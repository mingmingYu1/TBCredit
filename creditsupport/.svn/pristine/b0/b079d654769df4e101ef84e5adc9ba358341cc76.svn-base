package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sp_score_model", catalog="credit_db")
public class ScoreModelEntity implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 3709313538608666307L;
	
	/** 主键  */
	private Integer modelId;
	/** 评分模型编号  */
	private String modelCode;
	/** 评分模型名称  */
	private String modelName;
	/** 评分模型描述  */
	private String modelDesc;
	/** 算法描述  */
	private String algorithmDesc;
	/** 应用场景  */
	private String scene;
	/** 创建人 */
    private String createUser;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
    /** 状态
     * 0:未开发完成，后台算法还没有支持
     * 1:已投入使用，系统已支持该算法
     */
    private int status;
//    /** 创建时间字符类型 */
//    @SuppressWarnings("unused")
//    private String createTimeStr;
	/** 备用1 */
	private String reserve1;
	/** 备用2 */
	private String reserve2;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sm_id", nullable = false)
	public Integer getModelId() {
		return modelId;
	}
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	@Column(name="mod_code")
	public String getModelCode() {
		return modelCode == null ? "" : modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	
	@Column(name="mod_name", nullable = false)
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	@Column(name="mod_desc", nullable = true)
	public String getModelDesc() {
		return modelDesc;
	}
	public void setModelDesc(String modelDesc) {
		this.modelDesc = modelDesc;
	}
	
	@Column(name="algor_desc", nullable = true)
	public String getAlgorithmDesc() {
		return algorithmDesc;
	}
	public void setAlgorithmDesc(String algorithmDesc) {
		this.algorithmDesc = algorithmDesc;
	}
	@Column(name="scene", nullable = true)
    public String getScene() {
        return scene;
    }
    public void setScene(String scene) {
        this.scene = scene;
    }
	@Column(name="create_user")
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    @Column(name="create_time")
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Column(name="update_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name="status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
    @Column(name="reserve1", nullable = true)
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	@Column(name="reserve2", nullable = true)
	public String getReserve2() {
		return reserve2;
	}
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	
	@Override
	public String toString() {
		return "ScoreModelEntity [modelId="+ modelId +",modelCode=" + modelCode + ", modelName=" + modelName + ", modelDesc=" + modelDesc
				+ ", algorithmDesc=" + algorithmDesc + ", createUser=" + createUser + ", createTime="+ createTime + ",updateTime="+updateTime + ",status="+status + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modelId == null) ? 0 : modelId.hashCode());
		result = prime * result + ((modelCode == null) ? 0 : modelCode.hashCode());
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
		ScoreModelEntity other = (ScoreModelEntity) obj;
		if (modelId == null) {
			if (other.modelId != null)
				return false;
		} else if (!modelId.equals(other.modelId))
			return false;
		if (modelCode == null) {
			if (other.modelCode != null)
				return false;
		} else if (!modelCode.equals(other.modelCode))
			return false;
		return true;
	}
}