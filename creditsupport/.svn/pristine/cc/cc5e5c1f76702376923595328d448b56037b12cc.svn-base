package com.yodata.creditsupport.orm.person.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author jason
 * 个人对外投资_管理人员信息
 *
 */

@Entity
@Table(name ="ods_person_invest_ryposper", catalog="credit_db")
public class OdsPersonInvestRyposperEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============ =================
	private Integer id;

	// ============身份证号 =================
	private String cardId;

	// ============企业名称 =================
	private String entName;

	// ============企业注册号 =================
	private String entNo;

	// ============企业类型 =================
	private String entType;

	// ============注册资本 =================
	private Double regcapital;

	// ============币种 =================
	private String currency;

	// ============企业状态 =================
	private String status;

	// ============职务 =================
	private String position;

	// ============ =================
	private Timestamp addtime;

	// ============ =================
	@Id
	@Column(name="id")
	public Integer getId()
	{
		return this.id;
	};

	public void setId(Integer id)
	{
		this.id = id;
	};

	// ============身份证号 =================
	@Column(name="card_id")
	public String getCardId()
	{
		return this.cardId;
	};

	public void setCardId(String cardId)
	{
		this.cardId = cardId;
	};

	// ============企业名称 =================
	@Column(name="ent_name")
	public String getEntName()
	{
		return this.entName;
	};

	public void setEntName(String entName)
	{
		this.entName = entName;
	};

	// ============企业注册号 =================
	@Column(name="ent_no")
	public String getEntNo()
	{
		return this.entNo;
	};

	public void setEntNo(String entNo)
	{
		this.entNo = entNo;
	};

	// ============企业类型 =================
	@Column(name="ent_type")
	public String getEntType()
	{
		return this.entType;
	};

	public void setEntType(String entType)
	{
		this.entType = entType;
	};

	// ============注册资本 =================
	@Column(name="regcapital")
	public Double getRegcapital()
	{
		return this.regcapital;
	};

	public void setRegcapital(Double regcapital)
	{
		this.regcapital = regcapital;
	};

	// ============币种 =================
	@Column(name="currency")
	public String getCurrency()
	{
		return this.currency;
	};

	public void setCurrency(String currency)
	{
		this.currency = currency;
	};

	// ============企业状态 =================
	@Column(name="status")
	public String getStatus()
	{
		return this.status;
	};

	public void setStatus(String status)
	{
		this.status = status;
	};

	// ============职务 =================
	@Column(name="position")
	public String getPosition()
	{
		return this.position;
	};

	public void setPosition(String position)
	{
		this.position = position;
	};

	// ============ =================
	@Column(name="addtime")
	public Timestamp getAddtime()
	{
		return this.addtime;
	};

	public void setAddtime(Timestamp addtime)
	{
		this.addtime = addtime;
	};


@Override
	public String toString(){
		 return "id=" + id
			 + ", cardId=" + cardId
			 + ", entName=" + entName
			 + ", entNo=" + entNo
			 + ", entType=" + entType
			 + ", regcapital=" + regcapital
			 + ", currency=" + currency
			 + ", status=" + status
			 + ", position=" + position
			 + ", addtime=" + addtime;
	};
};