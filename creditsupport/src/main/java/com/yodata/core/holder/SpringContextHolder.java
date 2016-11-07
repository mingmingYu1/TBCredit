package com.yodata.core.holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by zheng.liu@baifendian on 2015-09-10.
 */
public class SpringContextHolder implements ApplicationContextAware {
    private ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }

    public ApplicationContext getContext(){
        return context;
    }

}
