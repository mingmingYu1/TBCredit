package com.yodata.creditsupport.orm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 纬度模型
 * @author liujin
 *
 */
@Entity
@Table(name ="dm_enterprise_bas_model", catalog="credit_db")
public class DimModelEntity {
    private Integer id;			//ID
    private String indicator;	//指标
    private String type;		//算法类型：Delphi专家法， RF随机森林， LR逻辑回归
    private double weight;		//权重
    private Date createTime;	//创建时间
    
    
    @Id
    @Column(name="ID" , nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="INDICATOR" , nullable = true)
	public String getIndicator() {
		return indicator;
	}
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	
	@Column(name="TYPE" , nullable = true)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name="WEIGHT" , nullable = true)
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Column(name="CREATE_TIME" , nullable = true)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
		DimModelEntity other = (DimModelEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DimModelEntity [id=" + id + ", indicator=" + indicator + ", type=" + type+ ", weight=" + weight+ ", createTime=" + createTime + "]";
	}
    
}