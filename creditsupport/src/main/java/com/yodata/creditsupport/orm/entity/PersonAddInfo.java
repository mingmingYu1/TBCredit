package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PersonAddInfo implements Serializable{

	private static final long serialVersionUID = 348597211217712797L;
	
	 private Integer infoId;         //主键
	 private String infoName;       //姓名
	 private String infoCardCode; //身份证号
	 private List<String> bankList = new ArrayList<String>();  //银行卡号
	 private List<String> phoneList = new ArrayList<String>(); //手机号码

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public String getInfoName() {
		return infoName;
	}

	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}

	public String getInfoCardCode() {
		return infoCardCode;
	}

	public void setInfoCardCode(String infoCardCode) {
		this.infoCardCode = infoCardCode;
	}

	public List<String> getBankList() {
		return bankList;
	}

	public void setBankList(List<String> bankList) {
		this.bankList = bankList;
	}

	public List<String> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<String> phoneList) {
		this.phoneList = phoneList;
	}

	
	 
	 
}
