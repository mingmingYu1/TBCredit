
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
 * @version 2016-6-22 10:37:29 ${user}
 */
  @Entity
  @Table(name="ods_agent_top_leader_court_exposure_his", catalog="credit_db")
  public class AgentTopleaderCourExposureHisEntity implements Serializable{
  
	private static final long serialVersionUID = 3580107003216229632L;


                     //===============  自增主键   =================
             private  Integer  id;
             
                     //===============  工商注册号   =================
             private  String  regId;
             
                     //===============  创建时间   =================
             private  Date  createTime;
             
                     //===============  文件编号   =================
             private  String  fileNo;
             
                     //===============  曝光台ID   =================
             private  String  exposureId;
             
                     //===============  立案日期   =================
             private  Date  caseDate;
             
                     //===============  内容   =================
             private  String  content;
             
                     //===============  曝光日期   =================
             private  Date  exposureDate;
             
                     //===============  当事人类型   =================
             private  String  ownerType;
             
                     //===============  法院名称   =================
             private  String  court;
             
                     //===============  申请人   =================
             private  String  applicant;
             
                     //===============  身份证/组织机构代码   =================
             private  String  ownerIdentCardNo;
             
                     //===============  案由   =================
             private  String  caseCause;
             
                     //===============  未执行金额   =================
             private  Double  ownedMoney;
             
                     //===============  地址   =================
             private  String  ownerAddress;
             
                     //===============  当事人   =================
             private  String  litigant;
             
                     //===============  案号   =================
             private  String  caseNo;
             
                     //===============  依据   =================
             private  String  basis;
             
                     //===============  标的金额   =================
             private  Double  applyMoney;
             
                     //===============  高管、控股股东或其他   =================
             private  String  caseOwnerType;
             
              
             public AgentTopleaderCourExposureHisEntity() {
         		// TODO Auto-generated constructor stub
         	}
         	
            public AgentTopleaderCourExposureHisEntity(String fileNo,Date createTime) {
         		// TODO Auto-generated constructor stub
         	   this.fileNo = fileNo;
         	   this.createTime = createTime;
         	}
             
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
                       //===============  曝光台ID   =================
                           @Column(name="EXPOSURE_ID")
             public String getExposureId(){
                    return this.exposureId;
             }
         
             public void setExposureId(String exposureId){
                    this.exposureId = exposureId;
             }
                       //===============  立案日期   =================
                           @Column(name="CASE_DATE")
             public Date getCaseDate(){
                    return this.caseDate;
             }
         
             public void setCaseDate(Date caseDate){
                    this.caseDate = caseDate;
             }
                       //===============  内容   =================
                           @Column(name="CONTENT")
             public String getContent(){
                    return this.content;
             }
         
             public void setContent(String content){
                    this.content = content;
             }
                       //===============  曝光日期   =================
                           @Column(name="EXPOSURE_DATE")
             public Date getExposureDate(){
                    return this.exposureDate;
             }
         
             public void setExposureDate(Date exposureDate){
                    this.exposureDate = exposureDate;
             }
                       //===============  当事人类型   =================
                           @Column(name="OWNER_TYPE")
             public String getOwnerType(){
                    return this.ownerType;
             }
         
             public void setOwnerType(String ownerType){
                    this.ownerType = ownerType;
             }
                       //===============  法院名称   =================
                           @Column(name="COURT")
             public String getCourt(){
                    return this.court;
             }
         
             public void setCourt(String court){
                    this.court = court;
             }
                       //===============  申请人   =================
                           @Column(name="APPLICANT")
             public String getApplicant(){
                    return this.applicant;
             }
         
             public void setApplicant(String applicant){
                    this.applicant = applicant;
             }
                       //===============  身份证/组织机构代码   =================
                           @Column(name="OWNER_IDENT_CARD_NO")
             public String getOwnerIdentCardNo(){
                    return this.ownerIdentCardNo;
             }
         
             public void setOwnerIdentCardNo(String ownerIdentCardNo){
                    this.ownerIdentCardNo = ownerIdentCardNo;
             }
                       //===============  案由   =================
                           @Column(name="CASE_CAUSE")
             public String getCaseCause(){
                    return this.caseCause;
             }
         
             public void setCaseCause(String caseCause){
                    this.caseCause = caseCause;
             }
                       //===============  未执行金额   =================
                           @Column(name="OWNED_MONEY")
             public Double getOwnedMoney(){
                    return this.ownedMoney;
             }
         
             public void setOwnedMoney(Double ownedMoney){
                    this.ownedMoney = ownedMoney;
             }
                       //===============  地址   =================
                           @Column(name="OWNER_ADDRESS")
             public String getOwnerAddress(){
                    return this.ownerAddress;
             }
         
             public void setOwnerAddress(String ownerAddress){
                    this.ownerAddress = ownerAddress;
             }
                       //===============  当事人   =================
                           @Column(name="LITIGANT")
             public String getLitigant(){
                    return this.litigant;
             }
         
             public void setLitigant(String litigant){
                    this.litigant = litigant;
             }
                       //===============  案号   =================
                           @Column(name="CASE_NO")
             public String getCaseNo(){
                    return this.caseNo;
             }
         
             public void setCaseNo(String caseNo){
                    this.caseNo = caseNo;
             }
                       //===============  依据   =================
                           @Column(name="BASIS")
             public String getBasis(){
                    return this.basis;
             }
         
             public void setBasis(String basis){
                    this.basis = basis;
             }
                       //===============  标的金额   =================
                           @Column(name="APPLY_MONEY")
             public Double getApplyMoney(){
                    return this.applyMoney;
             }
         
             public void setApplyMoney(Double applyMoney){
                    this.applyMoney = applyMoney;
             }
                       //===============  高管、控股股东或其他   =================
                           @Column(name="CASE_OWNER_TYPE")
             public String getCaseOwnerType(){
                    return this.caseOwnerType;
             }
         
             public void setCaseOwnerType(String caseOwnerType){
                    this.caseOwnerType = caseOwnerType;
             }
                
  }
  

