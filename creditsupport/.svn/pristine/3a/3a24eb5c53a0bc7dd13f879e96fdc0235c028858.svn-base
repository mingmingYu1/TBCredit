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
 * 股权冻结历史信息
 */
@Entity
@Table(name ="ods_agent_sharesfros", catalog="credit_db")
public class AgentSharesFroEntity implements Serializable {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 6851839307867539396L;
	
	private Integer id;				// 自增主键
	private String regId;	// 企业注册号
	
	private String froDocNo; // 冻结文号 
	private String thawAuth; // 解冻机关
	private String froAuth; // 冻结机关
	private String thawDocNo; // 解冻文号
	private Date froFrom; // 冻结起始日期
	private Date thawDate; // 解冻日期 
	private Date froTo;	// 冻结截至日期
	private String thawCommodsEnt; // 解冻说明
	private Double froAM; //冻结金额

	
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
	
	@Column(name="FRO_DOC_NO")
	public String getFroDocNo() {
		return froDocNo;
	}
	public void setFroDocNo(String froDocNo) {
		this.froDocNo = froDocNo;
	}
	@Column(name="THAW_AUTH")
	public String getThawAuth() {
		return thawAuth;
	}
	public void setThawAuth(String thawAuth) {
		this.thawAuth = thawAuth;
	}
	@Column(name="FRO_AUTH")
	public String getFroAuth() {
		return froAuth;
	}
	public void setFroAuth(String froAuth) {
		this.froAuth = froAuth;
	}
	@Column(name="THAW_DOC_NO")
	public String getThawDocNo() {
		return thawDocNo;
	}
	public void setThawDocNo(String thawDocNo) {
		this.thawDocNo = thawDocNo;
	}
	@Column(name="FRO_FROM")
	public Date getFroFrom() {
		return froFrom;
	}
	public void setFroFrom(Date froFrom) {
		this.froFrom = froFrom;
	}
	@Column(name="THAW_DATE")
	public Date getThawDate() {
		return thawDate;
	}
	public void setThawDate(Date thawDate) {
		this.thawDate = thawDate;
	}
	@Column(name="FRO_TO")
	public Date getFroTo() {
		return froTo;
	}
	public void setFroTo(Date froTo) {
		this.froTo = froTo;
	}
	@Column(name="THAW_COMMODS_ENT")
	public String getThawCommodsEnt() {
		return thawCommodsEnt;
	}
	public void setThawCommodsEnt(String thawCommodsEnt) {
		this.thawCommodsEnt = thawCommodsEnt;
	}
	@Column(name="FRO_AM")
	public Double getFroAM() {
		return froAM;
	}
	public void setFroAM(Double froAM) {
		this.froAM = froAM;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgentSharesFroEntity other = (AgentSharesFroEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AgentChangeEntity [id=" + id + ", regId=" + regId + ", froDocNo=" + froDocNo + "]";
	}
}
