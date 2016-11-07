package com.yodata.creditsupport.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.core.domain.Page;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.UserEntity;
import com.yodata.creditsupport.orm.entity.UserRoleEntity;
import com.yodata.creditsupport.orm.person.entity.PerUserEntity;
import com.yodata.creditsupport.orm.vo.User;
import com.yodata.creditsupport.util.ConstantBean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PerUserDao extends SimpleHibernateDao<PerUserEntity, java.lang.Integer>{
    private final Log log= LogFactory.getLog(PerUserDao.class);
    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Autowired
    private ConstantBean constant;
    
    public PerUserEntity findUserEntity(PerUserEntity user) {
        Criteria criteria = this.createCriteria(Restrictions.eq("peruserName", user.getPeruserName()));
        criteria.add(Restrictions.eq("perpassword", user.getPerpassword()));
        List<PerUserEntity> userEntityList = criteria.list();
        if(userEntityList.size()>0)return userEntityList.get(0);
        else return null;
    }
    

	public List<Integer> queryRoleByUserId(Integer userId) throws DataAccessException {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        String sql = "";
        try {
            sql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlQueryRoleByPerUserId(), params);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw e;
        }
        Query query = this.getSQLQuery(sql);
        List<Object> list = query.list();
        
        List<Integer> userList = new ArrayList<>();
        if(list!=null && list.size()>0){
            
            for (int i = 0; i < list.size(); i++) {
                
                Object[] objs = (Object[]) list.get(i);
                userList.add((Integer) objs[0]);
            }
        }
        
        return userList;
	}


	public void addUserRole(List<UserRoleEntity> list)
	{
		for (UserRoleEntity user : list) 
			getSession().saveOrUpdate(user);
		
		flush();
	}
	
	public Page<User> getPageUsers(String condition, String values, Page<User> page) throws DataAccessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("condition", condition);
		params.put("values", "%" + values + "%");
		try {
			// 计数SQL
			String countSql = dynamicHibernateSqlDao
					.getNamedQuerySql(constant.getSqlGetPagePerUser() + constant.getSqlCount(), params);
			Query query = this.getSQLQuery(countSql);
			List<Object> list2 = query.list();
			String count = list2.get(0) == null ? "0" : list2.get(0).toString();
			// 把总条数放入page
			page.setCount(Integer.parseInt(count));

			// 记录SQL
			String dataSql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetPagePerUser(), params);
			query = this.getSQLQuery(dataSql);
			query.setFirstResult(page.getCurrent() * page.getCountPerPage() - page.getCountPerPage());
			query.setMaxResults(page.getCountPerPage());
			query.setResultTransformer(Transformers.aliasToBean(User.class));
			List<User> userList = query.list();
			// 查询结果放入page
			page.setDate(userList == null ? new ArrayList<User>() : userList);

		} catch (DataAccessException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw e;
		}

		return page;
	}
}