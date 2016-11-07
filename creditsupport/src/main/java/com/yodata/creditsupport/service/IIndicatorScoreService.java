package com.yodata.creditsupport.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yodata.creditsupport.orm.vo.IndicatorAttr;
import com.yodata.creditsupport.orm.vo.IndicatorScoreWeight;

public interface IIndicatorScoreService {

    /**
     * 根据企业编号，查询指标得分及权重
     * @param uid
     * @param page
     * @return
     * @throws SQLException 
     */

    public List<IndicatorScoreWeight> getIndicatorScoreList(String regId, String algorithmType) throws SQLException;
    
    /**
     * 根据指标属性查询得分及权重
     * @param regId
     * @param algorithmType
     * @param indAttr
     * @return
     * @throws SQLException
     */
    public List<IndicatorScoreWeight> getIndicatorScoreLevel1ByAttr(String regId, String algorithmType, String indAttr);
    public List<IndicatorScoreWeight> getIndicatorScoreLevel2ByAttr(String regId, String algorithmType, String indAttr);
    public List<IndicatorScoreWeight> getIndicatorScoreByAttr(String regId, String algorithmType, String indAttr) throws SQLException;
    /**
     * 根据企业编号，查询总分
     * @param regId
     * @param algorithmType 
     * @return
     */
    public IndicatorScoreWeight getIndicatorScoreByTotal(String regId, String algorithmType);

    /**
     * 根据企业编号，查询指标大类得分、权重和下面指标数量
     * @param regId
     * @param algorithmType 
     * @return
     */
    public List<IndicatorScoreWeight> getIndicatorScoreListByLevel1(String regId, String algorithmType);

    /**
     * 根据企业编号，查询一级指标得分、权重和下属指标数量
     * @param regId
     * @return
     */
    public List<IndicatorScoreWeight> getIndicatorScoreListByLevel2(String regId, String algorithmType);

    /**
     * 根据企业编号，查询注册资金历史记录和增长率
     * @param regId
     * @return
     */
//    public List<CapitalGrowth> getCapitalGrowthList(String regId);

    /**
     * 查询一个企业的四大维度的各三个重要指标的指标值
     * @param regId
     * @return
     */
    public IndicatorAttr getIndicatorAttrList(String regId);

    /**
     * 根据企业编号，算法类型，查询最近六月信用得分
     * @param regId
     * @param algorithmType
     * @return
     */
    public List<Map<String, Object>> getCreditScore(String regId, String algorithmType);
	
    /**
     * 获取所有评分模型算法的 code和name
     * @return
     */
    public Map<String, String> getScoreModelMap();
}