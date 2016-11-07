package com.yodata.creditsupport.service.imp;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yodata.creditsupport.dao.ScoreLevelDao;
import com.yodata.creditsupport.dao.ScoreLevelVersionDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.ScoreLevelEntity;
import com.yodata.creditsupport.orm.entity.ScoreLevelVersionEntity;
import com.yodata.creditsupport.service.IScoreLevelVersionService;
import com.yodata.creditsupport.util.QueryParam;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

@Service
@Transactional
public class ScoreLevelVersionServiceImpl implements IScoreLevelVersionService {
    private final Log log= LogFactory.getLog(ScoreLevelVersionServiceImpl.class);
	@Resource
    private ScoreLevelVersionDao ScoreLevelVersionDao;

	@Resource
    private ScoreLevelDao scoreLevelDao;
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getPageScoreLevelVersions(QueryParam queryParam) {
		return  ScoreLevelVersionDao.getPageScoreLevelVersions(queryParam);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public ScoreLevelVersionEntity getScoreLevelVersionEntityByID(Integer id) {
		return ScoreLevelVersionDao.getScoreLevelVersionEntityByID(id);
	}

	@Override
	public void deleteEntity(Integer id) {
		ScoreLevelVersionDao.deleteEntity(id);
	}

	@Override
	public void copy(ScoreLevelVersionEntity scoreLevelEntity, List<ScoreLevelEntity> list) {
		int id=ScoreLevelVersionDao.saveOrUpdateEntity(scoreLevelEntity);
		for(int i=0;i<list.size();i++){
			list.get(i).setId(null);
			list.get(i).setLevelVersion(id);
			scoreLevelDao.save(list.get(i));
		}
		
	}

	@Override
	public void saveOrUpdateEntity(ScoreLevelVersionEntity scoreLevelVersionEntity) {
		ScoreLevelVersionDao.saveOrUpdateEntity(scoreLevelVersionEntity);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<ScoreLevelVersionEntity> getScoreLevelVersionEntityByStatus(int i) {
		return ScoreLevelVersionDao.getLevelsByStatus(i);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public ScoreLevelVersionEntity getlastVersion() {
		return ScoreLevelVersionDao.getLastVersion();
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int getScoreSumByID(Integer id) {
	    int i = 0;
		try {
            i = ScoreLevelVersionDao.getScoreSumByID(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return i;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public boolean hasAvailableVersion() {
		List<ScoreLevelVersionEntity> list = ScoreLevelVersionDao.getLevelsByStatus(1);
		if(list == null || list.size() <= 0) {
			return false;
		}
		return true;
	}
}