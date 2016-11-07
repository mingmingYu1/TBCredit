package com.yodata.creditsupport.service;

import java.util.Map;

import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.person.entity.PersonReportTempletEntity;
import com.yodata.creditsupport.util.QueryParam;

public interface IPersonReportTempletService {

	void add(PersonReportTempletEntity entity);

	void delete(Integer id) throws DataAccessException;

	void update(PersonReportTempletEntity entity);

	Map<String, Object> getPageTemplet(QueryParam queryParam) throws Exception;

	void saveOrUpdateEntity(PersonReportTempletEntity reportTempletEntity)throws Exception;
	/**
	 * 根据ID查询评分等级
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PersonReportTempletEntity getReportTempletEntityByID(Integer id) throws Exception;
	
}
