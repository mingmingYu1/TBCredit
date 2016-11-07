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
import org.jasig.cas.client.util.AssertionHolder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.UserEntity;
import com.yodata.creditsupport.orm.vo.Menu;
import com.yodata.creditsupport.service.IMenuService;
import com.yodata.creditsupport.service.IUserService;
import com.yodata.creditsupport.util.Tools;
/**
 * 单点登录后，保存session
 * @author Anna
 *
 */
@Controller
@RequestMapping("/caslogin")
public class CASLoginAction {

    private static final Logger log = Logger.getLogger("login");
    @Resource
    private IUserService userService;
    @Resource
    private IMenuService menuService;
    
    
    /**
     * 用户login
     * @param request
     * @return
     */
    @RequestMapping(value="/login",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> login(UserEntity user,HttpServletRequest request, HttpServletResponse response){
        
        response.setCharacterEncoding("UTF-8");
        Map<String,Object> object = new HashMap<>();
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long start = System.currentTimeMillis();
        log.info(">>>>>>>>>>>>>>>>>>>>>>>用户"+user.getUserName()+"在"+df.format(new Date())+"通过ip"+Tools.getIpAddr(request)+"尝试登录>>>>>>>>>>>>>>");

        //获取单点登录用户
        String username = AssertionHolder.getAssertion().getPrincipal().getName();
        
        if(username==null||"".equals(username)){
            log.info("用户名不能为空!>>>>>>>>>>>>>.");
            object.put("num", 0);
            return object;
        }

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
        UserEntity sessionUser = new UserEntity();
        sessionUser.setUserId(tempUser.getUserId());
        sessionUser.setDeptId(tempUser.getDeptId());
        sessionUser.setUserName(tempUser.getUserName());
        sessionUser.setRealName(tempUser.getRealName());
        request.getSession().setAttribute("sessionUser", sessionUser);
        object.put("result", 1);
        
        List<Menu> menuList = menuService.getMenuByUserId(tempUser.getUserId());
        if(menuList==null||menuList.size()==0){
            log.info("该账户'"+tempUser.getUserName()+"'没有任何菜单权限!>>>>>>>>>>>>>.");
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
        log.info("用户'"+tempUser.getRealName()+"'在"+df.format(new Date())+"通过ip"+Tools.getIpAddr(request)+"登录成功!>>>>>>>>>>>>>>>>>>>");
        log.info("==================登录耗时"+(end-start)+"ms========================");
        
        return object;
        
    }
    /**
     * 退出登录
     * @param request
     */
    @RequestMapping(value="/logout",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void logout(HttpServletRequest request){
        
        UserEntity loginUser = (UserEntity) request.getSession().getAttribute("sessionUser");
        
        //清除用户所有session信息
        request.getSession().invalidate();
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("用户'"+loginUser==null?"":loginUser.getRealName()+"'在"+df.format(new Date())+"退出成功!>>>>>>>>>>>>>>>>>>>");
            
    }
    
    /**
     * session验证
     * @param request
     */
    @RequestMapping(value="/checkSession",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> checkSessionTimeOut(HttpServletRequest request){
        
        UserEntity loginUser = (UserEntity) request.getSession().getAttribute("sessionUser");
        Map<String,Object> object = new HashMap<>();
        if(loginUser==null){
            object.put("code", -1);
        }else{
            object.put("code", 1);
        }
        return object;   
    }
}
