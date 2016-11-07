package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 分之机构信息
 */
@Entity
@Table(name ="ods_agent_filiation_info", catalog="credit_db")
public class AgentFiliationEntity implements Serializable {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 6851839307867539396L;
	
	private Integer id;				// 自增主键
	private String regId;	// 企业注册号
	
	private String brName; // 分支机构名称
	private String cbuItem; // 一般经营项目
	private String brRegNo; // 分支机构企业注册号
	private String localAdministration; //公司注册所所在工商管理局
	private String brAddr; // 分支机构地址
	private String brPrincipal; //分支机构负责人
	
	@Column(name="BR_NAME")
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}

	@Column(name="CBU_ITEM")
	public String getCbuItem() {
		return cbuItem;
	}
	public void setCbuItem(String cbuItem) {
		this.cbuItem = cbuItem;
	}
	
	@Column(name="BR_REG_No")
	public String getBrRegNo() {
		return brRegNo;
	}
	public void setBrRegNo(String brRegNo) {
		this.brRegNo = brRegNo;
	}
	
	@Column(name="LOCAL_ADMINISTRATION")
	public String getLocalAdministration() {
		return localAdministration;
	}
	public void setLocalAdministration(String localAdministration) {
		this.localAdministration = localAdministration;
	}
	
	@Column(name="BR_ADDR")
	public String getBrAddr() {
		return brAddr;
	}
	public void setBrAddr(String brAddr) {
		this.brAddr = brAddr;
	}

	@Column(name="BR_PRINCIPAL")
	public String getBrPrincipal() {
		return brPrincipal;
	}
	public void setBrPrincipal(String brPrincipal) {
		this.brPrincipal = brPrincipal;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="reg_id")
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AgentFiliationEntity other = (AgentFiliationEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AgentChangeEntity [id=" + id + ", regId=" + regId + ", branch_name=" + brName + "]";
	}
}
