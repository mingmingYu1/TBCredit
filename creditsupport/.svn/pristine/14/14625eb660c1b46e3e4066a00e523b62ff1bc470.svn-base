package com.yodata.creditsupport.dao;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.core.domain.Page;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.DeptEntity;
import com.yodata.creditsupport.orm.vo.Dept;
import com.yodata.creditsupport.util.ConstantBean;

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
public class DeptDao extends SimpleHibernateDao<DeptEntity, java.lang.Integer> {

    private final Log log= LogFactory.getLog(UserDao.class);
    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Autowired
    private ConstantBean constant;
    
    public Page<Dept> getPageDepts(Map<String, Object> params, Page<Dept> page) throws DataAccessException {
        try {
            String countSql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlGetPageDepts() + constant.getSqlCount(), params);
            Query query = this.getSQLQuery(countSql);
            List<Object> countList = query.list();
            
            String count = countList.get(0)==null?"0":countList.get(0).toString();
            page.setCount(Integer.parseInt(count));
            
            String dataSql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlGetPageDepts(), params);
            query = this.getSQLQuery(dataSql);
            query.setFirstResult(page.getCurrent()*page.getCountPerPage()-page.getCountPerPage());
            query.setMaxResults(page.getCountPerPage());
            query.setResultTransformer(Transformers.aliasToBean(Dept.class));
            
            List<Dept> deptList = query.list();
            page.setDate(deptList);
            
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error("SQL文件解析出错", e);
            throw e;
        }
        
        return page;
    }

}