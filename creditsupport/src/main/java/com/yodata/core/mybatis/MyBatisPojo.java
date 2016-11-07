package com.yodata.core.mybatis;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiangnan on 15-8-18.
 */
public class MyBatisPojo implements Serializable {
    /**
     * 获取POJO对应的表名
     * 需要POJO中的属性定义@Table(name)
     * @return
     */
    public String tablename() {
        Table table = this.getClass().getAnnotation(Table.class);
        if(table != null)
            return table.name();
        else
            throw new RuntimeException("undefine POJO @Table, need Tablename(@Table(name))");
    }

    /**
     * 获取POJO中的主键字段名
     * 需要定义@Id
     * @return
     */
    public String id() {
        for(Field field : this.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Id.class))
                return camelToUnderline(field.getName());
        }

        throw new RuntimeException("undefine POJO @Id");
    }

    /**
     * 用于存放POJO的列信息
     */
    private transient static Map<Class<? extends MyBatisPojo>,List<String>> columnMap = new HashMap<Class<? extends MyBatisPojo>, List<String>>();

    private boolean isNull(String fieldname) {
        try {
            Field field = this.getClass().getDeclaredField(fieldname);
            return isNull(field);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean isNull(Field field) {
        try {
            field.setAccessible(true);
            return field.get(this) == null;
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 用于计算类定义
     * 需要POJO中的属性定义@Column(name)
     */
    public void assembleColumnList() {
        if(columnMap.containsKey(this.getClass()))
            return;

        Field[] fields = this.getClass().getDeclaredFields();
        List<String> columnList = new ArrayList<String>(fields.length);

        for(Field field : fields) {
            if(field.isAnnotationPresent(Column.class))
                columnList.add(field.getName());
        }

        columnMap.put(this.getClass(), columnList);
    }

    /**
     * 获取用于WHERE的 有值字段表
     * @return
     */
    public List<WhereColumn> returnWhereColumnsName() {
        Field[] fields = this.getClass().getDeclaredFields();
        List<WhereColumn> columnList = new ArrayList<WhereColumn>(fields.length);

        for(Field field : fields) {
            if(field.isAnnotationPresent(Column.class) && !isNull(field))
                columnList.add(new WhereColumn(field.getName(), field.getGenericType().equals(String.class)));
        }

        return columnList;
    }

    /**
     * Where条件信息
     * @author HUYAO
     *
     */
    public class WhereColumn {
        public String name;
        public boolean isString;

        public WhereColumn(String name,boolean isString) {
            this.name = name;
            this.isString = isString;
        }
    }

    /**
     * 用于获取Insert的字段累加
     * @return
     */
    public String returnInsertColumnsName() {
        StringBuilder sb = new StringBuilder();

        List<String> list = columnMap.get(this.getClass());
        int i = 0;
        for(String column : list) {
            if(isNull(column))
                continue;

            if(i++ != 0)
                sb.append(',');
            sb.append(camelToUnderline(column));
        }
        return sb.toString();
    }

    /**
     * 用于获取Insert的字段映射累加
     * @return
     */
    public String returnInsertColumnsDefine() {
        StringBuilder sb = new StringBuilder();

        List<String> list = columnMap.get(this.getClass());
        int i = 0;
        for(String column : list) {
            if(isNull(column))
                continue;

            if(i++ != 0)
                sb.append(',');
            sb.append("#{").append(column).append('}');
        }
        return sb.toString();
    }

    /**
     * 用于获取Update Set的字段累加
     * @return
     */
    public String returnUpdateSet() {
        StringBuilder sb = new StringBuilder();

        List<String> list = columnMap.get(this.getClass());
        int i = 0;
        for(String column : list) {
            if(isNull(column))
                continue;

            if(i++ != 0)
                sb.append(',');
            sb.append(camelToUnderline(column)).append("=#{").append(column).append('}');
        }
        return sb.toString();
    }
    /**
     * 用于获取select 所有字段 累加
     * @return
     */
    public String returnSelectColumnsName() {
        StringBuilder sb = new StringBuilder();

        List<String> list = columnMap.get(this.getClass());
        int i = 0;
        for(String column : list) {
            if(i++ != 0)
                sb.append(',');
            sb.append(camelToUnderline(column));
            sb.append(" as ");
            sb.append(column);
        }
        if(!"".equals(sb.toString())){
            sb.append(",");
        }
        sb.append(id());
        return sb.toString();
    }
    /**
     * 用于获取select 所有字段 where 累加
     * @return
     */
    public String returnSelectWhereColumnsName(){
        StringBuilder sb = new StringBuilder();

        List<String> list = columnMap.get(this.getClass());
        int i = 0;
//        if(!isNull(underlineToCamel(id()))){
//            list.add(id());
//        }
        for(String column : list) {
            if(isNull(column))
                continue;
            if(i++ != 0)
                sb.append(" and ");
            sb.append(camelToUnderline(column));
            sb.append("=#{");
            sb.append(column);
            sb.append("}");
        }

        if(!isNull(underlineToCamel(id()))){
            if(!"".equals(sb.toString())){
                sb.append(" and ");
            }
            sb.append(underlineToCamel(id()));
            sb.append("=#{");
            sb.append(id());
            sb.append("}");
        }

        return sb.toString();
    }

    /**
     * 用于获取select 分页查询  所有字段 where 累加
     * @param entity
     * @return
     */
    public String returnPageSelectWhereColumnsName(String entity){
        StringBuilder sb = new StringBuilder();

        List<String> list = columnMap.get(this.getClass());
        int i = 0;
//        if(!isNull(underlineToCamel(id()))){
//            list.add(id());
//        }
        for(String column : list) {
            if(isNull(column))
                continue;
            if(i++ != 0)
                sb.append(" and ");
            sb.append(camelToUnderline(column));
            sb.append("=#{");
            sb.append(entity);
            sb.append(".");
            sb.append(column);
            sb.append("}");
        }

        if(!isNull(underlineToCamel(id()))){
            if(!"".equals(sb.toString())){
                sb.append(" and ");
            }
            sb.append(underlineToCamel(id()));
            sb.append("=#{");
            sb.append(entity);
            sb.append(".");
            sb.append(id());
            sb.append("}");
        }

        return sb.toString();
    }
    public Integer getId(){return 0;}

//    /**
//     * 转化POJO为JSON格式
//     * 需要org.json包支持,可以在json官网下载源码,或自己实现json编码
//     * @return
//     */
//    public String toJSONString() {
//        JSONObject json = new JSONObject(this);
//        return json.toString();
//    }

    /**
     * 打印类字段信息
     */
    @Override
    public String toString() {
        Field[] fields = this.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(Field f : fields) {
            if(Modifier.isStatic(f.getModifiers()) || Modifier.isFinal(f.getModifiers()))
                continue;
            Object value = null;
            try {
                f.setAccessible(true);
                value = f.get(this);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(value != null)
                sb.append(f.getName()).append('=').append(value).append(',');
        }
        sb.append(']');

        return sb.toString();
    }
    public static final char UNDERLINE='_';

    /**
     * 驼峰转 下划线
     * @param param
     * @return
     */
    public static String camelToUnderline(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (Character.isUpperCase(c)){
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线转驼峰
     * @param param
     * @return
     */
    public static String underlineToCamel(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (c==UNDERLINE){
                if (++i<len){
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
