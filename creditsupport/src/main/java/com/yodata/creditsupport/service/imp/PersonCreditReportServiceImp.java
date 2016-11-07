package com.yodata.creditsupport.service.imp;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.alibaba.druid.support.json.JSONParser;
import com.yodata.creditsupport.dao.IndicatorScoreDao;
import com.yodata.creditsupport.dao.PersonDao;
import com.yodata.creditsupport.dao.PersonSaveInfoDao;
import com.yodata.creditsupport.dao.ScoreDetalDao;
import com.yodata.creditsupport.dao.hibernate.PersonReportDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.person.entity.OdsPersonDriverlicensestatusEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInfoEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInvestAlidebtEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInvestPunishbreakEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInvestPunishedEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInvestRyposfrEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInvestRyposperEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInvestRyposshaEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonReportBasicEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonReportConsumecategoriesEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonReportConsumecitiesEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonReportMonthconsumesEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonReportTransbehaviorEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonReportTranscreditsEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonRiskBgtEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonRiskCpwsEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonRiskShixinEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonRiskWdhmdEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonRiskZxggEntity;
import com.yodata.creditsupport.orm.person.entity.OdsPersonVerifybankcardby3eleEntity;
import com.yodata.creditsupport.orm.person.entity.PersonReportTempletEntity;
import com.yodata.creditsupport.orm.person.entity.PersonSaveInfoEntity;
import com.yodata.creditsupport.orm.person.entity.report.OdsPersonInfoReportEntity;
import com.yodata.creditsupport.orm.vo.IndicatorScoreWeight;
import com.yodata.creditsupport.service.IPersonCreditReportService;
import com.yodata.creditsupport.util.QueryParam;

/**
 * 
* @Description: 个人征信Dao操作接口实现类
* @author Jason
* @date 2016年7月13日 上午10:08:57
*
 */

@Service
public class PersonCreditReportServiceImp implements IPersonCreditReportService{

	 private final Log log = LogFactory.getLog(PersonCreditReportServiceImp.class);
	
	@Resource
	private PersonDao personDao;
	@Resource
	private PersonReportDao personReportDao ;
	@Resource
	private PersonSaveInfoDao personSaveInfoDao;
	
