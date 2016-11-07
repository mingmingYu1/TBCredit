package com.yodata.creditsupport.orm.entity.his;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.yodata.creditsupport.util.Tools;

@Entity
@Table(name ="ods_merchant_trade_report_area_info_his", catalog="credit_db")
public class MerchantTrandeReportAreaHis implements Serializable{

	private static final long serialVersionUID = 8333499230995353239L;

	private Integer id; // 自增主键
	private String regId; // 企业注册号
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

	private String fileNo;			// 文件编号
	private Date createTime;		// 生成时间
	
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
	
	public MerchantTrandeReportAreaHis() {
		// TODO Auto-generated constructor stub
	}
	
   public MerchantTrandeReportAreaHis(String fileNo,Date createTime) {
		// TODO Auto-generated constructor stub
	   this.fileNo = fileNo;
	   this.createTime = createTime;
	}
   
	@Column(name="FILE_NO")
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	@Column(name="CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "SERIAL_NO")
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	@Column(name = "CUSTOMER_TYPE")
	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	@Column(name = "AMOUNT_PROP")
	public String getAmountProp() {
		return amountProp;
	}

	public void setAmountProp(String amountProp) {
		this.amountProp = amountProp;
	}

	@Column(name = "COUNT_PROP")
	public String getCountProp() {
		return countProp;
	}

	public void setCountProp(String countProp) {
		this.countProp = countProp;
	}

	@Column(name = "PERSON_PROP")
	public String getPersonProp() {
		return personProp;
	}

	public void setPersonProp(String personProp) {
		this.personProp = personProp;
	}

	@Column(name = "ADD_TIME")
	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "reg_id")
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
	public String toString() {
		return "AgentChangeEntity [id=" + id + ", regId=" + regId + ", serialNo=" + serialNo + "]";
	}
	
}
