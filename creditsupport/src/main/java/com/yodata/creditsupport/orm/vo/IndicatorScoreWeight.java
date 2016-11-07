package com.yodata.creditsupport.orm.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class IndicatorScoreWeight implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -2105473271409226914L;

	/** 主键 */
	private Integer id;
	/** 企业编号 */
	private String regId;
	/** 指标代码 */
	private String indicator;
	/** 指标名称 */
	private String indicatorName;
	/** 指标大类名称 */
	private String level1;
	/** 指标大类下属指标数量 */
    private BigInteger level1Count;
    /** 指标大类得分 */
    private Double level1Score;
    /** 指标大类权重 */
    private Double level1Weight;
	/** 一级指标名称 */
	private String level2;
	/** 一级指标下属指标数量 */
    private BigInteger level2Count;
    /** 一级指标得分 */
    private Double level2Score;
    /** 一级指标权重  */
    private Double level2Weight;
	/** 指标权重  */
	private Double weight;
	/** 指标得分 */
	private Double score;
	/** 指标详情链接 */
	private String detailURL;
	/** 指标行业属性  */
	private String indAttr;
	
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRegId() {
        return regId;
    }
    public void setRegId(String regId) {
        this.regId = regId;
    }
    public String getIndicator() {
        return indicator;
    }
    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }
    public String getIndicatorName() {
        return indicatorName;
    }
    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }
    public String getLevel1() {
        return level1;
    }
    public void setLevel1(String level1) {
        this.level1 = level1;
    }
    public BigInteger getLevel1Count() {
        return level1Count;
    }
    public void setLevel1Count(BigInteger level1Count) {
        this.level1Count = level1Count;
    }
    public Double getLevel1Score() {
        return level1Score;
    }
    public void setLevel1Score(Double level1Score) {
        this.level1Score = level1Score;
    }
    public Double getLevel1Weight() {
        return level1Weight;
    }
    public void setLevel1Weight(Double level1Weight) {
        this.level1Weight = level1Weight;
    }
    public String getLevel2() {
        return level2;
    }
    public void setLevel2(String level2) {
        this.level2 = level2;
    }
    public BigInteger getLevel2Count() {
        return level2Count;
    }
    public void setLevel2Count(BigInteger level2Count) {
        this.level2Count = level2Count;
    }
    public Double getLevel2Score() {
        return level2Score;
    }
    public void setLevel2Score(Double level2Score) {
        this.level2Score = level2Score;
    }
    public Double getLevel2Weight() {
        return level2Weight;
    }
    public void setLevel2Weight(Double level2Weight) {
        this.level2Weight = level2Weight;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
    public String getDetailURL() {
        return detailURL;
    }
    public void setDetailURL(String detailURL) {
        this.detailURL = detailURL;
    }
    public String getIndAttr() {
        return indAttr;
    }
    public void setIndAttr(String indAttr) {
        this.indAttr = indAttr;
    }
	
}