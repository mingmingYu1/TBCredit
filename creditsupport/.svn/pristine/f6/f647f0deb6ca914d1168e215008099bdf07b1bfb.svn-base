/******************************************************************************
 * Copyright (C) 2016 Yodata Co.,Ltd
 * All Rights Reserved.
 * 该软件有前海云游数据开发并拥有版权，在未经得前海云游数据有限公司正式书面授权情况下，
 * 任何公司，个人或者团体不得擅自修改，发布，使用本软件。违者必究。
 ******************************************************************************/
  package com.yodata.creditsupport.orm.entity;
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
 * 违法违规裁判文书
 * @version 2016-6-21 18:01:02 ${user}
 */
  @Entity
  @Table(name="ods_agent_judgement_document",catalog="credit_db")
  public class AgentJudgementDocumentEntity implements Serializable{
      
	private static final long serialVersionUID = -7658526827432516172L;

	public AgentJudgementDocumentEntity(){
       
       }
       
       //遍历所有的字段,columnMap
                     //===============  自增主键   =================
             private  Integer  id;
             
                     //===============  工商注册号   =================
             private  String  regId;
             
                     //===============  流水号   =================
             private  String  serialNo;
             
                     //===============  裁判文书ID   =================
             private  String  cpwsId;
             
                     //===============  内容   =================
             private  String  content;
             
                     //===============  标题   =================
             private  String  title;
             
                     //===============  审结时间   =================
             private  String  endTime;
             
                     //===============  法院名称   =================
             private  String  court;
             
                     //===============  案号   =================
             private  String  caseNo;
             
                     //===============     =================
             private  Date  addTime;
              
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
                       //===============  流水号   =================
             @Column(name="SERIAL_NO")
             public String getSerialNo(){
                    return this.serialNo;
             }
         
             public void setSerialNo(String serialNo){
                    this.serialNo = serialNo;
             }
                       //===============  裁判文书ID   =================
             @Column(name="CPWS_ID")
             public String getCpwsId(){
                    return this.cpwsId;
             }
         
             public void setCpwsId(String cpwsId){
                    this.cpwsId = cpwsId;
             }
                       //===============  内容   =================
             @Column(name="CONTENT")
             public String getContent(){
                    return this.content;
             }
         
             public void setContent(String content){
                    this.content = content;
             }
                       //===============  标题   =================
             @Column(name="TITLE")
             public String getTitle(){
                    return this.title;
             }
         
             public void setTitle(String title){
                    this.title = title;
             }
                       //===============  审结时间   =================
             @Column(name="END_TIME")
             public String getEndTime(){
                    return this.endTime;
             }
         
             public void setEndTime(String endTime){
                    this.endTime = endTime;
             }
                       //===============  法院名称   =================
                           @Column(name="COURT")
             public String getCourt(){
                    return this.court;
             }
         
             public void setCourt(String court){
                    this.court = court;
             }
                       //===============  案号   =================
                           @Column(name="CASE_NO")
             public String getCaseNo(){
                    return this.caseNo;
             }
         
             public void setCaseNo(String caseNo){
                    this.caseNo = caseNo;
             }
                       //===============     =================
                           @Column(name="ADD_TIME")
             public Date getAddTime(){
                    return this.addTime;
             }
         
             public void setAddTime(Date addTime){
                    this.addTime = addTime;
             }
                
       
  }
