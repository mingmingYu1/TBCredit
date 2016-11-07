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
@Table(name ="ods_mortgage_item_his", catalog="credit_db")
public class MortgageItemHisEntity implements Serializable{

	private static final long serialVersionUID = 607114078899315483L;

    private Integer id;				// 自增主键
	
	private String morRegId; //抵押ID
	private Double quan; //数量 
	private String guaName; //抵押物名称
	private Double value; //价值
	
	
	private String fileNo;			// 文件编号
	private Date createTime;		// 生成时间
	
   public MortgageItemHisEntity() {
		// TODO Auto-generated constructor stub
	}
	
   public MortgageItemHisEntity(String fileNo,Date createTime) {
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
	public String toString() {
		return "AgentChangeEntity [id=" + id + ", morRegId=" + morRegId + "]";
	}
}
