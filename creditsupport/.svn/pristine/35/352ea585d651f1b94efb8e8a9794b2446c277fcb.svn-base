package com.yodata.core.openservice;

import com.yodata.core.domain.PieData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonNode;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zheng.liu@baifendian on 2015-09-22.
 */
@Component
public class PieSQLParser extends AbstractSQLParser {
    private final Log log= LogFactory.getLog(PieSQLParser.class);
    @Override
    public Object transData(ResultSet rs, String disColumns) {
        PieData pieData=new PieData();
        JsonNode disJson= null;
        try {
            disJson = mapper.readTree(disColumns);
            pieData.setTitle(disJson.get("title").asText());
            Map<String,Integer> columnMap=getRSTypes(rs);

            while (rs.next()){
                Iterator<JsonNode> it=disJson.get("columns").iterator();
                JsonNode item=null;
                String xAxisValue="";
                Object yAxisValue=null;
                while (it.hasNext()){
                    item=it.next();
                    if (item.get("axis").asText().equalsIgnoreCase("x")){
                        xAxisValue=format(rs,item,columnMap).toString();
                    }else if (item.get("axis").asText().equalsIgnoreCase("y")){
                        if (pieData.getData()==null)pieData.setData(new HashMap<String, Object>());
                        yAxisValue=format(rs,item,columnMap);
                    }
                }
                pieData.getData().put(xAxisValue,yAxisValue);
            }
        } catch (IOException e) {
            log.error("",e);
        } catch (SQLException e) {
            log.error("",e);
        }
        return pieData;
    }
}
