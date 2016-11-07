package com.yodata.creditsupport.orm.entity.his;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ods_agent_judgement_document_his", catalog="credit_db")
public class AgentJudgementDocumentHisEntity implements Serializable{

	private static final long serialVersionUID = -7682396137385840011L;

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
      	private String fileNo;			// 文件编号
    	private Date createTime;		// 生成时间
    	
       public AgentJudgementDocumentHisEntity() {
    		// TODO Auto-generated constructor stub
    	}
    	
       public AgentJudgementDocumentHisEntity(String fileNo,Date createTime) {
    		// TODO Auto-generated constructor stub
    	   this.fileNo = fileNo;
    	   this.createTime = createTime;
    	}
       
    	@Column(name="FILE_NO")
    	public String getFileNo() {
    		return fileNo;
    	}
    	public void setFileNo(String fileNo) {
    		this.fileNo = fileNo;
    	}
    	@Column(name="CREATE_TIME")
    	public Date getCreateTime() {
    		return createTime;
    	}
    	public void setCreateTime(Date createTime) {
    		this.createTime = createTime;
    	}
          
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
