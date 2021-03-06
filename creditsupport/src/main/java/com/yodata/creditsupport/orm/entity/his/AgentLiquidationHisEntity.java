package com.yodata.creditsupport.orm.entity.his;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yodata.creditsupport.orm.entity.AgentLiquidationEntity;

@Entity
@Table(name ="ods_agent_liquidation_info_his", catalog="credit_db")
public class AgentLiquidationHisEntity implements Serializable{

	private static final long serialVersionUID = 786195777042160060L;
	
	private Integer id;				// 自增主键
	private String regId;	// 企业注册号
	
	private String entity; // 清算责任人
	private Date endDate; // 清算完结日期
	private String principal; //清算负责人
	private String debtTranee; //债务承接人
	private String member; // 清算组成员
	private String clainTranee; //债权承接人  
	private String ligst; // 清算完结情况
	
	private String fileNo;			// 文件编号
	private Date createTime;		// 生成时间
	
	 public AgentLiquidationHisEntity() {
			// TODO Auto-generated constructor stub
		}
		
	   public AgentLiquidationHisEntity(String fileNo,Date createTime) {
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
	
	@Column(name="ENTITY")
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	@Column(name="END_TIME")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Column(name="PRINCIPAL")
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	@Column(name="DEBT_TRANEE")
	public String getDebtTranee() {
		return debtTranee;
	}
	public void setDebtTranee(String debtTranee) {
		this.debtTranee = debtTranee;
	}
	@Column(name="MEMBER")
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	@Column(name="CLAIN_TRANEE")
	public String getClainTranee() {
		return clainTranee;
	}
	public void setClainTranee(String clainTranee) {
		this.clainTranee = clainTranee;
	}
	@Column(name="LIGST")
	public String getLigst() {
		return ligst;
	}
	public void setLigst(String ligst) {
		this.ligst = ligst;
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
		return "AgentLiquidationEntity [id=" + id + ", regId=" + regId + ", principal=" + principal + "]";
	}

}
