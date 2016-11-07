package com.yodata.creditsupport.util;

import org.springframework.beans.factory.annotation.Value;

public class ConstantBean {
    //算法接口地址
    @Value("${algorithm.host}")
    private String algorithmHost;    
    //LR算法训练参数
    @Value("${algorithm.lr.operation.train}")
    private String algorithmLROperationTrain;
    //LR算法预测参数
    @Value("${algorithm.lr.operation.predict}")
    private String algorithmLROperationPredict;
    //行业模型的代码，默认110000
    @Value("${algorithm.lr.model.code}")
    private String algorithmLRModelCode;
    
    ///////FTP的IP地址、端口、用户名和密码
    //FTP的ip地址
    @Value("${ftp.user.ip}")
    private String ftpIp;
    //FTP的端口号
    @Value("${ftp.user.port}")
    private Integer ftpPort;
    //FTP的用户名
    @Value("${ftp.user.userName}")
    private String ftpUserName;
    //FTP的密码
    @Value("${ftp.user.userPassword}")
    private String ftpUserPassword;
    
    /////webService地址/////
    //添加企业的webservice地址
    @Value("${add.agent.webservice.addr}")
    private String addAgentWebserviceAddr;
    
    //更新企业的webservice地址
    @Value("${update.agent.webservice.addr}")
    private String upadeAgentWebserviceAddr;
    
    //添加个人征信的webservice地址
    @Value("${add.person.webservice.addr}")
    private String addPersonWebserviceAddr;
    
    //更新个人征信的webservice地址
    @Value("${update.person.webservice.addr}")
    private String updatePersonWebserviceAddr;
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    ///////SQLMapperID START
    ///////////////////////////////////////////////////////////////////////////
    //分页查询时，查询记录条数的sql比查询记录的sql多一个后缀
    @Value("${sql.page.count}")
    private String sqlCount;
    //根据企业编号查询一条企业详细基本信息
    @Value("${sql.companydao.getOneCompany}")
    private String sqlGetOneCompany;
    //分页查询企业 sqlMapperID
    @Value("${sql.companydao.getPageCompanys}")
    private String sqlGetPageCompanys;
    //分页查询企业 sqlMapperID
    @Value("${sql.companyDao.findAgentBygroupId}")
    private String sqlFindAgentBygroupId;
    @Value("${sql.companyDao.deleteCompScore}")
    private String sqlDeleteCompScore;
    
    //分页查询用户 sqlMapperID
    @Value("${sql.userdao.getPageUsers}")
    private String sqlGetPageUsers;
    //删除用户及角色关联关系
    @Value("${sql.userroledao.deleteUserRole}")
    private String sqlDeleteUserRole;
    
    //根据用户ID查询角色ID
    @Value("${sql.userdao.queryRoleByUserId}")
    private String sqlQueryRoleByUserId;
    //根据角色ID删除角色菜单的关联关系
    @Value("${sql.rolemenudao.deleteRoleMenu}")
    private String sqlDeleteRoleMenu;
    //角色分页查询
    @Value("${sql.roledao.getPageRoles}")
    private String sqlGetPageRoles;
    
    //通过角色id获取菜单
    @Value("${sql.menudao.getMenuByRoleId}")
    private String sqlGetMenuByRoleId;
    //通过用户id获取菜单
    @Value("${sql.menudao.getMenuByUserId}")
    private String sqlGetMenuByUserId;
    
    //部门分页查询
    @Value("${sql.deptdao.getPageDepts}")
    private String sqlGetPageDepts;
    
    //得分等级版本分页查询
    @Value("${sql.scorelevelversiondao.getPageScoreLevelVersions}")
    private String sqlGetPageScoreLevelVersions;
    //得分等级版本所有分数之和 
    @Value("${sql.scorelevelversiondao.getScoreSumByVersion}")
    private String sqlGetScoreSumByVersion;
    //查询评分区间是否有重叠区域 
    @Value("${sql.scoreleveldao.getScoreLevelEntityByScore}")
    private String sqlGetScoreLevelEntityByScore;
    //评分等级分页查询
    @Value("${sql.scoreleveldao.getPageScoreLevels}")
    private String sqlGetPageScoreLevels;
    
