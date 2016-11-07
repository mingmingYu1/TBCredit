package com.yodata.creditsupport.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.AgentTopleaderDishonourNoticEntity;
import com.yodata.creditsupport.orm.entity.MerchantTradeReportAbormal;
import com.yodata.creditsupport.orm.entity.OdsLegPerEquityEntity;
import com.yodata.creditsupport.orm.entity.his.AgentAliLoanbreakHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentChangeHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentCourEnforcementHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentFiliationHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentInfoHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentJudgementDocumentHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentLiquidationHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentMortgageHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentSharesFroHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentSharesImpawnHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTaxAccountHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopLeaderExecuteDocHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopLeaderJudgementDocumentHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopleaderCourExposureHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopleaderDishonourNoticHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopleaderNetloanHisEntity;
import com.yodata.creditsupport.orm.entity.his.BasicIndiScoreHisEntity;
import com.yodata.creditsupport.orm.entity.his.EntAttrInfoHisEntity;
import com.yodata.creditsupport.orm.entity.his.LegPerInfoHisEntity;
import com.yodata.creditsupport.orm.entity.his.MerchantTradeReportAbormalHis;
import com.yodata.creditsupport.orm.entity.his.MerchantTrandeReportAreaHis;
import com.yodata.creditsupport.orm.entity.his.MerchantTrandeReportBaseHis;
import com.yodata.creditsupport.orm.entity.his.MerchantTrandeReportChangeHis;
import com.yodata.creditsupport.orm.entity.his.MerchantTrandeReportConstrastHis;
import com.yodata.creditsupport.orm.entity.his.MerchantTrandeReportLoyaltyHis;
import com.yodata.creditsupport.orm.entity.his.MerchantTrandeReportStabilityHis;
import com.yodata.creditsupport.orm.entity.his.MortgageItemHisEntity;
import com.yodata.creditsupport.orm.entity.his.OdsBalanceSheetHisEntity;
import com.yodata.creditsupport.orm.entity.his.OdsLegPerEquityHisEntity;
import com.yodata.creditsupport.orm.entity.his.OdsProfitHisEntity;
import com.yodata.creditsupport.orm.entity.his.OthEntInvestsInfoHisEntity;
import com.yodata.creditsupport.orm.entity.his.SpecialInfoHisEntity;
import com.yodata.creditsupport.orm.entity.his.StockholderInfoHisEntity;
import com.yodata.creditsupport.orm.entity.his.TopManagerInfoHisEntity;
import com.yodata.creditsupport.util.ConstantBean;

@Component
@SuppressWarnings("unchecked")
public class CompanyHisDao extends SimpleHibernateDao<AgentInfoHisEntity,java.lang.Integer> {
	
    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Autowired
    private ConstantBean constant;
    
