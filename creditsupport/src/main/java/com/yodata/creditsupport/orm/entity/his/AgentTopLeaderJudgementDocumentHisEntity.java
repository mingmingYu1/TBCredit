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
@Table(name = "ods_agent_top_leader_judgement_document_his", catalog = "credit_db")
public class AgentTopLeaderJudgementDocumentHisEntity implements Serializable{

	private static final long serialVersionUID = -7845859259422597256L;
	
	    private Integer id; // 自增主键
		
	    private String regId; // 企业注册号

		// =============== 裁判文书ID =================
		private String docId;

		// =============== 审结时间 =================
		private Date date;

		// =============== 文书类型 =================
		private String caseType;

		// =============== 内容 =================
		private String content;

		// =============== 法院名称 =================
		private String court;

		// =============== 案由编码 =================
		private String caseCauseCode;

		// =============== 标题 =================
		private String title;

		// =============== 审判员 =================
		private String judger;

		// =============== 案号 =================
		private String caseNo;

		// =============== 法人、控股股东或其他 =================
		private String caseOwnerType;

		private String fileNo;			// 文件编号
		private Date createTime;		// 生成时间
		
	   public AgentTopLeaderJudgementDocumentHisEntity() {
			// TODO Auto-generated constructor stub
		}
		
	   public AgentTopLeaderJudgementDocumentHisEntity(String fileNo,Date createTime) {
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

		@Column(name = "DOC_ID")
		public String getDocId() {
			return docId;
		}

		public void setDocId(String docId) {
			this.docId = docId;
		}

		@Column(name = "DATE")
		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		@Column(name = "CASE_TYPE")
		public String getCaseType() {
			return caseType;
		}

		public void setCaseType(String caseType) {
			this.caseType = caseType;
		}

		@Column(name = "CONTENT")
		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		@Column(name = "COURT")
		public String getCourt() {
			return court;
		}

		public void setCourt(String court) {
			this.court = court;
		}

		@Column(name = "CASE_CAUSE_CODE")
		public String getCaseCauseCode() {
			return caseCauseCode;
		}

		public void setCaseCauseCode(String caseCauseCode) {
			this.caseCauseCode = caseCauseCode;
		}

		@Column(name = "TITLE")
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		@Column(name = "JUDGER")
		public String getJudger() {
			return judger;
		}

		public void setJudger(String judger) {
			this.judger = judger;
		}

		@Column(name = "CASE_NO")
		public String getCaseNo() {
			return caseNo;
		}

		public void setCaseNo(String caseNo) {
			this.caseNo = caseNo;
		}

		@Column(name = "CASE_OWNER_TYPE")
		public String getCaseOwnerType() {
			return caseOwnerType;
		}
		public void setCaseOwnerType(String caseOwnerType) {
			this.caseOwnerType = caseOwnerType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}


		@Override
		public String toString() {
			return "AgentChangeEntity [id=" + id + ", regId=" + regId + ", title=" + title + "]";
		}

}
