package com.yodata.creditsupport.orm.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5486791186730635112L;
	/**主键**/
	private Integer menuId;
	/**菜单名称**/
	private String menuName;
	/**是否可用**/
	private String status;
	/**创建时间**/
	private Timestamp createTime;
	/**访问路径**/
	private String url;
	/**排序**/
	private int sort;
	/**上级编号**/
	private Integer parentId;
	/**是否被选中*/
	private int isSelected;
	/**下级菜单**/
	private List<Menu> subMenuList;//子菜单集合 
	
    public Integer getMenuId() {
        return menuId;
    }
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getSort() {
        return sort;
    }
    public void setSort(int sort) {
        this.sort = sort;
    }
    public Integer getParentId() {
        return parentId;
    }
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public int getIsSelected() {
        return isSelected;
    }
    public void setIsSelected(int isSelected) {
        this.isSelected = isSelected;
    }
    public List<Menu> getSubMenuList() {
        return subMenuList;
    }
    public void setSubMenuList(List<Menu> subMenuList) {
        this.subMenuList = subMenuList;
    }

}
