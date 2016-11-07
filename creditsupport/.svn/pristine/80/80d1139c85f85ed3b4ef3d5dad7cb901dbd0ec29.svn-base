package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.yodata.creditsupport.orm.vo.BasicIndiScore;
import com.yodata.creditsupport.orm.vo.IndicatorScoreWeight;

public class AllInfoEntity implements Serializable{

	private static final long serialVersionUID = 8746944840509186803L;

	private static AllInfoEntity singleInstance = null;
	static
	{
		singleInstance = new AllInfoEntity();
	}
	
	private AgentInfoEntity agentInfo;
	//联系信息
	private List<EntAttrInfoEntity> entAttrInfo;
	//股东信息
	private List<StockholderInfoEntity> stockholderInfo;
	//高管信息
	private List<TopManagerInfoEntity> topManagerInfo;
	//企业对外股权投资信息
	private List<OthEntInvestsInfoEntity> othEntInvestsInfo;
	private List<AgentChangeEntity> agentChangeInfo;
	private List<AgentFiliationEntity> agentFiliationInfo;
	private List<AgentLiquidationEntity> liquidationInfo;
	private List<AgentMortgageEntity> agentMortgageInfo;
	private List<MortgageItemEntity> mortgageItemInfo;
	private List<AgentSharesFroEntity> agentSharesInfo;
	private List<AgentSharesImpawnEntity> agentSharesImpawInfo;
	private List<AgentJudgementDocumentEntity> agentJudgeDocInfo;
	private List<AgentCourEnforcementEntity> agentCoutEnforceInfo;
	private List<AgentTopLeaderExecuteDocEntity> agentTopLeaderEexdocInfo;
	private List<AgentTopleaderDishonourNoticEntity> agentTopLeaderDishonourInfo;
	private List<AgentTopleaderNetloanEntity> agentTopLeaderNetloanInfo;
	private List<AgentTopleaderCourExposureEntity> agentTopLeaderCourtExposInfo;
	private List<AgentAliLoanbreakEntity> agentAliloadBreakInfo;
	private List<MerchantTrandeReportBase> merchantTradeInfo;
	private List<MerchantTrandeReportStability> merchantStabilityInfo;
	private List<SpecialInfoEntity> specialInfo;
	//法人信息：法人其他机构任职信息/法人股权投资信息
	private List<LegPerInfoEntity> legPerList;
	private List<BasicIndiScore> scoreWeight;
	private List<IndicatorScoreWeight> inds;
	
	private Map<String, String> scoreMap;
	private Map<String, String> agentScore;
	private Map<String, String> mList;
	private Map<String, Object> templetObj;
	private String algorithmType;
	private String regId;
	private String pdfFilePath;
	private SaveInfoEntity saveInfo;
	
