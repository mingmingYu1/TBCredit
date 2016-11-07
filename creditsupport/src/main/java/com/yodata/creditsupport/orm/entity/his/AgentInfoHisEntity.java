package com.yodata.creditsupport.orm.entity.his;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name ="ods_agent_info_his", catalog="credit_db")
public class AgentInfoHisEntity {

	private Integer id;                //主键
	private String regId;              //工商注册号
	private Date createTime;		   //生成时间
	private String fileNo;			   //文件编号
    private String compName;           //企业名称
    private String lperName;           //法人姓名
    private String status;            //企业状态 
    private Double regAssets;          //注册资本
    private Date openDate;             //开业日期（指标为“成立年限”）
    private String curType;            //货币种类 -- CNY/USD
    private String opePeriod;            //经营期限
    private String orgCode;            //社会信用代码/组织机构代码
    private Date validDate;            //代码证有效期
    private String lastYear;           //最后年检年度
    private Date lastDate;             //最后年检日期
    private Date cancelledDate;        //注销日期
    private Date revokDate;            //吊销日期
    private String typeEnt;            //企业类型
    private String typeOrg;            //机构类型
    private Integer emps;              //员工人数
    private String licPro;             //许可经营项目
    private String licGen;             //一般经营项目
    private String webSite;            //企业网址
    private String regAuth;            //工商登记机关
    private String industry;           //所属行业
    private String speMark;            //特殊标识
    private String busCope;            //经营范围
    private Integer saleType;          //机票销售代理资质种类 -- 1/2/3
    private Double busArea;            //主要经营场所面积
    private Integer busStab;           //经营场所稳定性
    private Integer age;               //年龄(自然人)
    private String addr;               //当前户籍地址(自然人)
    private Integer degree;            //学历(自然人) -- 1/2/3/4
    private Integer marSta;            //婚姻状况(自然人) -- 0/1
    private Integer busTraIndustry;    //商旅行业经验(自然人) -- 0/1
    private String coopSinc;           //授信合作诚意(自然人) -- 0/1/2
    private Integer localTime;         //当地居住时长(自然人)
    private Double houseErea;          //目前拥有房产的总面积(自然人)
    private Double ownHouseValue;      //目前房产可支配总净现值(自然人)
    private Integer ownCars;           //家庭拥有车辆情况(自然人)
    
    private Double indScore;        //最后一次得分
    private String score1;			// 
    private String score2;			// 
    private String score1Per;		// 
    private String score2Per;		// 
    private String score1Weight;	// 
    private String score2Weight;	// 
    
	// ~ ======================= 保存历史数据的计算结果，为了方便查询和避免不必要的再计算
    private String level;			// 评分等级
    private Integer score;			// 得分
    private String levelDesc;		// 等级描述
    // ~ =======================
    private String curTypeName;     //货币种类中文名称
    private String regAssetsStr;	//注册资本千分位
    
    private String industryCode;    //行业门类代码
    private String originalRegId;   //原注册号
    private Date annualSurveyTime;  //发照年检日期
    private Date operatingStartTime; //营业有效开始日期
    private Date operatingEndTime;   //营业有效结束日期
    private String industryName;     //行业分类名称
    
    private List<EntAttrInfoHisEntity> entAttrInfos = new ArrayList<>();//地址信息
    private List<StockholderInfoHisEntity> stockholderInfos = new ArrayList<>();//股东信息
    private List<TopManagerInfoHisEntity> topManagerInfos = new ArrayList<>();//高管信息
    private List<OthEntInvestsInfoHisEntity> othEntInvestsInfos = new ArrayList<>();//对外股权投资信息
    private List<LegPerInfoHisEntity> legPerInfos = new ArrayList<>();//法定代表人在其他机构任职信息:type=1
    private List<OdsLegPerEquityHisEntity> legPerQuityInfos = new ArrayList<>();
    private List<SpecialInfoHisEntity> specialInfos = new ArrayList<>();//法院被执行信息
    private List<BasicIndiScoreHisEntity> basicIndiScore = new ArrayList<>();//法定代表人股权投资信息:type=2
    
