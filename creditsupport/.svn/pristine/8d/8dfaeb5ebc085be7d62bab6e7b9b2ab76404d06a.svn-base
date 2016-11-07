package com.yodata.creditsupport.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author BFD_545
 *
 */
public class StringRandom {
	
	private StringRandom(){}

    /**
     * 获取当前日期+时间
     * @return
     */
    public static String currentDate(){
    	Date date = new Date();
    	DateFormat df = new SimpleDateFormat("yyMMddHHmmss");
    	return df.format(date);
    }
    
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
    
    public static String defaultString(String str) {
        return str == null ? "" : str;
    }
    
    public static String defaultIfEmpty(String str, String defaultStr) {
        return isEmpty(str) ? defaultStr : str;
    }
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
