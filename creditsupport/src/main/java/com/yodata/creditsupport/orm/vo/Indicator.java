package com.yodata.creditsupport.orm.vo;

import java.io.Serializable;

public class Indicator implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -2105473271409226914L;

	/** 主键 */
	private Integer indicatorId;
	/** 指标编号 */
	private String indicatorCode;
	/** 指标名称 */
	private String indicatorName;
	/** 指标属性 */
	private String indicatorAttr;
	/** 指标的级别，深度从0开始算 */
	private Integer depth;
	/** 父级指标ID */
	private Integer parentId ;
	/** 一级指标ID */
	private Integer lvl1Id;
	/** 一级指标名称 */
	private String lvl1Name;
	/** 二级指标名称 */
	private String lvl2Name;
	/** 三级指标名称 */
	private String lvl3Name;
	/** 四级指标名称 */
	private String lvl4Name;
	/** 五级指标名称 */
	private String lvl5Name;
	/** 六级指标名称 */
	private String lvl6Name;
	/** 定性/定量：定性0，定量1 ,编号*/
	private Integer qualiQuanti;
	/** 定性/定量：定性0，定量1 ,文字*/
	private String qualiQuantiStr;
	/** 计算周期 */
	private Integer calculCycle;
	/** 计算周期 */
	private String calculCycleName;
	/** 指标描述 */
	private String indicatorDesc;
	/** 计算规则 */
	private String calculRule;
	/** 备用1 */
	private String reserve1;
	/** 备用2 */
	private String reserve2;
	/** 备用3 */
	private String reserve3;
	
	public Integer getIndicatorId() {
        return indicatorId;
    }
    public void setIndicatorId(Integer indicatorId) {
        this.indicatorId = indicatorId;
    }
    public String getIndicatorCode() {
		return indicatorCode;
	}
	public void setIndicatorCode(String indicatorCode) {
		this.indicatorCode = indicatorCode;
	}
	public String getIndicatorName() {
		return indicatorName;
	}
	public void setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
	}
	public String getIndicatorAttr() {
		return indicatorAttr;
	}
	public void setIndicatorAttr(String indicatorAttr) {
		this.indicatorAttr = indicatorAttr;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getLvl1Id() {
		return lvl1Id;
	}
	public void setLvl1Id(Integer lvl1Id) {
		this.lvl1Id = lvl1Id;
	}
	public String getLvl1Name() {
		return lvl1Name;
	}
	public void setLvl1Name(String lvl1Name) {
		this.lvl1Name = lvl1Name;
	}
	public String getLvl2Name() {
		return lvl2Name;
	}
	public void setLvl2Name(String lvl2Name) {
		this.lvl2Name = lvl2Name;
	}
	public String getLvl3Name() {
		return lvl3Name;
	}
	public void setLvl3Name(String lvl3Name) {
		this.lvl3Name = lvl3Name;
	}
	public String getLvl4Name() {
		return lvl4Name;
	}
	public void setLvl4Name(String lvl4Name) {
		this.lvl4Name = lvl4Name;
	}
	public String getLvl5Name() {
		return lvl5Name;
	}
	public void setLvl5Name(String lvl5Name) {
		this.lvl5Name = lvl5Name;
	}
	public String getLvl6Name() {
		return lvl6Name;
	}
	public void setLvl6Name(String lvl6Name) {
		this.lvl6Name = lvl6Name;
	}
	public Integer getQualiQuanti() {
		return qualiQuanti;
	}
	public void setQualiQuanti(Integer qualiQuanti) {
		this.qualiQuanti = qualiQuanti;
	}
	public String getQualiQuantiStr() {
		return qualiQuantiStr;
	}
	public void setQualiQuantiStr(String qualiQuantiStr) {
		this.qualiQuantiStr = qualiQuantiStr;
	}
	public Integer getCalculCycle() {
		return calculCycle;
	}
	public void setCalculCycle(Integer calculCycle) {
		this.calculCycle = calculCycle;
	}
	public String getCalculCycleName() {
		return calculCycleName;
	}
	public void setCalculCycleName(String calculCycleName) {
		this.calculCycleName = calculCycleName;
	}
	public String getIndicatorDesc() {
		return indicatorDesc;
	}
	public void setIndicatorDesc(String indicatorDesc) {
		this.indicatorDesc = indicatorDesc;
	}
	public String getCalculRule() {
		return calculRule;
	}
	public void setCalculRule(String calculRule) {
		this.calculRule = calculRule;
	}
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	public String getReserve2() {
		return reserve2;
	}
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	public String getReserve3() {
		return reserve3;
	}
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}

}