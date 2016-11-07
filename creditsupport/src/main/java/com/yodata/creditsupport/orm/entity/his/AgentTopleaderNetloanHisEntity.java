
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
 * @to-do <指定类的功能>
 * @model common
 * @author ${user}
 * @since 1.0
 * @version 2016-6-22 10:03:24 ${user}
 */
  @Entity
  @Table(name="ods_agent_top_leader_net_loan_violate_his",catalog="credit_db")
  public class AgentTopleaderNetloanHisEntity implements Serializable{
  
	private static final long serialVersionUID = -1667137105066697664L;


	 public AgentTopleaderNetloanHisEntity() {
			// TODO Auto-generated constructor stub
		}
		
	   public AgentTopleaderNetloanHisEntity(String fileNo,Date createTime) {
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
             
                     //===============  网贷黑名单ID   =================
             private  String  blackSheetId;
             
                     //===============  贷款时间   =================
             private  Date  loanTime;
             
                     //===============  内容   =================
             private  String  content;
             
                     //===============  性别   =================
             private  String  ownerSex;
             
                     //===============  居住电话   =================
             private  String  ownerHomePhone;
             
                     //===============  信息更新时间   =================
             private  Date  ownerInforUpdateTime;
             
                     //===============  执行法院   =================
             private  String  court;
             
                     //===============  相关当事人   =================
             private  String  litigant;
             
                     //===============  未还/罚息   =================
             private  String  debt;
             
                     //===============  身份证号   =================
             private  String  ownerIdentityNo;
             
                     //===============  籍贯地址   =================
             private  String  ownerHomeTownAddress;
             
                     //===============  本金/本息   =================
             private  Double  principle;
             
                     //===============  案号   =================
             private  String  caseNo;
             
                     //===============  居住地址   =================
             private  String  ownerAddress;
             
                     //===============  邮箱地址   =================
             private  String  ownerPostAddress;
             
                     //===============  来源单位名称   =================
             private  String  ownerUnit;
             
                     //===============  年龄   =================
             private  String  ownerAge;
             
                     //===============  姓名   =================
             private  String  ownerName;
             
                     //===============  数据源   =================
             private  String  source;
             
                     //===============  已还金额   =================
             private  Double  paidMoney;
             
                     //===============  手机号   =================
             private  String  ownerMobileNumber;
             
                     //===============  法人、控股股东或其他   =================
             private  String  caseOwnerType;
             
              
                       //===============  自增主键   =================
             @Id
             @GeneratedValue(strategy = GenerationType.IDENTITY)
             @Column(name="ID", nullable = false)
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
                       //===============  网贷黑名单ID   =================
                           @Column(name="BLACK_SHEET_ID")
             public String getBlackSheetId(){
                    return this.blackSheetId;
             }
         
             public void setBlackSheetId(String blackSheetId){
                    this.blackSheetId = blackSheetId;
             }
                       //===============  贷款时间   =================
                           @Column(name="LOAN_TIME")
             public Date getLoanTime(){
                    return this.loanTime;
             }
         
             public void setLoanTime(Date loanTime){
                    this.loanTime = loanTime;
             }
                       //===============  内容   =================
                           @Column(name="CONTENT")
             public String getContent(){
                    return this.content;
             }
         
             public void setContent(String content){
                    this.content = content;
             }
                       //===============  性别   =================
                           @Column(name="OWNER_SEX")
             public String getOwnerSex(){
                    return this.ownerSex;
             }
         
             public void setOwnerSex(String ownerSex){
                    this.ownerSex = ownerSex;
             }
                       //===============  居住电话   =================
                           @Column(name="OWNER_HOME_PHONE")
             public String getOwnerHomePhone(){
                    return this.ownerHomePhone;
             }
         
             public void setOwnerHomePhone(String ownerHomePhone){
                    this.ownerHomePhone = ownerHomePhone;
             }
                       //===============  信息更新时间   =================
                           @Column(name="OWNER_INFOR_UPDATE_TIME")
             public Date getOwnerInforUpdateTime(){
                    return this.ownerInforUpdateTime;
             }
         
             public void setOwnerInforUpdateTime(Date ownerInforUpdateTime){
                    this.ownerInforUpdateTime = ownerInforUpdateTime;
             }
                       //===============  执行法院   =================
                           @Column(name="COURT")
             public String getCourt(){
                    return this.court;
             }
         
             public void setCourt(String court){
                    this.court = court;
             }
                       //===============  相关当事人   =================
                           @Column(name="LITIGANT")
             public String getLitigant(){
                    return this.litigant;
             }
         
             public void setLitigant(String litigant){
                    this.litigant = litigant;
             }
                       //===============  未还/罚息   =================
                           @Column(name="DEBT")
             public String getDebt(){
                    return this.debt;
             }
         
             public void setDebt(String debt){
                    this.debt = debt;
             }
                       //===============  身份证号   =================
                           @Column(name="OWNER_IDENTITY_NO")
             public String getOwnerIdentityNo(){
                    return this.ownerIdentityNo;
             }
         
             public void setOwnerIdentityNo(String ownerIdentityNo){
                    this.ownerIdentityNo = ownerIdentityNo;
             }
                       //===============  籍贯地址   =================
                           @Column(name="OWNER_HOME_TOWN_ADDRESS")
             public String getOwnerHomeTownAddress(){
                    return this.ownerHomeTownAddress;
             }
         
             public void setOwnerHomeTownAddress(String ownerHomeTownAddress){
                    this.ownerHomeTownAddress = ownerHomeTownAddress;
             }
                       //===============  本金/本息   =================
                           @Column(name="PRINCIPLE")
             public Double getPrinciple(){
                    return this.principle;
             }
         
             public void setPrinciple(Double principle){
                    this.principle = principle;
             }
                       //===============  案号   =================
                           @Column(name="CASE_NO")
             public String getCaseNo(){
                    return this.caseNo;
             }
         
             public void setCaseNo(String caseNo){
                    this.caseNo = caseNo;
             }
                       //===============  居住地址   =================
                           @Column(name="OWNER_ADDRESS")
             public String getOwnerAddress(){
                    return this.ownerAddress;
             }
         
             public void setOwnerAddress(String ownerAddress){
                    this.ownerAddress = ownerAddress;
             }
                       //===============  邮箱地址   =================
                           @Column(name="OWNER_POST_ADDRESS")
             public String getOwnerPostAddress(){
                    return this.ownerPostAddress;
             }
         
             public void setOwnerPostAddress(String ownerPostAddress){
                    this.ownerPostAddress = ownerPostAddress;
             }
                       //===============  来源单位名称   =================
                           @Column(name="OWNER_UNIT")
             public String getOwnerUnit(){
                    return this.ownerUnit;
             }
         
             public void setOwnerUnit(String ownerUnit){
                    this.ownerUnit = ownerUnit;
             }
                       //===============  年龄   =================
                           @Column(name="OWNER_AGE")
             public String getOwnerAge(){
                    return this.ownerAge;
             }
         
             public void setOwnerAge(String ownerAge){
                    this.ownerAge = ownerAge;
             }
                       //===============  姓名   =================
                           @Column(name="OWNER_NAME")
             public String getOwnerName(){
                    return this.ownerName;
             }
         
             public void setOwnerName(String ownerName){
                    this.ownerName = ownerName;
             }
                       //===============  数据源   =================
                           @Column(name="SOURCE")
             public String getSource(){
                    return this.source;
             }
         
             public void setSource(String source){
                    this.source = source;
             }
                       //===============  已还金额   =================
                           @Column(name="PAID_MONEY")
             public Double getPaidMoney(){
                    return this.paidMoney;
             }
         
             public void setPaidMoney(Double paidMoney){
                    this.paidMoney = paidMoney;
             }
                       //===============  手机号   =================
                           @Column(name="OWNER_MOBILE_NUMBER")
             public String getOwnerMobileNumber(){
                    return this.ownerMobileNumber;
             }
         
             public void setOwnerMobileNumber(String ownerMobileNumber){
                    this.ownerMobileNumber = ownerMobileNumber;
             }
                       //===============  法人、控股股东或其他   =================
                           @Column(name="CASE_OWNER_TYPE")
             public String getCaseOwnerType(){
                    return this.caseOwnerType;
             }
         
             public void setCaseOwnerType(String caseOwnerType){
                    this.caseOwnerType = caseOwnerType;
             }
                
  }
  

