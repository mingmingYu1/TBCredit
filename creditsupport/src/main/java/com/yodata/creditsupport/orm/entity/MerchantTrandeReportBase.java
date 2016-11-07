package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 核心经营指标信息及经营稳定性指标信息
 */
@Entity
@Table(name = "ods_merchant_trade_report_base_info", catalog = "credit_db")
public class MerchantTrandeReportBase implements Serializable {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 6851839307867539396L;

	// =============== 自增主键 =================
	private Integer id;

	// =============== 工商注册号 =================
	private String regId;

	// =============== 流水号 =================
	private String serialNo;

	// =============== 商户名称 =================
	private String mName;

	// =============== 商户编号 =================
	private String mid;

	// =============== 营业执照注册编号 =================
	private String busincessCode;

	// =============== 负责人姓名 =================
	private String name;

	// =============== 负责人手机号码 =================
	private String mobile;

	// =============== 负责人身份证号码 =================
	private String cid;

	// =============== 月还贷能力区间 =================
	private String repaymentAbility;

	// =============== 首次交易日期 =================
	private Date firstTransDate;

	// =============== 交易总金额 =================
	private String transAmountTotal;

	// =============== 交易总笔数 =================
	private String transCount;

	// =============== 交易总人数 =================
	private String transPersonCount;

	// =============== 周均交易金额 =================
	private String weekTransAmountAvg;

	// =============== 周均交易笔数 =================
	private String weekTransCountAvg;

	// =============== 月均交易天数 =================
	private String monthDaysAvg;

	// =============== 笔单价 =================
	private String countPrice;

	// =============== 客单价 =================
	private String personPrice;

	// =============== =================
	private Date addTime;

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

	// =============== 商户名称 =================
	@Column(name = "M_NAME")
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}


	// =============== 商户编号 =================
	@Column(name = "MID")
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}

	// =============== 营业执照注册编号 =================
	@Column(name = "BUSINCESS_CODE")
	public String getBusincessCode() {
		return busincessCode;
	}
	public void setBusincessCode(String busincessCode) {
		this.busincessCode = busincessCode;
	}

	// =============== 负责人姓名 =================
	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// =============== 负责人手机号码 =================
	@Column(name = "MOBILE")
	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	// =============== 负责人身份证号码 =================
	@Column(name = "CID")
	public String getCid() {
		return this.cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}

	// =============== 月还贷能力区间 =================
	@Column(name = "REPAYMENT_ABILITY")
	public String getRepaymentAbility() {
		return this.repaymentAbility;
	}
	public void setRepaymentAbility(String repaymentAbility) {
		this.repaymentAbility = repaymentAbility;
	}

	// =============== 首次交易日期 =================
	@Column(name = "FIRST_TRANS_DATE")
	public Date getFirstTransDate() {
		return this.firstTransDate;
	}
	public void setFirstTransDate(Date firstTransDate) {
		this.firstTransDate = firstTransDate;
	}
	
	// =============== 交易总金额 =================
	@Column(name = "TRANS_AMOUNT_TOTAL")
	public String getTransAmountTotal() {
	        //将总金额转换成百万
		return this.transAmountTotal;
	}

	public void setTransAmountTotal(String transAmountTotal) {
		this.transAmountTotal = transAmountTotal;
	}
	
	public void setTransCount(String transCount) {
		this.transCount = transCount;
	}

	// =============== 交易总笔数 =================
	@Column(name = "TRANS_COUNT")
	public String getTransCount() {
		return this.transCount;
	}

	public void setTransPersonCount(String transPersonCount) {
		this.transPersonCount = transPersonCount;
	}

	// =============== 交易总人数 =================
	@Column(name = "TRANS_PERSON_COUNT")
	public String getTransPersonCount() {
		return this.transPersonCount;
	}

	public void setWeekTransAmountAvg(String weekTransAmountAvg) {
		this.weekTransAmountAvg = weekTransAmountAvg;
	}

	// =============== 周均交易金额 =================
	@Column(name = "WEEK_TRANS_Amount_AVG")
	public String getWeekTransAmountAvg() {
		return this.weekTransAmountAvg;
	}

	public void setWeekTransCountAvg(String weekTransCountAvg) {
		this.weekTransCountAvg = weekTransCountAvg;
	}

	// =============== 周均交易笔数 =================
	@Column(name = "WEEK_TRANS_COUNT_AVG")
	public String getWeekTransCountAvg() {
		return this.weekTransCountAvg;
	}

	public void setMonthDaysAvg(String monthDaysAvg) {
		this.monthDaysAvg = monthDaysAvg;
	}

	// =============== 月均交易天数 =================
	@Column(name = "MONTH_DAYS_AVG")
	public String getMonthDaysAvg() {
		return this.monthDaysAvg;
	}

	public void setCountPrice(String countPrice) {
		this.countPrice = countPrice;
	}

	// =============== 笔单价 =================
	@Column(name = "COUNT_PRICE")
	public String getCountPrice() {
		return this.countPrice;
	}

	public void setPersonPrice(String personPrice) {
		this.personPrice = personPrice;
	}

	// =============== 客单价 =================
	@Column(name = "PERSON_PRICE")
	public String getPersonPrice() {
		return this.personPrice;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	// =============== =================
	@Column(name = "ADD_TIME")
	public Date getAddTime() {
		return this.addTime;
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
		MerchantTrandeReportBase other = (MerchantTrandeReportBase) obj;
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
}
