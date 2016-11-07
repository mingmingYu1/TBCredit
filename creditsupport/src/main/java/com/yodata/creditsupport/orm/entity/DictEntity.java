package com.yodata.creditsupport.orm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 * 分类字典
 * @author Anna
 *
 */
@Entity
@Table(name ="ods_dict", catalog="credit_db")
public class DictEntity {
    private Integer id;		    //ID
    private String category;	//类别名称
    private String name;		//名称
    private String descible;    //描述
    private String value;       //值
    
    @Id
    @Column(name="id", nullable = false)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="category")
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="descible")
    public String getDescible() {
        return descible;
    }
    public void setDescible(String descible) {
        this.descible = descible;
    }
    
    @Column(name="value")
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
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
        DictEntity other = (DictEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "DictEntity [category=" + category + ", name=" + name + ", value=" + value + "]";
    }       
    
}