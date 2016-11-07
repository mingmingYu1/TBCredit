package com.yodata.creditsupport.orm.vo;

import java.util.Date;
// zhongmeng
public class StockholderVo {
	
	private Integer id ;     // 股东id
	private String regId ; // 企业id
	private String name ;	 // 股东名称
	private Double cashCon;  // 出资额
	private Double cashRate; // 出资比例
	private String curType;	 // 币种
	private Date conDate ;   // 出资日期
	
	public StockholderVo(){}
	public StockholderVo(Integer id,String regId , String name,Double cashCon,
			Double cashRate,String curType,Date conDate){
		this.id = id ;
		this.regId = regId ;
		this.name = name ;
		this.cashCon = cashCon ;
		this.cashRate = cashRate ;
		this.curType = curType ;
		this.conDate = conDate ;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCashCon() {
		return cashCon;
	}
	public void setCashCon(Double cashCon) {
		this.cashCon = cashCon;
	}
	public Double getCashRate() {
		return cashRate;
	}
	public void setCashRate(Double cashRate) {
		this.cashRate = cashRate;
	}
	public String getCurType() {
		return curType;
	}
	public void setCurType(String curType) {
		this.curType = curType;
	}
	public Date getConDate() {
		return conDate;
	}
	public void setConDate(Date conDate) {
		this.conDate = conDate;
	}
	
	
	
}
