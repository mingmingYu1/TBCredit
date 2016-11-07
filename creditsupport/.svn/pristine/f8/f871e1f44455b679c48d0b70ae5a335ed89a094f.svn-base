package com.yodata.creditsupport.orm.entity.his;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yodata.creditsupport.orm.entity.AgentBlackListEntity;

@Entity
@Table(name = "ods_agent_black_list_his", catalog = "credit_db")
public class AgentBlackListHisEntity implements Serializable{

	private static final long serialVersionUID = 8849930274620645046L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false)
	private Integer id; // 自增主键

	@Column(name = "REG_ID")
	private String regId; // 企业注册号

	// =============== 违约金额 =================
	@Column(name = "MONEY")
	private Double money;

	// =============== 不良行为发生时间距今 =================
	@Column(name = "TIME_UP_TO_NOW")
	private Integer timeUpToNow;

	// =============== 身份证号 =================
	@Column(name = "IDENTITY_CARD_ID")
	private String identityCardId;

	// =============== 法院记录状态 =================
	@Column(name = "COURD_RECORD_STATUS")
	private String courdRecordStatus;

	// =============== 违约持续时间 =================
	@Column(name = "BREAK_ELASPE")
	private Integer breakElaspe;

	// =============== 黑名单原因类别 =================
	@Column(name = "BLACK_CAUSE_TYPE")
	private String blackCauseType;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getTimeUpToNow() {
		return timeUpToNow;
	}

	public void setTimeUpToNow(Integer timeUpToNow) {
		this.timeUpToNow = timeUpToNow;
	}

	public String getIdentityCardId() {
		return identityCardId;
	}

	public void setIdentityCardId(String identityCardId) {
		this.identityCardId = identityCardId;
	}

	public String getCourdRecordStatus() {
		return courdRecordStatus;
	}

	public void setCourdRecordStatus(String courdRecordStatus) {
		this.courdRecordStatus = courdRecordStatus;
	}

	public Integer getBreakElaspe() {
		return breakElaspe;
	}

	public void setBreakElaspe(Integer breakElaspe) {
		this.breakElaspe = breakElaspe;
	}

	public String getBlackCauseType() {
		return blackCauseType;
	}

	public void setBlackCauseType(String blackCauseType) {
		this.blackCauseType = blackCauseType;
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
		return "AgentChangeEntity [id=" + id + ", regId=" + regId + ", owner=" + identityCardId + "]";
	}

}