    //得分模型分页查询
    @Value("${sql.scoremodeldao.getPageScoreModels}")
    private String pageScoreModels;
    //根据企业ID查询企业所使用的算法
    @Value("${sql.scoremodeldao.getPageScoreModels}")
    private String sqlGetScoreModelEntityByRegId;
    
    
    //查询高管历史信息
    @Value("${sql.companyHisDao.getTopManagerInfoHis}")
    private String sqlGetTopManagerInfoHis;
    //查询对外股权投资历史信息
    @Value("${sql.companyHisDao.getOthEntInvestsInfoHis}")
    private String sqlGetOthEntInvestsInfoHis;
    //查询个指标大类的得分和权重历史信息
    @Value("${sql.companyHisDao.getBasicIndiScoreHis}")
    private String sqlGetBasicIndiScoreHis;
    //查询当前高管记录
    @Value("${sql.companyHisDao.getTopManagerInfo}")
    private String sqlGetTopManagerInfo;
    //查询当前对外股权投资记录
    @Value("${sql.companyHisDao.getOthEntInvestsInfo}")
    private String sqlGetOthEntInvestsInfo;
    //查询当前企业联系地址记录
    @Value("${sql.companyHisDao.getEntAttrInfo}")
    private String sqlGetEntAttrInfo;
    //查询当前法院记录
    @Value("${sql.companyHisDao.getSpecialInfo}")
    private String sqlGetSpecialInfo;
    //查询当前法人记录
    @Value("${sql.companyHisDao.getLegPerInfo}")
    private String sqlGetLegPerInfo;
    //查询当前股东记录
    @Value("${sql.companyHisDao.getStockholderInfo}")
    private String sqlGetStockholderInfo;
    //查询企业联系地址历史记录
    @Value("${sql.companyHisDao.getEntAttrInfoHis}")
    private String sqlGetEntAttrInfoHis;
    //查询法院历史记录
    @Value("${sql.companyHisDao.getSpecialInfoHis}")
    private String sqlGetSpecialInfoHis;
    //查询法人历史记录
    @Value("${sql.companyHisDao.getLegPerInfoHis}")
    private String sqlGetLegPerInfoHis;
    //查询股东历史记录
    @Value("${sql.companyHisDao.getStockholderInfoHis}")
    private String sqlGetStockholderInfoHis;
    //获取企业注册资金的币种名称
    @Value("${sql.companyHisDao.getCurTypeName}")
    private String sqlGetCurTypeName;
    
    //分页查询征信报告记录
    @Value("${sql.saveInfoDao.getPageReport}")
    private String sqlGetPageReport;
    //查询所有的征信报告模板信息
    @Value("${sql.saveInfoDao.getAllReportTemp}")
    private String sqlGetAllReportTemp;
    //根据征信报告模板编号查询一条记录
    @Value("${sql.saveInfoDao.getTempletById}")
    private String sqlGetTempletById;
    //更新征信报告模板的使用状态
    @Value("${sql.saveInfoDao.updateTempletStatus}")
    private String sqlUpdateTempletStatus;
    //获取一条征信报告模板内的各个显示模块名称
    @Value("${sql.saveInfoDao.getTempletDict}")
    private String sqlGetTempletDict;
    //获取该企业当前征信报告编号的日期和尾部数字
    @Value("${sql.saveInfoDao.createMaxIndexReport}")
    private String sqlCreateMaxIndexReport;
    
    //分页查询征信报告模板记录
    @Value("${sql.reportTempletDao.getPageTemplet}")
    private String sqlGetPageReportTemplet;
    //查询征信报告全部标题信息
    @Value("${sql.reportTempletDao.getReportTitle}")
    private String reportTitle;
    
    //查询一个数据库或模式下的所有表的详细信息
    @Value("${sql.dictionarydao.queryDictionary}")
    private String sqlQueryDictionary;
    //查询一个数据库或模式下的所有的表名
    @Value("${sql.dictionarydao.queryTables}")
    private String sqlQueryTables;
    
    //根据企业编号，查询注册资金历史记录和增长率
    @Value("${sql.scoreDetalDao.getCapitalGrowthList}")
    private String sqlGetCapitalGrowthList;
    //查询企业 毛利额-增长率
    @Value("${sql.scoreDetalDao.getGrossProfit}")
    private String sqlGetGrossProfit;
    //查询企业的月退废票
    @Value("${sql.scoreDetalDao.getRetirementTicketMonth}")
    private String sqlGetRetirementTicketMonth;
    //查询企业的日退废票
    @Value("${sql.scoreDetalDao.getRetirementTicketDay}")
    private String sqlGetRetirementTicketDay;
    
