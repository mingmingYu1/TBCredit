package com.yodata.creditsupport.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yodata.creditsupport.orm.entity.his.AgentInfoHisEntity;
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
import com.yodata.creditsupport.orm.person.entity.PersonReportTempletEntity;
import com.yodata.creditsupport.orm.person.entity.PersonSaveInfoEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonInfoReportEntity;
import com.yodata.creditsupport.orm.vo.IndicatorScoreWeight;
import com.yodata.creditsupport.util.QueryParam;

public interface IPersonCreditReportService{

	/**
	 * 查询个人一页征信报告
	 * @param queryParam
	 * @param cardId
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> getPersonPageReport(QueryParam queryParam, String cardId) throws SQLException;
	
	/**
	 * 获取一条报告模板信息来正确显示报告内容
	 * @param templetId	模板编号
	 * @param isCreate	是否为生成报告
	 * @return
	 */
	public Map<String, Object> getPersonTempletById(Integer templetId, boolean isCreate);
	
	/**
	 * 查询所有报告模板信息
	 * @return
	 */
	public List<PersonReportTempletEntity> getAllReportTemp();
	
	/**
	 * 获取一条报告模板信息来正确显示报告内容
	 * @param templetId	模板编号
	 * @param isCreate	是否为生成报告
	 * @return
	 */
	public Map<String, Object> getTempletById(Integer templetId, boolean isCreate);
	/**
	 * 查询该企业当天报表最大结尾编号，生成正确最大编号的记录并返回
	 * @param cardId	企业编号
	 * @param cardId		工商注册号
	 * @param date		用于对比是否为当天
	 * @return
	 */
	public PersonSaveInfoEntity createMaxIndexReport(String cardId, Date date);
	
	/**
	 * 查询一条个人信息
	 * @param cardId		省份证编号
	 * @return
	 */
	public OdsPersonInfoEntity getPersonInfoById(String cardId);
	
	public Map<String, String> getScoreReportInfo(String id, String algorithmType, IndicatorScoreWeight totalScore);
	
	/**
	 * 转换个人得分信息
	 * @param sw		各项指标得分的总分
	 * @return
	 */
	public Map<String, String> convertCreditScore(IndicatorScoreWeight sw);

	/**
	 * 驾驶证信息
	 * @param cardId 身份证号
	 * @return
	 */
	public List<OdsPersonDriverlicensestatusEntity> getDriverlicenseStatausInfo(String cardId);

	/**
	 * 个人投资失信被执行人
	 * @param cardId
	 * @return
	 */
	public List<OdsPersonInvestPunishbreakEntity> getInvestPunishBreakInfo(String cardId);

	/**
	 * 个人投资—执行人
	 * @param cardId
	 * @return
	 */
	public List<OdsPersonInvestPunishedEntity> getInvestPunishedInfo(String cardId);

	//企业法定代表人
	public List<OdsPersonInvestRyposfrEntity> getInversRyposfrInfo(String id);

	//管理人员
	public List<OdsPersonInvestRyposperEntity> getInversRyposperInfo(String id);

	//企业股东
	public List<OdsPersonInvestRyposshaEntity> getInversRyposshaInfo(String id);

	/**
	 * 个人司法
	 */
	
	//司法报告
	public List<OdsPersonRiskBgtEntity> getRiskBgtInfo(String cardId);

	//裁判文书
	public List<OdsPersonRiskCpwsEntity> getRiskCpwsInfo(String cardId);

	//失信公告
	public List<OdsPersonRiskShixinEntity> getRiskDishonerInfo(String cardId);

	//网贷黑名单
	public List<OdsPersonRiskWdhmdEntity> getRiskNetloadInfo(String cardId);

	//执行公告
	public List<OdsPersonRiskZxggEntity> getRiskExecuteDocInfo(String cardId);

	//阿里欠贷信息
	public List<OdsPersonInvestAlidebtEntity> getInvestAlidebtInfo(String cardId);

	//银联三要素
	public List<OdsPersonVerifybankcardby3eleEntity> getVerifyBankCardInfo(String cardId);
	
	//资产状况及交易行为
	public List<OdsPersonReportBasicEntity> getReportBasicInfo(String cardId);

	//消费大类分布
	public List<OdsPersonReportConsumecategoriesEntity> getReportConsumeCategoryInfo(String cardId);

	//城市消费状况
	public List<OdsPersonReportConsumecitiesEntity> getReportConsumeCityInfo(String cardId);

	//每月消费状况
	public List<OdsPersonReportMonthconsumesEntity> getReportMonthConsumeInfo(String carId);

	//消费行为
	public List<OdsPersonReportTransbehaviorEntity> getReportTransBehaivorInfo(String cardId);

	//信用相关交易统计
	public List<OdsPersonReportTranscreditsEntity> getReportTransCreditInfo(String cardId);

	/**
	 * 保存生成报告的一切信息
	 * @param person		企业历史信息
	 * @param saveInfo	生成的报告信息
	 */
	public void savePersonReport(OdsPersonInfoReportEntity person, PersonSaveInfoEntity saveInfo);
	
	/**
	 * 查询征信报告的企业历史信息
	 * @param cardId		身份证编号
	 * @param fileNo	文件编号
	 * @return
	 */
	public OdsPersonInfoReportEntity getPersonReportInfo(String cardId, String fileNo);

	
}
