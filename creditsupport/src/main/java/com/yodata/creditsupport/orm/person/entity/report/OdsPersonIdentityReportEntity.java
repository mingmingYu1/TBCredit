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
@Table(name ="ods_person_identity_report", catalog="credit_db")
public class OdsPersonIdentityReportEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============自增主键 =================
	private Integer id;

	// ============创建时间 =================
	private Date createTime;

	// ============文件编号 =================
	private String fileNo;

	// ============身份证号码 =================
	private String cardId;

	// ============姓名 =================
	private String name;

	// ============对比状态 1：一致2：不一致。3:库中无此号 =================
	private String compstatus;

	// ============对比结果，对应上述1、2，3的值 =================
	private String compresult;

	// ============ =================
	private Timestamp addtime;

	// ============自增主键 =================
	@Id
	@Column(name="ID")
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

	// ============身份证号码 =================
	@Column(name="card_id")
	public String getCardId()
	{
		return this.cardId;
	};

	public void setCardId(String cardId)
	{
		this.cardId = cardId;
	};

	// ============姓名 =================
	@Column(name="name")
	public String getName()
	{
		return this.name;
	};

	public void setName(String name)
	{
		this.name = name;
	};

	// ============对比状态 1：一致2：不一致。3:库中无此号 =================
	@Column(name="compstatus")
	public String getCompstatus()
	{
		return this.compstatus;
	};

	public void setCompstatus(String compstatus)
	{
		this.compstatus = compstatus;
	};

	// ============对比结果，对应上述1、2，3的值 =================
	@Column(name="compresult")
	public String getCompresult()
	{
		return this.compresult;
	};

	public void setCompresult(String compresult)
	{
		this.compresult = compresult;
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
			 + ", compstatus=" + compstatus
			 + ", compresult=" + compresult
			 + ", addtime=" + addtime;
	};
};