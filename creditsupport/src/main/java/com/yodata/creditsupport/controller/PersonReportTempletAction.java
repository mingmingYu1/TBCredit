package com.yodata.creditsupport.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.creditsupport.orm.person.entity.PersonReportTempletEntity;
import com.yodata.creditsupport.service.IPersonReportTempletService;
import com.yodata.creditsupport.util.QueryParam;

@Controller
@RequestMapping("/personReportTemplet")
public class PersonReportTempletAction extends BasicAction {
	private final Log log= LogFactory.getLog(PersonReportTempletAction.class);
	
	@Resource
	private IPersonReportTempletService temService;
	
	@RequestMapping(value="/query",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> queryTemplet(@RequestParam(required=false) Integer offset,@RequestParam(required=false) Integer limit){
		Map<String, Object> object = new HashMap<String, Object>();
		
		//查询分页条件
        String number = request.getParameter("number");
        String name = request.getParameter("name");
    	QueryParam queryParam = new QueryParam();
    	queryParam.setQueryCode(number);
    	queryParam.setQueryName(name);
        queryParam.setOffset(offset==null?0:offset);
        queryParam.setLimit(limit==null?10:limit);
        String sort = request.getParameter("sort");
    	String order = request.getParameter("order");
    	if(StringUtils.isNotEmpty(sort) && StringUtils.isNotEmpty(order)){
    		queryParam.setSortStr(sort + " " + order);
    	}
    	
    	try {
    		Map<String, Object> map = temService.getPageTemplet(queryParam);
    		if(map != null && !map.isEmpty()) {
    			Integer count = (Integer) map.get("count");
    			List<PersonReportTempletEntity> list = (List<PersonReportTempletEntity>) map.get("data");
    			List<Map<String, Object>> rows = new ArrayList<>();
        		if(list != null && !list.isEmpty()){
        			Map<String, Object> obj = null;
        			for(PersonReportTempletEntity item : list) {
        				obj = new HashMap<String, Object>();
        				obj.put("id", item.getId());
        				obj.put("number", item.getNumber());
        				obj.put("name", item.getName());
        				obj.put("moduleList", item.getModuleList());
        				obj.put("createTime", item.getCreateTime());
        				obj.put("status", item.getStatus());
        				obj.put("type", item.getType());
        				obj.put("declare", item.getDeclare());
        				rows.add(obj);
        			}
        		}
        		object.put("code", 0);
        		object.put("total", count);
        		object.put("rows", rows);
    		}
		} catch (Exception e) {
			e.printStackTrace();
			object.put("code", 0);
			object.put("message", "程序执行出错");
			log.error("程序执行出错", e);
		}
		return object;
	}
	
	
	/**
     * 保存模板信息
     * @param ScoreLevelEntity
     * @return
     */
    @RequestMapping(value="/update",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> updateReportTemplet(PersonReportTempletEntity reportTempletEntity){
    	Map<String, Object> obj = new HashMap<String, Object>();
    	try {
    		if(reportTempletEntity.getId()!=null){
    			PersonReportTempletEntity entity = temService.getReportTempletEntityByID(reportTempletEntity.getId());
    			if(entity.getStatus()==2){
    				obj.put("code", 1);
    				obj.put("message", "该模板被使用过，不能编辑");
    				return obj;
    			}
    		}
    		reportTempletEntity.setCreateTime(new Date());
    		reportTempletEntity.setStatus(1);
        	temService.saveOrUpdateEntity(reportTempletEntity);
        	obj.put("code", 0);
			obj.put("message", "操作成功");
		} catch (Exception e) {
			//数据库中对number,name设唯一字段，当添加相同数据时数据库报异常，在这里处理异常，看是哪里出的问题。
			obj.put("code", 1);
			String temp=e.getCause().toString();
			if(temp.contains("Duplicate")){
				if(temp.contains("number")){
					obj.put("message", "模板编号已存在");
				}else if(temp.contains("name")){
					obj.put("message", "模板名已存在");
				}
			}else{
				obj.put("message", "保存失败");
			}
			e.printStackTrace();
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
    public Map<String, Object> deleteReportTemplet(@RequestParam(required=true) Integer id){
    	Map<String, Object> obj = new HashMap<String, Object>();
    	if(id == null || id == 0){
    		obj.put("code", 1);
    		obj.put("message", "此记录不存在");
    	} else {
    		try {
    			PersonReportTempletEntity entity = temService.getReportTempletEntityByID(id);
    			if(entity == null){
    				obj.put("code", 1);
    	    		obj.put("message", "此记录不存在");
    			}
    			else if(entity.getStatus()==2){ //使用过后的模板status被标记为2
    				entity.setStatus(0);		//标记删除
    				temService.update(entity);
    				obj.put("code", 0);
    				obj.put("message", "删除成功");
    			}
    			else {
    				temService.delete(id);
    				obj.put("code", 0);
    				obj.put("message", "删除成功");
    			}
    			
    		} catch (Exception e){
    			e.printStackTrace();
    			obj.put("code", 1);
    			obj.put("message", "删除失败");
    		}
    	}
    	return obj;
    }
}
