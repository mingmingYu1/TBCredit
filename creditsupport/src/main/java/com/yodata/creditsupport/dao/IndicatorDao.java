package com.yodata.creditsupport.dao;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.dao.hibernate.DynamicHibernateSqlDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.DictEntity;
import com.yodata.creditsupport.orm.entity.IndicatorEntity;
import com.yodata.creditsupport.util.ConstantBean;
import com.yodata.creditsupport.util.QueryParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndicatorDao extends SimpleHibernateDao<IndicatorEntity,java.lang.Integer>{
    private final Log log= LogFactory.getLog(IndicatorDao.class);
    @Resource
    private DynamicHibernateSqlDao dynamicHibernateSqlDao;
    @Autowired
    private ConstantBean constant;
	@Resource
    private DictDao dictDao;

	public Map<String, Object> getPageIndicators(QueryParam queryParam) throws DataAccessException{

	    //参数
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(queryParam.getQueryCode())){
            params.put("indCode", queryParam.getQueryCode().trim());
        } else {
            params.put("indCode", null);
        }
        if(StringUtils.isNotBlank(queryParam.getQueryName())){
            params.put("indName", queryParam.getQueryName());
        } else {
            params.put("indName", null);
        }
        if(StringUtils.isNotBlank(queryParam.getIndicatorCate())){
            params.put("level1", queryParam.getIndicatorCate().trim());
        } else {
            params.put("level1", null);
        }
        //查询总记录条数
        int count = 0;
        //记录列表
        List<IndicatorEntity> list = null;
        try {
            //计算记录总条数的sql
            String countSql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlGetPageIndicators() + constant.getSqlCount(), params);
            Session session = this.getSession();
            Query query = session.createSQLQuery(countSql);
            List<Map<String, Object>> totals = query.list();
            count = totals != null ? totals.size() : 0;
            //排序字段
            params.put("sortStr", StringUtils.isNotBlank(queryParam.getSortStr()) 
                    ? queryParam.getSortStr() : null);
            String dataSql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlGetPageIndicators(), params);;
            query = session.createSQLQuery(dataSql);
            query.setFirstResult(queryParam.getOffset());
            query.setMaxResults(queryParam.getLimit());
            query.setResultTransformer(Transformers.aliasToBean(IndicatorEntity.class));
            
            list = query.list();
            if(list != null && !list.isEmpty()){
                List<DictEntity> calCycles = dictDao.getDictsByCategory("100002");
                Map<String, String> calCycleMap = new HashMap<String, String>();
                for(DictEntity de : calCycles){
                    calCycleMap.put(de.getValue(), de.getName());
                }
                List<DictEntity> indAttrs = dictDao.getDictsByCategory("100004");
                Map<String, String> indAttrMap = new HashMap<String, String>();
                for(DictEntity de : indAttrs){
                    indAttrMap.put(de.getValue(), de.getName());
                }
                List<DictEntity> indTargets = dictDao.getDictsByCategory("100003");
                Map<String, String> indTargetMap = new HashMap<String, String>();
                for(DictEntity de : indTargets){
                    indTargetMap.put(de.getValue(), de.getName());
                }
                for(IndicatorEntity entity : list){
                    //计算周期
                    entity.setCalCycleValue(StringUtils.isEmpty(entity.getCalCycle())
                            ? "" : calCycleMap.get(entity.getCalCycle()));
                    //对象
                    entity.setIndTargetValue(StringUtils.isEmpty(entity.getIndTarget())
                            ? "" : indTargetMap.get(entity.getIndTarget()));
                    //指标属性
                    entity.setIndAttrValue(StringUtils.isEmpty(entity.getIndAttr())
                            ? "" : indAttrMap.get(entity.getIndAttr()));
                }
            }
        } catch (DataAccessException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("count",count);
        map.put("data",list);
        return map;
	}

	public IndicatorEntity getIndicatorEntityByID(Integer id){
		return this.get(id);
	}

	public void deleteEntity(Integer id){
		this.delete(id);
	}

	public IndicatorEntity getIndicatorEntityByName(String indiName){
	    Disjunction dis = Restrictions.disjunction();
	    dis.add(Restrictions.eq("indName", indiName));
	    dis.add(Restrictions.eq("level1", indiName));
	    dis.add(Restrictions.eq("level2", indiName));
	    dis.add(Restrictions.eq("level3", indiName));
	    dis.add(Restrictions.eq("level4", indiName));
	    dis.add(Restrictions.eq("level5", indiName));
	    dis.add(Restrictions.eq("level6", indiName));
		List<IndicatorEntity> list = this.find(dis);
		return (list == null || list.isEmpty()) ? null : list.get(0);
	}

	public void saveOrUpdateEntity(IndicatorEntity indicatorEntity){
		this.getSession().saveOrUpdate(indicatorEntity);
	}

	public IndicatorEntity getIndicatorEntityByCode(String indiCode) {
		return this.findUniqueBy("indCode", indiCode);
	}

    public List<String> queryLevelIndicatorList() throws DataAccessException {
        try {
            String hql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlQueryLevelIndicatorList());
            return this.find(hql);
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            throw e;
        }
    }

    public List<IndicatorEntity> queryLevelIndicatorListByLevel(String level) throws DataAccessException {
        int levelNum = Integer.parseInt(level.substring(level.length() - 1, level.length()));
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("levelNum", levelNum);
        try {
            String sql = dynamicHibernateSqlDao.getNamedQuerySql(
                    constant.getSqlQueryLevelIndicatorListByLevel(), params);
            return this.getSession().createSQLQuery(sql)
                    .setResultTransformer(Transformers.aliasToBean(IndicatorEntity.class)).list();
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            throw e;
        }
    }

    public List<IndicatorEntity> queryChildren(String indName) {
        Disjunction dis = Restrictions.disjunction();
        dis.add(Restrictions.eq("level1", indName));
        dis.add(Restrictions.eq("level2", indName));
        dis.add(Restrictions.eq("level3", indName));
        dis.add(Restrictions.eq("level4", indName));
        dis.add(Restrictions.eq("level5", indName));
        dis.add(Restrictions.eq("level6", indName));
        return this.find(dis);
    }

    public List<IndicatorEntity> getAllEntityList(String algorithmType) throws DataAccessException {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("algorithmType", algorithmType);
            String sql = dynamicHibernateSqlDao.getNamedQuerySql(constant.getSqlGetAllEntityListByType(),params);
            Query query = this.getSession().createSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(IndicatorEntity.class));
            return query.list();
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            throw e;
        }
        
    }

}