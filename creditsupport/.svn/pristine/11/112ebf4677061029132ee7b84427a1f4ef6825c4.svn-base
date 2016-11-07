package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 股东信息
 */
@Entity
@Table(name ="ods_stockholder_info", catalog="credit_db")
public class StockholderInfoEntity implements Serializable {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 6851839307867539396L;
	
	private final DecimalFormat df = new DecimalFormat("0.00%");
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private Integer id;				// 自增主键
	private String regId;	// 企业注册号
	private String name;			// 名称
	private Double cashCon;			// 出资额
	private Double cashRate;		// 出资比例
	private String curType;		// 币种
	private Date conDate;		// 出资日期
	
	private String cashRateStr; 	// 出资比例字符串
	private String conDateStr;		// 日期格式化字符
	private String curTypeName;     //货币种类中文名称
	private String cashConStr;		//出资额千分位
	
	private String identifyType; 	//证件类型
	private String identifyNo; 		//证件号码
	private String address;			//住址
	private String country;			//国别
	
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
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="cash_con", precision = 18, scale = 2)
	public Double getCashCon() {
		return cashCon;
	}
	public void setCashCon(Double cashCon) {
		this.cashCon = cashCon;
	}
	
	@Column(name="cash_rate", precision = 6, scale = 4)
	public Double getCashRate() {
		return cashRate;
	}
	public void setCashRate(Double cashRate) {
		this.cashRate = cashRate;
	}
	
	@Column(name="cur_type")
	public String getCurType() {
		return curType;
	}
	public void setCurType(String curType) {
		this.curType = curType;
	}
	
	@Column(name="con_date")
	public Date getConDate() {
		return conDate;
	}
	public void setConDate(Date conDate) {
		this.conDate = conDate;
	}
	
	@Column(name="IDENTIFY_TYPE")
	public String getIdentifyType() {
		return identifyType;
	}
	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}

	@Column(name="IDENTIFY_NO")
	public String getIdentifyNo() {
		return identifyNo;
	}
	public void setIdentifyNo(String identifyNo) {
		this.identifyNo = identifyNo;
	}
	
	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="COUNTRY")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
		
	@Transient
	public String getCashRateStr() {
		if(cashRate != null) {
			cashRateStr = df.format(cashRate);
		}
		return cashRateStr;
	}
	public void setCashRateStr(String cashRateStr) {
		this.cashRateStr = cashRateStr;
	}
	@Transient
	public String getConDateStr() {
		if(conDate != null) {
			conDateStr = sdf.format(conDate);
		}
		return conDateStr;
	}
	public void setConDateStr(String conDateStr) {
		this.conDateStr = conDateStr;
	}
	@Transient
    public String getCurTypeName() {
		return curTypeName;
	}
	public void setCurTypeName(String curTypeName) {
		this.curTypeName = curTypeName;
	}
	@Transient
	public String getCashConStr() {
		if(this.cashCon == null || this.cashCon == 0.0d) {
			cashConStr = "0";
		} else {
			cashConStr = DecimalFormat.getNumberInstance().format(this.cashCon.intValue());
		}
		return cashConStr;
	}
	public void setCashConStr(String cashConStr) {
		this.cashConStr = cashConStr;
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
		StockholderInfoEntity other = (StockholderInfoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StockholderInfoEntity [id=" + id + ", regId=" + regId + ", name=" + name + ", cashCon="
				+ cashCon + ", cashRate=" + cashRate + ", curType=" + curType + ", conDate=" + conDate + "]";
	}
}
