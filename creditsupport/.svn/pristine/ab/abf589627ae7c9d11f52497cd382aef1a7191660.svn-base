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
@Table(name ="ods_riskdetail_cpws_party", catalog="credit_db")
public class OdsRiskdetailCpwsPartyEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============裁判文书ID =================
	private String cpwsid;

	// ============当事人生日 =================
	private String birthday;

	// ============当事人称号 =================
	private String title;

	// ============当事人类型 =================
	private String partytype;

	// ============律师事务所 =================
	private String lawoffice;

	// ============地址 =================
	private String address;

	// ============当事人立场 =================
	private String status;

	// ============当事人名称 =================
	private String pname;

	// ============当事人身份证号码 =================
	private String idcardno;

	// ============委托辩护人 =================
	private String lawyer;

	// ============ =================
	private Timestamp addtime;

	private Integer id;
	
	/**
	 * @return id
	 */
	@Id
	@Column(name="ID")
	public Integer getId() {
	    return id;
	}

	/**
	 * @param id 要设置的 id
	 */
	public void setId(Integer id) {
	    this.id = id;
	}

	// ============裁判文书ID =================
	
	@Column(name="cpwsId")
	public String getCpwsid()
	{
		return this.cpwsid;
	};

	public void setCpwsid(String cpwsid)
	{
		this.cpwsid = cpwsid;
	};

	// ============当事人生日 =================
	@Column(name="birthday")
	public String getBirthday()
	{
		return this.birthday;
	};

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	};

	// ============当事人称号 =================
	@Column(name="title")
	public String getTitle()
	{
		return this.title;
	};

	public void setTitle(String title)
	{
		this.title = title;
	};

	// ============当事人类型 =================
	@Column(name="partytype")
	public String getPartytype()
	{
		return this.partytype;
	};

	public void setPartytype(String partytype)
	{
		this.partytype = partytype;
	};

	// ============律师事务所 =================
	@Column(name="lawOffice")
	public String getLawoffice()
	{
		return this.lawoffice;
	};

	public void setLawoffice(String lawoffice)
	{
		this.lawoffice = lawoffice;
	};

	// ============地址 =================
	@Column(name="address")
	public String getAddress()
	{
		return this.address;
	};

	public void setAddress(String address)
	{
		this.address = address;
	};

	// ============当事人立场 =================
	@Column(name="status")
	public String getStatus()
	{
		return this.status;
	};

	public void setStatus(String status)
	{
		this.status = status;
	};

	// ============当事人名称 =================
	@Column(name="pname")
	public String getPname()
	{
		return this.pname;
	};

	public void setPname(String pname)
	{
		this.pname = pname;
	};

	// ============当事人身份证号码 =================
	@Column(name="idcardNo")
	public String getIdcardno()
	{
		return this.idcardno;
	};

	public void setIdcardno(String idcardno)
	{
		this.idcardno = idcardno;
	};

	// ============委托辩护人 =================
	@Column(name="lawyer")
	public String getLawyer()
	{
		return this.lawyer;
	};

	public void setLawyer(String lawyer)
	{
		this.lawyer = lawyer;
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
			 + ", birthday=" + birthday
			 + ", title=" + title
			 + ", partytype=" + partytype
			 + ", lawoffice=" + lawoffice
			 + ", address=" + address
			 + ", status=" + status
			 + ", pname=" + pname
			 + ", idcardno=" + idcardno
			 + ", lawyer=" + lawyer
			 + ", addtime=" + addtime;
	};
};