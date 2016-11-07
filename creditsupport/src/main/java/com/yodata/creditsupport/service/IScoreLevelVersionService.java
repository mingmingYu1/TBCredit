package com.yodata.creditsupport.service;

import java.util.List;
import java.util.Map;

import com.yodata.creditsupport.orm.entity.ScoreLevelEntity;
import com.yodata.creditsupport.orm.entity.ScoreLevelVersionEntity;
import com.yodata.creditsupport.util.QueryParam;

public interface IScoreLevelVersionService {

	/**
	 * 分页查询评分等级版本
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getPageScoreLevelVersions(QueryParam queryParam);

	/**
	 * 复制评分等级版本
	 * @param scoreLevelEntity
	 * @param list 
	 * @throws Exception
	 */
	public void copy(ScoreLevelVersionEntity scoreLevelEntity, List<ScoreLevelEntity> list);

	/**
	 * 保存或修改评分等级版本
	 * @param scoreLevelEntity
	 * @throws Exception
	 */
	public void saveOrUpdateEntity(ScoreLevelVersionEntity scoreLevelEntity);

	/**
	 * 根据ID查询评分等级版本
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ScoreLevelVersionEntity getScoreLevelVersionEntityByID(Integer id);

	/**
	 * 根据ID删除评分等级版本
	 * @param id
	 * @throws Exception
	 */
	public void deleteEntity(Integer id);

	/**
	 * 根据状态查询版本
	 * @param i
	 * @return
	 */
	public List<ScoreLevelVersionEntity> getScoreLevelVersionEntityByStatus(int i);

	/**
	 * 查询最新得分等级版本
	 * @return
	 */
	public ScoreLevelVersionEntity getlastVersion();

	/**
	 * 计算得分总和
	 * @param id
	 * @return
	 */
	public int getScoreSumByID(Integer id);
	/**
     * 生成征信报告时判断是否有可用评分版本
     * @return
     */
	public boolean hasAvailableVersion();

}
