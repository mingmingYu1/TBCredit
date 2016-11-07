package com.yodata.core.openservice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by zheng.liu@baifendian on 2015-07-14.
 */
public interface SQLParser {
    public static final String QUERY_CHART="SELECT CHART_ID, NAME, QUERY_SQL, PARAMS, QUERY_COLUMN_DIS FROM SYS_CHART_DEF where CHART_ID=?";
    /**
     * 标记key在请求中的参数
     */
    public static final String PARAM_KEY="chartID";
    public Object query(Connection sourceCon,Connection dbCon,String charID,Map params)throws SQLException;

}
