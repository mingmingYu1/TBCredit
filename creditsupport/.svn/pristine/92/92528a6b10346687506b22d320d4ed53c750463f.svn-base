package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sp_score_level_version", catalog = "credit_db")
public class ScoreLevelVersionEntity implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -4971659000205179184L;
	
	/** 主键  */
	private Integer id;
	/** 评分等级编号  */
	private String version;
	/**  */
	private Date create_time;
	/** 状态  */
    private Integer status;
    /** 用户名  */
    private String create_user;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Column(name = "[status]", nullable = false)
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

   
	
}