package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.yodata.creditsupport.util.Tools;

/**
 * 客户忠诚度信息
 */
@Entity
@Table(name = "ods_merchant_trade_report_loyalty_info", catalog = "credit_db")
public class MerchantTrandeReportLoyalty implements Serializable {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 6851839307867539396L;

	// 遍历所有的字段,columnMap
	// =============== 自增主键 =================
	private Integer id;

	// =============== 工商注册号 =================
	private String regId;

	// =============== 流水号 =================
	private String serialNo;

	// =============== 客户类型 =================
	private String customerType;

	// =============== 金额占比 =================
	private String amountProp;

	// =============== 交易笔数占比 =================
	private String countProp;

	// =============== 交易人数占比 =================
	private String personProp;

	// =============== =================
	private Date addTime;

	private String amountPropStr;
	private String countPropStr;
	private String personPropStr;
	
	
	@Transient
   public String getAmountPropStr() {
		if(amountProp != null)
			amountPropStr = Tools.getPrecentStr(amountProp);
		return amountPropStr;
	}

	public void setAmountPropStr(String amountPropStr) {
		this.amountPropStr = amountPropStr;
	}

	@Transient
	public String getCountPropStr() {
		if(countProp != null)
			countPropStr= Tools.getPrecentStr(countProp);
		return countPropStr;
	}

	public void setCountPropStr(String countPropStr) {
		this.countPropStr = countPropStr;
	}

	@Transient
	public String getPersonPropStr() {
		if(personProp != null)
			personPropStr = Tools.getPrecentStr(personProp);
		return personPropStr;
	}

	public void setPersonPropStr(String personPropStr) {
		this.personPropStr = personPropStr;
	}
	
	// =============== 自增主键 =================
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// =============== 工商注册号 =================
	@Column(name = "REG_ID")
	public String getRegId() {
		return this.regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	// =============== 流水号 =================
	@Column(name = "SERIAL_NO")
	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	// =============== 客户类型 =================
	@Column(name = "CUSTOMER_TYPE")
	public String getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	// =============== 金额占比 =================
	@Column(name = "AMOUNT_PROP")
	public String getAmountProp() {
		return this.amountProp;
	}

	public void setAmountProp(String amountProp) {
		this.amountProp = amountProp;
	}

	// =============== 交易笔数占比 =================
	@Column(name = "COUNT_PROP")
	public String getCountProp() {
		return this.countProp;
	}

	public void setCountProp(String countProp) {
		this.countProp = countProp;
	}

	// =============== 交易人数占比 =================
	@Column(name = "PERSON_PROP")
	public String getPersonProp() {
		return this.personProp;
	}

	public void setPersonProp(String personProp) {
		this.personProp = personProp;
	}

	// =============== =================
	@Column(name = "ADD_TIME")
	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
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
		MerchantTrandeReportLoyalty other = (MerchantTrandeReportLoyalty) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AgentChangeEntity [id=" + id + ", regId=" + regId + ", serialNo=" + serialNo + "]";
	}
}
