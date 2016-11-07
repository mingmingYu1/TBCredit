package com.yodata.creditsupport.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.MenuEntity;
import com.yodata.creditsupport.orm.entity.RoleMenuEntity;
import com.yodata.creditsupport.orm.vo.Menu;
import com.yodata.creditsupport.util.ConstantBean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

@Component
public class MenuDao extends SimpleHibernateDao<MenuEntity,java.lang.Long>{

    private final Log log= LogFactory.getLog(MenuDao.class);
    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Resource
    private ConstantBean constant;
    
	public void createRolePermission(List<RoleMenuEntity> list) {

		for(RoleMenuEntity role:list){
			getSession().saveOrUpdate(role);
		}
		flush();
	}

    @SuppressWarnings("unchecked")
    public List<Menu> getMenuByRoleId(Integer roleId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleId", roleId);
        try {
            String sql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlGetMenuByRoleId(), params);
            Query query = this.getSQLQuery(sql);
            List<Object> list = query.list();
            
            List<Menu> menuList = new ArrayList<>();
            if(list!=null && list.size()>0){
                for (int i = 0; i < list.size(); i++) {
                    Object[] objs = (Object[]) list.get(i);
                    Menu menu = new Menu();
                    menu.setMenuId((Integer) objs[0]);
                    menu.setMenuName(objs[1]==null?"":objs[1].toString());
                    menu.setParentId(new Integer(objs[2].toString()));
                    menu.setIsSelected(Integer.parseInt(objs[3].toString()));
                    menuList.add(menu);
                }
            }
            return menuList;
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            throw e;
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Menu> getMenuByUserId(Integer userId) throws DataAccessException {
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        try {
            String sql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlGetMenuByUserId(), params);
            Query query = this.getSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(Menu.class));
            return query.list();
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
	public List<Menu> getMenuByPerUserId(Integer userId) throws DataAccessException {
		// TODO Auto-generated method stub
		 Map<String, Object> params = new HashMap<String, Object>();
	        params.put("userId", userId);
	        try {
	            String sql = dynamicHibernateSqlDao.getNamedQuerySql(
	                    constant.getSqlGetMenuByPerUserId(), params);
	            Query query = this.getSQLQuery(sql);
	            query.setResultTransformer(Transformers.aliasToBean(Menu.class));
	            return query.list();
	        } catch (DataAccessException e) {
	            log.error(e.getMessage(), e);
	            e.printStackTrace();
	            throw e;
	        }
	}
}