    /**
     * 查询企业历史信息，即一张征信报告的数据
     * @param regId
     * @param fileNo
     * @return
     * @throws DataAccessException 
     */
	public AgentInfoHisEntity getAgentInfoHis(String regId, String fileNo) throws DataAccessException {
	    SimpleExpression param = Restrictions.eq("fileNo", fileNo);
	    Criteria criteria = this.createCriteria(Restrictions.conjunction()
                .add(Restrictions.eq("regId", regId))
                .add(param));
		List<AgentInfoHisEntity> list = (List<AgentInfoHisEntity>)criteria.list();
		if(list == null){
			return null;
		}
		AgentInfoHisEntity agent = list.get(0);
		agent.setEntAttrInfos(this.getEntAttrInfoHis(fileNo));
		
		criteria = this.getSession().createCriteria(TopManagerInfoHisEntity.class)
		        .add(param);
		agent.setTopManagerInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(OthEntInvestsInfoHisEntity.class)
                .add(param);
		agent.setOthEntInvestsInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(BasicIndiScoreHisEntity.class)
                .add(param);
		agent.setBasicIndiScore(criteria.list());
		
		criteria = this.getSession().createCriteria(AgentChangeHisEntity.class)
                .add(param);
		agent.setChangeInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(AgentFiliationHisEntity.class)
                .add(param);
		agent.setFiliationInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(AgentLiquidationHisEntity.class)
                .add(param);
		agent.setLiquidataInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(AgentMortgageHisEntity.class)
                .add(param);
		agent.setMortgageInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(MortgageItemHisEntity.class)
                .add(param);
		agent.setMortgageItemInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(AgentSharesFroHisEntity.class)
                .add(param);
		agent.setAgentSharesInfos(criteria.list());
		criteria = this.getSession().createCriteria(AgentSharesImpawnHisEntity.class)
                .add(param);
		agent.setAgentSharesImpawnInfos(criteria.list());
		criteria = this.getSession().createCriteria(AgentJudgementDocumentHisEntity.class)
                .add(param);
		agent.setAgentJudgedocInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(AgentCourEnforcementHisEntity.class)
                .add(param);
		agent.setAgentCoutEnforceInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(AgentTopLeaderExecuteDocHisEntity.class)
                .add(param);
		agent.setAgentTopleaderExdocInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(AgentTopleaderDishonourNoticHisEntity.class)
                .add(param);
		agent.setAgentTopleaderDishonourInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(AgentTopleaderNetloanHisEntity.class)
                .add(param);
		agent.setAgentTopleaderNetloadInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(AgentTopleaderCourExposureHisEntity.class)
                .add(param);
		agent.setAgentTopleaderCourtExposInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(AgentAliLoanbreakHisEntity.class)
                .add(param);
		agent.setAgentAliloadBreakInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(MerchantTrandeReportBaseHis.class)
                .add(param);
		agent.setMerchantTradeInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(MerchantTrandeReportStabilityHis.class)
                .add(param);
		agent.setMerchantStabilityInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(AgentTaxAccountHisEntity.class)
                .add(param);
		agent.setAgentTaxAccoutInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(MerchantTrandeReportChangeHis.class)
                .add(param);
		agent.setMerchantReportChangeInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(MerchantTrandeReportConstrastHis.class)
                .add(param);
		agent.setMerchantReportConstrastInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(MerchantTrandeReportAreaHis.class)
                .add(param);
		agent.setMerchantReportAreaInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(MerchantTrandeReportLoyaltyHis.class)
                .add(param);
		agent.setMerchantReportLoyalInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(AgentTopLeaderJudgementDocumentHisEntity.class)
                .add(param);
		agent.setAgentTopleaderJudgmentDocInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(MerchantTradeReportAbormalHis.class)
                .add(param);
		agent.setMerchantReportAbormalInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsBalanceSheetHisEntity.class)
                .add(param);
		agent.setOdsBalanceSheetInfos(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsProfitHisEntity.class)
                .add(param);
		agent.setOdsProfitInfos(criteria.list());
		
