package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="sp_crawler_agentgroup_agentinfo", catalog = "credit_db")
public class CrawlerAgetngroupAgentinfoEntity implements Serializable{
    
    /**
     * 序列化编号
     */
    private static final long serialVersionUID = 3819131562025603365L;
    
    private Integer infoId;                //企业主键
    private Integer groupId;//分组主键
	
    
    @Id
    @Column(name="info_id", nullable = false)
    public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	@Id
	@Column(name="group_id", nullable = false)
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	 
    
    

    
	
   
     
   
    
 }