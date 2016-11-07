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
@Table(name ="ods_person_invest_punished_report", catalog="credit_db")
public class OdsPersonInvestPunishedReportEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============自增主键 =================
	private Integer id;

	// ============创建时间 =================
	private Date createTime;

	// ============文件编号 =================
	private String fileNo;

	// ============身份证号 =================
	private String cardId;

	// ============案号 =================
	private String caseNo;

	// ============被执行姓名 =================
	private String name;

	// ============性别 =================
	private String sex;

	// ============年龄 =================
	private Integer age;

	// ============身份证号码 /工商注册号 =================
	private String cardNumber;

	// ============身份证原始发地 =================
	private String identityDeparture;

	// ============立案时间 =================
	private Date filingDate;

	// ============执行标的 =================
	private Double executeTarget;

	// ============省份 =================
	private String province;

	// ============关注次数 =================
	private Integer focusNumber;

	// ============案件状态 =================
	private String caseState;

	// ============执行法院 =================
	private String courtName;

	// ============ =================
	private Timestamp addtime;

	public OdsPersonInvestPunishedReportEntity(){}
	
	public OdsPersonInvestPunishedReportEntity(String fileNo, Date createTime) 
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

	// ============案号 =================
	@Column(name="case_no")
	public String getCaseNo()
	{
		return this.caseNo;
	};

	public void setCaseNo(String caseNo)
	{
		this.caseNo = caseNo;
	};

	// ============被执行姓名 =================
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

	// ============年龄 =================
	@Column(name="age")
	public Integer getAge()
	{
		return this.age;
	};

	public void setAge(Integer age)
	{
		this.age = age;
	};

	// ============身份证号码 /工商注册号 =================
	@Column(name="card_number")
	public String getCardNumber()
	{
		return this.cardNumber;
	};

	public void setCardNumber(String cardNumber)
	{
		this.cardNumber = cardNumber;
	};

	// ============身份证原始发地 =================
	@Column(name="identity_departure")
	public String getIdentityDeparture()
	{
		return this.identityDeparture;
	};

	public void setIdentityDeparture(String identityDeparture)
	{
		this.identityDeparture = identityDeparture;
	};

	// ============立案时间 =================
	@Column(name="filing_date")
	public Date getFilingDate()
	{
		return this.filingDate;
	};

	public void setFilingDate(Date filingDate)
	{
		this.filingDate = filingDate;
	};

	// ============执行标的 =================
	@Column(name="execute_target")
	public Double getExecuteTarget()
	{
		return this.executeTarget;
	};

	public void setExecuteTarget(Double executeTarget)
	{
		this.executeTarget = executeTarget;
	};

	// ============省份 =================
	@Column(name="province")
	public String getProvince()
	{
		return this.province;
	};

	public void setProvince(String province)
	{
		this.province = province;
	};

	// ============关注次数 =================
	@Column(name="focus_number")
	public Integer getFocusNumber()
	{
		return this.focusNumber;
	};

	public void setFocusNumber(Integer focusNumber)
	{
		this.focusNumber = focusNumber;
	};

	// ============案件状态 =================
	@Column(name="case_state")
	public String getCaseState()
	{
		return this.caseState;
	};

	public void setCaseState(String caseState)
	{
		this.caseState = caseState;
	};

	// ============执行法院 =================
	@Column(name="court_name")
	public String getCourtName()
	{
		return this.courtName;
	};

	public void setCourtName(String courtName)
	{
		this.courtName = courtName;
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
			 + ", caseNo=" + caseNo
			 + ", name=" + name
			 + ", sex=" + sex
			 + ", age=" + age
			 + ", cardNumber=" + cardNumber
			 + ", identityDeparture=" + identityDeparture
			 + ", filingDate=" + filingDate
			 + ", executeTarget=" + executeTarget
			 + ", province=" + province
			 + ", focusNumber=" + focusNumber
			 + ", caseState=" + caseState
			 + ", courtName=" + courtName
			 + ", addtime=" + addtime;
	};
};