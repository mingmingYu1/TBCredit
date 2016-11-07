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
@Table(name ="ods_person_invest_alidebt_report", catalog="credit_db")
public class OdsPersonInvestAlidebtReportEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============自增主键 =================
	private Integer id;

	// ============创建时间 =================
	private Date createTime;

	// ============文件编号 =================
	private String fileNo;

	// ============身份证号 =================
	private String cardId;

	// ============欠款额度 =================
	private Double arrears;

	// ============违约情况 =================
	private String isBreach;

	// ============贷款到期时间 =================
	private String loanDate;

	// ============淘宝账户 =================
	private String taobaoAccount;

	// ============法定代表人 =================
	private String legalPerson;

	// ============贷款期限 =================
	private String loanTimelimit;

	// ============被执行姓名 =================
	private String name;

	// ============性别 =================
	private String sex;

	// ============年龄 =================
	private Integer age;

	// ============身份证原始发地 =================
	private String identityDeparture;

	// ============省份 =================
	private String province;

	// ============ =================
	private Timestamp addtime;

	public OdsPersonInvestAlidebtReportEntity(){}
	
	public OdsPersonInvestAlidebtReportEntity(String fileNo, Date createTime)
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

	// ============欠款额度 =================
	@Column(name="arrears")
	public Double getArrears()
	{
		return this.arrears;
	};

	public void setArrears(Double arrears)
	{
		this.arrears = arrears;
	};

	// ============违约情况 =================
	@Column(name="is_breach")
	public String getIsBreach()
	{
		return this.isBreach;
	};

	public void setIsBreach(String isBreach)
	{
		this.isBreach = isBreach;
	};

	// ============贷款到期时间 =================
	@Column(name="loan_date")
	public String getLoanDate()
	{
		return this.loanDate;
	};

	public void setLoanDate(String loanDate)
	{
		this.loanDate = loanDate;
	};

	// ============淘宝账户 =================
	@Column(name="taobao_account")
	public String getTaobaoAccount()
	{
		return this.taobaoAccount;
	};

	public void setTaobaoAccount(String taobaoAccount)
	{
		this.taobaoAccount = taobaoAccount;
	};

	// ============法定代表人 =================
	@Column(name="legal_person")
	public String getLegalPerson()
	{
		return this.legalPerson;
	};

	public void setLegalPerson(String legalPerson)
	{
		this.legalPerson = legalPerson;
	};

	// ============贷款期限 =================
	@Column(name="loan_timelimit")
	public String getLoanTimelimit()
	{
		return this.loanTimelimit;
	};

	public void setLoanTimelimit(String loanTimelimit)
	{
		this.loanTimelimit = loanTimelimit;
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
			 + ", arrears=" + arrears
			 + ", isBreach=" + isBreach
			 + ", loanDate=" + loanDate
			 + ", taobaoAccount=" + taobaoAccount
			 + ", legalPerson=" + legalPerson
			 + ", loanTimelimit=" + loanTimelimit
			 + ", name=" + name
			 + ", sex=" + sex
			 + ", age=" + age
			 + ", identityDeparture=" + identityDeparture
			 + ", province=" + province
			 + ", addtime=" + addtime;
	};
};