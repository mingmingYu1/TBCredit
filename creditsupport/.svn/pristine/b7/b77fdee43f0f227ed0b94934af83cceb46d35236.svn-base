package com.yodata.creditsupport.service.imp;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yodata.creditsupport.dao.IndicatorScoreDao;
import com.yodata.creditsupport.dao.ScoreModelDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.ScoreModelEntity;
import com.yodata.creditsupport.orm.vo.IndicatorAttr;
import com.yodata.creditsupport.orm.vo.IndicatorScoreWeight;
import com.yodata.creditsupport.service.IIndicatorScoreService;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

@Service
@Transactional
public class IndicatorScoreServiceImp implements IIndicatorScoreService{
    private final Log log= LogFactory.getLog(IndicatorScoreServiceImp.class);
    @Resource
    private IndicatorScoreDao indicatorScoreDao;
    
    @Resource
    private ScoreModelDao scoreModelDao;
    
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<IndicatorScoreWeight> getIndicatorScoreList(String regId, String algorithmType) throws SQLException {
        //算法类型，如果为空，则去数据库查询当前企业的使用算法，如果还为空，则默认为Delphi
        List<IndicatorScoreWeight> rs = null;
        try {
            if(StringUtils.isEmpty(algorithmType)){
                ScoreModelEntity se = scoreModelDao.getScoreModelEntityByRegId(regId);
                if(se != null && se.getModelCode() != null){
                    algorithmType = se.getModelCode().trim();
                } else {
                    algorithmType =  "Delphi";
                }
            }
            rs = indicatorScoreDao.getIndicatorScoreList(regId, algorithmType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
        return rs;
    }
    
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<IndicatorScoreWeight> getIndicatorScoreByAttr(String regId, String algorithmType, String indAttr) throws SQLException {
        //算法类型，如果为空，则去数据库查询当前企业的使用算法，如果还为空，则默认为Delphi
        List<IndicatorScoreWeight> rs = null;
        try {
            if(StringUtils.isEmpty(algorithmType)){
                ScoreModelEntity se = scoreModelDao.getScoreModelEntityByRegId(regId);
                if(se != null && se.getModelCode() != null){
                    algorithmType = se.getModelCode().trim();
                } else {
                    algorithmType =  "Delphi";
                }
            }
            rs = indicatorScoreDao.getIndicatorScoreListByAttr(regId, algorithmType, indAttr);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
        return rs;
    }
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<IndicatorScoreWeight> getIndicatorScoreLevel1ByAttr(String regId, String algorithmType, String indAttr) {
        //算法类型，如果为空，则去数据库查询当前企业的使用算法，如果还为空，则默认为Delphi
        List<IndicatorScoreWeight> rs = null;
        try {
            if(StringUtils.isEmpty(algorithmType)){
                ScoreModelEntity se = scoreModelDao.getScoreModelEntityByRegId(regId);
                if(se != null && se.getModelCode() != null){
                    algorithmType = se.getModelCode().trim();
                } else {
                    algorithmType =  "Delphi";
                }
            }
            rs = indicatorScoreDao.getIndicatorScoreListLevel1ByAttr(regId, algorithmType, indAttr);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
        return rs;
    }
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<IndicatorScoreWeight> getIndicatorScoreLevel2ByAttr(String regId, String algorithmType, String indAttr) {
        //算法类型，如果为空，则去数据库查询当前企业的使用算法，如果还为空，则默认为Delphi
        List<IndicatorScoreWeight> rs = null;
        try {
            if(StringUtils.isEmpty(algorithmType)){
                ScoreModelEntity se = scoreModelDao.getScoreModelEntityByRegId(regId);
                if(se != null && se.getModelCode() != null){
                    algorithmType = se.getModelCode().trim();
                } else {
                    algorithmType =  "Delphi";
                }
            }
            rs = indicatorScoreDao.getIndicatorScoreListLevel2ByAttr(regId, algorithmType, indAttr);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
        return rs;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public IndicatorScoreWeight getIndicatorScoreByTotal(String regId, String algorithmType) {
        //算法类型，如果为空，则去数据库查询当前企业的使用算法，如果还为空，则默认为Delphi
        IndicatorScoreWeight rs = null;
        try {
            if(StringUtils.isEmpty(algorithmType)){
                ScoreModelEntity se = scoreModelDao.getScoreModelEntityByRegId(regId);
                if(se != null && se.getModelCode() != null){
                    algorithmType = se.getModelCode().trim();
                } else {
                    algorithmType =  "Delphi";
                }
            }
            rs = indicatorScoreDao.getIndicatorScoreByTotal(regId, algorithmType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
        return rs;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<IndicatorScoreWeight> getIndicatorScoreListByLevel1(String regId, String algorithmType) {
        //算法类型，如果为空，则去数据库查询当前企业的使用算法，如果还为空，则默认为Delphi
        List<IndicatorScoreWeight> rs = null;
        try {
            if(StringUtils.isEmpty(algorithmType)){
                ScoreModelEntity se = scoreModelDao.getScoreModelEntityByRegId(regId);
                if(se != null && se.getModelCode() != null){
                    algorithmType = se.getModelCode().trim();
                } else {
                    algorithmType =  "Delphi";
                }
            }
            rs = indicatorScoreDao.getIndicatorScoreListByLevel1(regId, algorithmType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
        return rs;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<IndicatorScoreWeight> getIndicatorScoreListByLevel2(String regId, String algorithmType) {
        //算法类型，如果为空，则去数据库查询当前企业的使用算法，如果还为空，则默认为Delphi
        List<IndicatorScoreWeight> rs = null;
        try {
            if(StringUtils.isEmpty(algorithmType)){
                ScoreModelEntity se = scoreModelDao.getScoreModelEntityByRegId(regId);
                if(se != null && se.getModelCode() != null){
                    algorithmType = se.getModelCode().trim();
                } else {
                    algorithmType =  "Delphi";
                }
            }
            rs = indicatorScoreDao.getIndicatorScoreListByLevel2(regId, algorithmType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
        return rs;
    }

//    @Override
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    public List<CapitalGrowth> getCapitalGrowthList(String regId) {
//        return indicatorScoreDao.getCapitalGrowthList(regId);
//    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public IndicatorAttr getIndicatorAttrList(String regId) {
        IndicatorAttr rs = null;
        try {
            rs = indicatorScoreDao.getIndicatorAttrList(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
        return rs;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Map<String, Object>> getCreditScore(String regId, String algorithmType) {
        //算法类型，如果为空，则去数据库查询当前企业的使用算法，如果还为空，则默认为Delphi
        List<Map<String, Object>> rs = null;
        try {
            if(StringUtils.isEmpty(algorithmType)){
                ScoreModelEntity se = scoreModelDao.getScoreModelEntityByRegId(regId);
                if(se != null && se.getModelCode() != null){
                    algorithmType = se.getModelCode().trim();
                } else {
                    algorithmType =  "Delphi";
                }
            }
            rs = indicatorScoreDao.getCreditScore(regId, algorithmType);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
        return rs;
    }
    
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Map<String, String> getScoreModelMap() {
    	return scoreModelDao.getScoreModelMap();
    }
	
}