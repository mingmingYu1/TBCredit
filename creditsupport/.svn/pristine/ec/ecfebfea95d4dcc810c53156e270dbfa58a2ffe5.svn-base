package com.yodata.creditsupport.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.orm.entity.CrawlerAgentGroupEntity;

@Component
public class AgentGroupDao extends SimpleHibernateDao<CrawlerAgentGroupEntity, java.lang.Integer> {
    public boolean isGroup(String compname) throws SQLException {
        List<CrawlerAgentGroupEntity> list = findBy("groupName", compname);
        return list != null && list.size() > 0 ? true : false;
    }
}
