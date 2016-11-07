package com.yodata.creditsupport.service;

import java.util.List;
import java.util.Map;

import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.ScoreLevelEntity;
import com.yodata.creditsupport.util.QueryParam;

/**
 * 评分等级管理接口
 * @author Anna
 *
 */
public interface IScoreLevelService {

	/**
	 * 分页查询评分等级
	 * @param queryParam
	 * @return
	 */
	public Map<String, Object> getPageScoreLevels(QueryParam queryParam);

	/**
	 * 检查得分区间查询评分等级
	 * @param levelScore
	 * @param id 
	 * @return
	 */
	public boolean getScoreLevelEntityByScore(String levelScore, Integer id);

	/**
	 * 根据等级查询评分等级
	 * @param integer2 
	 * @param trim
	 * @return
	 */
	public boolean getScoreLevelEntityByName(String levelName, Integer id, Integer levelVersion);

	/**
	 * 保存或修改评分等级
	 * @param scoreLevelEntity
	 * @throws BusinessException 
	 */
	public void saveOrUpdateEntity(ScoreLevelEntity scoreLevelEntity) throws BusinessException;

	/**
	 * 根据ID查询评分等级
	 * @param id
	 * @return
	 */
	public ScoreLevelEntity getScoreLevelEntityByID(Integer id);

	/**
	 * 根据ID删除评分等级
	 * @param id
	 * @throws BusinessException 
	 */
	public void deleteEntity(Integer id) throws BusinessException;

	/**
	 * 查询评分区间是否有重复
	 * @param levelScoreMin
	 * @param levelScoreMax
	 * @param id
	 * @return
	 * @throws BusinessException 
	 */
    public boolean getScoreLevelEntityByScore(Integer levelScoreMin, Integer levelScoreMax, Integer id,Integer levelVersion) throws BusinessException;

    /**
     * 根据得分查询等级和信用评定信息
     * @param levelScoreMin
     * @param levelScoreMax
     * @param id
     * @return
     * @throws BusinessException 
     */
    public ScoreLevelEntity getScoreLevelEntityByScore(Double score) throws BusinessException;
    
    /**
     * 根据版本查询评分等级列表
     * @param i
     * @return
     */
    public List<ScoreLevelEntity> getScoreLevelEntityByVersionID(Integer i);

	public Map<String, Object> getEnableScore();

	public Map<String, Object> queryScoeLevel();

	public Map<String, Object> getAgentSampleInfo(String regId);

}