    private List<AgentChangeHisEntity> changeInfos = new ArrayList<>();//企业变更信息
    private List<AgentFiliationHisEntity> filiationInfos = new ArrayList<>();//分支结构信息
    private List<AgentLiquidationHisEntity> liquidataInfos = new ArrayList<>();//清算信息
    private List<AgentMortgageHisEntity> MortgageInfos = new ArrayList<>();//动产抵押信息
    private List<MortgageItemHisEntity> mortgageItemInfos = new ArrayList<>();//动产抵押物信息
    private List<AgentSharesFroHisEntity> agentSharesInfos = new ArrayList<>();//股权冻结历史信息
    private List<AgentSharesImpawnHisEntity> agentSharesImpawnInfos = new ArrayList<>();//股权出质历史信息
    private List<AgentTaxAccountHisEntity> agentTaxAccoutInfos = new ArrayList<>();//税务信息
    private List<AgentJudgementDocumentHisEntity> agentJudgedocInfos = new ArrayList<>();//违法违规裁判文书信息
    private List<AgentCourEnforcementHisEntity> agentCoutEnforceInfos = new ArrayList<>();//违法违规执行公告信息
    private List<AgentTopLeaderJudgementDocumentHisEntity> agentTopleaderJudgmentDocInfos = new ArrayList<>();//裁判文书
    private List<AgentTopLeaderExecuteDocHisEntity> agentTopleaderExdocInfos = new ArrayList<>();//执行公告信息
    private List<AgentTopleaderDishonourNoticHisEntity> agentTopleaderDishonourInfos = new ArrayList<>();//失信公告
    private List<AgentTopleaderNetloanHisEntity> agentTopleaderNetloadInfos = new ArrayList<>();//网贷黑名单
    private List<AgentTopleaderCourExposureHisEntity> agentTopleaderCourtExposInfos = new ArrayList<>();//曝光台
    private List<AgentAliLoanbreakHisEntity> agentAliloadBreakInfos = new ArrayList<>();//阿里欠贷
    private List<MerchantTrandeReportBaseHis> merchantTradeInfos = new ArrayList<>();//核心经营
    private List<MerchantTrandeReportStabilityHis> merchantStabilityInfos = new ArrayList<>();//经营稳定性
    private List<MerchantTrandeReportChangeHis> merchantReportChangeInfos = new ArrayList<>();//经营变化趋势
    private List<MerchantTrandeReportConstrastHis> merchantReportConstrastInfos = new ArrayList<>();//本市同行对比
    private List<MerchantTrandeReportAreaHis> merchantReportAreaInfos = new ArrayList<>();//客户地域分布
    private List<MerchantTrandeReportLoyaltyHis> merchantReportLoyalInfos = new ArrayList<>();//客户忠诚度
    private List<MerchantTradeReportAbormalHis> merchantReportAbormalInfos = new ArrayList<>();//客户忠诚度
    private List<OdsBalanceSheetHisEntity> odsBalanceSheetInfos = new ArrayList<>();//资产负债
    private List<OdsProfitHisEntity> odsProfitInfos = new ArrayList<>();//利润表
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    public Integer getId() {
        return id;
    }
	public void setId(Integer id) {
        this.id = id;
    }
	@OneToMany(mappedBy = "fileNo",targetEntity=EntAttrInfoHisEntity.class,fetch=FetchType.LAZY)//
    @Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<EntAttrInfoHisEntity> getEntAttrInfos() {
    	return entAttrInfos;
    }
    public void setEntAttrInfos(List<EntAttrInfoHisEntity> entAttrInfos) {
    	this.entAttrInfos = entAttrInfos;
    }
    @OneToMany(mappedBy = "fileNo",targetEntity=StockholderInfoHisEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
    @Fetch(FetchMode.SELECT)
    public List<StockholderInfoHisEntity> getStockholderInfos() {
		return stockholderInfos;
	}
	public void setStockholderInfos(List<StockholderInfoHisEntity> stockholderInfos) {
		this.stockholderInfos = stockholderInfos;
	}
	@OneToMany(mappedBy = "fileNo",targetEntity=TopManagerInfoHisEntity.class,fetch=FetchType.LAZY)//
    @Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<TopManagerInfoHisEntity> getTopManagerInfos() {
		return topManagerInfos;
	}
	public void setTopManagerInfos(List<TopManagerInfoHisEntity> topManagerInfos) {
		this.topManagerInfos = topManagerInfos;
	}
	@OneToMany(mappedBy = "fileNo",targetEntity=OthEntInvestsInfoHisEntity.class,fetch=FetchType.LAZY)//
    @Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<OthEntInvestsInfoHisEntity> getOthEntInvestsInfos() {
		return othEntInvestsInfos;
	}
	public void setOthEntInvestsInfos(List<OthEntInvestsInfoHisEntity> othEntInvestsInfos) {
		this.othEntInvestsInfos = othEntInvestsInfos;
	}
	@OneToMany(mappedBy = "fileNo",targetEntity=LegPerInfoHisEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<LegPerInfoHisEntity> getLegPerInfos() {
		return legPerInfos;
	}
	public void setLegPerInfos(List<LegPerInfoHisEntity> legPerInfos) {
		this.legPerInfos = legPerInfos;
	}
	@OneToMany(mappedBy = "fileNo",targetEntity=SpecialInfoHisEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<SpecialInfoHisEntity> getSpecialInfos() {
		return specialInfos;
	}
	public void setSpecialInfos(List<SpecialInfoHisEntity> specialInfos) {
		this.specialInfos = specialInfos;
	}
	@OneToMany(mappedBy = "fileNo",targetEntity=BasicIndiScoreHisEntity.class,fetch=FetchType.LAZY)//
    @Cascade({CascadeType.SAVE_UPDATE})
	@Fetch(FetchMode.SELECT)
	public List<BasicIndiScoreHisEntity> getBasicIndiScore() {
		return basicIndiScore;
	}
	public void setBasicIndiScore(List<BasicIndiScoreHisEntity> basicIndiScore) {
		this.basicIndiScore = basicIndiScore;
	}
	
	
	//法人对外投资
	@OneToMany(mappedBy = "fileNo",targetEntity=OdsLegPerEquityHisEntity.class,fetch=FetchType.LAZY)//
    @Cascade({CascadeType.SAVE_UPDATE})
	@Fetch(FetchMode.SELECT)
	public List<OdsLegPerEquityHisEntity> getLegPerQuityInfos() {
		return legPerQuityInfos;
	}
	public void setLegPerQuityInfos(List<OdsLegPerEquityHisEntity> legPerQuityInfos) {
		this.legPerQuityInfos = legPerQuityInfos;
	}
	//企业变更
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentChangeHisEntity.class,fetch=FetchType.LAZY)//
    @Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentChangeHisEntity> getChangeInfos() {
		return changeInfos;
	}
	public void setChangeInfos(List<AgentChangeHisEntity> changeInfos) {
		this.changeInfos = changeInfos;
	}
	
	//分支结构
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentFiliationHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentFiliationHisEntity> getFiliationInfos() {
		return filiationInfos;
	}
	public void setFiliationInfos(List<AgentFiliationHisEntity> filiationInfos) {
		this.filiationInfos = filiationInfos;
	}
	
	//清算信息
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentLiquidationHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentLiquidationHisEntity> getLiquidataInfos() {
		return liquidataInfos;
	}
	public void setLiquidataInfos(List<AgentLiquidationHisEntity> liquidataInfos) {
		this.liquidataInfos = liquidataInfos;
	}
	
	//动产抵押信息
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentMortgageHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentMortgageHisEntity> getMortgageInfos() {
		return MortgageInfos;
	}
	public void setMortgageInfos(List<AgentMortgageHisEntity> mortgageInfos) {
		MortgageInfos = mortgageInfos;
	}
	
	//动产抵押物信息
	@OneToMany(mappedBy = "fileNo",targetEntity=MortgageItemHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<MortgageItemHisEntity> getMortgageItemInfos() {
		return mortgageItemInfos;
	}
	public void setMortgageItemInfos(List<MortgageItemHisEntity> mortgageItemInfos) {
		this.mortgageItemInfos = mortgageItemInfos;
	}
	
	//股权冻结历史信息
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentSharesFroHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentSharesFroHisEntity> getAgentSharesInfos() {
		return agentSharesInfos;
	}
	public void setAgentSharesInfos(List<AgentSharesFroHisEntity> agentSharesInfos) {
		this.agentSharesInfos = agentSharesInfos;
	}
	
	//股权出质
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentSharesImpawnHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentSharesImpawnHisEntity> getAgentSharesImpawnInfos() {
		return agentSharesImpawnInfos;
	}
	public void setAgentSharesImpawnInfos(List<AgentSharesImpawnHisEntity> agentSharesImpawnInfos) {
		this.agentSharesImpawnInfos = agentSharesImpawnInfos;
	}
	
	//资产负债
	@OneToMany(mappedBy = "fileNo",targetEntity=OdsBalanceSheetHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<OdsBalanceSheetHisEntity> getOdsBalanceSheetInfos() {
		return odsBalanceSheetInfos;
	}
	public void setOdsBalanceSheetInfos(List<OdsBalanceSheetHisEntity> odsBalanceSheetInfos) {
		this.odsBalanceSheetInfos = odsBalanceSheetInfos;
	}
	
	//资产负债
	@OneToMany(mappedBy = "fileNo",targetEntity=OdsProfitHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<OdsProfitHisEntity> getOdsProfitInfos() {
		return odsProfitInfos;
	}
	public void setOdsProfitInfos(List<OdsProfitHisEntity> odsProfitInfos) {
		this.odsProfitInfos = odsProfitInfos;
	}
	
	//税务信息
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentTaxAccountHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentTaxAccountHisEntity> getAgentTaxAccoutInfos() {
		return agentTaxAccoutInfos;
	}
	public void setAgentTaxAccoutInfos(List<AgentTaxAccountHisEntity> agentTaxAccoutInfos) {
		this.agentTaxAccoutInfos = agentTaxAccoutInfos;
	}
	
	
	//经营变化趋势信息
	@OneToMany(mappedBy = "fileNo",targetEntity=MerchantTrandeReportChangeHis.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<MerchantTrandeReportChangeHis> getMerchantReportChangeInfos() {
		return merchantReportChangeInfos;
	}
	public void setMerchantReportChangeInfos(List<MerchantTrandeReportChangeHis> merchantReportChangeInfos) {
		this.merchantReportChangeInfos = merchantReportChangeInfos;
	}
	
	
	//同市行业对比
	@OneToMany(mappedBy = "fileNo",targetEntity=MerchantTrandeReportConstrastHis.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<MerchantTrandeReportConstrastHis> getMerchantReportConstrastInfos() {
		return merchantReportConstrastInfos;
	}
	public void setMerchantReportConstrastInfos(List<MerchantTrandeReportConstrastHis> merchantReportConstrastInfos) {
		this.merchantReportConstrastInfos = merchantReportConstrastInfos;
	}
	
	
	//异常交易
	@OneToMany(mappedBy = "fileNo",targetEntity=MerchantTradeReportAbormalHis.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<MerchantTradeReportAbormalHis> getMerchantReportAbormalInfos() {
		return merchantReportAbormalInfos;
	}
	public void setMerchantReportAbormalInfos(List<MerchantTradeReportAbormalHis> merchantReportAbormalInfos) {
		this.merchantReportAbormalInfos = merchantReportAbormalInfos;
	}
	//客户地域分布
	@OneToMany(mappedBy = "fileNo",targetEntity=MerchantTrandeReportAreaHis.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<MerchantTrandeReportAreaHis> getMerchantReportAreaInfos() {
		return merchantReportAreaInfos;
	}
	public void setMerchantReportAreaInfos(List<MerchantTrandeReportAreaHis> merchantReportAreaInfos) {
		this.merchantReportAreaInfos = merchantReportAreaInfos;
	}
	
	//客户忠诚度
	@OneToMany(mappedBy = "fileNo",targetEntity=MerchantTrandeReportLoyaltyHis.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<MerchantTrandeReportLoyaltyHis> getMerchantReportLoyalInfos() {
		return merchantReportLoyalInfos;
	}
	public void setMerchantReportLoyalInfos(List<MerchantTrandeReportLoyaltyHis> merchantReportLoyalInfos) {
		this.merchantReportLoyalInfos = merchantReportLoyalInfos;
	}
	//违法违规裁判文书
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentJudgementDocumentHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentJudgementDocumentHisEntity> getAgentJudgedocInfos() {
		return agentJudgedocInfos;
	}
	public void setAgentJudgedocInfos(List<AgentJudgementDocumentHisEntity> agentJudgedocInfos) {
		this.agentJudgedocInfos = agentJudgedocInfos;
	}
	
	//违法违规执行公告
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentCourEnforcementHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentCourEnforcementHisEntity> getAgentCoutEnforceInfos() {
		return agentCoutEnforceInfos;
	}
	public void setAgentCoutEnforceInfos(List<AgentCourEnforcementHisEntity> agentCoutEnforceInfos) {
		this.agentCoutEnforceInfos = agentCoutEnforceInfos;
	}
	
	
	//法定代表人失信规执行公告
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentTopLeaderJudgementDocumentHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentTopLeaderJudgementDocumentHisEntity> getAgentTopleaderJudgmentDocInfos() {
		return agentTopleaderJudgmentDocInfos;
	}
	public void setAgentTopleaderJudgmentDocInfos(
			List<AgentTopLeaderJudgementDocumentHisEntity> agentTopleaderJudgmentDocInfos) {
		this.agentTopleaderJudgmentDocInfos = agentTopleaderJudgmentDocInfos;
	}
	//法定代表人失信规执行公告
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentTopLeaderExecuteDocHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentTopLeaderExecuteDocHisEntity> getAgentTopleaderExdocInfos() {
		return agentTopleaderExdocInfos;
	}
	public void setAgentTopleaderExdocInfos(List<AgentTopLeaderExecuteDocHisEntity> agentTopleaderExdocInfos) {
		this.agentTopleaderExdocInfos = agentTopleaderExdocInfos;
	}
	
	//法定代表人失信公告
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentTopleaderDishonourNoticHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentTopleaderDishonourNoticHisEntity> getAgentTopleaderDishonourInfos() {
		return agentTopleaderDishonourInfos;
	}
	public void setAgentTopleaderDishonourInfos(List<AgentTopleaderDishonourNoticHisEntity> agentTopleaderDishonourInfos) {
		this.agentTopleaderDishonourInfos = agentTopleaderDishonourInfos;
	}
	
	//法定代表人失信网贷黑名单
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentTopleaderNetloanHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentTopleaderNetloanHisEntity> getAgentTopleaderNetloadInfos() {
		return agentTopleaderNetloadInfos;
	}
	public void setAgentTopleaderNetloadInfos(List<AgentTopleaderNetloanHisEntity> agentTopleaderNetloadInfos) {
		this.agentTopleaderNetloadInfos = agentTopleaderNetloadInfos;
	}
	
	//法定代表人失信曝光台
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentTopleaderCourExposureHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentTopleaderCourExposureHisEntity> getAgentTopleaderCourtExposInfos() {
		return agentTopleaderCourtExposInfos;
	}
	public void setAgentTopleaderCourtExposInfos(List<AgentTopleaderCourExposureHisEntity> agentTopleaderCourtExposInfos) {
		this.agentTopleaderCourtExposInfos = agentTopleaderCourtExposInfos;
	}
	
	//阿里欠贷
	@OneToMany(mappedBy = "fileNo",targetEntity=AgentAliLoanbreakHisEntity.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<AgentAliLoanbreakHisEntity> getAgentAliloadBreakInfos() {
		return agentAliloadBreakInfos;
	}
	public void setAgentAliloadBreakInfos(List<AgentAliLoanbreakHisEntity> agentAliloadBreakInfos) {
		this.agentAliloadBreakInfos = agentAliloadBreakInfos;
	}
	
	//核心经营
	@OneToMany(mappedBy = "fileNo",targetEntity=MerchantTrandeReportBaseHis.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<MerchantTrandeReportBaseHis> getMerchantTradeInfos() {
		return merchantTradeInfos;
	}
	public void setMerchantTradeInfos(List<MerchantTrandeReportBaseHis> merchantTradeInfos) {
		this.merchantTradeInfos = merchantTradeInfos;
	}
	
	//经营稳定性
	@OneToMany(mappedBy = "fileNo",targetEntity=MerchantTrandeReportStabilityHis.class,fetch=FetchType.LAZY)//
	@Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
	@Fetch(FetchMode.SELECT)
	public List<MerchantTrandeReportStabilityHis> getMerchantStabilityInfos() {
		return merchantStabilityInfos;
	}
	public void setMerchantStabilityInfos(List<MerchantTrandeReportStabilityHis> merchantStabilityInfos) {
		this.merchantStabilityInfos = merchantStabilityInfos;
	}
	
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name="file_no")
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	
    @Column(name="comp_name")
    public String getCompName() {
        return compName;
    }
    public void setCompName(String compName) {
        this.compName = compName;
    }

    @Column(name="lper_name")
    public String getLperName() {
        return lperName;
    }
    public void setLperName(String lperName) {
        this.lperName = lperName;
    }

    @Column(name="status")
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name="reg_assets")
    public Double getRegAssets() {
        return regAssets;
    }
    public void setRegAssets(Double regAssets) {
        this.regAssets = regAssets;
    }

    @Column(name="open_date")
    public Date getOpenDate() {
        return openDate;
    }
    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    @Column(name="cur_type")
    public String getCurType() {
        return curType;
    }
    public void setCurType(String curType) {
        this.curType = curType;
    }

    @Column(name="ope_period")
    public String getOpePeriod() {
        return opePeriod;
    }
    public void setOpePeriod(String opePeriod) {
        this.opePeriod = opePeriod;
    }

    @Column(name="org_code")
    public String getOrgCode() {
        return orgCode;
    }
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    @Column(name="valid_date")
    public Date getValidDate() {
        return validDate;
    }
    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    @Column(name="reg_id")
    public String getRegId() {
        return regId;
    }
    public void setRegId(String regId) {
        this.regId = regId;
    }

    @Column(name="last_year")
    public String getLastYear() {
        return lastYear;
    }
    public void setLastYear(String lastYear) {
        this.lastYear = lastYear;
    }

    @Column(name="last_date")
    public Date getLastDate() {
        return lastDate;
    }
    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    @Column(name="cancelled_date")
    public Date getCancelledDate() {
        return cancelledDate;
    }
    public void setCancelledDate(Date cancelledDate) {
        this.cancelledDate = cancelledDate;
    }

    @Column(name="revok_date")
    public Date getRevokDate() {
        return revokDate;
    }
    public void setRevokDate(Date revokDate) {
        this.revokDate = revokDate;
    }

    @Column(name="type_ent")
    public String getTypeEnt() {
        return typeEnt;
    }
    public void setTypeEnt(String typeEnt) {
        this.typeEnt = typeEnt;
    }

    @Column(name="type_org")
    public String getTypeOrg() {
        return typeOrg;
    }
    public void setTypeOrg(String typeOrg) {
        this.typeOrg = typeOrg;
    }

    @Column(name="emps")
    public Integer getEmps() {
        return emps;
    }
    public void setEmps(Integer emps) {
        this.emps = emps;
    }

    @Column(name="lic_pro")
    public String getLicPro() {
        return licPro;
    }
    public void setLicPro(String licPro) {
        this.licPro = licPro;
    }

    @Column(name="lic_gen")
    public String getLicGen() {
        return licGen;
    }
    public void setLicGen(String licGen) {
        this.licGen = licGen;
    }

    @Column(name="web_site")
    public String getWebSite() {
        return webSite;
    }
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @Column(name="reg_auth")
    public String getRegAuth() {
        return regAuth;
    }
    public void setRegAuth(String regAuth) {
        this.regAuth = regAuth;
    }

    @Column(name="industry")
    public String getIndustry() {
        return industry;
    }
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Column(name="spe_mark")
    public String getSpeMark() {
        return speMark;
    }
    public void setSpeMark(String speMark) {
        this.speMark = speMark;
    }

    @Column(name="bus_cope")
    public String getBusCope() {
        return busCope;
    }
    public void setBusCope(String busCope) {
        this.busCope = busCope;
    }

    @Column(name="sale_type")
    public Integer getSaleType() {
        return saleType;
    }
    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
    }

    @Column(name="bus_area")
    public Double getBusArea() {
        return busArea;
    }
    public void setBusArea(Double busArea) {
        this.busArea = busArea;
    }

    @Column(name="bus_stab")
    public Integer getBusStab() {
        return busStab;
    }
    public void setBusStab(Integer busStab) {
        this.busStab = busStab;
    }

    @Column(name="age")
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name="addr")
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Column(name="degree")
    public Integer getDegree() {
        return degree;
    }
    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    @Column(name="mar_sta")
    public Integer getMarSta() {
        return marSta;
    }
    public void setMarSta(Integer marSta) {
        this.marSta = marSta;
    }

    @Column(name="bus_tra_industry")
    public Integer getBusTraIndustry() {
        return busTraIndustry;
    }
    public void setBusTraIndustry(Integer busTraIndustry) {
        this.busTraIndustry = busTraIndustry;
    }

    @Column(name="coop_sinc")
    public String getCoopSinc() {
        return coopSinc;
    }
    public void setCoopSinc(String coopSinc) {
        this.coopSinc = coopSinc;
    }

    @Column(name="local_time")
    public Integer getLocalTime() {
        return localTime;
    }
    public void setLocalTime(Integer localTime) {
        this.localTime = localTime;
    }

    @Column(name="house_erea")
    public Double getHouseErea() {
        return houseErea;
    }
    public void setHouseErea(Double houseErea) {
        this.houseErea = houseErea;
    }

    @Column(name="own_house_value")
    public Double getOwnHouseValue() {
        return ownHouseValue;
    }
    public void setOwnHouseValue(Double ownHouseValue) {
        this.ownHouseValue = ownHouseValue;
    }

    @Column(name="own_cars")
    public Integer getOwnCars() {
        return ownCars;
    }
    public void setOwnCars(Integer ownCars) {
        this.ownCars = ownCars;
    }
    
    @Column(name="ind_score", nullable = true)
    public Double getIndScore() {
		return indScore;
	}
	public void setIndScore(Double indScore) {
		this.indScore = indScore;
	}

	@Column(name="score1")
	public String getScore1() {
		return score1;
	}
	public void setScore1(String score1) {
		this.score1 = score1;
	}
	@Column(name="score2")
	public String getScore2() {
		return score2;
	}
	public void setScore2(String score2) {
		this.score2 = score2;
	}
	@Column(name="score1_per")
	public String getScore1Per() {
		return score1Per;
	}
	public void setScore1Per(String score1Per) {
		this.score1Per = score1Per;
	}
	@Column(name="score2_per")
	public String getScore2Per() {
		return score2Per;
	}
	public void setScore2Per(String score2Per) {
		this.score2Per = score2Per;
	}
	@Column(name="score1_weight")
	public String getScore1Weight() {
		return score1Weight;
	}
	public void setScore1Weight(String score1Weight) {
		this.score1Weight = score1Weight;
	}
	@Column(name="score2_weight")
	public String getScore2Weight() {
		return score2Weight;
	}
	public void setScore2Weight(String score2Weight) {
		this.score2Weight = score2Weight;
	}
	
    @Column(name="level")
    public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Column(name="score", precision = 6, scale = 4)
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Column(name="level_desc")
	public String getLevelDesc() {
		return levelDesc;
	}
	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}
	
	 @Column(name="INDUSTRY_CODE")
	    public String getIndustryCode() {
			return industryCode;
		}
		public void setIndustryCode(String industryCode) {
			this.industryCode = industryCode;
		}

	    @Column(name="ORIGINAL_REG_ID")
	    public String getOriginalRegId() {
			return originalRegId;
		}
		public void setOriginalRegId(String originalRegId) {
			this.originalRegId = originalRegId;
		}
		
	    @Column(name="ANNUAL_SURVEY_TIME")
		public Date getAnnualSurveyTime() {
			return annualSurveyTime;
		}
		public void setAnnualSurveyTime(Date annualSurveyTime) {
			this.annualSurveyTime = annualSurveyTime;
		}

		@Column(name="OPERATING_START_TIME")
		public Date getOperatingStartTime() {
			return operatingStartTime;
		}
		public void setOperatingStartTime(Date operatingStartTime) {
			this.operatingStartTime = operatingStartTime;
		}
		
	    @Column(name="OPERATING_END_TIME")
	    public Date getOperatingEndTime() {
			return operatingEndTime;
		}
		public void setOperatingEndTime(Date operatingEndTime) {
			this.operatingEndTime = operatingEndTime;
		}
		
	    @Column(name="INDUSTRY_NAME")
		public String getIndustryName() {
			return industryName;
		}
		public void setIndustryName(String industryName) {
			this.industryName = industryName;
		}    
	
	@Transient
    public String getCurTypeName() {
		return curTypeName;
	}
	public void setCurTypeName(String curTypeName) {
		this.curTypeName = curTypeName;
	}
	@Transient
	public String getRegAssetsStr() {
		if(this.regAssets == null || this.regAssets == 0.0d) {
			regAssetsStr = "0";
		} else {
			regAssetsStr = DecimalFormat.getNumberInstance().format(this.regAssets.intValue());
		}
		return regAssetsStr;
	}
	public void setRegAssetsStr(String regAssetsStr) {
		this.regAssetsStr = regAssetsStr;
	}
}
