package com.yodata.creditsupport.service;

import java.util.List;

import com.yodata.creditsupport.orm.entity.DictEntity;

/**
 * 字典表查询接口
 * @author Anna
 *
 */
public interface IDictService {

    /**
     * 根据服类目查询
     * @param category
     * @return
     */
    public List<DictEntity> getDictsByCategory(String category);

    /**
     * 根据id查询详细信息
     * @param id 
     * @return 
     */
	public DictEntity getCateEntityById(Integer id);
	
}