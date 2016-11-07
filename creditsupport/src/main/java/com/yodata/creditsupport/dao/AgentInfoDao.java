package com.yodata.creditsupport.dao;

import org.springframework.stereotype.Component;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.orm.entity.AgentInfoEntity;

@Component
public class AgentInfoDao extends SimpleHibernateDao<AgentInfoEntity,java.lang.Integer> {

}
