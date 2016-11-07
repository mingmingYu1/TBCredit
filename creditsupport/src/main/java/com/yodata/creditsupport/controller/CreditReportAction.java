package com.yodata.creditsupport.controller;

import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yodata.core.control.BasicAction;
import com.yodata.creditsupport.orm.entity.AgentFiliationEntity;
import com.yodata.creditsupport.orm.entity.AgentInfoEntity;
import com.yodata.creditsupport.orm.entity.AgentMortgageEntity;
import com.yodata.creditsupport.orm.entity.AgentSharesFroEntity;
import com.yodata.creditsupport.orm.entity.LegPerInfoEntity;
import com.yodata.creditsupport.orm.entity.OdsLegPerEquityEntity;
import com.yodata.creditsupport.orm.entity.ReportTempletEntity;
import com.yodata.creditsupport.orm.entity.SaveInfoEntity;
import com.yodata.creditsupport.orm.entity.SpecialInfoEntity;
import com.yodata.creditsupport.orm.entity.StockholderInfoEntity;
import com.yodata.creditsupport.orm.entity.his.AgentInfoHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopLeaderExecuteDocHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopLeaderJudgementDocumentHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopleaderCourExposureHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopleaderDishonourNoticHisEntity;
import com.yodata.creditsupport.orm.entity.his.AgentTopleaderNetloanHisEntity;
import com.yodata.creditsupport.orm.entity.his.LegPerInfoHisEntity;
import com.yodata.creditsupport.orm.entity.his.OdsLegPerEquityHisEntity;
import com.yodata.creditsupport.orm.entity.his.StockholderInfoHisEntity;
import com.yodata.creditsupport.orm.vo.IndicatorScoreWeight;
import com.yodata.creditsupport.service.ICreditReportService;
import com.yodata.creditsupport.service.IDictService;
import com.yodata.creditsupport.service.IIndicatorScoreService;
import com.yodata.creditsupport.util.QueryParam;
import com.yodata.creditsupport.util.Tools;
import com.yodata.creditsupport.util.Validator;

@Controller
@RequestMapping("/creditReport")
public class CreditReportAction extends BasicAction {

	private final Log log= LogFactory.getLog(CreditReportAction.class);
	
	@Resource
	private ICreditReportService creditReportService;
	@Resource
	private IIndicatorScoreService indicatorScoreService;
	
	@Resource
    private IDictService dictService;
	
	@RequestMapping(value="/queryReportTemplet",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public Map<String, Object> getReportTemplet() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ReportTempletEntity> list = creditReportService.getAllReportTemp();
		result.put("rows", list);
		return result;
	}
	
