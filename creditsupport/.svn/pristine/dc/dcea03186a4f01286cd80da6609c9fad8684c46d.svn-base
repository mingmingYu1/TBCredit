package com.yodata.creditsupport.service;

import java.util.List;
import java.util.Map;

import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.IndicatorEntity;
import com.yodata.creditsupport.util.QueryParam;

public interface IndicatorService {

	/**
	 * 分页查询指标
	 * @param queryParam
	 * @return
	 */
	public Map<String, Object> getPageIndicators(QueryParam queryParam);

	/**
	 * 根据指标名称查询指标是否已存在
	 * @param indiName 
	 * @return
	 */
	public IndicatorEntity getIndicatorEntityByName(String indiName);

	/**
	 * 保存或修改指标
	 * @param indicatorEntity
	 */
	public void saveOrUpdateEntity(IndicatorEntity indicatorEntity);

	/**
	 * 根据ID查询指标
	 * @param id
	 * @return
	 * @throws BusinessException 
	 */
	public IndicatorEntity getIndicatorEntityByID(Integer id) throws BusinessException;

	/**
	 * 根据ID删除指标
	 * @param id
	 */
	public void deleteEntity(Integer id);

	/**
	 * 根据编号查询指标
	 * @param indiCode
	 * @return
	 */
	public IndicatorEntity getIndicatorEntityByCode(String indiCode);

	/**
	 * 查询指标大类
	 * @return
	 */
    public List<String> queryLevelIndicatorList();

    /**
     * 根据级别查询所有当前级别的指标
     * @param level
     * @return
     */
    public List<IndicatorEntity> queryLevelIndicatorListByLevel(String level);

    /**
     * 根据指标名称查询下级指标
     * @param indName
     * @return
     */
    public List<IndicatorEntity> queryChildren(String indName);

    /**
     * 根据算法类型，查询指标权重
     * @param algorithmType
     * @return
     */
    public List<IndicatorEntity> getAllEntityList(String algorithmType);

}
