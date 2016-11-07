package com.yodata.creditsupport.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.creditsupport.orm.entity.CrawlerAgentGroupEntity;
import com.yodata.creditsupport.orm.entity.DictEntity;
import com.yodata.creditsupport.orm.entity.PersonAddInfo;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInfoEntity;
import com.yodata.creditsupport.orm.vo.AgentGroup;
import com.yodata.creditsupport.service.ICompanyService;
import com.yodata.creditsupport.service.IDictService;
import com.yodata.creditsupport.service.IPersonService;
import com.yodata.creditsupport.util.FTPClientUtil;
import com.yodata.creditsupport.util.QueryParam;
import com.yodata.creditsupport.util.Tools;


@Controller
@RequestMapping("person")
public class PersonAction extends BasicAction{
    private final Log log= LogFactory.getLog(CompanyAction.class);
    
    @Resource
	private IPersonService personServiceImpl;
    
    @Resource
    private IDictService dictServiceImpl;
    
    /**
     * 下载Ftp服务器文件
     */
    @RequestMapping(value="download/{path}/{file}",method=RequestMethod.GET,produces="application/pdf")
    public void download(HttpServletResponse response,@PathVariable String path, @PathVariable String file) throws IOException{
    	FTPClientUtil.getInstance().downFile("/download/"+path, file+".pdf",response);
    }
 
    /**
     * 删除个人信息
     */
    @RequestMapping(value="delete/{cardId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Integer> deletePerson(@PathVariable String cardId){
    	boolean result = personServiceImpl.delete(cardId);
    	if(result){
    		return new ResponseEntity<Integer>(1,HttpStatus.OK);//1成功
    	}else{
    		return new ResponseEntity<Integer>(0,HttpStatus.INTERNAL_SERVER_ERROR);//0失败
    	}
    }
    
    /**
     * 更新个人信息
     */
    @RequestMapping(value="updatePerson",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Integer> updateAgentNew(@RequestBody PersonAddInfo personInfos){
    	int id = personServiceImpl.addPerson(personInfos);
    	if(id>0){
    		return new ResponseEntity<Integer>(id,HttpStatus.OK);
    	}else{
    		return new ResponseEntity<Integer>(id,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 查询个人列表
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException 
     */
	@RequestMapping(value="query",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> queryPerson(@RequestParam(required=false) Integer offset,@RequestParam(required=false) Integer limit) throws UnsupportedEncodingException{
		Map<String, Object> object = new HashMap<>();
		
        //查询分页条件
        String cardId = request.getParameter("cardId");
        String cardName = request.getParameter("cardName");
        if(cardId != null)
        	cardId = new String(cardId.getBytes("ISO-8859-1"),"UTF-8");
        if(cardName != null)
        	cardName = new String(cardName.getBytes("ISO-8859-1"),"UTF-8");
    	QueryParam queryParam = new QueryParam();
    	queryParam.setQueryCode(cardId);
    	queryParam.setQueryName(cardName);
        queryParam.setOffset(offset==null?0:offset);
        queryParam.setLimit(limit==null?10:limit);
        String sort = request.getParameter("sort");
    	String order = request.getParameter("order");
    	if(StringUtils.isNotEmpty(sort) && StringUtils.isNotEmpty(order)){
    		queryParam.setSortStr(sort + " " + order);
    	}
        try {
        	Map<String, Object> map = personServiceImpl.getPagePerson(queryParam);
        	if(map != null && !map.isEmpty()){
        		Integer count = (Integer) map.get("count");
        		List<OdsPersonInfoEntity> list = (List<OdsPersonInfoEntity>) map.get("data");
        		List<Object> rows = new ArrayList<Object>();
        		if(list != null && !list.isEmpty()){
        			Map<String, Object> obj = null;
        			for(OdsPersonInfoEntity se : list){
        				obj = new HashMap<>();
        				obj.put("cardId", se.getCardId());
        				obj.put("cardName", se.getName());
        				obj.put("createTime", se.getAddtime() == null ? null
        				        : DateFormatUtils.format(se.getAddtime(), "yyyy-MM-dd HH:mm:ss"));
        				obj.put("updateTime", se.getModTime() == null ? null
        				        : DateFormatUtils.format(se.getModTime(), "yyyy-MM-dd"));
        				obj.put("updateTimeFull", se.getModTime() == null ? null
        						: DateFormatUtils.format(se.getModTime(), "yyyy-MM-dd HH:mm:ss"));//前端用于判断抓取结果
        				obj.put("indScore", se.getIndScore() != null 
        				        ? Double.compare(se.getIndScore(), (double) 0) < 0
        				                ? 0 : se.getIndScore()
        				        : null);
        				
        				obj.put("algorCode", se.getAlgorCode());
                        obj.put("algorName", se.getAlgorName());
        				rows.add(obj);
        			}
        		}
        		object.put("code", 1);
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
	 * 新增单条分组名称
	 * @param agentInfo
	 * @return
	 */
	@RequestMapping(value="addPerson",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Integer> addPeson(@RequestBody PersonAddInfo personInfos){
    	int id = personServiceImpl.addPerson(personInfos);
    	if(id>0){
    		return new ResponseEntity<Integer>(id,HttpStatus.OK);
    	}else{
    		return new ResponseEntity<Integer>(id,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
	
	
}