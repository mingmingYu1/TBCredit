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

@Entity
@Table(name ="ods_leg_per_equity_his", catalog="credit_db")
public class OdsLegPerEquityHisEntity implements Serializable{

	private static final long serialVersionUID = -5353939563030711264L;

	// ============自增主键 =================
		private Integer id;

		// ============注册ID =================
		private String regId;

		// ============企业名称 =================
		private String entName;

		// ============注册资本 =================
		private Double regCap;

		// ============出资比率 =================
		private String cashRate;

		// ============法人姓名 =================
		private String name;

		// ============注册编号 =================
		private String regNo;

		// ============企业类型 =================
		private String entType;

		// ============币种 =================
		private String curType;

		// ============注销日期 =================
		private Date cancelTime;

		// ============吊销日期 =================
		private Date revokeTime;

		// ============登记机关 =================
		private String regOrg;

		// ============认缴出资币种 =================
		private String subscribeConCurType;

		// ============开业日期 =================
		private Date operationTime;

		// ============认缴出资额 =================
		private Double subConam;

		// ============机构状态 =================
		private String entStatus;

		private String fileNo;			// 文件编号
		private Date createTime;		// 生成时间
		
		private String cashConStr;		//出资额千分位
		private String regAssetsStr;	//注册资本千分位
		
		private String curTypeName;     //货币种类中文名称
		
		@Transient
	    public String getCurTypeName() {
			return curTypeName;
		}
		public void setCurTypeName(String curTypeName) {
			this.curTypeName = curTypeName;
		}
		
		@Transient
		public String getRegAssetsStr() {
			if(this.regCap == null || this.regCap == 0.0d) {
				regAssetsStr = "0";
			} else {
				regAssetsStr = DecimalFormat.getNumberInstance().format(this.regCap.intValue());
			}
			return regAssetsStr;
		}
		public void setRegAssetsStr(String regAssetsStr) {
			this.regAssetsStr = regAssetsStr;
		}
		
		@Transient
		public String getCashConStr() {
			if(this.subConam == null || this.subConam == 0.0d) {
				cashConStr = "0";
			} else {
				cashConStr = DecimalFormat.getNumberInstance().format(this.subConam.intValue());
			}
			return cashConStr;
		}
		public void setCashConStr(String cashConStr) {
			this.cashConStr = cashConStr;
		}
		
	   public OdsLegPerEquityHisEntity() {}
		
	   public OdsLegPerEquityHisEntity(String fileNo,Date createTime) 
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
		
		// ============自增主键 =================
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ID", nullable = false)
		public Integer getId()
		{
			return this.id;
		};

		public void setId(Integer id)
		{
			this.id = id;
		};

		// ============注册ID =================
		@Column(name="REG_ID")
		public String getRegId()
		{
			return this.regId;
		};

		public void setRegId(String regId)
		{
			this.regId = regId;
		};

		// ============企业名称 =================
		@Column(name="ENT_NAME")
		public String getEntName()
		{
			return this.entName;
		};

		public void setEntName(String entName)
		{
			this.entName = entName;
		};

		// ============注册资本 =================
		@Column(name="REG_CAP")
		public Double getRegCap()
		{
			return this.regCap;
		};

		public void setRegCap(Double regCap)
		{
			this.regCap = regCap;
		};

		// ============出资比率 =================
		@Column(name="CASH_RATE")
		public String getCashRate()
		{
			return this.cashRate;
		};

		public void setCashRate(String cashRate)
		{
			this.cashRate = cashRate;
		};

		// ============法人姓名 =================
		@Column(name="NAME")
		public String getName()
		{
			return this.name;
		};

		public void setName(String name)
		{
			this.name = name;
		};

		// ============注册编号 =================
		@Column(name="REG_NO")
		public String getRegNo()
		{
			return this.regNo;
		};

		public void setRegNo(String regNo)
		{
			this.regNo = regNo;
		};

		// ============企业类型 =================
		@Column(name="ENT_TYPE")
		public String getEntType()
		{
			return this.entType;
		};

		public void setEntType(String entType)
		{
			this.entType = entType;
		};

		// ============币种 =================
		@Column(name="CUR_TYPE")
		public String getCurType()
		{
			return this.curType;
		};

		public void setCurType(String curType)
		{
			this.curType = curType;
		};

		// ============注销日期 =================
		@Column(name="CANCEL_TIME")
		public Date getCancelTime()
		{
			return this.cancelTime;
		};

		public void setCancelTime(Date cancelTime)
		{
			this.cancelTime = cancelTime;
		};

		// ============吊销日期 =================
		@Column(name="REVOKE_TIME")
		public Date getRevokeTime()
		{
			return this.revokeTime;
		};

		public void setRevokeTime(Date revokeTime)
		{
			this.revokeTime = revokeTime;
		};

		// ============登记机关 =================
		@Column(name="REG_ORG")
		public String getRegOrg()
		{
			return this.regOrg;
		};

		public void setRegOrg(String regOrg)
		{
			this.regOrg = regOrg;
		};

		// ============认缴出资币种 =================
		@Column(name="SUBSCRIBE_CON_CUR_TYPE")
		public String getSubscribeConCurType()
		{
			return this.subscribeConCurType;
		};

		public void setSubscribeConCurType(String subscribeConCurType)
		{
			this.subscribeConCurType = subscribeConCurType;
		};

		// ============开业日期 =================
		@Column(name="OPERATION_TIME")
		public Date getOperationTime()
		{
			return this.operationTime;
		};

		public void setOperationTime(Date operationTime)
		{
			this.operationTime = operationTime;
		};

		// ============认缴出资额 =================
		@Column(name="SUB_CONAM")
		public Double getSubConam()
		{
			return this.subConam;
		};

		public void setSubConam(Double subConam)
		{
			this.subConam = subConam;
		};

		// ============机构状态 =================
		@Column(name="ENT_STATUS")
		public String getEntStatus()
		{
			return this.entStatus;
		};

		public void setEntStatus(String entStatus)
		{
			this.entStatus = entStatus;
		};
	
	
	
}
