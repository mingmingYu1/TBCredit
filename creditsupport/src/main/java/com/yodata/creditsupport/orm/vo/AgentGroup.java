package com.yodata.creditsupport.orm.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
 
public class AgentGroup implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5156534343247113404L;
	
	private java.lang.Integer groupId;
    private java.lang.String groupName;
	public java.lang.Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(java.lang.Integer groupId) {
		this.groupId = groupId;
	}
	public java.lang.String getGroupName() {
		return groupName;
	}
	public void setGroupName(java.lang.String groupName) {
		this.groupName = groupName;
	}
    
    
}