package com.yodata.creditsupport.jstl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.yodata.creditsupport.orm.vo.Menu;

/**
 * User: zheng.liu@baifendian.com
 * Date: 14-9-15
 * Time: 上午9:51
 */
public class Permission extends TagSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2528654252938864256L;
	private String uri;
    private String rId;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    @SuppressWarnings("unchecked")
	@Override
    public int doStartTag() throws JspException {
    	HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
    	List<Menu> menuList = (List<Menu>) request.getSession().getAttribute("menuList");
    	List<Integer> list = new ArrayList<>();
    	for(Menu menu:menuList){
    		list.add(menu.getMenuId());
    	}
    	if(rId.startsWith("!")){
    	    if(list.contains(new Integer(rId.substring(1, rId.length())))){
                 return SKIP_BODY;
            }else{
                 return EVAL_BODY_INCLUDE;
            }
    	}
    	if(list.contains(new Integer(rId.toString()))){
    		return EVAL_BODY_INCLUDE;
    	}else{
    		 return SKIP_BODY;
    	}
    	
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
    
}