	public SaveInfoEntity getSaveInfo() {
		return saveInfo;
	}
	public void setSaveInfo(SaveInfoEntity saveInfo) {
		this.saveInfo = saveInfo;
	}
	public List<IndicatorScoreWeight> getInds() {
		return inds;
	}
	public void setInds(List<IndicatorScoreWeight> inds) {
		this.inds = inds;
	}
	public String getPdfFilePath() {
		return pdfFilePath;
	}
	public void setPdfFilePath(String pdfFilePath) {
		this.pdfFilePath = pdfFilePath;
	}
	public List<SpecialInfoEntity> getSpecialInfo() {
		return specialInfo;
	}
	public void setSpecialInfo(List<SpecialInfoEntity> specialInfo) {
		this.specialInfo = specialInfo;
	}
	public List<EntAttrInfoEntity> getEntAttrInfo() {
		return entAttrInfo;
	}
	public void setEntAttrInfo(List<EntAttrInfoEntity> entAttrInfo) {
		this.entAttrInfo = entAttrInfo;
	}
	public List<StockholderInfoEntity> getStockholderInfo() {
		return stockholderInfo;
	}
	public void setStockholderInfo(List<StockholderInfoEntity> stockholderInfo) {
		this.stockholderInfo = stockholderInfo;
	}
	public List<TopManagerInfoEntity> getTopManagerInfo() {
		return topManagerInfo;
	}
	public void setTopManagerInfo(List<TopManagerInfoEntity> topManagerInfo) {
		this.topManagerInfo = topManagerInfo;
	}
	public List<OthEntInvestsInfoEntity> getOthEntInvestsInfo() {
		return othEntInvestsInfo;
	}
	public void setOthEntInvestsInfo(List<OthEntInvestsInfoEntity> othEntInvestsInfo) {
		this.othEntInvestsInfo = othEntInvestsInfo;
	}
	public List<AgentChangeEntity> getAgentChangeInfo() {
		return agentChangeInfo;
	}
	public void setAgentChangeInfo(List<AgentChangeEntity> agentChangeInfo) {
		this.agentChangeInfo = agentChangeInfo;
	}
	public List<AgentFiliationEntity> getAgentFiliationInfo() {
		return agentFiliationInfo;
	}
	public void setAgentFiliationInfo(List<AgentFiliationEntity> agentFiliationInfo) {
		this.agentFiliationInfo = agentFiliationInfo;
	}
	public List<AgentLiquidationEntity> getLiquidationInfo() {
		return liquidationInfo;
	}
	public void setLiquidationInfo(List<AgentLiquidationEntity> liquidationInfo) {
		this.liquidationInfo = liquidationInfo;
	}
	public List<AgentMortgageEntity> getAgentMortgageInfo() {
		return agentMortgageInfo;
	}
	public void setAgentMortgageInfo(List<AgentMortgageEntity> agentMortgageInfo) {
		this.agentMortgageInfo = agentMortgageInfo;
	}
	public List<MortgageItemEntity> getMortgageItemInfo() {
		return mortgageItemInfo;
	}
	public void setMortgageItemInfo(List<MortgageItemEntity> mortgageItemInfo) {
		this.mortgageItemInfo = mortgageItemInfo;
	}
	public List<AgentSharesFroEntity> getAgentSharesInfo() {
		return agentSharesInfo;
	}
	public void setAgentSharesInfo(List<AgentSharesFroEntity> agentSharesInfo) {
		this.agentSharesInfo = agentSharesInfo;
	}
	public List<AgentSharesImpawnEntity> getAgentSharesImpawInfo() {
		return agentSharesImpawInfo;
	}
	public void setAgentSharesImpawInfo(List<AgentSharesImpawnEntity> agentSharesImpawInfo) {
		this.agentSharesImpawInfo = agentSharesImpawInfo;
	}
	public List<AgentJudgementDocumentEntity> getAgentJudgeDocInfo() {
		return agentJudgeDocInfo;
	}
	public void setAgentJudgeDocInfo(List<AgentJudgementDocumentEntity> agentJudgeDocInfo) {
		this.agentJudgeDocInfo = agentJudgeDocInfo;
	}
	public List<AgentCourEnforcementEntity> getAgentCoutEnforceInfo() {
		return agentCoutEnforceInfo;
	}
	public void setAgentCoutEnforceInfo(List<AgentCourEnforcementEntity> agentCoutEnforceInfo) {
		this.agentCoutEnforceInfo = agentCoutEnforceInfo;
	}
	public List<AgentTopLeaderExecuteDocEntity> getAgentTopLeaderEexdocInfo() {
		return agentTopLeaderEexdocInfo;
	}
	public void setAgentTopLeaderEexdocInfo(List<AgentTopLeaderExecuteDocEntity> agentTopLeaderEexdocInfo) {
		this.agentTopLeaderEexdocInfo = agentTopLeaderEexdocInfo;
	}
	public List<AgentTopleaderDishonourNoticEntity> getAgentTopLeaderDishonourInfo() {
		return agentTopLeaderDishonourInfo;
	}
	public void setAgentTopLeaderDishonourInfo(List<AgentTopleaderDishonourNoticEntity> agentTopLeaderDishonourInfo) {
		this.agentTopLeaderDishonourInfo = agentTopLeaderDishonourInfo;
	}
	public List<AgentTopleaderNetloanEntity> getAgentTopLeaderNetloanInfo() {
		return agentTopLeaderNetloanInfo;
	}
	public void setAgentTopLeaderNetloanInfo(List<AgentTopleaderNetloanEntity> agentTopLeaderNetloanInfo) {
		this.agentTopLeaderNetloanInfo = agentTopLeaderNetloanInfo;
	}
	public List<AgentTopleaderCourExposureEntity> getAgentTopLeaderCourtExposInfo() {
		return agentTopLeaderCourtExposInfo;
	}
	public void setAgentTopLeaderCourtExposInfo(List<AgentTopleaderCourExposureEntity> agentTopLeaderCourtExposInfo) {
		this.agentTopLeaderCourtExposInfo = agentTopLeaderCourtExposInfo;
	}
	public List<AgentAliLoanbreakEntity> getAgentAliloadBreakInfo() {
		return agentAliloadBreakInfo;
	}
	public void setAgentAliloadBreakInfo(List<AgentAliLoanbreakEntity> agentAliloadBreakInfo) {
		this.agentAliloadBreakInfo = agentAliloadBreakInfo;
	}
	public List<MerchantTrandeReportBase> getMerchantTradeInfo() {
		return merchantTradeInfo;
	}
	public void setMerchantTradeInfo(List<MerchantTrandeReportBase> merchantTradeInfo) {
		this.merchantTradeInfo = merchantTradeInfo;
	}
	public List<MerchantTrandeReportStability> getMerchantStabilityInfo() {
		return merchantStabilityInfo;
	}
	public void setMerchantStabilityInfo(List<MerchantTrandeReportStability> merchantStabilityInfo) {
		this.merchantStabilityInfo = merchantStabilityInfo;
	}
	public List<BasicIndiScore> getScoreWeight() {
		return scoreWeight;
	}
	public void setScoreWeight(List<BasicIndiScore> scoreWeight) {
		this.scoreWeight = scoreWeight;
	}
	public List<LegPerInfoEntity> getLegPerList() {
		return legPerList;
	}
	public void setLegPerList(List<LegPerInfoEntity> legPerList) {
		this.legPerList = legPerList;
	}
	public String getAlgorithmType() {
		return algorithmType;
	}
	public void setAlgorithmType(String algorithmType) {
		this.algorithmType = algorithmType;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public AgentInfoEntity getAgentInfo() {
		return agentInfo;
	}
	public void setAgentInfo(AgentInfoEntity agentInfo) {
		this.agentInfo = agentInfo;
	}	
	public Map<String, String> getScoreMap() {
		return scoreMap;
	}
	public void setScoreMap(Map<String, String> scoreMap) {
		this.scoreMap = scoreMap;
	}
	public Map<String, String> getAgentScore() {
		return agentScore;
	}
	public void setAgentScore(Map<String, String> agentScore) {
		this.agentScore = agentScore;
	}
	public Map<String, String> getmList() {
		return mList;
	}
	public void setmList(Map<String, String> mList) {
		this.mList = mList;
	}
	public Map<String, Object> getTempletObj() {
		return templetObj;
	}
	public void setTempletObj(Map<String, Object> templetObj) {
		this.templetObj = templetObj;
	}
	public static AllInfoEntity getInstance()
	{
		if(singleInstance == null)
			singleInstance = new AllInfoEntity();
		return singleInstance;
	}
	
}
