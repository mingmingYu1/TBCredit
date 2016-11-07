package com.yodata.creditsupport.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name ="ods_riskdetail_ktgg", catalog="credit_db")
public class OdsRiskdetailKtggEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============开庭公告ID =================
	private String ktggid;

	// ============开庭时间 =================
	private String sorttime;

	// ============内容 =================
	private String body;

	// ============原告 =================
	private String plaintiff;

	// ============组织者 =================
	private String organizer;

	// ============法庭名称 =================
	private String courtroom;

	// ============相关当事人 =================
	private String relatedparty;

	// ============法院名称 =================
	private String court;

	// ============当事人 =================
	private String party;

	// ============标题 =================
	private String title;

	// ============案由 =================
	private String casecause;

	// ============法官 =================
	private String judge;

	// ============案号 =================
	private String caseno;

	// ============被告 =================
	private String defendant;

	// ============ =================
	private Timestamp addtime;

	// ============开庭公告ID =================
	@Id
	@Column(name="ktggId")
	public String getKtggid()
	{
		return this.ktggid;
	};

	public void setKtggid(String ktggid)
	{
		this.ktggid = ktggid;
	};

	// ============开庭时间 =================
	@Column(name="sortTime")
	public String getSorttime()
	{
		return this.sorttime;
	};

	public void setSorttime(String sorttime)
	{
		this.sorttime = sorttime;
	};

	// ============内容 =================
	@Column(name="body")
	public String getBody()
	{
		return this.body;
	};

	public void setBody(String body)
	{
		this.body = body;
	};

	// ============原告 =================
	@Column(name="plaintiff")
	public String getPlaintiff()
	{
		return this.plaintiff;
	};

	public void setPlaintiff(String plaintiff)
	{
		this.plaintiff = plaintiff;
	};

	// ============组织者 =================
	@Column(name="organizer")
	public String getOrganizer()
	{
		return this.organizer;
	};

	public void setOrganizer(String organizer)
	{
		this.organizer = organizer;
	};

	// ============法庭名称 =================
	@Column(name="courtroom")
	public String getCourtroom()
	{
		return this.courtroom;
	};

	public void setCourtroom(String courtroom)
	{
		this.courtroom = courtroom;
	};

	// ============相关当事人 =================
	@Column(name="relatedParty")
	public String getRelatedparty()
	{
		return this.relatedparty;
	};

	public void setRelatedparty(String relatedparty)
	{
		this.relatedparty = relatedparty;
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

	// ============当事人 =================
	@Column(name="party")
	public String getParty()
	{
		return this.party;
	};

	public void setParty(String party)
	{
		this.party = party;
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

	// ============法官 =================
	@Column(name="judge")
	public String getJudge()
	{
		return this.judge;
	};

	public void setJudge(String judge)
	{
		this.judge = judge;
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

	// ============被告 =================
	@Column(name="defendant")
	public String getDefendant()
	{
		return this.defendant;
	};

	public void setDefendant(String defendant)
	{
		this.defendant = defendant;
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
		 return "ktggid=" + ktggid
			 + ", sorttime=" + sorttime
			 + ", body=" + body
			 + ", plaintiff=" + plaintiff
			 + ", organizer=" + organizer
			 + ", courtroom=" + courtroom
			 + ", relatedparty=" + relatedparty
			 + ", court=" + court
			 + ", party=" + party
			 + ", title=" + title
			 + ", casecause=" + casecause
			 + ", judge=" + judge
			 + ", caseno=" + caseno
			 + ", defendant=" + defendant
			 + ", addtime=" + addtime;
	};
};