package com.yodata.core.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/** 这个方法是判断Session中是否有对应Path下的Token，如果相同则是重复提交，不允许
 *
 * Created by zheng.liu@baifendian on 2015-07-09.
 */
public class AvoidDuplicateSubmissionInterceptor extends HandlerInterceptorAdapter {
    private final Log logger= LogFactory.getLog(AvoidDuplicateSubmissionInterceptor.class);
    private static int token=0;
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {

//        User user = UserUtil.getUser();
//        if (user != null) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();

            AvoidDuplicateSubmission annotation = method.getAnnotation(AvoidDuplicateSubmission.class);
            if (annotation != null) {
                boolean needSaveSession = annotation.needSaveToken();
                if (needSaveSession) {
                    request.getSession(false).setAttribute("token", generateToken());
                }

                boolean needRemoveSession = annotation.needRemoveToken();
                if (needRemoveSession) {
                    if (isRepeatSubmit(request)) {
                        logger.warn("please don't repeat submit,[user:" + request.getUserPrincipal() + ",url:"+ request.getServletPath() + "]");
                        return false;
                    }
                    request.getSession(false).removeAttribute("token");
                }
            }
//        }
        return true;
    }

    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(false).getAttribute("token");
        if (serverToken == null) {
            return true;
        }
        String clientToken = request.getParameter("token");
        if (clientToken == null) {
            return true;
        }
        if (!serverToken.equals(clientToken)) {
            return true;
        }
        return false;
    }

    public static synchronized int generateToken(){
        if (token>=10000){
            token=0;
        }
        token++;
        return token;
    }
}
