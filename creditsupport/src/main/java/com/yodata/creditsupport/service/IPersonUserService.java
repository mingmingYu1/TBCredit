package com.yodata.creditsupport.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yodata.core.domain.Page;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.UserRoleEntity;
import com.yodata.creditsupport.orm.person.entity.PerUserEntity;
import com.yodata.creditsupport.orm.vo.User;

/**
 * 用户管理接口
 * @author zhang
 *
 */
public interface IPersonUserService {

    /**
     * 新增用户
     * @param PerUserEntity
     * @return
     */
    public Integer adduser(PerUserEntity PerUserEntity);

    /**
     * 根据ID删除用户
     * @param id
     * @throws BusinessException 
     */
	public void deleteuser(Integer id) throws BusinessException;

	/**
	 * 更新用户
	 * @param user
	 * @throws BusinessException 
	 */
	public void updateuser(PerUserEntity user) throws BusinessException;
	
	/**
	 * 通过id查询用户
	 * @param uid
	 * @return
	 */
	public PerUserEntity findUserEntityById(String uid);
	
	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 */
	public PerUserEntity findUserEntityByName(String username);

	/**
	 * 通过密码和用户名查询用户
	 * @param user
	 * @return
	 */
	public PerUserEntity findUserEntity(PerUserEntity user);
	
	/**
	 * 新增用户管理关系
	 * @param list
	 */
	public void addUserRole(List<UserRoleEntity> list);

	/**
	 * 删除用户和角色的关联
	 * @param id
	 * @return
	 * @throws BusinessException 
	 */
	public int deleteUserRole(Integer uid) throws BusinessException;

	/**
	 * 查询所有用户
	 * @param request
	 * @param page
	 * @return
	 * @throws BusinessException 
	 */
	public Page<User> queryAllUser(HttpServletRequest request,Page<User> page) throws BusinessException;
	
	/**
	 * 通过用户名称获取用户对象
	 * @param username
	 * @return
	 */
	public int findByName(String username);
	
	/**
	 * 重置密码
	 * @param user
	 * @throws BusinessException 
	 */
	public void resetPword(PerUserEntity user) throws BusinessException;

	/**
	 * 通过用户查询角色
	 * @param uid
	 * @return
	 * @throws BusinessException 
	 */
	public List<Integer> queryRoleByUserId(Integer uid) throws BusinessException;

	/**
	 * 登录错误次数+1
	 * @param username
	 */
	public void addErrorcount(String username);
	/**
	 * 更新用户
	 * @param loginUser 
	 */
	public void updateuser2(PerUserEntity loginUser);


	/**
	 * 查询一个部门下的用户数量
	 * @param deptId
	 * @return
	 */
	public int selectUserCountByDeptId(Integer deptId);
	
	/**
	 * 冻结用户
	 * @param username
	 */
	public void blockUserEntity(String username);

	
}