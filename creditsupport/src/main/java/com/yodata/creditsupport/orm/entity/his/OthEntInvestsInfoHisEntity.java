package com.yodata.creditsupport.orm.entity.his;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 企业对外投资信息  -- 历史
 */
@Entity
@Table(name ="ods_oth_ent_invests_info_his", catalog="credit_db")
public class OthEntInvestsInfoHisEntity implements Serializable {
	
	private static final long serialVersionUID = 5436126933277627236L;
	
	private final DecimalFormat df = new DecimalFormat("0.00%");
	
	private Integer id;				// 自增主键
	private String regId;		// 企业ID
	private String fileNo;			// 文件编号
	private Date createTime;		// 生成时间
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
	
	public OthEntInvestsInfoHisEntity() {
	}
	public OthEntInvestsInfoHisEntity(String fileNo, Date createTime) {
		this.fileNo = fileNo;
		this.createTime = createTime;
	}
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
}
