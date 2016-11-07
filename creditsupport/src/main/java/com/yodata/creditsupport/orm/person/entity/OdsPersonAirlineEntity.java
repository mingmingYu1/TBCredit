package com.yodata.creditsupport.orm.person.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name ="ods_person_airline", catalog="credit_db")
public class OdsPersonAirlineEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============身份证号 =================
	private String cardId;

	// ============姓名 =================
	private String name;

	// ============1年飞行次数 =================
	private Integer flightTimes;

	// ============飞行月数 =================
	private String flightMonth;

	// ============最繁忙的月份乘机X次 =================
	private Integer flyTimes;

	// ============1年平均折扣 =================
	private Double avgDiscount;

	// ============商务舱乘机次数 =================
	private Integer fcabin;

	// ============公共舱乘机次数 =================
	private Integer ccabin;

	// ============经济舱乘机次数 =================
	private Integer ycabin;

	// ============最频繁乘机出发城市 =================
	private String fromCity;

	// ============最频繁乘机到达城市 =================
	private String destCity;

	// ============最频繁使用航空 =================
	private String airline;

	// ============国内飞行次数 =================
	private Integer cnCount;

	// ============国外飞行次数 =================
	private Integer interCount;

	// ============免费次数 =================
	private Integer freeCount;

	// ============平均票价 =================
	private Double avgPrice;

	// ============延误时间 =================
	private Double tsDelay;

	// ============平均延误时间 =================
	private Double avgDelay;

	// ============平均提前多少天出票 =================
	private Integer avgTicketDay;

	// ============最后飞行时间 =================
	private String lastFlightDate;

	// ============最后起飞城市 =================
	private String lastFromCity;

	// ============最后目的城市 =================
	private String lastDestCity;

	// ============飞行的总里程 =================
	private Integer flyTotaltpm;

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

	// ============1年飞行次数 =================
	@Column(name="flight_times")
	public Integer getFlightTimes()
	{
		return this.flightTimes;
	};

	public void setFlightTimes(Integer flightTimes)
	{
		this.flightTimes = flightTimes;
	};

	// ============飞行月数 =================
	@Column(name="flight_month")
	public String getFlightMonth()
	{
		return this.flightMonth;
	};

	public void setFlightMonth(String flightMonth)
	{
		this.flightMonth = flightMonth;
	};

	// ============最繁忙的月份乘机X次 =================
	@Column(name="fly_times")
	public Integer getFlyTimes()
	{
		return this.flyTimes;
	};

	public void setFlyTimes(Integer flyTimes)
	{
		this.flyTimes = flyTimes;
	};

	// ============1年平均折扣 =================
	@Column(name="avg_discount")
	public Double getAvgDiscount()
	{
		return this.avgDiscount;
	};

	public void setAvgDiscount(Double avgDiscount)
	{
		this.avgDiscount = avgDiscount;
	};

	// ============商务舱乘机次数 =================
	@Column(name="fcabin")
	public Integer getFcabin()
	{
		return this.fcabin;
	};

	public void setFcabin(Integer fcabin)
	{
		this.fcabin = fcabin;
	};

	// ============公共舱乘机次数 =================
	@Column(name="ccabin")
	public Integer getCcabin()
	{
		return this.ccabin;
	};

	public void setCcabin(Integer ccabin)
	{
		this.ccabin = ccabin;
	};

	// ============经济舱乘机次数 =================
	@Column(name="ycabin")
	public Integer getYcabin()
	{
		return this.ycabin;
	};

	public void setYcabin(Integer ycabin)
	{
		this.ycabin = ycabin;
	};

	// ============最频繁乘机出发城市 =================
	@Column(name="from_city")
	public String getFromCity()
	{
		return this.fromCity;
	};

	public void setFromCity(String fromCity)
	{
		this.fromCity = fromCity;
	};

	// ============最频繁乘机到达城市 =================
	@Column(name="dest_city")
	public String getDestCity()
	{
		return this.destCity;
	};

	public void setDestCity(String destCity)
	{
		this.destCity = destCity;
	};

	// ============最频繁使用航空 =================
	@Column(name="airline")
	public String getAirline()
	{
		return this.airline;
	};

	public void setAirline(String airline)
	{
		this.airline = airline;
	};

	// ============国内飞行次数 =================
	@Column(name="cn_count")
	public Integer getCnCount()
	{
		return this.cnCount;
	};

	public void setCnCount(Integer cnCount)
	{
		this.cnCount = cnCount;
	};

	// ============国外飞行次数 =================
	@Column(name="inter_count")
	public Integer getInterCount()
	{
		return this.interCount;
	};

	public void setInterCount(Integer interCount)
	{
		this.interCount = interCount;
	};

	// ============免费次数 =================
	@Column(name="free_count")
	public Integer getFreeCount()
	{
		return this.freeCount;
	};

	public void setFreeCount(Integer freeCount)
	{
		this.freeCount = freeCount;
	};

	// ============平均票价 =================
	@Column(name="avg_price")
	public Double getAvgPrice()
	{
		return this.avgPrice;
	};

	public void setAvgPrice(Double avgPrice)
	{
		this.avgPrice = avgPrice;
	};

	// ============延误时间 =================
	@Column(name="ts_delay")
	public Double getTsDelay()
	{
		return this.tsDelay;
	};

	public void setTsDelay(Double tsDelay)
	{
		this.tsDelay = tsDelay;
	};

	// ============平均延误时间 =================
	@Column(name="avg_delay")
	public Double getAvgDelay()
	{
		return this.avgDelay;
	};

	public void setAvgDelay(Double avgDelay)
	{
		this.avgDelay = avgDelay;
	};

	// ============平均提前多少天出票 =================
	@Column(name="avg_ticket_day")
	public Integer getAvgTicketDay()
	{
		return this.avgTicketDay;
	};

	public void setAvgTicketDay(Integer avgTicketDay)
	{
		this.avgTicketDay = avgTicketDay;
	};

	// ============最后飞行时间 =================
	@Column(name="last_flight_date")
	public String getLastFlightDate()
	{
		return this.lastFlightDate;
	};

	public void setLastFlightDate(String lastFlightDate)
	{
		this.lastFlightDate = lastFlightDate;
	};

	// ============最后起飞城市 =================
	@Column(name="last_From_city")
	public String getLastFromCity()
	{
		return this.lastFromCity;
	};

	public void setLastFromCity(String lastFromCity)
	{
		this.lastFromCity = lastFromCity;
	};

	// ============最后目的城市 =================
	@Column(name="last_dest_city")
	public String getLastDestCity()
	{
		return this.lastDestCity;
	};

	public void setLastDestCity(String lastDestCity)
	{
		this.lastDestCity = lastDestCity;
	};

	// ============飞行的总里程 =================
	@Column(name="fly_totaltpm")
	public Integer getFlyTotaltpm()
	{
		return this.flyTotaltpm;
	};

	public void setFlyTotaltpm(Integer flyTotaltpm)
	{
		this.flyTotaltpm = flyTotaltpm;
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
			 + ", flightTimes=" + flightTimes
			 + ", flightMonth=" + flightMonth
			 + ", flyTimes=" + flyTimes
			 + ", avgDiscount=" + avgDiscount
			 + ", fcabin=" + fcabin
			 + ", ccabin=" + ccabin
			 + ", ycabin=" + ycabin
			 + ", fromCity=" + fromCity
			 + ", destCity=" + destCity
			 + ", airline=" + airline
			 + ", cnCount=" + cnCount
			 + ", interCount=" + interCount
			 + ", freeCount=" + freeCount
			 + ", avgPrice=" + avgPrice
			 + ", tsDelay=" + tsDelay
			 + ", avgDelay=" + avgDelay
			 + ", avgTicketDay=" + avgTicketDay
			 + ", lastFlightDate=" + lastFlightDate
			 + ", lastFromCity=" + lastFromCity
			 + ", lastDestCity=" + lastDestCity
			 + ", flyTotaltpm=" + flyTotaltpm
			 + ", addtime=" + addtime;
	};
};