package com.yodata.creditsupport.service;

import com.yodata.creditsupport.orm.entity.AgentAlgorEntity;

public interface IAgentAlgorService {
    
    /**
     * 根据企业ID和算法ID查询
     * @param regId
     * @param algorId
     * @return
     */
    public AgentAlgorEntity getEntityByRegIdAndAlgorId(String regId, Integer algorId);

    /**
     * 根据企业ID询
     * @param regId
     * @return
     */
    public AgentAlgorEntity getEntityByRegId(String regId);

    /**
     * 保存或修改
     * @param entity
     */
    public void saveOrUpdate(AgentAlgorEntity entity);
}
