package com.yodata.creditsupport.orm.entity.his;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yodata.creditsupport.orm.entity.MerchantTrandeReportStability;

@Entity
@Table(name = "ods_merchant_trade_report_stability_info_his", catalog = "credit_db")
public class MerchantTrandeReportStabilityHis implements Serializable{

	private static final long serialVersionUID = -8352221164889072127L;
	
	private Integer id;

	// =============== 工商注册号 =================
	private String regId;

	// =============== 流水号 =================
	private String serialNo;

	// =============== 低于周均交易金额的周数 =================
	private String weekLowThanAvgCount;

	// =============== 最近的连续低于周均交易金额的周数 =================
	private String weekLatelyLowThanAvgCount;

	// =============== 交易额峰值常见旬 =================
	private String transAmountHighestTenDays;

	// =============== 周交易额中值 =================
	private String weekTransAmountMedian;

	// =============== 周均交易金额变异系数 =================
	private String weekTransAmountAvgCv;

	// =============== 周均交易笔数变异系数 =================
	private String weekTransCountAvgCv;

	// =============== 月均交易天数变异系数 =================
	private String weekTransDaysAvgCv;

	// =============== =================
	private Date addTime;

	private String fileNo;			// 文件编号
	private Date createTime;		// 生成时间
	
   public MerchantTrandeReportStabilityHis() {
		// TODO Auto-generated constructor stub
	}
	
   public MerchantTrandeReportStabilityHis(String fileNo,Date createTime) {
		// TODO Auto-generated constructor stub
	   this.fileNo = fileNo;
	   this.createTime = createTime;
	}
   
	@Column(name="FILE_NO")
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	@Column(name="CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	// =============== 自增主键 =================
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
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

	// =============== 低于周均交易金额的周数 =================
	@Column(name = "WEEK_LOW_THAN_AVG_COUNT")
	public String getWeekLowThanAvgCount() {
		return this.weekLowThanAvgCount;
	}

	public void setWeekLowThanAvgCount(String weekLowThanAvgCount) {
		this.weekLowThanAvgCount = weekLowThanAvgCount;
	}

	// =============== 最近的连续低于周均交易金额的周数 =================
	@Column(name = "WEEK_LATELY_LOW_THAN_AVG_COUNT")
	public String getWeekLatelyLowThanAvgCount() {
		return this.weekLatelyLowThanAvgCount;
	}

	public void setWeekLatelyLowThanAvgCount(String weekLatelyLowThanAvgCount) {
		this.weekLatelyLowThanAvgCount = weekLatelyLowThanAvgCount;
	}

	// =============== 交易额峰值常见旬 =================
	@Column(name = "TRANS_AMOUNT_HIGHEST_TEN_DAYS")
	public String getTransAmountHighestTenDays() {
		return this.transAmountHighestTenDays;
	}

	public void setTransAmountHighestTenDays(String transAmountHighestTenDays) {
		this.transAmountHighestTenDays = transAmountHighestTenDays;
	}

	// =============== 周交易额中值 =================
	@Column(name = "WEEK_TRANS_AMOUNT_MEDIAN")
	public String getWeekTransAmountMedian() {
		return this.weekTransAmountMedian;
	}

	public void setWeekTransAmountMedian(String weekTransAmountMedian) {
		this.weekTransAmountMedian = weekTransAmountMedian;
	}

	// =============== 周均交易金额变异系数 =================
	@Column(name = "WEEK_TRANS_AMOUNT_AVG_CV")
	public String getWeekTransAmountAvgCv() {
		return this.weekTransAmountAvgCv;
	}

	public void setWeekTransAmountAvgCv(String weekTransAmountAvgCv) {
		this.weekTransAmountAvgCv = weekTransAmountAvgCv;
	}

	// =============== 周均交易笔数变异系数 =================
	@Column(name = "WEEK_TRANS_COUNT_AVG_CV")
	public String getWeekTransCountAvgCv() {
		return this.weekTransCountAvgCv;
	}

	public void setWeekTransCountAvgCv(String weekTransCountAvgCv) {
		this.weekTransCountAvgCv = weekTransCountAvgCv;
	}

	// =============== 月均交易天数变异系数 =================
	@Column(name = "WEEK_TRANS_DAYS_AVG_CV")
	public String getWeekTransDaysAvgCv() {
		return this.weekTransDaysAvgCv;
	}

	public void setWeekTransDaysAvgCv(String weekTransDaysAvgCv) {
		this.weekTransDaysAvgCv = weekTransDaysAvgCv;
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
	public String toString() {
		return "AgentChangeEntity [id=" + id + ", regId=" + regId + ", serialNo=" + serialNo + "]";
	}

}
