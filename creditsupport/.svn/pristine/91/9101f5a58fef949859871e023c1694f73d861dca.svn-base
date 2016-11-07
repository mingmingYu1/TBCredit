package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 企业得分与算法关联表
 * @author Anna
 *
 */
@Entity
@Table(name = "ods_agent_algor", catalog="credit_db")
public class AgentAlgorEntity implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 3709313538608666307L;
	
	/** 主键  */
	private Integer id;
    /** 企业主键  */
    private String regId;
	/** 评分模型主键  */
	private Integer algorId;
	/** 创建人 */
    private String createUser;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="reg_id", nullable = false)
    public String getRegId() {
        return regId;
    }
    public void setRegId(String regId) {
        this.regId = regId;
    }
    
    @Column(name="algor_id", nullable = false)
    public Integer getAlgorId() {
        return algorId;
    }
    public void setAlgorId(Integer algorId) {
        this.algorId = algorId;
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
    public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
        AgentAlgorEntity other = (AgentAlgorEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "AgentAlgorEntity [id=" + id + ", regId=" + regId + ", algorId=" + algorId + ", createUser="
                + createUser + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
    }
	
}