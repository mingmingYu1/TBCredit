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

import org.apache.commons.lang3.time.DateFormatUtils;

@Entity
@Table(name = "sp_score_level", catalog = "credit_db")
public class ScoreLevelEntity implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -4971659000205179184L;
	
	/** 主键  */
	private Integer id;
	/** 评分等级编号  */
	private String levelCode;
	/** 得分区间  */
	private String levelScore;
	/** 得分区间最小值  */
    private Integer levelScoreMin;
    /** 得分区间最大值  */
    private Integer levelScoreMax;
	/** 评分等级  */
	private String levelName;
	/** 信用评定  */
	private String levelDesc;
	/** 信用评分建议  */
	private String remark;
	/** 创建人 */
    private String createUser;
    /** 创建时间 */
    private Date createTime;
    /** 创建时间字符串 */
    @SuppressWarnings("unused")
    private String createTimeStr;
	/** 备用1 */
	private Integer levelVersion;
	/** 备用2 */
	private String reserve2;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sc_lvl_id", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    @Column(name="sc_lvl_code")
	public String getLevelCode() {
		return levelCode == null ? "" : levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	
	@Column(name="sc_lvl_area", nullable = false)
	public String getLevelScore() {
		return levelScore;
	}
	public void setLevelScore(String levelScore) {
		this.levelScore = levelScore;
	}
	
	@Column(name="sc_lvl_min", nullable = false)
	public Integer getLevelScoreMin() {
        return levelScoreMin;
    }
    public void setLevelScoreMin(Integer levelScoreMin) {
        this.levelScoreMin = levelScoreMin;
    }
    
    @Column(name="sc_lvl_max", nullable = false)
    public Integer getLevelScoreMax() {
        return levelScoreMax;
    }
    public void setLevelScoreMax(Integer levelScoreMax) {
        this.levelScoreMax = levelScoreMax;
    }
    @Column(name="sc_lvl_name", nullable = false)
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	@Column(name="cre_assess", nullable = true)
	public String getLevelDesc() {
		return levelDesc;
	}
	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}
	
	@Column(name="cre_sc_offer", nullable = true)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
    @Transient
    public String getCreateTimeStr() {
        return this.createTime == null ? null 
                : DateFormatUtils.format(this.createTime, "yyyy-MM-dd");
    }
    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
    @Column(name="sc_lvl_version", nullable = true)
    public Integer getLevelVersion() {
		return levelVersion;
	}
	public void setLevelVersion(Integer levelVersion) {
		this.levelVersion = levelVersion;
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
		return "ScoreLevelEntity [levelCode=" + levelCode + ", levelName=" + levelName + ", levelDesc=" + levelDesc
				+ ", remark=" + remark + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((levelCode == null) ? 0 : levelCode.hashCode());
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
		ScoreLevelEntity other = (ScoreLevelEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (levelCode == null) {
			if (other.levelCode != null)
				return false;
		} else if (!levelCode.equals(other.levelCode))
			return false;
		return true;
	}
	
}