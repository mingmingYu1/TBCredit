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
 * @author Jason
 * 裁判文书
 *
 */

@Entity
@Table(name ="ods_person_risk_cpws", catalog="credit_db")
public class OdsPersonRiskCpwsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============ =================
	private Integer id;

	// ============身份证号 =================
	private String cardId;

	// ============裁判文书ID =================
	private String cpwsid;

	// ============审结时间 =================
	private String sorttime;

	// ============数据类型 =================
	private String datatype;

	// ============案由 =================
	private String casecause;

	// ============标题 =================
	private String title;

	// ============审理程序 =================
	private String trialprocedure;

	// ============当事人ID =================
	private String partyid;

	// ============匹配度 =================
	private String matchratio;

	// ============法院名称 =================
	private String court;

	// ============案号 =================
	private String caseno;

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

	// ============裁判文书ID =================
	@Column(name="cpwsId")
	public String getCpwsid()
	{
		return this.cpwsid;
	};

	public void setCpwsid(String cpwsid)
	{
		this.cpwsid = cpwsid;
	};

	// ============审结时间 =================
	@Column(name="sortTime")
	public String getSorttime()
	{
		return this.sorttime;
	};

	public void setSorttime(String sorttime)
	{
		this.sorttime = sorttime;
	};

	// ============数据类型 =================
	@Column(name="dataType")
	public String getDatatype()
	{
		return this.datatype;
	};

	public void setDatatype(String datatype)
	{
		this.datatype = datatype;
	};

	// ============案由 =================
	@Column(name="caseCause")
	public String getCasecause()
	{
		return this.casecause;
	};

	public void setCasecause(String casecause)
	{
		this.casecause = casecause;
	};

	// ============标题 =================
	@Column(name="title")
	public String getTitle()
	{
		return this.title;
	};

	public void setTitle(String title)
	{
		this.title = title;
	};

	// ============审理程序 =================
	@Column(name="trialProcedure")
	public String getTrialprocedure()
	{
		return this.trialprocedure;
	};

	public void setTrialprocedure(String trialprocedure)
	{
		this.trialprocedure = trialprocedure;
	};

	// ============当事人ID =================
	@Column(name="partyId")
	public String getPartyid()
	{
		return this.partyid;
	};

	public void setPartyid(String partyid)
	{
		this.partyid = partyid;
	};

	// ============匹配度 =================
	@Column(name="matchRatio")
	public String getMatchratio()
	{
		return this.matchratio;
	};

	public void setMatchratio(String matchratio)
	{
		this.matchratio = matchratio;
	};

	// ============法院名称 =================
	@Column(name="court")
	public String getCourt()
	{
		return this.court;
	};

	public void setCourt(String court)
	{
		this.court = court;
	};

	// ============案号 =================
	@Column(name="caseNo")
	public String getCaseno()
	{
		return this.caseno;
	};

	public void setCaseno(String caseno)
	{
		this.caseno = caseno;
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
			 + ", cpwsid=" + cpwsid
			 + ", sorttime=" + sorttime
			 + ", datatype=" + datatype
			 + ", casecause=" + casecause
			 + ", title=" + title
			 + ", trialprocedure=" + trialprocedure
			 + ", partyid=" + partyid
			 + ", matchratio=" + matchratio
			 + ", court=" + court
			 + ", caseno=" + caseno
			 + ", addtime=" + addtime;
	};
};