package com.yodata.creditsupport.orm.person.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name ="ods_person_blacklist", catalog="credit_db")
public class OdsPersonBlacklistEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============身份证号 =================
	private String cardId;

	// ============违约金额:0未知;1小于500元;2小于2000元;3小于5000元;4小于10000元;5大于等于10000元; =================
	private Integer amountType;

	// ============不良行为发生时间距今:0未知;1小于7天;2小于1个月;3小于3个月;4小于6个月;5小于12个月;6大于等于12个月; =================
	private Integer createDateType;

	// ============身份证号 =================
	private String identityCard;

	// ============法院记录状态 =================
	private Integer legalStatus;

	// ============违约持续时间:0未知;1小于1个月;2小于2个月;3小于3个月;4小于6个月;5大于等于6个月; =================
	private Integer overDuetype;

	// ============黑名单原因类别:0借款违约;1法律方面的原因，如有被法院执行记录等;2网络上的不良行为;3因为风险信息而被机构拒绝;4共享经济黑名单; =================
	private Integer reason;

	// ============ =================
	private Timestamp addtime;

	// ============身份证号 =================
	@Id
	@Column(name="card_id")
	public String getCardId()
	{
		return this.cardId;
	};

	public void setCardId(String cardId)
	{
		this.cardId = cardId;
	};

	// ============违约金额:0未知;1小于500元;2小于2000元;3小于5000元;4小于10000元;5大于等于10000元; =================
	@Column(name="amount_type")
	public Integer getAmountType()
	{
		return this.amountType;
	};

	public void setAmountType(Integer amountType)
	{
		this.amountType = amountType;
	};

	// ============不良行为发生时间距今:0未知;1小于7天;2小于1个月;3小于3个月;4小于6个月;5小于12个月;6大于等于12个月; =================
	@Column(name="create_date_type")
	public Integer getCreateDateType()
	{
		return this.createDateType;
	};

	public void setCreateDateType(Integer createDateType)
	{
		this.createDateType = createDateType;
	};

	// ============身份证号 =================
	@Column(name="identity_card")
	public String getIdentityCard()
	{
		return this.identityCard;
	};

	public void setIdentityCard(String identityCard)
	{
		this.identityCard = identityCard;
	};

	// ============法院记录状态 =================
	@Column(name="legal_status")
	public Integer getLegalStatus()
	{
		return this.legalStatus;
	};

	public void setLegalStatus(Integer legalStatus)
	{
		this.legalStatus = legalStatus;
	};

	// ============违约持续时间:0未知;1小于1个月;2小于2个月;3小于3个月;4小于6个月;5大于等于6个月; =================
	@Column(name="over_dueType")
	public Integer getOverDuetype()
	{
		return this.overDuetype;
	};

	public void setOverDuetype(Integer overDuetype)
	{
		this.overDuetype = overDuetype;
	};

	// ============黑名单原因类别:0借款违约;1法律方面的原因，如有被法院执行记录等;2网络上的不良行为;3因为风险信息而被机构拒绝;4共享经济黑名单; =================
	@Column(name="reason")
	public Integer getReason()
	{
		return this.reason;
	};

	public void setReason(Integer reason)
	{
		this.reason = reason;
	};

	// ============ =================
	@Column(name="addtime")
	public Timestamp getAddtime()
	{
		return this.addtime;
	};

	public void setAddtime(Timestamp addtime)
	{
		this.addtime = addtime;
	};


@Override
	public String toString(){
		 return "cardId=" + cardId
			 + ", amountType=" + amountType
			 + ", createDateType=" + createDateType
			 + ", identityCard=" + identityCard
			 + ", legalStatus=" + legalStatus
			 + ", overDuetype=" + overDuetype
			 + ", reason=" + reason
			 + ", addtime=" + addtime;
	};
};