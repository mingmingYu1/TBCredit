/******************************************************************************
 * Copyright (C) 2016 Yodata Co.,Ltd
 * All Rights Reserved.
 * 该软件有前海云游数据开发并拥有版权，在未经得前海云游数据有限公司正式书面授权情况下，
 * 任何公司，个人或者团体不得擅自修改，发布，使用本软件。违者必究。
 ******************************************************************************/
package com.yodata.creditsupport.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @to-do <请填写该类的功能>
 * @model creditsupport
 * @author Administrator
 * @since 1.0
 * @version 2016年7月1日 Administrator
 */
public class NullObjectUtil {
	private static final Logger log = Logger.getLogger(NullObjectUtil.class);
    /**
     * 获取控对象
     * @return
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static Object getNullObject(Object obj) {
	try{
	    Field[] objFlds = obj.getClass().getDeclaredFields();
	    String strType = "";
	    int iLastIndex = 0 ;
	    for (Field field:objFlds) {
		field.setAccessible(true);
		strType = field.getGenericType().toString();
		iLastIndex = strType.lastIndexOf(".")==-1? 0:strType.lastIndexOf(".")+1;
		strType = strType.substring(iLastIndex);
		if("String".equals(strType)){
		    field.set(obj, "空");
		}else if("int".equals(strType)||"Integer".equals(strType)){
		    field.set(obj, 10);
		}else if("Date".equals(strType)){
		    field.set(obj, Calendar.getInstance().getTime());
		}else if("float".equals(strType)||"Float".equals(strType)){
		    field.set(obj, 0.0f);
		}else if("double".equals(strType)||"Double".equals(strType)){
		    field.set(obj, 0.0);
		}
	    }
	    return obj;
	}catch(Exception ex){
		log.error(ex);
	}
	return obj;
    }
    
    public static List<Object> getNullObjectList(Object obj) {
		List<Object> list = new ArrayList<Object>();
		try {
			Field[] objFlds = obj.getClass().getDeclaredFields();
			String strType = "";
			int iLastIndex = 0;
			for (Field field : objFlds) {
				field.setAccessible(true);
				strType = field.getGenericType().toString();
				iLastIndex = strType.lastIndexOf(".") == -1 ? 0 : strType.lastIndexOf(".") + 1;
				strType = strType.substring(iLastIndex);
				if ("String".equals(strType)) {
					field.set(obj, "N/A");
				} else if ("int".equals(strType) || "Integer".equals(strType)) {
					field.set(obj, -9999);
				} else if ("Date".equals(strType)) {
					field.set(obj, Calendar.getInstance().getTime());
				} else if ("float".equals(strType) || "Float".equals(strType)) {
					field.set(obj, 0f);
				} else if ("double".equals(strType) || "Double".equals(strType)) {
					field.set(obj, 0.0d);
				}
			}
			list.add(obj);
			return list;
		} catch (Exception ex) {
			log.error(ex);
		}
		return list;
	}
}