	@Resource
	private ScoreDetalDao scoreDetalDao;
	@Resource
    private IndicatorScoreDao indicatorScoreDao;
	
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getPersonPageReport(QueryParam queryParam, String cardId) throws SQLException {
		Map<String, Object> pageReport = null;
	    try {
            pageReport = personSaveInfoDao.getPageReport(queryParam, cardId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
	    return pageReport;
	}

	//根据模板ID显示模板信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getPersonTempletById(Integer templetId, boolean isCreate) {
		PersonReportTempletEntity templet = null;
        try {
            templet = personSaveInfoDao.getTempletById(templetId, isCreate);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		Map<String, Object> data = new HashMap<>();
		Map<String, Integer> templetMap = new HashMap<>();
		List<String> declareList = new ArrayList<>();
		
		data.put("templetMap", templetMap);
		data.put("declareList", declareList);
		
		StringBuilder params = new StringBuilder();
		if(templet != null) {
			data.put("type", templet.getType());
			String jsonStr = templet.getModuleList();
			String declareStr = templet.getDeclare();
			JSONParser parser = new JSONParser(jsonStr);
			Map<String, Object> rs = parser.parseMap();
			if(rs != null) {
				String key;
				Integer value;
				boolean isFirst = true;
				for(Entry<String, Object> entry : rs.entrySet()) {
					try {
						value = (Integer) entry.getValue();
					} catch (ClassCastException e) {
						value = 0;
					}
					key = entry.getKey();
					templetMap.put(key, value);
					if(value == 1) {
						if(isFirst) {
							isFirst = false;
							params.append("'" + key + "'");
						} else {
							params.append(",'" + key + "'");
						}
					}
				}
				List<String> tList = null;
                try {
                    tList = personSaveInfoDao.getTempletDict(params.toString());
                } catch (DataAccessException e) {
                    e.printStackTrace();
                    log.error(e.getMessage(), e);
                }
				data.put("repItemList", tList);
			}
			if(declareStr != null) {
				String[] arr = declareStr.split("\\n");
				for(String d : arr) {
					declareList.add(d);
				}
			}
		}
		return data;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<PersonReportTempletEntity> getAllReportTemp() {
		List<PersonReportTempletEntity> list = null;
        try {
            list = personSaveInfoDao.getAllReportTemp();
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return list;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getTempletById(Integer templetId, boolean isCreate) {
		PersonReportTempletEntity templet = null;
        try {
            templet = personSaveInfoDao.getTempletById(templetId, isCreate);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		Map<String, Object> data = new HashMap<>();
		Map<String, Integer> templetMap = new HashMap<>();
		List<String> declareList = new ArrayList<>();
		
		data.put("templetMap", templetMap);
		data.put("declareList", declareList);
		
		StringBuilder params = new StringBuilder();
		if(templet != null) {
			data.put("type", templet.getType());
			String jsonStr = templet.getModuleList();
			String declareStr = templet.getDeclare();
			JSONParser parser = new JSONParser(jsonStr);
			Map<String, Object> rs = parser.parseMap();
			if(rs != null) {
				String key;
				Integer value;
				boolean isFirst = true;
				for(Entry<String, Object> entry : rs.entrySet()) {
					try {
						value = (Integer) entry.getValue();
					} catch (ClassCastException e) {
						value = 0;
					}
					key = entry.getKey();
					templetMap.put(key, value);
					if(value == 1) {
						if(isFirst) {
							isFirst = false;
							params.append("'" + key + "'");
						} else {
							params.append(",'" + key + "'");
						}
					}
				}
				List<String> tList = null;
                try {
                    tList = personSaveInfoDao.getTempletDict(params.toString());
                } catch (DataAccessException e) {
                    e.printStackTrace();
                    log.error(e.getMessage(), e);
                }
				data.put("repItemList", tList);
			}
			if(declareStr != null) {
				String[] arr = declareStr.split("\\n");
				for(String d : arr) {
					declareList.add(d);
				}
			}
		}
		return data;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public synchronized PersonSaveInfoEntity createMaxIndexReport(String cardId, Date date) {
		PersonSaveInfoEntity saveInfo = null;
        try {
            saveInfo = personSaveInfoDao.createMaxIndexReport(cardId, date);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return saveInfo;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public OdsPersonInfoEntity getPersonInfoById(String cardId) {
		List<OdsPersonInfoEntity> list = personDao.findBy("cardId", cardId);
		OdsPersonInfoEntity person = null;
        if(list != null && list.size() > 0)
        {
        	person = list.get(0);
        	
        }
        
        return person;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, String> getScoreReportInfo(String regId, String algorithmType, IndicatorScoreWeight totalScore) {
		Map<String, String> rs = new HashMap<>();
		try {
			if(totalScore == null) {
				totalScore = indicatorScoreDao.getIndicatorScoreByTotal(regId, algorithmType);
			}
			List<IndicatorScoreWeight> list = indicatorScoreDao.getIndicatorScoreList(regId, algorithmType);
			Double score1 = 0.0d;	//通用类指标 得分合计
			Double weight1 = 0.0d;	//通用类指标 权重合计
			for(IndicatorScoreWeight isw : list) {
				if("1".equals(isw.getIndAttr())) {
					weight1 += isw.getWeight();
					score1 += isw.getScore();
				}
			}
			if(totalScore != null)
			{
				Double totalS = totalScore.getScore();
				Double weight2 = 1 - weight1;	//行业类指标 权重合计
				Double score2 = totalS - score1;
				if(weight1 == 0.0d) {
					rs.put("score1Per", "0");
				} else {
					rs.put("score1Per", new BigDecimal(score1/weight1).setScale(0, BigDecimal.ROUND_HALF_UP).toString());
				}
				if(weight2 == 0.0d) {
					rs.put("score2Per", "0");
				} else {
					rs.put("score2Per", new BigDecimal(score2/weight2).setScale(0, BigDecimal.ROUND_HALF_UP).toString());
				}
				score1 = new BigDecimal(score1).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
				DecimalFormat df = new DecimalFormat("0%");
		        DecimalFormat d = new DecimalFormat("0");
		        rs.put("score1", d.format(score1));
		        rs.put("score2", d.format(score2));
		        rs.put("score1Weight", df.format(weight1));
		        rs.put("score2Weight", df.format(weight2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("sql执行错误", e);
		} catch (DataAccessException e) {
		    e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return rs;
	}

	@Override
	public Map<String, String> convertCreditScore(IndicatorScoreWeight sw) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 驾驶证信息
	 */
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonDriverlicensestatusEntity> getDriverlicenseStatausInfo(String cardId) {
		List<OdsPersonDriverlicensestatusEntity> list = null;
	       try {
	           list = personDao.getDriverlicentseStatusInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//个人投资--失信被执行人
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonInvestPunishbreakEntity> getInvestPunishBreakInfo(String cardId) {
		List<OdsPersonInvestPunishbreakEntity> list = null;
	       try {
	           list = personDao.getInvesPunishBreakInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//个人投资--执行人
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonInvestPunishedEntity> getInvestPunishedInfo(String cardId) {
		List<OdsPersonInvestPunishedEntity> list = null;
	       try {
	           list = personDao.getInversPunishedInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//个人投资--法定代表人
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonInvestRyposfrEntity> getInversRyposfrInfo(String cardId) {
    	List<OdsPersonInvestRyposfrEntity> list = null;
	       try {
	           list = personDao.getInversRyposfrInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

     //个人投资--管理人员
  	@Override
  	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonInvestRyposperEntity> getInversRyposperInfo(String cardId) {
  		List<OdsPersonInvestRyposperEntity> list = null;
	       try {
	           list = personDao.getInversRyposperInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

    //个人投资--企业股东
  	@Override
  	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonInvestRyposshaEntity> getInversRyposshaInfo(String cardId) {
  		List<OdsPersonInvestRyposshaEntity> list = null;
	       try {
	           list = personDao.getInversRyposshaInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

  	//个人司法--曝光台
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonRiskBgtEntity> getRiskBgtInfo(String cardId) {
		List<OdsPersonRiskBgtEntity> list = null;
	       try {
	           list = personDao.getRiskBgtInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//裁判文书
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonRiskCpwsEntity> getRiskCpwsInfo(String cardId) {
		List<OdsPersonRiskCpwsEntity> list = null;
	       try {
	           list = personDao.getRiskCpwsInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//失信公告
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonRiskShixinEntity> getRiskDishonerInfo(String cardId) {
		List<OdsPersonRiskShixinEntity> list = null;
	       try {
	           list = personDao.getRiskDishonerInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//网贷黑名单
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonRiskWdhmdEntity> getRiskNetloadInfo(String cardId) {
		List<OdsPersonRiskWdhmdEntity> list = null;
	       try {
	           list = personDao.getRiskNetloadInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//执行公告
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonRiskZxggEntity> getRiskExecuteDocInfo(String cardId) {
		List<OdsPersonRiskZxggEntity> list = null;
	       try {
	           list = personDao.getRiskExecuteDocInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//阿里欠贷
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonInvestAlidebtEntity> getInvestAlidebtInfo(String cardId) {
		List<OdsPersonInvestAlidebtEntity> list = null;
	       try {
	           list = personDao.getInvestAlidebtInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//银联三要素验证信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonVerifybankcardby3eleEntity> getVerifyBankCardInfo(String cardId) {
		List<OdsPersonVerifybankcardby3eleEntity> list = null;
	       try {
	           list = personDao.getVerifyBankCardInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}
	
	
	//资产状况及交易行为
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonReportBasicEntity> getReportBasicInfo(String cardId) {
		List<OdsPersonReportBasicEntity> list = null;
	       try {
	           list = personDao.getReportBasicInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//消费大类分布
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonReportConsumecategoriesEntity> getReportConsumeCategoryInfo(String cardId) {
		List<OdsPersonReportConsumecategoriesEntity> list = null;
	       try {
	           list = personDao.getReportConsumeCategoryInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//城市消费状况
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonReportConsumecitiesEntity> getReportConsumeCityInfo(String cardId) {
		List<OdsPersonReportConsumecitiesEntity> list = null;
	       try {
	           list = personDao.getReportConsumeCityInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//每月消费状况
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonReportMonthconsumesEntity> getReportMonthConsumeInfo(String cardId) {
		List<OdsPersonReportMonthconsumesEntity> list = null;
	       try {
	           list = personDao.getReportMonthConsumeInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//消费行为
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonReportTransbehaviorEntity> getReportTransBehaivorInfo(String cardId) {
		List<OdsPersonReportTransbehaviorEntity> list = null;
	       try {
	           list = personDao.getReportTransBehaviorInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	//信用相关交易统计
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<OdsPersonReportTranscreditsEntity> getReportTransCreditInfo(String cardId) {
		List<OdsPersonReportTranscreditsEntity> list = null;
	       try {
	           list = personDao.getReportTransCreditInfo(cardId);
	       } catch (DataAccessException e) {
	           e.printStackTrace();
	           log.error(e.getMessage(), e);
	       }
		return list;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void savePersonReport(OdsPersonInfoReportEntity person, PersonSaveInfoEntity saveInfo)
	{
		personReportDao.save(person);
		personSaveInfoDao.update(saveInfo);
	}

	//征信报告Report查询
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public OdsPersonInfoReportEntity getPersonReportInfo(String cardId, String fileNo) {
		try {
            return personReportDao.getPersonReportInfo(cardId, fileNo);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return null;
	}

}
