package com.yodata.creditsupport.orm.person.entity.report;

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
@Table(name ="ods_person_risk_zxgg_report", catalog="credit_db")
public class OdsPersonRiskZxggReportEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============自增主键 =================
	private Integer id;

	// ============创建时间 =================
	private Date createTime;

	// ============文件编号 =================
	private String fileNo;

	// ============身份证号 =================
	private String cardId;

	// ============执行公告id =================
	private String zxggid;

	// ============审结时间 =================
	private String sorttime;

	// ============内容 =================
	private String body;

	// ============执行状态 =================
	private String status;

	// ============执行法院名称 =================
	private String court;

	// ============申请人 =================
	private String proposer;

	// ============身份证/组织机构代码 =================
	private String idcardno;

	// ============数据类型 =================
	private String datatype;

	// ============标题 =================
	private String title;

	// ============匹配度 =================
	private Double matchratio;

	// ============姓名 =================
	private String pname;

	// ============案号 =================
	private String caseno;

	// ============案件状态 =================
	private String casestate;

	// ============执行标的 =================
	private Double execmoney;

	// ============ =================
	private Timestamp addtime;

	public OdsPersonRiskZxggReportEntity(){}
	
	public OdsPersonRiskZxggReportEntity(String fileNo, Date createTime)
	{
		this.fileNo = fileNo;
		this.createTime = createTime;
	}

	// ============自增主键 =================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
	public Integer getId()
	{
		return this.id;
	};

	public void setId(Integer id)
	{
		this.id = id;
	};

	// ============创建时间 =================
	@Column(name="CREATE_TIME")
	public Date getCreateTime()
	{
		return this.createTime;
	};

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	};

	// ============文件编号 =================
	@Column(name="FILE_NO")
	public String getFileNo()
	{
		return this.fileNo;
	};

	public void setFileNo(String fileNo)
	{
		this.fileNo = fileNo;
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

	// ============执行公告id =================
	@Column(name="zxggId")
	public String getZxggid()
	{
		return this.zxggid;
	};

	public void setZxggid(String zxggid)
	{
		this.zxggid = zxggid;
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

	// ============匹配度 =================
	@Column(name="matchRatio")
	public Double getMatchratio()
	{
		return this.matchratio;
	};

	public void setMatchratio(Double matchratio)
	{
		this.matchratio = matchratio;
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
		 return "id=" + id
			 + ", createTime=" + createTime
			 + ", fileNo=" + fileNo
			 + ", cardId=" + cardId
			 + ", zxggid=" + zxggid
			 + ", sorttime=" + sorttime
			 + ", body=" + body
			 + ", status=" + status
			 + ", court=" + court
			 + ", proposer=" + proposer
			 + ", idcardno=" + idcardno
			 + ", datatype=" + datatype
			 + ", title=" + title
			 + ", matchratio=" + matchratio
			 + ", pname=" + pname
			 + ", caseno=" + caseno
			 + ", casestate=" + casestate
			 + ", execmoney=" + execmoney
			 + ", addtime=" + addtime;
	};
};