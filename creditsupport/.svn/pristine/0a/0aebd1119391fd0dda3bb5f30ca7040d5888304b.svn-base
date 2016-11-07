package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name ="sp_role", catalog = "credit_db")
public class RoleEntity implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3151457799092757084L;
	
	private Integer roleId;
    private String roleName;
    private java.sql.Timestamp createTime;
    private String createUser;
    private String enRoleName;
    private int sort;
    private String status;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//这个注解表示这个表在数据库中它是自增的
    @SequenceGenerator(name="gen", sequenceName="seq")
    @Column(name="role_id", nullable = false)
    public Integer getRoleId() {
        return this.roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    
    @Column(name="role_name", nullable = false)
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Column(name="create_time", nullable = true)
    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }

    @Column(name="create_user", nullable = true)
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Column(name="en_role_name", nullable = true)
    public String getEnRoleName() {
        return enRoleName;
    }
    public void setEnRoleName(String enRoleName) {
        this.enRoleName = enRoleName;
    }

    @Column(name="sort", nullable = true)
    public int getSort() {
        return sort;
    }
    public void setSort(int sort) {
        this.sort = sort;
    }

    @Column(name="status", columnDefinition = "char", nullable = true)
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.roleId == null) ? 0 : this.roleId.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RoleEntity other = (RoleEntity) obj;
        if (this.roleId == null) {
            if (other.roleId != null)
                return false;
        } else if (!this.roleId.equals(other.roleId))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "RoleEntity [roleId=" + roleId + ", roleName=" + roleName + ", createTime=" + createTime
                + ", createUser=" + createUser + ", enRoleName=" + enRoleName + ", sort=" + sort + ", status=" + status
                + "]";
    }

}