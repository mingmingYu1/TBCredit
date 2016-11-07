package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity
@Table(name ="sp_user_role", catalog = "credit_db")
public class UserRoleEntity implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1108328888258891357L;
	
	private java.lang.Integer id;
    private java.lang.Integer userId;
    private java.lang.Integer roleId;
    
    public void setId(java.lang.Integer id){
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//这个注解表示这个表在数据库中它是自增的
    @SequenceGenerator(name="gen",sequenceName="seq")
    @Column(name="user_role_id" , nullable = false)
    public java.lang.Integer getId(){
        return this.id;
    }

    public void setUserId(java.lang.Integer userId){
        this.userId = userId;
    }
    
    @Column(name="user_id", nullable = false)
    public java.lang.Integer getUserId(){
        return this.userId;
    }

    public void setRoleId(java.lang.Integer roleId){
        this.roleId = roleId;
    }
    
    @Column(name="role_id", nullable = false)
    public java.lang.Integer getRoleId(){
        return this.roleId;
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
        UserRoleEntity other = (UserRoleEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}