package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "sp_cas_user", catalog = "credit_db")
public class UserEntity implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 3869904473250796441L;

	private java.lang.Integer userId;
	private java.lang.String userName;
	private java.lang.String password;
	private java.lang.String realName;
	private java.lang.Integer deptId;
	private java.sql.Timestamp createTime;
	private java.lang.String status;
	private Timestamp lastLoadTime;
	private String createUser;
	private int sort;
	private String enName;
	private String ip;
	private int errCount;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "gen", sequenceName = "seq")
    @Column(name = "u_id", nullable = false)
    public java.lang.Integer getUserId() {
        return userId;
    }
    public void setUserId(java.lang.Integer userId) {
        this.userId = userId;
    }

    @Column(name = "u_name", nullable = false)
    public java.lang.String getUserName() {
        return userName;
    }
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }

    @Column(name = "u_password", nullable = false)
    public java.lang.String getPassword() {
        return password;
    }
    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    @Column(name = "real_name", nullable = true)
    public java.lang.String getRealName() {
        return realName;
    }
    public void setRealName(java.lang.String realName) {
        this.realName = realName;
    }

    @Column(name = "dept_id", nullable = true)
    public java.lang.Integer getDeptId() {
        return deptId;
    }
    public void setDeptId(java.lang.Integer deptId) {
        this.deptId = deptId;
    }

    @Column(name = "create_time", nullable = true)
    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }

    @Column(name = "status", columnDefinition = "char", nullable = true)
    public java.lang.String getStatus() {
        return status;
    }
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    @Column(name = "last_load_time", nullable = true)
    public Timestamp getLastLoadTime() {
        return lastLoadTime;
    }
    public void setLastLoadTime(Timestamp lastLoadTime) {
        this.lastLoadTime = lastLoadTime;
    }

    @Column(name = "create_user", nullable = true)
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Column(name = "sort", nullable = true)
    public int getSort() {
        return sort;
    }
    public void setSort(int sort) {
        this.sort = sort;
    }

    @Column(name = "en_name", nullable = true)
    public String getEnName() {
        return enName;
    }
    public void setEnName(String enName) {
        this.enName = enName;
    }

    @Column(name = "ip_addr", nullable = true)
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "err_count", nullable = true)
    public int getErrCount() {
        return errCount;
    }
    public void setErrCount(int errCount) {
        this.errCount = errCount;
    }



}