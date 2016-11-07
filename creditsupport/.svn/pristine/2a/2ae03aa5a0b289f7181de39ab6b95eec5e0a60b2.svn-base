package com.yodata.creditsupport.dao.hibernate;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.yodata.creditsupport.exception.DataAccessException;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class DynamicHibernateSqlDao implements InitializingBean{

    private static final Log LOGGER = LogFactory.getLog(DynamicHibernateSqlDao.class);
    
    @Resource
    protected IDynamicHibernateStatementBuilder dynamicStatementBuilder;

    private Map<String, Template> templateMap;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        templateMap = new HashMap<String, Template>();
        try {
            dynamicStatementBuilder.init();
            Map<String, String> namedHQLQueries = dynamicStatementBuilder.getNamedHQLQueries();
            Map<String, String> namedSQLQueries = dynamicStatementBuilder.getNamedSQLQueries();
            
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
            configuration.setNumberFormat("#");
            StringTemplateLoader stringLoader = new StringTemplateLoader();
            Template template = null;
            for (Entry<String, String> entry : namedHQLQueries.entrySet()) {
                stringLoader.putTemplate(entry.getKey(), entry.getValue());
                template = new Template(entry.getKey(), 
                        new StringReader(entry.getValue()), configuration);
                templateMap.put(entry.getKey(), template);
            }
           
            for (Entry<String, String> entry : namedSQLQueries.entrySet()) {
                stringLoader.putTemplate(entry.getKey(), entry.getValue());
                template = new Template(entry.getKey(), 
                        new StringReader(entry.getValue()), configuration);
                templateMap.put(entry.getKey(), template);
            }
            configuration.setTemplateLoader(stringLoader);
        }catch (IOException e1) {
            e1.printStackTrace();
            LOGGER.error(e1.toString());
        } catch (Exception e1) {
            e1.printStackTrace();
            LOGGER.error(e1.toString());
        }
    }

    /**
     * 根据SQLId和参数获得sql
     * @param sqlId String
     * @param values Map<String, Object>
     * @return
     * @throws DataAccessException
     */
    public String getNamedQuerySql(String sqlId, Map<String, Object> values) throws DataAccessException{
        StringWriter stringWriter = new StringWriter();
        Template template = templateMap.get(sqlId);
        if(template == null){
            throw new DataAccessException("SQL Mapper ID " + sqlId + "不存在");
        }
        try {
            template.process(values, stringWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOGGER.error("SQL文件解析出错", e);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("SQL文件读取出错", e);
        }
        
        return stringWriter.toString();
    }
    
    /**
     * 根据SQLId获得sql
     * @param sqlId
     * @return
     * @throws DataAccessException
     */
    public String getNamedQuerySql(String sqlId) throws DataAccessException{
        StringWriter stringWriter = new StringWriter();
        Template template = templateMap.get(sqlId);
        if(template == null){
            throw new DataAccessException("SQL Mapper ID " + sqlId + "不存在");
        }
        try {
            template.process(null, stringWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
            LOGGER.error("SQL文件解析出错", e);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("SQL文件读取出错", e);
        }
        
        return stringWriter.toString();
    }

}
