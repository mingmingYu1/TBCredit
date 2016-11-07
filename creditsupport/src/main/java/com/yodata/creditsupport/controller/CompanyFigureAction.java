package com.yodata.creditsupport.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.creditsupport.orm.entity.AgentAlgorEntity;
import com.yodata.creditsupport.orm.entity.IndicatorEntity;
import com.yodata.creditsupport.orm.entity.ScoreLevelEntity;
import com.yodata.creditsupport.orm.entity.ScoreModelEntity;
import com.yodata.creditsupport.orm.vo.IndicatorAttr;
import com.yodata.creditsupport.orm.vo.IndicatorScoreWeight;
import com.yodata.creditsupport.service.IAgentAlgorService;
import com.yodata.creditsupport.service.IIndicatorScoreService;
import com.yodata.creditsupport.service.IScoreLevelService;
import com.yodata.creditsupport.service.IScoreModelService;
import com.yodata.creditsupport.service.IndicatorService;


@Controller
@RequestMapping("/company-figure")
public class CompanyFigureAction extends BasicAction{
    private final Log log= LogFactory.getLog(CompanyFigureAction.class);
    
    @Resource
    private IIndicatorScoreService indicatorScoreServiceImpl;
    
    @Resource
    private IScoreLevelService scoreLevelServiceImpl;
    
    @Resource
    private IndicatorService indicatorServiceImpl;
    
    @Resource
    private IScoreModelService scoreModelServiceImpl;
    
    @Resource
    private IAgentAlgorService agentAlgorServiceImpl;
    
