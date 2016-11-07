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
* @Description: 个人数据报告城市消费状况信息
* @author Jason
* @date 2016年7月13日 上午10:43:29
*
 */

@Entity
@Table(name ="ods_person_report_consumecities", catalog="credit_db")
public class OdsPersonReportConsumecitiesEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============ =================
	private Integer id;

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
			 + ", cardId=" + cardId
			 + ", card=" + card
			 + ", name=" + name
			 + ", amount=" + amount
			 + ", count=" + count
			 + ", addtime=" + addtime;
	};
};