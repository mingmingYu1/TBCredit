package com.yodata.creditsupport.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.ScoreLevelVersionEntity;
import com.yodata.creditsupport.util.ConstantBean;
import com.yodata.creditsupport.util.QueryParam;

@Component
public class ScoreLevelVersionDao extends SimpleHibernateDao<ScoreLevelVersionEntity,java.lang.Integer>{
    private final Log log= LogFactory.getLog(ScoreLevelVersionDao.class);
    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Resource
    private ConstantBean constant;
    
	public Map<String, Object> getPageScoreLevelVersions(QueryParam queryParam){
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", queryParam.getCondition() == null ? null 
		        : Integer.valueOf(queryParam.getCondition()));
		
		//查询总记录条数
		int count = 0;
		List<ScoreLevelVersionEntity> list = null;
		try {
		    String countSql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlGetPageScoreLevelVersions() + constant.getSqlCount(), params);
    		count = this.findCount(countSql);
    		//分页记录
    		String dataSql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlGetPageScoreLevelVersions(), params);
    		Session session = this.getSession();
    		Query query = session.createSQLQuery(dataSql);
    		query.setFirstResult(queryParam.getOffset());
    		query.setMaxResults(queryParam.getLimit());
    		query.setResultTransformer(Transformers.aliasToBean(ScoreLevelVersionEntity.class));
    		list = query.list();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count",count);
		map.put("data",list);
		return map;
	}
	
	public ScoreLevelVersionEntity getScoreLevelVersionEntityByID(Integer id){
		return this.get(id);
	}

	public void deleteEntity(Integer id) {
		this.delete(id);
	}

	public int saveOrUpdateEntity(ScoreLevelVersionEntity scoreLevelEntity){
		this.getSession().saveOrUpdate(scoreLevelEntity);
		return scoreLevelEntity.getId();
	}

	public List<ScoreLevelVersionEntity> getLevelsByStatus(int i) {
	    List<ScoreLevelVersionEntity> list = this.findBy("status", i);
        return list;
	}

	public ScoreLevelVersionEntity getLastVersion() {
	    List<ScoreLevelVersionEntity> list = this.getAll("id", false);
        return list == null || list.isEmpty() ? null : list.get(0);
	}

	public int getScoreSumByID(Integer id) throws DataAccessException {
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("id", id);
	    String sql = "";
        try {
            sql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlGetScoreSumByVersion(), params);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw e;
        }
		List temp = this.getSession().createSQLQuery(sql).list();
        if(temp.get(0)==null){
        	return 0;
        }else{
        	return Integer.parseInt(temp.get(0).toString());
        }
	}
}
