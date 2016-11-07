package com.yodata.creditsupport.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.IndicatorEntity;
import com.yodata.creditsupport.orm.entity.ScoreModelEntity;
import com.yodata.creditsupport.service.IScoreModelService;
import com.yodata.creditsupport.service.IndicatorService;
import com.yodata.creditsupport.util.QueryParam;
import com.yodata.creditsupport.util.Validator;

@Controller
@RequestMapping("/scoreModel")
public class ScoreModelAction  extends BasicAction{

	private final Log log= LogFactory.getLog(ScoreModelAction.class);
	
	@Resource
	private IScoreModelService scoreModelServiceImpl;
	@Resource
    private IndicatorService indicatorServiceImpl;

	/**
	 * 算法训练，通过算法获取各指标的权重
	 * @param modelCode
	 * @return
	 */
	@RequestMapping(value="runAlgorithm",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Integer> runAlgorithm(@RequestParam String modelCode){
        try {
            return scoreModelServiceImpl.runAlgorithm(modelCode) ? new ResponseEntity<Integer>(1,HttpStatus.OK) : new ResponseEntity<Integer>(0,HttpStatus.OK);
        } catch (BusinessException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            return new ResponseEntity<Integer>(2,HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            return new ResponseEntity<Integer>(0,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	/**
	 * 根据选择的计算各企业的信用得分
	 */
	@RequestMapping(value="scoring",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Integer> getScoring(@RequestParam String modelCode){
		try {
            return scoreModelServiceImpl.getScoring(modelCode) ? new ResponseEntity<Integer>(1,HttpStatus.OK) : new ResponseEntity<Integer>(0,HttpStatus.OK);
        } catch (BusinessException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            return new ResponseEntity<Integer>(2,HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            return new ResponseEntity<Integer>(0,HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	/**
     * 根据算法查看权重
     */
    @RequestMapping(value="weight",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Map<String, Object>>> weight(String modelCode){
    	List<IndicatorEntity> list = indicatorServiceImpl.getAllEntityList(modelCode);
    	ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
    	Iterator<IndicatorEntity> iterator = list.iterator();
    	while(iterator.hasNext()){
    		Map<String, Object> map = new HashMap<String, Object>();
    		IndicatorEntity entity = iterator.next();
			double weight = entity.getWeight();
			//移除权重值为0的记录
			if(weight==0){
				iterator.remove();
				continue;
			}
			map.put("y", weight);
			map.put("name", entity.getIndName());
			result.add(map);
    	}
    	return new ResponseEntity<List<Map<String, Object>>>(result,HttpStatus.OK);
    }
    /**
     * 查询状态
     */
    @RequestMapping(value="status",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Integer> status(String modelCode){
    	return new ResponseEntity<Integer>(scoreModelServiceImpl.getStatusByModelCode(modelCode),HttpStatus.OK);
    }
	/**
     * 查询
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value="query",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> query(@RequestParam(required=false) Integer offset,@RequestParam(required=false) Integer limit){
        Map<String,Object> object = new HashMap<>();
        
        //查询分页条件
        String modelCode = request.getParameter("modelCode");
        String modelName = request.getParameter("modelName");
    	QueryParam queryParam = new QueryParam();
    	queryParam.setQueryCode(modelCode);
    	queryParam.setQueryName(modelName);
        queryParam.setOffset(offset==null?0:offset);
        queryParam.setLimit(limit==null?10:limit);
        try {
        	Map<String, Object> map = scoreModelServiceImpl.getPageScoreModels(queryParam);
        	if(map != null && !map.isEmpty()){
        		Integer count = (Integer) map.get("count");
        		List<ScoreModelEntity> list = (List<ScoreModelEntity>) map.get("data");
        		object.put("code", 0);
        		object.put("total", count);
        		object.put("rows", list);
        	}
		} catch (SQLException e) {
			e.printStackTrace();
			object.put("code", 0);
			object.put("message", "SQL程序执行出错");
			log.error("SQL执行错误", e);
		} catch (Exception e) {
			e.printStackTrace();
			object.put("code", 0);
			object.put("message", "程序执行出错");
			log.error("程序执行出错", e);
		}
        return object;
    }
    
    
    /**
     * 保存模型信息
     * @param ScoreModelEntity
     * @return
     */
    @RequestMapping(value="update",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> updateScoreModel(ScoreModelEntity scoreModelEntity){
    	Map<String, Object> obj = new HashMap<String, Object>();
    	if(scoreModelEntity == null ){
    		obj.put("code", 1);
    		obj.put("message", "评分模型信息不能为空");
    	} else if(!Validator.isFullName(scoreModelEntity.getModelName())){
    		obj.put("code", 1);
    		obj.put("message", "评分模型名称为长度在1-20之间的中文和英文字母、下划线、点符号、数字的组合");
    	} else if(!Validator.isStrNumber(scoreModelEntity.getModelCode())){
    		obj.put("code", 1);
    		obj.put("message", "评分模型编码为长度在1-20之间的英文字母、下划线、数字的组合");
    	} else {
    		try {
				// 校验模型名称是否已经存在
				boolean isExistName = scoreModelServiceImpl
						.getScoreModelEntityByName(scoreModelEntity.getModelName().trim(), scoreModelEntity.getModelId());
				if (isExistName) {
					obj.put("code", 2);
					obj.put("message", "评分模型名称已存在，请重新输入");
					return obj;
				}
				
				// 校验模型编码是否已经存在,新增时需要校验，修改时不可修改此字段，不做校验
				if(scoreModelEntity.getModelId() == null){
					scoreModelEntity.setStatus(0); //前端新增的算法模型都为不可用状态，当算法开发完成后需手动设置为1
				    ScoreModelEntity oldCode = scoreModelServiceImpl
				            .getScoreModelEntityByCode(scoreModelEntity.getModelCode().trim());
				    if (oldCode != null) {
				        obj.put("code", 2);
				        obj.put("message", "评分模型编码已存在，请重新输入");
				        return obj;
				    }
				}
    			
    			scoreModelServiceImpl.saveOrUpdateEntity(scoreModelEntity);
    			
    			obj.put("code", 0);
    			obj.put("message", "保存成功");
    		} catch (Exception e){
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
    @RequestMapping(value="delete",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> deleteScoreModel(@RequestParam(required=true) Integer id){
    	Map<String, Object> obj = new HashMap<String, Object>();
    	if(id == null || id == 0){
    		obj.put("code", 1);
    		obj.put("message", "此记录不存在");
    	} else {
    		try {
    			ScoreModelEntity entity = scoreModelServiceImpl.getScoreModelEntityByID(id);
    			if(entity == null){
    				obj.put("code", 1);
    	    		obj.put("message", "此记录不存在");
    			} else if(entity.getStatus() != 1){
    				scoreModelServiceImpl.deleteEntity(id);
    				obj.put("code", 0);
    				obj.put("message", "删除成功");
    			}else {
    				obj.put("code", 1);
    				obj.put("message", "‘" + entity.getModelName() + "’正在使用中，不能删除！");
    			}
    		} catch (Exception e){
    			e.printStackTrace();
    			obj.put("code", 1);
    			obj.put("message", "删除失败");
    		}
    	}
    	return obj;
    }
    
    /**
     * 查询
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value="queryAlgorithmType",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Object> queryAlgorithmType(){
        List<Object> array = new ArrayList<>();
        try {
            List<ScoreModelEntity> list = scoreModelServiceImpl.getScoreModels();
            if(list != null && !list.isEmpty()){
                for(ScoreModelEntity entity : list){
                	if(entity.getStatus() == 1) { //只过滤当前可用的算法
                		Map<String, Object> object = new HashMap<String, Object>();
                		object.put("value", entity.getModelCode());
                		object.put("name", entity.getModelName());
                		array.add(object);
                	}
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("程序执行出错", e);
        }
        return array;
    }
    
}
