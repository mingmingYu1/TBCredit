package com.yodata.creditsupport.orm.person.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name ="ods_person_invest", catalog="credit_db")
public class OdsPersonInvestEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============身份证号 =================
	private String cardId;

	// ============姓名 =================
	private String name;

	// ============性别 =================
	private String sex;

	// ============地址 =================
	private String address;

	// ============ =================
	private Timestamp addtime;

	// ============身份证号 =================
	@Id
	@Column(name="card_id")
	public String getCardId()
	{
		return this.cardId;
	};

	public void setCardId(String cardId)
	{
		this.cardId = cardId;
	};

	// ============姓名 =================
	@Column(name="name")
	public String getName()
	{
		return this.name;
	};

	public void setName(String name)
	{
		this.name = name;
	};

	// ============性别 =================
	@Column(name="sex")
	public String getSex()
	{
		return this.sex;
	};

	public void setSex(String sex)
	{
		this.sex = sex;
	};

	// ============地址 =================
	@Column(name="address")
	public String getAddress()
	{
		return this.address;
	};

	public void setAddress(String address)
	{
		this.address = address;
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
		 return "cardId=" + cardId
			 + ", name=" + name
			 + ", sex=" + sex
			 + ", address=" + address
			 + ", addtime=" + addtime;
	};
};