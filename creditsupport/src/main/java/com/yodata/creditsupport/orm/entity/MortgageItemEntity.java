package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 动产抵押物信息
 */
@Entity
@Table(name ="ods_mortgage_item", catalog="credit_db")
public class MortgageItemEntity implements Serializable {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 6851839307867539396L;
	
	private Integer id;				// 自增主键
	
	private String morRegId; //抵押ID
	private Double quan; //数量 
	private String guaName; //抵押物名称
	private Double value; //价值
	
	@Column(name="MOR_REG_ID")
	public String getMorRegId() {
		return morRegId;
	}
	public void setMorRegId(String morRegId) {
		this.morRegId = morRegId;
	}
	
	@Column(name="QUAN")
	public Double getQuan() {
		return quan;
	}
	public void setQuan(Double quan) {
		this.quan = quan;
	}
	@Column(name="GUA_NAME")
	public String getGuaName() {
		return guaName;
	}
	public void setGuaName(String guaName) {
		this.guaName = guaName;
	}
	@Column(name="VALUE")
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
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
		MortgageItemEntity other = (MortgageItemEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AgentChangeEntity [id=" + id + ", morRegId=" + morRegId + "]";
	}
}
