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
@Table(name ="ods_riskdetail_zxgg", catalog="credit_db")
public class OdsRiskdetailZxggEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============执行公告ID =================
	private String zxggid;

	// ============立案时间 =================
	private String sorttime;

	// ============内容 =================
	private String body;

	// ============标题 =================
	private String title;

	// ============执行状态 =================
	private String status;

	// ============被执行人姓名 =================
	private String pname;

	// ============执行法院名称 =================
	private String court;

	// ============申请人 =================
	private String proposer;

	// ============案号 =================
	private String caseno;

	// ============案件状态 =================
	private String casestate;

	// ============身份证/组织机构代码 =================
	private String idcardno;

	// ============执行标的 =================
	private Double execmoney;

	// ============ =================
	private Timestamp addtime;

	// ============执行公告ID =================
	@Id
	@Column(name="zxggId")
	public String getZxggid()
	{
		return this.zxggid;
	};

	public void setZxggid(String zxggid)
	{
		this.zxggid = zxggid;
	};

	// ============立案时间 =================
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

	// ============执行状态 =================
	@Column(name="status")
	public String getStatus()
	{
		return this.status;
	};

	public void setStatus(String status)
	{
		this.status = status;
	};

	// ============被执行人姓名 =================
	@Column(name="pname")
	public String getPname()
	{
		return this.pname;
	};

	public void setPname(String pname)
	{
		this.pname = pname;
	};

	// ============执行法院名称 =================
	@Column(name="court")
	public String getCourt()
	{
		return this.court;
	};

	public void setCourt(String court)
	{
		this.court = court;
	};

	// ============申请人 =================
	@Column(name="proposer")
	public String getProposer()
	{
		return this.proposer;
	};

	public void setProposer(String proposer)
	{
		this.proposer = proposer;
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

	// ============案件状态 =================
	@Column(name="caseState")
	public String getCasestate()
	{
		return this.casestate;
	};

	public void setCasestate(String casestate)
	{
		this.casestate = casestate;
	};

	// ============身份证/组织机构代码 =================
	@Column(name="idcardNo")
	public String getIdcardno()
	{
		return this.idcardno;
	};

	public void setIdcardno(String idcardno)
	{
		this.idcardno = idcardno;
	};

	// ============执行标的 =================
	@Column(name="execMoney")
	public Double getExecmoney()
	{
		return this.execmoney;
	};

	public void setExecmoney(Double execmoney)
	{
		this.execmoney = execmoney;
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
		 return "zxggid=" + zxggid
			 + ", sorttime=" + sorttime
			 + ", body=" + body
			 + ", title=" + title
			 + ", status=" + status
			 + ", pname=" + pname
			 + ", court=" + court
			 + ", proposer=" + proposer
			 + ", caseno=" + caseno
			 + ", casestate=" + casestate
			 + ", idcardno=" + idcardno
			 + ", execmoney=" + execmoney
			 + ", addtime=" + addtime;
	};
};