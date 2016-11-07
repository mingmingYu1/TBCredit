package com.yodata.core.domain;

import java.util.Map;

/** 这个是饼图的图形结构
 * Created by zheng.liu@baifendian on 2015-09-22.
 */
public class PieData {
    private String title;
    private Map<String,Object> data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}

