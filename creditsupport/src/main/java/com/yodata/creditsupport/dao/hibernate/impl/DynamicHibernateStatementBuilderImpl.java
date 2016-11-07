package com.yodata.creditsupport.dao.hibernate.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.hibernate.internal.util.xml.MappingReader;
import org.hibernate.internal.util.xml.OriginImpl;
import org.hibernate.internal.util.xml.XmlDocument;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

import com.yodata.creditsupport.dao.hibernate.IDynamicHibernateStatementBuilder;
import com.yodata.creditsupport.dao.hibernate.DynamicStatementDTDEntityResolver;

/** 
 * @author WangXuzheng 
 * 
 */  
public class DynamicHibernateStatementBuilderImpl implements IDynamicHibernateStatementBuilder, ResourceLoaderAware {  
    private static final Log LOGGER = LogFactory.getLog(DynamicHibernateStatementBuilderImpl.class);  
    private Map<String, String> namedHQLQueries;  
    private Map<String, String> namedSQLQueries;  
    private String[] fileNames = new String[0];  
    private ResourceLoader resourceLoader;  
    private EntityResolver entityResolver = new DynamicStatementDTDEntityResolver();  
    /** 
     * 查询语句名称缓存，不允许重复 
     */  
    private Set<String> nameCache = new HashSet<String>();  
  
    public void setFileNames(String[] fileNames) {  
        this.fileNames = fileNames;  
    }  
  
    @Override  
    public Map<String, String> getNamedHQLQueries() {  
        return namedHQLQueries;  
    }  
  
    @Override  
    public Map<String, String> getNamedSQLQueries() {  
        return namedSQLQueries;  
    }  
  
    @Override  
    public void init() throws Exception {  
        namedHQLQueries = new HashMap<String, String>();  
        namedSQLQueries = new HashMap<String, String>();  
        boolean flag = this.resourceLoader instanceof ResourcePatternResolver;  
        for (String file : fileNames) {  
            if (flag) {  
                Resource[] resources = ((ResourcePatternResolver) this.resourceLoader).getResources(file);  
                buildMap(resources);  
            } else {  
                Resource resource = resourceLoader.getResource(file);  
                buildMap(resource);  
            }  
        }  
        //clear name cache  
        nameCache.clear();  
    }  
  
    @Override  
    public void setResourceLoader(ResourceLoader resourceLoader) {  
        this.resourceLoader = resourceLoader;  
    }  
  
    private void buildMap(Resource[] resources) throws Exception {  
        if (resources == null) {  
            return;  
        }  
        for (Resource resource : resources) {  
            buildMap(resource);  
        }  
    }  
  
    @SuppressWarnings({ "rawtypes" })  
    private void buildMap(Resource resource) throws IOException, Exception {  
        InputSource inputSource = null;  
        try {  
            inputSource = new InputSource(resource.getInputStream());  
            XmlDocument metadataXml = MappingReader.INSTANCE.readMappingDocument(entityResolver, inputSource,  
                    new OriginImpl("file", resource.getFilename()));  
            if (isDynamicStatementXml(metadataXml)) {  
                final Document doc = metadataXml.getDocumentTree();  
                final Element dynamicHibernateStatement = doc.getRootElement();  
                Iterator rootChildren = dynamicHibernateStatement.elementIterator();  
                while (rootChildren.hasNext()) {  
                    final Element element = (Element) rootChildren.next();  
                    final String elementName = element.getName();  
                    if ("sql-query".equals(elementName)) {  
                        putStatementToCacheMap(resource, element, namedSQLQueries);  
                    } else if ("hql-query".equals(elementName)) {  
                        putStatementToCacheMap(resource, element, namedHQLQueries);  
                    }  
                }  
            }  
        } catch (Exception e) {  
            LOGGER.error(e.toString()); 
            throw new Exception(e);  
        } finally {  
            if (inputSource != null && inputSource.getByteStream() != null) {  
                try {  
                    inputSource.getByteStream().close();  
                } catch (IOException e) {  
                    LOGGER.error(e.toString());  
                    throw new IOException(e);  
                }  
            }  
        }  
  
    }  
  
    private void putStatementToCacheMap(Resource resource, final Element element, Map<String, String> statementMap)  
            throws Exception {  
        String sqlQueryName = element.attribute("name").getText();  
        Validate.notEmpty(sqlQueryName);  
        if (nameCache.contains(sqlQueryName)) {  
            throw new Exception("重复的sql-query/hql-query语句定义在文件:" + resource.getURI() + "中，必须保证name的唯一.");  
        }  
        nameCache.add(sqlQueryName);  
        String queryText = element.getText();  
        statementMap.put(sqlQueryName, queryText);  
    }  
  
    private static boolean isDynamicStatementXml(XmlDocument xmlDocument) {  
        return "dynamic-hibernate-statement".equals(xmlDocument.getDocumentTree().getRootElement().getName());  
    }  
}  
