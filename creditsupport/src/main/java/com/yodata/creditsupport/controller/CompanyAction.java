package com.yodata.creditsupport.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.AgentInfoEntity;
import com.yodata.creditsupport.orm.entity.CrawlerAgentInfoEntity;
import com.yodata.creditsupport.service.ICompanyService;
import com.yodata.creditsupport.service.IDictService;
import com.yodata.creditsupport.util.FTPClientUtil;
import com.yodata.creditsupport.util.QueryParam;
import com.yodata.creditsupport.util.Tools;
import com.yodata.creditsupport.util.Validator;


@Controller
@RequestMapping("company")
public class CompanyAction extends BasicAction{
    private final Log log= LogFactory.getLog(CompanyAction.class);
    
    @Resource
	private ICompanyService companyServiceImpl;
    
    @Resource
    private IDictService dictServiceImpl;
    
    /**
     * 查询企业详情
     */
    @RequestMapping(value="query/{regId}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> query(@PathVariable String regId){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		AgentInfoEntity se = companyServiceImpl.getByRegId(regId);
    		if(se == null) {
    			map.put("code", -1);
    			map.put("message", "查询失败");
    			return map;
    		}
    		Map<String, Object> obj = new HashMap<>();
    		obj.put("id", se.getRegId());
    		obj.put("regId", se.getRegId());
    		obj.put("compName", se.getCompName());
    		obj.put("statusName", Tools.customStatus(se.getStatus()));
    		obj.put("lperName", se.getLperName());
    		obj.put("createTime", se.getCreateTime() == null ? null
    				: DateFormatUtils.format(se.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
    		obj.put("updateTime", se.getUpdateTime() == null ? null
    				: DateFormatUtils.format(se.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
    		obj.put("updateTimeFull", se.getUpdateTime() == null ? null
    				: DateFormatUtils.format(se.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));//前端用于判断抓取结果
    		obj.put("indScore", se.getIndScore() != null 
    				? Double.compare(se.getIndScore(), (double) 0) < 0
    						? 0 : Math.round(se.getIndScore())
    								: null);
    		obj.put("algorCode", se.getAlgorCode());
    		obj.put("algorName", se.getAlgorName());
			map.put("code", 1);
			map.put("data", obj);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			map.put("code", -1);
			map.put("message", "查询失败");
		}
    	return map;
    }
    
//    @RequestMapping(value="query/{regId}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public AgentInfoEntity query(@PathVariable String regId){
//    	AgentInfoEntity temp = companyServiceImpl.getByRegId(regId);
//    	return temp;
//    }
    
    /**
     * 下载Ftp服务器文件
     */
    @RequestMapping(value="download/{path}/{file}",method=RequestMethod.GET,produces="application/pdf")
    public void download(HttpServletResponse response,@PathVariable String path, @PathVariable String file) throws IOException{
    	FTPClientUtil.getInstance().downFile("/download/"+path, file+".pdf",response);
    }
    /**
     * 新增企业
     */
//    @RequestMapping(value="create",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<String> create(@RequestBody AgentInfoEntity agentInfo){
//    	String regId = companyServiceImpl.create(agentInfo);
//    	if(StringUtils.isNotEmpty(regId)){
//    		return new ResponseEntity<String>(regId,HttpStatus.OK);
//    	}else{
//    		return new ResponseEntity<String>(regId,HttpStatus.INTERNAL_SERVER_ERROR);
//    	}
//    }
    /**
     * 修改企业
     */
//    @RequestMapping(value="update",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<String> update(@RequestBody AgentInfoEntity agentInfo){
//    	boolean result = companyServiceImpl.update(agentInfo);
//    	if(result){
//    		return new ResponseEntity<String>(agentInfo.getRegId(),HttpStatus.OK);
//    	}else{
//    		return new ResponseEntity<String>(agentInfo.getRegId(),HttpStatus.INTERNAL_SERVER_ERROR);
//    	}
//    }
    /**
     * 删除企业
     */
    @RequestMapping(value="delete/{regId}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> deleteComp(@PathVariable String regId){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            boolean result = companyServiceImpl.delete(regId);
            if(result){
                map.put("code", 1);
                map.put("message", "删除企业成功");
            }else{
                map.put("code", -1);
                map.put("message", "删除企业失败");
            }
        } catch (BusinessException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            map.put("code", -2);
            map.put("message", e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            map.put("code", -2);
            map.put("message", "删除企业出现异常");
        }
        return map;
    }
    
    /**
     * 新增/更新企业
     * @param agentInfo
     * code编号：
     *      1：更新企业成功，前台页面列表刷新
     *      2：新增企业成功，前台页面列表刷新
     *      -1：捕捉到业务异常，页面刷新
     *      -2:代码运行中遇到异常，不刷新页面
     *      -9：企业名称错误或新增失败，前台页面不刷新
     *      
     * @return
     */
    @RequestMapping(value="updateAgentNew",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> updateAgentNew(CrawlerAgentInfoEntity agentInfo){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            String compName = agentInfo.getInfoName();
            if(StringUtils.isBlank(compName)){
                result.put("code", -9);
                result.put("message", "请输入完整的企业名称");
                return result;
            } else if(compName.length() > 50){
                result.put("code", -9);
                result.put("message", "企业名称长度不超过50位");
                return result;
            } else if(!Validator.isCompName(compName)){
                result.put("code", -9);
                result.put("message", "企业名称必须以中英文或+-()空格符组成且以中英文开头");
                return result;
            }
            List<AgentInfoEntity> agents = companyServiceImpl.getAgentInfoByName(compName);
            boolean existComp = agents == null || agents.isEmpty() ? false : true;
            int updateResult = companyServiceImpl.addAgent(agentInfo);
            boolean success = updateResult == 1 ? true : false;
            if(existComp){
                if(success){
                    result.put("code", 1);
                    //判读页面请求是新增还是更新
                    if(StringUtils.isBlank(agentInfo.getInfocreditcode())){
                        result.put("message", "企业已存在，已更新企业并重新计算信用得分成功");
                    } else {
                        result.put("message", "更新企业及重新计算信用得分成功");
                    }
                } else if(updateResult == -9){
                    result.put("code", -9);
                    result.put("message", "您输入的企业名称不正确或不完整，请输入完整的企业名称");
                } else {
                    result.put("code", -1);
                    result.put("message", "更新企业及重新计算信用得分出现异常");
                }
            } else {
                if(success){
                    result.put("code", 2);
                    result.put("message", "新增企业及重新计算信用得分成功");
                } else if(updateResult == -9){
                    //-9代表没有成功从接口获取企业信息
                    result.put("code", -9);
                    result.put("message", "您输入的企业名称不正确或不完整，请输入完整的企业名称");
                }  else {
                    result.put("code", -1);
                    result.put("message", "新增企业及重新计算信用得分出现异常");
                }
            }
        } catch (BusinessException e) {
            e.printStackTrace();
            log.info(e.getMessage(), e);
            result.put("code", -1);
            result.put("message", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage(), e);
            result.put("code", -2);
            result.put("message", "连接失败或服务器内部错误，请稍后再试");
        }
    	
    	return result;
    }
    
    /**
     * 查询企业列表
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException 
     */
	@RequestMapping(value="query",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> queryCompany(@RequestParam(required=false) Integer offset,@RequestParam(required=false) Integer limit) throws UnsupportedEncodingException{
		Map<String, Object> object = new HashMap<>();
		
        //查询分页条件
        String regid = request.getParameter("regId");
        String compname = request.getParameter("compName");
        String status = request.getParameter("status");
        String lpname = request.getParameter("lperName");
        String algorithmType = request.getParameter("algorithmType");
        if(compname != null)
        	compname = URLDecoder.decode(compname, "UTF-8");
        if(status != null)
        	status = URLDecoder.decode(status, "UTF-8");
        if(lpname != null)
        	lpname = URLDecoder.decode(lpname, "UTF-8");
    	QueryParam queryParam = new QueryParam();
    	queryParam.setQueryCode(regid);
    	queryParam.setQueryName(compname);
    	queryParam.setStatus(status);
    	queryParam.setLpname(lpname);
    	queryParam.setAlgorithmType(StringUtils.isEmpty(algorithmType) ? "Delphi" : algorithmType);
        queryParam.setOffset(offset==null?0:offset);
        queryParam.setLimit(limit==null?10:limit);
        String sort = request.getParameter("sort");
    	String order = request.getParameter("order");
    	if(StringUtils.isNotEmpty(sort) && StringUtils.isNotEmpty(order)){
			queryParam.setSortStr(sort + " " + order);
    	}
        try {
        	Map<String, Object> map = companyServiceImpl.getPageCompanys(queryParam);
        	if(map != null && !map.isEmpty()){
        		Integer count = (Integer) map.get("count");
        		List<AgentInfoEntity> list = (List<AgentInfoEntity>) map.get("data");
        		List<Object> rows = new ArrayList<Object>();
        		if(list != null && !list.isEmpty()){
        		    //得分保留整数
//        		    DecimalFormat dfScore = new DecimalFormat("0");
        		    //查询状态的数据字典
//    				List<DictEntity> dictList = dictServiceImpl.getDictsByCategory("100012");
					Map<String, Object> obj = null;
        			for(AgentInfoEntity se : list){
        				obj = new HashMap<>();
        				obj.put("id", se.getRegId());
        				obj.put("regId", se.getRegId());
        				obj.put("compName", se.getCompName());
        				obj.put("statusName", Tools.customStatus(se.getStatus()));
        				obj.put("lperName", se.getLperName());
        				obj.put("createTime", se.getCreateTime() == null ? null
        				        : DateFormatUtils.format(se.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        				obj.put("updateTime", se.getUpdateTime() == null ? null
        				        : DateFormatUtils.format(se.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
        				obj.put("updateTimeFull", se.getUpdateTime() == null ? null
        						: DateFormatUtils.format(se.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));//前端用于判断抓取结果
        				obj.put("indScore", se.getIndScore() != null 
        				        ? Double.compare(se.getIndScore(), (double) 0) < 0
        				                ? 0 : Math.round(se.getIndScore())
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
		} catch (SQLException e) {
			object.put("code", 0);
			object.put("message", "SQL程序执行出错");
			log.error("SQL执行错误", e);
		} catch (Exception e) {
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
//	@RequestMapping(value="addAgent",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<Integer> addAgent(@RequestBody CrawlerAgentInfoEntity agentInfos){
//    	int id;
//        try {
//            id = companyServiceImpl.addAgent(agentInfos);
//            if(id>0){
//                return new ResponseEntity<Integer>(id,HttpStatus.OK);
//            }else{
//                return new ResponseEntity<Integer>(id,HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        } catch (BusinessException e) {
//            e.printStackTrace();
//            return new ResponseEntity<Integer>(0,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
	
	/**
	 * 
	 * @return
	 * @throws SQLException 
	 */
//	@RequestMapping(value="/isAgent",produces=MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Map<String, Object> isAgent(HttpServletRequest request, HttpServletResponse response) throws SQLException{
//		 String compname = request.getParameter("compname");
//		 Map<String, Object> json = new HashMap<>();
//    	if(companyServiceImpl.isGroup(compname)){
//    		 json.put("status", 1);
//    	}else{
//    	     json.put("status", 0);
//    	}
//    	 return json;
//    }
	
	/**
     * 查询分组列表
     * @param request
     * @param response
     * @return
     */
//	@RequestMapping(value="findGroup",produces=MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Map<String, Object> findGroup(HttpServletResponse response){
//        long start = System.currentTimeMillis();
//    	
//    	response.setCharacterEncoding("utf-8");	
//    	Map<String, Object> object = new HashMap<>();
//    	 
//    	try {
//    		
//    		int limit = Integer.valueOf(request.getParameter("limit")==null?"10":request.getParameter("limit"));
//    		int offset = Integer.valueOf(request.getParameter("offset")==null?"0":request.getParameter("offset"));
//    		
//    		Page tempage = getPage();
//    		tempage.setCountPerPage(limit);
//    		tempage.setCurrent((offset+tempage.getCountPerPage())/limit);
//    		
//    		Page<AgentGroup> page = companyServiceImpl.findGroup(request,tempage);
//	       
//    		object = new HashMap<>();
//    		object.put("result","1" );
//	    	object.put("total", page.getCount());
//	    	
//	    	List<Object> array = new ArrayList<Object>();
//	    	List<AgentGroup> List = page.getDate();
//	    	
//	    	for(int i=0;i<List.size();i++){
//	    		
//	    		AgentGroup g = List.get(i);
//	    		Map<String, Object> row = new HashMap<>();
//	    		row.put("groupId", g.getGroupId());
//	    		row.put("groupName", g.getGroupName());
//	    		array.add(row);
//	    	}
//	    	object.put("rows", array);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error("具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>");
//			object.put("result","-1" );
//			
//		}
//    	long end = System.currentTimeMillis();
//    	log.info("查询耗时"+(end-start)+"ms=======================");
//    	return object;
//    }
	
	
	/**
     * 查询分组的企业列表
     * @param request
     * @param response
     * @return
     */
//	@RequestMapping(value="findAgent",produces=MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Map<String, Object> findAgent(HttpServletRequest req, HttpServletResponse response){
//         
//    	Map<String, Object> object = new HashMap<>();
//    	 	
//        ArrayList<CrawlerAgentInfoEntity> agentinfos = companyServiceImpl.findAgentBygroupId(Integer.parseInt(req.getParameter("groupId")));
//        List<Object> array = new ArrayList<>();
//        for(int i = 0; i < agentinfos.size(); i++){
//        	CrawlerAgentInfoEntity age = agentinfos.get(i);
//        	Map<String, Object> row = new HashMap<>();
//    		row.put("infoId", age.getInfoId());
//    		row.put("infoName", age.getInfoName());
//    		row.put("infoCreditcode", age.getInfocreditcode());
//    		array.add(row);
//        }
//        object.put("rows", array);
//      
//    	return object;
//    }
	
	
	
	 /**
	  * 编辑分组企业名称及社会信用代码
	  * @param req
	  * @param response
	  * @return
	  */
//	@RequestMapping(value="EditAgent",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<Map<String,Integer>> EditAgent(HttpServletRequest req, @RequestBody CrawlerAgentGroupEntity agentgroup, HttpServletResponse response){
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		try {
//			if(null==agentgroup.getGroupId()){
//				if(companyServiceImpl.isGroup(agentgroup.getGroupName())){
//					map.put("status", 3);
//					return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
//				}else{
//					boolean flag = companyServiceImpl.EditAgent(agentgroup);
//			    	if(flag){
//			    		map.put("status", 1);
//			    		map.put("id", agentgroup.getGroupId());
//			    		return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
//			    	}else{
//			    		return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
//			    	}
//				}
//			}else{
//				boolean flag = companyServiceImpl.EditAgent(agentgroup);
//		    	if(flag){
//		    		map.put("status", 1);
//		    		map.put("id", agentgroup.getGroupId());
//		    		return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
//		    	}else{
//		    		return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
//		    	}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//    }

	
	 /**
	  * 编辑分组企业名称及社会信用代码
	  * @param req
	  * @param response
	  * @return
	  */
//	@RequestMapping(value = "updateAgent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public ResponseEntity<Integer> updateAgent(HttpServletRequest req, @RequestBody CrawlerAgentGroupEntity agentgroup,
//			HttpServletResponse response) {
//
//		boolean flag = companyServiceImpl.updateAgent(agentgroup);
//		if (flag) {
//			return new ResponseEntity<Integer>(1, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Integer>(0, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	/**
	 * 提交分组id
	 * 
	 * @param req
	 * @param response
	 * @return
	 */
//	@RequestMapping(value = "submitGroupId", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public ResponseEntity<Integer> submitGroupId(@RequestBody CrawlerAgentGroupEntity agentgroup) {
//
//		boolean flag = companyServiceImpl.submitGroupId(agentgroup.getGroupId());
//		if (flag) {
//			return new ResponseEntity<Integer>(1, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Integer>(0, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	/**
	 * 删除企业信息
	 * 
	 * @param agentgroup
	 * @return
	 */
//	@RequestMapping(value = "deleteAgent", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public ResponseEntity<Integer> deleteAgent(@RequestBody CrawlerAgentGroupEntity agentgroup) {
//
//		boolean flag = companyServiceImpl.deleteAgent(agentgroup);
//		if (flag) {
//			return new ResponseEntity<Integer>(1, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Integer>(0, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	/**
	 * 删除分组
	 * 
	 * @param agentgroup
	 * @return
	 */
//	@RequestMapping(value = "deleteGroup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public ResponseEntity<Integer> deleteGroup(@RequestBody CrawlerAgentGroupEntity agentgroup) {
//
//		boolean flag = companyServiceImpl.deleteGroup(agentgroup);
//		if (flag) {
//			return new ResponseEntity<Integer>(1, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Integer>(0, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	/**
	 * 代理商标签是否存在
	 * @param compName
	 * @return
	 */
//	@RequestMapping(value = "agentLabelIsUsable")
//	@ResponseBody
//	public String labelIsUsable(@RequestParam(required=true) String compName) {
//		boolean isUsable = companyServiceImpl.agentIsExistence(compName);
//		return isUsable ? "1" : "";
//	}
}