    //根据算法类型查询企业各指标得分信息
    @Value("${sql.indicatorScoreDao.getIndicatorScoreList}")
    private String sqlGetIndicatorScoreList;
    //根据指标类型、算法类型查询企业各指标得分信息
    @Value("${sql.indicatorScoreDao.getIndicatorScoreListByAttr}")
    private String sqlGetIndicatorScoreListByAttr;
    //根据指标类型、算法类型查询企业各二级指标得分信息
    @Value("${sql.indicatorScoreDao.getIndicatorScoreListLevel2ByAttr}")
    private String sqlGetIndicatorScoreListLevel2ByAttr;
    //根据指标类型、算法类型查询企业各一级指标得分信息
    @Value("${sql.indicatorScoreDao.getIndicatorScoreListLevel1ByAttr}")
    private String sqlGetIndicatorScoreListLevel1ByAttr;
    //根据算法类型查询企业总得分信息
    @Value("${sql.indicatorScoreDao.getIndicatorScoreByTotal}")
    private String sqlGetIndicatorScoreByTotal;
    //根据算法类型查询企业各二级指标得分信息
    @Value("${sql.indicatorScoreDao.getIndicatorScoreListByLevel2}")
    private String sqlGetIndicatorScoreListByLevel2;
    //根据算法类型查询企业各一级指标得分信息
    @Value("${sql.indicatorScoreDao.getIndicatorScoreListByLevel1}")
    private String sqlGetIndicatorScoreListByLevel1;
    //查询企业各类指标信息
    @Value("${sql.indicatorScoreDao.getIndicatorAttrList}")
    private String sqlGetIndicatorAttrList;
    //查询企业最段时间征信得分信息
    @Value("${sql.indicatorScoreDao.getCreditScore}")
    private String sqlGetCreditScore;
    
    //指标分页查询下
    @Value("${sql.indicatorDao.getPageIndicators}")
    private String sqlGetPageIndicators;
    //查询一级指标名称，即指标大类名称
    @Value("${sql.indicatorDao.queryLevelIndicatorList}")
    private String sqlQueryLevelIndicatorList;
    //根据级别查询所有当前级别的指标
    @Value("${sql.indicatorDao.queryLevelIndicatorListByLevel}")
    private String sqlQueryLevelIndicatorListByLevel;
    //根据算法类型查询所有指标及权重
    @Value("${sql.indicatorDao.getAllEntityListByType}")
    private String sqlGetAllEntityListByType;
    
    
    //
  //查询企业变更记录
    @Value("${sql.companyHisDao.getAgentChangeInfo}")
    private String sqlAgentChangeInfo;
    
   //查询企业变更记录
    @Value("${sql.companyHisDao.getAgentFiliationInfo}")
    private String sqlAgentFiliationInfo;
    
   //查询企业清算信息
    @Value("${sql.companyHisDao.getAgentLiquidationInfo}")
    private String sqlAgentLiquidationInfo;
    
    //查询动产抵押信息
    @Value("${sql.companyHisDao.getAgentMortgageInfo}")
    private String sqlAgentMortgageInfo;
    
    //查询动产抵押物信息
    @Value("${sql.companyHisDao.getMortgageItemInfo}")
    private String sqlMortgageItemInfo;
    
    //查询股权冻结历史信息
    @Value("${sql.companyHisDao.getAgentSharesInfo}")
    private String sqlAgentSharesInfo;
    
    //查询股权冻出质历史信息
    @Value("${sql.companyHisDao.getAgentSharesImpawInfo}")
    private String sqlAgentSharesImpawInfo;
    
    //税务信息
    @Value("${sql.companyHisDao.getAgentTaxAccoutInfo}")
    private String sqlAgentTaxAccoutInfo;
    
    //经营变化趋势信息
    @Value("${sql.companyHisDao.getMerchantReportChangeInfo}")
    private String sqlMerchantReportChangeInfo;
    
    //月异常交易
    @Value("${sql.companyHisDao.getMerchantTradeAbormalInfo}")
    private String sqlMerchantTrandeAbormalInfo;
    
    //本市同行对比
    @Value("${sql.companyHisDao.getMerchantReportConstrastInfo}")
    private String sqlMerchantReportConstrastInfo;
    
    //客户地域分布
    @Value("${sql.companyHisDao.getMerchantReportAreaInfo}")
    private String sqlMerchantReportAreaInfo;
    
    //客户忠诚度
    @Value("${sql.companyHisDao.getMerchantReportLoyalInfo}")
    private String sqlMerchantReportLoyalInfo;
    
    //查询违法违规裁判文书
    @Value("${sql.companyHisDao.getAgentJudgementDocInfo}")
    private String sqlAgentJudgementDocInfo;
    
