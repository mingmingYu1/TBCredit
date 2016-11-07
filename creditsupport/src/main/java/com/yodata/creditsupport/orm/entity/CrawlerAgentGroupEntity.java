package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "sp_crawler_agent_group", catalog = "credit_db")
public class CrawlerAgentGroupEntity implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5156534343247113404L;
	
	private Integer groupId;
    private String groupName;
    
    private List<CrawlerAgentInfoEntity> agentinfos = new ArrayList<CrawlerAgentInfoEntity>();//公司名称
//    private List<InfoGroupEntity> infogroup = new ArrayList<InfoGroupEntity>();//公司名称和分组名称中间表
    @Transient
    public List<CrawlerAgentInfoEntity> getAgentinfos() {
		return agentinfos;
	}

	public void setAgentinfos(List<CrawlerAgentInfoEntity> agentinfos) {
		this.agentinfos = agentinfos;
	}
	
//	public List<InfoGroupEntity> getInfogroup() {
//		return infogroup;
//	}
//
//	public void setInfogroup(List<InfoGroupEntity> infogroup) {
//		this.infogroup = infogroup;
//	}o

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)//这个注解表示这个表在数据库中它是自增的
    @Column(name="group_id" , nullable = false)
    public java.lang.Integer getGroupId(){
        return this.groupId;
    }

    public void setGroupId(java.lang.Integer id){
        this.groupId=id;
    }
    
    @Column(name="group_name" , nullable = false) 
    public java.lang.String getGroupName() {
		return groupName;
	}
  	
    public void setGroupName(java.lang.String groupName) {
		this.groupName = groupName;
	}
    
    
    
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
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
        CrawlerAgentGroupEntity other = (CrawlerAgentGroupEntity) obj;
        if (groupId == null) {
            if (other.groupId != null)
                return false;
        } else if (!groupId.equals(other.groupId))
            return false;
        return true;
    }
}