package com.yodata.creditsupport.orm.person.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
@Entity
@Table(name = "sp_per_menu", catalog = "credit_db")
public class PerMenuEntity implements Serializable{
	
	private static final long serialVersionUID = 5108951624270605955L;
	
	private java.lang.Integer menuId;
    private java.lang.String menuName;
    private java.lang.Integer parentId;
    private java.lang.String status;
    private java.sql.Timestamp createTime;
    private java.lang.String createUser;
    private java.lang.String url;
    private java.lang.String enMenuName;
    private java.lang.Integer sort;
    public void setMenuId(java.lang.Integer id){
        this.menuId=id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//这个注解表示这个表在数据库中它是自增的
    @SequenceGenerator(name="gen",sequenceName="seq")
    @Column(name="menu_id" , nullable = false)
    public java.lang.Integer getMenuId(){
        return this.menuId;
    }

    public void setMenuName(java.lang.String menuName){
        this.menuName=menuName;
    }
    
    @Column(name="menu_name" , nullable = false)
    public java.lang.String getMenuName(){
        return this.menuName;
    }
    
    @Column(name="parent_id" , nullable = true)
    public java.lang.Integer getParentId() {
        return parentId;
    }
    public void setParentId(java.lang.Integer parentId) {
        this.parentId = parentId;
    }

    public void setStatus(java.lang.String status){
        this.status=status;
    }
    
    @Column(name="status", columnDefinition="char")
    public java.lang.String getStatus(){
        return this.status;
    }

    @Column(name="create_time", nullable = true)
    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="create_user", nullable = true)
    public java.lang.String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(java.lang.String createUser) {
        this.createUser = createUser;
    }

    public void setUrl(java.lang.String url){
        this.url=url;
    }
    
    @Column(name="url" , nullable = true)
    public java.lang.String getUrl(){
        return this.url;
    }

    
    public void setSort(java.lang.Integer sort){
        this.sort=sort;
    }
    
    @Column(name="sort" , nullable = true)
    public java.lang.Integer getSort(){
        return this.sort;
    }

    @Column(name="en_menu_name" , nullable = true)
    public java.lang.String getEnMenuName() {
        return enMenuName;
    }
    public void setEnMenuName(java.lang.String enMenuName) {
        this.enMenuName = enMenuName;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
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
        PerMenuEntity other = (PerMenuEntity) obj;
        if (menuId == null) {
            if (other.menuId != null)
                return false;
        } else if (!menuId.equals(other.menuId))
            return false;
        return true;
    }
}