    //查询违法违规执行公告
    @Value("${sql.companyHisDao.getAgentCoutEnforceInfo}")
    private String sqlAgentCoutEnforceInfo;
    
    //法定代表人失信裁判文书
    @Value("${sql.companyHisDao.getAgentTopLeaderJudgmentDocInfo}")
    private String sqlAgentTopLeaderJudgmentDocInfo;
    
    //法定代表人失信规执行公告
    @Value("${sql.companyHisDao.getAgentTopLeaderExdocInfo}")
    private String sqlAgentTopLeaderExdocInfo;
    
    //法定代表人失信规执行公告
    @Value("${sql.companyHisDao.getAgentTopLeaderDishourInfo}")
    private String sqlAgentTopLeaderDishourInfo;
    
    //法定代表人失信网贷黑名单
    @Value("${sql.companyHisDao.getAgentTopLeaderNetloadInfo}")
    private String sqlAgentTopLeaderNetloadInfo;
    
    //法定代表人失信曝光台
    @Value("${sql.companyHisDao.getAgentTopLeaderCourtExposInfo}")
    private String sqlAgentTopLeaderCourtExposInfo;
    
    //阿里欠贷
    @Value("${sql.companyHisDao.getAgentAliloadBreakInfo}")
    private String sqlAgentAliloadBreakInfo;
    
    //核心经营
    @Value("${sql.companyHisDao.getMerchantTradeInfo}")
    private String sqlMerchantTradeInfo;
    
    //经营稳定性
    @Value("${sql.companyHisDao.getMerchantStabilityInfo}")
    private String sqlMerchantStabilityInfo;
    
    //资产负债
    @Value("${sql.companyHisDao.getBalanceSheetInfo}")
    private String sqlBalanceSheeteInfo;
    
    //利润
    @Value("${sql.companyHisDao.getProfitInfo}")
	private String sqlProfitInfo;
    
    //查询资产负债历史记录
    @Value("${sql.companyHisDao.getBalanceSheetHis}")
	private String sqlBalanceSheetHisInfo;
    
    //裁判文书查询 --历史
    @Value("${sql.companyHisDao.getJudgementDocmentHis}")
	private String sqlJudgemenHisInfo;
    
    //执行公告查询 --历史
    @Value("${sql.companyHisDao.getExecuteDocHis}")
	private String sqlExecuteDocHisInfo;
	
    //失信公告查询 --历史
    @Value("${sql.companyHisDao.getDishonourNoticHis}")
	private String sqlDishonourNoticHisInfo;
	
    //网贷黑名单查询 --历史
    @Value("${sql.companyHisDao.getNetloadHis}")
	private String sqlNetloadHisInfo;
	
    //曝光台查询 --历史
    @Value("${sql.companyHisDao.getCourtExposeHis}")
	private String sqlCourtExposeHisInfo;
    
    //法人在其他机构任职 
    @Value("${sql.companyHisDao.getLegPerNew}")
	private String sqlLegPerNewInfo;
    
    //法人投资信息
    @Value("${sql.companyHisDao.getLegPerQuity}")
	private String sqlLegPerQuityInfo;
    
    //法人任职信息--历史
    @Value("${sql.companyHisDao.getLegPerHis}")
	private String sqlLegPerInfoHis;
	
	//法人投资--历史
    @Value("${sql.companyHisDao.getLegPerQuityHis}")
	private String sqlLegPerQuityHis;
    
    //根据用户ID查询角色ID
    @Value("${sql.userDao.queryRoleByPerUserId}")
	private String sqlQueryRolePerUserId;
    
    //通过个人用户id获取菜单
    @Value("${sql.menudao.getMenuByPerUserId}")
	private String sqlGetMenuByPerUserId;
    
    //查询个人信息
    @Value("${sql.personDao.getPagePersons}")
	private String sqlGetPagePersons;
    
    //查询个人信息
    @Value("${sql.personDao.getPersonCount}")
	private String sqlPersonCount;
    
     //分页查询个人征信报告记录
    @Value("${sql.personSaveInfoDao.getPageReport}")
	private String sqlGetPersonPageReport;
    
    //根据个人征信报告模板编号查询一条记录
    @Value("${sql.personSaveInfoDao.getTempletById}")
    private String sqlGetPersonTempletById;
    
    //查询所有的征信报告模板信息
    @Value("${sql.personSaveInfoDao.getAllReportTemp}")
    private String sqlGetAllPersonReportTemp;
    
  //更新征信报告模板的使用状态
    @Value("${sql.personSaveInfoDao.updateTempletStatus}")
    private String sqlUpdatePersonTempletStatus;
    
