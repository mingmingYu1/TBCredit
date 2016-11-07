package com.yodata.creditsupport.filter;
 
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.yodata.creditsupport.orm.entity.UserEntity;
import com.yodata.creditsupport.orm.vo.Menu;
import com.yodata.creditsupport.util.StringRandom;
 
/**
 * 用于检查用户是否登录了系统的过滤器<br>
 * 创建日期：2015-11-18
 * @author BFD_545
 *
 */
public class CheckLoginFilter implements Filter {
 
    /** 要检查的 session 的名称 */
    private String sessionKey;
     
    /** 需要排除（不拦截）的URL的正则表达式 */
    private Pattern excepUrlPattern;
     
    /** 检查不通过时，转发的URL */
    private String forwardUrl;
 
    @Override
    public void init(FilterConfig cfg) throws ServletException {
        sessionKey = cfg.getInitParameter("sessionKey");
 
        String excepUrlRegex = cfg.getInitParameter("excepUrlRegex");
        if (!StringRandom.isBlank(excepUrlRegex)) {
            excepUrlPattern = Pattern.compile(excepUrlRegex);
        }
 
        forwardUrl = cfg.getInitParameter("forwardUrl");
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    	// 如果 sessionKey 为空，则直接放行
        if (StringRandom.isBlank(sessionKey)) {
            chain.doFilter(req, res);
            return;
        }
 
//         * 请求 http://127.0.0.1:8080/webApp/home.jsp?&a=1&b=2 时
//          * request.getRequestURL()： http://127.0.0.1:8080/webApp/home.jsp
//         * request.getContextPath()： /webApp 
//         * request.getServletPath()：/home.jsp
//         * request.getRequestURI()： /webApp/home.jsp
//         * request.getQueryString()：a=1&b=2
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String servletPath = request.getServletPath();
        
        UserEntity sessionObj = (UserEntity) request.getSession().getAttribute(sessionKey);
        //发送请求的用户ID，判断发送请求的用户和session中的用户是否一致
        String userName = request.getParameter("sessionUserName");
        //校验发送请求的用户和session中的用户是否为同一个用户
        if(StringUtils.isNotBlank(userName) 
                && sessionObj != null && !sessionObj.getUserName().equals(userName)){
        	String requestType = request.getHeader("X-Requested-With");
            if (requestType != null && requestType.equals("XMLHttpRequest")) {	// 判断ajax请求
            	response.setStatus(401);
    			return;
            }
        	String contextPath = request.getContextPath();
            String responseURL = contextPath +forwardUrl;
            response.sendRedirect(responseURL);
            return;
        }
        // 如果请求的路径与forwardUrl相同，或请求的路径是排除的URL时，则直接放行
        if (servletPath.contains(forwardUrl) || excepUrlPattern.matcher(servletPath).matches()) {
            chain.doFilter(req, res);
            return;
        }
        if(servletPath.startsWith("/index.jsp")
        	||servletPath.startsWith("/css/") 
        	||servletPath.startsWith("/js/") 
        	||servletPath.startsWith("/fonts/")
        	||servletPath.startsWith("/images/")
        	||servletPath.startsWith("/error/") || servletPath.endsWith(".png")
        	||servletPath.startsWith("/font/")||servletPath.endsWith("favicon.ico")){
        	chain.doFilter(req, res);
        	return;
        }
        //判断是否为ajax请求
        /*String requestType = request.getHeader("X-Requested-With");
        if (requestType != null && requestType.equals("XMLHttpRequest")) {
//        	JSONObject object = new JSONObject();   
//			object.put("result", "-2");    
//			PrintWriter pw = res.getWriter();    
//			pw.print(object.toString());    
//			pw.close(); 
        	chain.doFilter(req, res);
			return;
        }*/
        
        // 如果Session为空，则跳转到指定页面
        if (sessionObj == null) {
//            String redirect = servletPath + "?" + StringRandom.defaultString(request.getQueryString());
            String requestType = request.getHeader("X-Requested-With");
            if (requestType != null && requestType.equals("XMLHttpRequest")) {	// 判断ajax请求
            	response.setStatus(401);
    			return;
            }
            String contextPath = request.getContextPath();
            String responseURL = contextPath +forwardUrl;
            response.sendRedirect(responseURL);
            return;
        } 
        //拥有权限校验
        else {
        	//修改密码
        	if(servletPath.startsWith("/user/updatePword")){
        		chain.doFilter(req, res);
        		return;
        	}
        	//checkSession
        	if(servletPath.startsWith("/login/checkSession")){
        		chain.doFilter(req, res);
        		return;
        	}
        	//退出用户
        	if(servletPath.startsWith("/login/logout")){
        		chain.doFilter(req, res);
        		return;
        	}
        	//只校验jsp的请求
//        	if(!servletPath.contains(".jsp")){
//        		chain.doFilter(req, res);
//        		return;
//        	}
        	
        	List<Menu> menuList = (List<Menu>) request.getSession().getAttribute("menuList");
            boolean b = false;
            if(menuList!=null){
            	for(int i =0; i<menuList.size(); i++){
            		Menu m = menuList.get(i);
            		String url = m.getUrl();
            		String[] urls = url.split(",");
            		for(String str: urls){
            			if(servletPath.startsWith(str)){
                			b = true;break;
                		}
            		}
            		if(b)break;
            		
                }
            	if(!b){
//            		request.getSession().removeAttribute("sessionUser");
//            		request.getSession().removeAttribute("menuList");
//            		request.getSession().removeAttribute("roles");
            		
            		String contextPath = request.getContextPath();
//            		String responseURL = contextPath +forwardUrl;
            		
                    //判断是否为ajax请求
                    String requestType = request.getHeader("X-Requested-With");
                    if (requestType != null && requestType.equals("XMLHttpRequest")) {
                    	response.setStatus(403);
            			return;
                    }
            		String responseURL = contextPath+"/error/jsp/error-page-noexist.jsp";
            		
            		response.sendRedirect(responseURL);
            		return;
            	}else{
            		chain.doFilter(req, res);
            		return;
            	}
            	
            }else{
            	request.getSession().removeAttribute("sessionUser");
        		request.getSession().removeAttribute("menuList");
        		request.getSession().removeAttribute("roles");
        		
        		String requestType = request.getHeader("X-Requested-With");
                if (requestType != null && requestType.equals("XMLHttpRequest")) {
                	response.setStatus(401);
        			return;
                }
        		String contextPath = request.getContextPath();
        		String responseURL = contextPath +forwardUrl;
        		response.sendRedirect(responseURL);
            	return;
            }
        }
    }
    
    @Override
    public void destroy() {
    }
}