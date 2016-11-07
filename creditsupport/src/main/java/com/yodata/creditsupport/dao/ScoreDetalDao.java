package com.yodata.creditsupport.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.AgentInfoEntity;
import com.yodata.creditsupport.orm.vo.GrossProfit;
import com.yodata.creditsupport.util.ConstantBean;

@Component
public class ScoreDetalDao extends SimpleHibernateDao<AgentInfoEntity,java.lang.Integer> {
	
    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Autowired
    private ConstantBean constant;
    /**
     * 根据企业编号，查询注册资金历史记录和增长率
     * @param regId
     * @param minDate
     * @param maxDate
     * @return
     * @throws DataAccessException
     */
	public List<GrossProfit> getCapitalGrowthList(String regId, String minDate, String maxDate) throws DataAccessException {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("regId", regId);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetCapitalGrowthList(), params);
        Query query = this.getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(GrossProfit.class));

        return query.list();
    }
	
	/**
	 * 查询企业 毛利额-增长率
	 * @param regId		企业ID
	 * @param kpicode	指标编码
	 * @param minDate	开始日期（包括）
	 * @param maxDate	结束日期（不包括）
	 * @return
	 * @throws DataAccessException
	 */
	public List<GrossProfit> getGrossProfit(String regId, String kpicode, String minDate, String maxDate) throws DataAccessException {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("regId", regId);
        params.put("kpicode", kpicode);
        params.put("minDate", minDate);
        params.put("maxDate", maxDate);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetGrossProfit(), params);
        Query query = this.getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(GrossProfit.class));

        return query.list();
	}
	
	/**
	 * 查询企业的月退废票
	 * @param regId		企业ID
	 * @param kpicode	指标编码
	 * @param minDate	开始日期（包括）
	 * @param maxDate	结束日期（不包括）
	 * @return
	 * @throws DataAccessException
	 */
	public List<GrossProfit> getRetirementTicketMonth(String regId, String kpicode, String minDate, String maxDate) throws DataAccessException {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("regId", regId);
        params.put("kpicode", kpicode);
        params.put("minDate", minDate);
        params.put("maxDate", maxDate);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetRetirementTicketMonth(), params);
        Query query = this.getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(GrossProfit.class));

        return query.list();
	}
	
	/**
	 * 查询企业的天退废票
	 * @param regId		企业ID
	 * @param kpicode	指标编码
	 * @param minDate	开始日期（包括）
	 * @param maxDate	结束日期（不包括）
	 * @return
	 * @throws DataAccessException
	 */
	public List<GrossProfit> getRetirementTicketDay(String regId, String kpicode, String minDate, String maxDate) throws DataAccessException {
        
	    Map<String, Object> params = new HashMap<String, Object>();
        params.put("regId", regId);
        params.put("kpicode", kpicode);
        params.put("minDate", minDate);
        params.put("maxDate", maxDate);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetRetirementTicketDay(), params);
        Query query = this.getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(GrossProfit.class));

        return query.list();
	}
}
