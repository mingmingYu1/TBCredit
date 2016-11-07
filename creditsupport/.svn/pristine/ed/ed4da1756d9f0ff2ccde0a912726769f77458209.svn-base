package com.yodata.core.util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by zheng.liu@baifendian on 2015-07-15.
 */
public class JDBCUtils {
    public static void closeConnection(Connection con){
        try {
            if (con!=null&&!con.isClosed()){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
