package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 企业属性表（区域、邮编等）
 */
@Entity
@Table(name ="ods_ent_attr_info", catalog="credit_db")
public class EntAttrInfoEntity implements Serializable {

	private static final long serialVersionUID = -2087256693020782813L;
	
	private Integer id;				// 自增主键
	private String regId;		    // 企业ID
	private String district;		// 行政区划
	private String addr;			// 注册地址
	private String tel;				// 注册电话
	private Integer post;			// 邮政编码
	private Integer type;			// 1/2 -- 注册人/联系人
	private String typeName;		// 地址类型名称
	
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
	
	@Column(name="DISTRICT")
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	@Column(name="ADDR")
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Column(name="TEL", length=20)
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Column(name="POST")
	public Integer getPost() {
		return post;
	}
	public void setPost(Integer post) {
		this.post = post;
	}
	
	@Column(name="TYPE")
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Transient
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
		EntAttrInfoEntity other = (EntAttrInfoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EntAttrInfoEntity [id=" + id + ", regId=" + regId + ", district=" + district + ", addr=" + addr
				+ ", tel=" + tel + ", post=" + post + ", type=" + type + "]";
	}
}
