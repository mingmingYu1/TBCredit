/******************************************************************************
 * Copyright (C) 2016 Yodata Co.,Ltd
 * All Rights Reserved.
 * 该软件有前海云游数据开发并拥有版权，在未经得前海云游数据有限公司正式书面授权情况下，
 * 任何公司，个人或者团体不得擅自修改，发布，使用本软件。违者必究。
 ******************************************************************************/
package com.yodata.creditsupport.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @to-do <请填写该类的功能>
 * @model creditsupport
 * @author Administrator
 * @since 1.0
 * @version 2016年7月8日 Administrator
 */
public class BigNumUtil {
     
    /**
     * 将大数转换成百万
     * @param value
     * @return
     */
     public static String convert2Million(String value){
	 if(value.contains("E")){
	     BigDecimal objDecimal = new BigDecimal(value);
	     double objMillon = objDecimal.doubleValue()/Math.pow(10, 6);
	     DecimalFormat df = new DecimalFormat("#.00");
         df.setRoundingMode(RoundingMode.HALF_UP);
	     return df.format(objMillon)+"（百万）";
	 }
	 return value;
     }
}
