package com.yodata.core.domain;

import java.util.List;

/** 这个是折线图的数据结构
 * Created by zheng.liu@baifendian on 2015-09-07.
 */
public class LineData {
    private String title;
    private XAxis xAxis;
    private YAxis yAxis;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public XAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(XAxis xAxis) {
        this.xAxis = xAxis;
    }

    public YAxis getyAxis() {
        return yAxis;
    }

    public void setyAxis(YAxis yAxis) {
        this.yAxis = yAxis;
    }

    public static class XAxis{
        private String title;
        private List<Object> data;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Object> getData() {
            return data;
        }

        public void setData(List<Object> data) {
            this.data = data;
        }
    }

    public static class YAxis{
        private String title;
        private List<YAxisData> data;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<YAxisData> getData() {
            return data;
        }

        public void setData(List<YAxisData> data) {
            this.data = data;
        }
    }

    public static class YAxisData{
        private String name;
        private List<Object> data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Object> getData() {
            return data;
        }

        public void setData(List<Object> data) {
            this.data = data;
        }
    }
}
