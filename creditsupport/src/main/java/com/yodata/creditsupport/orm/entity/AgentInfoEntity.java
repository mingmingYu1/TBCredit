package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name ="ods_agent_info", catalog="credit_db")
public class AgentInfoEntity implements Serializable{
    
    /**
     * 序列化编号
     */
    private static final long serialVersionUID = 3819131562025603365L;
    
    private String regId;              //工商注册号, 主键
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
    
    
    private Date createTime;        //创建时间，录入时间
    private Date updateTime;        //更新时间
    
    private Double indScore;        //最后一次得分
    private String algorCode;       //算法编码
    private String algorName;       //算法名称
    private String curTypeName;     //货币种类中文名称
    private String regAssetsStr;	//注册资本千分位
    
    private String industryCode;    //行业门类代码
    private String originalRegId;   //原注册号
    private Date annualSurveyTime;  //发照年检日期
    private Date operatingStartTime; //营业有效开始日期
    private Date operatingEndTime;   //营业有效结束日期
    private String industryName;     //行业分类名称
	 
	@Id
    @Column(name="reg_id", nullable = false)
    public String getRegId() {
        return regId;
    }
    public void setRegId(String regId) {
        this.regId = regId;
    }
    
	private List<EntAttrInfoEntity> entAttrInfos = new ArrayList<EntAttrInfoEntity>();//地址信息
    private List<StockholderInfoEntity> stockholderInfos = new ArrayList<StockholderInfoEntity>();//股东信息
    private List<TopManagerInfoEntity> topManagerInfos = new ArrayList<TopManagerInfoEntity>();//高管信息
    private List<OthEntInvestsInfoEntity> othEntInvestsInfos = new ArrayList<OthEntInvestsInfoEntity>();//对外股权投资信息
    private List<LegPerInfoEntity> legPerInfos1 = new ArrayList<LegPerInfoEntity>();//法定代表人在其他机构任职信息:type=0
    private List<LegPerInfoEntity> legPerInfos2 = new ArrayList<LegPerInfoEntity>();//法定代表人股权投资信息:type=1
    private List<SpecialInfoEntity> specialInfos = new ArrayList<SpecialInfoEntity>();//法院被执行信息
    
    private List<AgentChangeEntity> changeInfos = new ArrayList<AgentChangeEntity>();//企业变更信息
//    
//    private List<AgentFiliationEntity> filiationInfos = new ArrayList<AgentFiliationEntity>();//分支机构信息
//    private List<AgentLiquidationEntity> liquidationInfos = new ArrayList<AgentLiquidationEntity>();//股票冻结信息
//    private List<AgentMortgageEntity> mortgageInfos = new ArrayList<AgentMortgageEntity>();//动产抵押信息
//    private List<AgentSharesFroEntity> sharesForInfos = new ArrayList<AgentSharesFroEntity>();//股票冻结信息
//    private List<AgentSharesImpawnEntity> sharesImpawnInfos = new ArrayList<AgentSharesImpawnEntity>();//股票冻结信息

