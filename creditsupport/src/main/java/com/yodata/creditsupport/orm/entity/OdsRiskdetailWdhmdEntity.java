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
@Table(name ="ods_riskdetail_wdhmd", catalog="credit_db")
public class OdsRiskdetailWdhmdEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============网贷黑名单ID =================
	private String wdhmdid;

	// ============贷款时间 =================
	private String sorttime;

	// ============内容 =================
	private String body;

	// ============性别 =================
	private String sex;

	// ============居住电话 =================
	private String phone;

	// ============信息更新时间 =================
	private String updatetime;

	// ============执行法院 =================
	private String execcourt;

	// ============相关当事人 =================
	private String relatedparty;

	// ============未还/罚息 =================
	private String whfx;

	// ============身份证号 =================
	private String idcardno;

	// ============籍贯地址 =================
	private String birthplace;

	// ============本金/本息 =================
	private String bjbx;

	// ============案号 =================
	private String casecode;

	// ============居住地址 =================
	private String address;

	// ============邮箱地址 =================
	private String email;

	// ============来源单位名称 =================
	private String sourcename;

	// ============年龄 =================
	private Integer age;

	// ============姓名 =================
	private String pname;

	// ============数据源 =================
	private String datasource;

	// ============已还金额 =================
	private Double yhje;

	// ============手机号 =================
	private String mobile;

	// ============ =================
	private Timestamp addtime;

	// ============网贷黑名单ID =================
	@Id
	@Column(name="wdhmdId")
	public String getWdhmdid()
	{
		return this.wdhmdid;
	};

	public void setWdhmdid(String wdhmdid)
	{
		this.wdhmdid = wdhmdid;
	};

	// ============贷款时间 =================
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

	// ============居住电话 =================
	@Column(name="phone")
	public String getPhone()
	{
		return this.phone;
	};

	public void setPhone(String phone)
	{
		this.phone = phone;
	};

	// ============信息更新时间 =================
	@Column(name="updateTime")
	public String getUpdatetime()
	{
		return this.updatetime;
	};

	public void setUpdatetime(String updatetime)
	{
		this.updatetime = updatetime;
	};

	// ============执行法院 =================
	@Column(name="execCourt")
	public String getExeccourt()
	{
		return this.execcourt;
	};

	public void setExeccourt(String execcourt)
	{
		this.execcourt = execcourt;
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

	// ============未还/罚息 =================
	@Column(name="whfx")
	public String getWhfx()
	{
		return this.whfx;
	};

	public void setWhfx(String whfx)
	{
		this.whfx = whfx;
	};

	// ============身份证号 =================
	@Column(name="idcardNo")
	public String getIdcardno()
	{
		return this.idcardno;
	};

	public void setIdcardno(String idcardno)
	{
		this.idcardno = idcardno;
	};

	// ============籍贯地址 =================
	@Column(name="birthPlace")
	public String getBirthplace()
	{
		return this.birthplace;
	};

	public void setBirthplace(String birthplace)
	{
		this.birthplace = birthplace;
	};

	// ============本金/本息 =================
	@Column(name="bjbx")
	public String getBjbx()
	{
		return this.bjbx;
	};

	public void setBjbx(String bjbx)
	{
		this.bjbx = bjbx;
	};

	// ============案号 =================
	@Column(name="caseCode")
	public String getCasecode()
	{
		return this.casecode;
	};

	public void setCasecode(String casecode)
	{
		this.casecode = casecode;
	};

	// ============居住地址 =================
	@Column(name="address")
	public String getAddress()
	{
		return this.address;
	};

	public void setAddress(String address)
	{
		this.address = address;
	};

	// ============邮箱地址 =================
	@Column(name="email")
	public String getEmail()
	{
		return this.email;
	};

	public void setEmail(String email)
	{
		this.email = email;
	};

	// ============来源单位名称 =================
	@Column(name="sourceName")
	public String getSourcename()
	{
		return this.sourcename;
	};

	public void setSourcename(String sourcename)
	{
		this.sourcename = sourcename;
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

	// ============数据源 =================
	@Column(name="datasource")
	public String getDatasource()
	{
		return this.datasource;
	};

	public void setDatasource(String datasource)
	{
		this.datasource = datasource;
	};

	// ============已还金额 =================
	@Column(name="yhje")
	public Double getYhje()
	{
		return this.yhje;
	};

	public void setYhje(Double yhje)
	{
		this.yhje = yhje;
	};

	// ============手机号 =================
	@Column(name="mobile")
	public String getMobile()
	{
		return this.mobile;
	};

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
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
		 return "wdhmdid=" + wdhmdid
			 + ", sorttime=" + sorttime
			 + ", body=" + body
			 + ", sex=" + sex
			 + ", phone=" + phone
			 + ", updatetime=" + updatetime
			 + ", execcourt=" + execcourt
			 + ", relatedparty=" + relatedparty
			 + ", whfx=" + whfx
			 + ", idcardno=" + idcardno
			 + ", birthplace=" + birthplace
			 + ", bjbx=" + bjbx
			 + ", casecode=" + casecode
			 + ", address=" + address
			 + ", email=" + email
			 + ", sourcename=" + sourcename
			 + ", age=" + age
			 + ", pname=" + pname
			 + ", datasource=" + datasource
			 + ", yhje=" + yhje
			 + ", mobile=" + mobile
			 + ", addtime=" + addtime;
	};
};