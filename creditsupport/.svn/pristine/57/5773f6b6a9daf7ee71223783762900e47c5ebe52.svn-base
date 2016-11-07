package com.yodata.creditsupport.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Properties;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * @Title:FTP客户端工具
 * @author: jin.liu
 * @Date 2016-03-09
 */
public class FTPClientUtil{
	//日志
	private final Log log= LogFactory.getLog(FTPClientUtil.class);
    //实例
    private static FTPClientUtil instance;
    //Apache FTPClient
    private static FTPClient ftpClient;
    //文件字符编码
    private static String encoding;
    //ip :172.17.128.27
    private static final String IP = "172.17.128.27";
    //port：21
    private static final int PORT = 21;
    //username：ftpdata
    private static final String USER_NAME = "ftpdata";
    //password：ftpdata
    private static final String PASSWORD = "ftpdata";
    
    private static final String FTP_IP = "ftp.user.ip";
    private static final String FTP_PORT = "ftp.user.port";
    private static final String FTP_USER = "ftp.user.userName";
    private static final String FTP_PWD = "ftp.user.userPassword";
    
    
    private static Properties ftpProps;
    static {
        Resource resource = new ClassPathResource("/config.properties");
        EncodedResource enRecource = new EncodedResource(resource, "UTF-8");
        try {
            ftpProps = PropertiesLoaderUtils.loadProperties(enRecource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * 单例模式：私有构造器
     */
    
    private FTPClientUtil(){
    	
    }
    /*
     * 单例模式：获取实例
     */
    public static synchronized FTPClientUtil getInstance(){
		if(instance == null){
			instance = new FTPClientUtil();
		    encoding = System.getProperty("file.encoding");
			ftpClient = new FTPClient();
		}
    	return instance;
    }
    /**
     * @Description: 上传文件
     * @param	path 		上传到FTP服务器的目录,如果是根目录则为"/"
     * @param	fileName　	上传到FTP服务器的文件名
     * @param	input　		本地文件输入流
     * @return	成功返回true，否则返回false
     */
    public boolean uploadFile(String remotePath, String remoteFileName, InputStream input) {
        boolean result = false;
        try {
            String ftpIp = ftpProps.getProperty(FTP_IP, IP);
            String ftpPortStr = ftpProps.getProperty(FTP_PORT);
            int ftpPort = StringUtils.isNotBlank(ftpPortStr) 
                    ? Integer.parseInt(ftpPortStr) : PORT;
            String ftpUser = ftpProps.getProperty(FTP_USER, USER_NAME);
            String ftpPwd = ftpProps.getProperty(FTP_PWD, PASSWORD);
        	ftpClient.setControlEncoding(encoding);
            ftpClient.connect(ftpIp, ftpPort);
            ftpClient.login(ftpUser, ftpPwd);
            ftpClient.enterLocalPassiveMode();//如果服务器不支持主动模式则一定要设置为被动模式，否则无法上传和下载
            // 设置文件传输类型为二进制
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            // 获取ftp登录应答代码
            int reply = ftpClient.getReplyCode();
            // 验证是否登陆成功
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                log.error("ftp服务器拒绝连接！");
                return result;
            }
            //创建目录结构   
            String[] dirs = remotePath.split("/");
            StringBuffer sb = new StringBuffer();
            for (String dir : dirs) {
			    if (dir != null && !"".equals(dir)) {
			    	sb.append("/");
			    	sb.append(dir);
			    	ftpClient.makeDirectory(sb.toString());
				}
			}
            // 转移到FTP服务器目录至指定的目录下
            ftpClient.changeWorkingDirectory(new String(remotePath.getBytes(encoding),"iso-8859-1"));
            result = ftpClient.storeFile(remoteFileName, input);
            if (result) {
                log.info("上传文件成功!");
            }
//            ftpClient.completePendingCommand(); 
            ftpClient.logout();
        } catch (IOException e) {
            log.error("上传PDF文件到ftp异常", e);
        } finally {
        	if(input != null) {
        		try {
					input.close();
				} catch (IOException e) {
					log.error("关闭输入流失败", e);
				}
        	}
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                    log.info("关闭ftp成功！--[上传文件]");
                } catch (IOException ioe) {
                	log.error("关闭ftp连接失败--[上传文件]", ioe);
                }
            }
        }
        return result;
    }
    /**
     * @Description: 下载文件
     * @param	path 		FTP服务器上的保存目录,如果是根目录则为"/"
     * @param	fileName　	FTP服务器上的文件名
     * @param	response　	处理当前请求的线程的http返回对象
     * @return	成功返回true，否则返回false
     */
    	public boolean downFile(String path, String fileName, HttpServletResponse response) {
        boolean result = false;
        try {
            ftpClient.setControlEncoding(encoding);
            ftpClient.connect(IP, PORT);
            ftpClient.login(USER_NAME, PASSWORD);
            ftpClient.enterLocalPassiveMode();//设置为被动模式
            // 设置文件传输类型为二进制
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            // 获取ftp登录应答代码
            int reply = ftpClient.getReplyCode();
            // 验证是否登陆成功
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                log.error("ftp服务器拒绝连接！");
                return result;
            }
            // 转移到FTP服务器目录至指定的目录下
            ftpClient.changeWorkingDirectory(new String(path.getBytes(encoding),"iso-8859-1"));
            FTPFile[] fs = ftpClient.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                	ServletOutputStream outputStream = response.getOutputStream();
                	response.setHeader("Content-disposition","attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
                    ftpClient.retrieveFile(ff.getName(), outputStream);
                    outputStream.flush();
                    result = true;
                    break;
                }
            }
            ftpClient.logout();
        } catch (IOException e) {
            log.error("下载文件出现错误", e);
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                	log.error("关闭ftp连接失败--[下载文件]");
                }
            }
        }
        return result;
    }
//    public static void main(String[] args) {
//    	//测试上传
//    	try {
//    		FileInputStream fis = new FileInputStream(new File("C:\\Users\\think4\\Desktop\\HadoopiA2E_MEAP_ch01.pdf"));
//    		FTPClientUtil.getInstance().uploadFile("/download/test/abc", "test.pdf", fis);
//    	} catch (Exception e) {
//    		e.printStackTrace();
//    	}
//    	
//    	//测试下载
////    	try {
////    		boolean flag = FTPClientUtil.getInstance().downFile("/forum", "install.jsp", "D:/");
////    	} catch (Exception e) {
////    		e.printStackTrace();
////    	}
//    }

}