package com.yodata.creditsupport.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.orm.entity.AgentAlgorEntity;

@Component
public class AgentAlgorDao extends SimpleHibernateDao<AgentAlgorEntity,java.lang.Integer> {

    /**
     * 根据企业ID和算法ID查询
     * @param regId
     * @param algorId
     * @return
     */
    public AgentAlgorEntity getEntityByRegIdAndAlgorId(String regId, Integer algorId) {
        Criteria criteria = this.createCriteria(Restrictions.eq("regId", regId));
        criteria.add(Restrictions.eq("algorId", algorId));
        return (AgentAlgorEntity) criteria.uniqueResult();
    }

    public AgentAlgorEntity getEntityByRegId(String regId) {
        return this.findUniqueBy("regId", regId);
    }

    public void saveOrUpdate(AgentAlgorEntity entity) {
        this.getSession().saveOrUpdate(entity);
    }
    
}