    /**
     * 查询企业总得分及评级信息信息
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value="/queryCompScore",produces=MediaType.APPLICATION_JSON_VALUE)
    public String queryCompScore(Model model, @RequestParam(required=true) String regId,
            @RequestParam String compName, @RequestParam(required=false) String algorithmType){
	    
		model.addAttribute("regId", regId);
		model.addAttribute("compName", compName);
	    model.addAttribute("algorithmType", algorithmType);
		DecimalFormat dfPercent = new DecimalFormat("0%");
		dfPercent.setRoundingMode(RoundingMode.HALF_UP);
        DecimalFormat dfPercent2 = new DecimalFormat("0.00");
        dfPercent2.setRoundingMode(RoundingMode.HALF_UP);
		DecimalFormat dfDouble = new DecimalFormat("0");
		dfDouble.setRoundingMode(RoundingMode.HALF_UP);
	    try{
		    //总分
		    IndicatorScoreWeight totalScore = indicatorScoreServiceImpl.getIndicatorScoreByTotal(regId, algorithmType);
		    if(totalScore != null && totalScore.getScore() != null){
		        double score = Double.compare(totalScore.getScore(), (double) 0) < 0 
                        ? (double) 0 : totalScore.getScore();
		        //评分等级
		        ScoreLevelEntity scEntity = scoreLevelServiceImpl.getScoreLevelEntityByScore(score);
		        //指标大类得分权重
		        List<IndicatorScoreWeight> scoreWeightList = 
		                indicatorScoreServiceImpl.getIndicatorScoreListByLevel1(regId, algorithmType);
		        //各指标的值及属性
		        //（1）基本情况：经营时长（年）、股东数量（人）、法人股份占比（%）；
		        //（2）交易行为：月出票量（张）、月销售额（万元）、月出票增长率（%）；
		        //（3）履约能力：流动资产总额（万元）、流动负债总额（万元）、货币资金（万元）；
		        //（4）特殊事项：法院裁决违约（次）、法院裁决失信（次）；
		        IndicatorAttr indicatorAttr = indicatorScoreServiceImpl.getIndicatorAttrList(regId);
		        
		        model.addAttribute("score",Math.round(score));
		        if(scEntity != null){
		            model.addAttribute("level", scEntity.getLevelName());
		            model.addAttribute("desc", scEntity.getLevelDesc());
		        }
		        //基本类型得分及权重
		        if(scoreWeightList != null && !scoreWeightList.isEmpty()){
		            for(IndicatorScoreWeight isw : scoreWeightList){
		                if("基本信息".equalsIgnoreCase(isw.getLevel1())){
		                    model.addAttribute("basicInfo_weight", 
		                            dfPercent.format(isw.getLevel1Weight() != null ? isw.getLevel1Weight() : 0));
		                    model.addAttribute("basicInfo_score", 
		                            Math.round(isw.getLevel1Score()!= null ? isw.getLevel1Score() : 0));
		                } else if("交易行为".equalsIgnoreCase(isw.getLevel1())){
		                    model.addAttribute("trInfo_weight",
		                            dfPercent.format(isw.getLevel1Weight() != null ? isw.getLevel1Weight() : 0));
		                    model.addAttribute("trInfo_score",
		                            Math.round(isw.getLevel1Score()!= null ? isw.getLevel1Score() : 0));
		                } else if("履约能力".equalsIgnoreCase(isw.getLevel1())){
		                    model.addAttribute("capacityInfo_weight",
		                            dfPercent.format(isw.getLevel1Weight() != null ? isw.getLevel1Weight() : 0));
		                    model.addAttribute("capacityInfo_score",
		                            Math.round(isw.getLevel1Score()!= null ? isw.getLevel1Score() : 0));
		                } else if("特殊事项".equalsIgnoreCase(isw.getLevel1())){
		                    model.addAttribute("specialInfo_weight",
		                            dfPercent.format(isw.getLevel1Weight() != null ? isw.getLevel1Weight() : 0));
		                    model.addAttribute("specialInfo_score",
		                            Math.round(isw.getLevel1Score()!= null ? isw.getLevel1Score() : 0));
		                }
		            }
		        }
		        
		        //指标值
		        if(indicatorAttr != null){
		        	//基本信息
		            //经营时长（年）
		            model.addAttribute("basicInfo_dbsiOperatingYear", indicatorAttr.getDbsiOperatingYear());
		            //股东数量（人）
		            model.addAttribute("basicInfo_dbsiShareholderNum", indicatorAttr.getDbsiShareholderNum());
		            //法人股份占比（%）
		            model.addAttribute("basicInfo_dbsiLegalStock", indicatorAttr.getDbsiLegalStock() == null ? 0 : dfPercent2.format(indicatorAttr.getDbsiLegalStock()));
		            
		            //交易行为
		            // 月出票量（张）
		            model.addAttribute("trInfo_dtdbOrderAvgNum", indicatorAttr.getDtdbOrderAvgNum() == null ? 0 : dfDouble.format(indicatorAttr.getDtdbOrderAvgNum()));
		            // 月销售额（万元）
		            model.addAttribute("trInfo_dtdbOrderAmount", indicatorAttr.getDtdbOrderAmount() == null ? 0 : dfPercent2.format(indicatorAttr.getDtdbOrderAmount()));
		            // 月出票增长率（%）
		            model.addAttribute("trInfo_dtdbOrderAvgRate", indicatorAttr.getDtdbOrderAvgRate() == null ? 0 : dfPercent2.format(indicatorAttr.getDtdbOrderAvgRate()));
		            
		            //履约能力
		            // 流动资产总额（万元）
		            model.addAttribute("capacityInfo_dfncCurrentAssets", indicatorAttr.getDfncCurrentAssets() == null ? 0 : dfPercent2.format(indicatorAttr.getDfncCurrentAssets()));
		            // 流动负债总额（万元）
		            model.addAttribute("capacityInfo_dfncCurrentLiability", indicatorAttr.getDfncCurrentLiability() == null ? 0 : dfPercent2.format(indicatorAttr.getDfncCurrentLiability()));
		            // 货币资金（万元）
		            model.addAttribute("capacityInfo_dfncBankCash", indicatorAttr.getDfncBankCash() == null ? 0 : dfPercent2.format(indicatorAttr.getDfncBankCash()));
		            
		            //特殊事项
		            // 法院裁决违约（次）
		            model.addAttribute("specialInfo_dsmiBreachNum", indicatorAttr.getDsmiBreachNum());
		            // 法院裁决失信（次）
		            model.addAttribute("specialInfo_dsmiCreditbreakNum", indicatorAttr.getDsmiCreditbreakNum());
		        }
		    } else {
		        model.addAttribute("isNotExist", true);
		    }
		    
        } catch (Exception e) {
			e.printStackTrace();
			log.error("程序执行出错", e);
		}
        return "enterprise-portrait";
    }
    
    
    /**
     * 查询近6月信用历史记录
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value="/queryCreditScore",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> queryCreditScore(@RequestParam(required=true) String regId,
            @RequestParam(required=false) String algorithmType){
	    Map<String, Object> obj = new HashMap<String, Object>();
	    try {
	        //查询企业近6月信用得分
            List<Map<String, Object>> maps = indicatorScoreServiceImpl.getCreditScore(regId, algorithmType);
            if(maps != null && !maps.isEmpty()){
                //创建数组供前台页面展示
                List<Object> capitals = new ArrayList<Object>();
                
                Map<String, Object> capObj = null;
                Map<String, Object> map = null;
                for(int i = maps.size()-1; i >= 0; i--){
                    map = maps.get(i);
                    capObj = new HashMap<String, Object>();
                    capObj.put("name", map.get("year") + "年" + map.get("month") + "月");
                    Double score = ((BigDecimal) map.get("indiScore")).doubleValue();
                    capObj.put("y", map.get("indiScore") == null ? null 
                            : Double.compare(score, (double) 0) < 0
                            ? 0 : map.get("indiScore"));
                    capitals.add(capObj);
                }
                
                obj.put("code", 1);
                obj.put("creditScore", capitals);
            } else {
                obj.put("code", 0);
                obj.put("message", "企业近6月没有信用得分");
            }
        } catch (Exception e){
            e.printStackTrace();
            log.error("IndicatorScoreAction 执行出错");
            obj.put("code", 0);
            obj.put("message", "程序内部错误，请联系管理员");
        }
	    
	    return obj;
	
	}
	
	/**
     * 查询三级指标权重占比：三级指标对应评分指标
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/queryIndWeight",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> queryIndWeight(@RequestParam(required=true) String regId,
            @RequestParam(required=true) Integer type, 
            @RequestParam(required=false) String algorithmType){
        
        //type:1基本信息，2交易行为，3特殊事项，4履约能力
        Map<String, Object> obj = new HashMap<String, Object>();
        try {
            //算法类型，如果为空，则去数据库查询当前企业的使用算法，如果还为空，则默认为Delphi
            if(StringUtils.isEmpty(algorithmType)){
                ScoreModelEntity se = scoreModelServiceImpl.getScoreModelEntityByRegId(regId);
                if(se != null && se.getModelCode() != null){
                    algorithmType = se.getModelCode().trim();
                } else {
                    algorithmType =  "Delphi";
                } 
            }
            //指标大类得分权重
            List<IndicatorScoreWeight> scoreWeightList = 
                    indicatorScoreServiceImpl.getIndicatorScoreListByLevel1(regId, algorithmType);
            
            //各指标权重
            List<IndicatorEntity> indiWeights = indicatorServiceImpl.getAllEntityList(algorithmType);
            if(scoreWeightList != null && !scoreWeightList.isEmpty() 
                    && indiWeights != null && !indiWeights.isEmpty()){
                //创建数组供前台页面展示
                double sum = 0;
                double all = 0;
                List<Object> capitals = new ArrayList<Object>();
                Object[] weight = null;
                switch (type){
                case 1:
                    for(IndicatorEntity indiWeight : indiWeights){
                        if("基本信息".equalsIgnoreCase(indiWeight.getLevel1().trim())){
                            all += indiWeight.getWeight();
                        }
                        if("DBSI_OPERATING_YEAR".equalsIgnoreCase(indiWeight.getIndicator()) 
                                || "DBSI_SHAREHOLDER_NUM".equalsIgnoreCase(indiWeight.getIndicator())
                                || "DBSI_LEGAL_STOCK".equalsIgnoreCase(indiWeight.getIndicator())){
                            sum += indiWeight.getWeight();
                            weight = new Object[2];
                            weight[0] = indiWeight.getIndName();
                            weight[1] = indiWeight.getWeight();
                            capitals.add(weight);
                        }
                    }
                    break;
                case 2:
                    for(IndicatorEntity indiWeight : indiWeights){
                        if("交易行为".equalsIgnoreCase(indiWeight.getLevel1().trim())){
                            all += indiWeight.getWeight();
                        }
                        if("DTDB_ORDER_AVG_NUM".equalsIgnoreCase(indiWeight.getIndicator()) 
                                || "DTDB_ORDER_AMOUNT".equalsIgnoreCase(indiWeight.getIndicator())
                                || "DTDB_ORDER_AVG_RATE".equalsIgnoreCase(indiWeight.getIndicator())){
                            sum += indiWeight.getWeight();
                            weight = new Object[2];
                            weight[0] = indiWeight.getIndName();
                            weight[1] = indiWeight.getWeight();
                            capitals.add(weight);
                        }
                    }
                    break;
                case 3:
                  for(IndicatorEntity indiWeight : indiWeights){
                      if("特殊事项".equalsIgnoreCase(indiWeight.getLevel1().trim())){
                          all += indiWeight.getWeight();
                      }
                      if("DSMI_BREACH_NUM".equalsIgnoreCase(indiWeight.getIndicator()) 
                              || "DSMI_CREDITBREAK_NUM".equalsIgnoreCase(indiWeight.getIndicator())){
                          sum += indiWeight.getWeight();
                          weight = new Object[2];
                          weight[0] = indiWeight.getIndName();
                          weight[1] = indiWeight.getWeight();
                          capitals.add(weight);
                      }
                  }
                  break;
                case 4:
                  for(IndicatorEntity indiWeight : indiWeights){
                      if("履约能力".equalsIgnoreCase(indiWeight.getLevel1().trim())){
                          all += indiWeight.getWeight();
                      }
                      
                      if("DFNC_CURRENT_ASSETS".equalsIgnoreCase(indiWeight.getIndicator()) 
                              || "DFNC_CURRENT_LIABILITY".equalsIgnoreCase(indiWeight.getIndicator())
                              || "DFNC_BANK_CASH".equalsIgnoreCase(indiWeight.getIndicator())){
                          sum += indiWeight.getWeight();
                          weight = new Object[2];
                          weight[0] = indiWeight.getIndName();
                          weight[1] = indiWeight.getWeight();
                          capitals.add(weight);
                      }
                  }
                    break;
                }
                if((sum - all) >= 0.02 || (sum - all) <= -0.02){
                    weight = new Object[2];
                    weight[0] = "其他";
                    weight[1] = all - sum;
                    capitals.add(weight);
                }
                obj.put("code", 1);
                obj.put("indiWeight", capitals);
            } else {
                obj.put("code", 0);
                obj.put("message", "指标权重信息不存在");
            }
        } catch (Exception e){
            e.printStackTrace();
            log.error("IndicatorScoreAction 执行出错");
            obj.put("code", 0);
            obj.put("message", "程序内部错误，请联系管理员");
        }
        
        return obj;
    
    }
    
    /**
     * 查询一级指标权重占比
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/queryBasicIndWeight",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> queryBasicIndWeight(@RequestParam(required=true) String regId,
            @RequestParam(required=false) String algorithmType){
        Map<String, Object> obj = new HashMap<String, Object>();
        try {
            //指标大类得分权重
            List<IndicatorScoreWeight> scoreWeightList = 
                    indicatorScoreServiceImpl.getIndicatorScoreListByLevel1(regId, algorithmType);
            
            if(scoreWeightList != null && !scoreWeightList.isEmpty()){
                //创建数组供前台页面展示
                List<Object> capitals = new ArrayList<Object>();
                Object[] weight = null;
                for(IndicatorScoreWeight indiWeight : scoreWeightList){
                    weight = new Object[2];
                    weight[0] = indiWeight.getLevel1();
                    weight[1] = indiWeight.getLevel1Weight();
                    capitals.add(weight);
                }
                obj.put("code", 1);
                obj.put("indiWeight", capitals);
            } else {
                obj.put("code", 0);
                obj.put("message", "基本指标权重信息不存在");
            }
        } catch (Exception e){
            e.printStackTrace();
            log.error("IndicatorScoreAction 执行出错");
            obj.put("code", 0);
            obj.put("message", "程序内部错误，请联系管理员");
        }
        
        return obj;
    }
    
    /**
     * 企业当前算法是否已生成评分报告
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/checkAgentAlgor",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> checkAgentAlgor(@RequestParam(required=true) String regId,
            @RequestParam(required=false) String algorithmType){
        Map<String, Object> obj = new HashMap<String, Object>();
        try {
            //指标总得分
            IndicatorScoreWeight totalScore = indicatorScoreServiceImpl.getIndicatorScoreByTotal(regId, algorithmType);
            if(totalScore != null && totalScore.getScore() != null){
                obj.put("code", 2);
                obj.put("message", "您选择的算法已生成评分报告");
            } else {
                obj.put("code", 1);
                obj.put("message", "您选择的算法尚未生成评分报告，是否确定选择此算法？");
            }
        } catch (Exception e){
            e.printStackTrace();
            log.error("IndicatorScoreAction 执行出错");
            obj.put("code", 0);
            obj.put("message", "程序内部错误，请联系管理员");
        }
        
        return obj;
    }
	
    /**
     * 保存企业与算法的关联关系
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/saveAgentAlgor",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> saveAgentAlgor(@RequestParam(required=true) String regId,
            @RequestParam(required=true) String algorithmType){
        Map<String, Object> obj = new HashMap<String, Object>();
        try {
            ScoreModelEntity se = scoreModelServiceImpl.getScoreModelEntityByCode(algorithmType.trim());
            AgentAlgorEntity ae = agentAlgorServiceImpl.getEntityByRegId(regId);
            if(se != null && se.getModelId() != null){
                if(ae == null){
                    ae = new AgentAlgorEntity();
                    ae.setRegId(regId);
                    ae.setAlgorId(se.getModelId());
                    ae.setCreateTime(new Date());
                    ae.setUpdateTime(new Date());
                } else {
                    ae.setAlgorId(se.getModelId());
                    ae.setUpdateTime(new Date());
                }
                agentAlgorServiceImpl.saveOrUpdate(ae);
                obj.put("code", 1);
                obj.put("message", "保存成功");
                log.info("保存成功");
            } else {
                obj.put("code", 0);
                obj.put("message", "您选择的算法不存在");
                log.info("您选择的算法不存在");
            }
        } catch (Exception e){
            e.printStackTrace();
            log.error("CompanyFigureAction 执行出错");
            obj.put("code", 0);
            obj.put("message", "程序内部错误，请联系管理员");
        }
        
        return obj;
    }
    
}