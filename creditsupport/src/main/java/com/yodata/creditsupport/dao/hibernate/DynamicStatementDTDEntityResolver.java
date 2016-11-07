package com.yodata.creditsupport.dao.hibernate;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.internal.util.ConfigHelper;
import org.springframework.core.io.ClassPathResource;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/** 
 * hibernate动态sql dtd解析器 
 * @author WangXuzheng 
 * 
 */  
public class DynamicStatementDTDEntityResolver implements EntityResolver, Serializable{  
    private static final long serialVersionUID = 8123799007554762965L;  
    private static final Log LOGGER = LogFactory.getLog(DynamicStatementDTDEntityResolver.class);  
    private static final String HOP_DYNAMIC_STATEMENT = "http://credit.yodata.com/creditsupport/";
    private static final String USER_NAMESPACE = "classpath://";
  
    public InputSource resolveEntity(String publicId, String systemId) {
        InputSource source = null; // returning null triggers default behavior
        if ( systemId != null ) {
            LOGGER.debug( "Trying to resolve system-id " + systemId );
            if ( systemId.startsWith( HOP_DYNAMIC_STATEMENT ) ) {
                LOGGER.debug( "Recognized hibernate namespace; attempting to resolve on classpath under org/hibernate/" );
                source = resolveOnClassPath( publicId, systemId, HOP_DYNAMIC_STATEMENT );
            } else if ( systemId.startsWith( USER_NAMESPACE ) ) {
                LOGGER.debug( "Recognized local namespace; attempting to resolve on classpath" );
                String path = systemId.substring( USER_NAMESPACE.length() );
                InputStream stream = resolveInLocalNamespace( path );
                if ( stream == null ) {
                    LOGGER.debug( "Unable to locate " + systemId  + " on classpath");
                }
                else {
                    LOGGER.debug( "Located " + systemId  + " in classpath");
                    source = new InputSource( stream );
                    source.setPublicId( publicId );
                    source.setSystemId( systemId );
                }
            }
        }
        return source;
    }

    private InputSource resolveOnClassPath(String publicId, String systemId, String namespace) {
        InputSource source = null;
        String path = "hibernate/" + systemId.substring( namespace.length() );
        InputStream dtdStream = resolveInHibernateNamespace( path );
        if ( dtdStream == null ) {
            LOGGER.debug( "Unable to locate " + systemId + " on classpath");
        } else {
            LOGGER.debug( "Located " + systemId + " in classpath");
            source = new InputSource( dtdStream );
            source.setPublicId( publicId );
            source.setSystemId( systemId );
        }
        return source;
    }

    protected InputStream resolveInHibernateNamespace(String path) {
        return this.getClass().getClassLoader().getResourceAsStream( path );
    }

    protected InputStream resolveInLocalNamespace(String path) {
        try {
            return ConfigHelper.getUserResourceAsStream( path );
        }
        catch ( Throwable t ) {
            return null;
        }
    }
    
//    public InputSource resolveEntity(String publicId, String systemId) {  
//        InputSource source = null; // returning null triggers default behavior  
//        if (systemId != null) {  
//            LOGGER.debug("trying to resolve system-id [" + systemId + "]");
//            if (systemId.startsWith(HOP_DYNAMIC_STATEMENT)) {  
//                LOGGER.debug("recognized hop dyanmic statement namespace;"
//                        + " attempting to resolve on classpath ");  
//                source = resolveOnClassPath(publicId, systemId, HOP_DYNAMIC_STATEMENT); 
//            } else {
//                resolveOnClassPath(publicId, systemId, USER_NAMESPACE);
//            }
//        }  
//        return source;  
//    }  
//    
//  
//    private InputSource resolveOnClassPath(String publicId, String systemId, String namespace) {  
//        InputSource source = null;  
//        String path = "/hibernate/" + systemId.substring(namespace.length());  
//        InputStream dtdStream = null;
//        try {
//            dtdStream = new ClassPathResource(path).getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        };  
//        if (dtdStream == null) {  
//            LOGGER.debug("unable to locate [" + systemId + "] on classpath");
//            if (systemId.substring(namespace.length()).indexOf("2.0") > -1) { 
//                LOGGER.error("Don't use old DTDs, read the Hibernate 3.x Migration Guide!");  
//            }
//        } else {  
//            LOGGER.debug("located [" + systemId + "] in classpath");  
//            source = new InputSource(dtdStream); 
//            source.setPublicId(publicId);  
//            source.setSystemId(systemId);  
//        }  
//        return source;  
//    }  
//  
//    protected InputStream resolveInHibernateNamespace(String path) {  
//        return this.getClass().getClassLoader().getResourceAsStream(path);  
//    }  
//  
//    protected InputStream resolveInLocalNamespace(String path) {  
//        try {  
//            return ConfigHelper.getUserResourceAsStream(path);  
//        }  
//        catch (Throwable t) {  
//            return null;  
//        }  
//    }  
}  
