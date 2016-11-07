package com.yodata.core.openservice;

/** 支持的几种类型
 * Created by zheng.liu@baifendian on 2015-08-28.
 */
public enum SQLType {
    INT("int"),
    STRING("string"),
    LONG("long"),
    DOUBLE("double"),
    DATE("date");

    private String name;

    SQLType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
