package com.yodata.creditsupport.service;

import java.util.List;
import java.util.Map;

import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.ScoreModelEntity;
import com.yodata.creditsupport.util.QueryParam;

public interface IScoreModelService {

	/**
	 * 分页查询评分模型
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getPageScoreModels(QueryParam queryParam) throws Exception;

	/**
	 * 根据模型名称查询评分模型是否已存在
	 * @param trim
	 * @return
	 * @throws Exception
	 */
	public boolean getScoreModelEntityByName(String modelName, Integer integer) throws Exception;

	/**
	 * 保存或修改评分模型
	 * @param scoreModelEntity
	 * @throws Exception
	 */
	public void saveOrUpdateEntity(ScoreModelEntity scoreModelEntity) throws Exception;

	/**
	 * 根据ID查询评分模型
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ScoreModelEntity getScoreModelEntityByID(Integer id) throws Exception;

	/**
	 * 根据ID删除评分模型
	 * @param id
	 * @throws Exception
	 */
	public void deleteEntity(Integer id) throws Exception;

	/**
	 * 查询所有模型
	 * @return
	 */
    public List<ScoreModelEntity> getScoreModels();

    /**
     * 根据编码查询评分模型
     * @param trim
     * @return
     */
    public ScoreModelEntity getScoreModelEntityByCode(String modelCode);

	/**
	 * 算法重新计算权重
	 * @param modelCode算法类型
	 * @return
	 * @throws BusinessException 
	 */
	public boolean runAlgorithm(String modelCode) throws BusinessException;

	/**
	 * 按算法类型查询状态
	 * return -1
	 */
	public int getStatusByModelCode(String modelCode);
    
    /**
     * 根据企业ID查询企业计算得分权重时所使用的算法
     * @param regId
     * @return
     */
    public ScoreModelEntity getScoreModelEntityByRegId(String regId);

    /**
     * 获取所有评分模型算法的 code和name
     * @return
     */
    public Map<String, String> getScoreModelMap();

    /**
     * 根据算法编码，计算指定算法的所有企业的得分
     * @param modelCode
     * @return
     * @throws BusinessException 
     */
    public boolean getScoring(String modelCode) throws BusinessException;
}
