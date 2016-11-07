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
@Table(name ="ods_riskdetail_fygg", catalog="credit_db")
public class OdsRiskdetailFyggEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============法院公告ID =================
	private String fyggid;

	// ============发布时间 =================
	private String sorttime;

	// ============内容 =================
	private String body;

	// ============版面 =================
	private String layout;

	// ============相关当事人 =================
	private String relatedparty;

	// ============姓名 =================
	private String pname;

	// ============法院名称 =================
	private String court;

	// ============公告类型 =================
	private String ggtype;

	// ============ =================
	private Timestamp addtime;

	// ============法院公告ID =================
	@Id
	@Column(name="fyggId")
	public String getFyggid()
	{
		return this.fyggid;
	};

	public void setFyggid(String fyggid)
	{
		this.fyggid = fyggid;
	};

	// ============发布时间 =================
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

	// ============版面 =================
	@Column(name="layout")
	public String getLayout()
	{
		return this.layout;
	};

	public void setLayout(String layout)
	{
		this.layout = layout;
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

	// ============公告类型 =================
	@Column(name="ggType")
	public String getGgtype()
	{
		return this.ggtype;
	};

	public void setGgtype(String ggtype)
	{
		this.ggtype = ggtype;
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
		 return "fyggid=" + fyggid
			 + ", sorttime=" + sorttime
			 + ", body=" + body
			 + ", layout=" + layout
			 + ", relatedparty=" + relatedparty
			 + ", pname=" + pname
			 + ", court=" + court
			 + ", ggtype=" + ggtype
			 + ", addtime=" + addtime;
	};
};