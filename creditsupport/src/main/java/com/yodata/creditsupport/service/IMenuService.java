package com.yodata.creditsupport.service;

import java.util.List;

import com.yodata.creditsupport.orm.entity.MenuEntity;
import com.yodata.creditsupport.orm.entity.RoleMenuEntity;
import com.yodata.creditsupport.orm.vo.Menu;

/**
 * 菜单管理接口
 * @author zhang
 *
 */
public interface IMenuService {

	/**
	 * 添加权限
	 * @param list
	 */
	public void createRolePermission(List<RoleMenuEntity> list);
	
	/**
	 * 展示菜单
	 * @return
	 */
	public List<MenuEntity> queryMenuAll();

	/**
	 * 通过角色展示菜单
	 * @param roleId
	 * @return
	 */
	public List<Menu> getMenuByRoleId(Integer roleId);
	
	/**
	 * 通过用户id获取菜单
	 * @param integer
	 * @return
	 */
	public List<Menu> getMenuByUserId(Integer integer);

	/**
	 * 通过个人用户id获取菜单
	 * @param integer
	 * @return
	 */
	public List<Menu> getMenuByPerUserId(Integer userId);
	
	
}