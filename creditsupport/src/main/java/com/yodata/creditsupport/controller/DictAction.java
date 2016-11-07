package com.yodata.creditsupport.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.creditsupport.orm.entity.DictEntity;
import com.yodata.creditsupport.service.IDictService;


@Controller
@RequestMapping("/dict")
public class DictAction extends BasicAction{
    private final Log log= LogFactory.getLog(DictAction.class);
    @Resource
    private IDictService dictService;

    
    @RequestMapping(value="/query",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Object> query(@RequestParam String category){
    	List<Object> array = new ArrayList<Object>();
    	List<DictEntity> list = dictService.getDictsByCategory(category);
    	if(list!=null&&!list.isEmpty()){
    		for(DictEntity entity : list){
    			Map<String, Object> object = new HashMap<String, Object>();
    			object.put("value", entity.getValue());
    			object.put("name", entity.getName());
    			array.add(object);
    		}
    	} else {
    	    log.info(category + " 字典信息为空");
    	}
    	return array;
    }
    
}