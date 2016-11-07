package com.yodata.creditsupport.orm.person.entity.report;

import java.io.Serializable;
import java.sql.Timestamp;
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

/**
 * 
* @Description: 个人信息Report表
* @author Jason
* @date 2016年7月13日 下午5:58:04
*
 */
@Entity
@Table(name ="ods_person_info_report", catalog="credit_db")
public class OdsPersonInfoReportEntity implements Serializable{

	private static final long serialVersionUID = 6498756894114526733L;

	   private Integer id;                //主键
	   private Date createTime;		   //生成时间
	   private String fileNo;			   //文件编号
		// ============身份证号 =================
		private String cardId;

		// ============姓名 =================
		private String name;

		// ============性别 =================
		private String sex;

		// ============地址 =================
		private String address;
		
	// ============手机号 =================
	private String phone;

	// ============手机号认证结果 =================
	private String phoneStatus;

	// ============手机号认证详细信息 =================
	private String phoneMessage;

	// ============认证结果 =================
	private String compStatus;

	// ============认证详细信息 =================
	private String compResult;

	// ============银行卡号 =================
	private String accountNo;

	// ============银行卡认证结果 =================
	private String accountResult;

	// ============银行卡认证详细结果 =================
	private String accountMessage;
		
		// ============ 录入时间=================
		private Date addtime;
		// ============更新时间 =================
	    private Timestamp modTime;
	    
	    private Double indScore;        //最后一次得分
	    private String algorCode;       //算法编码
	    private String algorName;       //算法名称
	    
	   // ======================= 保存历史数据的计算结果，为了方便查询和避免不必要的再计算
	    private String level;			// 评分等级
	    private Integer score;			// 得分
	    private String levelDesc;		// 等级描述
		
	    private String score1;			// 
	    private String score2;			// 
	    private String score1Per;		// 
	    private String score2Per;		// 
	    private String score1Weight;	// 
	    private String score2Weight;	// 
	    
	    private List<OdsPersonDriverlicensestatusReportEntity> driverList = new ArrayList<>(); //驾驶证信息
	    private List<OdsPersonInvestPunishbreakReportEntity> investPunishBreakList = new ArrayList<>();//失信被执行人信息
	    private List<OdsPersonInvestPunishedReportEntity> investPunishedList = new ArrayList<>();//被执行人信息
	    private List<OdsPersonInvestRyposfrReportEntity> investRyposfrList = new ArrayList<>();//企业法定代表人
	    private List<OdsPersonInvestRyposperReportEntity> investRyposperList = new ArrayList<>();//管理人员
	    private List<OdsPersonInvestRyposshaReportEntity> investRyposshaList = new ArrayList<>();//企业股东
	    private List<OdsPersonRiskBgtReportEntity> riskBgtList = new ArrayList<>();//曝光台
	    private List<OdsPersonRiskCpwsReportEntity> riskCpwsList = new ArrayList<>();//裁判文书
	    private List<OdsPersonRiskShixinReportEntity> riskDishonerList = new ArrayList<>();//失信公告
	    private List<OdsPersonRiskWdhmdReportEntity> riskNetloadList = new ArrayList<>();//网贷黑名单
	    private List<OdsPersonRiskZxggReportEntity> riskExecuteDocList = new ArrayList<>();//执行公告
	    private List<OdsPersonInvestAlidebtReportEntity>  investAlidebtList = new ArrayList<>();//阿里欠贷
	    private List<OdsPersonVerifybankcardby3eleReportEntity>  vrifyBankCardList = new ArrayList<>();//银联三要素验证
	    private List<OdsPersonReportBasicReportEntity>  reportBasicList = new ArrayList<>();//资产状况及交易行为
	    private List<OdsPersonReportConsumecategoriesReportEntity>  reportConsumeCategoryList = new ArrayList<>();//消费大类分布
	    private List<OdsPersonReportConsumecitiesReportEntity>  reportConsumeCityList = new ArrayList<>();//城市消费状况
	    private List<OdsPersonReportMonthconsumesReportEntity>  reportMonthComsumeList = new ArrayList<>();//每月消费状况
	    private List<OdsPersonReportTransbehaviorReportEntity>  reportConsumeBehaviorList = new ArrayList<>();//消费行为
	    private List<OdsPersonReportTranscreditsReportEntity>  reportTransCreditList = new ArrayList<>();//信用相关交易统计
	    
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id", nullable = false)
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		
		@Column(name="CREATE_TIME")
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		
		@Column(name="FILE_NO")
		public String getFileNo() {
			return fileNo;
		}
		public void setFileNo(String fileNo) {
			this.fileNo = fileNo;
		}
		// ============身份证号 =================
		@Column(name="card_id", nullable = false)
		public String getCardId()
		{
			return this.cardId;
		}
		public void setCardId(String cardId)
		{
			this.cardId = cardId;
		}

