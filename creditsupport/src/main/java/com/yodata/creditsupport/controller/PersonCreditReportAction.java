package com.yodata.creditsupport.controller;

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
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yodata.core.control.BasicAction;
import com.yodata.creditsupport.orm.entity.EntAttrInfoEntity;
import com.yodata.creditsupport.orm.entity.his.AgentInfoHisEntity;
import com.yodata.creditsupport.orm.entity.his.EntAttrInfoHisEntity;
import com.yodata.creditsupport.orm.person.entity.*;
import com.yodata.creditsupport.orm.person.entity.report.BasicIndiScorePersonHisEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonDriverlicensestatusReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonInfoReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonInvestAlidebtReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonInvestPunishbreakReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonInvestPunishedReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonInvestRyposfrReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonInvestRyposperReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonInvestRyposshaReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonReportBasicReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonReportConsumecategoriesReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonReportConsumecitiesReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonReportMonthconsumesReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonReportTransbehaviorReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonReportTranscreditsReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonRiskBgtReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonRiskCpwsReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonRiskShixinReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonRiskWdhmdReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonRiskZxggReportEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonVerifybankcardby3eleReportEntity;
import com.yodata.creditsupport.orm.vo.BasicIndiScore;
import com.yodata.creditsupport.orm.vo.IndicatorScoreWeight;
import com.yodata.creditsupport.service.IDictService;
import com.yodata.creditsupport.service.IIndicatorScoreService;
import com.yodata.creditsupport.service.IPersonCreditReportService;
import com.yodata.creditsupport.util.QueryParam;
import com.yodata.creditsupport.util.ReportPdfUtils;
import com.yodata.creditsupport.util.Tools;

/**
 * 
* @Description: 个人征信报告生成Action
* @author Jason
* @date 2016年7月13日 上午10:05:32
*
 */

@Controller
@RequestMapping("/personCreditReport")
public class PersonCreditReportAction extends BasicAction {

	private final Log log= LogFactory.getLog(CreditReportAction.class);
	
	@Resource
	private IPersonCreditReportService creditReportService;
	@Resource
	private IIndicatorScoreService indicatorScoreService;
	
	@Resource
    private IDictService dictService;
	
	@RequestMapping(value="/queryReportTemplet",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public Map<String, Object> getReportTemplet() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<PersonReportTempletEntity> list = creditReportService.getAllReportTemp();
		result.put("rows", list);
		return result;
	}
	
