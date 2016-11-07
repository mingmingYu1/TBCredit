package com.yodata.creditsupport.orm.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4519116603662187544L;
	/**
	 * pk
	 */
	private Integer roleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	/**
	 * 角色状态
	 */
	private String status;
	
	/**
	 * 拥有权限
	 */
//	private List<Permission> permissionList;
	
	/**
	 * 权限名称
	 */
	private String enRoleName;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnRoleName() {
        return enRoleName;
    }

    public void setEnRoleName(String enRoleName) {
        this.enRoleName = enRoleName;
    }

}
