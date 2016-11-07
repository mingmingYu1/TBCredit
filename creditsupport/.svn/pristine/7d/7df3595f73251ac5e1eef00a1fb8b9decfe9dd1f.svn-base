package com.yodata.creditsupport.orm.person.entity.report;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ods_basic_indi_person_score_his", catalog="credit_db")
public class BasicIndiScorePersonHisEntity {

	private Integer id;             //主键
	private String cardId;		   //省份证编号
	private String fileNo;			//文件编号
	private Date createTime;		//生成时间
	private String itemName;		//名称
	private String base;			//基本信息
	private String behavior;		//交易行为
	private String history;			//信用历史
	private String capacity;		//履约能力
	private String special;			//特殊事项调整
	
	public BasicIndiScorePersonHisEntity() {
	}
	public BasicIndiScorePersonHisEntity(String cardId, String fileNo, Date createTime) {
		this.cardId = cardId;
		this.fileNo = fileNo;
		this.createTime = createTime;
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
	@Column(name="card_id", nullable = false)
	public String getRegId() {
		return cardId;
	}
	public void setRegId(String cardId) {
		this.cardId = cardId;
	}
	@Column(name="file_no", nullable = false)
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="item_name")
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	@Column(name="base")
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	@Column(name="behavior")
	public String getBehavior() {
		return behavior;
	}
	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
	@Column(name="history")
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	@Column(name="capacity")
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	@Column(name="special")
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
}