	@RequestMapping(value="/query",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> queryReport(@RequestParam(required=false) Integer offset,
    		@RequestParam(required=false) Integer limit,
    		@RequestParam(required=false, defaultValue="Delphi") String algorithmType){
		
		Map<String, Object> result = new HashMap<String, Object>();
    	Map<String, Object> map;
		try {
		    //查询分页条件
		    String cardId = request.getParameter("id");
		    String fileNo = request.getParameter("fileNo");
		    QueryParam queryParam = new QueryParam();
		    queryParam.setQueryName(fileNo);
		    queryParam.setAlgorithmType(algorithmType);
		    queryParam.setOffset(offset==null?0:offset);
		    queryParam.setLimit(limit==null?10:limit);
		    String sort = request.getParameter("sort");
		    String order = request.getParameter("order");
		    if(StringUtils.isNotEmpty(sort) && StringUtils.isNotEmpty(order)){
		        queryParam.setSortStr(sort + " " + order);
		    }
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			map = creditReportService.getPersonPageReport(queryParam, cardId);
			
			if(map != null && !map.isEmpty()){
				@SuppressWarnings("unchecked")
                List<PersonSaveInfoEntity> list = (List<PersonSaveInfoEntity>) map.get("data");
				List<Object> rows = new ArrayList<Object>();
				if(list != null && !list.isEmpty()){
					Map<String, Object> obj = null;
					for(PersonSaveInfoEntity item : list){
						obj = new HashMap<String, Object>();
						obj.put("id", item.getId());
						obj.put("fileNo", item.getFileNo());
						obj.put("name", item.getName());
						obj.put("templetId", item.getTempletId());
						obj.put("templetName", item.getTempletName());
						obj.put("algorithmName", item.getAlgorithmName());
						obj.put("scoreVersion", item.getScoreVersion());
						obj.put("path", item.getPath());
						obj.put("createTime", item.getCreateTime() == null ? null : sdf.format(item.getCreateTime()));
						rows.add(obj);
					}
					result.put("code", 1);
				}
				else
				{
					result.put("code", 2);
				}
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
	
	@RequestMapping(value="/createReport",produces=MediaType.APPLICATION_JSON_VALUE)
    public String createReport(Model model, @RequestParam String id, @RequestParam Integer templetId,
    		@RequestParam(required=false, defaultValue="Delphi") String algorithmType) {
		model.addAttribute("algorithmType", algorithmType);	// 算法类型
		model.addAttribute("cardId", id);
		Date createTime = new Date();	// 生成日期
		String cardId = id;			// 身份证号
		Map<String, Object> data = new HashMap<>();	// pdf 需要的数据
		ObjectMapper json = new ObjectMapper();
		try {
			// 显示的模板
			Map<String, Object> templetObj = creditReportService.getTempletById(templetId, true);
			// 显示模板
			data.put("templetMap", templetObj.get("templetMap"));
			// 报告类别
			data.put("reportType", templetObj.get("type"));
			model.addAttribute("reportType", templetObj.get("type"));
			data.put("curDate", new SimpleDateFormat("yyyy年MM月dd日").format(createTime));
			model.addAttribute("templetMap", templetObj.get("templetMap"));
			// 重要声明
			data.put("declareList", templetObj.get("declareList"));
			model.addAttribute("declareList", templetObj.get("declareList"));
			Object tList = templetObj.get("repItemList");// 大标题
			if(tList != null) {
				data.put("repItemList", tList);
				model.addAttribute("repItemList", tList);
			}
			OdsPersonInfoEntity baseInfo = creditReportService.getPersonInfoById(id);
			PersonSaveInfoEntity saveInfo = creditReportService.createMaxIndexReport(baseInfo.getCardId(), createTime);
			String fileNo = saveInfo.getFileNo();		// PDF报告编号
			ReportPdfUtils pdf = new ReportPdfUtils(fileNo, createTime, request.getSession().getServletContext().getRealPath("/"));
			String filePath = pdf.getPdfPath();			// PDF报告路径
			
			// 得分 权重
//			List<BasicIndiScorePersonHisEntity> basicIndi = new ArrayList<>();
			// 总分
//			IndicatorScoreWeight creditScore = indicatorScoreService.getIndicatorScoreByTotal(id, algorithmType);
			// 显示评分简述
//			Map<String, String> scoreMap =  creditReportService.getScoreReportInfo(id, algorithmType, creditScore);
//			data.put("score", scoreMap);
//			model.addAttribute("score", scoreMap);
//			Map<String, String> agentScore = creditReportService.convertCreditScore(creditScore);
//			data.put("creditScore", agentScore);
			// 算法名称
			Map<String, String> mList = indicatorScoreService.getScoreModelMap();
			data.put("algor", mList.get(algorithmType));
			model.addAttribute("algor", mList.get(algorithmType));
			
			OdsPersonInfoReportEntity personReport = new OdsPersonInfoReportEntity();
			BeanUtils.copyProperties(baseInfo, personReport, "id");
			personReport.setCardId(baseInfo.getCardId());
			personReport.setFileNo(fileNo);
			personReport.setCreateTime(createTime);
			personReport.setLevel("");
//			personReport.setScore(Integer.valueOf(agentScore.get("score")));
//			personReport.setLevel(agentScore.get("level"));
//			personReport.setLevelDesc(agentScore.get("levelDesc"));
//			personReport.setScore1(scoreMap.get("score1"));
//			personReport.setScore2(scoreMap.get("score2"));
//			personReport.setScore1Per(scoreMap.get("score1Per"));
//			personReport.setScore2Per(scoreMap.get("score2Per"));
//			personReport.setScore1Weight(scoreMap.get("score1Weight"));
//			personReport.setScore2Weight(scoreMap.get("score2Weight"));
			
			
			/**
			 * 一、基本信息
			 */
			data.put("baseInfo", personReport);
			model.addAttribute("data",personReport);
			//银行卡号查询
			
			//身份验证标识
			data.put("compStatus", personReport.getCompStatus());
			model.addAttribute("compStatus",personReport.getCompStatus());
			/**
			 * 二、驾驶证信息
			 */
			
			List<OdsPersonDriverlicensestatusEntity> driverInfo = creditReportService.getDriverlicenseStatausInfo(id);
			data.put("driverInfo", driverInfo);
			model.addAttribute("driverInfo",json.writeValueAsString(driverInfo));
			
			/**
			 * 三、个人对外投资信息
			 */
			
			//失信被执行人信息
			List<OdsPersonInvestPunishbreakEntity> punishBreakInfo = creditReportService.getInvestPunishBreakInfo(id);
			data.put("punishBreakInfo", punishBreakInfo);
			model.addAttribute("punishBreakInfo", punishBreakInfo);
			
			//被执行人信息
			List<OdsPersonInvestPunishedEntity> punishedInfo = creditReportService.getInvestPunishedInfo(id);
			data.put("punishedInfo", punishedInfo);
			model.addAttribute("punishedInfo", punishedInfo);
			
			//企业法定代表人
			List<OdsPersonInvestRyposfrEntity> ryposfrInfo = creditReportService.getInversRyposfrInfo(id);
			data.put("ryposfrInfo", ryposfrInfo);
			model.addAttribute("ryposfrInfo", json.writeValueAsString(ryposfrInfo));
			
			//管理人员
			List<OdsPersonInvestRyposperEntity> ryposperInfo = creditReportService.getInversRyposperInfo(id);
			data.put("ryposperInfo", ryposperInfo);
			model.addAttribute("ryposperInfo", json.writeValueAsString(ryposperInfo));
			
			//企业股东
			List<OdsPersonInvestRyposshaEntity> ryposshaInfo = creditReportService.getInversRyposshaInfo(id);
			data.put("ryposshaInfo", ryposshaInfo);
			model.addAttribute("ryposshaInfo", json.writeValueAsString(ryposshaInfo));
			
			/**
			 * 四、个人司法信息
			 */
			
			//曝光台
			List<OdsPersonRiskBgtEntity> riskBgtInfo = creditReportService.getRiskBgtInfo(id);
			data.put("riskBgtInfo", riskBgtInfo);
			model.addAttribute("riskBgtInfo", json.writeValueAsString(riskBgtInfo));
			
			//裁判文书
			List<OdsPersonRiskCpwsEntity> riskCpwsInfo = creditReportService.getRiskCpwsInfo(id);
			data.put("riskCpwsInfo", riskCpwsInfo);
			model.addAttribute("riskCpwsInfo", riskCpwsInfo);
			
			//失信公告
			List<OdsPersonRiskShixinEntity> riskDishonerInfo = creditReportService.getRiskDishonerInfo(id);
			data.put("riskDishonerInfo", riskDishonerInfo);
			model.addAttribute("riskDishonerInfo", riskDishonerInfo);
			
			//网贷黑名单
			List<OdsPersonRiskWdhmdEntity> riskNetloadInfo = creditReportService.getRiskNetloadInfo(id);
			data.put("riskNetloadInfo", riskNetloadInfo);
			model.addAttribute("riskNetloadInfo", riskNetloadInfo);
			
			//执行公告
			List<OdsPersonRiskZxggEntity> riskExecuteDocInfo = creditReportService.getRiskExecuteDocInfo(id);
			data.put("riskExecuteDocInfo", riskExecuteDocInfo);
			model.addAttribute("riskExecuteDocInfo", riskExecuteDocInfo);
			
			/**
			 * 五、阿里欠贷信息
			 */
			List<OdsPersonInvestAlidebtEntity> invesAlidebtInfo = creditReportService.getInvestAlidebtInfo(id);
			data.put("invesAlidebtInfo", invesAlidebtInfo);
			model.addAttribute("invesAlidebtInfo", invesAlidebtInfo);
			
			/**
			 * 七、银联三要素验证
			 */
			List<OdsPersonVerifybankcardby3eleEntity> verifyBankCardInfo = creditReportService.getVerifyBankCardInfo(id);
			data.put("verifyBankCardInfo", verifyBankCardInfo);
			model.addAttribute("verifyBankCardInfo", json.writeValueAsString(verifyBankCardInfo));
			
			
			/**
			 * 七、个人消费 
			 */
			
			//资产状况及交易行为
			List<OdsPersonReportBasicEntity> reportBasicInfo = creditReportService.getReportBasicInfo(id);
			data.put("reportBasicInfo", reportBasicInfo);
			model.addAttribute("reportBasicInfo", reportBasicInfo);
			
			
			//消费大类分布
			List<OdsPersonReportConsumecategoriesEntity> reportConsumeCategoryInfo = creditReportService.getReportConsumeCategoryInfo(id);
			data.put("reportConsumeCategoryInfo", reportConsumeCategoryInfo);
			model.addAttribute("reportConsumeCategoryInfo", json.writeValueAsString(reportConsumeCategoryInfo));
			
			//城市消费状况
			List<OdsPersonReportConsumecitiesEntity> reportConsumeCityInfo = creditReportService.getReportConsumeCityInfo(id);
			data.put("reportConsumeCityInfo", reportConsumeCityInfo);
			model.addAttribute("reportConsumeCityInfo", json.writeValueAsString(reportConsumeCityInfo));
			
			//每月消费状况
			List<OdsPersonReportMonthconsumesEntity> reportMonthConsumeInfo = creditReportService.getReportMonthConsumeInfo(id);
			data.put("reportMonthConsumeInfo", reportMonthConsumeInfo);
			model.addAttribute("reportMonthConsumeInfo", json.writeValueAsString(reportMonthConsumeInfo));
			
			//消费行为
			List<OdsPersonReportTransbehaviorEntity> reportTransBehivorInfo = creditReportService.getReportTransBehaivorInfo(id);
			data.put("reportTransBehivorInfo", reportTransBehivorInfo);
			model.addAttribute("reportTransBehivorInfo", reportTransBehivorInfo);
			
			//信用相关交易统计
			List<OdsPersonReportTranscreditsEntity> reportTransCreditInfo = creditReportService.getReportTransCreditInfo(id);
			data.put("reportTransCreditInfo", reportTransCreditInfo);
			model.addAttribute("reportTransCreditInfo", json.writeValueAsString(reportTransCreditInfo));
			
			/*-- 下面为要跳转的征信报告详情页面填充数据  --*/		
			model.addAttribute("filePath", filePath);	// 地址
			pdf.setPdfData(data);		// 设置数据
			pdf.createPdf("report-person.htm");
			
			//将查询到的征信报告数据保存到Report类中
			
			//驾驶证信息
			List<OdsPersonDriverlicensestatusReportEntity> driverReport = new ArrayList<>();
			for(OdsPersonDriverlicensestatusEntity entity : driverInfo)
			{
				OdsPersonDriverlicensestatusReportEntity report = new OdsPersonDriverlicensestatusReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				driverReport.add(report);
			}
			personReport.setDriverList(driverReport);
			
			//失信被执行人信息
			List<OdsPersonInvestPunishbreakReportEntity> investPunishBreakReport = new ArrayList<>();
			for(OdsPersonInvestPunishbreakEntity entity : punishBreakInfo)
			{
				OdsPersonInvestPunishbreakReportEntity report = new OdsPersonInvestPunishbreakReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				investPunishBreakReport.add(report);
			}
			personReport.setInvestPunishBreakList(investPunishBreakReport);
			
			//被执行人信息
			List<OdsPersonInvestPunishedReportEntity> investPunishedReport = new ArrayList<>();
			for(OdsPersonInvestPunishedEntity entity : punishedInfo)
			{
				OdsPersonInvestPunishedReportEntity report = new OdsPersonInvestPunishedReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				investPunishedReport.add(report);
			}
			personReport.setInvestPunishedList(investPunishedReport);
			
			//企业法定代表人
			List<OdsPersonInvestRyposfrReportEntity> investRyposfrReport = new ArrayList<>();
			for(OdsPersonInvestRyposfrEntity entity : ryposfrInfo)
			{
				OdsPersonInvestRyposfrReportEntity report = new OdsPersonInvestRyposfrReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				investRyposfrReport.add(report);
			}
			personReport.setInvestRyposfrList(investRyposfrReport);
			
			//管理人员
			List<OdsPersonInvestRyposperReportEntity> investRyposperReport = new ArrayList<>();
			for(OdsPersonInvestRyposperEntity entity : ryposperInfo)
			{
				OdsPersonInvestRyposperReportEntity report = new OdsPersonInvestRyposperReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				investRyposperReport.add(report);
			}
			personReport.setInvestRyposperList(investRyposperReport);
			
			//企业股东
			List<OdsPersonInvestRyposshaReportEntity> investRyposshaReport = new ArrayList<>();
			for(OdsPersonInvestRyposshaEntity entity : ryposshaInfo)
			{
				OdsPersonInvestRyposshaReportEntity report = new OdsPersonInvestRyposshaReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				investRyposshaReport.add(report);
			}
			personReport.setInvestRyposshaList(investRyposshaReport);
			
			//曝光台
			List<OdsPersonRiskBgtReportEntity> riskBgtReport = new ArrayList<>();
			for(OdsPersonRiskBgtEntity entity : riskBgtInfo)
			{
				OdsPersonRiskBgtReportEntity report = new OdsPersonRiskBgtReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				riskBgtReport.add(report);
			}
			personReport.setRiskBgtList(riskBgtReport);
			
			//裁判文书
			List<OdsPersonRiskCpwsReportEntity> riskCpwsReport = new ArrayList<>();
			for(OdsPersonRiskCpwsEntity entity : riskCpwsInfo)
			{
				OdsPersonRiskCpwsReportEntity report = new OdsPersonRiskCpwsReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				riskCpwsReport.add(report);
			}
			personReport.setRiskCpwsList(riskCpwsReport);
			
			//失信公告
			List<OdsPersonRiskShixinReportEntity> riskDishonerReport = new ArrayList<>();
			for(OdsPersonRiskShixinEntity entity : riskDishonerInfo)
			{
				OdsPersonRiskShixinReportEntity report = new OdsPersonRiskShixinReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				riskDishonerReport.add(report);
			}
			personReport.setRiskDishonerList(riskDishonerReport);
			
			//网贷黑名单
			List<OdsPersonRiskWdhmdReportEntity> riskNetloadReport = new ArrayList<>();
			for(OdsPersonRiskWdhmdEntity entity : riskNetloadInfo)
			{
				OdsPersonRiskWdhmdReportEntity report = new OdsPersonRiskWdhmdReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				riskNetloadReport.add(report);
			}
			personReport.setRiskNetloadList(riskNetloadReport);
			
			//执行公告
			List<OdsPersonRiskZxggReportEntity> riskExecuteDocReport = new ArrayList<>();
			for(OdsPersonRiskZxggEntity entity : riskExecuteDocInfo)
			{
				OdsPersonRiskZxggReportEntity report = new OdsPersonRiskZxggReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				riskExecuteDocReport.add(report);
			}
			personReport.setRiskExecuteDocList(riskExecuteDocReport);
			
			//阿里欠贷
			List<OdsPersonInvestAlidebtReportEntity>  investAlidebtReport = new ArrayList<>();
			for(OdsPersonInvestAlidebtEntity entity : invesAlidebtInfo)
			{
				OdsPersonInvestAlidebtReportEntity report = new OdsPersonInvestAlidebtReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				investAlidebtReport.add(report);
			}
			personReport.setInvestAlidebtList(investAlidebtReport);
			
			//银联三要素验证
			List<OdsPersonVerifybankcardby3eleReportEntity>  vrifyBankCardReport = new ArrayList<>();
			for(OdsPersonVerifybankcardby3eleEntity entity : verifyBankCardInfo)
			{
				OdsPersonVerifybankcardby3eleReportEntity report = new OdsPersonVerifybankcardby3eleReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				vrifyBankCardReport.add(report);
			}
			personReport.setVrifyBankCardList(vrifyBankCardReport);
			
			//资产状况及交易行为
			List<OdsPersonReportBasicReportEntity>  reportBasicReport = new ArrayList<>();
			for(OdsPersonReportBasicEntity entity : reportBasicInfo)
			{
				OdsPersonReportBasicReportEntity report = new OdsPersonReportBasicReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				reportBasicReport.add(report);
			}
			personReport.setReportBasicList(reportBasicReport);
			
			//消费大类分布
			List<OdsPersonReportConsumecategoriesReportEntity>  reportConsumeCategoryReport = new ArrayList<>();
			for(OdsPersonReportConsumecategoriesEntity entity : reportConsumeCategoryInfo)
			{
				OdsPersonReportConsumecategoriesReportEntity report = new OdsPersonReportConsumecategoriesReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				reportConsumeCategoryReport.add(report);
			}
			personReport.setReportConsumeCategoryList(reportConsumeCategoryReport);
			
			//城市消费状况
			List<OdsPersonReportConsumecitiesReportEntity>  reportConsumeCityReport = new ArrayList<>();
			for(OdsPersonReportConsumecitiesEntity entity : reportConsumeCityInfo)
			{
				OdsPersonReportConsumecitiesReportEntity report = new OdsPersonReportConsumecitiesReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				reportConsumeCityReport.add(report);
			}
			personReport.setReportConsumeCityList(reportConsumeCityReport);
			
			//每月消费状况
			List<OdsPersonReportMonthconsumesReportEntity>  reportMonthComsumeReport = new ArrayList<>();
			for(OdsPersonReportMonthconsumesEntity entity : reportMonthConsumeInfo)
			{
				OdsPersonReportMonthconsumesReportEntity report = new OdsPersonReportMonthconsumesReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				reportMonthComsumeReport.add(report);
			}
			personReport.setReportMonthComsumeList(reportMonthComsumeReport);
			
			//消费行为
			List<OdsPersonReportTransbehaviorReportEntity>  reportConsumeBehaviorReport = new ArrayList<>();
			for(OdsPersonReportTransbehaviorEntity entity : reportTransBehivorInfo)
			{
				OdsPersonReportTransbehaviorReportEntity report = new OdsPersonReportTransbehaviorReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				reportConsumeBehaviorReport.add(report);
			}
			personReport.setReportConsumeBehaviorList(reportConsumeBehaviorReport);
			
			//信用相关交易统计
			List<OdsPersonReportTranscreditsReportEntity>  reportTransCreditReport = new ArrayList<>();
			for(OdsPersonReportTranscreditsEntity entity : reportTransCreditInfo)
			{
				OdsPersonReportTranscreditsReportEntity report = new OdsPersonReportTranscreditsReportEntity(fileNo,createTime);
				BeanUtils.copyProperties(entity, report,"id");
				reportTransCreditReport.add(report);
			}
			personReport.setReportTransCreditList(reportTransCreditReport);
			
			saveInfo.setName(baseInfo.getName());
			saveInfo.setPath(filePath);
			saveInfo.setTempletId(templetId);
			saveInfo.setAlgorithmType(algorithmType);
			
			creditReportService.savePersonReport(personReport, saveInfo);
			
			
		} catch (Exception e) {
		    model.addAttribute("errorMeg", "生成征信报告出错");
			log.error("生成征信报告出错", e);
		}
		return "person/person-creditReport-detail";
	}
	
	@RequestMapping(value="/reportDetail")
    public String reportDetail(Model model, @RequestParam String id, 
            @RequestParam String fileNo, 
            @RequestParam String filePath,
            @RequestParam Integer templetId,
            @RequestParam(required=false, defaultValue="Delphi") String algorithmType) {
		try {
		   
			model.addAttribute("algorithmType", algorithmType);	// 算法类型
		    model.addAttribute("cardId", id);
		    model.addAttribute("filePath", filePath);	// 地址
		    
		    ObjectMapper json = new ObjectMapper();
		    // 显示的模板
		    Map<String, Object> templetObj = creditReportService.getTempletById(templetId, false);
		    model.addAttribute("reportType", templetObj.get("type")); // 报告类型
		    // 显示模板
		    model.addAttribute("templetMap", templetObj.get("templetMap"));
		    // 重要声明
		    model.addAttribute("declareList", templetObj.get("declareList"));
		    Object tList = templetObj.get("repItemList");// 大标题
		    if(tList != null) {
		        model.addAttribute("repItemList", tList);
		    }
		    
		    OdsPersonInfoReportEntity personReport = creditReportService.getPersonReportInfo(id, fileNo);
		    
		    /**
			 * 一、基本信息
			 */
			model.addAttribute("data",personReport);
			
			//身份验证标识
			model.addAttribute("compStatus",personReport.getCompStatus());
			
			/**
			 * 二、驾驶证信息
			 */
			
			model.addAttribute("driverInfo",json.writeValueAsString(personReport.getDriverList()));
			
			/**
			 * 三、个人对外投资信息
			 */
			
			//失信被执行人信息
			model.addAttribute("punishBreakInfo", personReport.getInvestPunishBreakList());
			
			//被执行人信息
			model.addAttribute("punishedInfo", personReport.getInvestPunishedList());
			
			//企业法定代表人
			model.addAttribute("ryposfrInfo", json.writeValueAsString(personReport.getInvestRyposfrList()));
			
			//管理人员
			model.addAttribute("ryposperInfo", json.writeValueAsString(personReport.getInvestRyposperList()));
			
			//企业股东
			model.addAttribute("ryposshaInfo", json.writeValueAsString(personReport.getInvestRyposshaList()));
			
			/**
			 * 四、个人司法信息
			 */
			
			//曝光台
			model.addAttribute("riskBgtInfo", json.writeValueAsString(personReport.getRiskBgtList()));
			
			//裁判文书
			model.addAttribute("riskCpwsInfo", personReport.getRiskCpwsList());
			
			//失信公告
			model.addAttribute("riskDishonerInfo", personReport.getRiskDishonerList());
			
			//网贷黑名单
			model.addAttribute("riskNetloadInfo", personReport.getRiskNetloadList());
			
			//执行公告
			model.addAttribute("riskExecuteDocInfo", personReport.getRiskExecuteDocList());
			
			/**
			 * 五、阿里欠贷信息
			 */
			model.addAttribute("invesAlidebtInfo", personReport.getInvestAlidebtList());
			
			/**
			 * 七、银联三要素验证
			 */
			model.addAttribute("verifyBankCardInfo", json.writeValueAsString(personReport.getVrifyBankCardList()));
			
			
			/**
			 * 七、个人消费 
			 */
			
			//资产状况及交易行为
			model.addAttribute("reportBasicInfo", personReport.getReportBasicList());
			
			
			//消费大类分布
			model.addAttribute("reportConsumeCategoryInfo", json.writeValueAsString(personReport.getReportConsumeCategoryList()));
			
			//城市消费状况
			model.addAttribute("reportConsumeCityInfo", json.writeValueAsString(personReport.getReportConsumeCityList()));
			
			//每月消费状况
			model.addAttribute("reportMonthConsumeInfo", json.writeValueAsString(personReport.getReportMonthComsumeList()));
			
			//消费行为
			model.addAttribute("reportTransBehivorInfo", personReport.getReportConsumeBehaviorList());
			
			//信用相关交易统计
			model.addAttribute("reportTransCreditInfo", json.writeValueAsString(personReport.getReportTransCreditList()));
			
		   
        } catch (Exception e) {
            model.addAttribute("errorMeg", "查询征信报告详情错误");
            log.error("查询征信报告详情错误", e);
        }
		return "person/person-creditReport-detail";
	}

}
