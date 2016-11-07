package com.yodata.creditsupport.orm.person.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ods_person_report_templet", catalog="credit_db")
public class PersonReportTempletEntity implements Serializable{

	private static final long serialVersionUID = -8415606116354580461L;
	private Integer id;             //主键
	private String number;			//模板编号
	private String name;			//模板名称
	private String declare;			//重要声明
	private String moduleList;		//模板模块列表
	private Integer type;			//报告用途 授信/贷款/交易-->1/2/3
	private Integer status;			//是否可用 0/1/2 -- 已弃用/可用/已使用
	private Date createTime;		//生成时间
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="number")
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Column(name = "[name]", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "[declare]", nullable = false)
	public String getDeclare() {
		return declare;
	}
	public void setDeclare(String declare) {
		this.declare = declare;
	}
	@Column(name="module_list")
	public String getModuleList() {
		return moduleList;
	}
	public void setModuleList(String moduleList) {
		this.moduleList = moduleList;
	}
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "[status]", nullable = false)
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name = "[type]", nullable = false)
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