	@RequestMapping(value="/query",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> queryReport(@RequestParam(required=false) Integer offset,
    		@RequestParam(required=false) Integer limit){
		
		Map<String, Object> result = new HashMap<String, Object>();
    	Map<String, Object> map;
		try {
		    //查询分页条件
			String fileNo = request.getParameter("fileNo");
			if(!StringUtils.isEmpty(fileNo) && !Validator.isFileNo(fileNo)) {
				result.put("code", 0);
				result.put("message", "报告编号只允许为字母或数字或‘-’");
				return result;
			}
		    String regId = request.getParameter("id");
		    QueryParam queryParam = new QueryParam();
		    queryParam.setQueryName(fileNo);
		    queryParam.setOffset(offset==null?0:offset);
		    queryParam.setLimit(limit==null?10:limit);
		    String sort = request.getParameter("sort");
		    String order = request.getParameter("order");
		    if(StringUtils.isNotEmpty(sort) && StringUtils.isNotEmpty(order)){
		        queryParam.setSortStr(sort + " " + order);
		    }
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			map = creditReportService.getPageReport(queryParam, regId);
			if(map != null && !map.isEmpty()){
				@SuppressWarnings("unchecked")
                List<SaveInfoEntity> list = (List<SaveInfoEntity>) map.get("data");
				List<Object> rows = new ArrayList<Object>();
				if(list != null && !list.isEmpty()){
					Map<String, Object> obj = null;
					for(SaveInfoEntity item : list){
						obj = new HashMap<String, Object>();
						obj.put("id", item.getId());
						obj.put("fileNo", item.getFileNo());
						obj.put("agentName", item.getAgentName());
						obj.put("templetId", item.getTempletId());
						obj.put("templetName", item.getTempletName());
						obj.put("algorithmType", item.getAlgorithmType());
						obj.put("algorithmName", item.getAlgorithmName());
						obj.put("scoreVersion", item.getScoreVersion());
						obj.put("path", item.getPath());
						obj.put("createTime", item.getCreateTime() == null ? null : sdf.format(item.getCreateTime()));
						rows.add(obj);
					}
				}
				result.put("code", 1);
//				else
//				{
//					result.put("code", 2);
//				}
				result.put("total", map.get("count"));
				result.put("rows", rows);
			}
			
		} catch (SQLException e) {
			result.put("code", 0);
			result.put("message", "程序执行出错");
			log.error("SQL执行出错", e);
		} catch (Exception e) {
		    e.printStackTrace();
		    result.put("code", 0);
            result.put("message", "程序执行出错");
		    log.error("程序执行出错", e);
		}
		return result;
	}
	
	@RequestMapping(value="/createReport")
    public String createReport(Model model, @RequestParam String id, @RequestParam Integer templetId,
    		@RequestParam(required=false, defaultValue="Delphi") String algorithmType) {
		try {	
			//获取企业总分信息
			IndicatorScoreWeight creditScore = indicatorScoreService.getIndicatorScoreByTotal(id, algorithmType);
			//获取信用评分信息
			Map<String, String> agentScore = creditReportService.convertCreditScore(creditScore);
			//获取评分简述得分信息
			Map<String, String> scoreMap =  creditReportService.getScoreReportInfo(id, algorithmType, creditScore);
			//获取指标大类得分、权重
			List<IndicatorScoreWeight> inds = indicatorScoreService.getIndicatorScoreListByLevel1(id, algorithmType);
			Map<String, String> mList = indicatorScoreService.getScoreModelMap();					
			Map<String, String> param = new HashMap<>();	//其它参数
			param.put("algor", mList.get(algorithmType));	//算法中文名称
			param.put("regId", id);
			param.put("algorithmType", algorithmType);
			param.put("rootPath", request.getSession().getServletContext().getRealPath("/"));
			SaveInfoEntity saveInfo = creditReportService.createMaxIndexReport(id, new Date()); //生成pdf文件编号 可以避免编号重复
			//生成pdf报告
			Map<String, Object> jspData = creditReportService.createReport(templetId, saveInfo, scoreMap, agentScore, inds, param);
			model.addAllAttributes(jspData);	//设置jsp页面数据
			model.addAttribute("algorithmType", algorithmType);	// 算法类型
			model.addAttribute("regId", id);	//企业工商注册号
		} catch (Exception e) {
		    model.addAttribute("errorMeg", "生成征信报告出错");
			log.error("生成征信报告出错", e);
		}
		return "creditReport-detail";
	}
	
	@RequestMapping(value="/reportDetail")
    public String reportDetail(Model model, @RequestParam String id, 
            @RequestParam String fileNo, 
            @RequestParam String filePath,
            @RequestParam Integer templetId,
            @RequestParam(required=false, defaultValue="Delphi") String algorithmType) {
		try {
			model.addAttribute("algorithmType", algorithmType); //算法类型
			model.addAttribute("regId", id);			//企业工商注册号
			model.addAttribute("filePath", filePath);	//pdf文件地址

			ObjectMapper json = new ObjectMapper();
			// 显示的模板
			Map<String, Object> templetObj = creditReportService.getTempletById(templetId, false);
			model.addAttribute("reportType", templetObj.get("type")); // 报告类型
			// 显示模板
			model.addAttribute("templetMap", templetObj.get("templetMap"));
			// 重要声明
			model.addAttribute("declareList", templetObj.get("declareList"));
			// 大标题
			model.addAttribute("templetList", json.writeValueAsString(templetObj.get("templetList")));
			List<LegPerInfoHisEntity> legPer1 = creditReportService.getLegPerInfoHisNew(fileNo);
			List<OdsLegPerEquityHisEntity> legPer2 = creditReportService.getLegPerQuityHis(fileNo);
			Double assets;
			Double cashCon;
			Double total = 0.0d;
			DecimalFormat df = new DecimalFormat("0.00%");
	        df.setRoundingMode(RoundingMode.HALF_UP);
			for (OdsLegPerEquityHisEntity item : legPer2) {
				cashCon = item.getSubConam();
				total += (cashCon == null ? 0.0d : cashCon);
				assets = item.getRegCap();
				if (assets != null && assets != 0.0d && cashCon != null) {
					item.setCashRate(df.format(cashCon / assets));
				} else {
					item.setCashRate("0.00%");
				}
			}
			// 法定代表人在其他机构任职信息
			model.addAttribute("legPer1", legPer1);
			// 法定代表人股权投资信息
			model.addAttribute("legPer2Total", legPer2.size() > 0 ? DecimalFormat.getNumberInstance().format(total) : "无投资金额");
			model.addAttribute("legPer2Count", legPer2.size() > 0 ? legPer2.size() : "无");
			model.addAttribute("legPer2", legPer2);
			model.addAttribute("legPerJson1", json.writeValueAsString(legPer1));
			model.addAttribute("legPerJson2", json.writeValueAsString(legPer2));

			AgentInfoHisEntity info = creditReportService.getAgentInfoHis(id, fileNo);
			model.addAttribute("data", info); // 基本信息
			// 股东信息
			List<StockholderInfoHisEntity> stockholderInfo = creditReportService.getStockholderInfoHis(fileNo);
			model.addAttribute("stockholderInfo", json.writeValueAsString(stockholderInfo));
			// 法院信息
			model.addAttribute("specialInfo", creditReportService.getSpecialInfoHis(fileNo, 2));
			// 企业地址和电话信息
			model.addAttribute("entAttrInfo", json.writeValueAsString(info.getEntAttrInfos()));
			// 高管信息
			model.addAttribute("topManagerInfo", json.writeValueAsString(info.getTopManagerInfos()));
			// 对外股权投资信息
			model.addAttribute("othEntInvestsInfo", json.writeValueAsString(info.getOthEntInvestsInfos()));
			// 评分权重
			model.addAttribute("basicIndiScore", json.writeValueAsString(info.getBasicIndiScore()));
			// 企业、机构类型名称
			model.addAttribute("entStatus", Tools.customStatus(info.getStatus()));
			model.addAttribute("algor", indicatorScoreService.getScoreModelMap().get(algorithmType));
			// 企业变更信息
			model.addAttribute("agentChangeInfo", json.writeValueAsString(info.getChangeInfos()));
			// 分支机构
			model.addAttribute("fenzhiInfo", info.getFiliationInfos());
			// 清算信息
			model.addAttribute("liquidationInfo", json.writeValueAsString(info.getLiquidataInfos()));
			// 动产抵押信息
			model.addAttribute("agentMortgageInfo", info.getMortgageInfos());
			// 动产抵押物信息
			model.addAttribute("mortgageItemInfo", json.writeValueAsString(info.getMortgageInfos()));
			// 股权冻结历史信息
			model.addAttribute("agentSharesInfo", info.getAgentSharesInfos());
			// 股权出质历史信息
			model.addAttribute("agentSharesImpawInfo", json.writeValueAsString(info.getAgentSharesImpawnInfos()));
			// 资产负债
			model.addAttribute("balanceSheetInfo", json.writeValueAsString(info.getOdsBalanceSheetInfos()));
			// 利润表
			model.addAttribute("profitInfo", json.writeValueAsString(info.getOdsProfitInfos()));
			// 税务信息
			model.addAttribute("agentTaxAccountInfo", json.writeValueAsString(info.getAgentTaxAccoutInfos()));
			// 经营变化趋势
			model.addAttribute("merchantTrandeReportChangeInfo", json.writeValueAsString(info.getMerchantReportChangeInfos()));
			// 本市同行对比
			model.addAttribute("merchantTrandeReportConstrastInfo", json.writeValueAsString(info.getMerchantReportConstrastInfos()));
			// 客户地域分布
			model.addAttribute("merchantTrandeReportAreaInfo", json.writeValueAsString(info.getMerchantReportAreaInfos()));
			// 客户忠诚度
			model.addAttribute("merchantTrandeReportLoyaltyInfo", json.writeValueAsString(info.getMerchantReportLoyalInfos()));
			// 异常交易
			model.addAttribute("merchantTradeAbormalInfo", info.getMerchantReportAbormalInfos());
			// 违法违规裁判文书信息
			model.addAttribute("wfwgcpInfo", info.getAgentJudgedocInfos());
			// 违法违规执行公告
			model.addAttribute("agentCoutEnforceInfo", info.getAgentCoutEnforceInfos());
			// 法定代表人失信裁判文书
			List<AgentTopLeaderJudgementDocumentHisEntity> topLeaderJudgementDoc = creditReportService
					.getJudgementDocmentInfoHis(fileNo, "TOP_LEADER");
			model.addAttribute("agentTopLeaderJudgentDocInfo", topLeaderJudgementDoc);
			// 法定代表人失信执行公告
			List<AgentTopLeaderExecuteDocHisEntity> topLeaderExecuteDoc = creditReportService
					.getExecuteDocInfoHis(fileNo, "TOP_LEADER");
			model.addAttribute("fdrsxzxInfo", topLeaderExecuteDoc);
			// 法定代表人失信公告
			List<AgentTopleaderDishonourNoticHisEntity> topLeaderDishonourHisInfo = creditReportService
					.getDishonourNoticeInfoHis(fileNo, "TOP_LEADER");
			model.addAttribute("agentTopLeaderDishonourInfo", topLeaderDishonourHisInfo);
			// 法定代表人失信网贷黑名单
			List<AgentTopleaderNetloanHisEntity> topLeaderNetloadHisInfo = creditReportService.getNetloadInfoHis(fileNo,
					"TOP_LEADER");
			model.addAttribute("agentTopLeaderNetloanInfo", topLeaderNetloadHisInfo);
			// 法定代表人失信曝光台
			List<AgentTopleaderCourExposureHisEntity> topLeaderCourExposureHisInfo = creditReportService
					.getExposureInfoHis(fileNo, "TOP_LEADER");
			model.addAttribute("agentTopLeaderCourtExposInfo", topLeaderCourExposureHisInfo);
			// 控股股东失信裁判文书
			List<AgentTopLeaderJudgementDocumentHisEntity> stockHolderJudgementDoc = creditReportService
					.getJudgementDocmentInfoHis(fileNo, "SHARE_CONTROLLER");
			model.addAttribute("agentStockHolderJudgentDocInfo", stockHolderJudgementDoc);
			// 控股股东失信执行公告
			List<AgentTopLeaderExecuteDocHisEntity> stockHolderExecuteDoc = creditReportService
					.getExecuteDocInfoHis(fileNo, "SHARE_CONTROLLER");
			model.addAttribute("agentStockHolderEexdocInfo", stockHolderExecuteDoc);
			// 控股股东失信公告
			List<AgentTopleaderDishonourNoticHisEntity> stockHolderDishonourHisInfo = creditReportService
					.getDishonourNoticeInfoHis(fileNo, "SHARE_CONTROLLER");
			model.addAttribute("agentStockHolderDishonourInfo", stockHolderDishonourHisInfo);
			// 控股股东失信网贷黑名单
			List<AgentTopleaderNetloanHisEntity> stockHolderNetloadHisInfo = creditReportService
					.getNetloadInfoHis(fileNo, "SHARE_CONTROLLER");
			model.addAttribute("agentStockHolderNetloanInfo", stockHolderNetloadHisInfo);
			// 控股股东信曝光台
			List<AgentTopleaderCourExposureHisEntity> stockHolderCourExposureHisInfo = creditReportService
					.getExposureInfoHis(fileNo, "SHARE_CONTROLLER");
			model.addAttribute("agentStockHolderCourtExposInfo", stockHolderCourExposureHisInfo);
			// 阿里欠贷
			model.addAttribute("agentAliloadBreakInfo", info.getAgentAliloadBreakInfos());
			// 核心经营
			model.addAttribute("merchantTradeInfo", info.getMerchantTradeInfos());
			// 经营稳定性
			model.addAttribute("merchantStabilityInfo", json.writeValueAsString(info.getMerchantStabilityInfos()));
			//由于 高管商旅 模块没有表信息，现用临时变量填充，使页面正常显示
			model.addAttribute("test", new ArrayList<>());
		} catch (Exception e) {
            model.addAttribute("errorMeg", "查询征信报告详情错误");
            log.error("查询征信报告详情错误", e);
        }
		return "creditReport-detail";
	}

	/* ---------------------------- compInfo --------------------------------- */	
	// 企业属性（区域、邮编等）
	@RequestMapping(value="/entAttrInfo",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> getEntAttrInfo(String regId){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", creditReportService.getEntAttrInfo(regId));
		result.put("result", 1);
		return result;
	}
	// 股东信息
	@RequestMapping(value="/stockholderInfo",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> getStockholderInfo(String regId){
		Map<String, Object> result = new HashMap<String, Object>();
		List<StockholderInfoEntity> list = creditReportService.getStockholderInfo(regId);
		result.put("data", list);
		result.put("result", 1);
		return result;
	}
	// 高管信息
	@RequestMapping(value="/topManagerInfo",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> getTopManagerInfo(String regId){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", creditReportService.getTopManagerInfo(regId));
		result.put("result", 1);
		return result;
	}
	// 企业对外投资信息
	@RequestMapping(value="/othEntInvestsInfo",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> getOthEntInvestsInfo(String regId){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", creditReportService.getOthEntInvestsInfo(regId));
		result.put("result", 1);
		return result;
	}
	
	// 法定代表人（在其他机构任职信息/股权投资信息）
	@RequestMapping(value="/legPerInfo",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> getLegPerInfo(String regId){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
//		    List<LegPerInfoEntity> legPerList = creditReportService.getLegPerInfo(agentInfo.getRegId());
		    List<LegPerInfoEntity> legPer1 = creditReportService.getLegPerInfoNew(regId);
		    List<OdsLegPerEquityEntity> legPer2 = creditReportService.getLegPerQuityInfo(regId);
		    Double assets;
		    Double cashCon;
		    DecimalFormat df = new DecimalFormat("0.00%");
            df.setRoundingMode(RoundingMode.HALF_UP);
		    for(OdsLegPerEquityEntity item : legPer2) {
		    	cashCon = item.getSubConam();
				assets = item.getRegCap();
				if(assets != null && assets!= 0.0d && cashCon != null) {
					item.setCashRate(df.format(cashCon/assets));
				} else {
					item.setCashRate("0.00%");
				}
		    }
		    // 法定代表人在其他机构任职信息
		    result.put("legPerInfo1", legPer1);
		    // 法定代表人股权投资信息
		    result.put("legPerInfo2", legPer2);
        } catch (Exception e) {
            result.put("code", 0);
            result.put("message", "程序执行出错");
            log.error("程序执行出错", e);
        }
		return result;
	}
	
	
	//企业变更信息
	@RequestMapping(value="/agentChangeInfo",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> getAgentChangeInfo(String regId){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", creditReportService.getAgentChangeInfo(regId));
		result.put("result", 1);
		return result;
	}
	
	//清算信息
	@RequestMapping(value = "/agentLiquidationInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> getAgentLiquidationInfo(String regId) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", creditReportService.getLiquidationInfo(regId));
		result.put("result", 1);
		return result;
	}
	
	//动产抵押信息
	@RequestMapping(value = "/mortgageItemInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> getMortgageItemInfo(String regId) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", creditReportService.getMortgageItemInfo(regId));
		result.put("result", 1);
		return result;
	}
	
	//股权出质历史
	@RequestMapping(value = "/agentSharesImpawnInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> getAgentSharesImpawnInfo(String regId) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", creditReportService.getAgentSharesImpawInfo(regId));
		result.put("result", 1);
		return result;
	}
	
	
	
	// 分之机构信息
//	@RequestMapping(value = "/agentFiliationInfo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public Map<String, Object> getAgentFiliationInfo(@RequestBody AgentInfoEntity agentInfo) {
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("data", creditReportService.getAgentFiliationInfo(agentInfo.getRegId()));
//		result.put("result", 1);
//		return result;
//	}
	
	// 评分指标信息
	@RequestMapping(value="/scoreWeight",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public Map<String, Object> getScoreWeight(@RequestParam String id, @RequestParam(required=false) String algorithmType) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
		    List<IndicatorScoreWeight> inds = indicatorScoreService.getIndicatorScoreListByLevel1(id, algorithmType);
		    Map<String, String> score = new LinkedHashMap<>();
		    Map<String, String> weight = new LinkedHashMap<>();
		    List<Map<String, String>> data = new LinkedList<>();
		    data.add(weight);
		    data.add(score);
		    weight.put("item", "权重");
		    score.put("item", "得分");
		    for(IndicatorScoreWeight ind : inds) {
		        String s = ind.getLevel1Score() != null ? ind.getLevel1Score().toString() : "0";
		        DecimalFormat df = new DecimalFormat("0.00%");
	            df.setRoundingMode(RoundingMode.HALF_UP);
		        String w = df.format(ind.getLevel1Weight() != null ? ind.getLevel1Weight() : 0);
		        switch (ind.getLevel1()) {
		        case "基本信息":
		            weight.put("base", w);
		            score.put("base", s);
		            break;
		        case "交易行为":
		            weight.put("behavior", w);
		            score.put("behavior", s);
		            break;
		        case "信用历史":
		            weight.put("history", w);
		            score.put("history", s);
		            break;
		        case "履约能力":
		            weight.put("capacity", w);
		            score.put("capacity", s);
		            break;
		        case "特殊事项":
		            weight.put("special", w);
		            score.put("special", s);
		            break;
		        default:
		            break;
		        }
		    }
		    result.put("data", data);
		    result.put("result", 1);
        } catch (Exception e) {
            result.put("code", 0);
            result.put("message", "程序执行出错");
            log.error("程序执行出错", e);
        }
		return result;
	}
	
	@RequestMapping(value="/querycompInfo")
    public String querycompInfo(Model model, @RequestParam String id,
            @RequestParam(required=false) String algorithmType){
	    try {
	        AgentInfoEntity info = creditReportService.getAgentInfoById(id);
	        
	        // 总分
	        IndicatorScoreWeight creditScore = indicatorScoreService.getIndicatorScoreByTotal(id, algorithmType);
	        Double total = 0.0d;
	        //法人信息
//	        List<LegPerInfoEntity> legPerList = creditReportService.getLegPerInfo(id,1);
	        //法人在其他机构投资信息
	        List<OdsLegPerEquityEntity> legPer2 = creditReportService.getLegPerQuityInfo(id);
	        OdsLegPerEquityEntity leg;
	        for(int i=legPer2.size()-1; i>=0; i--) {
	            leg = legPer2.get(i);
	            total += (leg.getSubConam() == null ? 0.0d : leg.getSubConam());
	        }
	        
	        model.addAttribute("data", info);	// 基本信息 
	        model.addAttribute("creditScore", creditReportService.convertCreditScore(creditScore));
	        model.addAttribute("legPer2Total", legPer2.size() > 0 ? DecimalFormat.getNumberInstance().format(total) : "无投资金额");
	        model.addAttribute("legPer2Count", legPer2.size() > 0 ? legPer2.size() : "无");
	        List<SpecialInfoEntity> newList = creditReportService.getSpecialInfo(info.getRegId()) ;
	        model.addAttribute("specialInfo", newList); // 法院信息
	        // 企业、机构状态
	        model.addAttribute("entStatus", Tools.customStatus(info.getStatus()));
	        //分之机构信息
	        List<AgentFiliationEntity> filiationInfo = creditReportService.getAgentFiliationInfo(info.getRegId());
	        model.addAttribute("fenzhiInfo",filiationInfo);
	        //动产抵押信息
	        List<AgentMortgageEntity> agentMortgageInfo = creditReportService.getAgentMortgageInfo(info.getRegId());
	        model.addAttribute("agentMortgageInfo",agentMortgageInfo);
	        //股权冻结历史
	        List<AgentSharesFroEntity> agentSharesInfo = creditReportService.getAgentSharesInfo(info.getRegId());
	        model.addAttribute("agentSharesInfo",agentSharesInfo);
        } catch (Exception e) {
            model.addAttribute("errorMsg", "程序执行出错");
            log.error("程序执行出错", e);
        }
		return "basic";
	}
}
