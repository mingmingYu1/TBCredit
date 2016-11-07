package com.yodata.creditsupport.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yodata.creditsupport.exception.BusinessException;
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
import com.yodata.creditsupport.orm.entity.ReportTempletEntity;
import com.yodata.creditsupport.orm.entity.SaveInfoEntity;
import com.yodata.creditsupport.orm.entity.SpecialInfoEntity;
import com.yodata.creditsupport.orm.entity.StockholderInfoEntity;
import com.yodata.creditsupport.orm.entity.TopManagerInfoEntity;
import com.yodata.creditsupport.orm.entity.his.AgentInfoHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopLeaderExecuteDocHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopLeaderJudgementDocumentHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopleaderCourExposureHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopleaderDishonourNoticHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopleaderNetloanHisEntity;
import com.yodata.creditsupport.orm.entity.his.LegPerInfoHisEntity;
import com.yodata.creditsupport.orm.entity.his.OdsBalanceSheetHisEntity;
import com.yodata.creditsupport.orm.entity.his.OdsLegPerEquityHisEntity;
import com.yodata.creditsupport.orm.entity.his.SpecialInfoHisEntity;
import com.yodata.creditsupport.orm.entity.his.StockholderInfoHisEntity;
import com.yodata.creditsupport.orm.vo.IndicatorScoreWeight;
import com.yodata.creditsupport.util.QueryParam;

public interface ICreditReportService {
	/**
	 * 获取评分简述里行业、通用类指标得分信息
	 * @param id			企业工商注册号
	 * @param algorithmType	算法类型
	 * @param totalScore	总分信息
	 * @return
	 */
	public Map<String, String> getScoreReportInfo(String id, String algorithmType, IndicatorScoreWeight totalScore);
	/**
	 * 生成征信报告
	 * @param templetId		报告模板编号
	 * @param saveInfo		报告临时信息
	 * @param scoreMap		评分简述得分信息
	 * @param agentScore	信用评分信息
	 * @param inds			指标大类得分、权重
	 * @param param			其它参数
	 * @return				jsp页面用到的数据
	 * @throws BusinessException
	 */
	public Map<String, Object> createReport(Integer templetId, SaveInfoEntity saveInfo,
			Map<String, String> scoreMap, Map<String, String> agentScore,
			List<IndicatorScoreWeight> inds, Map<String, String> param) throws BusinessException;
	/**
	 * 查询一页征信报告
	 * @param queryParam
	 * @param regId
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> getPageReport(QueryParam queryParam, String regId) throws SQLException;
	/**
	 * 转换企业得分信息
	 * @param sw		各项指标得分的总分
	 * @return
	 */
	public Map<String, String> convertCreditScore(IndicatorScoreWeight sw);
	/**
	 * 查询一条企业信息
	 * @param regId		企业编号
	 * @return
	 */
	public AgentInfoEntity getAgentInfoById(String regId);
	/**
	 * 查询企业地址和电话信息
	 * @param id		企业编号
	 * @return
	 */
	public List<EntAttrInfoEntity> getEntAttrInfo(String id);
	/**
	 * 查询股东信息
	 * @param id		企业编号
	 * @return
	 */
	public List<StockholderInfoEntity> getStockholderInfo(String id);
	/**
	 * 查询高管信息
	 * @param id		企业编号
	 * @return
	 */
	public List<TopManagerInfoEntity> getTopManagerInfo(String id);
	/**
	 * 查询对外股权投资信息
	 * @param id		企业编号
	 * @return
	 */
	public List<OthEntInvestsInfoEntity> getOthEntInvestsInfo(String id);
	/**
	 * 查询企业法人相关信息（全部）
	 * @param id		企业编号
	 * @return
	 */
	public List<LegPerInfoEntity> getLegPerInfo(String id);
	/**
	 * 查询企业法人相关信息（根据类型）
	 * @param id		企业编号
	 * @param type
	 * @return
	 */
	public List<LegPerInfoEntity> getLegPerInfo(String id,Integer type);
	/**
	 * 查询企业特殊事项信息
	 * @param regId		企业编号
	 * @param type		
	 * @return
	 */
	public List<SpecialInfoEntity> getSpecialInfo(String regId);
	/**
	 * 查询征信报告的企业历史信息
	 * @param id		企业编号
	 * @param fileNo	文件编号
	 * @return
	 */
	public AgentInfoHisEntity getAgentInfoHis(String id, String fileNo);
	/**
	 * 根据征信报告文件编号查询股东历史信息
	 * @param fileNo	文件编号
	 * @return
	 */
	public List<StockholderInfoHisEntity> getStockholderInfoHis(String fileNo);
	/**
	 * 根据征信报告文件编号查询法人历史信息
	 * @param fileNo	文件编号
	 * @return
	 */
	public List<LegPerInfoHisEntity> getLegPerInfoHis(String fileNo);
	/**
	 * 
	 * @param fileNo	文件编号
	 * @param type		
	 * @return
	 */
	public List<SpecialInfoHisEntity> getSpecialInfoHis(String fileNo, Integer type);
	/**
	 * 查询所有报告模板信息
	 * @return
	 */
	public List<ReportTempletEntity> getAllReportTemp();
	/**
	 * 获取一条报告模板信息来正确显示报告内容
	 * @param templetId	模板编号
	 * @param isCreate	是否为生成报告
	 * @return
	 */
	public Map<String, Object> getTempletById(Integer templetId, boolean isCreate) throws BusinessException;
	/**
	 * 查询该企业当天报表最大结尾编号，生成正确最大编号的记录并返回
	 * @param regId	企业编号
	 * @param regId		工商注册号
	 * @param date		用于对比是否为当天
	 * @return
	 */
	public SaveInfoEntity createMaxIndexReport(String regId, Date date);
	
