package com.yodata.creditsupport.service;

import java.util.List;

import com.yodata.core.domain.Page;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.RoleEntity;
import com.yodata.creditsupport.orm.vo.Role;

public interface IRoleService {

    public Integer addrole(RoleEntity RoleEntity);

    public void deleterole(Integer id);

    public void updaterole(RoleEntity RoleEntity) throws BusinessException;

	public List<RoleEntity> roleshow();

	public int queryUserCountByRoleId(Integer roleId);

	/**
	 * 删除用户菜单关联
	 * @param id
	 * @return
	 * @throws BusinessException 
	 */
	public int deleteRoleMenu(Integer id);

	/**
	 * 根据角色名称查询角色
	 * @param roelname
	 * @return
	 */
	public List<RoleEntity> queryRoleListByRoleName(String roelname);

	/**
	 * 查询是否有另外相同名字的角色
	 * @param roelname
	 * @param id
	 * @return
	 */
	public int queryRoleCountByRoleName(String roelname, Integer id);

	/**
	 * 角色展示
	 * @param rolename
	 * @param page
	 * @return
	 */
	public Page<Role> showRoleByName(String rolename, Page<Role> page);

	public void deleteRoleAndMenu(Integer roleId);

}