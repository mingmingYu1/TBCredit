package com.yodata.core.control;

import com.yodata.core.domain.Page;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/** 这个方法完成Control中Request和Response的注入
 * Created by zheng.liu@baifendian on 2015-07-09.
 */
public class BasicAction {
    @Resource
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    ThreadLocal<Map<String,Object>> threadLocal=new ThreadLocal<Map<String, Object>>();

    /**
     * 提供一些基本的通用属性和方法，让上下文重用
     * @param request
     */
    @ModelAttribute
    public void initData(HttpServletRequest request){
        Page page=new Page();
        if(request.getParameter("countPerPage")!=null)page.setCountPerPage(Integer.parseInt(request.getParameter("countPerPage")));
        if(request.getParameter("current")!=null)page.setCurrent(Integer.parseInt(request.getParameter("current")));
        if (threadLocal.get()==null){
            Map<String,Object> map=new HashMap<String, Object>();
            threadLocal.set(map);
        }
        threadLocal.get().put("page",page);
    }

    protected Page getPage(){
        return (Page) threadLocal.get().get("page");
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}
