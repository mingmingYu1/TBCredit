package com.yodata.creditsupport.service;

import java.util.List;
import java.util.Map;

import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.ReportTempletEntity;
import com.yodata.creditsupport.orm.vo.ReportTitleVo;
import com.yodata.creditsupport.util.QueryParam;

public interface IReportTempletService {

	void add(ReportTempletEntity entity);

	void delete(Integer id);

	void update(ReportTempletEntity entity);
	/**
	 * 分页查询报告模板信息
	 * @param queryParam
	 * @return
	 * @throws BusinessException
	 */
	Map<String, Object> getPageTemplet(QueryParam queryParam) throws BusinessException;
	/**
	 * 新增或修改一条报告模板
	 * @param reportTempletEntity
	 * @throws BusinessException
	 */
	void saveOrUpdateEntity(ReportTempletEntity reportTempletEntity)throws BusinessException;
	/**
	 * 根据ID查询评分等级
	 * @param id
	 * @return
	 */
	public ReportTempletEntity getReportTempletEntityByID(Integer id);
	/**
	 * 获取报告标题的层级结构
	 * @return
	 * @throws BusinessException
	 */
	public List<ReportTitleVo> getAllTempletTitle() throws BusinessException;
}
