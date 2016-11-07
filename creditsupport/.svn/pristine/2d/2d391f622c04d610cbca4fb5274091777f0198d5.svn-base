package com.yodata.core.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTablePool;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/** HBase的一些辅助的方法
 * Created by zheng.liu@baifendian on 2015-08-18.
 */
public class HBaseUtils {
    private static Log log= LogFactory.getLog(HBaseUtils.class);
    private static Map<String,Configuration> map=new Hashtable<>();
    private static int poolSize;
    private static Map<Configuration,HTablePool> poolMap = new HashMap<>();

    /**
     * 根据Hadoop的配置文件创建配置
     * @param file
     * @return
     */
    public static Configuration getConfig(File file){
        String filePath=file.getAbsolutePath();
        if (map.containsKey(filePath)){
            return map.get(filePath);
        }else {
            Configuration conf= HBaseConfiguration.create();
            try {
                conf.addResource(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                log.error(e);
            }
            map.put(filePath,conf);
        }
        return map.get(filePath);
    }

    /**
     * 根据Hadoop的配置属性，创建配置
     * @param params
     * @return
     */
    public static Configuration getConfig(Map<String,String> params){
        String key=params.toString();
        if (map.containsKey(key)){
            return map.get(key);
        }else {
            Configuration conf= HBaseConfiguration.create();
            for (Map.Entry<String,String> entry:params.entrySet()){
                conf.set(entry.getKey(),entry.getValue());
            }
            map.put(key,conf);
        }
        return map.get(key);
    }

    /**
     * 获得HTablePool的缓存数量
     * @return
     */
    public static int getPoolSize() {
        if (poolSize==0){
            return 5;
        }
        return poolSize;
    }

    /**
     * 设置HTablePool的缓存数量
     * @param poolSize
     */
    public static void setPoolSize(int poolSize) {
        HBaseUtils.poolSize = poolSize;
    }

    /**
     * 如果用此方法只生成过一个Hadoop可直接用些文件获得HTable连接
     * @param tableName
     * @return
     */
    public static HTable getTable(String tableName){
        if (map.size()>1){
            return null;
        }else if (poolMap.isEmpty()){
            synchronized (poolMap){
                poolMap.put(map.values().iterator().next(),new HTablePool(map.values().iterator().next(),getPoolSize()));
//                hTablePool=new HTablePool(map.values().iterator().next(),getPoolSize());
            }
            return (HTable) poolMap.entrySet().iterator().next().getValue().getTable(tableName);
        }else {
            return (HTable) poolMap.entrySet().iterator().next().getValue().getTable(tableName);
        }
    }

    /**
     * 根据指定的配置获得HTable的连接
     * @param tableName
     * @param config
     * @return
     */
    public static HTable getTable(String tableName,Configuration config){
        if (poolMap.containsKey(config)){
            return (HTable) poolMap.get(config).getTable(tableName);
        }else {
            synchronized (poolMap){
                poolMap.put(config,new HTablePool(config,getPoolSize()));
                return (HTable) poolMap.get(config).getTable(tableName);
            }
        }
    }

    /**
     * 将配置和表连接池清空
     */
    public static void clear(){
        map=null;
        poolMap=null;
    }
}