  //获取一条征信报告模板内的各个显示模块名称
    @Value("${sql.personSaveInfoDao.getTempletDict}")
    private String sqlGetPersonTempletDict;
    
    //获取该企业当前征信报告编号的日期和尾部数字
    @Value("${sql.personSaveInfoDao.createMaxIndexReport}")
    private String sqlCreatePersonMaxIndexReport;
    
    //设置模板为不可用状态
    @Value("${sql.personReportTempletDao.setDisabled}")
    private String sqlSetPersonReportTempletDisabled;
    
    //分页查询征信报告模板记录
    @Value("${sql.personReportTempletDao.getPageTemplet}")
    private String sqlGetPagePersonReportTemplet;
    
    //查询驾驶证信息
    @Value("${sql.personDao.getDriverLicenseStatusInfo}")
	private String sqlDriverLicenseStatusInfo;
    
    //查询个人投资--失信被执行人
    @Value("${sql.personDao.getInvesPunishBreakInfo}")
	private String sqlInvesPunishBreakInfo;
 
    //查询个人投资--执行人
    @Value("${sql.personDao.getInvesPunishedInfo}")
	private String sqlInvesPunishedInfo;
    
    //查询个人投资--法定代表人
    @Value("${sql.personDao.getInvesRyposfrInfo}")
	private String sqlInvesRyposfrInfo;
    
    //查询个人投资--管理人员
    @Value("${sql.personDao.getInvesRyposperInfo}")
	private String sqlInvesRyposperInfo;
     
    //查询个人投资--企业股东
    @Value("${sql.personDao.getInvesRyposshaInfo}")
	private String sqlInvesRyposshaInfo;
    
    //查询个人司法--曝光台
    @Value("${sql.personDao.getRiskBgtInfo}")
	private String sqlRiskBgtInfo;
    
    //查询个人司法--裁判文书
    @Value("${sql.personDao.getRiskCpwsInfo}")
	private String sqlRiskCpwsInfo;
    
    //查询个人司法--失信公告
    @Value("${sql.personDao.getRiskDishonerInfo}")
	private String sqlRiskDishonerInfo;
    
    //查询个人司法--网贷黑名单
    @Value("${sql.personDao.getRiskNetloadInfo}")
	private String sqlRiskNetloadInfo;
    
    //查询个人司法--执行报告
    @Value("${sql.personDao.getRiskExecuteDocInfo}")
	private String sqlRiskExecuteDocInfo;
    
    //查询个人司法--阿里欠贷
    @Value("${sql.personDao.getInvestAlidebtInfo}")
	private String sqlInvestAlidebtInfo;
    
    //银联三要素信息
    @Value("${sql.personDao.getVerifyBankCardInfo}")
	private String sqlVerifyBankCardInfo;
    
    //查询个人消费--资产状况及交易行为
    @Value("${sql.personDao.getReportBasicInfo}")
	private String sqlReportBasic;
    
    //查询个人消费--消费大类分布
    @Value("${sql.personDao.getReportConsumeCategoryInfo}")
	private String sqlReportConsumeCategory;
    
    //查询个人消费--城市消费分布
    @Value("${sql.personDao.getReportConsumeCityInfo}")
	private String sqlReportConsumeCity;
    
    //查询个人消费--每月消费状况
    @Value("${sql.personDao.getReportMonthConsumeInfo}")
	private String sqlReportMonthConsumeInfo;
    
    //查询个人消费--消费行为
    @Value("${sql.personDao.getReportTransBehaviorInfo}")
	private String sqlReportTransBehaviorInfo;
    
    //查询个人消费--信用相关交易统计
    @Value("${sql.personDao.getReportTransCreditInfo}")
	private String sqlReportTransCrditInfo;
    
    //分页查询用户 sqlMapperID
    @Value("${sql.perUserdao.getPageUsers}")
	private String sqlGetPagePerUser;
    
    ////////////////////////////////////////////////////////////////////////////
    ///////SQLMapperID END
    ///////////////////////////////////////////////////////////////////////////
    
    public String getAlgorithmHost() {
        return algorithmHost;
    }
    public String getAlgorithmLROperationTrain() {
        return algorithmLROperationTrain;
    }
    public String getAlgorithmLROperationPredict() {
        return algorithmLROperationPredict;
    }
    public String getAlgorithmLRModelCode() {
        return algorithmLRModelCode;
    }
    
