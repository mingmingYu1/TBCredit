package com.yodata.core.openservice;

import com.yodata.core.control.BasicAction;
import com.yodata.core.message.MessageEntity;
import com.yodata.core.util.JDBCUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

import static com.yodata.core.message.MessageCode.USER_DEF;

/**
 * Created by zheng.liu@baifendian on 2015-07-13.
 */
@Controller
@RequestMapping("/openservices/chart")
public class ChartService extends BasicAction {
    private final Log log = LogFactory.getLog(ChartService.class);
    /**
     * 这个数据源指的是核心组件的数据源
     */
    @Resource
    private DataSource dataSource;
    /**
     * 这个指的是SQL对应的数据源
     */
    @Resource(name = "dataSource")
    private DataSource source;
    //    @Resource(name = "simpleSQLParser")
//    private SQLParser sqlParser;
    private ObjectMapper mapper = new ObjectMapper();


    private static final String QUERY_CHART = "SELECT CHART_ID, NAME, QUERY_SQL, PARAMS, QUERY_CLOUN_DIS FROM SYS_CHART_DEF where CHART_ID=?";

    /**
     * 这个方法是提供报表的数据查询服务
     *
     * @param chartID 报表存储的ID
     * @return
     */
    @RequestMapping(value = "/data", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryData(String chartID, String charType) {
        Connection con = null;
        Connection sourceCon = null;
        try {
            con = dataSource.getConnection();
            sourceCon = source.getConnection();
            SQLParser sqlParser = SQLParserFactory.createSQLParser(SQLParserType.valueOf(charType.toUpperCase()));
//            sqlParser.query(con, sourceCon, chartID, request.getParameterMap());
//            PreparedStatement ps=con.prepareStatement(QUERY_CHART);
//            ps.setString(1,chartID);
//            ResultSet rs=ps.executeQuery();
//            if (rs.next()){
//            }else {
//                throw new BusinessException(new MessageEntity(DATA_ERROR,"当前报表中无此报表的相关记录"));
//            }
            mapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
            return mapper.writeValueAsString(sqlParser.query(con, sourceCon, chartID, request.getParameterMap()));
        } catch (SQLException e) {
            log.error("", e);
            return new MessageEntity(USER_DEF, "后台程序逻辑错误").toJson();
        } catch (Exception e) {
            log.error("", e);
            return new MessageEntity(USER_DEF, "后台程序逻辑错误").toJson();
        } finally {
            JDBCUtils.closeConnection(con);
            JDBCUtils.closeConnection(sourceCon);
        }
    }

    private static final class ParamDesc {
        private String key;
        private String type;
        private String format;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }
    }
}
