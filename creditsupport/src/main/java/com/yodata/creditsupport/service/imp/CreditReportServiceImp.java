package com.yodata.creditsupport.service.imp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.support.json.JSONParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yodata.creditsupport.dao.CompanyDao;
import com.yodata.creditsupport.dao.CompanyHisDao;
import com.yodata.creditsupport.dao.IndicatorScoreDao;
import com.yodata.creditsupport.dao.SaveInfoDao;
import com.yodata.creditsupport.exception.BusinessException;
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
import com.yodata.creditsupport.orm.entity.ScoreLevelEntity;
import com.yodata.creditsupport.orm.entity.SpecialInfoEntity;
import com.yodata.creditsupport.orm.entity.StockholderInfoEntity;
import com.yodata.creditsupport.orm.entity.TopManagerInfoEntity;
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
import com.yodata.creditsupport.orm.vo.BasicIndiScore;
import com.yodata.creditsupport.orm.vo.IndicatorScoreWeight;
import com.yodata.creditsupport.orm.vo.ReportTitle;
import com.yodata.creditsupport.orm.vo.ReportTitleVo;
import com.yodata.creditsupport.service.ICreditReportService;
import com.yodata.creditsupport.util.QueryParam;
import com.yodata.creditsupport.util.ReportPdfUtils;
import com.yodata.creditsupport.util.Tools;

@Service
public class CreditReportServiceImp implements ICreditReportService {
    private final Log log = LogFactory.getLog(CreditReportServiceImp.class);
    
