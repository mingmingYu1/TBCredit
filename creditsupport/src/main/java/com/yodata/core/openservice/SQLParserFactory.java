package com.yodata.core.openservice;

import com.yodata.core.holder.SpringContextHolder;

/**
 * Created by zheng.liu@baifendian on 2015-09-10.
 */
public class SQLParserFactory {

    public  static SQLParser createSQLParser(SQLParserType type){

        switch (type){
            case CHART:{
                return (SQLParser) new SpringContextHolder().getContext().getBean("lineSQLParser");
            }
            case PIE:{
                return (SQLParser) new SpringContextHolder().getContext().getBean("pieSQLParser");
            }
            default:{
                throw new NullPointerException("所选择类型不存在");
            }
        }
    }
}