    @OneToMany(mappedBy = "regId",targetEntity=EntAttrInfoEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.ALL})//缺这个注解将不保存oneToMany的many方
    public List<EntAttrInfoEntity> getEntAttrInfos() {
    	return entAttrInfos;
    }
    public void setEntAttrInfos(List<EntAttrInfoEntity> entAttrInfos) {
    	this.entAttrInfos = entAttrInfos;
    }
    @OneToMany(mappedBy = "regId",targetEntity=StockholderInfoEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.ALL})//缺这个注解将不保存oneToMany的many方
    public List<StockholderInfoEntity> getStockholderInfos() {
		return stockholderInfos;
	}
	public void setStockholderInfos(List<StockholderInfoEntity> stockholderInfos) {
		this.stockholderInfos = stockholderInfos;
	}
	@OneToMany(mappedBy = "regId",targetEntity=TopManagerInfoEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.ALL})//缺这个注解将不保存oneToMany的many方
	public List<TopManagerInfoEntity> getTopManagerInfos() {
		return topManagerInfos;
	}
	public void setTopManagerInfos(List<TopManagerInfoEntity> topManagerInfos) {
		this.topManagerInfos = topManagerInfos;
	}
	@OneToMany(mappedBy = "regId",targetEntity=OthEntInvestsInfoEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.ALL})//缺这个注解将不保存oneToMany的many方
	public List<OthEntInvestsInfoEntity> getOthEntInvestsInfos() {
		return othEntInvestsInfos;
	}
	public void setOthEntInvestsInfos(List<OthEntInvestsInfoEntity> othEntInvestsInfos) {
		this.othEntInvestsInfos = othEntInvestsInfos;
	}
	@OneToMany(mappedBy = "regId",targetEntity=LegPerInfoEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.ALL})//缺这个注解将不保存oneToMany的many方
	public List<LegPerInfoEntity> getLegPerInfos1() {
		return legPerInfos1;
	}
	public void setLegPerInfos1(List<LegPerInfoEntity> legPerInfos1) {
		this.legPerInfos1 = legPerInfos1;
	}
	@OneToMany(mappedBy = "regId",targetEntity=LegPerInfoEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.ALL})//缺这个注解将不保存oneToMany的many方
	public List<LegPerInfoEntity> getLegPerInfos2() {
		return legPerInfos2;
	}
	public void setLegPerInfos2(List<LegPerInfoEntity> legPerInfos2) {
		this.legPerInfos2 = legPerInfos2;
	}
	@OneToMany(mappedBy = "regId",targetEntity=SpecialInfoEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.ALL})//缺这个注解将不保存oneToMany的many方
	public List<SpecialInfoEntity> getSpecialInfos() {
		return specialInfos;
	}
	public void setSpecialInfos(List<SpecialInfoEntity> specialInfos) {
		this.specialInfos = specialInfos;
	}
	
   @OneToMany(mappedBy = "regId",targetEntity=AgentChangeEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.ALL})//缺这个注解将不保存oneToMany的many方
	public List<AgentChangeEntity> getChangeInfos() {
		return changeInfos;
	}
	public void setChangeInfos(List<AgentChangeEntity> changeInfos) {
		this.changeInfos = changeInfos;
	}
	/**
    @OneToMany(mappedBy = "regId",targetEntity=AgentFiliationEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.ALL})//缺这个注解将不保存oneToMany的many方
	public List<AgentFiliationEntity> getFiliationInfos() {
		return filiationInfos;
	}
	public void setFiliationInfos(List<AgentFiliationEntity> filiationInfos) {
		this.filiationInfos = filiationInfos;
	}
	
    @OneToMany(mappedBy = "regId",targetEntity=AgentLiquidationEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.ALL})//缺这个注解将不保存oneToMany的many方
	public List<AgentLiquidationEntity> getLiquidationInfos() {
		return liquidationInfos;
	}
	public void setLiquidationInfos(List<AgentLiquidationEntity> liquidationInfos) {
		this.liquidationInfos = liquidationInfos;
	}
	
    @OneToMany(mappedBy = "regId",targetEntity=AgentMortgageEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.ALL})//缺这个注解将不保存oneToMany的many方
    public List<AgentMortgageEntity> getMortgageInfos() {
		return mortgageInfos;
	}
	public void setMortgageInfos(List<AgentMortgageEntity> mortgageInfos) {
		this.mortgageInfos = mortgageInfos;
	}
	
    @OneToMany(mappedBy = "regId",targetEntity=AgentSharesFroEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.ALL})//缺这个注解将不保存oneToMany的many方
    public List<AgentSharesFroEntity> getSharesForInfos() {
		return sharesForInfos;
	}
	public void setSharesForInfos(List<AgentSharesFroEntity> sharesForInfos) {
		this.sharesForInfos = sharesForInfos;
	}
	
    @OneToMany(mappedBy = "regId",targetEntity=AgentSharesImpawnEntity.class,fetch=FetchType.LAZY)
    @Cascade({CascadeType.ALL})//缺这个注解将不保存oneToMany的many方
    public List<AgentSharesImpawnEntity> getSharesImpawnInfos() {
		return sharesImpawnInfos;
	}
	public void setSharesImpawnInfos(List<AgentSharesImpawnEntity> sharesImpawnInfos) {
		this.sharesImpawnInfos = sharesImpawnInfos;
	}*/
	
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
        if(StringUtils.isNotEmpty(this.opePeriod) 
                && (this.opePeriod.contains("T") && this.opePeriod.contains("+"))){
            this.opePeriod = this.opePeriod.substring(0, this.opePeriod.indexOf("T"));
        }
        return this.opePeriod;
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
    
    @Column(name="create_time")
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Column(name="update_time")
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    @Transient
    public Double getIndScore() {
        return indScore;
    }
    public void setIndScore(Double indScore) {
        this.indScore = indScore;
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
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((regId == null) ? 0 : regId.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AgentInfoEntity other = (AgentInfoEntity) obj;
        if (regId == null) {
            if (other.regId != null)
                return false;
        } else if (!regId.equals(other.regId))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "AgentInfoEntity [compName=" + compName + ", lperName=" + lperName + ", status=" + status
                + ", regAssets=" + regAssets + ", openDate=" + openDate + ", curType=" + curType + ", opePeriod="
                + opePeriod + ", orgCode=" + orgCode + ", validDate=" + validDate + ", regId=" + regId + ", lastYear="
                + lastYear + ", lastDate=" + lastDate + ", cancelledDate=" + cancelledDate + ", revokDate=" + revokDate
                + ", typeEnt=" + typeEnt + ", typeOrg=" + typeOrg + ", emps=" + emps + ", licPro=" + licPro
                + ", licGen=" + licGen + ", webSite=" + webSite + ", regAuth=" + regAuth + ", industry=" + industry
                + ", speMark=" + speMark + ", busCope=" + busCope + ", saleType=" + saleType + ", busArea=" + busArea
                + ", busStab=" + busStab + ", age=" + age + ", addr=" + addr + ", degree=" + degree + ", marSta="
                + marSta + ", busTraIndustry=" + busTraIndustry + ", coopSinc=" + coopSinc + ", localTime=" + localTime
                + ", houseErea=" + houseErea + ", ownHouseValue=" + ownHouseValue + ", ownCars=" + ownCars + "]";
    }           //家庭拥有车辆情况(自然人)
}