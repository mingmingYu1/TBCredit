package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="sp_crawler_agent_info", catalog = "credit_db")
public class CrawlerAgentInfoEntity implements Serializable{
    
    /**
     * 序列化编号
     */
    private static final long serialVersionUID = 3819131562025603365L;
    
    private Integer infoId;                //主键
    private String infoName;
    private String infocreditcode;
	
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="info_id", nullable = false)
    public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	@Column(name="info_name", nullable = false)
	public String getInfoName() {
		return infoName;
	}
	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}
	@Column(name="info_creditcode", nullable = false)
	public String getInfocreditcode() {
		return infocreditcode;
	}
	public void setInfocreditcode(String infocreditcode) {
		this.infocreditcode = infocreditcode;
	}
    
 }