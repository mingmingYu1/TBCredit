package com.yodata.core.openservice;

import com.yodata.core.exception.BusinessException;
import com.yodata.core.helper.SQLHelper;
import com.yodata.core.message.MessageCode;
import com.yodata.core.message.MessageEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zheng.liu@baifendian on 2015-09-07.
 */
public abstract class AbstractSQLParser implements SQLParser {
    private final Log log= LogFactory.getLog(AbstractSQLParser.class);
    protected ObjectMapper mapper=new ObjectMapper();
    @Override
    public Object query(Connection sourceCon, Connection dbCon, String charID, Map params) throws SQLException {
        PreparedStatement ps = sourceCon.prepareStatement(QUERY_CHART);
        ps.setString(1, charID);
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) throw new BusinessException(new MessageEntity(MessageCode.DATA_ERROR, "当前报表中无此报表的相关记录"));
        PreparedStatement dataPS = exeSQL(rs.getString("QUERY_SQL"), dbCon, params, rs.getString("PARAMS"));
        ResultSet data = dataPS.executeQuery();
        //将结果转换成对应的ChartData的格式
        return transData(data, rs.getString("QUERY_COLUMN_DIS"));
    }

    public PreparedStatement exeSQL(String sql,Connection con,Map params,String paramJson){
        String exeSQL=sql;
        Map<String,Integer> map=SQLHelper.analysisSQL(exeSQL);
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            exeSQL=exeSQL.replace(entry.getKey(),"?");
        }

        try {
            PreparedStatement ps=con.prepareStatement(exeSQL);
            if (StringUtils.isNotBlank(paramJson)){
                JsonNode jsonNode=mapper.readTree(paramJson);
                if (jsonNode.size()>0){
                    Iterator<JsonNode> it=jsonNode.iterator();
                    while (it.hasNext()){
                        JsonNode item=it.next();
                        ps.setObject(map.get(item.get("key").asText()),SQLHelper.getValue(item,params.get(item.get("key").asText())));
                    }
//                    for (Map.Entry<String,Integer> entry:map.entrySet()){
//                        ps.setObject(entry.getValue(),SQLHelper.getValue(jsonNode.get(entry.getKey()),params.get(entry.getKey())));
//                    }
                }
            }
            return ps;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public abstract Object transData(ResultSet rs,String disColumns);

    protected Map<String,Integer> getRSTypes(ResultSet rs) throws SQLException {
        ResultSetMetaData rsMetaData= rs.getMetaData();
        Map<String,Integer> map=new HashMap<>();
        for (int i=1;i<=rsMetaData.getColumnCount();i++){
            map.put(rsMetaData.getColumnName(i),rsMetaData.getColumnType(i));
        }
        return map;
    }

    /**
     * 将结果中的值根据特定的格式取出
     * @param rs 结果集
     * @param columnJson 描述性JSON格式参照 http://wiki.baifendian.com/pages/viewpage.action?pageId=4820848
     * @param columnTypes Map:key-列名，Value为类型（类型 为java.sql.Types中的值）
     * @return
     * @throws SQLException
     */
    protected Object format(ResultSet rs,JsonNode columnJson,Map<String,Integer> columnTypes) throws SQLException {
        String columnName=columnJson.get("key").asText();
        switch (columnTypes.get(columnName)){
            case Types.SMALLINT:
            case Types.INTEGER:
            case Types.BIGINT:{
                return  rs.getInt(columnName);
            }
            case Types.FLOAT:
            case Types.DOUBLE:
            case Types.NUMERIC:
            case Types.DECIMAL:{
                if (columnJson.has("format")&&StringUtils.isNotBlank(columnJson.get("format").asText())){
                    DecimalFormat decimalFormat=new DecimalFormat(columnJson.get("format").asText());
                    return Double.parseDouble(decimalFormat.format(rs.getDouble(columnName)));
                }else {
                    return rs.getDouble(columnName);
                }
            }
            case Types.CHAR:
            case Types.VARCHAR:
            case Types.LONGVARCHAR:{
                return rs.getString(columnName);
            }
            case Types.TIME:
            case Types.DATE:
            case Types.TIMESTAMP:{
                SimpleDateFormat format=null;
                if (columnJson.has("format")&&StringUtils.isNotBlank(columnJson.get("format").asText())){
                    format=new SimpleDateFormat(columnJson.get("format").asText());
                }else {
                    format=new SimpleDateFormat("yyyy-MM-dd");
                }
                return format.format(rs.getTimestamp(columnName));
            }
            default:return "";
        }

    }
}
