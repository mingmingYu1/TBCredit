package com.yodata.creditsupport.dao;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.core.domain.Page;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.RoleEntity;
import com.yodata.creditsupport.orm.vo.Role;
import com.yodata.creditsupport.util.ConstantBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleDao extends SimpleHibernateDao<RoleEntity,java.lang.Integer>{
    private final Log log= LogFactory.getLog(RoleDao.class);
    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Autowired
    private ConstantBean constant;
    
    public int deleteRoleMenu(Integer roleId) throws DataAccessException {
        int num = 0;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleId", roleId);
        try {
            String hql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlDeleteRoleMenu(), params);
            num = this.batchExecute(hql);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    public Page<Role> getPageRoles(String roleName, Page<Role> page) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleName", roleName);
        try {
            String countSql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlGetPageRoles() + constant.getSqlCount(), params);
            Query query = this.getSQLQuery(countSql);
            List<Object> countList = query.list();
            
            String count = countList.get(0)==null?"0":countList.get(0).toString();
            page.setCount(Integer.parseInt(count));
            
            String dataSql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetPageRoles(), params);
            query = this.getSQLQuery(dataSql);
            query.setFirstResult(page.getCurrent()*page.getCountPerPage()-page.getCountPerPage());
            query.setMaxResults(page.getCountPerPage());
            query.setResultTransformer(Transformers.aliasToBean(Role.class));
            
            List<Role> roleList = query.list();
            page.setDate(roleList);
            
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw e;
        }
        
        return page;
    }

}