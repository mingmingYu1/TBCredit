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
@Table(name ="ods_person_risk", catalog="credit_db")
public class OdsPersonRiskEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============身份证号 =================
	private String cardId;

	// ============姓名 =================
	private String pname;

	// ============数据条数 =================
	private String count;

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
	@Column(name="pname")
	public String getPname()
	{
		return this.pname;
	};

	public void setPname(String pname)
	{
		this.pname = pname;
	};

	// ============数据条数 =================
	@Column(name="count")
	public String getCount()
	{
		return this.count;
	};

	public void setCount(String count)
	{
		this.count = count;
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
			 + ", pname=" + pname
			 + ", count=" + count
			 + ", addtime=" + addtime;
	};
};