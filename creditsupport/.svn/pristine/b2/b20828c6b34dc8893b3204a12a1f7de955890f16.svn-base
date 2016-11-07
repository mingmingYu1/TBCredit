package com.yodata.creditsupport.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.ScoreLevelEntity;
import com.yodata.creditsupport.service.IScoreLevelService;
import com.yodata.creditsupport.util.QueryParam;
import com.yodata.creditsupport.util.Validator;

@Controller
@RequestMapping("/scoreLevel")
public class ScoreLevelAction  extends BasicAction{

	private final Log log= LogFactory.getLog(ScoreLevelAction.class);
	
	@Resource
	private IScoreLevelService scoreLevelServiceImpl;
	  
	
	/**
     * 查询
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value="/query",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> query(@RequestParam(required=false) Integer offset,@RequestParam(required=false) Integer limit){
        Map<String, Object> object = new HashMap<String, Object>();
        //查询分页条件
        int versionId = Integer.parseInt((request.getParameter("versionId").toString()));
        try {
        	List<ScoreLevelEntity> list = scoreLevelServiceImpl.getScoreLevelEntityByVersionID(versionId);
        	object.put("code", 0);
        	object.put("total", (list==null || list.isEmpty()) ? 0: list.size());
        	object.put("rows", list);
		} catch (Exception e) {
			e.printStackTrace();
			object.put("code", 0);
			object.put("message", "程序执行出错");
			log.error("程序执行出错", e);
		}
        return object;
    }
    
    
    /**
     * 查询
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value="/queryScoeLevel",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> queryScoeLevel(){
     
        return  scoreLevelServiceImpl.queryScoeLevel();
    }
    
    
    
    /**
     * 保存评分等级信息
     * @param ScoreLevelEntity
     * @return
     */
    @RequestMapping(value="/update",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> updateScoreLevel(ScoreLevelEntity scoreLevelEntity){
    	Map<String, Object> obj = new HashMap<String, Object>();
    	if(scoreLevelEntity == null ){
    		obj.put("code", 1);
    		obj.put("message", "评分等级信息不能为空");
    	} else if(scoreLevelEntity.getLevelScoreMin() == null || scoreLevelEntity.getLevelScoreMax() == null){
    		obj.put("code", 1);
    		obj.put("message", "评分区间最小值和最大值都不能为空");
    	} else if(!Validator.isLevelName(scoreLevelEntity.getLevelName())){
    		obj.put("code", 1);
    		obj.put("message", "等级名称为英文大小写字母或+-符号的1~20长度组合");
    	} else {
    		try {
				// 校验评分区间是否已经存在
				boolean isExistScore = scoreLevelServiceImpl
						.getScoreLevelEntityByScore(scoreLevelEntity.getLevelScoreMin(),
						        scoreLevelEntity.getLevelScoreMax(), scoreLevelEntity.getId(),scoreLevelEntity.getLevelVersion());
				if (isExistScore) {
					obj.put("code", 2);
					obj.put("message", "评分区间已存在，请重新输入");
					return obj;
				}
				// 校验等级是否已经存在
				boolean isExistName = scoreLevelServiceImpl
						.getScoreLevelEntityByName(scoreLevelEntity.getLevelName().trim(), scoreLevelEntity.getId(),scoreLevelEntity.getLevelVersion());
				if (isExistName) {
					obj.put("code", 2);
					obj.put("message", "等级已存在，请重新输入");
					return obj;
				}
    			scoreLevelEntity.setLevelScore(scoreLevelEntity.getLevelScoreMin()
    			        + "~" + scoreLevelEntity.getLevelScoreMax());
    			scoreLevelServiceImpl.saveOrUpdateEntity(scoreLevelEntity);
    			
    			obj.put("code", 0);
    			obj.put("message", "保存成功");
    			log.info("保存成功");
    		} catch (BusinessException e){
    		    log.error(e.getMessage(), e);
                e.printStackTrace();
                obj.put("code", 1);
                obj.put("message", e.getMessage());
            } catch (Exception e){
                log.error(e.getMessage(), e);
    			e.printStackTrace();
    			obj.put("code", 1);
    			obj.put("message", "保存失败");
    		}
    	}
    	return obj;
    }
    
    
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value="/delete",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> deleteScoreLevel(@RequestParam(required=true) Integer id){
    	Map<String, Object> obj = new HashMap<String, Object>();
    	if(id == null || id == 0){
    		obj.put("code", 1);
    		obj.put("message", "此记录不存在");
    	} else {
    		try {
    			ScoreLevelEntity entity = scoreLevelServiceImpl.getScoreLevelEntityByID(id);
    			if(entity == null){
    				obj.put("code", 1);
    	    		obj.put("message", "此记录不存在");
    			} else {
    				scoreLevelServiceImpl.deleteEntity(id);
    				obj.put("code", 0);
    				obj.put("message", "删除成功");
    				log.info("删除成功");
    			}
    			
    		} catch (BusinessException e){
    		    log.error(e.getMessage(), e);
                e.printStackTrace();
                obj.put("code", 1);
                obj.put("message", e.getMessage());
            } catch (Exception e){
    		    log.error(e.getMessage(), e);
    			e.printStackTrace();
    			obj.put("code", 1);
    			obj.put("message", "删除失败");
    		}
    	}
    	return obj;
    }
    
    
    @RequestMapping(value="/getScoreLevel",produces=MediaType.APPLICATION_JSON_VALUE)
    public String reportDetail(Model model, @RequestParam Integer id){
    	Map<String, Object> object = new HashMap<String, Object>();
		 try {
			//查询分页条件
		        String condition = request.getParameter("condition");
		    	QueryParam queryParam = new QueryParam();
		    	queryParam.setCondition(condition);
		        queryParam.setOffset(0);
		        queryParam.setLimit(10);
		        Map<String, Object> map = scoreLevelServiceImpl.getPageScoreLevels(queryParam);
	        	if(map != null && !map.isEmpty()){
	        		Integer count = (Integer) map.get("count");
	        		List<ScoreLevelEntity> list = (List<ScoreLevelEntity>) map.get("data");
	        		object.put("code", 0);
	        		object.put("total", count);
	        		object.put("rows", list);
	        	}
			} catch (Exception e) {
				e.printStackTrace();
				object.put("code", 0);
				object.put("message", "程序执行出错");
				log.error("程序执行出错", e);
			}
		
		
		model.addAttribute("scoreLevelList", object);
		
		return "scoreLevel-detail";
	}
	
    
    
}
