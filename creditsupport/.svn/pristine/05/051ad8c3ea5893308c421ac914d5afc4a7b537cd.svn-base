package com.yodata.creditsupport.orm.person.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
* @Description: 个人数据报告每月消费状况信息
* @author Jason
* @date 2016年7月13日 上午11:28:31
*
 */

@Entity
@Table(name ="ods_person_report_monthconsumes", catalog="credit_db")
public class OdsPersonReportMonthconsumesEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============ =================
	private Integer id;

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

	// ============ =================
	@Id
	@Column(name="id")
	public Integer getId()
	{
		return this.id;
	};

	public void setId(Integer id)
	{
		this.id = id;
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