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
@Table(name ="ods_person_report_monthconsumes_report", catalog="credit_db")
public class OdsPersonReportMonthconsumesReportEntity implements Serializable {

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

	// ============消费月 =================
	private String month;

	// ============每月消费金额及汇总 每月消费金额，数据原样输出 =================
	private Double amount;

	// ============消费金额在本市的排名 =================
	private Integer amountranking;

	// ============每月消费笔数及汇总 =================
	private Integer count;

	// ============消费笔数在本市的排名 =================
	private Integer countranking;

	// ============ =================
	private Timestamp addtime;

	public OdsPersonReportMonthconsumesReportEntity(){}
	
	public OdsPersonReportMonthconsumesReportEntity(String fileNo, Date createTime) 
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

	// ============消费月 =================
	@Column(name="month")
	public String getMonth()
	{
		return this.month;
	};

	public void setMonth(String month)
	{
		this.month = month;
	};

	// ============每月消费金额及汇总 每月消费金额，数据原样输出 =================
	@Column(name="amount")
	public Double getAmount()
	{
		return this.amount;
	};

	public void setAmount(Double amount)
	{
		this.amount = amount;
	};

	// ============消费金额在本市的排名 =================
	@Column(name="amountRanking")
	public Integer getAmountranking()
	{
		return this.amountranking;
	};

	public void setAmountranking(Integer amountranking)
	{
		this.amountranking = amountranking;
	};

	// ============每月消费笔数及汇总 =================
	@Column(name="count")
	public Integer getCount()
	{
		return this.count;
	};

	public void setCount(Integer count)
	{
		this.count = count;
	};

	// ============消费笔数在本市的排名 =================
	@Column(name="countRanking")
	public Integer getCountranking()
	{
		return this.countranking;
	};

	public void setCountranking(Integer countranking)
	{
		this.countranking = countranking;
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
			 + ", month=" + month
			 + ", amount=" + amount
			 + ", amountranking=" + amountranking
			 + ", count=" + count
			 + ", countranking=" + countranking
			 + ", addtime=" + addtime;
	};
};