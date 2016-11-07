package com.yodata.core.openservice;

/** 现在所有支持的类型的名称和类名
 * Created by zheng.liu@baifendian on 2015-09-10.
 */
public enum  SQLParserType {
    CHART("折线图","com.yodata.core.openservice.LineSQLParser"),
    PIE("饼图","com.yodata.core.openservice.PieSQLParser");
//    PIE("饼图");
    private String name;
    private String className;

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    SQLParserType(String name,String className) {
        this.name = name;
        this.className=className;
    }
}
