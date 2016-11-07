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

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.yodata.creditsupport.util.BigNumUtil;

/**
 * 本市同行业对比信息
 */
@Entity
@Table(name = "ods_merchant_trade_report_constrast_info", catalog = "credit_db")
public class MerchantTrandeReportConstrast implements Serializable {

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

    // =============== 月 =================
    private String month;

    // =============== 月交易金额 =================
    private String monthAmount;

    // =============== 月交易金额在本市同行业中的排名 =================
    private String monthAmountRank;

    // =============== 月交易笔数 =================
    private String monthCount;

    // =============== 月交易笔数在本市同行业中的排名 =================
    private String monthCountRank;

    // =============== =================
    private Date addTime;

    // =============== 自增主键 =================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    // =============== 工商注册号 =================
    @Id
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

    // =============== 月 =================
    @Column(name = "MONTH")
    public String getMonth() {
	return this.month;
    }

    public void setMonth(String month) {
	this.month = month;
    }

    // =============== 月交易金额 =================
    @Column(name = "MONTH_AMOUNT")
    public String getMonthAmount() {
        try {
            if(StringUtils.isNotEmpty(this.monthAmount) 
                    && (this.monthAmount.contains("E") || this.monthAmount.contains("e"))){
                this.monthAmount = String.format("%.2f", Double.parseDouble(this.monthAmount));
            }
        } catch (NumberFormatException ne) {
            //转换失败后显示原字符串
        }
        return this.monthAmount;
    }

    public void setMonthAmount(String monthAmount) {
	this.monthAmount = monthAmount;
    }

    // =============== 月交易金额在本市同行业中的排名 =================
    @Column(name = "MONTH_AMOUNT_RANK")
    public String getMonthAmountRank() {
	return this.monthAmountRank;
    }

    public void setMonthAmountRank(String monthAmountRank) {
	this.monthAmountRank = monthAmountRank;
    }

    // =============== 月交易笔数 =================
    @Column(name = "MONTH_COUNT")
    public String getMonthCount() {
	return this.monthCount;
    }

    public void setMonthCount(String monthCount) {
	this.monthCount = monthCount;
    }

    // =============== 月交易笔数在本市同行业中的排名 =================
    @Column(name = "MONTH_COUNT_RANK")
    public String getMonthCountRank() {
	return this.monthCountRank;
    }

    public void setMonthCountRank(String monthCountRank) {
	this.monthCountRank = monthCountRank;
    }

    // =============== =================
    @Column(name = "ADD_TIME")
    public Date getAddTime() {
	return this.addTime;
    }

    public void setAddTime(Date addTime)

    {
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
	MerchantTrandeReportConstrast other = (MerchantTrandeReportConstrast) obj;
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

    // =============== 月交易金额 =================
    @Transient
    public String getMonthAmountStr() {
	return BigNumUtil.convert2Million(this.monthAmount);
    }
}
