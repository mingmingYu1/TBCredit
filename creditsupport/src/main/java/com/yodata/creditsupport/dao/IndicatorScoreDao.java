package com.yodata.creditsupport.dao;

import java.sql.SQLException;
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
import com.yodata.creditsupport.orm.entity.IndicatorEntity;
import com.yodata.creditsupport.orm.vo.IndicatorAttr;
import com.yodata.creditsupport.orm.vo.IndicatorScoreWeight;
import com.yodata.creditsupport.util.ConstantBean;

@Component
public class IndicatorScoreDao extends SimpleHibernateDao<IndicatorEntity, java.lang.Integer> {

    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Autowired
    private ConstantBean constant;
    
    /**
     * 根据算法类型查询企业各指标得分信息
     * @param regId
     * @param algorithmType
     * @return
     * @throws SQLException
     * @throws DataAccessException
     */
	public List<IndicatorScoreWeight> getIndicatorScoreList(String regId, String algorithmType) throws SQLException, DataAccessException {
	    Map<String, Object> params = new HashMap<String, Object>();
        params.put("regId", regId);
        params.put("algorithmType", algorithmType);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetIndicatorScoreList(), params);
	    Query query = this.getSession().createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(IndicatorScoreWeight.class));

	    return query.list();
	}
	
	/**
	 * 根据指标类型、算法类型查询企业各指标得分信息
	 * @param regId
	 * @param algorithmType
	 * @param indAttr
	 * @return
	 * @throws SQLException
	 * @throws DataAccessException
	 */
	public List<IndicatorScoreWeight> getIndicatorScoreListByAttr(String regId, String algorithmType, String indAttr) throws SQLException, DataAccessException {
	    Map<String, Object> params = new HashMap<String, Object>();
        params.put("indAttr", indAttr);
        params.put("regId", regId);
        params.put("algorithmType", algorithmType);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetIndicatorScoreListByAttr(), params);
	    Query query = this.getSession().createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(IndicatorScoreWeight.class));
	    return query.list();
	}
	
	/**
	 * 根据指标类型、算法类型查询企业各二级指标得分信息
	 * @param regId
	 * @param algorithmType
	 * @param indAttr
	 * @return
	 * @throws DataAccessException
	 */
	public List<IndicatorScoreWeight> getIndicatorScoreListLevel2ByAttr(String regId, String algorithmType, String indAttr) throws DataAccessException {
	    Map<String, Object> params = new HashMap<String, Object>();
        params.put("indAttr", indAttr);
        params.put("regId", regId);
        params.put("algorithmType", algorithmType);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetIndicatorScoreListLevel2ByAttr(), params);
        Query query = this.getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(IndicatorScoreWeight.class));

        return query.list();
    }
	
	/**
	 * 根据指标类型、算法类型查询企业各一级指标得分信息
	 * @param regId
	 * @param algorithmType
	 * @param indAttr
	 * @return
	 * @throws DataAccessException
	 */
    public List<IndicatorScoreWeight> getIndicatorScoreListLevel1ByAttr(String regId, String algorithmType, String indAttr) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("indAttr", indAttr);
        params.put("regId", regId);
        params.put("algorithmType", algorithmType);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetIndicatorScoreListLevel1ByAttr(), params);
        Query query = this.getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(IndicatorScoreWeight.class));

        return query.list();
    }

    /**
     * 根据算法类型查询企业总得分信息
     * @param regId
     * @param algorithmType
     * @return
     * @throws DataAccessException
     */
    public IndicatorScoreWeight getIndicatorScoreByTotal(String regId, String algorithmType) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("regId", regId);
        params.put("algorithmType", algorithmType);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetIndicatorScoreByTotal(), params);
        Query query = this.getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(IndicatorScoreWeight.class));

        List<IndicatorScoreWeight> list = query.list();
        IndicatorScoreWeight entity = null;
        if (list != null && !list.isEmpty()) {
            entity = list.get(0);
            entity.setIndicatorName("总分");
        }
        
        return entity;
    }

    /**
     * 根据算法类型查询企业各二级指标得分信息
     * @param regId
     * @param algorithmType
     * @return
     * @throws DataAccessException
     */
    public List<IndicatorScoreWeight> getIndicatorScoreListByLevel2(String regId, String algorithmType) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("regId", regId);
        params.put("algorithmType", algorithmType);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetIndicatorScoreListByLevel2(), params);
        Query query = this.getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(IndicatorScoreWeight.class));

        return query.list();
        
    }

    /**
     * 根据算法类型查询企业各一级指标得分信息
     * @param regId
     * @param algorithmType
     * @return
     * @throws DataAccessException
     */
    public List<IndicatorScoreWeight> getIndicatorScoreListByLevel1(String regId, String algorithmType) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("regId", regId);
        params.put("algorithmType", algorithmType);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetIndicatorScoreListByLevel1(), params);
        Query query = this.getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(IndicatorScoreWeight.class));

        return query.list();
    }

//    public List<CapitalGrowth> getCapitalGrowthList(String regId) {
//        String sql = "SELECT DISTINCT tra1.`year` year, tra1.agent_id regId, tra1.amount amount, "
//                + " IF(tra1.amount = 0,-1,(tra1.amount-IFNULL(tra2.amount,0))/tra1.amount) growth "
//                + " FROM tbods.reg_assets tra1 "
//                + " LEFT JOIN tbods.reg_assets tra2 "
//                + " ON tra1.agent_id = tra2.agent_id AND tra1.`year` = (tra2.`year` + 1) "
//                + " WHERE tra1.agent_id = :regId "
//                + " ORDER BY tra1.`year` DESC LIMIT 6 "; 
//        Query query = this.getSession().createSQLQuery(sql);
//        query.setParameter("regId", regId);
//        query.setResultTransformer(Transformers.aliasToBean(CapitalGrowth.class));
//        return query.list();
//    }

    /**
     * 查询企业各类指标信息
     * @param regId
     * @return
     * @throws DataAccessException
     */
    public IndicatorAttr getIndicatorAttrList(String regId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("regId", regId);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetIndicatorAttrList(), params);
        Query query = this.getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(IndicatorAttr.class));
        List<IndicatorAttr> list = query.list();
        return list == null || list.isEmpty() ? null : list.get(0);
    }

    /**
     * 查询企业最段时间征信得分信息
     * @param regId
     * @param algorithmType
     * @return
     * @throws DataAccessException
     */
    public List<Map<String, Object>> getCreditScore(String regId, String algorithmType) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("regId", regId);
        params.put("algorithmType", algorithmType);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetCreditScore(), params);
        Query query = this.getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        return query.list();
    }


}
