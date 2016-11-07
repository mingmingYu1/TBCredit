package com.yodata.creditsupport.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.ParameterMode;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.AgentAliLoanbreakEntity;
import com.yodata.creditsupport.orm.entity.AgentChangeEntity;
import com.yodata.creditsupport.orm.entity.AgentCourEnforcementEntity;
import com.yodata.creditsupport.orm.entity.AgentFiliationEntity;
import com.yodata.creditsupport.orm.entity.AgentInfoEntity;
import com.yodata.creditsupport.orm.entity.AgentJudgementDocumentEntity;
import com.yodata.creditsupport.orm.entity.AgentLiquidationEntity;
import com.yodata.creditsupport.orm.entity.AgentMortgageEntity;
import com.yodata.creditsupport.orm.entity.AgentSharesFroEntity;
import com.yodata.creditsupport.orm.entity.AgentSharesImpawnEntity;
import com.yodata.creditsupport.orm.entity.AgentTaxAccountEntity;
import com.yodata.creditsupport.orm.entity.AgentTopLeaderExecuteDocEntity;
import com.yodata.creditsupport.orm.entity.AgentTopLeaderJudgementDocumentEntity;
import com.yodata.creditsupport.orm.entity.AgentTopleaderCourExposureEntity;
import com.yodata.creditsupport.orm.entity.AgentTopleaderDishonourNoticEntity;
import com.yodata.creditsupport.orm.entity.AgentTopleaderNetloanEntity;
import com.yodata.creditsupport.orm.entity.CrawlerAgentInfoEntity;
import com.yodata.creditsupport.orm.entity.EntAttrInfoEntity;
import com.yodata.creditsupport.orm.entity.LegPerInfoEntity;
import com.yodata.creditsupport.orm.entity.MerchantTradeReportAbormal;
import com.yodata.creditsupport.orm.entity.MerchantTrandeReportArea;
import com.yodata.creditsupport.orm.entity.MerchantTrandeReportBase;
import com.yodata.creditsupport.orm.entity.MerchantTrandeReportChange;
import com.yodata.creditsupport.orm.entity.MerchantTrandeReportConstrast;
import com.yodata.creditsupport.orm.entity.MerchantTrandeReportLoyalty;
import com.yodata.creditsupport.orm.entity.MerchantTrandeReportStability;
import com.yodata.creditsupport.orm.entity.MortgageItemEntity;
import com.yodata.creditsupport.orm.entity.OdsBalanceSheetEntity;
import com.yodata.creditsupport.orm.entity.OdsLegPerEquityEntity;
import com.yodata.creditsupport.orm.entity.OdsProfitEntity;
import com.yodata.creditsupport.orm.entity.OthEntInvestsInfoEntity;
import com.yodata.creditsupport.orm.entity.ScoreLevelEntity;
import com.yodata.creditsupport.orm.entity.ScoreLevelVersionEntity;
import com.yodata.creditsupport.orm.entity.SpecialInfoEntity;
import com.yodata.creditsupport.orm.entity.StockholderInfoEntity;
import com.yodata.creditsupport.orm.entity.TopManagerInfoEntity;
import com.yodata.creditsupport.util.ConstantBean;
import com.yodata.creditsupport.util.QueryParam;

@Component
public class CompanyDao extends SimpleHibernateDao<AgentInfoEntity, String> {

    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Autowired
    private ScoreLevelVersionDao scoreLevelVersionDao;
    @Autowired
    private ScoreLevelDao scoreLevelDao;
    @Autowired
    private ConstantBean constant;
    
