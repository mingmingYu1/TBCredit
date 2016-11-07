package com.yodata.creditsupport.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name ="ods_riskdetail_ajlc", catalog="credit_db")
public class OdsRiskdetailAjlcEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============��������ID =================
	private String ajlcid;

	// ============��ͥ��Ա =================
	private String member;

	// ============����ʱ�� =================
	private String sorttime;

	// ============��ֵԱ�绰 =================
	private String clerkphone;

	// ============������� =================
	private String casetype;

	// ============���� =================
	private String body;

	// ============������� =================
	private String trialprocedure;

	// ============�о����� =================
	private String sentencingdate;

	// ============ִ��״̬ =================
	private String status;

	// ============����״̬ =================
	private String casestatus;

	// ============��֯�� =================
	private String organizer;

	// ============�鵵���� =================
	private Date filingdate;

	// ============��Ժ��� =================
	private String court;

	// ============����״̬ =================
	private String ajlcstatus;

	// ============��Ҫ���� =================
	private String chiefjudge;

	// ============���� =================
	private String casecause;

	// ============������������ =================
	private String triallimitdate;

	// ============���Ա =================
	private String clerk;

	// ============���� =================
	private String judge;

	// ============���ϱ�� =================
	private String actionobject;

	// ============������ =================
	private String pname;

	// ============���� =================
	private String caseno;

	// ============��Ч���� =================
	private String effectivedate;

	// ============ =================
	private Timestamp addtime;

	// ============��������ID =================
	@Id
	@Column(name="ajlcId")
	public String getAjlcid()
	{
		return this.ajlcid;
	};

	public void setAjlcid(String ajlcid)
	{
		this.ajlcid = ajlcid;
	};

	// ============��ͥ��Ա =================
	@Column(name="member")
	public String getMember()
	{
		return this.member;
	};

	public void setMember(String member)
	{
		this.member = member;
	};

	// ============����ʱ�� =================
	@Column(name="sortTime")
	public String getSorttime()
	{
		return this.sorttime;
	};

	public void setSorttime(String sorttime)
	{
		this.sorttime = sorttime;
	};

	// ============��ֵԱ�绰 =================
	@Column(name="clerkPhone")
	public String getClerkphone()
	{
		return this.clerkphone;
	};

	public void setClerkphone(String clerkphone)
	{
		this.clerkphone = clerkphone;
	};

	// ============������� =================
	@Column(name="caseType")
	public String getCasetype()
	{
		return this.casetype;
	};

	public void setCasetype(String casetype)
	{
		this.casetype = casetype;
	};

	// ============���� =================
	@Column(name="body")
	public String getBody()
	{
		return this.body;
	};

	public void setBody(String body)
	{
		this.body = body;
	};

	// ============������� =================
	@Column(name="trialProcedure")
	public String getTrialprocedure()
	{
		return this.trialprocedure;
	};

	public void setTrialprocedure(String trialprocedure)
	{
		this.trialprocedure = trialprocedure;
	};

	// ============�о����� =================
	@Column(name="sentencingDate")
	public String getSentencingdate()
	{
		return this.sentencingdate;
	};

	public void setSentencingdate(String sentencingdate)
	{
		this.sentencingdate = sentencingdate;
	};

	// ============ִ��״̬ =================
	@Column(name="status")
	public String getStatus()
	{
		return this.status;
	};

	public void setStatus(String status)
	{
		this.status = status;
	};

	// ============����״̬ =================
	@Column(name="caseStatus")
	public String getCasestatus()
	{
		return this.casestatus;
	};

	public void setCasestatus(String casestatus)
	{
		this.casestatus = casestatus;
	};

	// ============��֯�� =================
	@Column(name="organizer")
	public String getOrganizer()
	{
		return this.organizer;
	};

	public void setOrganizer(String organizer)
	{
		this.organizer = organizer;
	};

	// ============�鵵���� =================
	@Column(name="filingDate")
	public Date getFilingdate()
	{
		return this.filingdate;
	};

	public void setFilingdate(Date filingdate)
	{
		this.filingdate = filingdate;
	};

	// ============��Ժ��� =================
	@Column(name="court")
	public String getCourt()
	{
		return this.court;
	};

	public void setCourt(String court)
	{
		this.court = court;
	};

	// ============����״̬ =================
	@Column(name="ajlcStatus")
	public String getAjlcstatus()
	{
		return this.ajlcstatus;
	};

	public void setAjlcstatus(String ajlcstatus)
	{
		this.ajlcstatus = ajlcstatus;
	};

	// ============��Ҫ���� =================
	@Column(name="chiefJudge")
	public String getChiefjudge()
	{
		return this.chiefjudge;
	};

	public void setChiefjudge(String chiefjudge)
	{
		this.chiefjudge = chiefjudge;
	};

	// ============���� =================
	@Column(name="caseCause")
	public String getCasecause()
	{
		return this.casecause;
	};

	public void setCasecause(String casecause)
	{
		this.casecause = casecause;
	};

	// ============������������ =================
	@Column(name="trialLimitDate")
	public String getTriallimitdate()
	{
		return this.triallimitdate;
	};

	public void setTriallimitdate(String triallimitdate)
	{
		this.triallimitdate = triallimitdate;
	};

	// ============���Ա =================
	@Column(name="clerk")
	public String getClerk()
	{
		return this.clerk;
	};

	public void setClerk(String clerk)
	{
		this.clerk = clerk;
	};

	// ============���� =================
	@Column(name="judge")
	public String getJudge()
	{
		return this.judge;
	};

	public void setJudge(String judge)
	{
		this.judge = judge;
	};

	// ============���ϱ�� =================
	@Column(name="actionObject")
	public String getActionobject()
	{
		return this.actionobject;
	};

	public void setActionobject(String actionobject)
	{
		this.actionobject = actionobject;
	};

	// ============������ =================
	@Column(name="pname")
	public String getPname()
	{
		return this.pname;
	};

	public void setPname(String pname)
	{
		this.pname = pname;
	};

	// ============���� =================
	@Column(name="caseNo")
	public String getCaseno()
	{
		return this.caseno;
	};

	public void setCaseno(String caseno)
	{
		this.caseno = caseno;
	};

	// ============��Ч���� =================
	@Column(name="effectiveDate")
	public String getEffectivedate()
	{
		return this.effectivedate;
	};

	public void setEffectivedate(String effectivedate)
	{
		this.effectivedate = effectivedate;
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
		 return "ajlcid=" + ajlcid
			 + ", member=" + member
			 + ", sorttime=" + sorttime
			 + ", clerkphone=" + clerkphone
			 + ", casetype=" + casetype
			 + ", body=" + body
			 + ", trialprocedure=" + trialprocedure
			 + ", sentencingdate=" + sentencingdate
			 + ", status=" + status
			 + ", casestatus=" + casestatus
			 + ", organizer=" + organizer
			 + ", filingdate=" + filingdate
			 + ", court=" + court
			 + ", ajlcstatus=" + ajlcstatus
			 + ", chiefjudge=" + chiefjudge
			 + ", casecause=" + casecause
			 + ", triallimitdate=" + triallimitdate
			 + ", clerk=" + clerk
			 + ", judge=" + judge
			 + ", actionobject=" + actionobject
			 + ", pname=" + pname
			 + ", caseno=" + caseno
			 + ", effectivedate=" + effectivedate
			 + ", addtime=" + addtime;
	};
};