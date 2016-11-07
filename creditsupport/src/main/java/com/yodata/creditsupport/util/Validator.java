package com.yodata.creditsupport.util;
 
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
 
/**
 * 校验器：利用正则表达式校验邮箱、手机号等
 * 
 * @author liujiduo
 * 
 */
public class Validator {
	/**
	 * 
	 * 征信报告编号验证
	 * 由营业执照号、生成日期、当天编号组成
	 */
	public static final String REGEX_FILENO_STR = "regex.fileno";
	public static String regexFileNo;
	/**
     * 验证名称，只能为 简繁中文 大小写字母下划线_和英文点号.
     * 长度为1到20
     */
    public static final String REGEX_FULLNAME_STR = "regex.fullname";
    public static String regexFullName;
    
    /**
     * 验证编号，字母数字下划线的1~20字符串
     */
    public static final String REGEX_STRNUMBER_STR = "regex.strnumber";
    public static String regexStrNumber;
    /**
     * 校验评分等级名称
     * 必须为英文大小写字母和+-符合的1~20长度组合
     */
    public static final String REGEX_LEVELNAME_STR = "regex.levelname";
    public static String regexLevelName;
    /**
     * 正则表达式：验证用户名
     */
    public static final String REGEX_USERNAME_STR = "regex.username";
    public static String regexUserName;
    public static final String REGEX_USERNAME2_STR = "regex.username2";
    public static String regexUserName2;
    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD_STR = "regex.password";
    public static String regexPassword;
    public static final String REGEX_PASSWORD2_STR = "regex.password2";//必须为数字和字母的组合,8-16位
    public static String regexPassword2;
    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE_STR = "regex.mobile";
    public static String regexMobile;
    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL_STR = "regex.email";
    public static String regexEmail;
    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE_STR = "regex.chinese";
    public static String regexChinese;
    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD_STR = "regex.id.card";
    public static String regexIdCard;
    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL_STR = "regex.url";
    public static String regexUrl;
    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR_STR = "regex.ip.addr";
    public static String regexIpAddr;
    
    /**
     * 正则表达式：验证企业名称
     */
    public static final String REGEX_COMP_NAME = "regex.comp.name";
    public static String regexCompName;
 
    private static Properties props;
    static {
        Resource resource = new ClassPathResource("/validator-config.properties");
        EncodedResource enRecource = new EncodedResource(resource, "UTF-8");
        try {
            props = PropertiesLoaderUtils.loadProperties(enRecource);
            regexFileNo = props.getProperty(REGEX_FILENO_STR);
            regexFullName = props.getProperty(REGEX_FULLNAME_STR);
            regexStrNumber = props.getProperty(REGEX_STRNUMBER_STR);
            regexLevelName = props.getProperty(REGEX_LEVELNAME_STR);
            regexUserName = props.getProperty(REGEX_USERNAME_STR);
            regexUserName2 = props.getProperty(REGEX_USERNAME2_STR);
            regexPassword = props.getProperty(REGEX_PASSWORD_STR);
            regexPassword2 = props.getProperty(REGEX_PASSWORD2_STR);
            regexMobile = props.getProperty(REGEX_MOBILE_STR);
            regexEmail = props.getProperty(REGEX_EMAIL_STR);
            regexChinese = props.getProperty(REGEX_CHINESE_STR);
            regexIdCard = props.getProperty(REGEX_ID_CARD_STR);
            regexUrl = props.getProperty(REGEX_URL_STR);
            regexIpAddr = props.getProperty(REGEX_IP_ADDR_STR);
            regexCompName = props.getProperty(REGEX_COMP_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 验证征信报告编号规则
     * @param fileNo
     * @return 	校验通过返回true，否则返回false
     */
    public static boolean isFileNo(String fileNo) {
    	if(fileNo == null) return false;
    	return Pattern.matches(fileNo, fileNo);
    }
    /**
     * 校验名称
     * @param name
     * @return	校验通过返回true，否则返回false
     */
    public static boolean isFullName(String name) {
    	if(name == null) return false;
    	return Pattern.matches(regexFullName, name);
    }
    
    /**
     * 校验编号
     * @param number
     * @return	校验通过返回true，否则返回false
     */
    public static boolean isStrNumber(String number) {
    	if(number == null) return false;
    	return Pattern.matches(regexStrNumber, number);
    }
    
    /**
     * 校验评分等级名称
     * @param name
     * @return	校验通过返回true，否则返回false
     */
    public static boolean isLevelName(String name) {
    	if(name == null) return false;
    	return Pattern.matches(regexLevelName, name);
    }
    
    /**
     * 校验用户名
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsername(String username) {
    	if(username == null) return false;
        return Pattern.matches(regexUserName, username);
    }
 
    /**
     * 校验密码
     * 
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
    	if(password == null) return false;
        return Pattern.matches(regexPassword2, password);
    }
 
    /**
     * 校验手机号
     * 
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(regexMobile, mobile);
    }
 
    /**
     * 校验邮箱
     * 
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(regexEmail, email);
    }
 
    /**
     * 校验汉字
     * 
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(regexChinese, chinese);
    }
 
    /**
     * 校验身份证
     * 
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(regexIdCard, idCard);
    }
 
    /**
     * 校验URL
     * 
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(regexUrl, url);
    }
 
    /**
     * 校验IP地址
     * 
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(regexIpAddr, ipAddr);
    }
    
    
    public static boolean isCompName(String compName) {
        return Pattern.matches(regexCompName, compName);
    }
}