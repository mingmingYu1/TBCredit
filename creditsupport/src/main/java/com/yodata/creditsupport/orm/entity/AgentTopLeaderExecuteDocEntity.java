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
 * 法定代表人失信执行公告信息
 */
@Entity
@Table(name ="ods_agent_top_leader_excute_document", catalog="credit_db")
public class AgentTopLeaderExecuteDocEntity implements Serializable{

	private static final long serialVersionUID = 6436386973653315500L;

	private Integer id;				// 自增主键
	private String regId;   	// 企业注册号
	private Date endTime;     //审结时间
	private String content;   //内容
	private String status;    //执行状态
	private String court;     //法院
	private String applicant;  //申请人
	private String identCardNo;   //身份证/组织结构代码
	private String statement;     //执行公告ID
	private String caseType;      //数据类型
	private String title;         //标题
	private String matchDegree;   //匹配度
	private String name;          //姓名
	private String caseCod;      //案号
	private String caseStatus;    //案件状态
	private double execMony;      //执行标的
	private String caseOwerType;  //
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="reg_id")
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	
	@Column(name="END_TIME")
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Column(name="CONTENT")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="COURT")
	public String getCourt() {
		return court;
	}
	public void setCourt(String court) {
		this.court = court;
	}
	
	@Column(name="APPLICANT")
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	
	@Column(name="IDENT_CARD_NO")
	public String getIdentCardNo() {
		return identCardNo;
	}
	public void setIdentCardNo(String identCardNo) {
		this.identCardNo = identCardNo;
	}
	
	@Column(name="STATEMENT")
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	
	@Column(name="CASE_TYPE")
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	
	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="MATCH_DEGREE")
	public String getMatchDegree() {
		return matchDegree;
	}
	public void setMatchDegree(String matchDegree) {
		this.matchDegree = matchDegree;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="CASE_CODE")
	public String getCaseCod() {
		return caseCod;
	}
	public void setCaseCod(String caseCod) {
		this.caseCod = caseCod;
	}
	
	@Column(name="CASE_STATUS")
	public String getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}
	
	@Column(name="EXEC_MONEY")
	public double getExecMony() {
		return execMony;
	}
	public void setExecMony(double execMony) {
		this.execMony = execMony;
	}
	
	@Column(name="CASE_OWNER_TYPE")
	public String getCaseOwerType() {
		return caseOwerType;
	}
	public void setCaseOwerType(String caseOwerType) {
		this.caseOwerType = caseOwerType;
	}
	
}
