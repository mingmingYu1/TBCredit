package com.yodata.creditsupport.orm.entity.his;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yodata.creditsupport.orm.entity.AgentSharesImpawnEntity;

@Entity
@Table(name ="ods_agent_sharesimpawn_his", catalog="credit_db")
public class AgentSharesImpawnHisEntity implements Serializable{

	private static final long serialVersionUID = 2742275457698071475L;
	
	private Integer id;				// 自增主键
	private String regId;	// 企业注册号
	
	private String impOrg; // 质权人姓名
	private String impExaeep; // 出质审批部门
	private String impOrgType; //出质人类别
	private Date impSanDate; // 出质批准日期
	private Double impAm; // 出质金额 
	private Date impTo; // 出质截至日期 
	private Date imponRecDate; // 出质备案日期
	
	private String fileNo;			// 文件编号
	private Date createTime;		// 生成时间
	
   public AgentSharesImpawnHisEntity() {
		// TODO Auto-generated constructor stub
	}
	
   public AgentSharesImpawnHisEntity(String fileNo,Date createTime) {
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
	
	@Column(name="IMP_ORG")
	public String getImpOrg() {
		return impOrg;
	}
	public void setImpOrg(String impOrg) {
		this.impOrg = impOrg;
	}
	@Column(name="IMP_EXAEEP")
	public String getImpExaeep() {
		return impExaeep;
	}
	public void setImpExaeep(String impExaeep) {
		this.impExaeep = impExaeep;
	}
	@Column(name="IMP_ORG_TYPE")
	public String getImpOrgType() {
		return impOrgType;
	}
	public void setImpOrgType(String impOrgType) {
		this.impOrgType = impOrgType;
	}
	@Column(name="IMP_SAN_DATE")
	public Date getImpSanDate() {
		return impSanDate;
	}
	public void setImpSanDate(Date impSanDate) {
		this.impSanDate = impSanDate;
	}
	@Column(name="IMP_AM")
	public Double getImpAm() {
		return impAm;
	}
	public void setImpAm(Double impAm) {
		this.impAm = impAm;
	}
	@Column(name="IMP_TO")
	public Date getImpTo() {
		return impTo;
	}
	public void setImpTo(Date impTo) {
		this.impTo = impTo;
	}
	@Column(name="IMPON_REC_DATE")
	public Date getImponRecDate() {
		return imponRecDate;
	}
	public void setImponRecDate(Date imponRecDate) {
		this.imponRecDate = imponRecDate;
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
		return "AgentChangeEntity [id=" + id + ", regId=" + regId + ", impOrg=" + impOrg + "]";
	}

}