    public String getSqlQueryLevelIndicatorList() {
        return sqlQueryLevelIndicatorList;
    }
    public String getSqlQueryRoleByUserId() {
        return sqlQueryRoleByUserId;
    }
    public String getSqlGetOneCompany() {
        return sqlGetOneCompany;
    }
    public String getSqlGetPageCompanys() {
        return sqlGetPageCompanys;
    }
    public String getSqlCount() {
        return sqlCount;
    }
    public String getSqlFindAgentBygroupId() {
        return sqlFindAgentBygroupId;
    }
    
    public String getSqlGetPageUsers() {
        return sqlGetPageUsers;
    }
    public String getSqlDeleteUserRole() {
        return sqlDeleteUserRole;
    }
    public String getSqlDeleteRoleMenu() {
        return sqlDeleteRoleMenu;
    }
    public String getSqlGetPageRoles() {
        return sqlGetPageRoles;
    }
    public String getSqlGetPageDepts() {
        return sqlGetPageDepts;
    }
    public String getSqlGetPageScoreLevelVersions() {
        return sqlGetPageScoreLevelVersions;
    }
    public String getSqlGetScoreSumByVersion() {
        return sqlGetScoreSumByVersion;
    }
    public String getSqlGetScoreLevelEntityByScore() {
        return sqlGetScoreLevelEntityByScore;
    }
    public String getSqlGetPageScoreLevels() {
        return sqlGetPageScoreLevels;
    }
    public String getPageScoreModels() {
        return pageScoreModels;
    }
    public String getSqlGetScoreModelEntityByRegId() {
        return sqlGetScoreModelEntityByRegId;
    }
    public String getSqlGetTopManagerInfoHis() {
        return sqlGetTopManagerInfoHis;
    }
    public String getSqlGetOthEntInvestsInfoHis() {
        return sqlGetOthEntInvestsInfoHis;
    }
    public String getSqlGetBasicIndiScoreHis() {
        return sqlGetBasicIndiScoreHis;
    }
    public String getSqlGetTopManagerInfo() {
        return sqlGetTopManagerInfo;
    }
    public String getSqlGetOthEntInvestsInfo() {
        return sqlGetOthEntInvestsInfo;
    }
    public String getSqlGetEntAttrInfo() {
        return sqlGetEntAttrInfo;
    }
    public String getSqlGetSpecialInfo() {
        return sqlGetSpecialInfo;
    }
    public String getSqlGetLegPerInfo() {
        return sqlGetLegPerInfo;
    }
    public String getSqlGetStockholderInfo() {
        return sqlGetStockholderInfo;
    }
    public String getSqlGetEntAttrInfoHis() {
        return sqlGetEntAttrInfoHis;
    }
    public String getSqlGetSpecialInfoHis() {
        return sqlGetSpecialInfoHis;
    }
    public String getSqlGetLegPerInfoHis() {
        return sqlGetLegPerInfoHis;
    }
    public String getSqlGetStockholderInfoHis() {
        return sqlGetStockholderInfoHis;
    }
    public String getSqlGetCurTypeName() {
        return sqlGetCurTypeName;
    }
    public String getSqlGetPageReport() {
        return sqlGetPageReport;
    }
    public String getSqlGetAllReportTemp() {
        return sqlGetAllReportTemp;
    }
    public String getSqlGetTempletById() {
        return sqlGetTempletById;
    }
    public String getSqlUpdateTempletStatus() {
        return sqlUpdateTempletStatus;
    }
    public String getSqlGetTempletDict() {
        return sqlGetTempletDict;
    }
    public String getSqlCreateMaxIndexReport() {
        return sqlCreateMaxIndexReport;
    }
    public String getSqlGetPageReportTemplet() {
        return sqlGetPageReportTemplet;
    }
    public String getReportTitle() {
		return reportTitle;
	}
	public String getSqlQueryDictionary() {
        return sqlQueryDictionary;
    }
    public String getSqlQueryTables() {
        return sqlQueryTables;
    }
    public String getSqlGetCapitalGrowthList() {
        return sqlGetCapitalGrowthList;
    }
    public String getSqlGetGrossProfit() {
        return sqlGetGrossProfit;
    }
    public String getSqlGetRetirementTicketMonth() {
        return sqlGetRetirementTicketMonth;
    }
    public String getSqlGetRetirementTicketDay() {
        return sqlGetRetirementTicketDay;
    }
    public String getSqlGetIndicatorScoreList() {
        return sqlGetIndicatorScoreList;
    }
    public String getSqlGetIndicatorScoreListByAttr() {
        return sqlGetIndicatorScoreListByAttr;
    }
    public String getSqlGetIndicatorScoreListLevel2ByAttr() {
        return sqlGetIndicatorScoreListLevel2ByAttr;
    }
    public String getSqlGetIndicatorScoreListLevel1ByAttr() {
        return sqlGetIndicatorScoreListLevel1ByAttr;
    }
    public String getSqlGetIndicatorScoreByTotal() {
        return sqlGetIndicatorScoreByTotal;
    }
    public String getSqlGetIndicatorScoreListByLevel2() {
        return sqlGetIndicatorScoreListByLevel2;
    }
    public String getSqlGetIndicatorScoreListByLevel1() {
        return sqlGetIndicatorScoreListByLevel1;
    }
    public String getSqlGetIndicatorAttrList() {
        return sqlGetIndicatorAttrList;
    }
    public String getSqlGetCreditScore() {
        return sqlGetCreditScore;
    }
    public String getSqlGetPageIndicators() {
        return sqlGetPageIndicators;
    }
    public String getSqlQueryLevelIndicatorListByLevel() {
        return sqlQueryLevelIndicatorListByLevel;
    }
    public String getSqlGetAllEntityListByType() {
        return sqlGetAllEntityListByType;
    }
    public String getSqlGetMenuByRoleId() {
        return sqlGetMenuByRoleId;
    }
    public String getSqlGetMenuByUserId() {
        return sqlGetMenuByUserId;
    }
    
    
    public String getSqlAgentChangeInfo()
    {
    	return sqlAgentChangeInfo;
    }
    
