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
@Table(name ="ods_riskdetail_cpws", catalog="credit_db")
public class OdsRiskdetailCpwsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============裁判文书ID =================
	private String cpwsid;

	// ============审结时间 =================
	private String sorttime;

	// ============文书类型（案件类型） =================
	private String casetype;

	// ============内容 =================
	private String body;

	// ============法院名称 =================
	private String court;

	// ============案由编码 =================
	private String anyou;

	// ============标题 =================
	private String title;

	// ============审判员 =================
	private String judge;

	// ============案号 =================
	private String caseno;

	// ============判决结果 =================
	private String judgeresult;

	// ============审理程序 =================
	private String trialprocedure;

	// ============案由 =================
	private String casecause;

	// ============案由编码类型 =================
	private String anyoutype;

	// ============依据 =================
	private String yiju;

	// ============法院等级 =================
	private String courtrank;

	// ============ =================
	private Timestamp addtime;

	// ============裁判文书ID =================
	@Id
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

	// ============文书类型（案件类型） =================
	@Column(name="caseType")
	public String getCasetype()
	{
		return this.casetype;
	};

	public void setCasetype(String casetype)
	{
		this.casetype = casetype;
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

	// ============案由编码 =================
	@Column(name="anyou")
	public String getAnyou()
	{
		return this.anyou;
	};

	public void setAnyou(String anyou)
	{
		this.anyou = anyou;
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

	// ============审判员 =================
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

	// ============判决结果 =================
	@Column(name="judgeResult")
	public String getJudgeresult()
	{
		return this.judgeresult;
	};

	public void setJudgeresult(String judgeresult)
	{
		this.judgeresult = judgeresult;
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

	// ============案由编码类型 =================
	@Column(name="anyouType")
	public String getAnyoutype()
	{
		return this.anyoutype;
	};

	public void setAnyoutype(String anyoutype)
	{
		this.anyoutype = anyoutype;
	};

	// ============依据 =================
	@Column(name="yiju")
	public String getYiju()
	{
		return this.yiju;
	};

	public void setYiju(String yiju)
	{
		this.yiju = yiju;
	};

	// ============法院等级 =================
	@Column(name="courtRank")
	public String getCourtrank()
	{
		return this.courtrank;
	};

	public void setCourtrank(String courtrank)
	{
		this.courtrank = courtrank;
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
		 return "cpwsid=" + cpwsid
			 + ", sorttime=" + sorttime
			 + ", casetype=" + casetype
			 + ", body=" + body
			 + ", court=" + court
			 + ", anyou=" + anyou
			 + ", title=" + title
			 + ", judge=" + judge
			 + ", caseno=" + caseno
			 + ", judgeresult=" + judgeresult
			 + ", trialprocedure=" + trialprocedure
			 + ", casecause=" + casecause
			 + ", anyoutype=" + anyoutype
			 + ", yiju=" + yiju
			 + ", courtrank=" + courtrank
			 + ", addtime=" + addtime;
	};
};