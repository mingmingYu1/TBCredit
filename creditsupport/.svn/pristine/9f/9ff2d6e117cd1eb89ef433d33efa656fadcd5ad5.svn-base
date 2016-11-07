package com.yodata.creditsupport.service.imp;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yodata.creditsupport.dao.CompanyDao;
import com.yodata.creditsupport.dao.ScoreLevelDao;
import com.yodata.creditsupport.dao.ScoreLevelVersionDao;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.ScoreLevelEntity;
import com.yodata.creditsupport.orm.entity.ScoreLevelVersionEntity;
import com.yodata.creditsupport.service.IScoreLevelService;
import com.yodata.creditsupport.util.QueryParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

@Service
@Transactional
public class ScoreLevelServiceImpl implements IScoreLevelService {
    private final Log log= LogFactory.getLog(ScoreLevelServiceImpl.class);
	@Resource
    private ScoreLevelDao scoreLevelDao;
	@Resource
	private ScoreLevelVersionDao scoreVersionDao;
	@Resource
    private CompanyDao companyDao;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getPageScoreLevels(QueryParam queryParam) {
		try {
            return  scoreLevelDao.getPageScoreLevels(queryParam);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return null;
	}

	@Override
	public void saveOrUpdateEntity(ScoreLevelEntity scoreLevelEntity) throws BusinessException {
	    if(scoreLevelEntity.getLevelVersion() == null){
	        log.error("评分版本不能为空");
	        throw new BusinessException("评分版本不能为空");
	    }
	    if(scoreLevelEntity.getLevelScoreMin() == null
                || scoreLevelEntity.getLevelScoreMax() == null){
            log.error("评分区间最低分、最高分都不能为空");
            throw new BusinessException("评分区间最低分、最高分都不能为空");
        }
	    if(StringUtils.isEmpty(scoreLevelEntity.getLevelName())){
            log.error("评分区间等级不能为空");
            throw new BusinessException("评分区间等级不能为空");
        }
	    Integer versionId = scoreLevelEntity.getLevelVersion();
	    if(versionId == null || versionId <=0) {
	    	log.error("评分版本不能为空");
            throw new BusinessException("评分版本不能为空");
	    }
	    ScoreLevelVersionEntity version = scoreVersionDao.get(versionId);
    	if(version == null) {
    		BusinessException be = new BusinessException("您选择的评分版本不存在");
	        log.error(be.getMessage());
	        throw be;
    	} 
    	if(version.getStatus() == 1) {
    		BusinessException be = new BusinessException("启动中的评分版本不允许新增/修改");
	        log.error(be.getMessage());
	        throw be;
    	}
		scoreLevelDao.saveOrUpdateEntity(scoreLevelEntity);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public ScoreLevelEntity getScoreLevelEntityByID(Integer id) {
		return scoreLevelDao.getScoreLevelEntityByID(id);
	}

	@Override
	public void deleteEntity(Integer id) throws BusinessException {
	    ScoreLevelEntity oldEntity = scoreLevelDao.get(id);
	    if(oldEntity == null){
	        BusinessException be = new BusinessException("您删除的评分区间不存在");
	        log.error(be.getMessage());
	        throw be;
	    } else {
	    	ScoreLevelVersionEntity version = scoreVersionDao.get(oldEntity.getLevelVersion());
	    	if(version == null) {
	    		BusinessException be = new BusinessException("您删除的评分区间所在版本不存在");
		        log.error(be.getMessage());
		        throw be;
	    	} 
	    	if(version.getStatus() == 1) {
	    		BusinessException be = new BusinessException("启动中的评分版本不允许删除评分区间");
		        log.error(be.getMessage());
		        throw be;
	    	}
	        scoreLevelDao.deleteEntity(id);
	    }
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public boolean getScoreLevelEntityByScore(String levelScore, Integer id) {
		return scoreLevelDao.getScoreLevelEntityByScore(levelScore, id);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public boolean getScoreLevelEntityByName(String levelName, Integer id, Integer levelVersion) {
		return scoreLevelDao.getScoreLevelEntityByName(levelName, id, levelVersion);
	}

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public boolean getScoreLevelEntityByScore(Integer levelScoreMin, Integer levelScoreMax, Integer id,Integer levelVersion) throws BusinessException {
        if(levelVersion == null){
            log.error("评分版本不能为空");
            throw new BusinessException("评分版本不能为空");
        }
        if(levelScoreMin == null || levelScoreMax == null){
            log.error("评分区间最低分、最高分都不能为空");
            throw new BusinessException("评分区间最低分、最高分都不能为空");
        }
        boolean result = false;
        try {
            result = scoreLevelDao.getScoreLevelEntityByScore(levelScoreMin, levelScoreMax, id,levelVersion);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ScoreLevelEntity getScoreLevelEntityByScore(Double score) throws BusinessException {
        return scoreLevelDao.getScoreLevelEntityByScore(score);
    }

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<ScoreLevelEntity> getScoreLevelEntityByVersionID(Integer i) {
		return scoreLevelDao.getScoreLevelEntityByVersionID( i);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getEnableScore() {
		return companyDao.getEnableScore();
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> queryScoeLevel() {
		return companyDao.queryScoreLevel();
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getAgentSampleInfo(String regId) {
		Map<String, Object> map = companyDao.getAgentInfo(regId);
		return map == null ? new HashMap<String, Object>() : map;
	}

}