package com.yodata.creditsupport.orm.person.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
* @Description: 银行三要素认证
* @author Jason
* @date 2016年7月13日 上午11:05:29
*
 */

@Entity
@Table(name ="ods_person_verifybankcardby3ele", catalog="credit_db")
public class OdsPersonVerifybankcardby3eleEntity implements Serializable {

	private static final long serialVersionUID = 1L;

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

	// ============姓名 =================
	@Id
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
		 return "name=" + name
			 + ", accountno=" + accountno
			 + ", idcardnum=" + idcardnum
			 + ", bankpremobile=" + bankpremobile
			 + ", result=" + result
			 + ", message=" + message
			 + ", addtime=" + addtime;
	};
};