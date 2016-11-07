package com.yodata.creditsupport.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yodata.core.domain.Page;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.DeptEntity;
import com.yodata.creditsupport.orm.vo.Dept;

/**
 * 部门管理接口
 * @author zhang
 *
 */
public interface IDeptService {

    /**
     * 新增
     * @param DeptEntity
     */
    public void add(DeptEntity DeptEntity);

    /**
     * 更新
     * @param DeptEntity
     * @return
     * @throws BusinessException
     */
    public int update(DeptEntity DeptEntity) throws BusinessException;

    /**
     * 列表显示
     * @return
     */
	public List<DeptEntity> deptshow();

	/**
	 * 查询相同名称的数量
	 * @param rolename
	 * @return
	 */
	public List<DeptEntity> findByName(String deptname);
	
	/**
	 * 根据Id删除部门
	 * @param deptId
	 * @return
	 * @throws BusinessException 
	 */
	public int deleteEntity(Integer deptId) throws BusinessException;

	/**
	 * 部门信息展示
	 * @param request
	 * @param page
	 * @return
	 */
	public Page<Dept> queryAllDept(HttpServletRequest request, Page<Dept> page);

	/**
	 * 根据部门名称,查询部门信息
	 * @param deptEntity
	 * @return
	 */
	public int queryDeptByName(DeptEntity deptEntity);

	/**
	 * 查询是否有子部门
	 * @param deptId
	 * @return
	 */
	public int selectSonByDeptId(Integer deptId);
	
	/**
     * 查询子部门
     * @param parentId
     * @return
     */
    public List<DeptEntity> getSonDeptByParentId(Integer parentId);
	
}