		// ============姓名 =================
		@Column(name="name")
		public String getName()
		{
			return this.name;
		}
		public void setName(String name)
		{
			this.name = name;
		}

		// ============性别 =================
		@Column(name="sex")
		public String getSex()
		{
			return this.sex;
		}
		public void setSex(String sex)
		{
			this.sex = sex;
		}

		// ============地址 =================
		@Column(name="address")
		public String getAddress()
		{
			return this.address;
		}

		public void setAddress(String address)
		{
			this.address = address;
		}

		@Column(name="add_time")
		public Date getAddtime()
		{
			return this.addtime;
		}
		public void setAddtime(Date addtime)
		{
			this.addtime = addtime;
		}

		@Column(name="mod_time")
		public Timestamp getModTime() {
			return modTime;
		}
		public void setModTime(Timestamp modTime) {
			this.modTime = modTime;
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
	    
	    @Transient
	    public String getAlgorCode() {
	        return algorCode;
	    }
	    public void setAlgorCode(String algorCode) {
	        this.algorCode = algorCode;
	    }
	    
	    @Transient
	    public String getAlgorName() {
	        return algorName;
	    }
	    public void setAlgorName(String algorName) {
	        this.algorName = algorName;
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
		
		@Transient
		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		@Transient
		public String getPhoneStatus() {
			return phoneStatus;
		}

		public void setPhoneStatus(String phoneStatus) {
			this.phoneStatus = phoneStatus;
		}

		@Transient
		public String getPhoneMessage() {
			return phoneMessage;
		}

		public void setPhoneMessage(String phoneMessage) {
			this.phoneMessage = phoneMessage;
		}

		@Column(name="compstatus")
		public String getCompStatus() {
			return compStatus;
		}

		public void setCompStatus(String compStatus) {
			this.compStatus = compStatus;
		}

		@Column(name="compresult")
		public String getCompResult() {
			return compResult;
		}

		public void setCompResult(String compResult) {
			this.compResult = compResult;
		}

		@Transient
		public String getAccountNo() {
			return accountNo;
		}

		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}

		@Transient
		public String getAccountResult() {
			return accountResult;
		}

		public void setAccountResult(String accountResult) {
			this.accountResult = accountResult;
		}

		@Transient
		public String getAccountMessage() {
			return accountMessage;
		}
		public void setAccountMessage(String accountMessage) {
			this.accountMessage = accountMessage;
		}
		
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonDriverlicensestatusReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonDriverlicensestatusReportEntity> getDriverList() 
		{
			return driverList;
		}
		public void setDriverList(List<OdsPersonDriverlicensestatusReportEntity> driverList)
		{
			this.driverList = driverList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonInvestPunishbreakReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})//缺这个注解将不保存oneToMany的many方
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonInvestPunishbreakReportEntity> getInvestPunishBreakList() 
		{
			return investPunishBreakList;
		}
		public void setInvestPunishBreakList(List<OdsPersonInvestPunishbreakReportEntity> investPunishBreakList)
		{
			this.investPunishBreakList = investPunishBreakList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonInvestPunishedReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonInvestPunishedReportEntity> getInvestPunishedList() {
			return investPunishedList;
		}
		public void setInvestPunishedList(List<OdsPersonInvestPunishedReportEntity> investPunishedList) {
			this.investPunishedList = investPunishedList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonInvestRyposfrReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonInvestRyposfrReportEntity> getInvestRyposfrList() {
			return investRyposfrList;
		}
		public void setInvestRyposfrList(List<OdsPersonInvestRyposfrReportEntity> investRyposfrList) {
			this.investRyposfrList = investRyposfrList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonInvestRyposperReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonInvestRyposperReportEntity> getInvestRyposperList() {
			return investRyposperList;
		}
		public void setInvestRyposperList(List<OdsPersonInvestRyposperReportEntity> investRyposperList) {
			this.investRyposperList = investRyposperList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonInvestRyposshaReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonInvestRyposshaReportEntity> getInvestRyposshaList() {
			return investRyposshaList;
		}
		public void setInvestRyposshaList(List<OdsPersonInvestRyposshaReportEntity> investRyposshaList) {
			this.investRyposshaList = investRyposshaList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonRiskBgtReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonRiskBgtReportEntity> getRiskBgtList() {
			return riskBgtList;
		}
		public void setRiskBgtList(List<OdsPersonRiskBgtReportEntity> riskBgtList) {
			this.riskBgtList = riskBgtList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonRiskCpwsReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonRiskCpwsReportEntity> getRiskCpwsList() {
			return riskCpwsList;
		}
		public void setRiskCpwsList(List<OdsPersonRiskCpwsReportEntity> riskCpwsList) {
			this.riskCpwsList = riskCpwsList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonRiskShixinReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonRiskShixinReportEntity> getRiskDishonerList() {
			return riskDishonerList;
		}
		public void setRiskDishonerList(List<OdsPersonRiskShixinReportEntity> riskDishonerList) {
			this.riskDishonerList = riskDishonerList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonRiskWdhmdReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonRiskWdhmdReportEntity> getRiskNetloadList() {
			return riskNetloadList;
		}
		public void setRiskNetloadList(List<OdsPersonRiskWdhmdReportEntity> riskNetloadList) {
			this.riskNetloadList = riskNetloadList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonRiskZxggReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonRiskZxggReportEntity> getRiskExecuteDocList() {
			return riskExecuteDocList;
		}
		public void setRiskExecuteDocList(List<OdsPersonRiskZxggReportEntity> riskExecuteDocList) {
			this.riskExecuteDocList = riskExecuteDocList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonInvestAlidebtReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonInvestAlidebtReportEntity> getInvestAlidebtList() {
			return investAlidebtList;
		}
		public void setInvestAlidebtList(List<OdsPersonInvestAlidebtReportEntity> investAlidebtList) {
			this.investAlidebtList = investAlidebtList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonVerifybankcardby3eleReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonVerifybankcardby3eleReportEntity> getVrifyBankCardList() {
			return vrifyBankCardList;
		}
		public void setVrifyBankCardList(List<OdsPersonVerifybankcardby3eleReportEntity> vrifyBankCardList) {
			this.vrifyBankCardList = vrifyBankCardList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonReportBasicReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonReportBasicReportEntity> getReportBasicList() {
			return reportBasicList;
		}
		public void setReportBasicList(List<OdsPersonReportBasicReportEntity> reportBasicList) {
			this.reportBasicList = reportBasicList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonReportConsumecategoriesReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonReportConsumecategoriesReportEntity> getReportConsumeCategoryList() {
			return reportConsumeCategoryList;
		}
		public void setReportConsumeCategoryList(List<OdsPersonReportConsumecategoriesReportEntity> reportConsumeCategoryList) {
			this.reportConsumeCategoryList = reportConsumeCategoryList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonReportConsumecitiesReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonReportConsumecitiesReportEntity> getReportConsumeCityList() {
			return reportConsumeCityList;
		}
		public void setReportConsumeCityList(List<OdsPersonReportConsumecitiesReportEntity> reportConsumeCityList) {
			this.reportConsumeCityList = reportConsumeCityList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonReportMonthconsumesReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonReportMonthconsumesReportEntity> getReportMonthComsumeList() {
			return reportMonthComsumeList;
		}
		public void setReportMonthComsumeList(List<OdsPersonReportMonthconsumesReportEntity> reportMonthComsumeList) {
			this.reportMonthComsumeList = reportMonthComsumeList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonReportTransbehaviorReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonReportTransbehaviorReportEntity> getReportConsumeBehaviorList() {
			return reportConsumeBehaviorList;
		}
		public void setReportConsumeBehaviorList(List<OdsPersonReportTransbehaviorReportEntity> reportConsumeBehaviorList) {
			this.reportConsumeBehaviorList = reportConsumeBehaviorList;
		}
		
		@OneToMany(mappedBy = "fileNo",targetEntity=OdsPersonReportTranscreditsReportEntity.class,fetch=FetchType.LAZY)//
	    @Cascade({CascadeType.SAVE_UPDATE})
		@Fetch(FetchMode.SELECT)
		public List<OdsPersonReportTranscreditsReportEntity> getReportTransCreditList() {
			return reportTransCreditList;
		}
		public void setReportTransCreditList(List<OdsPersonReportTranscreditsReportEntity> reportTransCreditList) {
			this.reportTransCreditList = reportTransCreditList;
		}
		
		
}
