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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.core.domain.Page;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.DeptEntity;
import com.yodata.creditsupport.orm.entity.RoleEntity;
import com.yodata.creditsupport.orm.entity.UserEntity;
import com.yodata.creditsupport.orm.entity.UserRoleEntity;
import com.yodata.creditsupport.orm.vo.User;
import com.yodata.creditsupport.service.IDeptService;
import com.yodata.creditsupport.service.IRoleService;
import com.yodata.creditsupport.service.IUserService;
import com.yodata.creditsupport.util.MD5;
import com.yodata.creditsupport.util.Validator;


@Controller
@RequestMapping("/user")
public class UserAction extends BasicAction{
    private final Log log= LogFactory.getLog(UserAction.class);
    @Resource
    private IUserService userService;
    @Resource
    private IRoleService roleService;
    @Resource
    private IDeptService deptService;
    
    //重置密码时的密码
    @Value("${reset.password}")
    private String resetPwd;

    /**
     * 添加用户
     * @param request
     * @return
     */
    @RequestMapping(value="/addUser",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> adduser(UserEntity user,HttpServletResponse response){
    	
    	long start = System.currentTimeMillis();
    	
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
    	
    	//用户未登录
    	UserEntity loaduser = (UserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result", -2);
    		return object;
    	}
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	log.info("用户'"+loaduser.getRealName()+"'在"+df.format(new Date())+"添加用户>>>>>>>>>>>>>>");
    	
		
		String username = user.getUserName();
		String errMsg;
		try {
			if("".equals(user.getPassword())){
				errMsg = "密码不能为空";
				log.info(errMsg);
				object.put("result", -1);
				object.put("message", errMsg);
				return object;
			}
			if(user.getUserName().equals(user.getPassword())){
				errMsg = "用户名和密码不能相等";
				log.info(errMsg);
				object.put("result", -1);
				object.put("message", errMsg);
				return object;
			}
			if(!Validator.isPassword(user.getPassword())){
				errMsg = "密码必须为数字或字母的组合，且长度为8-16位";
				log.info(errMsg);
				object.put("result", -1);
				object.put("message", errMsg);
				return object;
			}
			if(user.getUserName()==null || "".equals(user.getUserName())){
				errMsg = "用户名不能为空";
				log.info(errMsg);
				object.put("result", -1);
				object.put("message", errMsg);
				return object;
			}
			if(!Validator.isUsername(user.getUserName())){
				errMsg = "用户名为数字或字母或点号的组合，长度不超过20位";
				log.info(errMsg);
				object.put("result", -1);
				object.put("message", errMsg);
				return object;
			}
			
			if(!Validator.isFullName(user.getRealName())){
				errMsg = "姓名不可含有除点以外的特殊字符且长度不可超过20位";
				log.info(errMsg);
				object.put("result", -1);
				object.put("message", errMsg);
				return object;
			}
			List<UserEntity> uList = userService.findByName(username);
			int num = uList == null ? 0 : uList.size();
			
			if(num>0){
				errMsg = "用户名已经存在";
				log.info(errMsg);
				object.put("result", -1);
				object.put("message", errMsg);
				return object;
			}
			
			String createby = loaduser.getUserName();
			user.setCreateUser(createby);
			user.setStatus("1");
			
			//获取当前系统时间
			String ts = df.format(System.currentTimeMillis());  	
			user.setCreateTime(Timestamp.valueOf(ts));
	    	
			//MD5加密password
			String passwordMD5 = MD5.digest(user.getPassword()); 
			user.setPassword(passwordMD5);
			
			String roleId=request.getParameter("roleIds");
			if(roleId==null ||"".equals(roleId)){
				errMsg = "用户必须赋予角色";
				log.info(errMsg);
				object.put("result", -1);
				object.put("message", errMsg);
				return object;
			}
			
			String[] roleIds=roleId.split(",");
			
			for (int i = 0; i < roleIds.length; i++){
				if("1".equals(roleIds[i])){
					errMsg = "普通用户不允许赋予管理员权限";
					log.info(errMsg);
					object.put("result", -1);
					object.put("message", errMsg);
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
			log.info("用户'"+loaduser.getRealName()+"'添加新用户"+user.getUserName()+"成功>>>>>>>>>>>>");
			
			object.put("result", 1);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("保存新的用户信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>>>>>");
			object.put("result", -1);
			object.put("message", "保存失败");
		}
		
		long end = System.currentTimeMillis();
		log.info("===================添加用户'"+user.getUserName()+"'耗时"+(end-start)+"ms=======================");
		
		return object;
    }

    /**
     * 更新用户
     * @param request
     */
    @RequestMapping(value="/updateUser",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> updateuser(UserEntity user,HttpServletRequest request){
    	Map<String, Object> object = new HashMap<String, Object>();
    	UserEntity loaduser = (UserEntity) request.getSession().getAttribute("sessionUser");
    	Integer userId = user.getUserId();
    	String errMsg;
    	if(loaduser==null){
    		object.put("result",-2 );	//用户未登录
    		return object;
    	} else if(userId == null) {
    		object.put("result",-1 );
    		object.put("message", "用户编号不能为空");
    		return object;
    	} else if(loaduser.getUserId().equals(userId)) {
			object.put("result", -1);
			object.put("message", "用户不能对自己进行修改操作");
			return object;
		}
    	
		String roleId=request.getParameter("roleIds");
		if(roleId==null ||"".equals(roleId)){
			errMsg = "用户必须赋予角色";
			log.info(errMsg);
			object.put("result", -1);
			object.put("message", errMsg);
			return object;
		}
		if(userId == 1){
			errMsg = "管理员用户不允许修改";
			log.info(errMsg);
			object.put("result", -1);
			object.put("message", errMsg);
			return object;
		}
		if(user.getUserName()==null || "".equals(user.getUserName())){
			errMsg = "用户名不能为空";
			log.info(errMsg);
			object.put("result", -1);
			object.put("message", errMsg);
			return object;
		}
		if(!Validator.isUsername(user.getUserName())){
			errMsg = "用户名为数字或字母或点号的组合，长度不超过20位";
			log.info(errMsg);
			object.put("result", -1);
			object.put("message", errMsg);
			return object;
		}
		if(!Validator.isFullName(user.getRealName())){
			errMsg = "姓名不可含有除点以外的特殊字符且长度不可超过20位";
			log.info(errMsg);
			object.put("result", -1);
			object.put("message", errMsg);
			return object;
		}
		
		//获取当前系统时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ts = df.format(System.currentTimeMillis());  	
		user.setCreateTime(Timestamp.valueOf(ts));
		
		String [] roleIds=roleId.split(",");
		
		List<UserRoleEntity> list = new ArrayList<>();  
		for(int i =0;i < roleIds.length;i++){  
			if("1".equals(roleIds[i])){
				errMsg = "普通用户不允许赋予管理员权限";
				log.info(errMsg);
				object.put("result", -1);
				object.put("message", errMsg);
				return object;
			}
			
			UserRoleEntity ur=new UserRoleEntity();  
			ur.setUserId(userId);
			ur.setRoleId(Integer.valueOf(roleIds[i]));
			list.add(ur);  
		}
		//判断是否重名
		List<UserEntity> uList = userService.findByName(user.getUserName());
		if(uList != null && !uList.isEmpty()){
		    for(UserEntity ue : uList){
		        if(!ue.getUserId().equals(user.getUserId())){
		            errMsg = "用户名‘" + user.getUserName() + "’已存在！";
	                log.info(errMsg);
	                object.put("result", -1);
	                object.put("message", errMsg);
	                return object; 
		        }
		    }
		}
		//如果激活,就清空错误次数
		if(user.getStatus().equals("1")){
			user.setErrCount(0);
		}
		try {
			userService.updateuser(user);
			userService.deleteUserRole(userId);
			userService.addUserRole(list);
			object.put("result", 1);
			log.info("用户'"+loaduser.getRealName()+"'修改用户"+user.getUserName()+"成功>>>>>>>>>>>>");
		} catch (BusinessException e) {
            log.error("修改用户信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>");
            object.put("result", -1);
            object.put("message", e.getMessage());         
        } catch (Exception e) {
			log.error("修改用户信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>");
			object.put("result", -1);
			object.put("message", "修改用户信息失败");			
		}
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
    	UserEntity loaduser = (UserEntity) request.getSession().getAttribute("sessionUser");
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
    	log.info("用户'"+loaduser.getUserName()+"'查询用户耗时"+(end-start)+"ms=======================");
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
		UserEntity loaduser = (UserEntity) request.getSession().getAttribute("sessionUser");
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
    	log.info("用户'"+loaduser.getUserName()+"'在UserAction查询角色耗时"+(end-start)+"ms=======================");
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
		UserEntity loaduser = (UserEntity) request.getSession().getAttribute("sessionUser");
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
    	log.info("用户'"+loaduser.getUserName()+"'在UserAction查询部门耗时"+(end-start)+"ms=======================");
		
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
    public Map<String, Object> delUser(@RequestParam(required=true) Integer userId, HttpServletRequest request){
    	Map<String, Object> object = new HashMap<String, Object>();
		try {
			UserEntity loaduser = (UserEntity) request.getSession().getAttribute("sessionUser");
			if(loaduser==null){
				object.put("result",-2 );	//用户未登录
				return object;
			} else if(loaduser.getUserId().equals(userId)) {
				object.put("result", -1);
				object.put("message", "用户不能对自己进行删除操作");
				return object;
			} else if(userId == 1){
				object.put("result", -1);
				log.info("管理员用户不允许删除!");
				return object;
			}
			
			int num = userService.deleteUserRole(userId);
			if(num>0){
				log.info("删除"+num+"条 用户角色关联>>>>>>>>>>>>");
			}
			
            userService.deleteuser(userId);
            
			log.info("用户'"+loaduser.getUserName()+"'删除ID为"+userId+"的用户成功>>>>>>>>>>>>>>");
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
    public Map<String, Object> resetPword(@RequestParam(required=true) Integer userId,HttpServletRequest request){
    	Map<String, Object> object = new HashMap<String, Object>();
    	//用户未登录
    	UserEntity loaduser = (UserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		return object;
    	} else if(loaduser.getUserId().equals(userId)) {
    		object.put("result", -1);
            object.put("message", "用户不能对自己进行重置密码操作");
            return object;
    	}
		try {
			String newPassword = StringUtils.isEmpty(resetPwd) ? "yodata88" : resetPwd;
			userService.resetPword(userId, newPassword);
			object.put("result", 1);
			object.put("message", "该用户密码已重置为：" + newPassword);
		} catch (BusinessException e) {
            e.printStackTrace();
            log.error("对用户重置密码信息异常，具体异常信息："+ e.getMessage());
            object.put("result", -1);
            object.put("message", e.getMessage());
        } catch (Exception e) {
			e.printStackTrace();
			log.error("对用户重置密码信息异常，具体异常信息："+ e.getMessage());
			object.put("result", -1);
			object.put("message", "重置密码失败");
		}
		return object;
    }
    
	/**
     * 密码修改
     * @param user
     * @param response
     * @return
     */
	/*@RequestMapping(value="/updatePword",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> updatePword(HttpServletRequest request,HttpServletResponse response){
    	long start = System.currentTimeMillis();
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
    	//用户未登录
    	UserEntity loaduser = (UserEntity) request.getSession().getAttribute("sessionUser");
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
    	UserEntity userEntity = userService.findUserEntityById(uid);
    	if(!MD5.digest(oldPassWord).equals(userEntity.getPassword())){
    		object.put("num", 4);
			log.info("旧密码输入有误>>>>>>>>>>>");
			return object;
    	}
    	String newPassWord1 = request.getParameter("newPassWord1");
    	String newPassWord2 = request.getParameter("newPassWord2");
    	if(!newPassWord1.equals(newPassWord2)){
    		object.put("num", 9);
			log.info("两次输入新密码不一致!>>>>>>>>>>>");
			return object;
    	}
    	String newPassWord = newPassWord1;
		if("".equals(newPassWord)){
			object.put("num", 0);
			log.info("新密码不能为空>>>>>>>>>>>>");
			return object;
		}
		if(newPassWord.length()<8){
			log.info("新密码不能小于8位>>>>>>>>>>>>");
			object.put("num", 1);
			return object;
		}
		if(userEntity.getUserName().equals(newPassWord)){
			log.info("用户名和密码不能相等>>>>>>>>>>>>");
			object.put("num", 2);
			return object;
		}
		if(newPassWord==null || !Validator.isPassword(newPassWord)){
			log.info("密码只能为数字和字母,且不能超过16位>>>>>>>>>>>");
			object.put("num", 5);
			return object;
		}
		try {
			userEntity.setPassword(MD5.digest(newPassWord));
			userService.resetPword(userEntity);
			log.info("用户'"+loaduser.getRealName()+"'修改密码"+userEntity.getUserName()+"成功>>>>>>>>>>>>");
			object.put("result", 1);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("修改密码信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>>>>>");
			object.put("result", -1);
		}
		long end = System.currentTimeMillis();
		log.info("===================修改密码'"+userEntity.getUserName()+"'耗时"+(end-start)+"ms=======================");
		return object;
    }*/
}