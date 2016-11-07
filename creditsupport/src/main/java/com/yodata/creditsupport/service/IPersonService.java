package com.yodata.creditsupport.service;

import java.util.Map;

import com.yodata.creditsupport.orm.entity.AgentInfoEntity;
import com.yodata.creditsupport.orm.entity.PersonAddInfo;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInfoEntity;
import com.yodata.creditsupport.util.QueryParam;

public interface IPersonService {

	/**
	 * 新增个人信息
	 * @param personInfos
	 * @return
	 */
	public int addPerson(PersonAddInfo personInfos);

	/**
	 * 个人信息查询
	 * @param queryParam
	 * @return
	 */
	public Map<String, Object> getPagePerson(QueryParam queryParam) throws Exception;
	
	
	/**
	 * 删除个人信息
	 */
	public boolean delete(String cardId);
	
	
	
	public OdsPersonInfoEntity getByCardId(String cardId);


	
	


	

	
}
