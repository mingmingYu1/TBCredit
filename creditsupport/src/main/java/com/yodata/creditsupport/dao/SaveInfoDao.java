package com.yodata.creditsupport.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.ReportTempletEntity;
import com.yodata.creditsupport.orm.entity.SaveInfoEntity;
import com.yodata.creditsupport.orm.vo.ReportTitle;
import com.yodata.creditsupport.util.ConstantBean;
import com.yodata.creditsupport.util.QueryParam;

@Repository
@SuppressWarnings("unchecked")
public class SaveInfoDao extends SimpleHibernateDao<SaveInfoEntity,java.lang.Integer>{

    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Autowired
    private ConstantBean constant;
    
    /**
     * 查询一页征信报告记录
     * @param queryParam
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public Map<String, Object> getPageReport(QueryParam queryParam, String regId) throws DataAccessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("regId", regId);
		if (StringUtils.isNotBlank(queryParam.getQueryName())) {
			params.put("fileNo", "%" + queryParam.getQueryName().trim() + "%");
		}
		// 查询总记录条数
		String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetPageReport() + constant.getSqlCount(), params);
		Integer count = 0;
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		List<BigInteger> totals = query.list();
		if(totals != null && !totals.isEmpty()) {
		    count = totals.get(0).intValue();
		}
		// 查询分页记录
		if (StringUtils.isNotBlank(queryParam.getSortStr())) {
		    params.put("order", camelToUnderline(queryParam.getSortStr()));
		}
		sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetPageReport(), params);
		query = session.createSQLQuery(sql);
		query.setFirstResult(queryParam.getOffset());
		query.setMaxResults(queryParam.getLimit());
		query.setResultTransformer(Transformers.aliasToBean(SaveInfoEntity.class));
		List<SaveInfoEntity> list = query.list();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 查询所有的征信报告模板信息
	 * @return
	 * @throws DataAccessException 
	 */
	public List<ReportTempletEntity> getAllReportTemp() throws DataAccessException {
		String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetAllReportTemp());
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(ReportTempletEntity.class));
		List<ReportTempletEntity> list = query.list();
		return list;
	}
	
	/**
	 * 根据征信报告模板编号查询一条记录
	 * @param templetId
	 * @param isCreate
	 * @return
	 * @throws DataAccessException 
	 */
	public ReportTempletEntity getTempletById(Integer templetId, boolean isCreate) throws DataAccessException {
	    Map<String, Object> params = new HashMap<String, Object>();
        params.put("templetId", templetId);
        
	    String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetTempletById(), params);
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(ReportTempletEntity.class));
		List<ReportTempletEntity> list = query.list();
		if(list == null || list.size() <= 0) {
			return null;
		}
		ReportTempletEntity rte = list.get(0);
		if(isCreate && rte.getStatus() == 1) {
		    sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlUpdateTempletStatus(), params);
			query = session.createSQLQuery(sql);
			query.executeUpdate();
		}
		return rte;
	}
	
	/**
	 * 获取全部报告标题列表
	 * @return
	 * @throws DataAccessException
	 */
	public List<ReportTitle> getReportTitle() throws DataAccessException {
		String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getReportTitle());
        Query query = this.getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ReportTitle.class));
		List<ReportTitle> totals = query.list();
        return totals;
	}
	
	/**
	 * 按规则生成该企业征信报告编号并新增一条记录，防止并发生成时编号重复问题
	 * @param regId
	 * @param date
	 * @return
	 * @throws DataAccessException 
	 */
	public SaveInfoEntity createMaxIndexReport(String regId, Date date) throws DataAccessException {
	    Map<String, Object> params = new HashMap<String, Object>();
        params.put("regId", regId);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlCreateMaxIndexReport(), params);
	    
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		List<String> list = query.list();
		String maxNo = "001";	// 每天的开始计数值
		String dateStr = new SimpleDateFormat("yyyyMMdd").format(date);
		if(list != null && list.size() > 0) {
			try {
				String[] dateAndNo = list.get(0).split("-");
				if(dateAndNo[0].equals(dateStr)) {
					Integer max = Integer.valueOf(dateAndNo[1]);
					maxNo = String.valueOf(++max);
					if(maxNo.length() == 1) {
						maxNo = "00" + maxNo;
					} else if(maxNo.length() == 2) {
						maxNo = "0" + maxNo;
					}
				}
			} catch (Exception e) {
				// 忽略异常使用默认值
			}
		}
		// 新增一条记录 获取主键值
		SaveInfoEntity saveInfo = new SaveInfoEntity();
		saveInfo.setRegId(regId);
		saveInfo.setFileNo(regId + "-" + dateStr + "-" + maxNo);
		saveInfo.setCreateTime(date);
		Serializable id = saveReturnPk(saveInfo);
		saveInfo.setId((Integer)id);
		return saveInfo;
	}
	
	/**
	 * 把驼峰命名的变量名改成下划线的形式
	 * @param param
	 * @return
	 */
	private String camelToUnderline(String param){  
       if (param==null||"".equals(param.trim())){  
           return "";  
       }  
       int len=param.length();  
       StringBuilder sb=new StringBuilder(len);  
       for (int i = 0; i < len; i++) {  
           char c=param.charAt(i);  
           if (Character.isUpperCase(c)){  
               sb.append('_');  
               sb.append(Character.toLowerCase(c));  
           }else{  
               sb.append(c);  
           }  
       }  
       return sb.toString();  
   }  
	
}
