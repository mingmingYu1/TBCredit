package com.yodata.creditsupport.orm.entity.his;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name ="ods_agent_court_enforcement_info_his", catalog="credit_db")
public class AgentCourEnforcementHisEntity implements Serializable{

	private static final long serialVersionUID = -5790617017872029781L;

	private Integer id;				// 自增主键
	private String regId;	   // 企业注册号
	private String exeId;     //执行公告ID
	private Date caseDate;    //立案时间
	private String content;    //内容
	private String title;      //标题
	private String status;     //执行状态
	private String executee;   //被执行人姓名
	private String court;      //执行法院名称
	private String applicant;  //申请人
	private String caseNo;      //案号
	private String caseStatus; //案件状态
	private String idCardNo;   //身份证/组织结构代码
	private double execMoney;  //执行标的
	
	private String conDateStr;		// 日期格式化字符
	
	private String fileNo;			// 文件编号
	private Date createTime;		// 生成时间
	
   public AgentCourEnforcementHisEntity() {}
	
   public AgentCourEnforcementHisEntity(String fileNo,Date createTime) 
   {
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
	
	@Column(name="EXE_ID")
	public String getExeId() {
		return exeId;
	}
	public void setExeId(String exeId) {
		this.exeId = exeId;
	}
	
	@Column(name="CASE_TIME")
	public Date getCaseDate() {
		return caseDate;
	}
	public void setCaseDate(Date caseDate) {
		this.caseDate = caseDate;
	}
	
	@Column(name="CONTENT")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="EXECUTEE")
	public String getExecutee() {
		return executee;
	}
	public void setExecutee(String executee) {
		this.executee = executee;
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
	
	@Column(name="CASE_NO")
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	
	@Column(name="CASE_STATUS")
	public String getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}
	
	@Column(name="ID_CARD_NO")
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	
	@Column(name="EXEC_MONEY")
	public double getExecMoney() {
		return execMoney;
	}
	public void setExecMoney(double execMoney) {
		this.execMoney = execMoney;
	}
	
	@Transient
	public String getConDateStr() {
		if(caseDate != null)
			conDateStr = new SimpleDateFormat("yyyy-MM-dd").format(caseDate);
		return conDateStr;
	}
	public void setConDateStr(String conDateStr) {
		this.conDateStr = conDateStr;
	}
}