		agent.setCurTypeName(this.getCurTypeName(agent.getCurType()));
		return agent;
	}
	
	/**
     * 根据报告编号查询企业联系地址历史记录
     * @param fileNo 报告编号
     * @return       企业联系地址历史记录
	 * @throws DataAccessException 
     */
	private List<EntAttrInfoHisEntity> getEntAttrInfoHis(String fileNo) throws DataAccessException {
	    Map<String, Object> params = new HashMap<>();
        params.put("fileNo", fileNo);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetEntAttrInfoHis(), params);
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(EntAttrInfoHisEntity.class));
		return query.list();
	}
	
	/**
     * 根据报告编号查询法院历史记录
     * @param fileNo 报告编号
     * @return       法院历史记录
	 * @throws DataAccessException 
     */
	public List<SpecialInfoHisEntity> getSpecialInfoHis(String fileNo, Integer type) throws DataAccessException {
	    Map<String, Object> params = new HashMap<>();
        params.put("fileNo", fileNo);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetSpecialInfoHis(), params);
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(SpecialInfoHisEntity.class));
		return query.list();
	}
	/**
     * 根据报告编号查询法人历史记录
     * @param fileNo 报告编号
     * @return       法人历史记录
	 * @throws DataAccessException 
     */
	public List<LegPerInfoHisEntity> getLegPerInfoHis(String fileNo) throws DataAccessException{
	    Map<String, Object> params = new HashMap<>();
        params.put("fileNo", fileNo);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetLegPerInfoHis(), params);
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(LegPerInfoHisEntity.class));
		return query.list();
	}
	/**
	 * 根据报告编号查询股东历史记录
	 * @param fileNo 报告编号
	 * @return       股东历史记录
	 * @throws DataAccessException 
	 */
	public List<StockholderInfoHisEntity> getStockholderInfoHis(String fileNo) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
        params.put("fileNo", fileNo);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetStockholderInfoHis(), params);
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(StockholderInfoHisEntity.class));
		return query.list();
	}
	
	/**
	 * 根据报告编号查询资产负债历史记录
	 * @param fileNo 报告编号
	 * return
	 * @throws DataAccessException 
	 */
	public List<OdsBalanceSheetHisEntity> getBalanceHisInfoHis(String fileNo) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
        params.put("fileNo", fileNo);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getBalanceSheetInfoHis(), params);
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(StockholderInfoHisEntity.class));
		return query.list();
	}
	
	/**
	 * 获取企业注册资金的币种名称
	 * @param curType	币种英文表示
	 * @return			币种中文名称
	 * @throws DataAccessException 
	 */
	public String getCurTypeName(String curType) throws DataAccessException {
		if(curType == null || curType.equals("")) return "";
	    Map<String, Object> params = new HashMap<>();
        params.put("curType", curType);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetCurTypeName(), params);
		Query query = this.getSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> rs = query.list();
		if(rs != null && rs.size() > 0) {
			try {
				Map<String, Object> map = rs.get(0);
				curType = (String) map.get("NAME");
				
			} catch (Exception e) {
			}
		}
		return curType;
	}

	/**
	 * 裁判文书（报告历史查询）
	 * @param fileNo    //文件编号
	 * @param userType  //用户类型：法人代表、控股股东
	 * @return
	 * @throws DataAccessException 
	 */
	public List<AgentTopLeaderJudgementDocumentHisEntity> getJudgementDocmentInfoHis(String fileNo, String userType) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getJudgementDocHisInfo());
        List<AgentTopLeaderJudgementDocumentHisEntity> list = createQuery(hql, fileNo,userType).list();
        return list;
	}

	/**
	 * 执行公告（报告历史查询）
	 * @param fileNo    //文件编号
	 * @param userType  //用户类型：法人代表、控股股东
	 * @return
	 * @throws DataAccessException 
	 */
	public List<AgentTopLeaderExecuteDocHisEntity> getJExecuteDocInfoHis(String fileNo, String userType) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getExecuteDocHisInfo());
        List<AgentTopLeaderExecuteDocHisEntity> list = createQuery(hql, fileNo,userType).list();
        return list;
	}

	/**
	 * 失信公告（报告历史查询）
	 * @param fileNo    //文件编号
	 * @param userType  //用户类型：法人代表、控股股东
	 * @return
	 * @throws DataAccessException 
	 */
	public List<AgentTopleaderDishonourNoticHisEntity> getDishonourNoticeInfoHis(String fileNo, String userType) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getDishonourNoticeHisInfo());
        List<AgentTopleaderDishonourNoticHisEntity> list = createQuery(hql, fileNo,userType).list();
        return list;
	}

	/**
	 * 网贷黑名单（报告历史查询）
	 * @param fileNo    //文件编号
	 * @param userType  //用户类型：法人代表、控股股东
	 * @return
	 * @throws DataAccessException 
	 */
	public List<AgentTopleaderNetloanHisEntity> getNetloadInfoHis(String fileNo, String userType) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getNetloadHisInfo());
        List<AgentTopleaderNetloanHisEntity> list = createQuery(hql, fileNo,userType).list();
        return list;
	}
	
	
	/**
	 * 曝光台（报告历史查询）
	 * @param fileNo    //文件编号
	 * @param userType  //用户类型：法人代表、控股股东
	 * @return
	 * @throws DataAccessException 
	 */
	public List<AgentTopleaderCourExposureHisEntity> getCourExposureInfoHis(String fileNo, String userType) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getCourtExposureHisInfo());
        List<AgentTopleaderCourExposureHisEntity> list = createQuery(hql, fileNo,userType).list();
        return list;
	}

	/**
	 * 法人任职（报告历史查询）
	 * @param fileNo    //文件编号
	 * @return
	 * @throws DataAccessException 
	 */
	public List<LegPerInfoHisEntity> getLegPerInfoNewHis(String fileNo) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getLegPerHisInfo());
        List<LegPerInfoHisEntity> list = createQuery(hql, fileNo).list();
        return list;
	}

	/**
	 * 法人投资（报告历史查询）
	 * @param fileNo    //文件编号
	 * @return
	 * @throws DataAccessException 
	 */
	public List<OdsLegPerEquityHisEntity> getLegPerQuityInfoHis(String fileNo) throws DataAccessException {
		Map<String, Object> params = new HashMap<>();
        params.put("fileNo", fileNo);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getLegPerQuityHisInfo(), params);
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(OdsLegPerEquityHisEntity.class));
		return query.list();
	}
}
