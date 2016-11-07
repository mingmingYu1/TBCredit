package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 信用记录表
 */
@Entity
@Table(name ="ods_credit_info", catalog="credit_db")
public class CreditInfoEntity implements Serializable {

	private static final long serialVersionUID = 4720634575018246111L;
	
	private Integer id;				// 自增主键
	private String regId;			// 企业ID号
	private Integer lperCreRec;		// 企业负责人贷款记录（指标统计24个月内逾期天数）
	private Integer lperCrecardRec;	// 企业负责人信用卡记录（指标统计24个月内逾期天数）
	private Integer entCreRec;		// 企业贷款记录（指标统计24个月内逾期天数）
	private Integer tradeRec;		// 同行业交易违规情况（指标统计违规次数）
	private Integer ryxRec;			// 融易行商旅贷逾期记录（指标统计24个月内逾期天数）
	private String historyRating;	// 历史评级
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="reg_id")
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	
	@Column(name="LPER_CRE_REC")
	public Integer getLperCreRec() {
		return lperCreRec;
	}
	public void setLperCreRec(Integer lperCreRec) {
		this.lperCreRec = lperCreRec;
	}
	
	@Column(name="LPER_CRECARD_REC")
	public Integer getLperCrecardRec() {
		return lperCrecardRec;
	}
	public void setLperCrecardRec(Integer lperCrecardRec) {
		this.lperCrecardRec = lperCrecardRec;
	}
	
	@Column(name="ENT_CRE_REC")
	public Integer getEntCreRec() {
		return entCreRec;
	}
	public void setEntCreRec(Integer entCreRec) {
		this.entCreRec = entCreRec;
	}
	
	@Column(name="TRADE_OUT_OF_LINE_REC")
	public Integer getTradeRec() {
		return tradeRec;
	}
	public void setTradeRec(Integer tradeRec) {
		this.tradeRec = tradeRec;
	}
	
	@Column(name="RYX_BUS_OVERDUE_REC")
	public Integer getRyxRec() {
		return ryxRec;
	}
	public void setRyxRec(Integer ryxRec) {
		this.ryxRec = ryxRec;
	}
	
	@Column(name="HISTORY_RATING")
	public String getHistoryRating() {
		return historyRating;
	}
	public void setHistoryRating(String historyRating) {
		this.historyRating = historyRating;
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
		CreditInfoEntity other = (CreditInfoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CreditInfoEntity [id=" + id + ", regId=" + regId + ", lperCreRec=" + lperCreRec + ", lperCrecardRec="
				+ lperCrecardRec + ", entCreRec=" + entCreRec + ", tradeRec=" + tradeRec + ", ryxRec=" + ryxRec
				+ ", historyRating=" + historyRating + "]";
	}
	
}
