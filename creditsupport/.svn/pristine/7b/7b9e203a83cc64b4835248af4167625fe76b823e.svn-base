package com.yodata.creditsupport.orm.person.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author lenovo
 *个人信息表
 */
@Entity
@Table(name ="ods_person_info", catalog="credit_db")
public class OdsPersonInfoEntity implements Serializable{

	
	private static final long serialVersionUID = -2521492372837371971L;

		// ============身份证号 =================
		private String cardId;

		// ============姓名 =================
		private String name;

		// ============性别 =================
		private String sex;

		// ============地址 =================
		private String address;
		
		// ============手机号 =================
		private String phone;
		
		// ============手机号认证结果 =================
		private String phoneStatus;
		
		// ============手机号认证详细信息 =================
		private String phoneMessage;
		
		// ============认证结果 =================
	    private String compStatus;
	    
	    // ============认证详细信息 =================
	    private String compResult;
	    
	    // ============银行卡号 =================
	    private String accountNo;
	    
	    // ============银行卡认证结果 =================
	    private String accountResult;
	    
	    // ============银行卡认证详细结果 =================
	    private String accountMessage;
	    
		
		// ============ 录入时间=================
		private Date addtime;
		// ============更新时间 =================
	    private Timestamp modTime;
	    
	    private Double indScore;        //最后一次得分
	    private String algorCode;       //算法编码
	    private String algorName;       //算法名称
		
		// ============身份证号 =================
		@Id
		@Column(name="card_id", nullable = false)
		public String getCardId()
		{
			return this.cardId;
		}
		public void setCardId(String cardId)
		{
			this.cardId = cardId;
		}

		// ============姓名 =================
		@Column(name="name")
		public String getName()
		{
			return this.name;
		}
		public void setName(String name)
		{
			this.name = name;
		}

		// ============性别 =================
		@Column(name="sex")
		public String getSex()
		{
			return this.sex;
		}
		public void setSex(String sex)
		{
			this.sex = sex;
		}

		// ============地址 =================
		@Column(name="address")
		public String getAddress()
		{
			return this.address;
		}

		public void setAddress(String address)
		{
			this.address = address;
		}

		@Column(name="add_time")
		public Date getAddtime()
		{
			return this.addtime;
		}
		public void setAddtime(Date addtime)
		{
			this.addtime = addtime;
		}

		@Column(name="mod_time")
		public Timestamp getModTime() {
			return modTime;
		}
		public void setModTime(Timestamp modTime) {
			this.modTime = modTime;
		}
		
	@Transient
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Transient
	public String getPhoneStatus() {
		return phoneStatus;
	}

	public void setPhoneStatus(String phoneStatus) {
		this.phoneStatus = phoneStatus;
	}

	@Transient
	public String getPhoneMessage() {
		return phoneMessage;
	}

	public void setPhoneMessage(String phoneMessage) {
		this.phoneMessage = phoneMessage;
	}

	@Column(name="compstatus")
	public String getCompStatus() {
		return compStatus;
	}

	public void setCompStatus(String compStatus) {
		this.compStatus = compStatus;
	}

	@Column(name="compresult")
	public String getCompResult() {
		return compResult;
	}

	public void setCompResult(String compResult) {
		this.compResult = compResult;
	}

	@Transient
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Transient
	public String getAccountResult() {
		return accountResult;
	}

	public void setAccountResult(String accountResult) {
		this.accountResult = accountResult;
	}

	@Transient
	public String getAccountMessage() {
		return accountMessage;
	}

	public void setAccountMessage(String accountMessage) {
		this.accountMessage = accountMessage;
	}
		
		@Transient
	    public Double getIndScore() {
	        return indScore;
	    }
	    public void setIndScore(Double indScore) {
	        this.indScore = indScore;
	    }
	    
	    @Transient
	    public String getAlgorCode() {
	        return algorCode;
	    }
	    public void setAlgorCode(String algorCode) {
	        this.algorCode = algorCode;
	    }
	    
	    @Transient
	    public String getAlgorName() {
	        return algorName;
	    }
	    public void setAlgorName(String algorName) {
	        this.algorName = algorName;
	    }
	    
}
