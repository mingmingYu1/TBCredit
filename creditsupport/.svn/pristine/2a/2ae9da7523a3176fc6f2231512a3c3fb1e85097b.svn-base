package com.yodata.creditsupport.orm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ods_dim_indicator", catalog = "credit_db")
public class IndicatorEntity implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -2105473271409226914L;

	private Integer id;            //自增主键
	private String indicator;      //指标
	private String indCode;        //指标编号
	private String indName;        //指标名称
	private String indAttr;        //指标属性编号100004
	private String indAttrValue;   //指标属性值
	private String indTarget;      //对象编号100003
	private String indTargetValue; //对象的值
	private Double weight;         //权重
	private String calCycle;       //计算周期编号100002
	private String calCycleValue;  //计算周期值
	private String indDesc;        //指标描述
	private String calaRegu;       //计算规则
	private Integer stat;          //定性/量,定性0，定量1
	@SuppressWarnings("unused")
    private String statValue;      //定性/量
	private String unit;           //单位
	private Integer sign;          //正负
	private Date startDate;        //生效日期
	private Date endDate;          //失效日期
	private Integer ifEval;        //是否评分
	private Integer available;     //是否可用
	private String detailURL;      //详情链接
	private Integer sort;          //排序
	private String level1;         //层次1
	private String level2;         //层次2
	private String level3;         //层次3
	private String level4;         //层次4
	private String level5;         //层次5
	private String level6;         //层次6
	private String level7;         //层次7
	private String createUser;     //创建人
	private Date createTime;     //创建时间
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="indicator")
    public String getIndicator() {
        return indicator;
    }
    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    @Column(name="ind_code")
    public String getIndCode() {
        return indCode;
    }
    public void setIndCode(String indCode) {
        this.indCode = indCode;
    }

    @Column(name="ind_name", nullable = false)
    public String getIndName() {
        return indName;
    }
    public void setIndName(String indName) {
        this.indName = indName;
    }

    @Column(name="ind_attr")
    public String getIndAttr() {
        return indAttr;
    }
    public void setIndAttr(String indAttr) {
        this.indAttr = indAttr;
    }

    @Transient
    public String getIndAttrValue() {
        return indAttrValue;
    }
    public void setIndAttrValue(String indAttrValue) {
        this.indAttrValue = indAttrValue;
    }
    
    @Column(name="ind_target")
    public String getIndTarget() {
        return indTarget;
    }
    public void setIndTarget(String indTarget) {
        this.indTarget = indTarget;
    }
    
    @Transient
    public String getIndTargetValue() {
        return indTargetValue;
    }
    public void setIndTargetValue(String indTargetValue) {
        this.indTargetValue = indTargetValue;
    }
    @Column(name="weight")
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Column(name="cal_cycle")
    public String getCalCycle() {
        return calCycle;
    }
    public void setCalCycle(String calCycle) {
        this.calCycle = calCycle;
    }

    @Column(name="ind_desc")
    public String getIndDesc() {
        return indDesc;
    }
    public void setIndDesc(String indDesc) {
        this.indDesc = indDesc;
    }

    @Column(name="cala_regu")
    public String getCalaRegu() {
        return calaRegu;
    }
    public void setCalaRegu(String calaRegu) {
        this.calaRegu = calaRegu;
    }

    @Transient
    public String getCalCycleValue() {
        return calCycleValue;
    }
    public void setCalCycleValue(String calCycleValue) {
        this.calCycleValue = calCycleValue;
    }
    @Column(name="stat")
    public Integer getStat() {
        return stat;
    }
    public void setStat(Integer stat) {
        this.stat = stat;
    }

    @Transient
    public String getStatValue() {
        return this.stat == null ? "" : this.stat == 0 ? "定性" : "定量";
    }
    public void setStatValue(String statValue) {
        this.statValue = statValue;
    }
    @Column(name="unit")
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Column(name="sign")
    public Integer getSign() {
        return sign;
    }
    public void setSign(Integer sign) {
        this.sign = sign;
    }

    @Column(name="start_date")
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name="end_date")
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name="if_eval")
    public Integer getIfEval() {
        return ifEval;
    }
    public void setIfEval(Integer ifEval) {
        this.ifEval = ifEval;
    }

    @Column(name="available")
    public Integer getAvailable() {
        return available;
    }
    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Column(name="detail_url")
    public String getDetailURL() {
        return detailURL;
    }
    public void setDetailURL(String detailURL) {
        this.detailURL = detailURL;
    }

    @Column(name="sort")
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Column(name="level1")
    public String getLevel1() {
        return level1;
    }
    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    @Column(name="level2")
    public String getLevel2() {
        return level2;
    }
    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    @Column(name="level3")
    public String getLevel3() {
        return level3;
    }
    public void setLevel3(String level3) {
        this.level3 = level3;
    }

    @Column(name="level4")
    public String getLevel4() {
        return level4;
    }
    public void setLevel4(String level4) {
        this.level4 = level4;
    }

    @Column(name="level5")
    public String getLevel5() {
        return level5;
    }
    public void setLevel5(String level5) {
        this.level5 = level5;
    }

    @Column(name="level6")
    public String getLevel6() {
        return level6;
    }
    public void setLevel6(String level6) {
        this.level6 = level6;
    }

    @Column(name="level7")
    public String getLevel7() {
        return level7;
    }
    public void setLevel7(String level7) {
        this.level7 = level7;
    }
    
    @Column(name="create_user")
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    @Column(name="create_time")
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((indicator == null) ? 0 : indicator.hashCode());
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
        IndicatorEntity other = (IndicatorEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (indicator == null) {
            if (other.indicator != null)
                return false;
        } else if (!indicator.equals(other.indicator))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "IndicatorEntity [indicator=" + indicator + ", indName=" + indName + ", weight=" + weight
                + ", calCycle=" + calCycle + ", indDesc=" + indDesc + ", calaRegu=" + calaRegu + ", stat=" + stat
                + ", unit=" + unit + ", sign=" + sign + ", startDate=" + startDate + ", endDate=" + endDate
                + ", ifEval=" + ifEval + ", available=" + available + ", detailURL=" + detailURL + ", sort=" + sort
                + ", level1=" + level1 + ", level2=" + level2 + "]";
    }
	
}