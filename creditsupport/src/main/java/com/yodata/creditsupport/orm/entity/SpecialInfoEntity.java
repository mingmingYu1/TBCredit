package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 特殊事项（法院对企业、法人、行政处罚）
 */
@Entity
@Table(name ="ods_special_info", catalog="credit_db")
public class SpecialInfoEntity implements Serializable {

	private static final long serialVersionUID = 1136984964215304742L;
	
	private Integer id;				//自增主键
	private String regId;		//企业ID
	private String name;			//被执行人姓名(特殊事项)
	private String object;			//执行标的(特殊事项)
	private String court;			//执行法院(特殊事项)
	private String status;			//案件状态(特殊事项) -- 1未执行完毕/2执行完毕
	private String num;				//案号(特殊事项)
	private Date caseDate;			//立案时间(特殊事项)
	private Date getinfoDate;		//信息获取日期(特殊事项)
	private String type;			//企业负责人/企业/行政管理 -- 1/2/3
	
	private String statuName;		//转换后的案件状态名称
	
	private String caseNo;      //案号
	private String sex; 
    private Integer age;    
    private String cardNumber;   //省份证号
    private String indentityDepature;        //省份证始发地
    private String head;                      //法定代表人
    private Date filingDate;                  //立案时间
    private String executeTarget;               //执行标的
    private String province;    //省份
    private Integer foucsNum;      //关注次数
    private String caseStatus;  //案件状态
    
    private String ageStr;
    private String foucsNumStr;
    
    @Transient
    public String getFoucsNumStr() {
		return foucsNumStr;
	}
	public void setFoucsNumStr(String foucsNumStr) {
		this.foucsNumStr = foucsNumStr;
	}
	@Transient
    public String getAgeStr() {
		return ageStr;
	}
	public void setAgeStr(String ageStr) {
		this.ageStr = ageStr;
	}
	@Column(name="IDENTITY_DEPATURE")
    public String getIndentityDepature() {
		return indentityDepature;
	}
	public void setIndentityDepature(String indentityDepature) {
		this.indentityDepature = indentityDepature;
	}
	@Column(name="CASE_NO")
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	
	@Column(name="SEX")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name="AGE")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Column(name="CARD_NUMBER")
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Column(name="HEAD")
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	
	@Column(name="FILING_DATE")
	public Date getFilingDate() {
		return filingDate;
	}
	public void setFilingDate(Date filingDate) {
		this.filingDate = filingDate;
	}
	
	@Column(name="EXECUTE_TARGET")
	public String getExecuteTarget() {
		return executeTarget;
	}
	public void setExecuteTarget(String executeTarget) {
		this.executeTarget = executeTarget;
	}
	
	@Column(name="PROVINCE")
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	@Column(name="FOCUS_NUMBER")
	public Integer getFoucsNum() {
		return foucsNum;
	}
	public void setFoucsNum(Integer foucsNum) {
		this.foucsNum = foucsNum;
	}
	
	@Column(name="CASE_STATE")
	public String getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
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
	
	@Column(name="reg_id")
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	
	@Column(name="NAME", length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="OBJECT", length=300)
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	
	@Column(name="COURT", length=30)
	public String getCourt() {
		return court;
	}
	public void setCourt(String court) {
		this.court = court;
	}
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="NUM", length=100)
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	@Column(name="CASE_DATE")
	public Date getCaseDate() {
		return caseDate;
	}
	public void setCaseDate(Date caseDate) {
		this.caseDate = caseDate;
	}
	
	@Column(name="GETINFO_DATE")
	public Date getGetinfoDate() {
		return getinfoDate;
	}
	public void setGetinfoDate(Date getinfoDate) {
		this.getinfoDate = getinfoDate;
	}
	
	@Column(name="TYPE")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Transient
	public String getStatuName() {
		return statuName;
	}
	public void setStatuName(String statuName) {
		this.statuName = statuName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpecialInfoEntity other = (SpecialInfoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SpecialInfoEntity [id=" + id + ", regId=" + regId + ", name=" + name + ", object=" + object + ", court="
				+ court + ", status=" + status + ", num=" + num + ", caseDate=" + caseDate + ", getinfoDate="
				+ getinfoDate + ", type=" + type + "]";
	}
}
