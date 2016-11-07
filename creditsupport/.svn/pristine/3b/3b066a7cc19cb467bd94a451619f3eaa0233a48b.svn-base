package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 企业对外投资信息
 */
@Entity
@Table(name ="ods_oth_ent_invests_info", catalog="credit_db")
public class OthEntInvestsInfoEntity implements Serializable {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 438278299516811183L;
	
	private final DecimalFormat df = new DecimalFormat("0.00%");
	
	private Integer id;				// 自增主键
	private String regId;		// 企业ID
	private String name;			// 企业信息
	private Double regAssets;		// 注册资本
	private Double cashRate;		// 出资比例
	
	private String cashRateStr; 	// 出资比例字符串
    private String regAssetsStr;	//注册资本千分位
	
	@Transient
	public String getRegAssetsStr() {
		if(this.regAssets == null || this.regAssets == 0.0d) {
			regAssetsStr = "0";
		} else {
			regAssetsStr = DecimalFormat.getNumberInstance().format(this.regAssets.intValue());
		}
		return regAssetsStr;
	}
	public void setRegAssetsStr(String regAssetsStr) {
		this.regAssetsStr = regAssetsStr;
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
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="reg_assets", precision = 18, scale = 2)
	public Double getRegAssets() {
		return regAssets;
	}
	public void setRegAssets(Double regAssets) {
		this.regAssets = regAssets;
	}
	
	@Column(name="cash_rate")
	public Double getCashRate() {
		return cashRate;
	}
	public void setCashRate(Double cashRate) {
		this.cashRate = cashRate;
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
		OthEntInvestsInfoEntity other = (OthEntInvestsInfoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OthEntInvestsInfoEntity [id=" + id + ", regId=" + regId + ", name=" + name + ", regAssets="
				+ regAssets + ", cashRate=" + cashRate + "]";
	}
}
