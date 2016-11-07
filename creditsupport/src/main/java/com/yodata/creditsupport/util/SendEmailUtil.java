package com.yodata.creditsupport.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.xwpf.converter.core.utils.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 发送邮件工具类
 * @author Anna
 *
 */
public class SendEmailUtil {
	
	
	private static Properties sendMailProps;
	static {
		Resource resource = new ClassPathResource("/email-config.properties");
		EncodedResource enRecource = new EncodedResource(resource, "UTF-8");
        try {
        	sendMailProps = PropertiesLoaderUtils.loadProperties(enRecource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送邮件,如果文件作为附件的文件数量大于1个，则压缩后发送，如果文件数量为1且targetFileName为空，直接发送
	 * @param filePaths 邮件的附件路径，不可为空
	 * @param emailAddrs 邮件的收件人,可为空
	 * @param targetFilePath 包括文件路径，文件名；如果邮件附件需要压缩后发送，此项不可为空；否则，将不压缩
	 * @return
	 * @throws Exception
	 */
	public static boolean sendEmails(List<String> filePaths, List<String> emailAddrs, String targetFilePath) throws Exception {
		
		//附件不能为空
		if(filePaths==null || filePaths.isEmpty()){
			return false;
		}
		
		String emailSubject = sendMailProps.getProperty("mail.send.subject", "企业信用评分低于50分示警");
		// 判断是否需要身份认证
		Authenticator authenticator = null;
		// 创建一个密码验证器
		authenticator = new Authenticator(){
			@Override
		    protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sendMailProps.getProperty("mail.send.from.username"), 
						sendMailProps.getProperty("mail.send.from.password"));
		    }
		};
		
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Properties mailPro = new Properties();
		mailPro.put("mail.smtp.host", sendMailProps.getProperty("mail.smtp.host"));   
		mailPro.put("mail.smtp.port", sendMailProps.getProperty("mail.smtp.port"));   
		mailPro.put("mail.smtp.auth", sendMailProps.getProperty("mail.smtp.auth"));   
		Session sendMailSession = Session.getInstance(mailPro, authenticator);
		
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(sendMailProps.getProperty("mail.send.from.address"));
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			Address[] addresses = null;
			if(emailAddrs != null && !emailAddrs.isEmpty()){
				addresses = new Address[emailAddrs.size()];
				for(int i=0; i< emailAddrs.size(); i++){
					addresses[i] = new InternetAddress(emailAddrs.get(i));
				}
			} else {
				String emailAddrStr = sendMailProps.getProperty("mail.send.to.addresses");
				if(StringUtils.isNotEmpty(emailAddrStr)){
					String[] addrArrStr = emailAddrStr.split(";");
					addresses = new Address[addrArrStr.length];
					for(int i=0; i< addrArrStr.length; i++){
						addresses[i] = new InternetAddress(addrArrStr[i]);
					}
				} else {
					return false;
				}
			}
			// Message.RecipientType.TO属性表示接收者的类型为TO
			mailMessage.setRecipients(Message.RecipientType.TO, addresses);
			// 设置邮件消息的主题
			mailMessage.setSubject(emailSubject);
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			// 设置HTML内容
			String content = "附件为" + emailSubject + " ，请查收！";
			html.setContent(content, "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			
			//如果作为附件的文件多于1个（2个以上），则以当前日期为压缩后的文件名
			if(filePaths.size() > 1){
				if(StringUtils.isEmpty(targetFilePath)){
					targetFilePath = DateFormatUtils.format(new Date(), "yyyy-MM-dd")
							+ ".zip";
				}
			}
			// 添加附件的内容, 先将附件压缩
			if(targetFilePath == null || "".equals(targetFilePath.trim())){
				if(filePaths.size() == 1){
					File attachment = new File(filePaths.get(0));
					if (attachment != null) {
						BodyPart attachmentBodyPart = new MimeBodyPart();
						DataSource source = new FileDataSource(attachment);
						attachmentBodyPart.setDataHandler(new DataHandler(source));
						
						// 网上流传的解决文件名乱码的方法，其实用MimeUtility.encodeWord就可以很方便的搞定
						// 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
						//sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
						//messageBodyPart.setFileName("=?GBK?B?" + enc.encode(attachment.getName().getBytes()) + "?=");
						
						//MimeUtility.encodeWord可以避免文件名乱码
						attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
						mainPart.addBodyPart(attachmentBodyPart);
					}
				}
			} else {
				FileToZipUtil.filesToZip(filePaths, targetFilePath);
				File attachment = new File(targetFilePath);
				if (attachment != null) {
					BodyPart attachmentBodyPart = new MimeBodyPart();
					DataSource source = new FileDataSource(attachment);
					attachmentBodyPart.setDataHandler(new DataHandler(source));
					
					// 网上流传的解决文件名乱码的方法，其实用MimeUtility.encodeWord就可以很方便的搞定
					// 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
					//sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
					//messageBodyPart.setFileName("=?GBK?B?" + enc.encode(attachment.getName().getBytes()) + "?=");
					
					//MimeUtility.encodeWord可以避免文件名乱码
					attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
					mainPart.addBodyPart(attachmentBodyPart);
				}
			}
			
			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(mainPart);
			// 发送邮件
			Transport.send(mailMessage);
			
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
			throw new MessagingException();
		} finally {
			// 判断目录或文件是否存在 
			if(StringUtils.isNotEmpty(targetFilePath)){
				File zipFile = new File(targetFilePath);
				if (zipFile.exists()) {
					// 判断是否为文件  
					if (zipFile.isFile()) {  // 为文件时调用删除文件方法  
						zipFile.delete();  
					}
				} 
			}
		}
	}
	
	
	/**
	 * 发送邮件
	 * @param filePaths 邮件的附件路径, 不可为空
	 * @return
	 * @throws Exception
	 */
	public static boolean sendEmails(List<String> filePaths) throws Exception {
		
		//邮件附件不可为空
		if(filePaths == null || filePaths.isEmpty()){
			return false;
		}
		String emailSubject = sendMailProps.getProperty("mail.send.subject", "企业信用评分低于50分示警");
		// 判断是否需要身份认证
		Authenticator authenticator = null;
		// 创建一个密码验证器
		authenticator = new Authenticator(){
			@Override
		    protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sendMailProps.getProperty("mail.send.from.username"), 
						sendMailProps.getProperty("mail.send.from.password"));
		    }
		};
		
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Properties mailPro = new Properties();
		mailPro.put("mail.smtp.host", sendMailProps.getProperty("mail.smtp.host"));   
		mailPro.put("mail.smtp.port", sendMailProps.getProperty("mail.smtp.port"));   
		mailPro.put("mail.smtp.auth", sendMailProps.getProperty("mail.smtp.auth"));   
		Session sendMailSession = Session.getInstance(mailPro, authenticator);
		
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(sendMailProps.getProperty("mail.send.from.address"));
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			Address[] addresses = null;
			String emailAddrStr = sendMailProps.getProperty("mail.send.to.addresses");
			if(StringUtils.isNotEmpty(emailAddrStr)){
				String[] addrArrStr = emailAddrStr.split(";");
				addresses = new Address[addrArrStr.length];
				for(int i=0; i< addrArrStr.length; i++){
					addresses[i] = new InternetAddress(addrArrStr[i]);
				}
			} else {
				return false;
			}
			// Message.RecipientType.TO属性表示接收者的类型为TO
			mailMessage.setRecipients(Message.RecipientType.TO, addresses);
			// 设置邮件消息的主题
			mailMessage.setSubject(emailSubject);
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			// 设置HTML内容
			String content = "附件为" + emailSubject + " ，请查收！";
			html.setContent(content, "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			
			// 添加附件的内容, 先将附件压缩
			for(String fPath : filePaths){
				File attachment = new File(fPath);
				if (attachment != null) {
					BodyPart attachmentBodyPart = new MimeBodyPart();
					DataSource source = new FileDataSource(attachment);
					attachmentBodyPart.setDataHandler(new DataHandler(source));
					
					// 网上流传的解决文件名乱码的方法，其实用MimeUtility.encodeWord就可以很方便的搞定
					// 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
					//sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
					//messageBodyPart.setFileName("=?GBK?B?" + enc.encode(attachment.getName().getBytes()) + "?=");
						
					//MimeUtility.encodeWord可以避免文件名乱码
					attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
					mainPart.addBodyPart(attachmentBodyPart);
				}
			}
			
			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(mainPart);
			// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
			throw new MessagingException();
		}
	}
	
	
	public static void main(String[] args){
//		List<String> emailAddrs = new ArrayList<String>();
//		emailAddrs.add("huina.zhou@baifendian.com");
//		emailAddrs.add("cimc_actionsupport@163.com");
		List<String> filePaths = new ArrayList<String>();
		filePaths.add("D:/qhyynote/征信报告模板.pdf");
		filePaths.add("D:/qhyynote/前海云游标签设计&销量预测开发计划 -V1.2.mpp");
//		filePaths.add("D:/qhyynote/qhyynote.txt");
//		String targetFilePath = "D:/zjnote/test160107007.zip";
		try {
			sendEmails(filePaths, null, null);
//			sendEmails(filePaths);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
