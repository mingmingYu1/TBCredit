package com.yodata.creditsupport.orm.entity.his;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="ods_agent_mortgage_info_his", catalog="credit_db")
public class AgentMortgageHisEntity implements Serializable{

	private static final long serialVersionUID = -4633715371099302418L;
	
	private Integer id;				// 自增主键
	private String regId;	// 企业注册号
	
	private String morRegId; //抵押ID
	private String morRegcNo; //登记证号 
	private String morgagor; //抵押人
	private String appRegRea; //申请抵押原因
	private String more; //抵押权人'
	private String priClaSecKind; //被担保主债权种类
	private String regOrg; //登记机关
	private Double priClaSecAm; //被担保主债权数额
	private Date regiDate; //登记日期
	private Date pefperFrom; //履约起始日期
	private String morType; //状态标识
	private Date pefperTo; //履约截止日期 
	private Date canDate; //注销日期
	
	private String fileNo;			// 文件编号
	private Date createTime;		// 生成时间
	
	public AgentMortgageHisEntity() {
		// TODO Auto-generated constructor stub
	}
	
   public AgentMortgageHisEntity(String fileNo,Date createTime) {
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
	
	@Column(name="MOR_REG_ID")
	public String getMorRegId() {
		return morRegId;
	}
	public void setMorRegId(String morRegId) {
		this.morRegId = morRegId;
	}
	@Column(name="MOR_REGC_NO")
	public String getMorRegcNo() {
		return morRegcNo;
	}
	public void setMorRegcNo(String morRegcNo) {
		this.morRegcNo = morRegcNo;
	}
	@Column(name="MORTGAGOR")
	public String getMorgagor() {
		return morgagor;
	}
	public void setMorgagor(String morgagor) {
		this.morgagor = morgagor;
	}
	@Column(name="APP_REG_REA")
	public String getAppRegRea() {
		return appRegRea;
	}
	public void setAppRegRea(String appRegRea) {
		this.appRegRea = appRegRea;
	}
	@Column(name="MORE")
	public String getMore() {
		return more;
	}
	public void setMore(String more) {
		this.more = more;
	}
	@Column(name="PRI_CLA_SEC_KIND")
	public String getPriClaSecKind() {
		return priClaSecKind;
	}
	public void setPriClaSecKind(String priClaSecKind) {
		this.priClaSecKind = priClaSecKind;
	}
	@Column(name="REG_ORG")
	public String getRegOrg() {
		return regOrg;
	}
	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}
	@Column(name="PRI_CLA_SEC_AM")
	public Double getPriClaSecAm() {
		return priClaSecAm;
	}
	public void setPriClaSecAm(Double priClaSecAm) {
		this.priClaSecAm = priClaSecAm;
	}
	@Column(name="REGI_DATE")
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
	@Column(name="PEFPER_FROM")
	public Date getPefperFrom() {
		return pefperFrom;
	}
	public void setPefperFrom(Date pefperFrom) {
		this.pefperFrom = pefperFrom;
	}
	@Column(name="MOR_TYPE")
	public String getMorType() {
		return morType;
	}
	public void setMorType(String morType) {
		this.morType = morType;
	}
	@Column(name="PEFPER_TO")
	public Date getPefperTo() {
		return pefperTo;
	}
	public void setPefperTo(Date pefperTo) {
		this.pefperTo = pefperTo;
	}
	@Column(name="CAN_DATE")
	public Date getCanDate() {
		return canDate;
	}
	public void setCanDate(Date canDate) {
		this.canDate = canDate;
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "AgentChangeEntity [id=" + id + ", regId=" + regId + ", morRegId=" + morRegId + "]";
	}

}
