package com.yodata.creditsupport.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.ScoreModelEntity;
import com.yodata.creditsupport.util.ConstantBean;
import com.yodata.creditsupport.util.QueryParam;

@Component
public class ScoreModelDao extends SimpleHibernateDao<ScoreModelEntity,java.lang.Integer> {
    @Autowired
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Autowired
    private ConstantBean constant;
    
	public Map<String, Object> getPageScoreModels(QueryParam queryParam) throws SQLException, DataAccessException{
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("modelCode", queryParam.getQueryCode());
		params.put("modelName", queryParam.getQueryName());
		
		int count = this.findCount(dynamicHibernateSqlDao.getNamedQuerySql(constant.getPageScoreModels()+constant.getSqlCount(), params));
		
		String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getPageScoreModels(), params);
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql);
		query.setFirstResult(queryParam.getOffset());
		query.setMaxResults(queryParam.getLimit());
		query.setResultTransformer(Transformers.aliasToBean(ScoreModelEntity.class));
		List<ScoreModelEntity> list = query.list();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count",count);
		map.put("data",list);
		return map;
	}
	
	public ScoreModelEntity getScoreModelEntityByID(Integer id) throws SQLException {
		return this.get(id);
	}

	public void deleteEntity(Integer id) throws SQLException {
		this.delete(id);
	}

	public boolean getScoreModelEntityByName(String modelName, Integer id) throws SQLException {
		List<ScoreModelEntity> list = this.findBy("modelName", modelName);
		if(list != null && !list.isEmpty()){
			if(id != null && id != 0) {
				for(ScoreModelEntity entity : list){
					if(entity.getModelId().equals(id)){
						return false;
					}
				}
			} else {
				return true;
			}
		}
		return false;
	}

	public void saveOrUpdateEntity(ScoreModelEntity scoreModelEntity) throws SQLException {
	    scoreModelEntity.setUpdateTime(new Date());
		this.getSession().saveOrUpdate(scoreModelEntity);
	}

    public List<ScoreModelEntity> getScoreModels() {
        return this.getAll();
    }

    public ScoreModelEntity getScoreModelEntityByCode(String modelCode) {
        return this.findUniqueBy("modelCode", modelCode);
    }
    
    public Map<String, String> getScoreModelMap() {
    	List<ScoreModelEntity> list = this.getAll();
    	Map<String, String> map = new HashMap<>();
    	for(ScoreModelEntity s : list) {
    		map.put(s.getModelCode(), s.getModelName());
    	}
		return map;
	}
    
    /**
     * 根据企业ID查询企业所使用的算法
     * @param regId
     * @return
     * @throws DataAccessException 
     */
    public ScoreModelEntity getScoreModelEntityByRegId(String regId) throws DataAccessException {
//        String hql = "SELECT csm.sm_id modelId, csm.mod_code modelCode, csm.mod_name modelName, csm.mod_desc modelDesc, "
//                + " csm.algor_desc algorithmDesc, csm.reserve1, csm.reserve2, csm.create_user createUser, "
//                + " csm.create_time createTime, csm.update_time updateTime "
//                + " FROM tbods.agent_algor taa, credit_support.score_model csm "
//                + " WHERE taa.algor_id = csm.sm_id AND taa.agent_id = :regId ";
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("regId", regId);
        String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetScoreModelEntityByRegId(), params);
        
        Query query = this.getSession().createSQLQuery(sql);
//        query.setParameter("regId", regId);
        query.setResultTransformer(Transformers.aliasToBean(ScoreModelEntity.class));
        List<ScoreModelEntity> list = query.list();
        
        return (list == null || list.isEmpty()) ? null : list.get(0);
    }

    public void getScoring(String modelCode) throws DataAccessException {
        try {
            //计算得分并进行行列转换
            this.getSession().createStoredProcedureCall("sp_web_enterprise_score_delphi").getOutputs();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataAccessException("存储过程执行失败");
        }
    }
}
