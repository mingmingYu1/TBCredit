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
 * 企业变更信息
 */
@Entity
@Table(name ="ods_agent_change_info", catalog="credit_db")
public class AgentChangeEntity implements Serializable {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 6851839307867539396L;
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private Integer id;				// 自增主键
	private String regId;	// 企业注册号
	private Date changeTime; // 变更日期
	private String changeItem; // 变更项目
	private String preChange; //变更前值
	private String postChange; //变更后值
	
	private String conDateStr;		// 日期格式化字符
	
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
	
	@Column(name="CHANGE_TIME")
	public Date getChangeTime() {
		return changeTime;
	}
	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	
	@Column(name="CHANGE_ITEM")
	public String getChangeItem() {
		return changeItem;
	}
	public void setChangeItem(String changeItem) {
		this.changeItem = changeItem;
	}
	
	@Column(name="PRE_CHANGE")
	public String getPreChange() {
		return preChange;
	}
	public void setPreChange(String preChange) {
		this.preChange = preChange;
	}
	
	@Column(name="POST_CHANGE")
	public String getPostChange() {
		return postChange;
	}
	public void setPostChange(String postChange) {
		this.postChange = postChange;
	}
	
	@Transient
	public String getConDateStr() {
		if(changeTime != null)
			conDateStr = sdf.format(changeTime);
		return conDateStr;
	}
	public void setConDateStr(String conDateStr) {
		this.conDateStr = conDateStr;
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
		AgentChangeEntity other = (AgentChangeEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AgentChangeEntity [id=" + id + ", regId=" + regId + ", changeTime=" + changeTime + ", changeItem="
				+ changeItem + ", preChange=" + preChange + ", postChange=" + postChange + "]";
	}
}
