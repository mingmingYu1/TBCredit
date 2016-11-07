package com.yodata.creditsupport.dao.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.person.entity.OdsPersonDriverlicensestatusEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInfoEntity;
import com.yodata.creditsupport.orm.person.entity.report.*;
import com.yodata.creditsupport.util.ConstantBean;

@Component
@SuppressWarnings("unchecked")
public class PersonReportDao extends SimpleHibernateDao<OdsPersonInfoReportEntity,java.lang.Integer>{

	@Resource
	private DynamicHibernateSqlDao dynamicHibernateSqlDao;
	@Autowired
	private ConstantBean constant;
	
	 /**
     * 查询企业历史信息，即一张征信报告的数据
     * @param cardId
     * @param fileNo
     * @return
     * @throws DataAccessException 
     */
	public OdsPersonInfoReportEntity getPersonReportInfo(String cardId, String fileNo) throws DataAccessException {
	    SimpleExpression param = Restrictions.eq("fileNo", fileNo);
	    Criteria criteria = this.createCriteria(Restrictions.conjunction()
                .add(Restrictions.eq("cardId", cardId))
                .add(param));
		List<OdsPersonInfoReportEntity> list = (List<OdsPersonInfoReportEntity>)criteria.list();
		if(list == null){
			return null;
		}
		OdsPersonInfoReportEntity personReport = list.get(0);
		
		criteria = this.getSession().createCriteria(OdsPersonDriverlicensestatusReportEntity.class).add(param);
		personReport.setDriverList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonInvestPunishbreakReportEntity.class).add(param);
		personReport.setInvestPunishBreakList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonInvestPunishedReportEntity.class).add(param);
		personReport.setInvestPunishedList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonInvestRyposfrReportEntity.class).add(param);
		personReport.setInvestRyposfrList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonInvestRyposperReportEntity.class).add(param);
		personReport.setInvestRyposperList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonInvestRyposshaReportEntity.class).add(param);
		personReport.setInvestRyposshaList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonRiskBgtReportEntity.class).add(param);
		personReport.setRiskBgtList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonRiskCpwsReportEntity.class).add(param);
		personReport.setRiskCpwsList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonRiskShixinReportEntity.class).add(param);
		personReport.setRiskDishonerList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonRiskWdhmdReportEntity.class).add(param);
		personReport.setRiskNetloadList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonRiskZxggReportEntity.class).add(param);
		personReport.setRiskExecuteDocList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonInvestAlidebtReportEntity.class).add(param);
		personReport.setInvestAlidebtList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonVerifybankcardby3eleReportEntity.class).add(param);
		personReport.setVrifyBankCardList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonReportBasicReportEntity.class).add(param);
		personReport.setReportBasicList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonReportConsumecategoriesReportEntity.class).add(param);
		personReport.setReportConsumeCategoryList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonReportConsumecitiesReportEntity.class).add(param);
		personReport.setReportConsumeCityList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonReportMonthconsumesReportEntity.class).add(param);
		personReport.setReportMonthComsumeList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonReportTransbehaviorReportEntity.class).add(param);
		personReport.setReportConsumeBehaviorList(criteria.list());
		
		criteria = this.getSession().createCriteria(OdsPersonReportTranscreditsReportEntity.class).add(param);
		personReport.setReportTransCreditList(criteria.list());
		
		
		return personReport;
	}

	
}
