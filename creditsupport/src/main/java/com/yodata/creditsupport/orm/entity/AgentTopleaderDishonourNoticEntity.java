package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ods_agnet_top_leader_dishonour_notice", catalog="credit_db")
public class AgentTopleaderDishonourNoticEntity implements Serializable{

	private static final long serialVersionUID = 7338122322047923532L;
	
	private Integer id;				// 自增主键
	private String regId;	        // 企业注册号
	private Date caseTime;              //立案时间
	private String dishonourSex;        //性别
	private String proformanceStatus;   // 被执行人的履行情况
	private String dishounrNoticeId;    // 失信公告ID
	private String documentId;          //执行依据文号
	private String court;              //执行法院名称
	private String identityId;         //身份证/组织结构代码
	private String enforceBasisUnit;   //做出执行依据单文
	private String caseType;           //数据类型
	private String behivourDescrible;  //失信被执行人行为具体情形
	private String obligition;         //生效法律文书确定的义务
	private int dishonourAge;          //年龄
    private String matchDegree;        //匹配度
    private String dishonourName;      //姓名
    private String caseProvince;       //省份
    private String caseNo;             //案号
    private Date noticeTime;          //发布时间
    private String caseOwnerType;     //
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="REG_ID")
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	
	@Column(name="CASE_TIME")
	public Date getCaseTime() {
		return caseTime;
	}
	public void setCaseTime(Date caseTime) {
		this.caseTime = caseTime;
	}
	
	@Column(name="DISHONOUR_SEX")
	public String getDishonourSex() {
		return dishonourSex;
	}
	public void setDishonourSex(String dishonourSex) {
		this.dishonourSex = dishonourSex;
	}
	
	@Column(name="PROFORMANCE_STATUS")
	public String getProformanceStatus() {
		return proformanceStatus;
	}
	public void setProformanceStatus(String proformanceStatus) {
		this.proformanceStatus = proformanceStatus;
	}
	
	@Column(name="DISHOUNR_NOTICE_ID")
	public String getDishounrNoticeId() {
		return dishounrNoticeId;
	}
	public void setDishounrNoticeId(String dishounrNoticeId) {
		this.dishounrNoticeId = dishounrNoticeId;
	}
	
	@Column(name="DOCUMENT_ID")
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	
	@Column(name="COURT")
	public String getCourt() {
		return court;
	}
	public void setCourt(String court) {
		this.court = court;
	}
	
	@Column(name="IDENTITY_ID")
	public String getIdentityId() {
		return identityId;
	}
	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}
	
	@Column(name="ENFORCE_BASIS_UNIT")
	public String getEnforceBasisUnit() {
		return enforceBasisUnit;
	}
	public void setEnforceBasisUnit(String enforceBasisUnit) {
		this.enforceBasisUnit = enforceBasisUnit;
	}
	
	@Column(name="CASE_TYPE")
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	
	@Column(name="BEHIVOUR_DESCRIBLE")
	public String getBehivourDescrible() {
		return behivourDescrible;
	}
	public void setBehivourDescrible(String behivourDescrible) {
		this.behivourDescrible = behivourDescrible;
	}
	
	@Column(name="OBLIGITION")
	public String getObligition() {
		return obligition;
	}
	public void setObligition(String obligition) {
		this.obligition = obligition;
	}
	
	@Column(name="DISHONOUR_AGE")
	public int getDishonourAge() {
		return dishonourAge;
	}
	public void setDishonourAge(int dishonourAge) {
		this.dishonourAge = dishonourAge;
	}
	
	@Column(name="MATCH_DEGREE")
	public String getMatchDegree() {
		return matchDegree;
	}
	public void setMatchDegree(String matchDegree) {
		this.matchDegree = matchDegree;
	}
	
	@Column(name="DISHONOUR_NAME")
	public String getDishonourName() {
		return dishonourName;
	}
	public void setDishonourName(String dishonourName) {
		this.dishonourName = dishonourName;
	}
	
	@Column(name="CASE_PROVINCE")
	public String getCaseProvince() {
		return caseProvince;
	}
	public void setCaseProvince(String caseProvince) {
		this.caseProvince = caseProvince;
	}
	
	@Column(name="CASE_NO")
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	
	@Column(name="NOTICE_TIME")
	public Date getNoticeTime() {
		return noticeTime;
	}
	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}
	
	@Column(name="CASE_OWNER_TYPE")
	public String getCaseOwnerType() {
		return caseOwnerType;
	}
	public void setCaseOwnerType(String caseOwnerType) {
		this.caseOwnerType = caseOwnerType;
	}
	
}
