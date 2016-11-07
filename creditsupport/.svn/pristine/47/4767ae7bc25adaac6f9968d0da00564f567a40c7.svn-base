package com.yodata.creditsupport.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author lenovo
 * 
 * 利润表
 *
 */

@Entity
@Table(name ="ods_profit", catalog="credit_db")
public class OdsProfitEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============自定义主键 =================
	private Integer id;

	// ============流水号 =================
	private String serialNo;

	// ============工商注册号 =================
	private String regId;

	// ============项目 =================
	private String item;

	// ============上期金额 =================
	private Double preAmount;

	// ============本期金额 =================
	private Double curAmount;

	// ============ =================
	private Timestamp addTime;

	// ============自定义主键 =================
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false)
	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	// ============流水号 =================
	@Column(name="serial_no")
	public String getSerialNo()
	{
		return this.serialNo;
	}

	public void setSerialNo(String serialNo)
	{
		this.serialNo = serialNo;
	}

	// ============工商注册号 =================
	@Column(name="reg_id")
	public String getRegId()
	{
		return this.regId;
	}

	public void setRegId(String regId)
	{
		this.regId = regId;
	}

	// ============项目 =================
	@Column(name="item")
	public String getItem()
	{
		return this.item;
	}

	public void setItem(String item)
	{
		this.item = item;
	}

	// ============上期金额 =================
	@Column(name="pre_amount")
	public Double getPreAmount()
	{
		return this.preAmount;
	}

	public void setPreAmount(Double preAmount)
	{
		this.preAmount = preAmount;
	}

	// ============本期金额 =================
	@Column(name="cur_amount")
	public Double getCurAmount()
	{
		return this.curAmount;
	}

	public void setCurAmount(Double curAmount)
	{
		this.curAmount = curAmount;
	}

	// ============ =================
	@Column(name="add_time")
	public Timestamp getAddTime()
	{
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime)
	{
		this.addTime = addTime;
	}


}