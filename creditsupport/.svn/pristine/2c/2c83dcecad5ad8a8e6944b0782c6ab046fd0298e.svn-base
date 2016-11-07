package com.yodata.creditsupport.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.creditsupport.orm.entity.DictEntity;
import com.yodata.creditsupport.orm.entity.ScoreModelEntity;
import com.yodata.creditsupport.orm.vo.IndicatorScoreWeight;
import com.yodata.creditsupport.service.IDictService;
import com.yodata.creditsupport.service.IIndicatorScoreService;
import com.yodata.creditsupport.service.IScoreLevelService;
import com.yodata.creditsupport.service.IScoreModelService;
import com.yodata.creditsupport.util.ReportPdfUtils;


@Controller
@RequestMapping("/indicator-score")
public class IndicatorScoreAction extends BasicAction{
    private final Log log= LogFactory.getLog(IndicatorScoreAction.class);
    
    @Resource
    private IIndicatorScoreService indicatorScoreServiceImpl;
    
    @Resource
    private IDictService dictService;
    @Resource
	private IScoreLevelService scoreLevelServiceImpl;
    
    @Resource
    private IScoreModelService scoreModelServiceImpl;
    @RequestMapping(value="/indexReport")
    public String indexReport(HttpServletRequest request){
    	Map<String, Object> queryScoeLevel = scoreLevelServiceImpl.queryScoeLevel();
    	queryScoeLevel.get("rows");
    	request.setAttribute("tip", queryScoeLevel.get("rows"));
    	return "index-report";
    }
    /**
     * 查询所有指标得分及权重信息
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value="/queryAllInfo",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> queryAllInfo(@RequestParam(required=true) String regId,
            @RequestParam(required=false) String algorithmType){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> indiArr = new ArrayList<Map<String, Object>>();
		try{
		    if(StringUtils.isEmpty(algorithmType)){
                ScoreModelEntity se = scoreModelServiceImpl.getScoreModelEntityByRegId(regId);
                if(se != null && se.getModelCode() != null){
                    algorithmType = se.getModelCode().trim();
                } else {
                    algorithmType =  "Delphi";
                } 
            }
		    //总分
		    IndicatorScoreWeight totalScore = indicatorScoreServiceImpl.getIndicatorScoreByTotal(regId, algorithmType);
		    //指标大类,不为空时转为map，方便下面使用
		    List<IndicatorScoreWeight> topLevelList = indicatorScoreServiceImpl.getIndicatorScoreListByLevel1(regId, algorithmType);
		    Map<String, IndicatorScoreWeight> topMap = null;
		    if(topLevelList != null && !topLevelList.isEmpty()){
		        topMap = new HashMap<String, IndicatorScoreWeight>();
		        for(IndicatorScoreWeight topIsw : topLevelList){
		            topMap.put(topIsw.getLevel1(), topIsw);
		        }
		    }
		    //一级指标分类,不为空时转为map，方便下面使用
		    List<IndicatorScoreWeight> firstLevelList = indicatorScoreServiceImpl.getIndicatorScoreListByLevel2(regId, algorithmType);
		    Map<String, IndicatorScoreWeight> firstMap = null;
            if(firstLevelList != null && !firstLevelList.isEmpty()){
                firstMap = new HashMap<String, IndicatorScoreWeight>();
                for(IndicatorScoreWeight firstIsw : firstLevelList){
                    firstMap.put(firstIsw.getLevel2(), firstIsw);
                }
            }
            
            //行业属性数据字典
            List<DictEntity> indAttrList = dictService.getDictsByCategory("100004");
            Map<String, String> indAttrMap = null;
            if(indAttrList != null && !indAttrList.isEmpty()){
                indAttrMap = new HashMap<String, String>();
                for(DictEntity indAttr : indAttrList){
                    indAttrMap.put(indAttr.getValue(), indAttr.getName());
                }
            }
		    List<IndicatorScoreWeight> list = indicatorScoreServiceImpl.getIndicatorScoreList(regId, algorithmType);
		    if(totalScore != null 
		            && topMap != null 
		            && firstMap != null
		            && list != null && !list.isEmpty()){
		        DecimalFormat df = new DecimalFormat("0.00%");
	            df.setRoundingMode(RoundingMode.HALF_UP);
		        //添加总分
		        Map<String, Object> obj = new HashMap<String, Object>();
		        obj.put("id", "");
		        obj.put("topLevel", totalScore.getIndicatorName());
		        obj.put("topLevelcount", 0);
		        obj.put("firstLevel", "");
		        obj.put("firstLevelcount", 0);
		        obj.put("secondLevelName", "");
		        obj.put("secondLevelWeight", "100%");
		        obj.put("secondLevelScore", Math.round(totalScore.getScore()));
		        obj.put("secondLevelUrl", "");
		        obj.put("indAttr", "");
	            indiArr.add(obj);
		        //添加各个指标
		        for(IndicatorScoreWeight isw : list){
		            obj = new HashMap<String, Object>();
		            obj.put("id", isw.getId());
		            //指标大类的名称和得分一起显示
		            obj.put("topLevel", isw.getLevel1() + "<br>得分："
		                    + (topMap.get(isw.getLevel1()).getLevel1Score() == null 
		                        ? "-" : topMap.get(isw.getLevel1()).getLevel1Score())
		                    +  " <br>权重：" + df.format(topMap.get(isw.getLevel1()).getLevel1Weight()));
		            //添加指标大类的指标数量及得分
		            obj.put("topLevelcount", topMap.get(isw.getLevel1()).getLevel1Count());
		            obj.put("firstLevel", isw.getLevel2() + "<br>得分：" 
		                    + (firstMap.get(isw.getLevel2()).getLevel2Score() == null 
		                        ? "-" : firstMap.get(isw.getLevel2()).getLevel2Score())
		                    + " <br>权重：" + df.format(firstMap.get(isw.getLevel2()).getLevel2Weight()));
		            obj.put("firstLevelcount", firstMap.get(isw.getLevel2()).getLevel2Count());
		            obj.put("secondLevelName", isw.getIndicatorName());
		            obj.put("secondLevelWeight", df.format(isw.getWeight()));
		            
		            obj.put("secondLevelScore", isw.getScore() == null ? "无数据不参与评分" : isw.getScore());
		            obj.put("secondLevelUrl", isw.getDetailURL());
		            obj.put("indicator", isw.getIndicator());
		            //行业属性
		            if(indAttrMap != null){
		                obj.put("indAttr", indAttrMap.get(isw.getIndAttr()));
		            } else {
		                obj.put("indAttr", "");
		            }
		            indiArr.add(obj);
		        }
		        result.put("total", list.size());
		        result.put("rows", indiArr);
		    } else {
		        result.put("code", 0);
	            result.put("message", "此公司尚未生成评分报告");
	            log.info("公司" + regId + "尚未生成评分报告");
		    }
		} catch (SQLException e) {
            e.printStackTrace();
            result.put("code", 0);
            result.put("message", "数据库执行出错");
            log.error("数据库执行出错", e);
        } catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("message", "程序执行出错");
			log.error("程序执行出错", e);
		}
        return result;
    }
	@RequestMapping(value="/queryOneInfo",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> queryOneInfo(@RequestParam(required=true) String regId,
            @RequestParam(required=false) String algorithmType,@RequestParam(defaultValue="1") String type){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> indiArr = new ArrayList<Map<String, Object>>();
		try{
		    if(StringUtils.isEmpty(algorithmType)){
                ScoreModelEntity se = scoreModelServiceImpl.getScoreModelEntityByRegId(regId);
                if(se != null && se.getModelCode() != null){
                    algorithmType = se.getModelCode().trim();
                } else {
                    algorithmType =  "Delphi";
                } 
            }
		    
		    //总分
		    IndicatorScoreWeight totalScore = indicatorScoreServiceImpl.getIndicatorScoreByTotal(regId, algorithmType);
		    //指标大类,不为空时转为map，方便下面使用
		    List<IndicatorScoreWeight> topLevelList = indicatorScoreServiceImpl.getIndicatorScoreLevel1ByAttr(regId, algorithmType, type);
		    Map<String, IndicatorScoreWeight> topMap = null;
		    if(topLevelList != null && !topLevelList.isEmpty()){
		        topMap = new HashMap<String, IndicatorScoreWeight>();
		        for(IndicatorScoreWeight topIsw : topLevelList){
		            topMap.put(topIsw.getLevel1(), topIsw);
		        }
		    }
		    //一级指标分类,不为空时转为map，方便下面使用
		    List<IndicatorScoreWeight> firstLevelList = indicatorScoreServiceImpl.getIndicatorScoreLevel2ByAttr(regId, algorithmType, type);
		    Map<String, IndicatorScoreWeight> firstMap = null;
            if(firstLevelList != null && !firstLevelList.isEmpty()){
                firstMap = new HashMap<String, IndicatorScoreWeight>();
                for(IndicatorScoreWeight firstIsw : firstLevelList){
                    firstMap.put(firstIsw.getLevel2(), firstIsw);
                }
            }
            
            //行业属性数据字典
            List<DictEntity> indAttrList = dictService.getDictsByCategory("100004");
            Map<String, String> indAttrMap = null;
            if(indAttrList != null && !indAttrList.isEmpty()){
                indAttrMap = new HashMap<String, String>();
                for(DictEntity indAttr : indAttrList){
                    indAttrMap.put(indAttr.getValue(), indAttr.getName());
                }
            }
            
		    List<IndicatorScoreWeight> list = indicatorScoreServiceImpl.getIndicatorScoreList(regId, algorithmType);
		    List<IndicatorScoreWeight> list1 = new ArrayList<>();
		    
		    Double score = 0.0d;	//通用类或行业类指标 得分
		    Double weight = 0.0d;	//通用类或行业类指标 权重
            Double score2 = 0.0d;
		    for(IndicatorScoreWeight isw : list) {
		    	if(type.equals(isw.getIndAttr())) {
		    		if(isw.getWeight() != null)
		    			weight += isw.getWeight();
		    		if(isw.getScore() != null)
		    			score += isw.getScore();
		    		list1.add(isw);
		    	} else {
		    		if(isw.getScore() != null)
		    			score2 += isw.getScore();
		    	}
		    }
		    if(totalScore != null 
		            && topMap != null 
		            && firstMap != null
		            && list1 != null && !list1.isEmpty()){
		    	if("1".equals(type)) {
		    		score = totalScore.getScore() - score2;
		    	}
		    	score = new BigDecimal(score).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		    	Map<String, Object> obj = new HashMap<String, Object>();
		    	obj.put("topLevel", "百分制得分");
		    	obj.put("firstLevel", "");
		    	obj.put("secondLevelName", "");
		    	obj.put("secondLevelWeight", "100%");
		    	if(weight == 0.0d) {
		    		obj.put("secondLevelScore", "0");
		    	} else {
		    		obj.put("secondLevelScore", new BigDecimal(score/weight).setScale(0, BigDecimal.ROUND_HALF_UP));
		    	}
		    	indiArr.add(obj);
		    	DecimalFormat df = new DecimalFormat("0.00%");
	            df.setRoundingMode(RoundingMode.HALF_UP);
		        DecimalFormat d = new DecimalFormat("0.00");
	            d.setRoundingMode(RoundingMode.HALF_UP);
		        obj = new HashMap<String, Object>();
		        obj.put("id", "");
		        obj.put("topLevel", totalScore.getIndicatorName());
		        obj.put("topLevelcount", 0);
		        obj.put("firstLevel", "");
		        obj.put("firstLevelcount", 0);
		        obj.put("secondLevelName", "");
		        obj.put("secondLevelWeight", d.format(weight));
		        obj.put("secondLevelScore", score);
		        obj.put("secondLevelUrl", "");
		        obj.put("indAttr", "");
	            indiArr.add(obj);
		        //添加各个指标
	            for(IndicatorScoreWeight isw : list1){
		            obj = new HashMap<String, Object>();
		            obj.put("id", isw.getId());
		            //指标大类的名称和得分一起显示
		            obj.put("topLevel", isw.getLevel1() + "<br>得分："
		                    + (topMap.get(isw.getLevel1()).getLevel1Score() == null
		                        ? "-" : topMap.get(isw.getLevel1()).getLevel1Score())
		                    +  " <br>权重：" + df.format(topMap.get(isw.getLevel1()).getLevel1Weight()));
		            //添加指标大类的指标数量及得分
		            obj.put("topLevelcount", topMap.get(isw.getLevel1()).getLevel1Count());
		            obj.put("firstLevel", isw.getLevel2() + "<br>得分：" 
		                    + (firstMap.get(isw.getLevel2()).getLevel2Score() == null
		                        ? "-" : firstMap.get(isw.getLevel2()).getLevel2Score())
		                    + " <br>权重：" + df.format(firstMap.get(isw.getLevel2()).getLevel2Weight()));
		            obj.put("firstLevelcount", firstMap.get(isw.getLevel2()).getLevel2Count());
		            obj.put("secondLevelName", isw.getIndicatorName());
		            obj.put("secondLevelWeight", df.format(isw.getWeight()));
		            obj.put("secondLevelScore", isw.getScore() == null ? "无数据不参与评分" : isw.getScore());
		            obj.put("secondLevelUrl", isw.getDetailURL());
		            obj.put("indicator", isw.getIndicator());
		            //行业属性
		            if(indAttrMap != null){
		                obj.put("indAttr", indAttrMap.get(isw.getIndAttr()));
		            } else {
		                obj.put("indAttr", "");
		            }
		            indiArr.add(obj);
		        }
		        result.put("total", list1.size());
		        result.put("rows", indiArr);
		    } else {
		        result.put("code", 0);
	            result.put("message", "此公司尚未生成评分报告");
	            log.info("公司" + regId + "尚未生成评分报告");
		    }
		} catch (SQLException e) {
            e.printStackTrace();
            result.put("code", 0);
            result.put("message", "数据库执行出错");
            log.error("数据库执行出错", e);
        } catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("message", "程序执行出错");
			log.error("程序执行出错", e);
		}
        return result;
    }
	
    /**
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value="/createOneInfo/{regId}/{algorithmType}",produces="application/pdf")
    public void createOneInfo(@PathVariable String regId,
    		@PathVariable String algorithmType,
            HttpServletResponse response){
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> indiArr = new ArrayList<Map<String, Object>>();
		try{
		    if(StringUtils.isEmpty(algorithmType)){
                ScoreModelEntity se = scoreModelServiceImpl.getScoreModelEntityByRegId(regId);
                if(se != null && se.getModelCode() != null){
                    algorithmType = se.getModelCode().trim();
                } else {
                    algorithmType =  "Delphi";
                } 
            }
		    //总分
		    IndicatorScoreWeight totalScore = indicatorScoreServiceImpl.getIndicatorScoreByTotal(regId, algorithmType);
		    //指标大类,不为空时转为map，方便下面使用
		    List<IndicatorScoreWeight> topLevelList = indicatorScoreServiceImpl.getIndicatorScoreListByLevel1(regId, algorithmType);
		    Map<String, IndicatorScoreWeight> topMap = null;
		    if(topLevelList != null && !topLevelList.isEmpty()){
		        topMap = new HashMap<String, IndicatorScoreWeight>();
		        for(IndicatorScoreWeight topIsw : topLevelList){
		            topMap.put(topIsw.getLevel1(), topIsw);
		        }
		    }
		    //一级指标分类,不为空时转为map，方便下面使用
		    List<IndicatorScoreWeight> firstLevelList = indicatorScoreServiceImpl.getIndicatorScoreListByLevel2(regId, algorithmType);
		    Map<String, IndicatorScoreWeight> firstMap = null;
            if(firstLevelList != null && !firstLevelList.isEmpty()){
                firstMap = new HashMap<String, IndicatorScoreWeight>();
                for(IndicatorScoreWeight firstIsw : firstLevelList){
                    firstMap.put(firstIsw.getLevel2(), firstIsw);
                }
            }
            
            //行业属性数据字典
            List<DictEntity> indAttrList = dictService.getDictsByCategory("100004");
            Map<String, String> indAttrMap = null;
            if(indAttrList != null && !indAttrList.isEmpty()){
                indAttrMap = new HashMap<String, String>();
                for(DictEntity indAttr : indAttrList){
                    indAttrMap.put(indAttr.getValue(), indAttr.getName());
                }
            }
		    
		    List<IndicatorScoreWeight> list = indicatorScoreServiceImpl.getIndicatorScoreList(regId, algorithmType);
		    if(totalScore != null 
		            && topMap != null 
		            && firstMap != null
		            && list != null && !list.isEmpty()){
		        DecimalFormat df = new DecimalFormat("0.00%");
		        df.setRoundingMode(RoundingMode.HALF_UP);
		        
		        //添加总分
	            result.put("totalLevelName", totalScore.getIndicatorName());
	            result.put("totalLevelWeight", "100%");
//	            Integer tScore = new BigDecimal(totalScore.getScore()).setScale(2, BigDecimal.ROUND_HALF_UP).intValue();
	            result.put("totalLevelScore", Math.round(totalScore.getScore()));
		        //添加各个指标
	            Map<String, Object> obj;
	            Map<String, String> isFirst = new HashMap<>();
		        for(IndicatorScoreWeight isw : list){
		            obj = new HashMap<String, Object>();
		            //指标大类的名称和得分一起显示
		            if(!isFirst.containsKey("topLevel" + isw.getLevel1())) {
		            	obj.put("topLevel", isw.getLevel1() + "<br/>得分："
		            			+ topMap.get(isw.getLevel1()).getLevel1Score()
		            			+  " <br/>权重：" + df.format(topMap.get(isw.getLevel1()).getLevel1Weight()));
		            	//添加指标大类的指标数量及得分
		            	obj.put("topLevelcount", topMap.get(isw.getLevel1()).getLevel1Count());
		            	
		            	isFirst.put("topLevel" + isw.getLevel1(), "");
		            }
		            if(!isFirst.containsKey("firstLevel" + isw.getLevel2())) {
		            	obj.put("firstLevel", isw.getLevel2() + "<br/>得分：" 
		            			+ firstMap.get(isw.getLevel2()).getLevel2Score()
		            			+ " <br/>权重：" + df.format(firstMap.get(isw.getLevel2()).getLevel2Weight()));
		            	obj.put("firstLevelcount", firstMap.get(isw.getLevel2()).getLevel2Count());
		            	isFirst.put("firstLevel" + isw.getLevel2(), "");
		            }
		            obj.put("secondLevelName", isw.getIndicatorName());
		            obj.put("secondLevelWeight", df.format(isw.getWeight()));
		            
		            obj.put("secondLevelScore", isw.getScore() == null ? "无数据" : isw.getScore());
		            //行业属性
		            if(indAttrMap != null){
		                obj.put("indAttr", indAttrMap.get(isw.getIndAttr()));
		            } else {
		                obj.put("indAttr", "");
		            }
		            indiArr.add(obj);
		        }
		        Map<String, String> mList = scoreModelServiceImpl.getScoreModelMap();
		        Map<String, Object> desc = scoreLevelServiceImpl.queryScoeLevel();
		        Map<String, Object> agentInfo = scoreLevelServiceImpl.getAgentSampleInfo(regId);
		        result.put("rows", indiArr);
		        result.put("compName", agentInfo.get("comp_name"));
		        result.put("desc", desc.get("rows"));
		        result.put("algor", mList.get(algorithmType));
		        ReportPdfUtils pdf = new ReportPdfUtils(request.getSession().getServletContext().getRealPath("/"));
		        pdf.createScoreReport(result,response, "report-score1.htm", agentInfo.get("reg_id") + "_score_" + algorithmType);
		    } else {
	            log.info("公司" + regId + "尚未生成评分报告");
		    }
		} catch (SQLException e) {
            e.printStackTrace();
            log.error("数据库执行出错", e);
        } catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("message", "程序执行出错");
			log.error("程序执行出错", e);
		}
    }
    
	/**
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value="/createTwoInfo/{regId}/{algorithmType}",produces="application/pdf")
    public void createTwoInfo(@PathVariable String regId,
    		@PathVariable String algorithmType,
            HttpServletResponse response){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> indiArr1 = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> indiArr2 = new ArrayList<Map<String, Object>>();
		try{
			if(StringUtils.isEmpty(algorithmType)){
                ScoreModelEntity se = scoreModelServiceImpl.getScoreModelEntityByRegId(regId);
                if(se != null && se.getModelCode() != null){
                    algorithmType = se.getModelCode().trim();
                } else {
                    algorithmType =  "Delphi";
                } 
            }
		    //总分
		    IndicatorScoreWeight totalScore = indicatorScoreServiceImpl.getIndicatorScoreByTotal(regId, algorithmType);
		    //指标大类,不为空时转为map，方便下面使用
		    List<IndicatorScoreWeight> topLevelList = indicatorScoreServiceImpl.getIndicatorScoreListByLevel1(regId, algorithmType);
		    Map<String, IndicatorScoreWeight> topMap = null;
		    if(topLevelList != null && !topLevelList.isEmpty()){
		        topMap = new HashMap<String, IndicatorScoreWeight>();
		        for(IndicatorScoreWeight topIsw : topLevelList){
		            topMap.put(topIsw.getLevel1(), topIsw);
		        }
		    }
		    //一级指标分类,不为空时转为map，方便下面使用
		    List<IndicatorScoreWeight> firstLevelList = indicatorScoreServiceImpl.getIndicatorScoreListByLevel2(regId, algorithmType);
		    Map<String, IndicatorScoreWeight> firstMap = null;
            if(firstLevelList != null && !firstLevelList.isEmpty()){
                firstMap = new HashMap<String, IndicatorScoreWeight>();
                for(IndicatorScoreWeight firstIsw : firstLevelList){
                    firstMap.put(firstIsw.getLevel2(), firstIsw);
                }
            }
            
            //行业属性数据字典
            List<DictEntity> indAttrList = dictService.getDictsByCategory("100004");
            Map<String, String> indAttrMap = null;
            if(indAttrList != null && !indAttrList.isEmpty()){
                indAttrMap = new HashMap<String, String>();
                for(DictEntity indAttr : indAttrList){
                    indAttrMap.put(indAttr.getValue(), indAttr.getName());
                }
            }
            
            List<IndicatorScoreWeight> list1 = new ArrayList<>();
            List<IndicatorScoreWeight> list2 = new ArrayList<>();
		    List<IndicatorScoreWeight> list = indicatorScoreServiceImpl.getIndicatorScoreList(regId, algorithmType);
		    
		    //现在代码固定了 这两个指标值的含义
		    Double weight1 = 0.0d;	//通用类指标 权重合计
            Double weight2 = 0.0d;	//行业类指标 权重合计
            Double score1 = 0.0d;	//通用类指标 得分合计
            Double score2 = 0.0d;	//行业类指标 得分合计
            if(list != null && !list.isEmpty()){
                for(IndicatorScoreWeight isw : list) {
                    if("1".equals(isw.getIndAttr())) {
                        if(isw.getWeight() != null)
                            weight1 += isw.getWeight();
                        if(isw.getScore() != null)
                            score1 += isw.getScore();
                        list1.add(isw);
                    } else {
                        if(isw.getScore() != null)
                            score2 += isw.getScore();
                        list2.add(isw);
                    }
                }
            }
		    weight2 = 1 - weight1;
		    if(weight1 == 0.0d) {
		    	result.put("score1per", "0");
			} else {
				result.put("score1per", new BigDecimal(score1/weight1).setScale(0, BigDecimal.ROUND_HALF_UP));
			}
			if(weight2 == 0.0d) {
				result.put("score2per", 0);
			} else {
				result.put("score2per", new BigDecimal(score2/weight2).setScale(0, BigDecimal.ROUND_HALF_UP));
			}
		    
		    if(totalScore != null 
		            && topMap != null 
		            && firstMap != null
		            && list != null && !list.isEmpty()){
		    	score1 = totalScore.getScore() - score2;
		    	score1 = new BigDecimal(score1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		    	score2 = new BigDecimal(score2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        DecimalFormat df = new DecimalFormat("0.00%");
	            df.setRoundingMode(RoundingMode.HALF_UP);
		        DecimalFormat dd = new DecimalFormat("0%");
	            dd.setRoundingMode(RoundingMode.HALF_UP);
		        //添加总分
	            result.put("totalLevelName", totalScore.getIndicatorName());
	            result.put("totalLevelWeight1", dd.format(weight1));
	            result.put("totalLevelWeight2", dd.format(weight2));
	            result.put("totalLevelScore1", score1);
	            result.put("totalLevelScore2", score2);
		        //添加各个指标
	            Map<String, Object> obj;
	            Map<String, Map<String, Object>> isFirst = new HashMap<>();
	            for(IndicatorScoreWeight isw : list1) {
	            	obj = new HashMap<String, Object>();
		            //指标大类的名称和得分一起显示
		            if(!isFirst.containsKey("topLevel" + isw.getLevel1())) {
		            	obj.put("topLevel", isw.getLevel1());
		            	obj.put("topLevelScore", isw.getScore() == null ? 0 : isw.getScore());
		            	obj.put("topLevelWeight", isw.getWeight() == null ? 0 : isw.getWeight());
		            	obj.put("topLevelcount", 1);
		            	isFirst.put("topLevel" + isw.getLevel1(), obj);
		            } else {
		            	String topName = "topLevel" + isw.getLevel1();
		            	Map<String, Object> map = isFirst.get(topName);
		            	Integer i = (Integer)map.get("topLevelcount");
		            	Double w = (Double)map.get("topLevelWeight");
		            	Double s = (Double)map.get("topLevelScore");
		            	map.put("topLevelcount", ++i);
		            	if(isw.getWeight() != null) 
		            		w += isw.getWeight();
		            	if(isw.getScore() != null) 
		            		s += isw.getScore();
		            	map.put("topLevelWeight", w);
		            	map.put("topLevelScore", s);
		            }
		            if(!isFirst.containsKey("firstLevel" + isw.getLevel2())) {
		            	obj.put("firstLevel", isw.getLevel2());
		            	obj.put("firstLevelScore", isw.getScore() == null ? 0 : isw.getScore());
		            	obj.put("firstLevelWeight", isw.getWeight() == null ? 0 : isw.getWeight());
		            	obj.put("firstLevelcount", 1);
		            	isFirst.put("firstLevel" + isw.getLevel2(), obj);
		            } else {
		            	String firstName = "firstLevel" + isw.getLevel2();
		            	Map<String, Object> map = isFirst.get(firstName);
		            	Integer i = (Integer)map.get("firstLevelcount");
		            	Double w = (Double)map.get("firstLevelWeight");
		            	Double s = (Double)map.get("firstLevelScore");
		            	map.put("firstLevelcount", ++i);
		            	if(isw.getWeight() != null) 
		            		w += isw.getWeight();
		            	if(isw.getScore() != null) 
		            		s += isw.getScore();
		            	map.put("firstLevelWeight", w);
		            	map.put("firstLevelScore", s );
		            }
		            obj.put("secondLevelName", isw.getIndicatorName());
		            obj.put("secondLevelWeight", df.format(isw.getWeight()));
		            obj.put("secondLevelScore", isw.getScore() == null ? "无数据" : isw.getScore());
		            //行业属性
		            if(indAttrMap != null){
		                obj.put("indAttr", indAttrMap.get(isw.getIndAttr()));
		            } else {
		                obj.put("indAttr", "");
		            }
		            indiArr1.add(obj);
	            }
	            isFirst.clear();
	            for(IndicatorScoreWeight isw : list2) {
	            	obj = new HashMap<String, Object>();
		            //指标大类的名称和得分一起显示
		            if(!isFirst.containsKey("topLevel" + isw.getLevel1())) {
		            	obj.put("topLevel", isw.getLevel1());
		            	obj.put("topLevelScore", isw.getScore() == null ? 0 : isw.getScore());
		            	obj.put("topLevelWeight", isw.getWeight() == null ? 0 : isw.getWeight());
		            	obj.put("topLevelcount", 1);
		            	isFirst.put("topLevel" + isw.getLevel1(), obj);
		            } else {
		            	String topName = "topLevel" + isw.getLevel1();
		            	Map<String, Object> map = isFirst.get(topName);
		            	Integer i = (Integer)map.get("topLevelcount");
		            	Double w = (Double)map.get("topLevelWeight");
		            	Double s = (Double)map.get("topLevelScore");
		            	map.put("topLevelcount", ++i);
		            	if(isw.getWeight() != null) 
		            		w += isw.getWeight();
		            	if(isw.getScore() != null) 
		            		s += isw.getScore();
		            	map.put("topLevelWeight", w);
		            	map.put("topLevelScore", s);
		            }
		            if(!isFirst.containsKey("firstLevel" + isw.getLevel2())) {
		            	obj.put("firstLevel", isw.getLevel2());
		            	obj.put("firstLevelScore", isw.getScore() == null ? 0 : isw.getScore());
		            	obj.put("firstLevelWeight", isw.getWeight() == null ? 0 : isw.getWeight());
		            	obj.put("firstLevelcount", 1);
		            	isFirst.put("firstLevel" + isw.getLevel2(), obj);
		            } else {
		            	String firstName = "firstLevel" + isw.getLevel2();
		            	Map<String, Object> map = isFirst.get(firstName);
		            	Integer i = (Integer)map.get("firstLevelcount");
		            	Double w = (Double)map.get("firstLevelWeight");
		            	Double s = (Double)map.get("firstLevelScore");
		            	map.put("firstLevelcount", ++i);
		            	if(isw.getWeight() != null) 
		            		w += isw.getWeight();
		            	if(isw.getScore() != null) 
		            		s += isw.getScore();
		            	map.put("firstLevelWeight", w);
		            	map.put("firstLevelScore", s);
		            }
		            obj.put("secondLevelName", isw.getIndicatorName());
		            obj.put("secondLevelWeight", isw.getWeight() == null ? "无数据" : df.format(isw.getWeight()));
		            obj.put("secondLevelScore", isw.getScore() == null ? "无数据" : isw.getScore());
		            //行业属性
		            if(indAttrMap != null){
		                obj.put("indAttr", indAttrMap.get(isw.getIndAttr()));
		            } else {
		                obj.put("indAttr", "");
		            }
		            indiArr2.add(obj);
	            }
	            Map<String, String> mList = scoreModelServiceImpl.getScoreModelMap();
	            Map<String, Object> desc = scoreLevelServiceImpl.queryScoeLevel();
	            Map<String, Object> agentInfo = scoreLevelServiceImpl.getAgentSampleInfo(regId);
//	            Integer tScore = new BigDecimal(totalScore.getScore()).setScale(2, BigDecimal.ROUND_HALF_UP).intValue();
	            result.put("score", Math.round(totalScore.getScore()));
		        result.put("desc", desc.get("rows"));
		        result.put("compName", agentInfo.get("comp_name"));
		        result.put("rows1", indiArr1);
		        result.put("rows2", indiArr2);
		        result.put("algor", mList.get(algorithmType));
		        ReportPdfUtils pdf = new ReportPdfUtils(request.getSession().getServletContext().getRealPath("/"));
		        pdf.createScoreReport(result,response, "report-score2.htm", agentInfo.get("reg_id") + "_score_" + algorithmType);
		    } else {
	            log.info("公司" + regId + "尚未生成评分报告");
		    }
		} catch (SQLException e) {
            e.printStackTrace();
            log.error("数据库执行出错", e);
        } catch (Exception e) {
			e.printStackTrace();
			log.error("程序执行出错", e);
		}
    }
    
    /**
     * 查询注册资本信息
     * @param request
     * @param response
     * @return
     */
//	@RequestMapping(value="/queryCapitalGrowth",produces=MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Map<String, Object> queryIndiScoreWeight(@RequestParam(required=true) String regId){
//	    Map<String, Object> obj = new HashMap<String, Object>();
//	    try {
//	        //查询注册资金值及增长率
//            List<CapitalGrowth> list = indicatorScoreServiceImpl.getCapitalGrowthList(regId);
//            if(list != null && !list.isEmpty()){
//                //创建两个数组供前台页面展示
//                //注册资金
//                List<Map<String, Object>> capitals = new ArrayList<>();
//                //注册资金增长率
//                List<Map<String, Object>> growths = new ArrayList<>();
//                Map<String, Object> capObj = null;
//                Map<String, Object> growObj = null;
//                CapitalGrowth cg = null;
//                for(int i = list.size() - 1; i >= 0; i--){
//                    cg = list.get(i);
//                    //注册资金
//                    capObj = new HashMap<String, Object>();
//                    capObj.put("name", cg.getYear() + "年");
//                    capObj.put("y", (double)cg.getAmount());
//                    capitals.add(capObj);
//                    //增长率
//                    growObj = new HashMap<String, Object>();
//                    growObj.put("name", cg.getYear() + "年");
//                    growObj.put("y", (double)cg.getGrowth());
//                    growths.add(growObj);
//                }
//                obj.put("code", 1);
//                obj.put("capital", capitals);
//                obj.put("growth", growths);
//            } else {
//                obj.put("code", 0);
//                obj.put("message", "注册资金信息不存在");
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//            log.error("IndicatorScoreAction 执行出错");
//            obj.put("code", 0);
//            obj.put("message", "程序内部错误，请联系管理员");
//        }
//	    return obj;
//	}
	
}