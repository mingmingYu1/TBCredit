package com.yodata.creditsupport.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.core.domain.Page;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.DeptEntity;
import com.yodata.creditsupport.orm.person.entity.PerUserEntity;
import com.yodata.creditsupport.orm.vo.Dept;
import com.yodata.creditsupport.service.IDeptService;
import com.yodata.creditsupport.service.IUserService;


@Controller
@RequestMapping("/personDept")
public class PersonDeptAction extends BasicAction{
    private final Log log= LogFactory.getLog(PersonDeptAction.class);
    @Resource
    private IDeptService deptService;
    @Resource
    private IUserService userService;

    /**
     * 添加部门
     * @param deptEntity
     * @return
     */
    @RequestMapping(value="/adddept",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> add(DeptEntity deptEntity,HttpServletRequest request, HttpServletResponse response){
 
    	long start = System.currentTimeMillis();
    	
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
		
    	//用户未登录
    	PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		return object;
    	}
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	log.info("用户'"+loaduser.getRealName()+"'在"+df.format(new Date())+"添加部门>>>>>>>>>>>>>>");
    	
    	try {
    		//部门名称不能为空
    		if(deptEntity.getDeptName()==null || "".equals(deptEntity.getDeptName())){
    			object.put("num", 1);
    			log.info("部门名称不允许为空!>>>>>>>>>>>>>>>>");
				return object;
    		}
    		
    		if(deptEntity.getDeptName().length()>20){
    			object.put("num", 3);
    			log.info("部门名称不允许超过20位!>>>>>>>>>>>>>>>>");
				return object;
    		}
    		
    		
    		//上级部门不允许为空
    		if(deptEntity.getParentId().intValue()==-1){
    			object.put("num", 2);
    			log.info("上级部门不允许为空!>>>>>>>>>>>>>>>>");
				return object;
    		}
    		
    		//根据部门名称获取部门信息
    		List<DeptEntity> dList = deptService.findByName(deptEntity.getDeptName());
    		if(dList != null && !dList.isEmpty()){//部门名称已经存在
    			object.put("num", 0);
    			log.info("部门'"+deptEntity.getDeptName()+"'已经存在了!>>>>>>>>>>>>>>>>");
				return object;
    		}
    		
			String createby = loaduser.getPeruserName();
			deptEntity.setCreateUser(createby);
    		deptEntity.setStatus(String.valueOf(1));
    		
    		//获取当前系统时间
    		String ts = df.format(System.currentTimeMillis());  	
    		deptEntity.setCreateTime(Timestamp.valueOf(ts));
    		
    		deptService.add(deptEntity);
    		object.put("result", 1);
    		log.info("用户'"+loaduser.getRealName()+"'添加新部门"+deptEntity.getDeptName()+"成功>>>>>>>>>>>>");
    		
    	}catch (Exception e) {
    		
			e.printStackTrace();
			log.error("用户'"+loaduser.getRealName()+"'保存新的用部门信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>");
			object.put("result", -1);
			
		}
    	long end = System.currentTimeMillis();
		log.info("===================添加部门'"+deptEntity.getDeptName()+"'耗时"+(end-start)+"ms=======================");
    	
		return object;
    }

    /**
     * 删除部门
     * @param deptEntity
     */
    @RequestMapping(value="/deldept",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> delete(DeptEntity deptEntity,HttpServletRequest request, HttpServletResponse response){
    	
    	long start = System.currentTimeMillis();
    	
		response.setCharacterEncoding("UTF-8");
		Map<String, Object> object = new HashMap<String, Object>();
		
		PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		return object;
    	}
    	
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	log.info("用户'"+loaduser.getRealName()+"'在"+df.format(new Date())+"删除部门>>>>>>>>>>>>>>");
		
    	try {
    		Integer id = deptEntity.getDeptId();
    		if(id.intValue() == 1){
    			object.put("num", "3");
    			log.info("该部门不允许删除>>>>>>>>>>>>>>>>>>>>");
				return object;
    		}
    		Integer deptId = deptEntity.getDeptId();
    		//查询部门员工
    		int num = userService.selectUserCountByDeptId(deptId);
    		
			if(num>0){
				object.put("num", "0");
				log.info("该部门下有员工，不能删除>>>>>>>>>>>>>>>>>>>>");
				return object;
			}
			int son = deptService.selectSonByDeptId(deptId);
			if(son>0){
				object.put("num", "1");
				log.info("该部门下子部门，不能删除>>>>>>>>>>>>>>>>>>>>");
				return object;
			}
			
			int i = deptService.deleteEntity(deptId);
			if(i>0){
				object.put("result", 1);
				log.info("用户'"+loaduser.getRealName()+"'已经删除ID为"+deptId+"的部门>>>>>>>>>>>>>>>>>>>>");
			}
		} catch (BusinessException e) {
			e.printStackTrace();
			object.put("result", -1);
			log.error("用户'"+loaduser.getRealName()+"' 删除部门信息异常，具体异常信息："+e.getMessage());
			
		} catch (Exception e) {
            
            e.printStackTrace();
            object.put("result", -1);
            log.error("用户'"+loaduser.getRealName()+"' 删除部门信息异常，具体异常信息："+e.getMessage());
            
        }
    	long end = System.currentTimeMillis();
    	log.info("===================删除部门'"+deptEntity.getDeptName()+"'耗时"+(end-start)+"ms=======================");
    	return object;
    }
    
