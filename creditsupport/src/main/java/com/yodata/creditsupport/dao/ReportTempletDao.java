package com.yodata.creditsupport.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.ReportTempletEntity;
import com.yodata.creditsupport.orm.vo.ReportTitle;
import com.yodata.creditsupport.util.ConstantBean;
import com.yodata.creditsupport.util.QueryParam;

@Component
public class ReportTempletDao extends SimpleHibernateDao<ReportTempletEntity,java.lang.Integer> {

    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Autowired
    private ConstantBean constant;
    
	public Map<String, Object> getPageTemplet(QueryParam queryParam) throws DataAccessException {

		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(queryParam.getQueryCode())) {
			params.put("number", "%" + queryParam.getQueryCode().trim() + "%");
		}
		if (StringUtils.isNotBlank(queryParam.getQueryName())) {
			params.put("name", "%" + queryParam.getQueryName().trim() + "%");
		}

		// 查询总记录条数
		String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetPageReportTemplet() + constant.getSqlCount(), params);
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
		sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetPageReportTemplet(), params);
		query = session.createSQLQuery(sql);
		query.setFirstResult(queryParam.getOffset());
		query.setMaxResults(queryParam.getLimit());
		query.setResultTransformer(Transformers.aliasToBean(ReportTempletEntity.class));
		List<ReportTempletEntity> list = query.list();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("data", list);
		return map;
	}
	
	public void saveOrUpdateEntity(ReportTempletEntity reportTempletEntity) {
		this.getSession().saveOrUpdate(reportTempletEntity);
	}
	
	public ReportTempletEntity getReportTempletEntityByID(Integer id) {
		return this.get(id);
	}
	/**
	 * 查看该字段值是否存在
	 * @param fieldName	字段名称
	 * @param value		字段值
	 * @return
	 */
	public boolean isExist(String fieldName, String value, Integer id) {
		Criteria criteria = this.createCriteria(Restrictions.eq(fieldName, value));
		if(id != null) {
			criteria.add(Restrictions.ne("id", id));
		}
        return criteria.uniqueResult() != null;
	}
	
	/**
	 * 获取全部报告标题列表
	 * @return
	 * @throws DataAccessException
	 */
	public List<ReportTitle> getReportTitle() throws DataAccessException {
		String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getReportTitle());
        Query query = this.getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ReportTitle.class));
        @SuppressWarnings("unchecked")
		List<ReportTitle> totals = query.list();
        return totals;
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
