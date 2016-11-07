package com.yodata.creditsupport.orm.person.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 征信报告保存信息
 * @author wenli.qu
 */
@Entity
@Table(name ="ods_person_save_info", catalog="credit_db")
public class PersonSaveInfoEntity {

	private Integer id;
	private String cardId;
	private String fileNo;
	private String name;
	private Date createTime;
	private String path;
	
	private String algorithmType;	// 算法类型
	private String algorithmName;	// 算法中文名称
	private Integer templetId;		// 模板编号
	private String templetName;		// 模板名称
	private String scoreVersion;	// 评分版本
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="card_id", nullable = true)
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	@Column(name="file_no", nullable = false, length = 200)
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	
	@Column(name="name", nullable = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Column(name="create_time", nullable = true)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name="path", nullable = true)
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Column(name="algorithm_type")
	public String getAlgorithmType() {
		return algorithmType;
	}
	public void setAlgorithmType(String algorithmType) {
		this.algorithmType = algorithmType;
	}
	@Column(name="templet_id")
	public Integer getTempletId() {
		return templetId;
	}
	public void setTempletId(Integer templetId) {
		this.templetId = templetId;
	}
	@Column(name="score_version")
	public String getScoreVersion() {
		return scoreVersion;
	}
	public void setScoreVersion(String scoreVersion) {
		this.scoreVersion = scoreVersion;
	}
	@Transient
	public String getAlgorithmName() {
		return algorithmName;
	}
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	@Transient
	public String getTempletName() {
		return templetName;
	}
	public void setTempletName(String templetName) {
		this.templetName = templetName;
	}
	
}
