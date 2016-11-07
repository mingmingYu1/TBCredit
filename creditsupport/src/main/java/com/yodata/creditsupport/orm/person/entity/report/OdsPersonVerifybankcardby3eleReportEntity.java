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
@Table(name ="ods_person_verifybankcardby3ele_report", catalog="credit_db")
public class OdsPersonVerifybankcardby3eleReportEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============自增主键 =================
	private Integer id;

	// ============创建时间 =================
	private Date createTime;

	// ============文件编号 =================
	private String fileNo;

	// ============姓名 =================
	private String name;

	// ============银行账户 =================
	private String accountno;

	// ============身份证号码  =================
	private String idcardnum;

	// ============银行预留手机号 =================
	private String bankpremobile;

	// ============认证结果：t为成功，f为失败,d为不支持的银行或无法验证 =================
	private String result;

	// ============描述信息 =================
	private String message;

	// ============ =================
	private Timestamp addtime;

	public OdsPersonVerifybankcardby3eleReportEntity(){}
	
	public OdsPersonVerifybankcardby3eleReportEntity(String fileNo, Date createTime)
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

	// ============银行账户 =================
	@Column(name="accountno")
	public String getAccountno()
	{
		return this.accountno;
	};

	public void setAccountno(String accountno)
	{
		this.accountno = accountno;
	};

	// ============身份证号码  =================
	@Column(name="idcardnum")
	public String getIdcardnum()
	{
		return this.idcardnum;
	};

	public void setIdcardnum(String idcardnum)
	{
		this.idcardnum = idcardnum;
	};

	// ============银行预留手机号 =================
	@Column(name="bankpremobile")
	public String getBankpremobile()
	{
		return this.bankpremobile;
	};

	public void setBankpremobile(String bankpremobile)
	{
		this.bankpremobile = bankpremobile;
	};

	// ============认证结果：t为成功，f为失败,d为不支持的银行或无法验证 =================
	@Column(name="result")
	public String getResult()
	{
		return this.result;
	};

	public void setResult(String result)
	{
		this.result = result;
	};

	// ============描述信息 =================
	@Column(name="message")
	public String getMessage()
	{
		return this.message;
	};

	public void setMessage(String message)
	{
		this.message = message;
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
			 + ", name=" + name
			 + ", accountno=" + accountno
			 + ", idcardnum=" + idcardnum
			 + ", bankpremobile=" + bankpremobile
			 + ", result=" + result
			 + ", message=" + message
			 + ", addtime=" + addtime;
	};
};