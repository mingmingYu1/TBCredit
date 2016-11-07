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
@Table(name ="ods_agent_filiation_info_his", catalog="credit_db")
public class AgentFiliationHisEntity implements Serializable{

	private static final long serialVersionUID = 7479525688935707993L;
	private Integer id;				// 自增主键
	private String regId;	// 企业注册号
	
	private String brName; // 分支机构名称
	private String cbuItem; // 一般经营项目
	private String brRegNo; // 分支机构企业注册号
	private String localAdministration; //公司注册所所在工商管理局
	private String brAddr; // 分支机构地址
	private String brPrincipal; //分支机构负责人
	
	
	private String fileNo;			// 文件编号
	private Date createTime;		// 生成时间
	
   public AgentFiliationHisEntity() {
		// TODO Auto-generated constructor stub
	}
	
   public AgentFiliationHisEntity(String fileNo,Date createTime) {
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
	@Column(name="BR_NAME")
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}

	@Column(name="CBU_ITEM")
	public String getCbuItem() {
		return cbuItem;
	}
	public void setCbuItem(String cbuItem) {
		this.cbuItem = cbuItem;
	}
	
	@Column(name="BR_REG_No")
	public String getBrRegNo() {
		return brRegNo;
	}
	public void setBrRegNo(String brRegNo) {
		this.brRegNo = brRegNo;
	}
	
	@Column(name="LOCAL_ADMINISTRATION")
	public String getLocalAdministration() {
		return localAdministration;
	}
	public void setLocalAdministration(String localAdministration) {
		this.localAdministration = localAdministration;
	}
	
	@Column(name="BR_ADDR")
	public String getBrAddr() {
		return brAddr;
	}
	public void setBrAddr(String brAddr) {
		this.brAddr = brAddr;
	}

	@Column(name="BR_PRINCIPAL")
	public String getBrPrincipal() {
		return brPrincipal;
	}
	public void setBrPrincipal(String brPrincipal) {
		this.brPrincipal = brPrincipal;
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

}
