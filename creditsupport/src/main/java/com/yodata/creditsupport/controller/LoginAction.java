package com.yodata.creditsupport.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.UserEntity;
import com.yodata.creditsupport.orm.person.entity.PerUserEntity;
import com.yodata.creditsupport.orm.vo.Menu;
import com.yodata.creditsupport.service.IMenuService;
import com.yodata.creditsupport.service.IPersonUserService;
import com.yodata.creditsupport.service.IUserService;
import com.yodata.creditsupport.util.MD5;
import com.yodata.creditsupport.util.Tools;


@Controller
@RequestMapping("/login")
public class LoginAction extends BasicAction{
//    private final Log log= LogFactory.getLog(LoginAction.class);
    private static final Logger log = Logger.getLogger("login");
    @Resource
    private IUserService userService;
    @Resource
    private IMenuService menuService;
    @Resource
    private IPersonUserService perSerService;
    
    
    /**
     * 添加用户
     * @param request
     * @return
     */
    @RequestMapping(value="/login",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> login(UserEntity user,HttpServletRequest request, HttpServletResponse response){
    	
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
    	
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	long start = System.currentTimeMillis();
    	log.info(">>>>>>>>>>>>>>>>>>>>>>>用户"+user.getUserName()+"在"+df.format(new Date())+"通过ip"+Tools.getIpAddr(request)+"尝试登录>>>>>>>>>>>>>>");

    	String username = user.getUserName();
    	String password = user.getPassword();
    	
    	if(username==null||"".equals(username)){
    		log.info("用户名不能为空!>>>>>>>>>>>>>.");
    		object.put("num", 0);
    		return object;
    	}
    	if(password==null||"".equals(password)){
    		log.info("密码不能为空!>>>>>>>>>>>>>.");
    		object.put("num", 1);
    		return object;
    	}

    	//MD5加密password
		String passwordMD5 = MD5.digest(password); 
		user.setPassword(passwordMD5);
    	
    	UserEntity tempUser = userService.findUserEntityByName(username);
    	//用户名错误
    	if(tempUser==null){
    		log.info("用户名输入错误!>>>>>>>>>>>>>.");
    		object.put("num",2);
    		return object;
    	}
    	//用户名已经正确
    	if(tempUser.getErrCount()>=10){
    		log.info("该用户'"+tempUser.getUserName()+"'密码错误次数太多,已经被冻结,请联系管理员!>>>>>>>>>>>>>.");
    		object.put("num",4);
    		return object;
    	}
    	
    	UserEntity loginUser = userService.findUserEntity(user);
    	//密码错误
    	if(loginUser==null){
    		if(tempUser.getErrCount()>=9){
    			userService.blockUserEntity(username);
    		}else{
    			userService.addErrorcount(username);
    		}
    		log.info("密码输入错误!>>>>>>>>>>>>>.");
    		object.put("num",2);
    		return object;
    	}
    	
    	if(!loginUser.getStatus().equals("1")){
    		log.info("该账户'"+loginUser.getUserName()+"'已经被冻结,请联系管理员!>>>>>>>>>>>>>.");
    		object.put("num", 3);
    		return object;
    	}
    	//登录成功
    	loginUser.setErrCount(0);
    	loginUser.setIp(Tools.getIpAddr(request));
    	loginUser.setLastLoadTime(Tools.getCurrentDate());
    	userService.updateuser2(loginUser);
    	
    	//将必要的user信息放至session中
    	UserEntity sessionUser = new UserEntity();
    	sessionUser.setUserId(loginUser.getUserId());
    	sessionUser.setDeptId(loginUser.getDeptId());
    	sessionUser.setUserName(loginUser.getUserName());
    	sessionUser.setRealName(loginUser.getRealName());
    	request.getSession().setAttribute("sessionUser", sessionUser);
    	object.put("result", 1);
    	
    	List<Menu> menuList = menuService.getMenuByUserId(loginUser.getUserId());
    	if(menuList==null||menuList.size()==0){
    		log.info("该账户'"+loginUser.getUserName()+"'没有任何菜单权限!>>>>>>>>>>>>>.");
    		object.put("num", 5);
    		return object;
    	}
    	request.getSession().setAttribute("menuList", menuList);
    	object.put("menu", menuList);
    	
    	List<Integer> roles = null;
        try {
            roles = userService.queryRoleByUserId(tempUser.getUserId());
        } catch (BusinessException e) {
            log.error("用户登录异常："+ e.getMessage()+">>>>>>>>>>>>>>>>>>>>>");
            object.put("result", -1);
            object.put("message", e.getMessage());
        }
    	request.getSession().setAttribute("roles", roles);
    	
    	long end = System.currentTimeMillis();
    	log.info("用户'"+loginUser.getRealName()+"'在"+df.format(new Date())+"通过ip"+Tools.getIpAddr(request)+"登录成功!>>>>>>>>>>>>>>>>>>>");
    	log.info("==================登录耗时"+(end-start)+"ms========================");
    	
		return object;
    	
    }
    
    /**
     * 个人用户
     * @param request
     * @return
     */
    @RequestMapping(value="/personLogin",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> perLogin(PerUserEntity user,HttpServletRequest request, HttpServletResponse response){
    	
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
    	
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	long start = System.currentTimeMillis();
    	log.info(">>>>>>>>>>>>>>>>>>>>>>>用户"+user.getPeruserName()+"在"+df.format(new Date())+"通过ip"+Tools.getIpAddr(request)+"尝试登录>>>>>>>>>>>>>>");

    	
    	String perusername = user.getPeruserName();
    	String perpassword = user.getPerpassword();
    	
    	if(perusername==null||"".equals(perusername)){
    		log.info("用户名不能为空!>>>>>>>>>>>>>.");
    		object.put("num", 0);
    		return object;
    	}
    	if(perpassword==null||"".equals(perpassword)){
    		log.info("密码不能为空!>>>>>>>>>>>>>.");
    		object.put("num", 1);
    		return object;
    	}

    	//MD5加密password
		String passwordMD5 = MD5.digest(perpassword); 
		user.setPerpassword(passwordMD5);
    	
    	PerUserEntity tempUser = perSerService.findUserEntityByName(perusername);
    	//用户名错误
    	if(tempUser==null){
    		log.info("用户名输入错误!>>>>>>>>>>>>>.");
    		object.put("num",2);
    		return object;
    	}
    	//用户名已经正确
    	if(tempUser.getErrCount()>=10){
    		log.info("该用户'"+tempUser.getPeruserName()+"'密码错误次数太多,已经被冻结,请联系管理员!>>>>>>>>>>>>>.");
    		object.put("num",4);
    		return object;
    	}
    	
    	PerUserEntity loginUser = perSerService.findUserEntity(user);
    	//密码错误
    	if(loginUser==null){
    		if(tempUser.getErrCount()>=9){
    			perSerService.blockUserEntity(perusername);
    		}else{
    			perSerService.addErrorcount(perusername);
    		}
    		log.info("密码输入错误!>>>>>>>>>>>>>.");
    		object.put("num",2);
    		return object;
    	}
    	
    	if(!loginUser.getStatus().equals("1")){
    		log.info("该账户'"+loginUser.getPeruserName()+"'已经被冻结,请联系管理员!>>>>>>>>>>>>>.");
    		object.put("num", 3);
    		return object;
    	}
    	//登录成功
    	loginUser.setErrCount(0);
    	loginUser.setIp(Tools.getIpAddr(request));
    	loginUser.setLastLoadTime(Tools.getCurrentDate());
    	perSerService.updateuser2(loginUser);
    	
    	request.getSession().setAttribute("sessionUser", loginUser);
    	object.put("result", 1);
    	
    	List<Menu> menuList = menuService.getMenuByPerUserId(loginUser.getUserId());
    	if(menuList==null||menuList.size()==0){
    		log.info("该账户'"+loginUser.getPeruserName()+"'没有任何菜单权限!>>>>>>>>>>>>>.");
    		object.put("num", 5);
    		return object;
    	}
    	request.getSession().setAttribute("menuList", menuList);
    	object.put("menu", menuList);
    	
    	List<Integer> roles = null;
        try {
            roles = perSerService.queryRoleByUserId(tempUser.getUserId());
        } catch (BusinessException e) {
            log.error("用户登录异常："+ e.getMessage()+">>>>>>>>>>>>>>>>>>>>>");
            object.put("result", -1);
            object.put("message", e.getMessage());
        }
    	request.getSession().setAttribute("roles", roles);
    	
    	long end = System.currentTimeMillis();
    	log.info("用户'"+loginUser.getRealName()+"'在"+df.format(new Date())+"通过ip"+Tools.getIpAddr(request)+"登录成功!>>>>>>>>>>>>>>>>>>>");
    	log.info("==================登录耗时"+(end-start)+"ms========================");
    	
		return object;
    	
    }
    
    /**
     * 退出登录
     * @param request
     */
	@RequestMapping(value="/logout",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> logout(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		UserEntity loginUser = (UserEntity) request.getSession().getAttribute("sessionUser");
		
		//清除用户所有session信息
		request.getSession().invalidate();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.info("用户'"+loginUser==null?"":loginUser.getRealName()+"'在"+df.format(new Date())+"退出成功!>>>>>>>>>>>>>>>>>>>");
		return map;
	}
	
	/**
     * 退出登录
     * @param request
     */
	@RequestMapping(value="/perlogout",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> perlogout(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		PerUserEntity loginUser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
		
		//清除用户所有session信息
		request.getSession().invalidate();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.info("用户'"+loginUser==null?"":loginUser.getRealName()+"'在"+df.format(new Date())+"退出成功!>>>>>>>>>>>>>>>>>>>");
		return map;
	}
	
	/**
     * 退出登录
     * @param request
     */
	@RequestMapping(value="/checkSession",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> checkSessionTimeOut(HttpServletRequest request){
		
		UserEntity loginUser = (UserEntity) request.getSession().getAttribute("sessionUser");
		Map<String, Object> object = new HashMap<String, Object>();
		if(loginUser==null){
			object.put("code", -1);
		}else{
			object.put("code", 1);
		}
		return object;	
	}
	
	/**
     * 修改密码
     * @param request
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping(value="/updatePassword",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> updatePassword(HttpServletRequest request,
    		String oldPassword, String newPassword){
    	Map<String, Object> map = new HashMap<String, Object>();
        UserEntity loginUser = (UserEntity) request.getSession().getAttribute("sessionUser");
        if(loginUser == null) {
            map.put("message", "请先登录");
            map.put("result", -2);
            return map;
        }
        try {
            userService.updatePassword(loginUser.getUserId(), oldPassword, newPassword);
            map.put("message", "密码修改成功！");
            map.put("result", 1);
        } catch (BusinessException e) {
            e.printStackTrace();
            map.put("message", e.getMessage());
            map.put("result", -1);
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            String error = "修改用户密码出错";
            e.printStackTrace();
            map.put("message", error);
            map.put("result", -1);
            log.error(error, e);
        }
        return map;   
    }
    
    /**
     * 获取当前登陆用户的信息
     * @param request
     * @return
     */
    @RequestMapping(value="/getUserInfos",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> getUserInfos(HttpServletRequest request){
    	Map<String, Object> map = new HashMap<String, Object>();
        try {
        	UserEntity loginUser = (UserEntity) request.getSession().getAttribute("sessionUser");
        	@SuppressWarnings("unchecked")
			List<Integer> roles = (List<Integer>) request.getSession().getAttribute("roles");
        	if(loginUser == null || roles == null) {
        		map.put("message", "请先登录");
        		map.put("result", -2);
        		return map;
        	}
            HashMap<String, Object> data = new HashMap<>();
            data.put("userId", loginUser.getUserId());
            data.put("deptId", loginUser.getDeptId());
            data.put("roles", roles);
            map.put("result", 1);
            map.put("data", data);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("从session中获取用户信息失败", e);
            map.put("result", -1);
        }
        return map;   
    }
    
}