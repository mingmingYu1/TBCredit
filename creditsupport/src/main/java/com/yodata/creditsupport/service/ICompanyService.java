package com.yodata.creditsupport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.yodata.creditsupport.orm.entity.CrawlerAgentGroupEntity;
import com.yodata.core.domain.Page;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.AgentInfoEntity;
import com.yodata.creditsupport.orm.entity.CrawlerAgentInfoEntity;
import com.yodata.creditsupport.orm.vo.AgentGroup;
import com.yodata.creditsupport.util.QueryParam;

public interface ICompanyService {

	/**
	 * 查询企业列表
	 */
	public Map<String, Object> getPageCompanys(QueryParam queryParam) throws Exception;
	
	/**
	 * 查询企业详情
	 */
	public AgentInfoEntity getByRegId(String regId) throws BusinessException;

	/**
	 * 新增企业
	 */
	public String create(AgentInfoEntity agentInfo);

	/**
	 * 删除企业
	 * @throws BusinessException 
	 */
	public boolean delete(String regId) throws BusinessException;

	/**
	 * 修改企业
	 */
	public boolean update(AgentInfoEntity agentInfo);

	/**
	 * 新增或更新企业信息
	 * @throws BusinessException 
	 */
	public int addAgent(CrawlerAgentInfoEntity agentInfo) throws BusinessException;
	
	/**
	 * 验证分组名称
	 * @throws SQLException 
	 */
	public boolean isGroup(String compname) throws SQLException;

	/**
	 * 查询分组
	 * @param request
	 * @param tempage
	 * @return
	 */
	public Page<AgentGroup> findGroup(HttpServletRequest request, Page<AgentGroup> tempage);

	/**
	 * 根据分组id查询企业名称
	 * @param groupId
	 * @return
	 */
	public ArrayList<CrawlerAgentInfoEntity> findAgentBygroupId(Integer parameter);

	/**
	 * 批量保存企业名称和信用代码
	 * @param list
	 * @return
	 */
	public  boolean EditAgent(CrawlerAgentGroupEntity agentgroup);

	/**
	 * 批量修改企业名称和信用代码
	 * @param agentInfos
	 * @return
	 */
	public boolean updateAgent(CrawlerAgentGroupEntity agentgroup);

	/**
	 * 删除企业名称和信用代码
	 * @param agentgroup
	 * @return
	 */
	public boolean deleteAgent(CrawlerAgentGroupEntity agentgroup);
	
    /**
     * 提交分组id
     * @param groupId
     * @return
     */
	public boolean submitGroupId(Integer groupId);

	/**
	 * 删除分组
	 * @param agentgroup
	 * @return
	 */
	public boolean deleteGroup(CrawlerAgentGroupEntity agentgroup);

	/**
	 * 判断代理商是否有标签信息
	 * @param compName
	 * @return
	 */
	public boolean agentIsExistence(String compName);

	/**
	 * 根据企业名字获取企业
	 * @param compName
	 * @return
	 */
	public List<AgentInfoEntity> getAgentInfoByName(String compName) throws BusinessException;
}
