package com.yodata.creditsupport.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.IndicatorEntity;
import com.yodata.creditsupport.orm.entity.UserEntity;
import com.yodata.creditsupport.orm.vo.Indicator;
import com.yodata.creditsupport.service.IndicatorService;
import com.yodata.creditsupport.util.QueryParam;
import com.yodata.creditsupport.util.StringRandom;
import com.yodata.creditsupport.util.Validator;

@Controller
@RequestMapping("/indicator")
public class IndicatorAction  extends BasicAction{

	private final Log log= LogFactory.getLog(IndicatorAction.class);
	
	@Resource
	private IndicatorService indicatorServiceImpl;
	
	/**
     * 查询
     * @param offset
     * @param limit
     * @return
	 * @throws UnsupportedEncodingException 
     */
    @RequestMapping(value="/query",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> query(@RequestParam(required=false) Integer offset,@RequestParam(required=false) Integer limit) throws UnsupportedEncodingException{
        Map<String, Object> object = new HashMap<String, Object>();
        //查询分页条件
        String indicatorCode = request.getParameter("indicatorCode");
        String indicatorName = request.getParameter("indicatorName");
        String level1 = request.getParameter("level1");
        if(indicatorCode != null) {
        	indicatorCode = URLDecoder.decode(indicatorCode, "UTF-8");
        }
        if(indicatorName != null) {
        	indicatorName = URLDecoder.decode(indicatorName, "UTF-8");
        }
        if(level1 != null) {
        	level1 = URLDecoder.decode(level1, "UTF-8");
        }
    	QueryParam queryParam = new QueryParam();
    	queryParam.setQueryCode(indicatorCode);
    	queryParam.setQueryName(indicatorName);
    	queryParam.setIndicatorCate(level1);
    	String sort = request.getParameter("sort");
    	String order = request.getParameter("order");
    	if(StringUtils.isNotEmpty(sort) && StringUtils.isNotEmpty(order)){
    		queryParam.setSortStr(sort + " " + order);
    	}
        queryParam.setOffset(offset==null?0:offset);
        queryParam.setLimit(limit==null?10:limit);
        try {
        	Map<String, Object> map = indicatorServiceImpl.getPageIndicators(queryParam);
        	if(map != null && !map.isEmpty()){
        		Integer count = (Integer) map.get("count");
        		List<Indicator> list = (List<Indicator>) map.get("data");
        		object.put("code", 0);
        		object.put("total", count);
        		object.put("rows", list);
        	} else {
        	    object.put("code", 0);
                object.put("total", 0);
                object.put("rows", null);
        	}
		} catch (Exception e) {
			e.printStackTrace();
			object.put("code", 0);
			object.put("message", "程序执行出错");
			log.error("程序执行出错", e);
		}
        return object;
    }
    
    
    /**
     * 保存指标信息
     * @param IndicatorEntity
     * @return
     */
    @RequestMapping(value="/update",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> updateIndicator(IndicatorEntity indicatorEntity){
    	Map<String, Object> obj = new HashMap<String, Object>();
    	if(indicatorEntity == null ){
    		obj.put("code", 1);
    		obj.put("message", "指标信息不能为空");
    	} else if(!Validator.isStrNumber(indicatorEntity.getIndCode())){
    		obj.put("code", 1);
    		obj.put("message", "指标编号为长度在1-20之间的英文字母、下划线、数字的组合");
    	} else if(!Validator.isFullName(indicatorEntity.getIndName())){
    		obj.put("code", 1);
    		obj.put("message", "指标名称为长度在1-20之间的中文和英文字母、下划线、点符号、数字的组合");
    	} else if(StringRandom.isBlank(indicatorEntity.getLevel1())){
    		obj.put("code", 1);
    		obj.put("message", "上级指标名称有误");
    	} else {
    		try {
    			// 校验指标编码是否已经存在
				IndicatorEntity codeEntity = indicatorServiceImpl
						.getIndicatorEntityByCode(indicatorEntity.getIndCode().trim());
				if(codeEntity != null && !codeEntity.getId().equals(indicatorEntity.getId())){
					obj.put("code", 2);
					obj.put("message", "指标编号已存在，请重新输入");
					return obj;
				}
				// 校验指标名称是否已经存在
				IndicatorEntity sameNameEntity = indicatorServiceImpl
						.getIndicatorEntityByName(indicatorEntity.getIndName().trim());
				
				if (sameNameEntity != null 
				        && !sameNameEntity.getId().equals(indicatorEntity.getId())) {
					obj.put("code", 2);
					obj.put("message", "指标名称已存在，请重新输入");
					return obj;
				}
				
				//保存指标的父级关系
				//所选指标为是否为1级指标
				String parentName = indicatorEntity.getLevel1().trim();
				IndicatorEntity parent = indicatorServiceImpl
                        .getIndicatorEntityByName(parentName);
				if(parent == null || parent.getId() == null){
				    obj.put("code", 2);
                    obj.put("message", "上级指标不存在，请重新选择");
                    return obj;
				} else {
				    if(parent.getLevel1() != null){
				        indicatorEntity.setLevel1(parent.getLevel1());
				        if(!parent.getLevel1().equals(parentName)){
				            if(parent.getLevel2() != null){
	                            indicatorEntity.setLevel2(parent.getLevel2());
	                            if(!parent.getLevel2().equals(parentName)){
	                                if(parent.getLevel3() != null){
	                                    indicatorEntity.setLevel3(parent.getLevel3());
	                                    if(!parent.getLevel3().equals(parentName)){
	                                        if(parent.getLevel4() != null){
	                                            indicatorEntity.setLevel4(parent.getLevel4());
	                                            if(!parent.getLevel4().equals(parentName)){
	                                                if(parent.getLevel5() != null){
	                                                    indicatorEntity.setLevel5(parent.getLevel5());
	                                                    if(!parent.getLevel5().equals(parentName)){
	                                                        if(parent.getLevel6() != null){
	                                                            indicatorEntity.setLevel6(parent.getLevel6());
	                                                        } else {
	                                                            indicatorEntity.setLevel6(parent.getIndName());
	                                                        }
	                                                    }
	                                                } else {
	                                                    indicatorEntity.setLevel5(parent.getIndName());
	                                                } 
	                                            }
	                                        } else {
	                                            indicatorEntity.setLevel4(parent.getIndName());
	                                        }
	                                    }
	                                } else {
	                                    indicatorEntity.setLevel3(parent.getIndName());
	                                }
	                            }
	                        } else {
	                            indicatorEntity.setLevel2(parent.getIndName());
	                        }
				        }
				    } else {
				        obj.put("code", 2);
	                    obj.put("message", "指标大类不可新增");
	                    return obj;
				    }
				}
				
				//设置初始值
				indicatorEntity.setAvailable(1);
				indicatorEntity.setCreateTime(new Date());
				UserEntity loaduser = (UserEntity) request.getSession().getAttribute("sessionUser");
				indicatorEntity.setCreateUser(loaduser.getUserName());
				indicatorEntity.setStartDate(new Date());
				indicatorEntity.setEndDate(DateUtils.parseDate("2099-12-31", "yyyy-MM-dd"));
    			
    			indicatorServiceImpl.saveOrUpdateEntity(indicatorEntity);
    			
    			obj.put("code", 0);
    			obj.put("message", "保存成功");
    		} catch (Exception e){
    			e.printStackTrace();
    			obj.put("code", 1);
    			obj.put("message", "保存失败");
    			log.error(">>>>>保存失败");
    		}
    	}
    	return obj;
    }
    
    
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value="/delete",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> deleteIndicator(@RequestParam(required=true) Integer id){
    	Map<String, Object> obj = new HashMap<String, Object>();
    	if(id == null || id == 0){
    		obj.put("code", 1);
    		obj.put("message", "此记录不存在");
    	} else {
    		try {
    			IndicatorEntity entity = indicatorServiceImpl.getIndicatorEntityByID(id);
    			if(entity == null){
    				obj.put("code", 1);
    	    		obj.put("message", "此记录不存在");
    			} else {
    			    List<IndicatorEntity> children = indicatorServiceImpl.queryChildren(entity.getIndName());
    				if(children != null && !children.isEmpty()){
    				    obj.put("code", 2);
                        obj.put("message", "此指标下有其他指标，不可删除");
    				} else {
    				    indicatorServiceImpl.deleteEntity(id);
    				    obj.put("code", 0);
    				    obj.put("message", "删除成功");
    				}
    			}
    		} catch (BusinessException e){
    		    log.error(e.getMessage(), e);
                e.printStackTrace();
                obj.put("code", 1);
                obj.put("message", e.getMessage());
            } catch (Exception e){
                log.error(e.getMessage(), e);
    			e.printStackTrace();
    			obj.put("code", 1);
    			obj.put("message", ">>>>>>>删除失败");
    		}
    	}
    	return obj;
    }
    
    @RequestMapping(value="/queryIndicatorType",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Object> queryIndicatorType(){
    	List<Object> array = new ArrayList<>();
    	try {
	    	//查询一级类别列表
	    	List<String> list = indicatorServiceImpl.queryLevelIndicatorList();
	    	Map<String, Object> object = null;
	    	for(Object name : list){
	    	    object = new HashMap<String, Object>();
                object.put("id", name.toString().trim());
                object.put("indiName", name.toString().trim());
                array.add(object);
	    	}
    	} catch (Exception e) {
    	    log.error(e.getMessage());
			e.printStackTrace();
    	}
    	return array;
    }
    
    @RequestMapping(value="/indicatorTree",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> queryTree(@RequestParam(required = false) Integer id, @RequestParam(required = false) Integer level){
    	IndicatorEntity indicatorEntity = null;
    	Map<String, Object> obj = new HashMap<String, Object>();
    	List<Object> array = new ArrayList<>();
    	try {
	    	//此ID为页面传来的指标ID
    		if(id != null){
    		    indicatorEntity = indicatorServiceImpl.getIndicatorEntityByID(id);
			}
    	    
    	    //查询一级类别列表
            List<String> list = indicatorServiceImpl.queryLevelIndicatorList();
            Map<String, Object> object = null;
            for(Object name : list){
                object = new HashMap<String, Object>();
                object.put("id",name);
                object.put("pid","-1");
                object.put("name",name);
                array.add(object);
            }
            List<IndicatorEntity> level2List = indicatorServiceImpl.queryLevelIndicatorListByLevel("level2");
            List<IndicatorEntity> level3List = indicatorServiceImpl.queryLevelIndicatorListByLevel("level3");
            List<IndicatorEntity> level4List = indicatorServiceImpl.queryLevelIndicatorListByLevel("level4");
            List<IndicatorEntity> level5List = indicatorServiceImpl.queryLevelIndicatorListByLevel("level5");
            List<IndicatorEntity> level6List = indicatorServiceImpl.queryLevelIndicatorListByLevel("level6");
            List<IndicatorEntity> level7List = indicatorServiceImpl.queryLevelIndicatorListByLevel("level7");
            //指标本身
            boolean checked = setChildrenIndicator(level7List, array, 7, indicatorEntity, false);
            //选中的父级指标，页面只选中父级，不选中祖父级及更高级别
            checked = setChildrenIndicator(level6List, array, 6, indicatorEntity, checked);
            checked = setChildrenIndicator(level5List, array, 5, indicatorEntity, checked);
            checked = setChildrenIndicator(level4List, array, 4, indicatorEntity, checked);
            checked = setChildrenIndicator(level3List, array, 3, indicatorEntity, checked);
            checked = setChildrenIndicator(level2List, array, 2, indicatorEntity, checked);
            
            obj.put("treenodes", array);
    	} catch (Exception e) {
    	    log.error(e.getMessage());
			e.printStackTrace();
		}
    	return obj;
    }
    
    private boolean setChildrenIndicator(List<IndicatorEntity> levelList, List<Object> array, int level, IndicatorEntity entity, boolean checked) {
        if(levelList != null && levelList.size() > 0 
                && StringUtils.isNotEmpty(levelList.get(0).getLevel2())) {
            Map<String, Object> object = null;
            for(IndicatorEntity ie : levelList){
                object = new HashMap<String, Object>();
                object.put("id",ie.getLevel2());
                object.put("pid",ie.getLevel1());
                object.put("name",ie.getLevel2());
                //第七层级为最低层级，即为指标本身，不可选择
                if(level == 7){
                    object.put("nocheck", true);
                    array.add(object);
                    continue;
                }
                if(entity != null && !checked){
                    switch (level) {
                    case 2:
                        //被选中的父级节点
                        if(StringUtils.isNotEmpty(entity.getLevel2())
                                && entity.getLevel2().equals(ie.getLevel2())){
                            object.put("checked", true);
                            checked = true;
                        }
                        break;
                    case 3:
                        //被选中的父级节点
                        if(StringUtils.isNotEmpty(entity.getLevel3())
                                && entity.getLevel3().equals(ie.getLevel2())){
                            object.put("checked", true);
                            checked = true;
                        }
                        break;
                    case 4:
                      //被选中的父级节点
                        if(StringUtils.isNotEmpty(entity.getLevel4())
                                && entity.getLevel4().equals(ie.getLevel2())){
                            object.put("checked", true);
                            checked = true;
                        }
                        break;
                    case 5:
                      //被选中的父级节点
                        if(StringUtils.isNotEmpty(entity.getLevel5())
                                && entity.getLevel5().equals(ie.getLevel2())){
                            object.put("checked", true);
                            checked = true;
                        }
                        break;
                    case 6:
                      //第六层级
                        if(StringUtils.isNotEmpty(entity.getLevel6())
                                && entity.getLevel6().equals(ie.getLevel2())){
                            object.put("checked", true);
                            checked = true;
                        }
                        break;
                    default:
                        break;
                    }
                    //本身不能被选中
                    if(entity.getIndName().equals(ie.getLevel2())){
                        object.put("nocheck", true);
                    }
                }
                
                array.add(object);
            }
        }
        return checked;
    }

}
