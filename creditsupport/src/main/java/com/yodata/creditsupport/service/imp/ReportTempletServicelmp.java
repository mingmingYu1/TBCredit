package com.yodata.creditsupport.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import com.alibaba.druid.support.json.JSONParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yodata.creditsupport.dao.ReportTempletDao;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.ReportTempletEntity;
import com.yodata.creditsupport.orm.vo.ReportTitle;
import com.yodata.creditsupport.orm.vo.ReportTitleVo;
import com.yodata.creditsupport.service.IReportTempletService;
import com.yodata.creditsupport.util.QueryParam;

@Service
@Transactional
public class ReportTempletServicelmp implements IReportTempletService {
    private final Log log = LogFactory.getLog(ReportTempletServicelmp.class);
    private final String hanzi[]={"零","一","二","三","四","五","六","七","八","九","十","十一","十二"};
	@Resource
    private ReportTempletDao reportTempletDao;
	
	@Override
    public void add(ReportTempletEntity entity){
		reportTempletDao.save(entity);
    }
	
    @Override
    public void delete(Integer id) {
    	reportTempletDao.delete(id);
    }

    @Override
    public void update(ReportTempletEntity entity) {
    	reportTempletDao.update(entity);
    }
    
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Map<String, Object> getPageTemplet(QueryParam queryParam) throws BusinessException {
    	try {
			return reportTempletDao.getPageTemplet(queryParam);
		} catch (DataAccessException e) {
			String error = "数据查询异常";
			log.error(error, e);
			throw new BusinessException(error);
		}
    }

	@Override
	public void saveOrUpdateEntity(ReportTempletEntity reportTempletEntity) throws BusinessException {
		try {
			Integer id = reportTempletEntity.getId();
			if(reportTempletDao.isExist("number", reportTempletEntity.getNumber(), id)) {
				throw new BusinessException("模板编号已存在");
			}
			if(reportTempletDao.isExist("name", reportTempletEntity.getName(), id)) {
				throw new BusinessException("模板名已存在");
			}
			List<ReportTitle> reportTitle = reportTempletDao.getReportTitle();
			Set<Integer> parentIds = new HashSet<>();
			Map<Integer, ReportTitle> rsData = new LinkedHashMap<>(reportTitle.size());
			
			JSONParser parser = new JSONParser(HtmlUtils.htmlUnescape(reportTempletEntity.getModuleList()));
			Map<String, Object> selected = parser.parseMap();
			Integer value;
			for(ReportTitle title : reportTitle) {
				value = (Integer) selected.get(title.getKeyName());
				if(value != null && value == 1) {
					title.setDisplay(true);
					rsData.put(title.getId(), title);
					parentIds.add(title.getParentId());
				} else {
					title.setDisplay(false);
					rsData.put(title.getId(), title);
				}
			}
			for(Integer parentId : parentIds) {
				setParentDisplay(parentId, rsData);
			}
			Map<String, String> items = new HashMap<>();
			Map<Integer, Integer> index = new HashMap<>();
			int parentId = -1;
			int curLevel = 0;
			int oldLevel = 0;
			Integer curLevelIndex;
			for(ReportTitle title : rsData.values()) {	//这里rsData里的标题列表还是按sort降序的
				if(title.isDisplay()) {
					curLevel = title.getLevel();
					curLevelIndex = index.get(curLevel);
					if(parentId == -1) {
						parentId = title.getParentId();	//初始化 parentId
						index.put(curLevel, 1);	//循环第一次执行时 此级别的索引从1开始
						oldLevel = curLevel;	//初始化之前的级别
					} else if(parentId != title.getParentId()) {
						parentId = title.getParentId();	//更新 parentId
						if(curLevelIndex == null) {
							index.put(curLevel, 1);	//新的级别索引从1开始
						} else {
							if(curLevel < oldLevel) {	//向外跳出
								index.put(curLevel, curLevelIndex + 1);	//当前级别的索引加1
							} else {	//向内下沉一级
								index.put(curLevel, 1);	//新的级别索引从1开始
							}
						}
						oldLevel = curLevel;	//更新之前的级别
					} else {
						index.put(curLevel, curLevelIndex + 1);	//当前级别的索引加1
					}
					items.put(title.getKeyName(), getTitleNum(index, curLevel) + title.getName());
				}
			}
			ObjectMapper json = new ObjectMapper();
			reportTempletEntity.setModuleList(json.writeValueAsString(items));
			reportTempletDao.saveOrUpdateEntity(reportTempletEntity);
		} catch (DataAccessException e) {
			String error = "查询报告列表异常";
			log.error(error, e);
			throw new BusinessException(error);
		} catch (JsonProcessingException e) {
			String error = "JSON转换异常";
			log.error(error, e);
			throw new BusinessException(error);
		}
	}
	
