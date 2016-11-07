package com.yodata.creditsupport.orm.person.entity.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name ="ods_person_report_consumecities_report", catalog="credit_db")
public class OdsPersonReportConsumecitiesReportEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============自增主键 =================
	private Integer id;

	// ============创建时间 =================
	private Date createTime;

	// ============文件编号 =================
	private String fileNo;

	// ============身份证号 =================
	private String cardId;

	// ============银行卡号 =================
	private String card;

	// ============消费地域 ,城市名称 =================
	private String name;

	// ============消费金额（元） =================
	private Double amount;

	// ============消费笔数 =================
	private Integer count;

	// ============ =================
	private Timestamp addtime;
	
	public OdsPersonReportConsumecitiesReportEntity(){}

	public OdsPersonReportConsumecitiesReportEntity(String fileNo, Date createTime)
	{
		this.fileNo = fileNo;
		this.createTime = createTime;
	}

	// ============自增主键 =================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
	public Integer getId()
	{
		return this.id;
	};

	public void setId(Integer id)
	{
		this.id = id;
	};

	// ============创建时间 =================
	@Column(name="CREATE_TIME")
	public Date getCreateTime()
	{
		return this.createTime;
	};

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	};

	// ============文件编号 =================
	@Column(name="FILE_NO")
	public String getFileNo()
	{
		return this.fileNo;
	};

	public void setFileNo(String fileNo)
	{
		this.fileNo = fileNo;
	};

	// ============身份证号 =================
	@Column(name="card_id")
	public String getCardId()
	{
		return this.cardId;
	};

	public void setCardId(String cardId)
	{
		this.cardId = cardId;
	};

	// ============银行卡号 =================
	@Column(name="card")
	public String getCard()
	{
		return this.card;
	};

	public void setCard(String card)
	{
		this.card = card;
	};

	// ============消费地域 ,城市名称 =================
	@Column(name="name")
	public String getName()
	{
		return this.name;
	};

	public void setName(String name)
	{
		this.name = name;
	};

	// ============消费金额（元） =================
	@Column(name="amount")
	public Double getAmount()
	{
		return this.amount;
	};

	public void setAmount(Double amount)
	{
		this.amount = amount;
	};

	// ============消费笔数 =================
	@Column(name="count")
	public Integer getCount()
	{
		return this.count;
	};

	public void setCount(Integer count)
	{
		this.count = count;
	};

	// ============ =================
	@Column(name="addtime")
	public Timestamp getAddtime()
	{
		return this.addtime;
	};

	public void setAddtime(Timestamp addtime)
	{
		this.addtime = addtime;
	};


@Override
	public String toString(){
		 return "id=" + id
			 + ", createTime=" + createTime
			 + ", fileNo=" + fileNo
			 + ", cardId=" + cardId
			 + ", card=" + card
			 + ", name=" + name
			 + ", amount=" + amount
			 + ", count=" + count
			 + ", addtime=" + addtime;
	};
};