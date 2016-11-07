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
@Table(name ="ods_person_identity", catalog="credit_db")
public class OdsPersonIdentityEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============身份证号码 =================
	private String cardId;

	// ============姓名 =================
	private String name;

	// ============对比状态 1：一致2：不一致。3:库中无此号 =================
	private String compstatus;

	// ============对比结果，对应上述1、2，3的值 =================
	private String compresult;

	// ============ =================
	private Timestamp addtime;

	// ============身份证号码 =================
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

	// ============对比状态 1：一致2：不一致。3:库中无此号 =================
	@Column(name="compstatus")
	public String getCompstatus()
	{
		return this.compstatus;
	};

	public void setCompstatus(String compstatus)
	{
		this.compstatus = compstatus;
	};

	// ============对比结果，对应上述1、2，3的值 =================
	@Column(name="compresult")
	public String getCompresult()
	{
		return this.compresult;
	};

	public void setCompresult(String compresult)
	{
		this.compresult = compresult;
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
			 + ", compstatus=" + compstatus
			 + ", compresult=" + compresult
			 + ", addtime=" + addtime;
	};
};