	/**
	 * 查询该企业的变更信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentChangeEntity> getAgentChangeInfo(String id);
	
	/**
	 * 查询该企业的变更信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentFiliationEntity> getAgentFiliationInfo(String regId);
	
	/**
	 * 查询清算信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentLiquidationEntity> getLiquidationInfo(String regId);
	
	/**
	 * 查询动产抵押信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentMortgageEntity> getAgentMortgageInfo(String regId);
	
	/**
	 * 查询动产抵押信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<MortgageItemEntity> getMortgageItemInfo(String regId);
	
	/**
	 * 查询股权冻结类似信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentSharesFroEntity> getAgentSharesInfo(String regId);
	
	/**
	 * 查询股权出质信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentSharesImpawnEntity> getAgentSharesImpawInfo(String regId);
	
	
	/**
	 * 查询违法违规裁判文书
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentJudgementDocumentEntity> getJudgeMentDocInfo(String regId);
	
	/**
	 * 查询违法违规执行公告
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentCourEnforcementEntity> getAgentCourForceInfo(String regId);
	
	/**
	 * 查询法定代表人执行公告
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentTopLeaderExecuteDocEntity> getAgentTopleaderExdocInfo(String regId,String userType);
	
	/**
	 * 查询法定代表人失信公告
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentTopleaderDishonourNoticEntity> getAgentTopLeaderDishonourInfo(String regId,String userType);
	
	/**
	 * 查询法定代表人失信网贷黑民单
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentTopleaderNetloanEntity> getAgentTopLeaderNetLoanInfo(String regId,String userType);
	
	/**
	 * 查询法定代表人失信曝光台
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentTopleaderCourExposureEntity> getAgentTopLeaderCourtExposInfo(String regId,String userType);
	
	/**
	 * 查询阿里欠贷信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentAliLoanbreakEntity> getAgentAliloadBreakInfo(String id);
	
	/**
	 * 核心经营指标信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<MerchantTrandeReportBase> getMerchantTradeInfo(String id);
	
	/**
	 * 经营稳定性指标
	 * @param regId	企业编号
	 * @return
	 */
	public List<MerchantTrandeReportStability> getMerchantStabilityInfo(String regId);
	
	/**
	 * 税务信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentTaxAccountEntity> getAgentTaxAccountInfo(String id);
	
	/**
	 * 经营变化趋势信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<MerchantTrandeReportChange> getMerchantChangeInfo(String id);
	
	/**
	 * 本市同行对比信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<MerchantTrandeReportConstrast> getMerchantConstrastInfo(String regId);
	
	/**
	 * 本市同行对比信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<MerchantTrandeReportArea> getMerchantAreaInfo(String regId);
	
	/**
	 * 客户忠诚度
	 * @param regId	企业编号
	 * @return
	 */
	public List<MerchantTrandeReportLoyalty> getMerchantLoyaltyInfo(String regId);
	
	/**
	 * 法定代表人失信裁判文书
	 * @param regId	企业编号
	 * @return
	 */
	public List<AgentTopLeaderJudgementDocumentEntity> getAgentTopleaderJudgentDocInfo(String id,String userType);
	
	/**
	 * 月异常信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<MerchantTradeReportAbormal> getMerchantAbormalInfo(String id);
	
	/**
	 * 资产负债
	 * @param regId	企业编号
	 * @return
	 */
	public List<OdsBalanceSheetEntity> getBalanceSheetInfo(String regId);
	
	/**
	 * 利润表
	 * @param regId	企业编号
	 * @return
	 */
	public List<OdsProfitEntity> getProfitInfo(String id);
	
	/**
	 * 资产负债（Report）
	 * @param regId	企业编号
	 * @return
	 */
	public List<OdsBalanceSheetHisEntity> getBalanceSheetInfoHis(String fileNo);
	
	/**
	 * 裁判文书（Report）
	 * @param fileNo	文件编号
	 * @param userType 用户类型
	 * @return
	 */
	public List<AgentTopLeaderJudgementDocumentHisEntity> getJudgementDocmentInfoHis(String fileNo,String userType);

	/**
	 * 执行公告（Report）
	 * @param fileNo	文件编号
	 * @return
	 */
	public List<AgentTopLeaderExecuteDocHisEntity> getExecuteDocInfoHis(String fileNo, String userType);
	
	/**
	 * 失信公告（Report）
	 * @param fileNo	文件编号
	 * @return
	 */
	public List<AgentTopleaderDishonourNoticHisEntity> getDishonourNoticeInfoHis(String fileNo, String userType);
	
	/**
	 * 网贷黑名单（Report）
	 * @param fileNo	文件编号
	 * @return
	 */
	public List<AgentTopleaderNetloanHisEntity> getNetloadInfoHis(String fileNo, String userType);
	
	/**
	 * 曝光台（Report）
	 * @param fileNo	文件编号
	 * @return
	 */
	public List<AgentTopleaderCourExposureHisEntity> getExposureInfoHis(String fileNo, String string);
	
	/**
	 * 法人在其他机构任职（Report）
	 * @param regId	企业编号
	 * @return
	 */
	public List<LegPerInfoEntity> getLegPerInfoNew(String regId);
	
	/**
	 * 法人投资信息
	 * @param regId	企业编号
	 * @return
	 */
	public List<OdsLegPerEquityEntity> getLegPerQuityInfo(String id);

	/**
	 * 
	 * @param fileNo
	 * @return
	 */
	public List<LegPerInfoHisEntity> getLegPerInfoHisNew(String fileNo);
	
	/**
	 * 
	 * @param fileNo
	 * @return
	 */
	public List<OdsLegPerEquityHisEntity> getLegPerQuityHis(String fileNo);
	
}
