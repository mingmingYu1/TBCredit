
/******************************************************************************
 * Copyright (C) 2016 Yodata Co.,Ltd
 * All Rights Reserved.
 * 该软件有前海云游数据开发并拥有版权，在未经得前海云游数据有限公司正式书面授权情况下，
 * 任何公司，个人或者团体不得擅自修改，发布，使用本软件。违者必究。
 ******************************************************************************/
package com.yodata.creditsupport.orm.entity.his;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 /**
 * @version 2016-6-22 11:04:57 ${user}
 */
  @Entity
  @Table(name="ods_agent_ali_loan_break_his", catalog="credit_db")
  public class AgentAliLoanbreakHisEntity implements Serializable{
  
	private static final long serialVersionUID = -2656673007464159924L;


	public AgentAliLoanbreakHisEntity() {}
	
   public AgentAliLoanbreakHisEntity(String fileNo,Date createTime) {
		// TODO Auto-generated constructor stub
	   this.fileNo = fileNo;
	   this.createTime = createTime;
	}
       
       //遍历所有的字段,columnMap
                     //===============  自增主键   =================
             private  Integer  id;
             
                     //===============  工商注册号   =================
             private  String  regId;
             
                     //===============  创建时间   =================
             private  Date  createTime;
             
                     //===============  文件编号   =================
             private  String  fileNo;
             
                     //===============  省份   =================
             private  String  province;
             
                     //===============  发布时间   =================
             private  Date  exposureTime;
             
                     //===============  欠款额度   =================
             private  Double  ownedMoney;
             
                     //===============  违约情况   =================
             private  String  brief;
             
                     //===============  贷款到期时间   =================
             private  Date  loanDate;
             
                     //===============  淘宝账户   =================
             private  String  taobaoAccount;
             
                     //===============  法定代表人   =================
             private  String  juridicalPerson;
             
                     //===============  贷款期限   =================
             private  String  loanDueTime;
             
                     //===============  被执行姓名   =================
             private  Double  ownedName;
             
                     //===============  性别   =================
             private  String  ownerSex;
             
                     //===============  年龄   =================
             private  Integer  ownerAge;
             
                     //===============  身份证号码 /工商注册号   =================
             private  String  ownerIdentityCardId;
             
              
                       //===============  自增主键   =================
             @Id
             @GeneratedValue(strategy = GenerationType.IDENTITY)
             @Column(name="id", nullable = false)
             public Integer getId(){
                    return this.id;
             }
         
             public void setId(Integer id){
                    this.id = id;
             }
                       //===============  工商注册号   =================
                           @Column(name="REG_ID")
             public String getRegId(){
                    return this.regId;
             }
         
             public void setRegId(String regId){
                    this.regId = regId;
             }
                       //===============  创建时间   =================
                           @Column(name="CREATE_TIME")
             public Date getCreateTime(){
                    return this.createTime;
             }
         
             public void setCreateTime(Date createTime){
                    this.createTime = createTime;
             }
                       //===============  文件编号   =================
                           @Column(name="FILE_NO")
             public String getFileNo(){
                    return this.fileNo;
             }
         
             public void setFileNo(String fileNo){
                    this.fileNo = fileNo;
             }
                       //===============  省份   =================
                           @Column(name="PROVINCE")
             public String getProvince(){
                    return this.province;
             }
         
             public void setProvince(String province){
                    this.province = province;
             }
                       //===============  发布时间   =================
                           @Column(name="EXPOSURE_TIME")
             public Date getExposureTime(){
                    return this.exposureTime;
             }
         
             public void setExposureTime(Date exposureTime){
                    this.exposureTime = exposureTime;
             }
                       //===============  欠款额度   =================
                           @Column(name="OWNED_MONEY")
             public Double getOwnedMoney(){
                    return this.ownedMoney;
             }
         
             public void setOwnedMoney(Double ownedMoney){
                    this.ownedMoney = ownedMoney;
             }
                       //===============  违约情况   =================
                           @Column(name="BRIEF")
             public String getBrief(){
                    return this.brief;
             }
         
             public void setBrief(String brief){
                    this.brief = brief;
             }
                       //===============  贷款到期时间   =================
                           @Column(name="LOAN_DATE")
             public Date getLoanDate(){
                    return this.loanDate;
             }
         
             public void setLoanDate(Date loanDate){
                    this.loanDate = loanDate;
             }
                       //===============  淘宝账户   =================
                           @Column(name="TAOBAO_ACCOUNT")
             public String getTaobaoAccount(){
                    return this.taobaoAccount;
             }
         
             public void setTaobaoAccount(String taobaoAccount){
                    this.taobaoAccount = taobaoAccount;
             }
                       //===============  法定代表人   =================
                           @Column(name="JURIDICAL_PERSON")
             public String getJuridicalPerson(){
                    return this.juridicalPerson;
             }
         
             public void setJuridicalPerson(String juridicalPerson){
                    this.juridicalPerson = juridicalPerson;
             }
                       //===============  贷款期限   =================
                           @Column(name="LOAN_DUE_TIME")
             public String getLoanDueTime(){
                    return this.loanDueTime;
             }
         
             public void setLoanDueTime(String loanDueTime){
                    this.loanDueTime = loanDueTime;
             }
                       //===============  被执行姓名   =================
                           @Column(name="OWNED_NAME")
             public Double getOwnedName(){
                    return this.ownedName;
             }
         
             public void setOwnedName(Double ownedName){
                    this.ownedName = ownedName;
             }
                       //===============  性别   =================
                           @Column(name="OWNER_SEX")
             public String getOwnerSex(){
                    return this.ownerSex;
             }
         
             public void setOwnerSex(String ownerSex){
                    this.ownerSex = ownerSex;
             }
                       //===============  年龄   =================
                           @Column(name="OWNER_AGE")
             public Integer getOwnerAge(){
                    return this.ownerAge;
             }
         
             public void setOwnerAge(Integer ownerAge){
                    this.ownerAge = ownerAge;
             }
                       //===============  身份证号码 /工商注册号   =================
                           @Column(name="OWNER_IDENTITY_CARD_ID")
             public String getOwnerIdentityCardId(){
                    return this.ownerIdentityCardId;
             }
         
             public void setOwnerIdentityCardId(String ownerIdentityCardId){
                    this.ownerIdentityCardId = ownerIdentityCardId;
             }
                
       
  }
  

