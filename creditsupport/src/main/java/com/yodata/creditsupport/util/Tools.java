package com.yodata.creditsupport.util;

import java.sql.Timestamp;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

public class Tools {
	 /* 通过HttpServletRequest返回IP地址
	 * @param request HttpServletRequest
	 * @return ip String
	 */
	
	final static DecimalFormat df = new DecimalFormat("0.00%");
	
	public static String getIpAddr(HttpServletRequest request) {
		
	    try {
			String ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			    ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			    ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			    ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			    ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			    ip = request.getRemoteAddr();
			}
			return ip;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Timestamp getCurrentDate(){
		return new Timestamp(System.currentTimeMillis()); 
	}
	
	public static String customStatus(String status) {
		if(status == null || "".equals(status)){
			return "待查";
		}else if(status.matches(".*在营.*")||status.matches(".*在业.*")||status.matches(".*开业.*")||status.matches(".*登记成立.*")){
    		return "在营";
    	}else if(status.matches(".*注销.*")){
        	return "注销";
        }else if(status.matches(".*吊销.*")){
	    	return "吊销";
	    }else{
			return "待查";
		}
	}
	
	public static DecimalFormat getDf()
	{
		return df;
	}
	
	public static String getPrecentStr(String precent)
	{
		String precentStr = "";
		if(precent != null && !precent.equals(""))
			precentStr = precent + "%";
		return precentStr;
	}
}
