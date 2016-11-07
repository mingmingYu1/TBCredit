package com.yodata.core.openservice;

import com.yodata.core.domain.LineData;
import org.codehaus.jackson.JsonNode;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by zheng.liu@baifendian on 2015-09-08.
 */
@Component
public class LineSQLParser extends AbstractSQLParser {
    @Override
    public Object transData(ResultSet rs, String disColumns) {
        LineData lineData=new LineData();
        try {
            JsonNode disJson=mapper.readTree(disColumns);
            lineData.setTitle(disJson.get("title").asText());
            LineData.XAxis xAxis=new LineData.XAxis();
            xAxis.setTitle(disJson.get("xAxisTitle").asText());
            LineData.YAxis yAxis=new LineData.YAxis();
            yAxis.setTitle(disJson.get("yAxisTitle").asText());
            JsonNode columns=disJson.get("columns");
            Map<String,List<Object>> yData=new HashMap<>();
            JsonNode item=null;
            Map<String,Integer> columnMap=getRSTypes(rs);
            while (rs.next()){
                Iterator<JsonNode> it= columns.iterator();
                while (it.hasNext()){
                    item=it.next();
                    if (item.get("axis").asText().equalsIgnoreCase("x")){
                        if (xAxis.getData()==null)xAxis.setData(new ArrayList<Object>());
                        xAxis.getData().add(format(rs,item,columnMap));
                    }else {
                        if (!yData.containsKey(item.get("key").asText()))yData.put(item.get("key").asText(),new ArrayList<Object>());
                        yData.get(item.get("key").asText()).add(format(rs,item,columnMap));
                    }
                }
            }
            lineData.setxAxis(xAxis);
            for (Map.Entry<String,List<Object>> entry:yData.entrySet()){
                LineData.YAxisData yAxisData=new LineData.YAxisData();
                yAxisData.setName(entry.getKey());
                yAxisData.setData(entry.getValue());
                if (yAxis.getData()==null)yAxis.setData(new ArrayList<LineData.YAxisData>());
                yAxis.getData().add(yAxisData);
            }
            lineData.setyAxis(yAxis);
            return lineData;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
