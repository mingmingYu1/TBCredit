package com.yodata.creditsupport.service.imp;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yodata.creditsupport.dao.AgentAlgorDao;
import com.yodata.creditsupport.orm.entity.AgentAlgorEntity;
import com.yodata.creditsupport.service.IAgentAlgorService;

import javax.annotation.Resource;

@Service
@Transactional
public class AgentAlgorServiceImpl implements IAgentAlgorService {

	@Resource
    private AgentAlgorDao agentAlgorDao;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public AgentAlgorEntity getEntityByRegIdAndAlgorId(String regId, Integer algorId) {
        return agentAlgorDao.getEntityByRegIdAndAlgorId(regId, algorId);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public AgentAlgorEntity getEntityByRegId(String regId) {
        return agentAlgorDao.getEntityByRegId(regId);
    }

    @Override
    public void saveOrUpdate(AgentAlgorEntity entity) {
        agentAlgorDao.saveOrUpdate(entity);
    }


}