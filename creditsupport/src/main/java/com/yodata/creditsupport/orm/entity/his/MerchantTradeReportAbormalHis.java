package com.yodata.creditsupport.orm.entity.his;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.yodata.creditsupport.util.BigNumUtil;
import com.yodata.creditsupport.util.Tools;

@Entity
@Table(name ="ods_merchant_trade_report_abnormal_info_his", catalog="credit_db")
public class MerchantTradeReportAbormalHis implements Serializable{

	private static final long serialVersionUID = 301403939458412911L;
	
	private Integer id;
	private String regId;	             // 企业注册号
	private String serialNo;              //流水号
	private String revrseTransAmount;     //反向交易金额
	private String peverseTransCount;      // 反向交易笔数
	private String top5TransAmount;        //交易金额前五客户的金额占比
	private String top5TransCountProp;     //交易金额前五客户的笔数占比
	private String creditCardTransAmount;   // 贷记卡的交易总金额
	private String creditCardTransCount;   //贷记卡的交易总笔数
	private String debitCardTransAmount;    //借记卡的交易总笔数
	private String debitCardTransCount;        //借记卡的交易总金额
	private String abnormalTimeTransCount;     //非正常时间的交易总笔数
	private String abnormalTimeTransAmout;     //非正常时间的交易总金额
	private String transFailedAmount;          //交易失败金额
	private String transFailedCount;         //交易失败笔数
	
	
	private String fileNo;			// 文件编号
	private Date createTime;		// 生成时间
	
	private String top5TransAmountStr;
	private String top5TransCountPropStr;
	
	
   @Transient
   public String getTop5TransAmountStr() {
	   if(top5TransAmount != null)
		   top5TransAmountStr = Tools.getPrecentStr(top5TransAmount);
		return top5TransAmountStr;
	}

	public void setTop5TransAmountStr(String top5TransAmountStr) {
		this.top5TransAmountStr = top5TransAmountStr;
	}

	@Transient
	public String getTop5TransCountPropStr() {
		if(top5TransCountProp != null)
			top5TransCountPropStr = Tools.getPrecentStr(top5TransCountProp);
		return top5TransCountPropStr;
	}

	public void setTop5TransCountPropStr(String top5TransCountPropStr) {
		this.top5TransCountPropStr = top5TransCountPropStr;
	}

public MerchantTradeReportAbormalHis() {}
	
   public MerchantTradeReportAbormalHis(String fileNo,Date createTime) 
   {
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
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
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
	
	@Column(name="SERIAL_NO")
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	@Column(name="REVERSE_TRANS_AMOUNT")
	public String getRevrseTransAmount() {
		return revrseTransAmount;
	}
	public void setRevrseTransAmount(String revrseTransAmount) {
		this.revrseTransAmount = revrseTransAmount;
	}
	
	@Column(name="REVERSE_TRANS_COUNT")
	public String getPeverseTransCount() {
		return peverseTransCount;
	}
	public void setPeverseTransCount(String peverseTransCount) {
		this.peverseTransCount = peverseTransCount;
	}
	
	@Column(name="TOP_5_TRANS_AMOUNT_PROP")
	public String getTop5TransAmount() {
		return top5TransAmount;
	}
	public void setTop5TransAmount(String top5TransAmount) {
		this.top5TransAmount = top5TransAmount;
	}
	
	@Column(name="TOP_5_TRANS_COUNT_PROP")
	public String getTop5TransCountProp() {
		return top5TransCountProp;
	}
	public void setTop5TransCountProp(String top5TransCountProp) {
		this.top5TransCountProp = top5TransCountProp;
	}
	
	@Column(name="CREDIT_CARD_TRANS_AMOUNT")
	public String getCreditCardTransAmount() {
		return creditCardTransAmount;
	}
	public void setCreditCardTransAmount(String creditCardTransAmount) {
		this.creditCardTransAmount = creditCardTransAmount;
	}
	
	@Column(name="CREDIT_CARD_TRANS_COUNT")
	public String getCreditCardTransCount() {
		return creditCardTransCount;
	}
	public void setCreditCardTransCount(String creditCardTransCount) {
		this.creditCardTransCount = creditCardTransCount;
	}
	
	@Column(name="DEBIT_CARD_TRANS_AMOUNT")
	public String getDebitCardTransAmount() {
		return debitCardTransAmount;
	}
	public void setDebitCardTransAmount(String debitCardTransAmount) {
		this.debitCardTransAmount = debitCardTransAmount;
	}
	
	@Column(name="DEBIT_CARD_TRANS_COUNT")
	public String getDebitCardTransCount() {
		return debitCardTransCount;
	}
	public void setDebitCardTransCount(String debitCardTransCount) {
		this.debitCardTransCount = debitCardTransCount;
	}
	
	@Column(name="ABNORMAL_TIME_TRANS_COUNT")
	public String getAbnormalTimeTransCount() {
		return abnormalTimeTransCount;
	}
	public void setAbnormalTimeTransCount(String abnormalTimeTransCount) {
		this.abnormalTimeTransCount = abnormalTimeTransCount;
	}
	
	@Column(name="ABNORMAL_TIME_TRANS_AMOUNT")
	public String getAbnormalTimeTransAmout() {
		return abnormalTimeTransAmout;
	}
	public void setAbnormalTimeTransAmout(String abnormalTimeTransAmout) {
		this.abnormalTimeTransAmout = abnormalTimeTransAmout;
	}
	
	@Column(name="TRANS_FAILED_AMOUNT")
	public String getTransFailedAmount() {
		return transFailedAmount;
	}
	public void setTransFailedAmount(String transFailedAmount) {
		this.transFailedAmount = transFailedAmount;
	}
	
	@Column(name="TRANS_FAILED_COUNT")
	public String getTransFailedCount() {
		return transFailedCount;
	}
	public void setTransFailedCount(String transFailedCount) {
		this.transFailedCount = transFailedCount;
	}
	
	@Transient
	public String getRevrseTransAmountStr(){
	    return BigNumUtil.convert2Million(this.revrseTransAmount);
	}
	
	@Transient
	public String getCreditCardTransAmountStr() {
		return BigNumUtil.convert2Million(creditCardTransAmount);
	}

}
