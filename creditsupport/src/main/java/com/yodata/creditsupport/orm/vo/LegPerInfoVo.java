package com.yodata.creditsupport.orm.vo;


public class LegPerInfoVo {

	private Integer id ; 	  // id
	private String regId;		// 企业ID
	private String orgName ;  // 被投资机构名称
	private String orgSta;   // 投资机构状态
	private String regNo ;    // 工商注册号
	private String position ;	// 担任职务
	private Double regAssets;	// 注册资本 
	private Double cashCon;		// 出资额
	private String curType ;	// 币种
	private Double cashRate ;	// 出资比例
	private String entType;	// 企业类型
	private String regAuth;		// 登记机关	
	
	public LegPerInfoVo(){}
 
	// 法定代表人在其机构任职信息	法定代表人股权投资信息	被投资机构概要信息
	public LegPerInfoVo(Integer id , String regId, String orgName , String orgSta ,String regNo , String position,
			Double regAssets,Double cashCon,String curType,String entType,String regAuth,Double cashRate){
		this.id = id ;
		this.regId = regId ;
		this.orgName = orgName ;
		this.orgSta = orgSta ;
		this.regNo = regNo ;
		this.position = position ;
		this.regAssets = regAssets ;
		this.cashCon = cashCon ;
		this.curType = curType ;
		this.entType = entType ;
		this.regAuth = regAuth ;
		this.cashRate = cashRate ;
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

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgSta() {
		return orgSta;
	}

	public void setOrgSta(String orgSta) {
		this.orgSta = orgSta;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Double getRegAssets() {
		return regAssets;
	}

	public void setRegAssets(Double regAssets) {
		this.regAssets = regAssets;
	}

	public Double getCashCon() {
		return cashCon;
	}

	public void setCashCon(Double cashCon) {
		this.cashCon = cashCon;
	}

	public String getCurType() {
		return curType;
	}

	public void setCurType(String curType) {
		this.curType = curType;
	}

	public String getEntType() {
		return entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	public String getRegAuth() {
		return regAuth;
	}

	public void setRegAuth(String regAuth) {
		this.regAuth = regAuth;
	}
	public Double getCashRate() {
		return cashRate;
	}

	public void setCashRate(Double cashRate) {
		this.cashRate = cashRate;
	}
	
	
	
}	