	public String getSqlAgentFiliationInfo() {
		return sqlAgentFiliationInfo;
	}
	public String getSqlAgentLiquidationInfo() {
		return sqlAgentLiquidationInfo;
	}
	public String getSqlAgentMortgageInfo() {
		return sqlAgentMortgageInfo;
	}
	
	public String getSqlMortgageItemInfo()
	{
		return sqlMortgageItemInfo;
	}
	
	public String getSqlAgentSharesInfo() 
	{
		return sqlAgentSharesInfo;
	}
	public String getSqlAgentSharesImpawInfo() 
	{
		return sqlAgentSharesImpawInfo;
	}
	public String getSqlAgentJudgementDocInfo() {
		return sqlAgentJudgementDocInfo;
	}
	public String getSqlAgentCoutEnforceInfo() {
		return sqlAgentCoutEnforceInfo;
	}
	public String getSqlAgentTopLeaderExdocInfo() {
		return sqlAgentTopLeaderExdocInfo;
	}
	public String getSqlAgentTopLeaderDishonourInfo() {
		return sqlAgentTopLeaderDishourInfo;
	}
	public String getSqlAgentTopLeaderNetloadInfo() {
		return sqlAgentTopLeaderNetloadInfo;
	}
	
	public String getSqlAgentTopLeaderCourtExposInfo() {
		return sqlAgentTopLeaderCourtExposInfo;
	}
	public String getSqlAgentAliloadBreakInfo() {
		return sqlAgentAliloadBreakInfo;
	}
	public String getSqlMerchantTradeInfo() {
		return sqlMerchantTradeInfo;
	}
	public String getSqlMerchantStabilityInfo() {
		return sqlMerchantStabilityInfo;
	}
	public String getSqlAgentTaxAccountInfo() {
		return sqlAgentTaxAccoutInfo;
	}
	public String getSqlMerchantReportChangeInfo() {
		return sqlMerchantReportChangeInfo;
	}
	
	public String getSqlMerchantReportConstrastInfo() {
		return sqlMerchantReportConstrastInfo;
	}
	
	public String getSqlMerchantReportAreaInfo() {
		return sqlMerchantReportAreaInfo;
	}
	
	public String getMerchantReportLoyalInfo() {
		return sqlMerchantReportLoyalInfo;
	}
	public String getAgentTopleaderJudgmentDocInfo() {
		return sqlAgentTopLeaderJudgmentDocInfo;
	}
	public String getMerchantTradeAbomalInfo() {
		return sqlMerchantTrandeAbormalInfo;
	}
	public String getBalanceSheetInfo() {
		return sqlBalanceSheeteInfo;
	}
	public String getProfitInfo() {
		return sqlProfitInfo;
	}
	public String getBalanceSheetInfoHis() {
		return sqlBalanceSheetHisInfo;
	}
	
