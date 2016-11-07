package com.yodata.creditsupport.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.person.entity.OdsPersonDriverlicensestatusEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInfoEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInvestAlidebtEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInvestPunishbreakEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInvestPunishedEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInvestRyposfrEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInvestRyposperEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInvestRyposshaEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonReportBasicEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonReportConsumecategoriesEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonReportConsumecitiesEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonReportMonthconsumesEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonReportTransbehaviorEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonReportTranscreditsEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonRiskBgtEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonRiskCpwsEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonRiskShixinEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonRiskWdhmdEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonRiskZxggEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonVerifybankcardby3eleEntity;
import com.yodata.creditsupport.util.ConstantBean;
import com.yodata.creditsupport.util.NullObjectUtil;
import com.yodata.creditsupport.util.QueryParam;

@Component
public class PersonDao extends SimpleHibernateDao<OdsPersonInfoEntity, String>{

	@Resource
	private DynamicHibernateSqlDao dynamicHibernateSqlDao;
	@Autowired
	private ScoreLevelVersionDao scoreLevelVersionDao;
	@Autowired
	private ScoreLevelDao scoreLevelDao;
	@Autowired
	private ConstantBean constant;

	public Map<String, Object> getPagePersons(QueryParam queryParam) throws DataAccessException 
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("cardId", StringUtils.isEmpty(queryParam.getQueryCode()) ? null : queryParam.getQueryCode());
		params.put("cardName", StringUtils.isEmpty(queryParam.getQueryName()) ? null : queryParam.getQueryName());
		String countSql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetPagePersons()+constant.getSqlCount(), params);
		int count = 0;
		Session session = this.getSession();
		Query query = session.createSQLQuery(countSql);
		List<Map<String, Object>> totals = query.list();
		count = totals != null ? totals.size() : 0;
		params.put("sortStr", StringUtils.isEmpty(queryParam.getSortStr()) ? null : queryParam.getSortStr());
		String dataSql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetPagePersons(), params);
		query = session.createSQLQuery(dataSql);
		query.setFirstResult(queryParam.getOffset());
		query.setMaxResults(queryParam.getLimit());
		query.setResultTransformer(Transformers.aliasToBean(OdsPersonInfoEntity.class));
		List<OdsPersonInfoEntity> list = query.list();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("data", list);
		return map;
	}
	

	/**
	 * 查询驾驶证信息
	 * @param cardId
	 * @return
	 * @throws DataAccessException 
	 */
	public List<OdsPersonDriverlicensestatusEntity> getDriverlicentseStatusInfo(String cardId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getDriverLicenseStatusInfo());
		List<OdsPersonDriverlicensestatusEntity> list = createQuery(hql, cardId).list();
		return list;
	}

	//个人投资--失信被执行人
	public List<OdsPersonInvestPunishbreakEntity> getInvesPunishBreakInfo(String cardId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getInvesPunishBreakInfo());
		List<OdsPersonInvestPunishbreakEntity> list = createQuery(hql, cardId).list();
		return list;
	}


	//个人投资--执行人
	public List<OdsPersonInvestPunishedEntity> getInversPunishedInfo(String cardId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getInvesPunishedInfo());
		List<OdsPersonInvestPunishedEntity> list = createQuery(hql, cardId).list();
		return list;
	}

	//法定代表人
	public List<OdsPersonInvestRyposfrEntity> getInversRyposfrInfo(String cardId) throws DataAccessException
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getInvesRyposfrInfo());
		List<OdsPersonInvestRyposfrEntity> list = createQuery(hql, cardId).list();
		return list;
	}

    //管理人员
	public List<OdsPersonInvestRyposperEntity> getInversRyposperInfo(String cardId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getInvesRyposperInfo());
		List<OdsPersonInvestRyposperEntity> list = createQuery(hql, cardId).list();
		return list;
	}

    //企业股东
	public List<OdsPersonInvestRyposshaEntity> getInversRyposshaInfo(String cardId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getInvesRyposshaInfo());
		List<OdsPersonInvestRyposshaEntity> list = createQuery(hql, cardId).list();
		return list;
	}
	
	/**
	 * 个人司法
	 */

    //曝光台
	public List<OdsPersonRiskBgtEntity> getRiskBgtInfo(String cardId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getRiskBgtInfo());
		List<OdsPersonRiskBgtEntity> list = createQuery(hql, cardId).list();
		return list;
	}


	//裁判文书
	public List<OdsPersonRiskCpwsEntity> getRiskCpwsInfo(String cardId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getRiskCpwsInfo());
		List<OdsPersonRiskCpwsEntity> list = createQuery(hql, cardId).list();
		return list;
	}


	//失信报告
	public List<OdsPersonRiskShixinEntity> getRiskDishonerInfo(String cardId) throws DataAccessException {
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getRiskDishonerInfo());
		List<OdsPersonRiskShixinEntity> list = createQuery(hql, cardId).list();
		return list;
	}


	//网贷黑名单
	public List<OdsPersonRiskWdhmdEntity> getRiskNetloadInfo(String cardId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getRiskNetloadInfo());
		List<OdsPersonRiskWdhmdEntity> list = createQuery(hql, cardId).list();
		return list;
	}

    //执行报告
	public List<OdsPersonRiskZxggEntity> getRiskExecuteDocInfo(String cardId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getRiskExecuteDocInfo());
		List<OdsPersonRiskZxggEntity> list = createQuery(hql, cardId).list();
		return list;
	}

    //阿里欠贷信息
	public List<OdsPersonInvestAlidebtEntity> getInvestAlidebtInfo(String cardId) throws DataAccessException
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getInvestAlidebtInfo());
		List<OdsPersonInvestAlidebtEntity> list = createQuery(hql, cardId).list();
		return list;
	}

	// 银联三要素验证信息
	public List<OdsPersonVerifybankcardby3eleEntity> getVerifyBankCardInfo(String cardId) throws DataAccessException
	{
		/*String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getVerifyBankCardInfo());
		List<OdsPersonVerifybankcardby3eleEntity> list = createQuery(hql, cardId).list();
		return list;*/
		Map<String, Object> params = new HashMap<>();
        params.put("cardId", cardId);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getVerifyBankCardInfo(),params);
        Session session = this.getSession();
        Query query = session.createSQLQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(OdsPersonVerifybankcardby3eleEntity.class));
        return query.list();
	}

	//资产状况及交易行为
	public List<OdsPersonReportBasicEntity> getReportBasicInfo(String cardId) throws DataAccessException
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getReportBasicInfo());
		List<OdsPersonReportBasicEntity> list = createQuery(hql, cardId).list();
		return list;
	}

    //消费大类分布
	public List<OdsPersonReportConsumecategoriesEntity> getReportConsumeCategoryInfo(String cardId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getReportConsumeCategoryInfo());
		List<OdsPersonReportConsumecategoriesEntity> list = createQuery(hql, cardId).list();
		return list;
	}

    //城市消费状况
	public List<OdsPersonReportConsumecitiesEntity> getReportConsumeCityInfo(String cardId) throws DataAccessException
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getReportConsumeCityInfo());
		List<OdsPersonReportConsumecitiesEntity> list = createQuery(hql, cardId).list();
		return list;
	}

    //每月消费状况
	public List<OdsPersonReportMonthconsumesEntity> getReportMonthConsumeInfo(String cardId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getReportMonthConsumeInfo());
		List<OdsPersonReportMonthconsumesEntity> list = createQuery(hql, cardId).list();
		return list;
	}

    //消费行为
	public List<OdsPersonReportTransbehaviorEntity> getReportTransBehaviorInfo(String cardId) throws DataAccessException
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getReportTransBehaviorInfo());
		List<OdsPersonReportTransbehaviorEntity> list = createQuery(hql, cardId).list();
		return list;
	}

    //信用相关交易统计
	public List<OdsPersonReportTranscreditsEntity> getReportTransCreditInfo(String cardId) throws DataAccessException 
	{
		String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getReportTransCreditInfo());
		List<OdsPersonReportTranscreditsEntity> list = createQuery(hql, cardId).list();
		return list;
	}

}
