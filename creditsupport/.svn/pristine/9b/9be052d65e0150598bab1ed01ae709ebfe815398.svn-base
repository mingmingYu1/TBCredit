package com.yodata.creditsupport.util;

public enum IndNameEnum {
	
	REG_ASSETS("REG_ASSETS","注册资本"),
	FIXED_YEAR("FIXED_YEAR","成立年限"),
	EMPS("EMPS","员工人数"),
	SALE_TYPE("SALE_TYPE","机票销售代理资质种类"),
	BUS_AREA("BUS_AREA","主要经营场所面积"),
	BUS_STAB("BUS_STAB","经营场所稳定性"),
	AGE("AGE","年龄"),
	ADDR("ADDR","当前户籍地址"),
	DEGREE("DEGREE","学历"),
	MAR_STA("MAR_STA","婚姻状况"),
	BUS_TRA_INDUSTRY("BUS_TRA_INDUSTRY","商旅行业经验"),
	COOP_SINC("COOP_SINC","授信合作诚意"),
	LOCAL_TIME("LOCAL_TIME","当地居住时长"),
	HOUSE_EREA("HOUSE_EREA","目前拥有房产的总面积"),
	OWN_HOUSE_VALUE("OWN_HOUSE_VALUE","目前房产可支配总净现值"),
	OWN_CARS("OWN_CARS","家庭拥有车辆情况"),
	SERV_CENTER("SERV_CENTER","机票销售客服呼叫中心"),
	PLAT("PLAT","机票直销网上预定平台"),
	NODE_NUM("NODE_NUM","营业网点数量(含本市及异地)"),
	OTH_BUSI("OTH_BUSI","经营非机票类类业务"),
	POLICY("POLICY","航空公司机票政策"),
	ARI_COV("ARI_COV","航空公司覆盖程度"),
	SIX_M_VOTES("SIX_M_VOTES","近6个月平均月出票量"),
	SIX_M_VOTES_RATE("SIX_M_VOTES_RATE","近6个月出票增长率"),
	SIX_M_INVALID_RATE("SIX_M_INVALID_RATE","近6个月平均退废票率"),
	SIX_CON_ORDER_RATE("SIX_CON_ORDER_RATE","近6个月联程票比例"),
	SIX_GAP_RATE("SIX_GAP_RATE","近6个月缺口票比例"),
	SIX_CHID_RATE("SIX_CHID_RATE","近6个月儿童票比例"),
	AVE_AMT_ATK_LSMON("AVE_AMT_ATK_LSMON","近6个月平均机票月销售额"),
	AVE_AMT_NATK_LSMON("AVE_AMT_NATK_LSMON","近6个月平均非机票月销售额"),
	ATK_SALES_INC_RATIO_LSMON("ATK_SALES_INC_RATIO_LSMON","近6个月机票销售额增长率"),
	GROSS_PROFIT_OF_LTYEAR("GROSS_PROFIT_OF_LTYEAR","近两年的年平均商旅毛利润总额"),
	AVE_ASS_LIB_RATIO_LSMON("AVE_ASS_LIB_RATIO_LSMON","近6个月平均资产负债率"),
	AVE_LIQ_RATIO_LSMON("AVE_LIQ_RATIO_LSMON","近6个月平均流动比率"),
	ASS_INCREASE_RATE("ASS_INCREASE_RATE","总资产增长率"),
	REC_BAL("REC_BAL","应收账款的余额"),
	ENT_CRE_REC("ENT_CRE_REC","企业贷款记录（指标统计24个月内逾期天数）"),
	TRADE_OUT_OF_LINE_REC("TRADE_OUT_OF_LINE_REC","同行业交易违规情况（指标统计违规次数）"),
	RYX_BUS_OVERDUE_REC("RYX_BUS_OVERDUE_REC","融易行商旅贷逾期记录（指标统计24个月内逾期天数）"),
	LPER_CRE_REC("LPER_CRE_REC","企业负责人贷款记录（指标统计24个月内逾期天数）"),
	LPER_CRECARD_REC("LPER_CRECARD_REC","企业负责人信用卡记录（指标统计24个月内逾期天数）"),
	ENT_COURT("ENT_COURT","企业法院被执行信息"),
	ADMIN_COURT("ADMIN_COURT","行政管理处罚"),
	LPER_COURT("LPER_COURT","企业负责人法院被执行信息");

	
	// 成员变量
	private String value;
	private String key;
	// 构造方法
	private IndNameEnum(String key, String value) {
		this.value = value;
		this.key = key;
	}
	// 普通方法
	public static String getName(String key) {
		for (IndNameEnum c : IndNameEnum.values()) {
			if (key.equals(c.getKey())) {
				return c.value;
			}
		}
		return null;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}
