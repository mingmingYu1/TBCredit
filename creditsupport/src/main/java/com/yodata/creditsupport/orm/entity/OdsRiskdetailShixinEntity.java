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
@Table(name ="ods_riskdetail_shixin", catalog="credit_db")
public class OdsRiskdetailShixinEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============失信公告ID =================
	private String shixinid;

	// ============立案时间 =================
	private String sorttime;

	// ============性别 =================
	private String sex;

	// ============被执行人的履行情况 =================
	private String lxqk;

	// ============执行依据文号 =================
	private String yjcode;

	// ============相关当事人 =================
	private String relatedparty;

	// ============执行法院名称 =================
	private String court;

	// ============身份证/组织机构代码 =================
	private String idcardno;

	// ============做出执行依据单位 =================
	private String yjdw;

	// ============失信被执行人行为具体情形 =================
	private String jtqx;

	// ============生效法律文书确定的义务 =================
	private String yiwu;

	// ============年龄 =================
	private Integer age;

	// ============被执行人姓名 =================
	private String pname;

	// ============省份 =================
	private String province;

	// ============案号 =================
	private String caseno;

	// ============发布时间 =================
	private String posttime;

	// ============ =================
	private Timestamp addtime;

	// ============失信公告ID =================
	@Id
	@Column(name="shixinId")
	public String getShixinid()
	{
		return this.shixinid;
	};

	public void setShixinid(String shixinid)
	{
		this.shixinid = shixinid;
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

	// ============被执行人的履行情况 =================
	@Column(name="lxqk")
	public String getLxqk()
	{
		return this.lxqk;
	};

	public void setLxqk(String lxqk)
	{
		this.lxqk = lxqk;
	};

	// ============执行依据文号 =================
	@Column(name="yjCode")
	public String getYjcode()
	{
		return this.yjcode;
	};

	public void setYjcode(String yjcode)
	{
		this.yjcode = yjcode;
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

	// ============做出执行依据单位 =================
	@Column(name="yjdw")
	public String getYjdw()
	{
		return this.yjdw;
	};

	public void setYjdw(String yjdw)
	{
		this.yjdw = yjdw;
	};

	// ============失信被执行人行为具体情形 =================
	@Column(name="jtqx")
	public String getJtqx()
	{
		return this.jtqx;
	};

	public void setJtqx(String jtqx)
	{
		this.jtqx = jtqx;
	};

	// ============生效法律文书确定的义务 =================
	@Column(name="yiwu")
	public String getYiwu()
	{
		return this.yiwu;
	};

	public void setYiwu(String yiwu)
	{
		this.yiwu = yiwu;
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

	// ============发布时间 =================
	@Column(name="postTime")
	public String getPosttime()
	{
		return this.posttime;
	};

	public void setPosttime(String posttime)
	{
		this.posttime = posttime;
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
		 return "shixinid=" + shixinid
			 + ", sorttime=" + sorttime
			 + ", sex=" + sex
			 + ", lxqk=" + lxqk
			 + ", yjcode=" + yjcode
			 + ", relatedparty=" + relatedparty
			 + ", court=" + court
			 + ", idcardno=" + idcardno
			 + ", yjdw=" + yjdw
			 + ", jtqx=" + jtqx
			 + ", yiwu=" + yiwu
			 + ", age=" + age
			 + ", pname=" + pname
			 + ", province=" + province
			 + ", caseno=" + caseno
			 + ", posttime=" + posttime
			 + ", addtime=" + addtime;
	};
};