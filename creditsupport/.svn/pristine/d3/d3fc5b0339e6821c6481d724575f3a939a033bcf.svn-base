package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.yodata.creditsupport.util.BigNumUtil;
import com.yodata.creditsupport.util.Tools;


/**
 * 经营变化趋势信息
 */
@Entity
@Table(name = "ods_merchant_trade_report_change_info", catalog = "credit_db")
public class MerchantTrandeReportChange implements Serializable {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 6851839307867539396L;

	// 遍历所有的字段,columnMap
	// =============== 自增主键 =================
	private Integer id;

	// =============== 工商注册号 =================
	private String regId;

	// =============== 流水号 =================
	private String serialNo;

	// =============== 周 =================
	private String week;

	// =============== 交易金额周均增长率 =================
	private String weekTransAmountGrowthRate;

	// =============== 交易笔数周均增长率 =================
	private String weekTransCountGrowthRate;

	// =============== 每周交易金额 =================
	private String weekTransAmounts;

	// =============== 每周交易笔数 =================
	private String weekTransCounts;

	// =============== =================
	private Date addTime;
	
	private String weekTransAmountGrowthRateStr;
	private String weekTransCountGrowthRateStr;

	@Transient
	public String getWeekTransAmountGrowthRateStr() {
		if(weekTransAmountGrowthRate != null)
			weekTransAmountGrowthRateStr = Tools.getPrecentStr(weekTransAmountGrowthRate);
		return weekTransAmountGrowthRateStr;
	}

	public void setWeekTransAmountGrowthRateStr(String weekTransAmountGrowthRateStr) {
		this.weekTransAmountGrowthRateStr = weekTransAmountGrowthRateStr;
	}

	@Transient
	public String getWeekTransCountGrowthRateStr() {
		if(weekTransCountGrowthRate != null)
			weekTransCountGrowthRateStr = Tools.getPrecentStr(weekTransCountGrowthRate);
		return weekTransCountGrowthRateStr;
	}

	public void setWeekTransCountGrowthRateStr(String weekTransCountGrowthRateStr) {
		this.weekTransCountGrowthRateStr = weekTransCountGrowthRateStr;
	}

	// =============== 自增主键 =================
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// =============== 工商注册号 =================
	@Column(name = "REG_ID")
	public String getRegId() {
		return this.regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	// =============== 流水号 =================
	@Column(name = "SERIAL_NO")
	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	// =============== 周 =================
	@Column(name = "WEEK")
	public String getWeek() {
		return this.week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	// =============== 交易金额周均增长率 =================
	@Column(name = "WEEK_TRANS_AMOUNT_GROWTH_RATE")
	public String getWeekTransAmountGrowthRate() {
		return this.weekTransAmountGrowthRate;
	}

	public void setWeekTransAmountGrowthRate(String weekTransAmountGrowthRate) {
		this.weekTransAmountGrowthRate = weekTransAmountGrowthRate;
	}

	// =============== 交易笔数周均增长率 =================
	@Column(name = "WEEK_TRANS_COUNT_GROWTH_RATE")
	public String getWeekTransCountGrowthRate() {
		return this.weekTransCountGrowthRate;
	}

	public void setWeekTransCountGrowthRate(String weekTransCountGrowthRate) {
		this.weekTransCountGrowthRate = weekTransCountGrowthRate;
	}

	// =============== 每周交易金额 =================
	@Column(name = "WEEK_TRANS_AMOUNTS")
	public String getWeekTransAmounts() {
		return this.weekTransAmounts;
	}

	public void setWeekTransAmounts(String weekTransAmounts) {
		this.weekTransAmounts = weekTransAmounts;
	}

	// =============== 每周交易笔数 =================
	@Column(name = "WEEK_TRANS_COUNTS")
	public String getWeekTransCounts() {
		return this.weekTransCounts;
	}

	public void setWeekTransCounts(String weekTransCounts) {
		this.weekTransCounts = weekTransCounts;
	}

	// =============== =================
	@Column(name = "ADD_TIME")
	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MerchantTrandeReportChange other = (MerchantTrandeReportChange) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AgentChangeEntity [id=" + id + ", regId=" + regId + ", serialNo=" + serialNo + "]";
	}
	
	
	@Transient
	public String getWeekTransAmountsStr() {
		return BigNumUtil.convert2Million(this.weekTransAmounts);
	}
}