    /**
     * 部门展示
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping(value="/query",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> topdeptShow(HttpServletRequest request, HttpServletResponse response){
    	
    	long start = System.currentTimeMillis();
    	
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
    	
    	//用户未登录
    	PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		return object;
    	}
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	log.info("用户'"+loaduser.getRealName()+"'在"+df.format(new Date())+"查询部门>>>>>>>>>>>>>>");
    	
    	try {
    		int limit = Integer.valueOf(request.getParameter("limit")==null?"10":request.getParameter("limit"));
    		int offset = Integer.valueOf(request.getParameter("offset")==null?"0":request.getParameter("offset"));
    		
    		Page<Dept> tempage = getPage();
    		tempage.setCountPerPage(limit);
    		tempage.setCurrent((offset+tempage.getCountPerPage())/limit);
			
    		Page<Dept> page =deptService.queryAllDept(request,tempage);
    		
    		object = new HashMap<String, Object>();
    		object.put("result","1" );
	    	object.put("total", page.getCount());
	    	
	    	List<Object> array = new ArrayList<Object>();
	    	List<Dept> userList = page.getDate();
	    	
	    	for(int i=0;i<userList.size();i++){
	    		
	    		Dept user = userList.get(i);
	    		Map<String, Object> row = new HashMap<String, Object>();
	    		row.put("id", user.getDeptId());
	    		row.put("rolename", user.getDeptName());
	    		row.put("deptPName", user.getDeptPName());
	    		array.add(row);
	    	}
	    	object.put("rows", array);
    		
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查看部门信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>>>>>");
			
			object.put("result","-1" );
		}
    	
    	long end = System.currentTimeMillis();
    	log.info("===================查询部门耗时"+(end-start)+"ms=======================");
    	
		return object;
    }

    /**
     * 修改部门
     * @param deptEntity
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/updateDept",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> update(DeptEntity deptEntity,HttpServletRequest request,HttpServletResponse response){
    	
    	long start = System.currentTimeMillis();
    	
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
    	
    	PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		return object;
    	}
    	
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	log.info("用户'"+loaduser.getRealName()+"'在"+df.format(new Date())+"修改部门>>>>>>>>>>>>>>");
    	try {
    	    Integer parentId = deptEntity.getParentId();
        	if(deptEntity.getDeptName()==null || "".equals(deptEntity.getDeptName())){
    			object.put("num", 2);
    			log.info("部门名称不允许为空!>>>>>>>>>>>>>>>>");
    			return object;
    		}
        	
        	if(deptEntity.getDeptName().length()>20){
    			object.put("num", 7);
    			log.info("部门名称不允许超过20位!>>>>>>>>>>>>>>>>");
				return object;
    		}
        	
        	if(parentId==-1){
    			object.put("num", 4);
    			log.info("上级部门不允许为空!>>>>>>>>>>>>>>>>");
				return object;
    		}
    		
			if(1==deptEntity.getDeptId()){
				object.put("num", 1);
				log.error("该部门不允许修改!");
				return object;
			}
			//根据部门名称获取部门信息
			int num = deptService.queryDeptByName(deptEntity);
			if(num >0){
				log.error("部门名称已经存在!>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				object.put("num", 0);
				return object;
			}
			
			if(deptEntity.getDeptId().equals(parentId)){
				object.put("num", 3);
    			log.info("不允许拿自己做上级部门!>>>>>>>>>>>>>>>>");
    			return object;
			}
			
			if(checkParentId(deptEntity.getDeptId(), parentId)){
			    object.put("num", 5);
                log.info("不能拿本部门的子孙部门当上级部门!>>>>>>>>>>>>>>>>");
                return object;
			}
			
			//获取当前系统时间
			String ts = df.format(System.currentTimeMillis());  	
			deptEntity.setCreateTime(Timestamp.valueOf(ts));
			
			int count = deptService.update(deptEntity);
			
			if(count>0){
				object.put("result", 1);
				log.info("修改"+deptEntity.getDeptName()+"部门成功");
			}
			
		} catch (BusinessException e) {
            e.printStackTrace();
            log.error("修改部门信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>>");
            object.put("result", -1);
        } catch (Exception e) {
			e.printStackTrace();
			log.error("修改部门信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>>");
			object.put("result", -1);
		}
    	
    	long end = System.currentTimeMillis();
    	log.info("===================修改部门耗时"+(end-start)+"ms=======================");
		
		return object;
    }

    /**
     * 不能拿本部门的子孙部门当上级部门
     * @param deptId
     * @param parentId
     * @return
     */
    private boolean checkParentId(Integer deptId, Integer parentId) {
        boolean result = false;
        List<DeptEntity> sonList = deptService.getSonDeptByParentId(deptId);
        if(sonList != null && !sonList.isEmpty()){
            for(DeptEntity sonDept : sonList){
                if(sonDept.getDeptId().equals(parentId)){
                    result = true;
                    break;
                } else {
                    result = checkParentId(sonDept.getDeptId(), parentId);
                    if(result){
                        break;
                    }
                }
            }
        }
        return result;
    }
    
}