	@Resource
	private CompanyDao companyDao;
	@Resource
	private CompanyHisDao companyHisDao;
	@Resource
	private SaveInfoDao saveInfoDao;
	@Resource
    private IndicatorScoreDao indicatorScoreDao;
	
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, String> getScoreReportInfo(String regId, String algorithmType, IndicatorScoreWeight totalScore) {
		Map<String, String> rs = new HashMap<>();
		try {
			if(totalScore == null) {
				totalScore = indicatorScoreDao.getIndicatorScoreByTotal(regId, algorithmType);
			}
			List<IndicatorScoreWeight> list = indicatorScoreDao.getIndicatorScoreList(regId, algorithmType);
			Double score1 = 0.0d;	//通用类指标 得分合计
			Double weight1 = 0.0d;	//通用类指标 权重合计
			for(IndicatorScoreWeight isw : list) {
				if("1".equals(isw.getIndAttr())) {
					if(isw.getWeight() != null)
						weight1 += isw.getWeight();
					if(isw.getScore() != null)
						score1 += isw.getScore();
				}
			}
			if(totalScore != null)
			{
				Double totalS = totalScore.getScore();
				Double weight2 = 1 - weight1;	//行业类指标 权重合计
				Double score2 = totalS - score1;
				if(weight1 == 0.0d) {
					rs.put("score1Per", "0");
				} else {
					rs.put("score1Per", new BigDecimal(score1/weight1).setScale(0, BigDecimal.ROUND_HALF_UP).toString());
				}
				if(weight2 == 0.0d) {
					rs.put("score2Per", "0");
				} else {
					rs.put("score2Per", new BigDecimal(score2/weight2).setScale(0, BigDecimal.ROUND_HALF_UP).toString());
				}
				DecimalFormat df = new DecimalFormat("0%");
	            df.setRoundingMode(RoundingMode.HALF_UP);
		        DecimalFormat d = new DecimalFormat("0.00");
	            d.setRoundingMode(RoundingMode.HALF_UP);
		        rs.put("score1", d.format(score1));
		        rs.put("score2", d.format(score2));
		        rs.put("score1Weight", df.format(weight1));
		        rs.put("score2Weight", df.format(weight2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("sql执行错误", e);
		} catch (DataAccessException e) {
		    e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return rs;
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Map<String, Object> createReport(Integer templetId, SaveInfoEntity saveInfo,
			Map<String, String> scoreMap, Map<String, String> agentScore,
			List<IndicatorScoreWeight> inds, Map<String, String> param) throws BusinessException {
		Map<String, Object> jspData = new HashMap<>();	// jsp 需要的数据
		Map<String, Object> pdfData = new HashMap<>();	// pdf 需要的数据
		try {
			ObjectMapper json = new ObjectMapper();
			Date createTime = saveInfo.getCreateTime();	// 生成日期
			String algor = param.get("algor");
			String regId = param.get("regId");
			String algorithmType = param.get("algorithmType");
			String rootPath = param.get("rootPath");
			// 算法中文名称
			pdfData.put("algor", algor);
			jspData.put("algor", algor);
			// 显示的模板
			Map<String, Object> templetObj = this.getTempletById(templetId, true);
			// 显示模板
			pdfData.put("templetMap", templetObj.get("templetMap"));
			jspData.put("templetMap", templetObj.get("templetMap"));
			// 报告类别
			pdfData.put("reportType", templetObj.get("type"));
			jspData.put("reportType", templetObj.get("type"));
			pdfData.put("curDate", new SimpleDateFormat("yyyy年MM月dd日").format(createTime));
			// 重要声明
			pdfData.put("declareList", templetObj.get("declareList"));
			jspData.put("declareList", templetObj.get("declareList"));
			// 大标题
			pdfData.put("templetList", templetObj.get("templetList"));
			jspData.put("templetList", json.writeValueAsString(templetObj.get("templetList")));
			//得分信息
			pdfData.put("scoreMap", scoreMap);
			pdfData.put("creditScore", agentScore);
			/**
			 * 基本信息
			 */
			AgentInfoEntity info = this.getAgentInfoById(regId);
			pdfData.put("baseInfo", info);	// 工商注册信息 
			// 企业地址和电话信息
			List<EntAttrInfoEntity> entAttrInfo = this.getEntAttrInfo(regId);
			pdfData.put("entAttrInfo", entAttrInfo);
			jspData.put("entAttrInfo", json.writeValueAsString(entAttrInfo));
			// 股东信息
			List<StockholderInfoEntity> stockholderInfo = this.getStockholderInfo(regId);
			pdfData.put("stockholderInfo", stockholderInfo);
			jspData.put("stockholderInfo", json.writeValueAsString(stockholderInfo));
			// 高管信息
			List<TopManagerInfoEntity> topManagerInfo = this.getTopManagerInfo(regId);
			pdfData.put("topManagerInfo", topManagerInfo);
			jspData.put("topManagerInfo", json.writeValueAsString(topManagerInfo));
			// 对外股权投资信息
			List<OthEntInvestsInfoEntity> othEntInvestsInfo = this.getOthEntInvestsInfo(regId);
			pdfData.put("othEntInvestsInfo", othEntInvestsInfo);
			jspData.put("othEntInvestsInfo", json.writeValueAsString(othEntInvestsInfo));
			//企业变更信息
			List<AgentChangeEntity> agentChangeInfo = this.getAgentChangeInfo(regId);
			pdfData.put("agentChangeInfo", agentChangeInfo);
			jspData.put("agentChangeInfo", json.writeValueAsString(agentChangeInfo));
			//分之机构信息
			List<AgentFiliationEntity> agentFiliationInfo = this.getAgentFiliationInfo(regId);
			pdfData.put("fenzhiInfo", agentFiliationInfo);
			jspData.put("fenzhiInfo", agentFiliationInfo);
			//清算信息
			List<AgentLiquidationEntity> liquidationInfo = this.getLiquidationInfo(regId);
			pdfData.put("liquidationInfo", liquidationInfo);
			jspData.put("liquidationInfo", json.writeValueAsString(liquidationInfo));
			//动产抵押信息
			List<AgentMortgageEntity> agentMortgageInfo = this.getAgentMortgageInfo(regId);
			pdfData.put("agentMortgageInfo", agentMortgageInfo);
			jspData.put("agentMortgageInfo", agentMortgageInfo);
			//动产抵押物信息
			List<MortgageItemEntity> mortgageItemInfo = this.getMortgageItemInfo(regId);
			pdfData.put("mortgageItemInfo", mortgageItemInfo);
			jspData.put("mortgageItemInfo", json.writeValueAsString(mortgageItemInfo));
			//股权冻结历史信息
			List<AgentSharesFroEntity> agentSharesInfo = this.getAgentSharesInfo(regId);
			pdfData.put("agentSharesInfo", agentSharesInfo);
			jspData.put("agentSharesInfo", agentSharesInfo);
			//股权出质信息
			List<AgentSharesImpawnEntity> agentSharesImpawInfo = this.getAgentSharesImpawInfo(regId);
			pdfData.put("agentSharesImpawInfo", agentSharesImpawInfo);
			jspData.put("agentSharesImpawInfo", json.writeValueAsString(agentSharesImpawInfo));
			/**
			 * 财务信息
			 */
			//资产负债表
			List<OdsBalanceSheetEntity> balanceSheetInfo = this.getBalanceSheetInfo(regId);
			pdfData.put("balanceSheetInfo", balanceSheetInfo);
			jspData.put("balanceSheetInfo", json.writeValueAsString(balanceSheetInfo));
			//利润表
			List<OdsProfitEntity> profitInfo = this.getProfitInfo(regId);
			pdfData.put("profitInfo", profitInfo);
			jspData.put("profitInfo", json.writeValueAsString(profitInfo));
			/**
			 * 税务信息
			 */
			List<AgentTaxAccountEntity> agentTaxAccountInfo = this.getAgentTaxAccountInfo(regId);
			pdfData.put("agentTaxAccountInfo", agentTaxAccountInfo);
			jspData.put("agentTaxAccountInfo", json.writeValueAsString(agentTaxAccountInfo));
			/**
			 * 交易信息
			 */
			//核心经营指标
			List<MerchantTrandeReportBase> merchantTradeInfo = this.getMerchantTradeInfo(regId);
			pdfData.put("merchantTradeInfo", merchantTradeInfo);
			jspData.put("merchantTradeInfo", merchantTradeInfo);
			//经营稳定性指标
			List<MerchantTrandeReportStability> merchantStabilityInfo = this.getMerchantStabilityInfo(regId);
			pdfData.put("merchantStabilityInfo", merchantStabilityInfo);
			jspData.put("merchantStabilityInfo", json.writeValueAsString(merchantStabilityInfo));
			//异常交易信息
			List<MerchantTradeReportAbormal> merchantTradeAbormalInfo = this.getMerchantAbormalInfo(regId);
			pdfData.put("merchantTradeAbormalInfo", merchantTradeAbormalInfo);
			jspData.put("merchantTradeAbormalInfo", merchantTradeAbormalInfo);
			//经营变化趋势
			List<MerchantTrandeReportChange> merchantTrandeReportChangeInfo = this.getMerchantChangeInfo(regId);
			pdfData.put("merchantTrandeReportChangeInfo", merchantTrandeReportChangeInfo);
			jspData.put("merchantTrandeReportChangeInfo", json.writeValueAsString(merchantTrandeReportChangeInfo));
			//本市同行对比
			List<MerchantTrandeReportConstrast> merchantTrandeReportConstrastInfo = this.getMerchantConstrastInfo(regId);
			pdfData.put("merchantTrandeReportConstrastInfo", merchantTrandeReportConstrastInfo);
			jspData.put("merchantTrandeReportConstrastInfo", json.writeValueAsString(merchantTrandeReportConstrastInfo));
			//客户地域分布
			List<MerchantTrandeReportArea> merchantTrandeReportAreaInfo = this.getMerchantAreaInfo(regId);
			pdfData.put("merchantTrandeReportAreaInfo", merchantTrandeReportAreaInfo);
			jspData.put("merchantTrandeReportAreaInfo", json.writeValueAsString(merchantTrandeReportAreaInfo));
			//客户忠诚度
			List<MerchantTrandeReportLoyalty> merchantTrandeReportLoyaltyInfo = this.getMerchantLoyaltyInfo(regId);
			pdfData.put("merchantTrandeReportLoyaltyInfo", merchantTrandeReportLoyaltyInfo);
			jspData.put("merchantTrandeReportLoyaltyInfo", json.writeValueAsString(merchantTrandeReportLoyaltyInfo));
			/**
			 * 高管商旅信息
			 */
			ArrayList<Object> test = new ArrayList<>();
			pdfData.put("test", test);	//由于此模块没有表信息，用临时变量填充，使页面正常显示
			jspData.put("test", test);
			/**
			 * 特殊事项信息
			 */
			//违法违规裁判文书
			List<AgentJudgementDocumentEntity> agentJudgeDocInfo = this.getJudgeMentDocInfo(regId);
			pdfData.put("wfwgcpInfo", agentJudgeDocInfo);
			jspData.put("wfwgcpInfo", agentJudgeDocInfo);
			//违法违执行公告
			List<AgentCourEnforcementEntity> agentCoutEnforceInfo = this.getAgentCourForceInfo(regId);
			pdfData.put("agentCoutEnforceInfo", agentCoutEnforceInfo);
			jspData.put("agentCoutEnforceInfo", agentCoutEnforceInfo);
			//法定代表人失信裁判文书
			List<AgentTopLeaderJudgementDocumentEntity> agentTopLeaderJudgentDocInfo = this.getAgentTopleaderJudgentDocInfo(regId,"TOP_LEADER");
			pdfData.put("agentTopLeaderJudgentDocInfo", agentTopLeaderJudgentDocInfo);
			jspData.put("agentTopLeaderJudgentDocInfo", agentTopLeaderJudgentDocInfo);
			//法定代表人失信执行公告
			List<AgentTopLeaderExecuteDocEntity> agentTopLeaderEexdocInfo = this.getAgentTopleaderExdocInfo(regId,"TOP_LEADER");
			pdfData.put("fdrsxzxInfo", agentTopLeaderEexdocInfo);
			jspData.put("fdrsxzxInfo", agentTopLeaderEexdocInfo);
			//法定代表人失信公告
			List<AgentTopleaderDishonourNoticEntity> agentTopLeaderDishonourInfo = this.getAgentTopLeaderDishonourInfo(regId,"TOP_LEADER");
			pdfData.put("agentTopLeaderDishonourInfo", agentTopLeaderDishonourInfo);
			jspData.put("agentTopLeaderDishonourInfo", agentTopLeaderDishonourInfo);
			//法定代表人失信网贷黑名单
			List<AgentTopleaderNetloanEntity> agentTopLeaderNetloanInfo = this.getAgentTopLeaderNetLoanInfo(regId,"TOP_LEADER");
			pdfData.put("agentTopLeaderNetloanInfo", agentTopLeaderNetloanInfo);
			jspData.put("agentTopLeaderNetloanInfo", agentTopLeaderNetloanInfo);
			//法定代表人失信曝光台
			List<AgentTopleaderCourExposureEntity> agentTopLeaderCourtExposInfo = this.getAgentTopLeaderCourtExposInfo(regId,"TOP_LEADER");
			pdfData.put("agentTopLeaderCourtExposInfo", agentTopLeaderCourtExposInfo);
			jspData.put("agentTopLeaderCourtExposInfo", agentTopLeaderCourtExposInfo);
			//控股股东失信裁判文书
			List<AgentTopLeaderJudgementDocumentEntity> agentStockHolderJudgentDocInfo = this.getAgentTopleaderJudgentDocInfo(regId,"SHARE_CONTROLLER");
			pdfData.put("agentStockHolderJudgentDocInfo", agentStockHolderJudgentDocInfo);
			jspData.put("agentStockHolderJudgentDocInfo", agentStockHolderJudgentDocInfo);
			//控股股东失信执行公告
			List<AgentTopLeaderExecuteDocEntity> agentStockHolderEexdocInfo = this.getAgentTopleaderExdocInfo(regId,"SHARE_CONTROLLER");
			pdfData.put("agentStockHolderEexdocInfo", agentStockHolderEexdocInfo);
			jspData.put("agentStockHolderEexdocInfo", agentStockHolderEexdocInfo);
			//控股股东失信公告
			List<AgentTopleaderDishonourNoticEntity> agentStockHolderDishonourInfo = this.getAgentTopLeaderDishonourInfo(regId,"SHARE_CONTROLLER");
			pdfData.put("agentStockHolderDishonourInfo", agentStockHolderDishonourInfo);
			jspData.put("agentStockHolderDishonourInfo", agentStockHolderDishonourInfo);
			//控股股东失信网贷黑名单
			List<AgentTopleaderNetloanEntity> agentStockHolderNetloanInfo = this.getAgentTopLeaderNetLoanInfo(regId,"SHARE_CONTROLLER");
			pdfData.put("agentStockHolderNetloanInfo", agentStockHolderNetloanInfo);
			jspData.put("agentStockHolderNetloanInfo", agentStockHolderNetloanInfo);
			//控股股东失信曝光台
			List<AgentTopleaderCourExposureEntity> agentStockHolderCourtExposInfo = this.getAgentTopLeaderCourtExposInfo(regId,"SHARE_CONTROLLER");
			pdfData.put("agentStockHolderCourtExposInfo", agentStockHolderCourtExposInfo);
			jspData.put("agentStockHolderCourtExposInfo", agentStockHolderCourtExposInfo);
			//阿里欠贷
			List<AgentAliLoanbreakEntity> agentAliloadBreakInfo = this.getAgentAliloadBreakInfo(regId);
			pdfData.put("agentAliloadBreakInfo", agentAliloadBreakInfo);
			jspData.put("agentAliloadBreakInfo", agentAliloadBreakInfo);
			//其他不良网贷黑名单
			List<AgentTopleaderNetloanEntity> agentotherNetloanInfo = this.getAgentTopLeaderNetLoanInfo(regId,"OTHER");
			pdfData.put("agentotherNetloanInfo", agentotherNetloanInfo);
			jspData.put("agentotherNetloanInfo", agentotherNetloanInfo);
			// 法定代表人在其他机构任职信息
			List<LegPerInfoEntity> legPer1 = this.getLegPerInfoNew(regId);
			pdfData.put("legPerInfo1", legPer1);
			jspData.put("legPer1", legPer1);
			// 法定代表人股权投资信息
			List<OdsLegPerEquityEntity> legPer2 = this.getLegPerQuityInfo(regId);
			Double total = 0.0d;
			Double assets;
			Double cashCon;
			DecimalFormat df = new DecimalFormat("0.00%");
            df.setRoundingMode(RoundingMode.HALF_UP);
			for(OdsLegPerEquityEntity item : legPer2) {
				cashCon = item.getSubConam();
				total += (cashCon == null ? 0.0d : cashCon);
				assets = item.getRegCap();
				if(assets != null && assets!= 0.0d && cashCon != null) {
					item.setCashRate(df.format(cashCon/assets));
				} else {
					item.setCashRate("0.00%");
				}
			}
			String legPer2Total = legPer2.size() > 0 ? DecimalFormat.getNumberInstance().format(total) : "无投资金额";
			String legPer2Count = legPer2.size() > 0 ? String.valueOf(legPer2.size()) : "无";
			pdfData.put("legPer2Total", legPer2Total);
			pdfData.put("legPer2Count", legPer2Count);
			pdfData.put("legPerInfo2", legPer2);
			jspData.put("legPer2Total", legPer2Total);
			jspData.put("legPer2Count", legPer2Count);
			jspData.put("legPer2", legPer2);
			jspData.put("legPerJson1", json.writeValueAsString(legPer1)); //法定代表人在其他机构任职 详细信息
			jspData.put("legPerJson2", json.writeValueAsString(legPer2)); //法定代表人股权投资 详细信息
			// 转换为企业、机构类型名称
			String entStatus = Tools.customStatus(info.getStatus());
			pdfData.put("entStatus", entStatus);
			jspData.put("entStatus", entStatus);
			// 法院被执行信息
			List<SpecialInfoEntity> specialInfo = this.getSpecialInfo(regId);
			jspData.put("specialInfo", specialInfo);
			pdfData.put("specialInfo", specialInfo);
			// 评分指标信息
			List<BasicIndiScore> scoreWeight = new ArrayList<>();
			BasicIndiScore score = new BasicIndiScore();
			BasicIndiScore weight = new BasicIndiScore();
			scoreWeight.add(weight);
			scoreWeight.add(score);
			weight.setItemName("权重");
			score.setItemName("得分");
			for(IndicatorScoreWeight ind : inds) {
				Double s = ind.getLevel1Score() != null ? ind.getLevel1Score() : 0;
				Double w = ind.getLevel1Weight() != null ? ind.getLevel1Weight() : 0;
				switch (ind.getLevel1()) {
				case "基本信息":
					weight.setBase(df.format(w));
					score.setBase(s.toString());
					break;
				case "交易行为":
					weight.setBehavior(df.format(w));
					score.setBehavior(s.toString());
					break;
				case "履约能力":
					weight.setCapacity(df.format(w));
					score.setCapacity(s.toString());
					break;
				case "特殊事项":
					weight.setSpecial(df.format(w));
					score.setSpecial(s.toString());
					break;
				default:
					break;
				}
			}
			pdfData.put("scoreWeight", scoreWeight);
			jspData.put("basicIndiScore", json.writeValueAsString(scoreWeight));

			String fileNo = saveInfo.getFileNo();	// PDF报告编号 所有的历史数据都以此编号进行关联
			String filePath = this.createPdf(fileNo, createTime, rootPath, pdfData); //生成pdf文件并返回文件路径
			jspData.put("filePath", filePath);	//页面下载pdf时用到的文件路径
			saveInfo.setAgentName(info.getCompName());
			saveInfo.setTempletId(templetId);
			saveInfo.setAlgorithmType(algorithmType);
			saveInfo.setScoreVersion(agentScore.get("version"));
			saveInfo.setPath(filePath);
			
			/*-----------开始创建报告的历史数据-----------*/
			AgentInfoHisEntity agentHis = new AgentInfoHisEntity();
			BeanUtils.copyProperties(info, agentHis, "id");
			agentHis.setRegId(info.getRegId());
			agentHis.setFileNo(fileNo);
			agentHis.setCreateTime(createTime);
			agentHis.setScore(Integer.valueOf(agentScore.get("score")));
			agentHis.setLevel(agentScore.get("level"));
			agentHis.setLevelDesc(agentScore.get("levelDesc"));
			agentHis.setScore1(scoreMap.get("score1"));
			agentHis.setScore2(scoreMap.get("score2"));
			agentHis.setScore1Per(scoreMap.get("score1Per"));
			agentHis.setScore2Per(scoreMap.get("score2Per"));
			agentHis.setScore1Weight(scoreMap.get("score1Weight"));
			agentHis.setScore2Weight(scoreMap.get("score2Weight"));
			jspData.put("data", agentHis);	// 基本信息
			// 得分 权重
			List<BasicIndiScoreHisEntity> basicIndi = new ArrayList<>();
			BasicIndiScoreHisEntity weightHis = new BasicIndiScoreHisEntity(regId, fileNo, createTime);
			BasicIndiScoreHisEntity scoreHis = new BasicIndiScoreHisEntity(regId, fileNo, createTime);
			BeanUtils.copyProperties(weight, weightHis);
			BeanUtils.copyProperties(score, scoreHis);
			basicIndi.add(weightHis);
			basicIndi.add(scoreHis);
			// 联系地址和电话信息(历史纪录)
			List<EntAttrInfoHisEntity> entAttrHis = new ArrayList<>();
			EntAttrInfoHisEntity entHis;
			for(EntAttrInfoEntity ent : entAttrInfo) {
				entHis = new EntAttrInfoHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(ent, entHis, "id");
				entAttrHis.add(entHis);
			}
			// 股东信息(历史纪录)
			List<StockholderInfoHisEntity> stockholderHis = new ArrayList<>();
			StockholderInfoHisEntity stocHis;
			for(StockholderInfoEntity stoc : stockholderInfo) {
				stocHis = new StockholderInfoHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(stoc, stocHis, "id");
				stockholderHis.add(stocHis);
			}
			
			// 法人在其他机构任职(历史纪录)
			List<LegPerInfoHisEntity> legperHis = new ArrayList<>();
			for (LegPerInfoEntity stoc : legPer1) {
				LegPerInfoHisEntity his = new LegPerInfoHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(stoc, his, "id");
				legperHis.add(his);
			}
			
			// 法人对外投资信息(历史纪录)
			List<OdsLegPerEquityHisEntity> legperQuityHis = new ArrayList<>();
			for (OdsLegPerEquityEntity stoc : legPer2) {
				OdsLegPerEquityHisEntity his = new OdsLegPerEquityHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(stoc, his, "id");
				legperQuityHis.add(his);
			}
			// 高管信息(历史纪录)
			List<TopManagerInfoHisEntity> topManagerHis = new ArrayList<>();
			TopManagerInfoHisEntity topmHis;
			for(TopManagerInfoEntity topm : topManagerInfo) {
				topmHis = new TopManagerInfoHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(topm, topmHis, "id");
				topManagerHis.add(topmHis);
			}
			// 对外股权投资信息(历史纪录)
			List<OthEntInvestsInfoHisEntity> othEntInvestsHis = new ArrayList<>();
			OthEntInvestsInfoHisEntity otheHis;
			for(OthEntInvestsInfoEntity othe : othEntInvestsInfo) {
				otheHis = new OthEntInvestsInfoHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(othe, otheHis, "id");
				othEntInvestsHis.add(otheHis);
			}
			// 法院被执行信息(历史纪录)
			List<SpecialInfoHisEntity> specHisList = new ArrayList<>();
			for(SpecialInfoEntity spec : specialInfo) {
				SpecialInfoHisEntity his = new SpecialInfoHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(spec, his, "id");
				specHisList.add(his);
			}
			// 企业变更(历史纪录)
			List<AgentChangeHisEntity> agentChangeHisList = new ArrayList<>();
			for(AgentChangeEntity atc : agentChangeInfo) {
				AgentChangeHisEntity agentChangeHis = new AgentChangeHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(atc, agentChangeHis, "id");
				agentChangeHisList.add(agentChangeHis);
			}
			// 分支结构(历史纪录)
			List<AgentFiliationHisEntity> agentFiliationHisList = new ArrayList<>();
			for(AgentFiliationEntity afc : agentFiliationInfo) {
				AgentFiliationHisEntity agentFiliationHis = new AgentFiliationHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(afc, agentFiliationHis, "id");
				agentFiliationHisList.add(agentFiliationHis);
			}
			// 清算(历史纪录)
			List<AgentLiquidationHisEntity> agentLiquidationHisList = new ArrayList<>();
			for(AgentLiquidationEntity atc : liquidationInfo) {
				AgentLiquidationHisEntity agentLiquiHis = new AgentLiquidationHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(atc, agentLiquiHis, "id");
				agentLiquidationHisList.add(agentLiquiHis);
			}
			// 动产抵押(历史纪录)
			List<AgentMortgageHisEntity> agentMortgageHisList = new ArrayList<>();
			for(AgentMortgageEntity atc : agentMortgageInfo) {
				AgentMortgageHisEntity agentMortHis = new AgentMortgageHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(atc, agentMortHis, "id");
				agentMortgageHisList.add(agentMortHis);
			}
			// 动产抵押物(历史纪录)
			List<MortgageItemHisEntity> mortgageItemHisList = new ArrayList<>();
			for(MortgageItemEntity atc : mortgageItemInfo) {
				MortgageItemHisEntity mortItemHis = new MortgageItemHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(atc, mortItemHis, "id");
				mortgageItemHisList.add(mortItemHis);
			}
			// 股权冻结(历史纪录)
			List<AgentSharesFroHisEntity> agentSharesHisList = new ArrayList<>();
			for(AgentSharesFroEntity atc : agentSharesInfo) {
				AgentSharesFroHisEntity mortItemHis = new AgentSharesFroHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(atc, mortItemHis, "id");
				agentSharesHisList.add(mortItemHis);
			}
			// 股权出质(历史纪录)
			List<AgentSharesImpawnHisEntity> agentSharesImpawHisList = new ArrayList<>();
			for(AgentSharesImpawnEntity atc : agentSharesImpawInfo) {
				AgentSharesImpawnHisEntity mortItemHis = new AgentSharesImpawnHisEntity(fileNo, createTime);
				 BeanUtils.copyProperties(atc, mortItemHis, "id");
				 agentSharesImpawHisList.add(mortItemHis);
			}
			// 资产负债(历史纪录)
			List<OdsBalanceSheetHisEntity> odsBanlanceSheetHisList = new ArrayList<>();
			for (OdsBalanceSheetEntity atc : balanceSheetInfo) {
				OdsBalanceSheetHisEntity his = new OdsBalanceSheetHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(atc, his, "id");
				odsBanlanceSheetHisList.add(his);
			}
			// 资产负债(历史纪录)
			List<OdsProfitHisEntity> odsProfitHisList = new ArrayList<>();
			for (OdsProfitEntity atc : profitInfo) {
				OdsProfitHisEntity his = new OdsProfitHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(atc, his, "id");
				odsProfitHisList.add(his);
			}
			// 税务信息(历史纪录)
			List<AgentTaxAccountHisEntity> agentTaxAccountHisList = new ArrayList<>();
			for (AgentTaxAccountEntity atc : agentTaxAccountInfo) {
				AgentTaxAccountHisEntity his = new AgentTaxAccountHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(atc, his, "id");
				agentTaxAccountHisList.add(his);
			}
			// 经营变化趋势(历史纪录)
			List<MerchantTrandeReportChangeHis> merchantReportChangeHisList = new ArrayList<>();
			for (MerchantTrandeReportChange atc : merchantTrandeReportChangeInfo) {
				MerchantTrandeReportChangeHis his = new MerchantTrandeReportChangeHis(fileNo, createTime);
				BeanUtils.copyProperties(atc, his, "id");
				merchantReportChangeHisList.add(his);
			}
			// 本市同行对比(历史纪录)
			List<MerchantTrandeReportConstrastHis> merchantReportConstrastHisList = new ArrayList<>();
			for (MerchantTrandeReportConstrast atc : merchantTrandeReportConstrastInfo) {
				MerchantTrandeReportConstrastHis his = new MerchantTrandeReportConstrastHis(fileNo, createTime);
				BeanUtils.copyProperties(atc, his, "id");
				merchantReportConstrastHisList.add(his);
			}
			// 客户地域分布(历史纪录)
			List<MerchantTrandeReportAreaHis> merchantReportAreaHisList = new ArrayList<>();
			for (MerchantTrandeReportArea atc : merchantTrandeReportAreaInfo) {
				MerchantTrandeReportAreaHis his = new MerchantTrandeReportAreaHis(fileNo, createTime);
				BeanUtils.copyProperties(atc, his, "id");
				merchantReportAreaHisList.add(his);
			}
			// 客户忠诚度(历史纪录)
			List<MerchantTrandeReportLoyaltyHis> merchantReportLoyalHisList = new ArrayList<>();
			for (MerchantTrandeReportLoyalty atc : merchantTrandeReportLoyaltyInfo) {
				MerchantTrandeReportLoyaltyHis his = new MerchantTrandeReportLoyaltyHis(fileNo, createTime);
				BeanUtils.copyProperties(atc, his, "id");
				merchantReportLoyalHisList.add(his);
			}
			// 异常交易(历史纪录)
			List<MerchantTradeReportAbormalHis> merchantReportAbormalHisList = new ArrayList<>();
			for (MerchantTradeReportAbormal atc : merchantTradeAbormalInfo) {
				MerchantTradeReportAbormalHis his = new MerchantTradeReportAbormalHis(fileNo, createTime);
				BeanUtils.copyProperties(atc, his, "id");
				merchantReportAbormalHisList.add(his);
			}
			// 违法违规裁判文书(历史纪录)
			List<AgentJudgementDocumentHisEntity> agentjudgeDocHisList = new ArrayList<>();
			for(AgentJudgementDocumentEntity atc : agentJudgeDocInfo) {
				AgentJudgementDocumentHisEntity juddocHis = new AgentJudgementDocumentHisEntity(fileNo, createTime);
				 BeanUtils.copyProperties(atc, juddocHis, "id");
				 agentjudgeDocHisList.add(juddocHis);
			}
			// 违法违规执行公告(历史纪录)
			List<AgentCourEnforcementHisEntity> agentCoutEnforceeHisList = new ArrayList<>();
			for(AgentCourEnforcementEntity atc : agentCoutEnforceInfo) {
				AgentCourEnforcementHisEntity juddocHis = new AgentCourEnforcementHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(atc, juddocHis, "id");
				agentCoutEnforceeHisList.add(juddocHis);
			}
			// 法定代表人失信裁判文书(历史纪录)
			List<AgentTopLeaderJudgementDocumentHisEntity> agentTopLeaderJudgmentDocHisList = new ArrayList<>();
			for(AgentTopLeaderJudgementDocumentEntity atc : agentTopLeaderJudgentDocInfo) {
				AgentTopLeaderJudgementDocumentHisEntity juddocHis = new AgentTopLeaderJudgementDocumentHisEntity(fileNo,createTime);
				BeanUtils.copyProperties(atc, juddocHis, "id");
				agentTopLeaderJudgmentDocHisList.add(juddocHis);
			}
			// 法定代表人失信执行公告(历史纪录)
			List<AgentTopLeaderExecuteDocHisEntity> agentTopLeaderExdocHisList = new ArrayList<>();
			for (AgentTopLeaderExecuteDocEntity atc : agentTopLeaderEexdocInfo) {
				AgentTopLeaderExecuteDocHisEntity juddocHis = new AgentTopLeaderExecuteDocHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(atc, juddocHis, "id");
				agentTopLeaderExdocHisList.add(juddocHis);
			}
			// 法定代表人失信公告(历史纪录)
			List<AgentTopleaderDishonourNoticHisEntity> agentTopLeaderDishonourHisList = new ArrayList<>();
			for (AgentTopleaderDishonourNoticEntity atc : agentTopLeaderDishonourInfo) {
				AgentTopleaderDishonourNoticHisEntity juddocHis = new AgentTopleaderDishonourNoticHisEntity(fileNo,
						createTime);
				BeanUtils.copyProperties(atc, juddocHis, "id");
				agentTopLeaderDishonourHisList.add(juddocHis);
			}
			// 法定代表人失信网贷黑名单(历史纪录)
			List<AgentTopleaderNetloanHisEntity> agentTopLeaderNetloadHisList = new ArrayList<>();
			AgentTopleaderNetloanHisEntity netloadHis;
			for (AgentTopleaderNetloanEntity atc : agentTopLeaderNetloanInfo) {
				netloadHis = new AgentTopleaderNetloanHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(atc, netloadHis, "id");
				agentTopLeaderNetloadHisList.add(netloadHis);
			}
			// 法定代表人失信曝光台(历史纪录)
			List<AgentTopleaderCourExposureHisEntity> agentTopLeaderCourtExposHisList = new ArrayList<>();
			AgentTopleaderCourExposureHisEntity courtExposHis;
			for (AgentTopleaderCourExposureEntity atc : agentTopLeaderCourtExposInfo) {
				courtExposHis = new AgentTopleaderCourExposureHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(atc, courtExposHis, "id");
				agentTopLeaderCourtExposHisList.add(courtExposHis);
			}
			// 阿里欠贷(历史纪录)
			List<AgentAliLoanbreakHisEntity> agentAliloadBreakHisList = new ArrayList<>();
			for (AgentAliLoanbreakEntity atc : agentAliloadBreakInfo) {
				AgentAliLoanbreakHisEntity aliHis = new AgentAliLoanbreakHisEntity(fileNo, createTime);
				BeanUtils.copyProperties(atc, aliHis, "id");
				agentAliloadBreakHisList.add(aliHis);
			}
			// 核心经营(历史纪录)
			List<MerchantTrandeReportBaseHis> merchantTradList = new ArrayList<>();
			for (MerchantTrandeReportBase atc : merchantTradeInfo) {
				MerchantTrandeReportBaseHis hisEntity = new MerchantTrandeReportBaseHis(fileNo, createTime);
				BeanUtils.copyProperties(atc, hisEntity, "id");
				merchantTradList.add(hisEntity);
			}
			// 经营稳定性(历史纪录)
			List<MerchantTrandeReportStabilityHis> merchantStabilityList = new ArrayList<>();
			for (MerchantTrandeReportStability atc : merchantStabilityInfo) {
				MerchantTrandeReportStabilityHis hisEntity = new MerchantTrandeReportStabilityHis(fileNo, createTime);
				BeanUtils.copyProperties(atc, hisEntity, "id");
				merchantStabilityList.add(hisEntity);
			}
			agentHis.setEntAttrInfos(entAttrHis);
			agentHis.setStockholderInfos(stockholderHis);
			agentHis.setTopManagerInfos(topManagerHis);
			agentHis.setLegPerInfos(legperHis);
			agentHis.setLegPerQuityInfos(legperQuityHis);
			agentHis.setOthEntInvestsInfos(othEntInvestsHis);
			agentHis.setSpecialInfos(specHisList);
			agentHis.setBasicIndiScore(basicIndi);
			agentHis.setChangeInfos(agentChangeHisList);
			agentHis.setFiliationInfos(agentFiliationHisList);
			agentHis.setLiquidataInfos(agentLiquidationHisList);
			agentHis.setMortgageInfos(agentMortgageHisList);
			agentHis.setMortgageItemInfos(mortgageItemHisList);
			agentHis.setAgentSharesInfos(agentSharesHisList);
			agentHis.setAgentSharesImpawnInfos(agentSharesImpawHisList);
			agentHis.setAgentJudgedocInfos(agentjudgeDocHisList);
			agentHis.setAgentCoutEnforceInfos(agentCoutEnforceeHisList);
			agentHis.setAgentTopleaderExdocInfos(agentTopLeaderExdocHisList);
			agentHis.setAgentTopleaderDishonourInfos(agentTopLeaderDishonourHisList);
			agentHis.setAgentTopleaderNetloadInfos(agentTopLeaderNetloadHisList);
			agentHis.setAgentTopleaderCourtExposInfos(agentTopLeaderCourtExposHisList);
			agentHis.setAgentAliloadBreakInfos(agentAliloadBreakHisList);
			agentHis.setMerchantTradeInfos(merchantTradList);
			agentHis.setMerchantStabilityInfos(merchantStabilityList);
			agentHis.setAgentTaxAccoutInfos(agentTaxAccountHisList);
			agentHis.setMerchantReportChangeInfos(merchantReportChangeHisList);
			agentHis.setMerchantReportConstrastInfos(merchantReportConstrastHisList);
			agentHis.setMerchantReportAreaInfos(merchantReportAreaHisList);
			agentHis.setMerchantReportLoyalInfos(merchantReportLoyalHisList);
			agentHis.setAgentTopleaderJudgmentDocInfos(agentTopLeaderJudgmentDocHisList);
			agentHis.setMerchantReportAbormalInfos(merchantReportAbormalHisList);
			agentHis.setOdsBalanceSheetInfos(odsBanlanceSheetHisList);
			agentHis.setOdsProfitInfos(odsProfitHisList);
			companyHisDao.save(agentHis);	//保存企业的历史基本信息
			saveInfoDao.update(saveInfo);	//保存征信报告信息
		} catch (Exception e) {
			String error = "生成征信报告出错";
			log.error(error, e);
			throw new BusinessException(error);
		}
		return jspData;	//成功后返回jsp页面数据
	}
	
	/**
	 * 生成征信报告的PDF文件
	 * @param fileNo	文件编号
	 * @param createTime生成时间
	 * @param rootPath	生成的pdf的根目录
	 * @param pdfData	pdf文件内容
	 * @return
	 */
	private String createPdf(String fileNo, Date createTime, String rootPath, 
			Map<String, Object> pdfData) {
		ReportPdfUtils pdf = new ReportPdfUtils(fileNo, createTime, rootPath);
		pdf.setPdfData(pdfData);	// 设置pdf数据
		pdf.createPdf("report.htm");
		return pdf.getPdfPath();	// 征信报告的pdf文件地址
	}
	
	// 分页查询征信报告
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getPageReport(QueryParam queryParam, String regId) throws SQLException {
	    Map<String, Object> pageReport = null;
	    try {
            pageReport = saveInfoDao.getPageReport(queryParam, regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
	    return pageReport;
	}
	
	// 获取报告最大编号 加上同步锁 避免编号重复
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public synchronized SaveInfoEntity createMaxIndexReport(String regId, Date date) {
		SaveInfoEntity saveInfo = null;
        try {
            saveInfo = saveInfoDao.createMaxIndexReport(regId, date);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return saveInfo;
	}
	
	// 查询所有报告模板
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<ReportTempletEntity> getAllReportTemp() {
		List<ReportTempletEntity> list = null;
        try {
            list = saveInfoDao.getAllReportTemp();
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	// 根据模板ID查询显示模块列表
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getTempletById(Integer templetId, boolean isCreate) throws BusinessException {
		ReportTempletEntity templet = null;
        try {
            templet = saveInfoDao.getTempletById(templetId, isCreate);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		Map<String, Object> data = new HashMap<>();
		List<ReportTitleVo> templetList;
		List<String> declareList = new ArrayList<>();
		data.put("declareList", declareList);
		
		if(templet != null) {
			data.put("type", templet.getType());
			String jsonStr = templet.getModuleList();
			String declareStr = templet.getDeclare();
			JSONParser parser = new JSONParser(jsonStr);
			Map<String, Object> rs = parser.parseMap();
			data.put("templetMap", rs);
			try {
				List<ReportTitle> allTitle = saveInfoDao.getReportTitle();
				List<ReportTitle> selectTitle = new ArrayList<>();
				String key;
				for(ReportTitle r : allTitle) {
					key = (String) rs.get(r.getKeyName());
					if(key != null) {
						r.setName(key);
						selectTitle.add(r);
					}
				}
				templetList = buildHierarchical(selectTitle, new HashMap<Integer, List<ReportTitle>>(), true);
				data.put("templetList", templetList);
			} catch (DataAccessException e) {
				log.error(e.getMessage(), e);
				throw new BusinessException();
			}
			if(declareStr != null) {
				String[] arr = declareStr.split("\\n");
				for(String d : arr) {
					declareList.add(d);
				}
			}
		}
		return data;
	}
	
	/**
	 * 构建报告标题的层级结构
	 * @param reportTitle
	 * @param map
	 * @param isTop
	 * @return
	 */
	private List<ReportTitleVo> buildHierarchical(List<ReportTitle> reportTitle, Map<Integer, List<ReportTitle>> map, boolean isTop) {
		List<ReportTitle> child = new ArrayList<>();
		List<ReportTitleVo> rs = new ArrayList<>();
		for(ReportTitle title : reportTitle) {
			if(isTop) {
				if(title.getParentId() == 0) {
					child.add(title);
					continue;
				}
				List<ReportTitle> group = map.get(title.getParentId());
                if(group == null) {     // 创建一个分组，并添加进组容器map中
                    group = new ArrayList<ReportTitle>();
                    group.add(title);
                    map.put(title.getParentId(), group);
                } else {
                    group.add(title);
                }
			} else {
				child.add(title);
			}
		}
		ReportTitleVo rtv;
		for(ReportTitle t : child) {
			rtv = new ReportTitleVo();
			rtv.setKey(t.getKeyName());
			rtv.setName(t.getName());
			for(Integer id : map.keySet()) {
				if(id - t.getId() == 0) {
					List<ReportTitleVo> c = buildHierarchical(map.remove(id), map, false);
					rtv.setChildren(c);
					break;
				}
			}
			rs.add(rtv);
		}
		return rs;
	}
	
	// 转换信用评分信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, String> convertCreditScore(IndicatorScoreWeight sw) {
		Map<String, String> rs = new HashMap<>();
		rs.put("level", "未能做出评定");
		if(sw == null) {
			rs.put("score", "0");
			return rs;
		}
		Map<String, Object> rsMap = companyDao.getEnableScore();
		Double score = sw.getScore();
		if(score == null || score < 0) {
			score = 0.0d;
		}
		String scoreStr = new BigDecimal(score).setScale(0, BigDecimal.ROUND_HALF_UP).toString();
		score = Double.parseDouble(scoreStr);
		rs.put("score", scoreStr);
		if(rsMap == null || rsMap.get("list") == null) {
			return rs;
		}
		@SuppressWarnings("unchecked")
		List<ScoreLevelEntity> list = (List<ScoreLevelEntity>) rsMap.get("list");
		rs.put("version", "V" + rsMap.get("version"));
		
		for(ScoreLevelEntity sle : list) {
			if(score <= sle.getLevelScoreMax() && score >= sle.getLevelScoreMin()) {
				rs.put("level", sle.getLevelName());
				rs.put("levelDesc", "（" + sle.getLevelDesc() + "）");
				break;
			}
		}
		return rs;
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public AgentInfoEntity getAgentInfoById(String regId) {
        List<AgentInfoEntity> list = companyDao.findBy("regId", regId);
        AgentInfoEntity agent = null;
        if(list != null && list.size() > 0) {
        	agent = list.get(0);
        	if(agent.getCurType()!=null){
        		try {
                    agent.setCurTypeName(companyHisDao.getCurTypeName(agent.getCurType()));
                } catch (DataAccessException e) {
                    log.error(e.getMessage(), e);
                }
        	}
        }
        return agent;
    }
	// 企业报告历史信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public AgentInfoHisEntity getAgentInfoHis(String id, String fileNo) {
	    try {
            return companyHisDao.getAgentInfoHis(id, fileNo);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return null;
	}
	
	// 企业地址和电话信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<EntAttrInfoEntity> getEntAttrInfo(String id) {
	    try {
            return companyDao.getEntAttrInfo(id);
        }  catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return null;
	}

	// 股东信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<StockholderInfoEntity> getStockholderInfo(String id) {
		List<StockholderInfoEntity> list = null;
        try {
            list = companyDao.getStockholderInfo(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}

	// 高管信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<TopManagerInfoEntity> getTopManagerInfo(String id) {
	    List<TopManagerInfoEntity> topManagerInfo = null;
	    try {
            topManagerInfo = companyDao.getTopManagerInfo(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return topManagerInfo;
	}

	// 对外股权投资信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OthEntInvestsInfoEntity> getOthEntInvestsInfo(String id) {
	    List<OthEntInvestsInfoEntity> othEntInvestsInfo = null;
	    try {
            othEntInvestsInfo = companyDao.getOthEntInvestsInfo(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return othEntInvestsInfo;
	}
	
	//法人在其他机构任职信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<LegPerInfoEntity> getLegPerInfoNew(String regId) {
		List<LegPerInfoEntity> othEntInvestsInfo = null;
	    try {
            othEntInvestsInfo = companyDao.getLegPerNewInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return othEntInvestsInfo;
	}
	
	// 法定代表人（全部类型）
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<LegPerInfoEntity> getLegPerInfo(String id) {
		List<LegPerInfoEntity> list = null;
        try {
            list = companyDao.getLegPerInfo(id, null);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
		
	// 法定代表人（在其他机构任职信息/股权投资信息）
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<LegPerInfoEntity> getLegPerInfo(String id,Integer type) {
		List<LegPerInfoEntity> list = null;
        try {
            list = companyDao.getLegPerInfo(id, type);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	// 法定代表人投资信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsLegPerEquityEntity> getLegPerQuityInfo(String id) {
		List<OdsLegPerEquityEntity> list = null;
        try {
            list = companyDao.getLegPerQuityInfo(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}

	// 法院被执行信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<SpecialInfoEntity> getSpecialInfo(String regId) {
		List<SpecialInfoEntity> list = null;
        try {
            list = companyDao.getSpecialInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	// 企业变更信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentChangeEntity> getAgentChangeInfo(String id) 
	{
		List<AgentChangeEntity> list = null;
	       try {
	           list = companyDao.getAgentChangeInfo(id);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}
	
	//分支机构信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentFiliationEntity> getAgentFiliationInfo(String id) 
	{
		List<AgentFiliationEntity> list = null;
	       try {
	           list = companyDao.getAgentFliliationInfo(id);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}
		
	//清算信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentLiquidationEntity> getLiquidationInfo(String regId)
	{
		List<AgentLiquidationEntity> list = null;
	       try {
	           list = companyDao.getAgentLiquidationInfo(regId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//动产抵押信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentMortgageEntity> getAgentMortgageInfo(String regId) {
		List<AgentMortgageEntity> list = null;
	       try {
	           list = companyDao.getAgentMortgageInfo(regId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}
		
	//动产抵押物信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<MortgageItemEntity> getMortgageItemInfo(String regId) {
		List<MortgageItemEntity> list = null;
        try {
            list = companyDao.getMortgageItemInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//股权冻结历史
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentSharesFroEntity> getAgentSharesInfo(String regId) {
		List<AgentSharesFroEntity> list = null;
        try {
            list = companyDao.getAgentSharesInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//股权出质信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentSharesImpawnEntity> getAgentSharesImpawInfo(String regId) {
		List<AgentSharesImpawnEntity> list = null;
        try {
            list = companyDao.getAgentSharesImpawInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//税务信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentTaxAccountEntity> getAgentTaxAccountInfo(String id) {
		List<AgentTaxAccountEntity> list = null;
        try {
            list = companyDao.getAgentTaxAccoutInfo(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//经营变化趋势信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<MerchantTrandeReportChange> getMerchantChangeInfo(String id) {
		List<MerchantTrandeReportChange> list = null;
        try {
            list = companyDao.getMerchantTrandeReportChangeInfo(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//本市同行对比
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<MerchantTrandeReportConstrast> getMerchantConstrastInfo(String regId) {
		List<MerchantTrandeReportConstrast> list = null;
        try {
            list = companyDao.getMerchantTrandeReportConstrastInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//客户地域分布
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<MerchantTrandeReportArea> getMerchantAreaInfo(String regId) {
		List<MerchantTrandeReportArea> list = null;
        try {
            list = companyDao.getMerchantTrandeReportAreaInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//客户忠诚度
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<MerchantTrandeReportLoyalty> getMerchantLoyaltyInfo(String regId) {
		List<MerchantTrandeReportLoyalty> list = null;
        try {
            list = companyDao.getMerchantTrandeReportLoyalInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	//违法违规裁判文书
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentJudgementDocumentEntity> getJudgeMentDocInfo(String regId) {
		List<AgentJudgementDocumentEntity> list = null;
        try {
            list = companyDao.getAgentJudgeMentDocInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//违法违规执行公告
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentCourEnforcementEntity> getAgentCourForceInfo(String regId) {
		List<AgentCourEnforcementEntity> list = null;
        try {
            list = companyDao.getAgentCoutEnforceInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//法定代表人失信裁判文书
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentTopLeaderJudgementDocumentEntity> getAgentTopleaderJudgentDocInfo(String id,String userType) {
		List<AgentTopLeaderJudgementDocumentEntity> list = null;
        try {
            list = companyDao.getAgentTopLeaderJudgmentDocInfo(id,userType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//法定代表人失信执行公告
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentTopLeaderExecuteDocEntity> getAgentTopleaderExdocInfo(String regId,String userType) {
		List<AgentTopLeaderExecuteDocEntity> list = null;
        try {
            list = companyDao.getAgentTopLeaderExdocInfo(regId,userType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//法定代表人失信公告
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentTopleaderDishonourNoticEntity> getAgentTopLeaderDishonourInfo(String regId,String userType) {
		List<AgentTopleaderDishonourNoticEntity> list = null;
        try {
            list = companyDao.getAgentTopLeaderDishonourInfo(regId,userType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//法定代表人失信网贷黑名单
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentTopleaderNetloanEntity> getAgentTopLeaderNetLoanInfo(String regId,String userType) {
		List<AgentTopleaderNetloanEntity> list = null;
        try {
            list = companyDao.getAgentTopLeaderNetLoanInfo(regId,userType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//法定代表人失信曝光台
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentTopleaderCourExposureEntity> getAgentTopLeaderCourtExposInfo(String regId,String userType) {
		List<AgentTopleaderCourExposureEntity> list = null;
        try {
            list = companyDao.getAgentTopLeaderCourtExposInfo(regId,userType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//阿里欠贷
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentAliLoanbreakEntity> getAgentAliloadBreakInfo(String regId) {
		List<AgentAliLoanbreakEntity> list = null;
        try {
            list = companyDao.getAgentAliloadBreakInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//核心经营信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<MerchantTrandeReportBase> getMerchantTradeInfo(String regId) {
		List<MerchantTrandeReportBase> list = null;
        try {
            list = companyDao.getAgentMerchantTradeInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//经营稳定性指标
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<MerchantTrandeReportStability> getMerchantStabilityInfo(String regId) {
		List<MerchantTrandeReportStability> list = null;
        try {
            list = companyDao.getAgentMerchantStabilityInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//月异常信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<MerchantTradeReportAbormal> getMerchantAbormalInfo(String id) {
		List<MerchantTradeReportAbormal> list = null;
        try {
            list = companyDao.getAgentMerchantAbormalInfo(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	//资产负债
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsBalanceSheetEntity> getBalanceSheetInfo(String regId) {
		List<OdsBalanceSheetEntity> list = null;
        try {
            list = companyDao.getBalanceSheetInfo(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	
	//利润表
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsProfitEntity> getProfitInfo(String id) {
		List<OdsProfitEntity> list = null;
        try {
            list = companyDao.getProfitInfo(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	// 股东信息  -- 历史
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<StockholderInfoHisEntity> getStockholderInfoHis(String fileNo) {
		List<StockholderInfoHisEntity> list = null;
        try {
            list = companyHisDao.getStockholderInfoHis(fileNo);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	// 资产负债 -- 历史
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsBalanceSheetHisEntity> getBalanceSheetInfoHis(String fileNo) {
		List<OdsBalanceSheetHisEntity> list = null;
		try {
			list = companyHisDao.getBalanceHisInfoHis(fileNo);
		} catch (DataAccessException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
		return list;
	}
	
	// 法定代表人（全部类型） -- 历史
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<LegPerInfoHisEntity> getLegPerInfoHis(String fileNo) {
		List<LegPerInfoHisEntity> list = null;
        try {
            list = companyHisDao.getLegPerInfoHis(fileNo);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	// 法院被执行信息 -- 历史
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<SpecialInfoHisEntity> getSpecialInfoHis(String fileNo, Integer type) {
		List<SpecialInfoHisEntity> list = null;
        try {
            list = companyHisDao.getSpecialInfoHis(fileNo, type);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	
	// 裁判文书信息 -- 历史
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentTopLeaderJudgementDocumentHisEntity> getJudgementDocmentInfoHis(String fileNo,String userType) {
		List<AgentTopLeaderJudgementDocumentHisEntity> list = null;
        try {
            list = companyHisDao.getJudgementDocmentInfoHis(fileNo,userType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	// 执行公告 -- 历史
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentTopLeaderExecuteDocHisEntity> getExecuteDocInfoHis(String fileNo, String userType) {
		// TODO Auto-generated method stub
		List<AgentTopLeaderExecuteDocHisEntity> list = null;
        try {
            list = companyHisDao.getJExecuteDocInfoHis(fileNo,userType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}

	// 失信公告 -- 历史
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentTopleaderDishonourNoticHisEntity> getDishonourNoticeInfoHis(String fileNo, String userType) {
		// TODO Auto-generated method stub
		List<AgentTopleaderDishonourNoticHisEntity> list = null;
        try {
            list = companyHisDao.getDishonourNoticeInfoHis(fileNo,userType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}

	
	// 网贷黑名单 -- 历史
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentTopleaderNetloanHisEntity> getNetloadInfoHis(String fileNo, String userType) {
		// TODO Auto-generated method stub
		List<AgentTopleaderNetloanHisEntity> list = null;
        try {
            list = companyHisDao.getNetloadInfoHis(fileNo,userType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}

	// 曝光台 -- 历史
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AgentTopleaderCourExposureHisEntity> getExposureInfoHis(String fileNo, String userType) {
		// TODO Auto-generated method stub
		List<AgentTopleaderCourExposureHisEntity> list = null;
        try {
            list = companyHisDao.getCourExposureInfoHis(fileNo,userType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
	
	// 法人投资 -- 历史
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsLegPerEquityHisEntity> getLegPerQuityHis(String fileNo) {
		List<OdsLegPerEquityHisEntity> list = null;
        try {
            list = companyHisDao.getLegPerQuityInfoHis(fileNo);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}

	
	// 法人任职 -- 历史
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<LegPerInfoHisEntity> getLegPerInfoHisNew(String fileNo) {
		List<LegPerInfoHisEntity> list = null;
        try {
            list = companyHisDao.getLegPerInfoNewHis(fileNo);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}
}