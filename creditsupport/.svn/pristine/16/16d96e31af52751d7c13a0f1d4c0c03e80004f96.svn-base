package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 高管信息
 */
@Entity
@Table(name ="ods_top_manager_info", catalog="credit_db")
public class TopManagerInfoEntity implements Serializable {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 1968897234228987367L;
	
	private Integer id;				// 自增主键
	private String regId;	// 企业ID
	private String name;			// 高管名称
	private String position;		// 高管职务
	
	private String sex;             //性别
	private String phone;           //联系电话
	private String identifyType; 	//证件类型
	private String identifyNo; 		//证件号码
	
	
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
	
	@Column(name="name", length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="position", length=100)
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name="SEX")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name="TELEPHONE_NO")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="IDENTIFY_TYPE")
	public String getIdentifyType() {
		return identifyType;
	}
	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}
	
	@Column(name="IDENTIFY_NO")
	public String getIdentifyNo() {
		return identifyNo;
	}
	public void setIdentifyNo(String identifyNo) {
		this.identifyNo = identifyNo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TopManagerInfoEntity other = (TopManagerInfoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TopManagerInfoEntity [id=" + id + ", regId=" + regId + ", name=" + name + ", position="
				+ position + "]";
	}
}
