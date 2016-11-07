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
* @Description: 资产状况及交易行为信息
* @author Jason
* @date 2016年7月13日 上午10:39:55
*
 */

@Entity
@Table(name ="ods_person_report_basic", catalog="credit_db")
public class OdsPersonReportBasicEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============身份证号 =================
	private String cardId;

	// ============姓名 =================
	private String name;

	// ============手机号码 =================
	private String mobile;

	// ============银行卡号 =================
	private String card;

	// ============每月还贷能力，金额范围 =================
	private String repaymentAbility;

	// ============依照相关交易行为判定个人是否有房 =================
	private String hasHouse;

	// ============房产预估购买时间 =================
	private String housePurTime;

	// ============房产估值 单位：万元 =================
	private Double houseValue;

	// ============有无汽车 =================
	private String hasCar;

	// ============汽车预估购买时间 =================
	private String carPurTime;

	// ============汽车估值 单位：万元 =================
	private Double carValue;

	// ============ =================
	private Timestamp addtime;

	// ============身份证号 =================
	@Id
	@Column(name="card_id")
	public String getCardId()
	{
		return this.cardId;
	};

	public void setCardId(String cardId)
	{
		this.cardId = cardId;
	};

	// ============姓名 =================
	@Column(name="name")
	public String getName()
	{
		return this.name;
	};

	public void setName(String name)
	{
		this.name = name;
	};

	// ============手机号码 =================
	@Column(name="mobile")
	public String getMobile()
	{
		return this.mobile;
	};

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
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

	// ============每月还贷能力，金额范围 =================
	@Column(name="repayment_ability")
	public String getRepaymentAbility()
	{
		return this.repaymentAbility;
	};

	public void setRepaymentAbility(String repaymentAbility)
	{
		this.repaymentAbility = repaymentAbility;
	};

	// ============依照相关交易行为判定个人是否有房 =================
	@Column(name="has_house")
	public String getHasHouse()
	{
		return this.hasHouse;
	};

	public void setHasHouse(String hasHouse)
	{
		this.hasHouse = hasHouse;
	};

	// ============房产预估购买时间 =================
	@Column(name="house_pur_time")
	public String getHousePurTime()
	{
		return this.housePurTime;
	};

	public void setHousePurTime(String housePurTime)
	{
		this.housePurTime = housePurTime;
	};

	// ============房产估值 单位：万元 =================
	@Column(name="house_value")
	public Double getHouseValue()
	{
		return this.houseValue;
	};

	public void setHouseValue(Double houseValue)
	{
		this.houseValue = houseValue;
	};

	// ============有无汽车 =================
	@Column(name="has_car")
	public String getHasCar()
	{
		return this.hasCar;
	};

	public void setHasCar(String hasCar)
	{
		this.hasCar = hasCar;
	};

	// ============汽车预估购买时间 =================
	@Column(name="car_pur_time")
	public String getCarPurTime()
	{
		return this.carPurTime;
	};

	public void setCarPurTime(String carPurTime)
	{
		this.carPurTime = carPurTime;
	};

	// ============汽车估值 单位：万元 =================
	@Column(name="car_value")
	public Double getCarValue()
	{
		return this.carValue;
	};

	public void setCarValue(Double carValue)
	{
		this.carValue = carValue;
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
		 return "cardId=" + cardId
			 + ", name=" + name
			 + ", mobile=" + mobile
			 + ", card=" + card
			 + ", repaymentAbility=" + repaymentAbility
			 + ", hasHouse=" + hasHouse
			 + ", housePurTime=" + housePurTime
			 + ", houseValue=" + houseValue
			 + ", hasCar=" + hasCar
			 + ", carPurTime=" + carPurTime
			 + ", carValue=" + carValue
			 + ", addtime=" + addtime;
	};
};