	/**
	 * 获取标题序号
	 * @param index
	 * @param curLevel
	 * @return
	 */
	private String getTitleNum(Map<Integer, Integer> index, Integer curLevel) {
		Integer curLevelIndex = index.get(curLevel);	//获取当前级别的索引值
		if(curLevel.intValue() == 1) {
			return hanzi[curLevelIndex] + "、";	//顶级的索引值要转换为简体中文
		}
		StringBuilder titleNum = new StringBuilder();
		for(int i=1; i<curLevel; i++) {
			titleNum.append(index.get(i) + ".");
		}
		titleNum.append(curLevelIndex + "、");
		return titleNum.toString();
	}
	/**
	 * 设置上级标题为显示状态
	 * @param id
	 * @param rsData
	 */
	private void setParentDisplay(Integer id, Map<Integer, ReportTitle> rsData) {
		ReportTitle parentTitle = rsData.get(id);
		if(parentTitle != null) {
			parentTitle.setDisplay(true);
			id = parentTitle.getParentId();
			if(id.intValue() > 0) {
				setParentDisplay(id, rsData);
			}
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public ReportTempletEntity getReportTempletEntityByID(Integer id) {
		 return reportTempletDao.getReportTempletEntityByID(id);
	}
    
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<ReportTitleVo> getAllTempletTitle() throws BusinessException {
		try {
			List<ReportTitle> reportTitle = reportTempletDao.getReportTitle();
			return buildHierarchical(reportTitle, new HashMap<Integer, List<ReportTitle>>(), true);
		} catch (DataAccessException e) {
			log.error("查询报告列表失败", e);
			throw new BusinessException();
		}
	}
	
	/**
	 * 构建报告标题的层级结构
	 * @param reportTitle
	 * @param map
	 * @param isTop
	 * @return
	 */
	private List<ReportTitleVo> buildHierarchical(List<ReportTitle> reportTitle, Map<Integer, List<ReportTitle>> map, boolean isTop) {
		List<ReportTitle> child = new ArrayList<>();
		List<ReportTitleVo> rs = new ArrayList<>();
		for(ReportTitle title : reportTitle) {
			if(isTop) {
				if(title.getParentId() == 0) {
					child.add(title);
					continue;
				}
				List<ReportTitle> group = map.get(title.getParentId());
                if(group == null) {     // 创建一个分组，并添加进组容器map中
                    group = new ArrayList<ReportTitle>();
                    group.add(title);
                    map.put(title.getParentId(), group);
                } else {
                    group.add(title);
                }
			} else {
				child.add(title);
			}
		}
		ReportTitleVo rtv;
		for(ReportTitle t : child) {
			rtv = new ReportTitleVo();
			rtv.setKey(t.getKeyName());
			rtv.setName(t.getRemark() + "、" + t.getName());
			for(Integer id : map.keySet()) {
				if(id.equals(t.getId())) {
					List<ReportTitleVo> c = buildHierarchical(map.remove(id), map, false);
					rtv.setChildren(c);
					break;
				}
			}
			rs.add(rtv);
		}
		return rs;
	}
}
