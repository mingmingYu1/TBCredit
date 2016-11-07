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
@Table(name ="ods_person_invest_rypossha_report", catalog="credit_db")
public class OdsPersonInvestRyposshaReportEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============自增主键 =================
	private Integer id;

	// ============创建时间 =================
	private Date createTime;

	// ============文件编号 =================
	private String fileNo;

	// ============身份证号 =================
	private String cardId;

	// ============查询人姓名 =================
	private String name;

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

	// ============认缴出资额 =================
	private Double contribution;

	// ============认缴出资额(币种) =================
	private String contributionCurrency;

	// ============企业状态 =================
	private String status;

	// ============ =================
	private Timestamp addtime;

	public OdsPersonInvestRyposshaReportEntity(){}
	
	public OdsPersonInvestRyposshaReportEntity(String fileNo, Date createTime)
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

	// ============查询人姓名 =================
	@Column(name="name")
	public String getName()
	{
		return this.name;
	};

	public void setName(String name)
	{
		this.name = name;
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

	// ============认缴出资额 =================
	@Column(name="contribution")
	public Double getContribution()
	{
		return this.contribution;
	};

	public void setContribution(Double contribution)
	{
		this.contribution = contribution;
	};

	// ============认缴出资额(币种) =================
	@Column(name="contribution_currency")
	public String getContributionCurrency()
	{
		return this.contributionCurrency;
	};

	public void setContributionCurrency(String contributionCurrency)
	{
		this.contributionCurrency = contributionCurrency;
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
			 + ", name=" + name
			 + ", entName=" + entName
			 + ", entNo=" + entNo
			 + ", entType=" + entType
			 + ", regcapital=" + regcapital
			 + ", currency=" + currency
			 + ", contribution=" + contribution
			 + ", contributionCurrency=" + contributionCurrency
			 + ", status=" + status
			 + ", addtime=" + addtime;
	};
};