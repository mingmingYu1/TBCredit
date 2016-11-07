package com.yodata.creditsupport.orm.entity.his;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name ="ods_agent_change_info_his", catalog="credit_db")
public class AgentChangeHisEntity implements Serializable{

	private static final long serialVersionUID = 6919443076647017051L;
	private Integer id;				// 自增主键
	private String regId;	// 企业注册号
	private String fileNo;			// 文件编号
	private Date createTime;		// 生成时间
	private Date changeTime; // 变更日期
	private String changeItem; // 变更项目
	private String preChange; //变更前值
	private String postChange; //变更后值
	
	private String conDateStr;		// 日期格式化字符
	
	public AgentChangeHisEntity(){};
	
	public AgentChangeHisEntity(String fileNo, Date createTime) {
		this.fileNo = fileNo;
		this.createTime = createTime;
	}
	
	@Transient
	public String getConDateStr() {
		if(changeTime != null)
			conDateStr = new SimpleDateFormat("yyyy-MM-dd").format(changeTime);
		return conDateStr;
	}
	public void setConDateStr(String conDateStr) {
		this.conDateStr = conDateStr;
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
	
	@Column(name="REG_ID")
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
	
	
	
}