    public Map<String, Object> getPageCompanys(QueryParam queryParam) throws DataAccessException {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("regId", StringUtils.isEmpty(queryParam.getQueryCode()) ? null : queryParam.getQueryCode());
        params.put("compName", StringUtils.isEmpty(queryParam.getQueryName()) ? null : queryParam.getQueryName());
        params.put("lpName", StringUtils.isEmpty(queryParam.getLpname()) ? null : queryParam.getLpname());
        params.put("status", StringUtils.isEmpty(queryParam.getStatus()) ? null : queryParam.getStatus());
		String countSql = dynamicHibernateSqlDao.getNamedQuerySql((constant.getSqlGetPageCompanys() + constant.getSqlCount()), params);
		int count = 0;
        Session session = this.getSession();
        Query query = session.createSQLQuery(countSql);
        List<Map<String, Object>> totals = query.list();
        count = totals != null ? totals.size() : 0;
		params.put("sortStr", StringUtils.isEmpty(queryParam.getSortStr()) ? null : queryParam.getSortStr());
		String dataSql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetPageCompanys(), params);
        query = session.createSQLQuery(dataSql);
        query.setFirstResult(queryParam.getOffset());
        query.setMaxResults(queryParam.getLimit());
        query.setResultTransformer(Transformers.aliasToBean(AgentInfoEntity.class));
        List<AgentInfoEntity> list = query.list();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("data", list);
		return map;
	}
    
    public AgentInfoEntity getCompanyById(String regId) throws DataAccessException {
    	Map<String, Object> params = new HashMap<>();
        params.put("regId", regId);
    	String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetOneCompany(), params);
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(AgentInfoEntity.class));
		return (AgentInfoEntity) query.uniqueResult();
    }

	@SuppressWarnings("unchecked")
	public ArrayList<CrawlerAgentInfoEntity> findAgentBygroupId(Integer parameter) throws DataAccessException {
	    Map<String, Object> params = new HashMap<String, Object>();
        params.put("group_id", parameter);
        String countSql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlFindAgentBygroupId(), params);
        Query query = this.getSession().createSQLQuery(countSql);
        List<Object> list = query.list();
        ArrayList<CrawlerAgentInfoEntity> aList = new ArrayList<CrawlerAgentInfoEntity>();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object[] objs = (Object[]) list.get(i);
                CrawlerAgentInfoEntity ag = new CrawlerAgentInfoEntity();
                ag.setInfoId((Integer) objs[0]);
                ag.setInfoName(objs[1].toString());
                ag.setInfocreditcode(objs[2].toString());
                aList.add(ag);
            }
        }
        return aList;
	}

	public Map<String, Object> getEnableScore() {
	    List<ScoreLevelVersionEntity> listV = scoreLevelVersionDao.findBy("status", 1);
		if(listV == null || listV.size() <= 0) {
			return null;
		}
		ScoreLevelVersionEntity scoreLevelVersionEntity = listV.get(0);
		List<ScoreLevelEntity> list = scoreLevelDao.findBy("levelVersion", scoreLevelVersionEntity.getId());
		Map<String, Object> rs = new HashMap<>();
		rs.put("list", list);
		rs.put("version", scoreLevelVersionEntity.getVersion());
		return rs;
	}

	public Map<String, Object> queryScoreLevel() {
	    List<ScoreLevelVersionEntity> listV = scoreLevelVersionDao.findBy("status", 1);
        if(listV == null || listV.size() <= 0) {
            return null;
        }
        ScoreLevelVersionEntity scoreLevelVersionEntity = listV.get(0);
        List<ScoreLevelEntity> list = scoreLevelDao.findBy("levelVersion", scoreLevelVersionEntity.getId());
		List<Object> lisc = new ArrayList<>();  
		for (ScoreLevelEntity sc : list) {
        	lisc.add(sc.getLevelName()+" ("+sc.getLevelDesc()+") "+sc.getLevelScoreMin()+"-"+sc.getLevelScoreMax()+"  "+sc.getRemark());
		}
		Map<String, Object> map = new HashMap<>();
		map.put("rows", lisc);
		return map;
	}
	
	public Map<String, Object> getAgentInfo(String regId) {
	    List<AgentInfoEntity> list = findBy("id", regId);
	    if(list != null && !list.isEmpty()) {
            AgentInfoEntity agentInfoEntity = list.get(0);
            Map<String, Object> map = new HashMap<>();
            map.put("reg_id", agentInfoEntity.getRegId());
            map.put("comp_name", agentInfoEntity.getCompName());
            return map;
        }else{
            return null;
        }
	}
	
	
	/**
     * 查询当前高管记录
     * @param regId
     * @return
     * @throws DataAccessException 
     */
    public List<TopManagerInfoEntity> getTopManagerInfo(String regId) throws DataAccessException {
        String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetTopManagerInfo());
        List<TopManagerInfoEntity> list = createQuery(hql, regId).list();
        return list;
    }
    
    /**
     * 查询当前对外股权投资记录
     * @param regId
     * @return
     * @throws DataAccessException 
     */
    public List<OthEntInvestsInfoEntity> getOthEntInvestsInfo(String regId) throws DataAccessException {
        String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetOthEntInvestsInfo());
        List<OthEntInvestsInfoEntity> list = createQuery(hql, regId).list();
        return list;
    }
    
    /**
     * 查询当前企业联系地址记录
     * @param id
     * @return
     * @throws DataAccessException 
     */
    public List<EntAttrInfoEntity> getEntAttrInfo(String id) throws DataAccessException {
        Map<String, Object> params = new HashMap<>();
        params.put("regId", id);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetEntAttrInfo(),params);
        Session session = this.getSession();
        Query query = session.createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(EntAttrInfoEntity.class));
        return query.list();
    }
    
    /**
     * 查询当前法院记录
     * @param regId
     * @return
     * @throws DataAccessException 
     */
    public List<SpecialInfoEntity> getSpecialInfo(String regId) throws DataAccessException {
        Map<String, Object> params = new HashMap<>();
        params.put("regId", regId);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetSpecialInfo(),params);
        Session session = this.getSession();
        Query query = session.createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(SpecialInfoEntity.class));
        return query.list();
    }
    
    /**
     * 查询当前法人记录
     * @param id
     * @param type
     * @return
     * @throws DataAccessException 
     */
    public List<LegPerInfoEntity> getLegPerInfo(String id, Integer type) throws DataAccessException {
        Map<String, Object> params = new HashMap<>();
        params.put("regId", id);
        if(type != null) params.put("type", type);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetLegPerInfo(), params);
        Session session = this.getSession();
        Query query = session.createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(LegPerInfoEntity.class));
        return query.list();
    }
    
    /**
     * 根据法人在其他机构任职信息
     * @param fileNo 企业编号
     * @return       当前股东记录
     * @throws DataAccessException 
     */
	public List<LegPerInfoEntity> getLegPerNewInfo(String regId) throws DataAccessException {
	    Map<String, Object> params = new HashMap<>();
		params.put("regId", regId);
		String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlLegPerNewInfo(), params);
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(LegPerInfoEntity.class));
		return query.list();
	}
	
	/**
	 * 法人代表投资信息
	 * @param id
	 * @return
	 * @throws DataAccessException 
	 */
	public List<OdsLegPerEquityEntity> getLegPerQuityInfo(String id) throws DataAccessException {
	    Map<String, Object> params = new HashMap<>();
		params.put("regId", id);
		String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getLegPerQuityInfo(), params);
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(OdsLegPerEquityEntity.class));
		return query.list();
	}
    
    /**
     * 根据企业编号查询当前股东记录
     * @param fileNo 企业编号
     * @return       当前股东记录
     * @throws DataAccessException 
     */
    public List<StockholderInfoEntity> getStockholderInfo(String regId) throws DataAccessException {
        Map<String, Object> params = new HashMap<>();
        params.put("regId", regId);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetStockholderInfo(), params);
        Session session = this.getSession();
        Query query = session.createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(StockholderInfoEntity.class));
        return query.list();
    }
    
    /**
     * 查询当前企业变更信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
    public List<AgentChangeEntity> getAgentChangeInfo(String regId) throws DataAccessException {
        String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentChangeInfo());
        List<AgentChangeEntity> list = createQuery(hql, regId).list();
        /*if(list.size() == 0)
        {
        	list.add((AgentChangeEntity)NullObjectUtil.getNullObject(new AgentChangeEntity()));
        }*/
        return list;
    }

    /**
     * 查询分支机构信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentFiliationEntity> getAgentFliliationInfo(String id) throws DataAccessException 
	{
		// TODO Auto-generated method stub
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentFiliationInfo());
        List<AgentFiliationEntity> list = createQuery(hql, id).list();
        return list;
	}

	 /**
     * 查询清算信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentLiquidationEntity> getAgentLiquidationInfo(String regId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentLiquidationInfo());
        List<AgentLiquidationEntity> list = createQuery(hql, regId).list();
        return list;
	}

	/**
     * 查询动产抵押信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentMortgageEntity> getAgentMortgageInfo(String regId) throws DataAccessException
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentMortgageInfo());
        List<AgentMortgageEntity> list = createQuery(hql, regId).list();
        return list;
	}

	/**
     * 查询动产抵押物信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<MortgageItemEntity> getMortgageItemInfo(String regId) throws DataAccessException {
		 Map<String, Object> params = new HashMap<>();
	        params.put("regId", regId);
	        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlMortgageItemInfo(),params);
	        Session session = this.getSession();
	        Query query = session.createSQLQuery(sql);
	        query.setResultTransformer(Transformers.aliasToBean(MortgageItemEntity.class));
	        return query.list();
	}

	/**
     * 查询股权冻结信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentSharesFroEntity> getAgentSharesInfo(String regId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentSharesInfo());
        List<AgentSharesFroEntity> list = createQuery(hql, regId).list();
        return list;
	}

	/**
     * 查询股权出质历史信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentSharesImpawnEntity> getAgentSharesImpawInfo(String regId) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentSharesImpawInfo());
        List<AgentSharesImpawnEntity> list = createQuery(hql, regId).list();
        return list;
	}

	/**
     * 查询违法违规裁判文书信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentJudgementDocumentEntity> getAgentJudgeMentDocInfo(String regId) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentJudgementDocInfo());
        List<AgentJudgementDocumentEntity> list = createQuery(hql, regId).list();
        return list;
	}

	/**
     * 查询违法违规执行公告信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentCourEnforcementEntity> getAgentCoutEnforceInfo(String regId) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentCoutEnforceInfo());
        List<AgentCourEnforcementEntity> list = createQuery(hql, regId).list();
        return list;
	}

	/**
     * 查询法定代表人失信执行公告信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentTopLeaderExecuteDocEntity> getAgentTopLeaderExdocInfo(String regId,String userType) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentTopLeaderExdocInfo());
        List<AgentTopLeaderExecuteDocEntity> list = createQuery(hql, regId,userType).list();
        return list;
	}
	
	/**
     * 查询法定代表人失信公告信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentTopleaderDishonourNoticEntity> getAgentTopLeaderDishonourInfo(String regId,String userType) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentTopLeaderDishonourInfo());
        List<AgentTopleaderDishonourNoticEntity> list = createQuery(hql, regId,userType).list();
        return list;
	}

	/**
     * 查询法定代表人失信网贷黑名单
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentTopleaderNetloanEntity> getAgentTopLeaderNetLoanInfo(String regId,String userType) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentTopLeaderNetloadInfo());
        List<AgentTopleaderNetloanEntity> list = createQuery(hql, regId,userType).list();
        return list;
	}
	
	/**
     * 查询法定代表人失信曝光台
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentTopleaderCourExposureEntity> getAgentTopLeaderCourtExposInfo(String regId,String userType) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentTopLeaderCourtExposInfo());
        List<AgentTopleaderCourExposureEntity> list = createQuery(hql, regId,userType).list();
        return list;
	}

	/**
     * 查询阿里欠贷信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentAliLoanbreakEntity> getAgentAliloadBreakInfo(String regId) throws DataAccessException {
		// TODO Auto-generated method stub
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentAliloadBreakInfo());
        List<AgentAliLoanbreakEntity> list = createQuery(hql, regId).list();
        return list;
	}

	/**
     * 查询核心经营信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<MerchantTrandeReportBase> getAgentMerchantTradeInfo(String regId) throws DataAccessException {
		// TODO Auto-generated method stub
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlMerchantTradeInfo());
        List<MerchantTrandeReportBase> list = createQuery(hql, regId).list();
        return list;
	}

	/**
     * 查询经营稳定性信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<MerchantTrandeReportStability> getAgentMerchantStabilityInfo(String regId) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlMerchantStabilityInfo());
        List<MerchantTrandeReportStability> list = createQuery(hql, regId).list();
        return list;
	}

	/**
     * 经营变化趋势
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<MerchantTrandeReportChange> getMerchantTrandeReportChangeInfo(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlMerchantReportChangeInfo());
        List<MerchantTrandeReportChange> list = createQuery(hql, id).list();
        return list;
	}

	/**
     * 税务信息
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentTaxAccountEntity> getAgentTaxAccoutInfo(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlAgentTaxAccountInfo());
        List<AgentTaxAccountEntity> list = createQuery(hql, id).list();
        return list;
	}

	/**
     * 客户地域分布
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<MerchantTrandeReportArea> getMerchantTrandeReportAreaInfo(String regId) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlMerchantReportAreaInfo());
        List<MerchantTrandeReportArea> list = createQuery(hql, regId).list();
        return list;
	}

	/**
     * 本市同行对比
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<MerchantTrandeReportConstrast> getMerchantTrandeReportConstrastInfo(String regId) throws DataAccessException {
		// TODO Auto-generated method stub
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlMerchantReportConstrastInfo());
        List<MerchantTrandeReportConstrast> list = createQuery(hql, regId).list();
        return list;
	}

	/**
     * 客户忠诚度
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<MerchantTrandeReportLoyalty> getMerchantTrandeReportLoyalInfo(String regId) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getMerchantReportLoyalInfo());
        List<MerchantTrandeReportLoyalty> list = createQuery(hql, regId).list();
        return list;
	}

	/**
     * 法定代表人失信裁判文书
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<AgentTopLeaderJudgementDocumentEntity> getAgentTopLeaderJudgmentDocInfo(String id,String userType) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getAgentTopleaderJudgmentDocInfo());
        List<AgentTopLeaderJudgementDocumentEntity> list = createQuery(hql, id,userType).list();
        return list;
	}

	/**
     * 月异常交易
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<MerchantTradeReportAbormal> getAgentMerchantAbormalInfo(String id) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getMerchantTradeAbomalInfo());
        List<MerchantTradeReportAbormal> list = createQuery(hql, id).list();
        return list;
	}

	/**
     * 资产负债
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<OdsBalanceSheetEntity> getBalanceSheetInfo(String regId) throws DataAccessException {
		Map<String, Object> params = new HashMap<>();
        params.put("regId", regId);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getBalanceSheetInfo(),params);
        Session session = this.getSession();
        Query query = session.createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(OdsBalanceSheetEntity.class));
        return query.list();
	}

	/**
     * 利润表
     * @param regId
     * @return
     * @throws DataAccessException 
     */
	public List<OdsProfitEntity> getProfitInfo(String id) throws DataAccessException {
		Map<String, Object> params = new HashMap<>();
        params.put("regId", id);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getProfitInfo(),params);
        Session session = this.getSession();
        Query query = session.createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(OdsProfitEntity.class));
        return query.list();
	}

	/**
	 * 根据企业名称和企业ID，调用存储过程，计算企业的Delphi的信用得分
	 * @param regId
	 * @param compName
	 * @throws DataAccessException
	 */
    public void getScoreingByRegId(String regId, String compName) throws DataAccessException {
        ProcedureCall procedure = this.getSession().createStoredProcedureCall("sp_web_enterprise_index_delphi_et");
        try {
            procedure.registerParameter("v_et_name", String.class, ParameterMode.IN).bindValue(compName);
            procedure.registerParameter("v_et_regno", String.class, ParameterMode.IN).bindValue(regId);
            procedure.getOutputs();
        } catch (Exception e) {
            throw new DataAccessException("存储过程执行失败");
        }
    }

    /**
     * 删除企业后删除企业的信用得分
     * @param regId
     * @throws DataAccessException  数据操作异常
     */
    public boolean deleteCompScoreByRegId(String regId) throws DataAccessException {
       Map<String, Object> params = new HashMap<>();
        params.put("regId", regId);
        try {
            String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlDeleteCompScore(),params);
            int num = this.getSession().createSQLQuery(sql).executeUpdate();
            return num >= 0;
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        }
    }

	
}
