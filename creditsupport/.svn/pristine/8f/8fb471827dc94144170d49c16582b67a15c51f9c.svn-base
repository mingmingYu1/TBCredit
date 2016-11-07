package com.yodata.core.helper;

import com.yodata.core.openservice.SQLType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonNode;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zheng.liu@baifendian on 2015-08-28.
 */
public class SQLHelper {
    private static Log log= LogFactory.getLog(SQLHelper.class);
    /**
     * 将SQL的参数解析成一个Map
     * @param sql
     * @return
     */
    public static Map<String,Integer> analysisSQL(String sql){
        int i =0;
        boolean begin=false;
        int beginIndex=0;
        int index=0;
        Map<String ,Integer> map=new LinkedHashMap<>();
        while (i<sql.length()){
            char word=sql.charAt(i);
            if ('#'==word){
                if (begin){
                    begin=false;
                    map.put(sql.substring(beginIndex,i+1),index);
                }else{
                    index++;
                    beginIndex=i;
                    begin=true;
                }
            }
            i++;
        }
        return map;
    }

    public static Object getValue(JsonNode json){
        SQLType paramType=SQLType.valueOf(json.get("type").asText().toUpperCase());
        switch (paramType){
            case INT:return json.get("testvalue").asInt();
            case STRING:return json.get("testvalue").asText();
            case LONG:return json.get("testvalue").asLong();
            case DOUBLE:return json.get("testvalue").asDouble();
            case DATE:{
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return format.parse(json.get("testvalue").asText());
                } catch (ParseException e) {
                    log.error("",e);
                    return null;
                }
            }
        }
        return null;
    }

    public static Object getValue(JsonNode json,Object value){
        SQLType paramType=SQLType.valueOf(json.get("type").asText().toUpperCase());
        String transValue="";
        if (value instanceof Object[]){
            transValue=((Object [])value)[0].toString();
        }else {
            transValue=value.toString();
        }
        switch (paramType){
            case INT:return Integer.parseInt(transValue);
            case STRING:return transValue;
            case LONG:return Long.parseLong(transValue);
            case DOUBLE:return Double.parseDouble(transValue);
            case DATE:{
                SimpleDateFormat format=null;
                if (json.has("format"))format=new SimpleDateFormat(json.get("format").asText());
                else format=new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return format.parse(transValue);
                } catch (ParseException e) {
                    log.error("",e);
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * 遍历查询结果中的数据
     * @param rs
     * @return
     */
    public static List<List<Object>> queryWithMate(ResultSet rs) throws SQLException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        ResultSetMetaData metaData= rs.getMetaData();
        List<List<Object>> list=new LinkedList<>();
        List<Object> head=new LinkedList<>();
        for (int i=1;i<=metaData.getColumnCount();i++){
            head.add(metaData.getColumnName(i));
        }
        list.add(head);
        //将数据加进去
        while (rs.next()){
            List<Object> dataList=new LinkedList<>();
            for (int i=1;i<=metaData.getColumnCount();i++){
                Object item=rs.getObject(i);
                if (item==null){
                    dataList.add("");
                }else if (metaData.getColumnType(i)>= Types.DATE &&metaData.getColumnType(i)<= Types.TIMESTAMP){
                    dataList.add(format.format(rs.getDate(i)));
                }else{
                    dataList.add(rs.getObject(i));
                }
            }
            list.add(dataList);
        }
        return list;
    }
}
