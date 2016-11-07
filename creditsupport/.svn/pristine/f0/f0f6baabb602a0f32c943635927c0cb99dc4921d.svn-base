package com.yodata.creditsupport.dao;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.UserRoleEntity;
import com.yodata.creditsupport.util.ConstantBean;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRoleDao extends SimpleHibernateDao<UserRoleEntity,java.lang.Integer>{

    private final Log log= LogFactory.getLog(UserRoleDao.class);
    
    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Autowired
    private ConstantBean constant;
    
    public int deleteUserRole(Integer userId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        int num = 0;
        try {
            String hql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlDeleteUserRole(), params);
            num = this.batchExecute(hql);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error("SQL文件解析出错", e);
            throw e;
        }
        return num;
    }


}