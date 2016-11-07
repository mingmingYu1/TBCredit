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

import org.apache.commons.lang3.StringUtils;
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
import com.yodata.creditsupport.orm.entity.RoleEntity;
import com.yodata.creditsupport.orm.entity.UserRoleEntity;
import com.yodata.creditsupport.orm.person.entity.PerUserEntity;
import com.yodata.creditsupport.orm.vo.User;
import com.yodata.creditsupport.service.IDeptService;
import com.yodata.creditsupport.service.IPersonUserService;
import com.yodata.creditsupport.service.IRoleService;
import com.yodata.creditsupport.util.MD5;
import com.yodata.creditsupport.util.Validator;


@Controller
@RequestMapping("/personUser")
public class PersonUserAction extends BasicAction{
    private final Log log= LogFactory.getLog(PersonUserAction.class);
    @Resource
    private IPersonUserService userService;
    @Resource
    private IRoleService roleService;
    @Resource
    private IDeptService deptService;

    /**
     * 添加用户
     * @param request
     * @return
     */
    @RequestMapping(value="/addUser",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> adduser(PerUserEntity user,HttpServletResponse response){
    	
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
    	log.info("用户'"+loaduser.getRealName()+"'在"+df.format(new Date())+"添加用户>>>>>>>>>>>>>>");
    	
		if("".equals(user.getPerpassword())){
			object.put("num", 0);
			log.info("密码不能为空>>>>>>>>>>>>");
			return object;
		}
		if(user.getPerpassword().length()<8){
			log.info("密码不能小于8位>>>>>>>>>>>>");
			object.put("num", 1);
			return object;
		}
		if(user.getPeruserName().equals(user.getPerpassword())){
			log.info("用户名和密码不能相等>>>>>>>>>>>>");
			object.put("num", 2);
			return object;
		}
		if(user.getPerpassword()==null || !Validator.isPassword(user.getPerpassword())){
			log.info("密码必须为数字和字母，且长度为8-16位 >>>>>>>>>>>>");
			object.put("num", 7);
			return object;
		}
		
		if(user.getPeruserName()==null || "".equals(user.getPeruserName())){
			log.info("用户名不能为空>>>>>>>>>>>>");
			object.put("num", 4);
			return object;
		}
		if(user.getPeruserName()==null || !Validator.isUsername(user.getPeruserName())){
			log.info("用户名必须为数字和字母开头,6到17位数字、字母、下划线的组合>>>>>>>>>>>>");
			object.put("num", 8);
			return object;
		}
		
		if(user.getRealName()==null || "".equals(user.getRealName())){
			log.info("姓名不能为空>>>>>>>>>>>>");
			object.put("num", 9);
			return object;
		}
		
		String username = user.getPeruserName();
		
		try {
			int num = userService.findByName(username);
			
			if(num>0){
				object.put("num", 3);
				log.info("用户名已经存在>>>>>>>>>>>>");
				return object;
			}
			
			String createby = loaduser.getPeruserName();
			user.setCreateUser(createby);
			user.setStatus("1");
			
			//获取当前系统时间
			String ts = df.format(System.currentTimeMillis());  	
			user.setCreateTime(Timestamp.valueOf(ts));
	    	
			//MD5加密password
			String passwordMD5 = MD5.digest(user.getPerpassword()); 
			user.setPerpassword(passwordMD5);
			
			String roleId=request.getParameter("roleIds");
			if(roleId==null ||"".equals(roleId)){
				log.info("用户必须赋予角色>>>>>>>>>>>>");
				object.put("num", 5);
				return object;
			}
			
			String[] roleIds=roleId.split(",");
			
			for (int i = 0; i < roleIds.length; i++){
				if("1".equals(roleIds[i])){
					log.info("普通用户不允许赋予管理员权限>>>>>>>>>>>>");
					object.put("num", 6);
					return object;
				}
			}
			
			Integer uid = (Integer) userService.adduser(user);
			
			
			List<UserRoleEntity> list = new ArrayList<>();
			for (int i = 0; i < roleIds.length; i++) {
				UserRoleEntity userRole = new UserRoleEntity();
				userRole.setUserId(uid);
				Integer rid = Integer.valueOf(roleIds[i]);
				userRole.setRoleId(rid);
				list.add(userRole);
			}
			
			userService.addUserRole(list);
			log.info("用户'"+loaduser.getRealName()+"'添加新用户"+user.getPeruserName()+"成功>>>>>>>>>>>>");
			
			object.put("result", 1);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("保存新的用户信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>>>>>");
			object.put("result", -1);
		}
		
		long end = System.currentTimeMillis();
		log.info("===================添加用户'"+user.getPeruserName()+"'耗时"+(end-start)+"ms=======================");
		
		return object;
    }

    /**
     * 更新用户
     * @param request
     */
    @RequestMapping(value="/updateUser",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> updateuser(PerUserEntity user,HttpServletRequest request,HttpServletResponse response){
    	
    	long start = System.currentTimeMillis();
    	
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
    	//用户未登录
    	PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		return object;
    	}
    	
		String roleId=request.getParameter("roleIds");
		if(roleId==null ||"".equals(roleId)){
			log.info("用户必须赋予角色>>>>>>>>>>>>");
			object.put("num", 0);
			return object;
		}
		if(1==user.getUserId()){
			log.info("管理员用户不允许修改>>>>>>>>>>>>");
			object.put("num", 1);
			return object;
		}
		if(user.getPeruserName()==null || "".equals(user.getPeruserName())){
			log.info("用户名不能为空>>>>>>>>>>>>");
			object.put("num", 4);
			return object;
		}
		if(user.getPeruserName()==null || !Validator.isUsername(user.getPeruserName())){
			log.info("用户名必须为数字和字母开头,6到17位数字、字母、下划线的组合 >>>>>>>>>>>>");
			object.put("num", 8);
			return object;
		}
		if(user.getRealName()==null || "".equals(user.getRealName())){
			log.info("姓名不能为空 >>>>>>>>>>>>");
			object.put("num", 9);
			return object;
		}
		
		//获取当前系统时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ts = df.format(System.currentTimeMillis());  	
		user.setCreateTime(Timestamp.valueOf(ts));
		
		String [] roleIds=roleId.split(",");
		
		Integer uid = user.getUserId();
		List<UserRoleEntity> list = new ArrayList<>();  
		for(int i =0;i < roleIds.length;i++){  
			if("1".equals(roleIds[i])){
				log.info("普通用户不允许赋予管理员权限>>>>>>>>>>>>");
				object.put("num", 6);
				return object;
			}
			
			UserRoleEntity ur=new UserRoleEntity();  
			ur.setUserId(uid);
			ur.setRoleId(Integer.valueOf(roleIds[i]));
			list.add(ur);  
		} 
		
		//如果激活,就清空错误次数
		if(user.getStatus().equals("1")){
			user.setErrCount(0);
		}
		try {
			userService.updateuser(user);
			userService.deleteUserRole(uid);
			userService.addUserRole(list);
			
			object.put("result", 1);
			log.info("用户'"+loaduser.getRealName()+"'修改用户"+user.getPeruserName()+"成功>>>>>>>>>>>>");
			
		} catch (BusinessException e) {
            log.error("修改用户信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>");
            object.put("result", -1);
            object.put("ret_info", e.getMessage());         
        } catch (Exception e) {
			log.error("修改用户信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>");
			object.put("result", -1);
			object.put("ret_info", e.getMessage());			
		}
		
		long end = System.currentTimeMillis();
		log.info("===================修改用户'"+user.getPeruserName()+"'耗时"+(end-start)+"ms=======================");
		
		return object;
    }
    
    /**
     * 展示用户界面
     * @param request
     * @return
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping(value="/query",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> query(HttpServletRequest request,HttpServletResponse response){
		
    	long start = System.currentTimeMillis();
    	
    	response.setCharacterEncoding("utf-8");	
    	Map<String, Object> object = new HashMap<String, Object>();
    	//用户未登录
        PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		return object;
    	}
    	try {
    		
    		int limit = Integer.valueOf(request.getParameter("limit")==null?"10":request.getParameter("limit"));
    		int offset = Integer.valueOf(request.getParameter("offset")==null?"0":request.getParameter("offset"));
    		
    		Page tempage = getPage();
    		tempage.setCountPerPage(limit);
    		tempage.setCurrent((offset+tempage.getCountPerPage())/limit);
    		
    		Page<User> page = userService.queryAllUser(request,tempage);
	       
    		object = new HashMap<String, Object>();
    		object.put("result","1" );
	    	object.put("total", page.getCount());
	    	
	    	List<Object> array = new ArrayList<>();
	    	List<User> userList = page.getDate();
	    	
	    	for(int i=0;i<userList.size();i++){
	    		
	    		User user = userList.get(i);
	    		Map<String, Object> row = new HashMap<String, Object>();
	    		row.put("userId", user.getUserId());
	    		row.put("realName", user.getRealName());
	    		row.put("userName", user.getUserName());
	    		row.put("deptName", user.getDeptName());
	    		row.put("password", user.getPassword());
	    		row.put("roleName", user.getRoleName());
	    		row.put("status", user.getStatus());
	    		array.add(row);
	    	}
	    	object.put("rows", array);

		} catch (BusinessException e) {
            e.printStackTrace();
            log.error("查看用户信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>");
            object.put("result","-1" );
            object.put("ret_info",e.getMessage() );
        } catch (Exception e) {
			e.printStackTrace();
			log.error("查看用户信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>");
			object.put("result","-1" );
			object.put("ret_info","连接失败或服务器内部错误，请稍后再试" );
		}
    	long end = System.currentTimeMillis();
    	log.info("用户'"+loaduser.getPeruserName()+"'查询用户耗时"+(end-start)+"ms=======================");
    	return object;
    }
    
    /**
     * 所有角色展示
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/roleshow",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> roleshow(HttpServletRequest request,HttpServletResponse response){
    	
    	long start = System.currentTimeMillis();
    	
		response.setCharacterEncoding("UTF-8");
		Map<String, Object> object = new HashMap<String, Object>();
    	//用户未登录
		PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
		if(loaduser==null){
			object.put("result",-2 );
			return object;
		}
		
		try{
			List<RoleEntity> roleList = roleService.roleshow();
			object.put("roleList", roleList);
			object.put("result", 1);
		}catch (Exception e) {
			log.error("加载角色信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>");
			object.put("result", -1);
		}
		
		long end = System.currentTimeMillis();
    	log.info("用户'"+loaduser.getPeruserName()+"'在UserAction查询角色耗时"+(end-start)+"ms=======================");
        return object;
    }
    
    /**
     * 所有部门展示
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/deptshow",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> deptshow(HttpServletRequest request,HttpServletResponse response){
    	
    	long start = System.currentTimeMillis();
    	
		response.setCharacterEncoding("UTF-8");
		Map<String, Object> object = new HashMap<String, Object>();
    	//用户未登录
		PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
		if(loaduser==null){
			object.put("result",-2 );
			return object;
		}

		try{
			List<DeptEntity> deptList = deptService.deptshow();
			object.put("deptList", deptList);
			object.put("result", 1);
		}catch (Exception e) {
			log.error("加载部门信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>>>");
			object.put("result", -1);
		}
		
		long end = System.currentTimeMillis();
    	log.info("用户'"+loaduser.getPeruserName()+"'在UserAction查询部门耗时"+(end-start)+"ms=======================");
		
        return object;
    }
    
    /**
     * 根据id删除用户
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/deluser")
    @ResponseBody
    public Map<String, Object> delUser(HttpServletRequest request,HttpServletResponse response){
	
    	long start = System.currentTimeMillis();
    	
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
    	//用户未登录
    	PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		return object;
    	}
		try {
			String id = request.getParameter("userId");
			if("1".equals(id)){
				object.put("num", 0);
				log.info("管理员用户不允许删除!>>>>>>>>>>>>>>>>>.");
				return object;
			}
			
			int num = userService.deleteUserRole(Integer.valueOf(id));
			if(num>0){
				log.info("删除"+num+"条 用户角色关联>>>>>>>>>>>>");
			}
			
                userService.deleteuser(Integer.valueOf(id));
            
			log.info("用户'"+loaduser.getPeruserName()+"'删除ID为"+id+"的用户成功>>>>>>>>>>>>>>");
			object.put("result", 1);
			
		} catch (NumberFormatException e) {
            e.printStackTrace();
            log.error("删除用户信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>",e);
            object.put("result", -1);
            object.put("ret_info", e.getMessage());
        } catch (BusinessException e) {
            e.printStackTrace();
            log.error("删除用户信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>",e);
            object.put("result", -1);
            object.put("ret_info", e.getMessage());
        } catch (Exception e) {
			log.error("删除用户信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>",e);
			object.put("result", -1);
			object.put("ret_info", e.getMessage());			
		}
		
		long end = System.currentTimeMillis();
    	log.info("用户'"+loaduser.getPeruserName()+"'删除用户耗时:"+(end-start)+"ms=======================");
    	
		return object;
    }
    
    /**
     * 密码重置
     * @param user
     * @param response
     * @return
     */
	@RequestMapping(value="/resetPword",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> resetPword(PerUserEntity user,HttpServletRequest request,HttpServletResponse response){
    	
    	long start = System.currentTimeMillis();
    	
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
    	
    	//用户未登录
    	PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		return object;
    	}
    	
    	List<Integer> roles = null;
        try {
            roles = userService.queryRoleByUserId(loaduser.getUserId());
        } catch (BusinessException e1) {
            log.error("对用户重置密码信息异常，具体异常信息："+ e1.getMessage()+">>>>>>>>>>>>>>>>>>>>>");
            object.put("result", -1);
            object.put("message", e1.getMessage());
        }
    	if(roles != null && !roles.isEmpty() && !roles.contains(1)){
    		object.put("num",3);
			log.info("非管理员权限不能重置密码>>>>>>>>>>>>");
			return object;
    	}
    	
    	if(user.getUserId()==1){
    		object.put("num", 5);
    		log.info("不能重置管理员用户的密码");
    		return object;
    	}
    	
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	log.info("用户'"+loaduser.getRealName()+"'在"+df.format(new Date())+"重置密码>>>>>>>>>>>>>>");
    	
    	String password1 = request.getParameter("password1");
    	String password2 = request.getParameter("password2");
    	if(password1!=null && !password1.equals(password2)){
    		object.put("num", 4);
			log.info("两次输入密码不一致!>>>>>>>>>>>>");
			return object;
    	}
    	
    	user.setPerpassword(password1);
    	
		if("".equals(user.getPerpassword())){
			object.put("num", 0);
			log.info("密码不能为空>>>>>>>>>>>>");
			return object;
		}
		if(user.getPerpassword().length()<8){
			log.info("密码不能小于8位>>>>>>>>>>>>");
			object.put("num", 1);
			return object;
		}
		if(user.getPeruserName().equals(user.getPerpassword())){
			log.info("用户名和密码不能相等>>>>>>>>>>>>");
			object.put("num", 2);
			return object;
		}
		
		
		if(user.getPerpassword()==null || !Validator.isPassword(user.getPerpassword())){
			log.info("密码必须为数字和字母,不能超过16位>>>>>>>>>>>>");
			object.put("num", 7);
			return object;
		}
		
		try {
			user.setPerpassword(MD5.digest(user.getPerpassword()));
			
			userService.resetPword(user);
			log.info("用户'"+loaduser.getRealName()+"'重置密码"+user.getPeruserName()+"成功>>>>>>>>>>>>");
			
			object.put("result", 1);
			
		} catch (BusinessException e) {
            e.printStackTrace();
            log.error("对用户重置密码信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>>>>>");
            object.put("result", -1);
            object.put("message", e.getMessage());
        } catch (Exception e) {
			e.printStackTrace();
			log.error("对用户重置密码信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>>>>>");
			object.put("result", -1);
			object.put("message", e.getMessage());
		}
		
		long end = System.currentTimeMillis();
		log.info("===================重置密码'"+user.getPerpassword()+"'耗时"+(end-start)+"ms=======================");
		
		return object;
    }
    
	   /**
     * 密码修改
     * @param user
     * @param response
     * @return
     */
	@RequestMapping(value="/updatePword",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> updatePword(HttpServletRequest request,HttpServletResponse response){
    	
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
    	log.info("用户'"+loaduser.getRealName()+"'在"+df.format(new Date())+"修改密码>>>>>>>>>>>>>>");
    	
    	String oldPassWord = request.getParameter("oldPassWord");
    	if(oldPassWord==null || "".equals(oldPassWord)){
    		object.put("num", 3);
			log.info("请输入旧密码>>>>>>>>>>>");
			return object;
    	}
    	
    	String uid = String.valueOf(loaduser.getUserId());
    	PerUserEntity PerUserEntity = userService.findUserEntityById(uid);
    	
    	if(!MD5.digest(oldPassWord).equals(PerUserEntity.getPerpassword())){
    		object.put("num", 4);
			log.info("旧密码输入有误>>>>>>>>>>>");
			return object;
    	}
    	
    	String newPassWord1 = request.getParameter("newPassWord1");
    	String newPassWord2 = request.getParameter("newPassWord2");
    	
//    	String newPassWord = newPassWord1;
    	
    	if(StringUtils.isBlank(newPassWord1)){
    	    object.put("num", 0);
    	    log.info("新密码不能为空>>>>>>>>>>>>");
    	    return object;
    	}
    	if(newPassWord1 != null && newPassWord1.length() < 8){
    	    log.info("新密码不能小于8位>>>>>>>>>>>>");
    	    object.put("num", 1);
    	    return object;
    	}
    	
    	if(newPassWord1 != null && !newPassWord1.equals(newPassWord2)){
    		object.put("num", 9);
			log.info("两次输入新密码不一致!>>>>>>>>>>>");
			return object;
    	}
    	
    	
		if(PerUserEntity.getPeruserName().equals(newPassWord1)){
			log.info("用户名和密码不能相等>>>>>>>>>>>>");
			object.put("num", 2);
			return object;
		}
		if(newPassWord1 == null || !Validator.isPassword(newPassWord1)){
			log.info("密码只能为数字和字母,且不能超过16位>>>>>>>>>>>");
			object.put("num", 5);
			return object;
		}
		
		try {
			PerUserEntity.setPerpassword(MD5.digest(newPassWord1));
			
			userService.resetPword(PerUserEntity);
			log.info("用户'"+loaduser.getRealName()+"'修改密码"+PerUserEntity.getPeruserName()+"成功>>>>>>>>>>>>");
			
			object.put("result", 1);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("修改密码信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>>>>>");
			object.put("result", -1);
		}
		
		long end = System.currentTimeMillis();
		log.info("===================修改密码'"+PerUserEntity.getPeruserName()+"'耗时"+(end-start)+"ms=======================");
		
		return object;
    }
}