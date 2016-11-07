package com.yodata.core.jstl;

import com.yodata.core.domain.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/** 生成分页信息 页的开始是从第一页开始
 * Created by zheng.liu@baifendian on 2015-07-30.
 */
public class PageTag extends TagSupport {
//    private final Log log= LogFactory.getLog(PageTag.class);
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //    <nav>
//    <ul class="pagination">
//    <li>
//    <a href="#" aria-label="up"><span aria-hidden="true">up</span> </a>
//    </li>
//
//    </ul>
//    </nav>
    @Override
    public int doStartTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
        JspWriter writer = this.pageContext.getOut();
        Page page = (Page) request.getAttribute("page");
        //如果当前没有分页页面 刚默认不显示
        try {
            if (page == null) {
                writer.write("<nav>");
                writer.write("<ul class=\"pagination\">");
                writer.write("<li><a href=\"#\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span> </a></li>");
                writer.write("<li><a href=\"#\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span> </a></li>");
                writer.write("</ul>");
                writer.write("</nav>");
            }else {
                int pages=page.getCount()%page.getCountPerPage()==0?(page.getCount()/page.getCountPerPage()):(page.getCount()/page.getCountPerPage()+1);
                String indexUrl=request.getContextPath()+url+"?current=";
                writer.write("<nav>");
                writer.write("<ul class=\"pagination\">");
                writer.write("<li><a href=\""+indexUrl+(page.getCurrent()<=1?1:page.getCurrent()-1)+"\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span> </a></li>");
                for (int i=1;i<=pages;i++){
                    String className="";
                    //设置活动的页
                    if (i==page.getCurrent()){
                        className="active";
                    }
                    writer.write("<li class=\""+className+"+\"><a href=\""+indexUrl+i+"\">1</a></li>");
                }
                writer.write("<li><a href=\""+indexUrl+(pages<=page.getCurrent()?page.getCurrent():page.getCurrent()-1)+"\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span> </a></li>");
                writer.write("</ul>");
                writer.write("</nav>");
            }
        } catch (IOException e) {
//            log.error("",e);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
