package com.yodata.creditsupport.service.imp;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yodata.creditsupport.dao.IndicatorDao;
import com.yodata.creditsupport.dao.ScoreModelDao;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.IndicatorEntity;
import com.yodata.creditsupport.service.IndicatorService;
import com.yodata.creditsupport.util.QueryParam;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

@Service
@Transactional
public class IndicatorServiceImpl implements IndicatorService {
    private final Log log= LogFactory.getLog(IndicatorServiceImpl.class);
	@Resource
    private IndicatorDao indicatorDao;
	
	@Resource
    private ScoreModelDao scoreModelDao;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getPageIndicators(QueryParam queryParam) {
		try {
            return  indicatorDao.getPageIndicators(queryParam);
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public void saveOrUpdateEntity(IndicatorEntity indicatorEntity) {
		indicatorDao.saveOrUpdateEntity(indicatorEntity);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public IndicatorEntity getIndicatorEntityByID(Integer id) throws BusinessException {
	    if(id == null){
	        log.error("ID不能为空");
	        throw new BusinessException("ID不能为空");
	    }
		return indicatorDao.getIndicatorEntityByID(id);
	}

	@Override
	public void deleteEntity(Integer id) {
		indicatorDao.deleteEntity(id);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public IndicatorEntity getIndicatorEntityByName(String indiName) {
		return indicatorDao.getIndicatorEntityByName(indiName);
	}

//	@Override
//	@Transactional(propagation = Propagation.NOT_SUPPORTED)
//	public List<IndicatorEntity> queryByParentIdAndLevel(Integer parentId, int depth) {
//		return indicatorDao.queryByParentIdAndLevel(parentId, depth);
//	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public IndicatorEntity getIndicatorEntityByCode(String indiCode) {
		return indicatorDao.getIndicatorEntityByCode(indiCode);
	}

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<String> queryLevelIndicatorList() {
        try {
            return indicatorDao.queryLevelIndicatorList();
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<IndicatorEntity> queryLevelIndicatorListByLevel(String level) {
        try {
            return indicatorDao.queryLevelIndicatorListByLevel(level);
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<IndicatorEntity> queryChildren(String indName) {
        return indicatorDao.queryChildren(indName);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<IndicatorEntity> getAllEntityList(String algorithmType) {
        try {
            return indicatorDao.getAllEntityList(algorithmType);
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            return null;
        }
    }

}