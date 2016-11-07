package com.yodata.creditsupport.orm.entity.his;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 企业属性表（区域、邮编等） -- 历史
 */
@Entity
@Table(name ="ods_ent_attr_info_his", catalog="credit_db")
public class EntAttrInfoHisEntity {

	private Integer id;				// 自增主键
	private String regId;		// 企业属性（地址，联系人）ID
	private String fileNo;			// 文件编号
	private Date createTime;		// 生成时间
	private String district;		// 行政区划
	private String addr;			// 注册地址
	private String tel;				// 注册电话
	private Integer post;			// 邮政编码
	private Integer type;			// 1/2 -- 注册人/联系人
	private String typeName;		// 地址类型名称
	
	public EntAttrInfoHisEntity() {
	}
	public EntAttrInfoHisEntity(String fileNo, Date createTime) {
		this.fileNo = fileNo;
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
		EntAttrInfoHisEntity other = (EntAttrInfoHisEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EntAttrInfoHisEntity [id=" + id + ", regId=" + regId + ", fileNo=" + fileNo + ", createTime="
				+ createTime + ", district=" + district + ", addr=" + addr + ", tel=" + tel + ", post=" + post
				+ ", type=" + type + "]";
	}
}
