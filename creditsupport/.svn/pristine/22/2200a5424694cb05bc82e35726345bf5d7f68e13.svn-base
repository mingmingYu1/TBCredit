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
* @Description: 个人数据报告消费行为
* @author Jason
* @date 2016年7月13日 上午11:31:27
*
 */

@Entity
@Table(name ="ods_person_report_transbehavior", catalog="credit_db")
public class OdsPersonReportTransbehaviorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============ =================
	private Integer id;

	// ============身份证号 =================
	private String cardId;

	// ============银行卡号 =================
	private String card;

	// ============有无出差 =================
	private String businesstrip;

	// ============有无婚庆消费 =================
	private String marriageconsume;

	// ============有无家庭特征 =================
	private String childinvest;

	// ============有无夜消费 =================
	private String nightconsume;

	// ============是否就业 =================
	private String employed;

	// ============常住城市 =================
	private String city;

	// ============工作时间消费区域 =================
	private String workregion;

	// ============非工作时间消费区域 =================
	private String freeregion;

	// ============是否失业 =================
	private String unemployed;

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

	// ============有无出差 =================
	@Column(name="businessTrip")
	public String getBusinesstrip()
	{
		return this.businesstrip;
	};

	public void setBusinesstrip(String businesstrip)
	{
		this.businesstrip = businesstrip;
	};

	// ============有无婚庆消费 =================
	@Column(name="marriageConsume")
	public String getMarriageconsume()
	{
		return this.marriageconsume;
	};

	public void setMarriageconsume(String marriageconsume)
	{
		this.marriageconsume = marriageconsume;
	};

	// ============有无家庭特征 =================
	@Column(name="childInvest")
	public String getChildinvest()
	{
		return this.childinvest;
	};

	public void setChildinvest(String childinvest)
	{
		this.childinvest = childinvest;
	};

	// ============有无夜消费 =================
	@Column(name="nightConsume")
	public String getNightconsume()
	{
		return this.nightconsume;
	};

	public void setNightconsume(String nightconsume)
	{
		this.nightconsume = nightconsume;
	};

	// ============是否就业 =================
	@Column(name="employed")
	public String getEmployed()
	{
		return this.employed;
	};

	public void setEmployed(String employed)
	{
		this.employed = employed;
	};

	// ============常住城市 =================
	@Column(name="city")
	public String getCity()
	{
		return this.city;
	};

	public void setCity(String city)
	{
		this.city = city;
	};

	// ============工作时间消费区域 =================
	@Column(name="workRegion")
	public String getWorkregion()
	{
		return this.workregion;
	};

	public void setWorkregion(String workregion)
	{
		this.workregion = workregion;
	};

	// ============非工作时间消费区域 =================
	@Column(name="freeRegion")
	public String getFreeregion()
	{
		return this.freeregion;
	};

	public void setFreeregion(String freeregion)
	{
		this.freeregion = freeregion;
	};

	// ============是否失业 =================
	@Column(name="unEmployed")
	public String getUnemployed()
	{
		return this.unemployed;
	};

	public void setUnemployed(String unemployed)
	{
		this.unemployed = unemployed;
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
			 + ", businesstrip=" + businesstrip
			 + ", marriageconsume=" + marriageconsume
			 + ", childinvest=" + childinvest
			 + ", nightconsume=" + nightconsume
			 + ", employed=" + employed
			 + ", city=" + city
			 + ", workregion=" + workregion
			 + ", freeregion=" + freeregion
			 + ", unemployed=" + unemployed
			 + ", addtime=" + addtime;
	};
};