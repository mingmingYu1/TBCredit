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
 * 法人信息  -- 历史
 */
@Entity
@Table(name ="ods_leg_per_info_his", catalog="credit_db")
public class LegPerInfoHisEntity implements Serializable{

	private static final long serialVersionUID = 8198066043967396930L;
	private Integer id;				// 自增主键
	private String regId;		// 企业ID, 工商注册号
	private String fileNo;			// 文件编号
	private Date createTime;		// 生成时间
	private String orgName;			// 被投资机构名称
	private String orgSta;			// 投资机构状态
	private String position;		// 担任职务
	private Double regAssets;		// 注册资本
	private Double cashCon;			// 出资额
	private String entType;			// 企业类型
	private String regAuth;			// 登记机关
	private Integer type;			// 0/1 -- 法人其他机构任职信息/法人股权投资信息
	private String curType;			// 币种
	private String cashRate;		// 出资比例
	private Integer isLegal;		// 是否为法人  0/1 -- 否/是
	
	private String curTypeName;     //货币种类中文名称
	private String isLegalName;		// 是否为法人转换名称
	private String regAssetsStr;	//注册资本千分位
	private String cashConStr;		//出资额千分位
	
	private String regNo; //注册号
	private String enterpriseType; //企业类型
	private Date cancelTime; // 注销日期
	private Date revokeTime; // 吊销日期
	private String regOrgnization; //登记机关
	private Double subscribleCon;	//认缴出资额
	private String subscribleConCurType; //认缴出资币种
	private Date operationTime; //开业日期
	
	public LegPerInfoHisEntity() {
	}
	public LegPerInfoHisEntity(String fileNo, Date createTime) {
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
	@Column(name="org_name")
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	@Column(name="org_sta")
	public String getOrgSta() {
		return orgSta;
	}
	public void setOrgSta(String orgSta) {
		this.orgSta = orgSta;
	}
	
	@Column(name="position", length=30)
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Column(name="reg_assets", precision = 18, scale = 2)
	public Double getRegAssets() {
		return regAssets;
	}
	public void setRegAssets(Double regAssets) {
		this.regAssets = regAssets;
	}
	
	@Column(name="cash_con", precision = 18, scale = 2)
	public Double getCashCon() {
		return cashCon;
	}
	public void setCashCon(Double cashCon) {
		this.cashCon = cashCon;
	}
	
	@Column(name="ent_type")
	public String getEntType() {
		return entType;
	}
	public void setEntType(String entType) {
		this.entType = entType;
	}
	
	@Column(name="reg_auth", length=100)
	public String getRegAuth() {
		return regAuth;
	}
	public void setRegAuth(String regAuth) {
		this.regAuth = regAuth;
	}
	
	@Column(name="type")
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Column(name="cur_type")
	public String getCurType() {
		return curType;
	}
	public void setCurType(String curType) {
		this.curType = curType;
	}
	@Column(name="cash_rate")
	public String getCashRate() {
		return cashRate;
	}
	public void setCashRate(String cashRate) {
		this.cashRate = cashRate;
	}
	@Column(name="is_legal")
	public Integer getIsLegal() {
		return isLegal;
	}
	public void setIsLegal(Integer isLegal) {
		this.isLegal = isLegal;
	}
	@Column(name="REG_NO")
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	@Column(name="ENTERPRISE_TYPE")
	public String getEnterpriseType() {
		return enterpriseType;
	}
	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	
	@Column(name="CANCEL_TIME")
	public Date getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
	
	@Column(name="REVOKE_TIME")
	public Date getRevokeTime() {
		return revokeTime;
	}
	public void setRevokeTime(Date revokeTime) {
		this.revokeTime = revokeTime;
	}
	
	@Column(name="REG_ORGNIZATION")
	public String getRegOrgnization() {
		return regOrgnization;
	}
	public void setRegOrgnization(String regOrgnization) {
		this.regOrgnization = regOrgnization;
	}
	
	@Column(name="SUBSCRIBLE_CON")
	public Double getSubscribleCon() {
		return subscribleCon;
	}
	public void setSubscribleCon(Double subscribleCon) {
		this.subscribleCon = subscribleCon;
	}
	
	@Column(name="SUBSCRIBLE_CON_CUR_TYPE")
	public String getSubscribleConCurType() {
		return subscribleConCurType;
	}
	public void setSubscribleConCurType(String subscribleConCurType) {
		this.subscribleConCurType = subscribleConCurType;
	}
	
	@Column(name="OPERATION_TIME")
	public Date getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
	
	@Transient
    public String getCurTypeName() {
		return curTypeName;
	}
	public void setCurTypeName(String curTypeName) {
		this.curTypeName = curTypeName;
	}
	@Transient
	public String getIsLegalName() {
		return isLegalName;
	}
	public void setIsLegalName(String isLegalName) {
		this.isLegalName = isLegalName;
	}
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
}