	//Report查询
	public String getJudgementDocHisInfo() {
		return sqlJudgemenHisInfo;
	}
	public String getExecuteDocHisInfo() {
		return sqlExecuteDocHisInfo;
	}
	public String getDishonourNoticeHisInfo() {
		return sqlDishonourNoticHisInfo;
	}
	public String getNetloadHisInfo() {
		return sqlNetloadHisInfo;
	}
	public String getCourtExposureHisInfo() {
		return sqlCourtExposeHisInfo;
	}
	public String getSqlLegPerNewInfo() {
		return sqlLegPerNewInfo;
	}
	
	public String getLegPerQuityInfo() {
		return sqlLegPerQuityInfo;
	}
	public String getLegPerHisInfo() {
		return sqlLegPerInfoHis;
	}
	public String getLegPerQuityHisInfo() {
		return sqlLegPerQuityHis;
	}
	
	public String getSqlQueryRoleByPerUserId() {
		return sqlQueryRolePerUserId;
	}
	
	public String getSqlGetMenuByPerUserId() {
		return sqlGetMenuByPerUserId;
	}
	public String getSqlGetPagePersons() {
		return sqlGetPagePersons;
	}
	public String getSqlPersonCount() {
		return sqlPersonCount;
	}
	public String getSqlGetPersonPageReport() {
		return sqlGetPersonPageReport;
	}
	public String getSqlGetPersonTempletById() {
		return sqlGetPersonTempletById;
	}
	public String getSqlGetAllPersonReportTemp() {
		return sqlGetAllPersonReportTemp;
	}
	public String getSqlUpdatePersonTempletStatus() {
		return sqlUpdatePersonTempletStatus;
	}
	public String getSqlGetPersonTempletDict() {
		return sqlGetPersonTempletDict;
	}
	public String getSqlCreatePersonMaxIndexReport() {
		return sqlCreatePersonMaxIndexReport;
	}
	public String getSqlSetPersonReportTempletDisabled() {
		return sqlSetPersonReportTempletDisabled;
	}
	public String getSqlGetPersonPageReportTemplet() {
		return sqlGetPagePersonReportTemplet;
	}
	public String getDriverLicenseStatusInfo() {
		return sqlDriverLicenseStatusInfo;
	}
	public String getInvesPunishBreakInfo() {
		return sqlInvesPunishBreakInfo;
	}
	public String getInvesPunishedInfo() {
		return sqlInvesPunishedInfo;
	}
	public String getInvesRyposfrInfo() {
		return sqlInvesRyposfrInfo;
	}
	public String getInvesRyposperInfo() {
		return sqlInvesRyposperInfo;
	}
	public String getInvesRyposshaInfo() {
		return sqlInvesRyposshaInfo;
	}
	public String getRiskBgtInfo() {
		return sqlRiskBgtInfo;
	}
	public String getRiskCpwsInfo() {
		return sqlRiskCpwsInfo;
	}
	public String getRiskDishonerInfo() {
		return sqlRiskDishonerInfo;
	}
	public String getRiskNetloadInfo() {
		return sqlRiskNetloadInfo;
	}
	public String getRiskExecuteDocInfo() {
		return sqlRiskExecuteDocInfo;
	}
	public String getInvestAlidebtInfo() {
		return sqlInvestAlidebtInfo;
	}
	public String getReportBasicInfo() {
		return sqlReportBasic;
	}
	public String getReportConsumeCategoryInfo() {
		return sqlReportConsumeCategory;
	}
	public String getReportConsumeCityInfo() {
		return sqlReportConsumeCity;
	}
	public String getVerifyBankCardInfo() {
		return sqlVerifyBankCardInfo;
	}
	public String getReportMonthConsumeInfo() {
		return sqlReportMonthConsumeInfo;
	}
	public String getReportTransBehaviorInfo() {
		return sqlReportTransBehaviorInfo;
	}
	public String getReportTransCreditInfo() {
		return sqlReportTransCrditInfo;
	}
	public String getAddAgentWebserviceAddr()
	{
		return addAgentWebserviceAddr;
	}
	public String updateAgentWebserviceAddr()
	{
		return upadeAgentWebserviceAddr;
	}
	public String getAddPersonServiceAdd()
	{
		return addPersonWebserviceAddr;
	}
	public String getUpdatePersonServiceAddr()
	{
		return updatePersonWebserviceAddr;
	}
	public String getFtpIp() {
		return ftpIp;
	}
	public Integer getFtpPort() {
		return ftpPort;
	}
	public String getFtpUserName() {
		return ftpUserName;
	}
	public String getFtpUserPassword() {
		return ftpUserPassword;
	}
	public String getSqlGetPagePerUser() {
		return sqlGetPagePerUser;
	}
    public String getSqlDeleteCompScore() {
        return sqlDeleteCompScore;
    }
	
}

