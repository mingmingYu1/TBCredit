package com.yodata.creditsupport.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CommonFilter implements Filter{

	   /** 
     * Default constructor.  
     */  
    public CommonFilter() {  
        // TODO Auto-generated constructor stub  
    }  
  
    /** 
     * @see Filter#destroy() 
     */  
    public void destroy() {  
        // TODO Auto-generated method stub  
    }  
  
    /** 
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain) 
     */  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
        // TODO Auto-generated method stub  
        // place your code here  
                HttpServletRequest hr=(HttpServletRequest) request;  
    
                String url = hr.getServletPath().trim();  
                if (url.equals("xxx")){//不需要过滤的url，这里可以使用一个配置文件配置这些url，项目启动时读入内存一个map中，然后在这里进行判断  
            //我定义的是urlFilterMap，然后在这里urlFilterMap.containsValue(url)进行判断      
                    chain.doFilter(hr, response);  
                }else{  
                   ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper((HttpServletRequest)request);  
           chain.doFilter(requestWrapper, response);  
                }  
    }  
  
    /** 
     * @see Filter#init(FilterConfig) 
     */  
    public void init(FilterConfig fConfig) throws ServletException {  
        // TODO Auto-generated method stub  
    } 
}
