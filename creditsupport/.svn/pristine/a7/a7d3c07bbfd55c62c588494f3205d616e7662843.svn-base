package com.yodata.creditsupport.dao.hibernate;

import java.io.IOException;
import java.util.Map;

/** 
 * 动态sql/hql语句组装器 
 * @author WangXuzheng 
 * 
 */  
public interface IDynamicHibernateStatementBuilder {  
    /** 
     * hql语句map 
     * @return 
     */  
    public Map<String,String> getNamedHQLQueries();  
    /** 
     * sql语句map 
     * @return 
     */  
    public Map<String,String> getNamedSQLQueries();  
    /** 
     * 初始化 
     * @throws IOException  
     * @throws Exception 
     */  
    public void init() throws IOException, Exception;  
}  
