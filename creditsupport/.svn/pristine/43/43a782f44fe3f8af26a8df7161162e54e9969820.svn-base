package com.yodata.core.mybatis;

import com.yodata.core.domain.Page;

import java.io.Serializable;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

/**
 * Created by jiangnan on 15-8-18.
 */
public class MybatisTemplate <T extends MyBatisPojo,PK extends Serializable> {

    public String insert(T obj) {
        BEGIN();

        INSERT_INTO(obj.tablename());
        obj.assembleColumnList();
        VALUES(obj.returnInsertColumnsName(), obj.returnInsertColumnsDefine());

        return SQL();
    }

    public String update(T obj) {
        String primaryKey = obj.id();

        BEGIN();

        UPDATE(obj.tablename());
        obj.assembleColumnList();
        SET(obj.returnUpdateSet());
        WHERE(primaryKey + "=#{" + primaryKey + "}");

        return SQL();
    }

    public String deleteByPrimaryKey(T obj) {
        String primaryKey = obj.id();

        BEGIN();

        DELETE_FROM(obj.tablename());
        WHERE(primaryKey + "=#{" + primaryKey + "}");

        return SQL();
    }

    public String select(T obj){
        BEGIN();

        obj.assembleColumnList();
        SELECT(obj.returnSelectColumnsName());

        FROM(obj.tablename());
        WHERE(obj.returnSelectWhereColumnsName());

        return SQL();
    }

    public String selectList(T obj){

        BEGIN();

        obj.assembleColumnList();
        SELECT(obj.returnSelectColumnsName());

        FROM(obj.tablename());
        WHERE(obj.returnSelectWhereColumnsName());

        return SQL();
    }

    /**
     * 如果有多个参数必须使用map 接收
     * 参数等于返回
     * @param para
     * @return
     */
    public String selectPage(Map<String, Object> para){
        T obj = (T) para.get("entity");
        Page page = (Page) para.get("page");
        BEGIN();
        obj.assembleColumnList();
        SELECT(obj.returnSelectColumnsName());
        FROM(obj.tablename());
        WHERE(obj.returnPageSelectWhereColumnsName("entity"));
        StringBuilder sql = new StringBuilder(SQL());
        sql.append(" limit ");
        sql.append((page.getCurrent() - 1) * page.getCountPerPage());
        sql.append(",");
        sql.append(page.getCountPerPage());
        return sql.toString();
    }

    /**
     * 查询等于的count
     * @param para
     * @return
     */
    public String selectCount(Map<String, Object> para){
        T obj = (T) para.get("entity");
        BEGIN();
        obj.assembleColumnList();
        SELECT(" COUNT(*) ");
        FROM(obj.tablename());
        WHERE(obj.returnPageSelectWhereColumnsName("entity"));

        return SQL();
    }
}
