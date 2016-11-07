package com.yodata.creditsupport.service.imp;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.yodata.creditsupport.dao.ScoreModelDao;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.ScoreModelEntity;
import com.yodata.creditsupport.service.IScoreModelService;
import com.yodata.creditsupport.util.ConstantBean;
import com.yodata.creditsupport.util.HttpClientUtil;
import com.yodata.creditsupport.util.QueryParam;

@Service
@Transactional
public class ScoreModelServiceImpl implements IScoreModelService {
    private final Log log = LogFactory.getLog(ScoreModelServiceImpl.class);
	@Resource
    private ScoreModelDao scoreModelDao;
	@Autowired
	private ConstantBean constant;
	@Override
	public Map<String, Object> getPageScoreModels(QueryParam queryParam){
		Map<String, Object> map = null;
        try {
            map = scoreModelDao.getPageScoreModels(queryParam);
        } catch (SQLException | DataAccessException e) {
            log.error(e.getMessage());
        }
		return map;
	}

	@Override
	public void saveOrUpdateEntity(ScoreModelEntity scoreModelEntity) {
		try {
            scoreModelDao.saveOrUpdateEntity(scoreModelEntity);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public ScoreModelEntity getScoreModelEntityByID(Integer id) {
		try {
            return scoreModelDao.getScoreModelEntityByID(id);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return null;
        }
	}

	@Override
	public void deleteEntity(Integer id) {
		try {
            scoreModelDao.deleteEntity(id);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public boolean getScoreModelEntityByName(String modelName, Integer id) {
		try {
            return scoreModelDao.getScoreModelEntityByName(modelName, id);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return false;
	}

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ScoreModelEntity> getScoreModels() {
        return scoreModelDao.getScoreModels();
    }
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Map<String, String> getScoreModelMap() {
    	return scoreModelDao.getScoreModelMap();
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ScoreModelEntity getScoreModelEntityByCode(String modelCode) {
        return scoreModelDao.getScoreModelEntityByCode(modelCode);
    }
    @Override
    public boolean runAlgorithm(String modelCode) throws BusinessException {
        if(StringUtils.isEmpty(modelCode)){
            throw new BusinessException("算法类型必须指定！");
        }
        boolean result = false;
        switch (modelCode) {
        case "Delphi"://专家算法
            break;
        case "LR":
            String host = constant.getAlgorithmHost();      //算法接口的地址
            String operation = constant.getAlgorithmLROperationTrain();   //模型预测或训练操作
            String modelType = constant.getAlgorithmLRModelCode();  //行业属性类型
            if(StringUtils.isEmpty(host) || StringUtils.isEmpty(operation)
                    || StringUtils.isEmpty(modelType)){
                throw new BusinessException("算法服务器接口信息必须指定！");
            }
            
//          operation   <string>: 模型预测或训练操作，predict 或 train 可选；默认为predict；
//          model_code <string>: 行业模型的代码，默认110000； 依次编码为 110001,110002... 以此类推
            //算法需要的参数
            JSONObject json = new JSONObject();
            json.put("operation", operation);
            json.put("model_code", modelType);
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("content", json.toJSONString()));
            try {
                String postRs = HttpClientUtil.post(host, params);
                JSONObject rsJson = JSONObject.parseObject(postRs);
                int stateCode = rsJson.getIntValue("state_code");
                if(stateCode == 1){
                    result = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error("算法服务器连接出错");
                throw new BusinessException("连接算法服务接口发生异常");
            }
            break;
        default:
            break;
        }
        return result;
    }	

	@Override
	public int getStatusByModelCode(String modelCode) {
		Criteria criteria = scoreModelDao.createCriteria();
		criteria.add(Restrictions.eq("modelCode", modelCode));
		@SuppressWarnings("rawtypes")
		List list = criteria.list();
		ScoreModelEntity bean = (ScoreModelEntity)list.get(0);
		if(bean.getStatus() == 0){
//			//完成 //失败
//			if(ShellUtil.getInstance().isFinished(bean.getModelCode(),1,constant) || ShellUtil.getInstance().isError(bean.getModelCode(),1,constant)){
//				bean.setStatus(1);
//				scoreModelDao.update(bean);
//				return 1;
//			}else{
				return 0;
//			}
		}else{
			return 1;
		}
	}
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ScoreModelEntity getScoreModelEntityByRegId(String regId) {
        try {
            return scoreModelDao.getScoreModelEntityByRegId(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public boolean getScoring(String modelCode) throws BusinessException {
        if(StringUtils.isEmpty(modelCode)){
            throw new BusinessException("算法类型必须指定！");
        }
        boolean result = false;
        switch (modelCode) {
        case "Delphi"://专家算法
            try {
                scoreModelDao.getScoring(modelCode);
            } catch (DataAccessException e) {
                e.printStackTrace();
                log.error(e.getMessage(), e);
                throw new BusinessException("专家法计分失败");
            }
            result = true;
            break;
        case "LR":  //逻辑回归算法
            String host = constant.getAlgorithmHost();      //算法接口的地址
            String operation = constant.getAlgorithmLROperationPredict();   //模型预测或训练操作
            String modelType = constant.getAlgorithmLRModelCode();  //行业属性类型
            if(StringUtils.isEmpty(host) || StringUtils.isEmpty(operation)
                    || StringUtils.isEmpty(modelType)){
                throw new BusinessException("算法服务器信息必须指定！");
            }
            
//          operation   <string>: 模型预测或训练操作，predict 或 train 可选；默认为predict；
//          model_code <string>: 行业模型的代码，默认110000； 依次编码为 110001,110002... 以此类推
            //算法需要的参数
            JSONObject json = new JSONObject();
            json.put("operation", operation);
            json.put("model_code", modelType);
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("content", json.toJSONString()));
            try {
                String postRs = HttpClientUtil.post(host, params);
                JSONObject rsJson = JSONObject.parseObject(postRs);
                int stateCode = rsJson.getIntValue("state_code");
                if(stateCode == 1){
                    result = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error("算法服务器连接出错");
                throw new BusinessException("算法服务器连接出错");
            }
            break;
        default:
            break;
        }
        return result;
    }

}