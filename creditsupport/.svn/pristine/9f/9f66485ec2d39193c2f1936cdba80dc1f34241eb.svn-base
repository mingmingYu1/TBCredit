package com.yodata.creditsupport.service;

import java.util.Date;
import java.util.List;

import com.yodata.creditsupport.orm.entity.DimModelEntity;


public interface IDimModelService {

    /**
     * 查询指定日期的指标模型
     * 注意：同一天相同指标没有重复，即算法更新会覆盖原数据
     * @param date
     * @return
     */
    public List<DimModelEntity> getByDate(Date date);

	/**
	 * 获取最新的维度值
	 * @param modelCode
	 * @return
	 */
	public List<DimModelEntity> getByModelCodeLatest(String modelCode);

	
}