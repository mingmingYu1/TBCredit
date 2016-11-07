package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
@Entity
@Table(name ="sp_dept", catalog = "credit_db")
public class DeptEntity implements Serializable{
	
    /**
	 * 序列化
	 */
	private static final long serialVersionUID = 1441840385089626664L;
	
	private java.lang.Integer deptId;
    private java.lang.String deptName;
    private java.sql.Timestamp createTime;
    private java.lang.Integer parentId;
    private String enDeptName;
    private int sort;
    private String status;
    private String createUser;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dept_id" , nullable = false)
	public java.lang.Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(java.lang.Integer deptId) {
		this.deptId = deptId;
	}
	
    @Column(name="dept_name", nullable = false)
	public java.lang.String getDeptName() {
		return deptName;
	}
	public void setDeptName(java.lang.String deptName) {
		this.deptName = deptName;
	}
	
	@Column(name="create_time" , nullable = true)
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}
	

    
    @Column(name="parent_id" , nullable = true)
	public java.lang.Integer getParentId() {
		return parentId;
	}
	public void setParentId(java.lang.Integer parentId) {
		this.parentId = parentId;
	}

    @Column(name="en_dept_name" , nullable = true)
	public String getEnDeptName() {
		return enDeptName;
	}
	public void setEnDeptName(String enDeptName) {
		this.enDeptName = enDeptName;
	}
	
    @Column(name="sort" , nullable = true)
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
    @Column(name="status", columnDefinition = "char")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    @Column(name="create_user" , nullable = true)
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((deptId == null) ? 0 : deptId.hashCode());
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
        DeptEntity other = (DeptEntity) obj;
        if (deptId == null) {
            if (other.deptId != null)
                return false;
        } else if (!deptId.equals(other.deptId))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "DeptEntity [deptId=" + deptId + ", deptName=" + deptName + ", createTime=" + createTime + ", parentId="
                + parentId + ", enDeptName=" + enDeptName + ", sort=" + sort + ", status=" + status + ", createUser="
                + createUser + "]";
    }
    
}