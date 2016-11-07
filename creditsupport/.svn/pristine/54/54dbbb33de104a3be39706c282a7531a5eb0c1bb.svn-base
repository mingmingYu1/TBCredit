package com.yodata.creditsupport.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.ScoreLevelEntity;
import com.yodata.creditsupport.orm.entity.ScoreLevelVersionEntity;
import com.yodata.creditsupport.util.ConstantBean;
import com.yodata.creditsupport.util.QueryParam;

@Component
public class ScoreLevelDao extends SimpleHibernateDao<ScoreLevelEntity,java.lang.Integer>{
    private final Log log= LogFactory.getLog(ScoreLevelDao.class);
    @Resource
    private ScoreLevelVersionDao ScoreLevelVersionDao;
    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Resource
    private ConstantBean constant;
    
	public Map<String, Object> getPageScoreLevels(QueryParam queryParam) throws DataAccessException{
		//查询总记录条数
		int count = 0;
		//查询分页记录
		List<ScoreLevelEntity> list = null;
		//参数
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", queryParam.getCondition() == null ? null 
                : Integer.valueOf(queryParam.getCondition()));
		try {
            String countSql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlGetPageScoreLevels() + constant.getSqlCount(), params);
            count = this.findCount(countSql);
            
            String dataSql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlGetPageScoreLevels(), params);
            Session session = this.getSession();
            Query query = session.createSQLQuery(dataSql);
            query.setFirstResult(queryParam.getOffset());
            query.setMaxResults(queryParam.getLimit());
            query.setResultTransformer(Transformers.aliasToBean(ScoreLevelEntity.class));
            list = query.list();
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw e;
        }
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count",count);
		map.put("data",list);
		return map;
	}
	
	public ScoreLevelEntity getScoreLevelEntityByID(Integer id) {
		return this.get(id);
	}

	public void deleteEntity(Integer id) {
		this.delete(id);
	}

	public boolean getScoreLevelEntityByScore(String levelScore, Integer id) {
		List<ScoreLevelEntity> list = this.findBy("levelScore", levelScore);
		if(list != null && !list.isEmpty()){
			if(id != null && id != 0) {
				for(ScoreLevelEntity entity : list){
					if(entity.getId().equals(id)){
						return false;
					}
				}
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean getScoreLevelEntityByName(String levelName, Integer id, Integer levelVersion) {
	    Criteria criteria  = this.createCriteria(Restrictions.eq("levelName", levelName));
	    criteria.add(Restrictions.eq("levelVersion", levelVersion));
	    if(id != null && id != 0) {
	        criteria.add(Restrictions.ne("id", id));
	    }
		List<ScoreLevelEntity> list = criteria.list();
		return list == null || list.isEmpty() ? false : true;
	}

	public void saveOrUpdateEntity(ScoreLevelEntity scoreLevelEntity) {
		this.getSession().saveOrUpdate(scoreLevelEntity);
	}

    public boolean getScoreLevelEntityByScore(Integer levelScoreMin, 
            Integer levelScoreMax, Integer id,Integer levelVersion) throws DataAccessException {
        Map<String, Object> values = new HashMap<String, Object>();
        values.put("levelScoreMin", levelScoreMin);
        values.put("levelScoreMax", levelScoreMax);
        values.put("levelVersion", levelVersion);
        values.put("id", id);
        
        try {
            String hql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlGetScoreLevelEntityByScore(), values);
            List<ScoreLevelEntity> list = this.find(hql);
            return (list != null && !list.isEmpty()) ? true : false;
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public ScoreLevelEntity getScoreLevelEntityByScore(Double score) throws BusinessException {
        //查询可用版本
        List<ScoreLevelVersionEntity> listVersion = ScoreLevelVersionDao.getLevelsByStatus(1);
        ScoreLevelVersionEntity version = (listVersion == null || listVersion.isEmpty())
                ? null : listVersion.get(0);
        if(version == null){
            log.error("查询不到可用的得分等级版本");
            throw new BusinessException("查询不到可用的得分等级版本");
        }
        //得分区间为整数，现将得分转为整数
        int intScore = score.intValue();
        //查询可用版本下得分在哪个区间
        Criteria criteria = this.createCriteria(Restrictions.le("levelScoreMin", (int)Math.round(score)));
        criteria.add(Restrictions.ge("levelScoreMax",(int)Math.round(score)));
        criteria.add(Restrictions.eq("levelVersion", version.getId()));
        List<ScoreLevelEntity> list = criteria.list();
        
        return list == null || list.isEmpty() ? null : list.get(0);
    }

	public List<ScoreLevelEntity> getScoreLevelEntityByVersionID(Integer i) {
	    Criteria criteria = this.createCriteria();
        criteria.add(Restrictions.eq("levelVersion", i));
        criteria.addOrder(Order.desc("levelScoreMax"));
        List<ScoreLevelEntity> list = (List<ScoreLevelEntity>)criteria.list();
        return list;
	}

}
