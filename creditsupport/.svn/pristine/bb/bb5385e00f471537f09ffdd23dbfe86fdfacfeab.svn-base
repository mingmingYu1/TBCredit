package com.yodata.creditsupport.orm.person.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 驾驶证信息
 * @author Jason
 *
 */

@Entity
@Table(name ="ods_person_driverlicensestatus", catalog="credit_db")
public class OdsPersonDriverlicensestatusEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============身份证号 =================
	private String cardId;

	// ============姓名 =================
	private String name;

	// ============驾驶证号匹配结果 =================
	private Integer jszh;

	// ============姓名匹配结果 =================
	private Integer xm;

	// ============A 正常;B 超分;C 转出;D 暂扣;E 撤销;F 吊销;G 注销;H 违法未处理;I 事故未处理;J 停止使用;K 协查;L 锁定;M 逾期未换证;N 延期换证;P 延期体检;R 逾期未体检;S 逾期未审;U 扣留;Z 其他;以上结果可能存在组合，如BDJ表示超分暂扣驾驶证停止使用 =================
	private String zt;

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

	// ============姓名 =================
	@Column(name="name")
	public String getName()
	{
		return this.name;
	};

	public void setName(String name)
	{
		this.name = name;
	};

	// ============驾驶证号匹配结果 =================
	@Column(name="jszh")
	public Integer getJszh()
	{
		return this.jszh;
	};

	public void setJszh(Integer jszh)
	{
		this.jszh = jszh;
	};

	// ============姓名匹配结果 =================
	@Column(name="xm")
	public Integer getXm()
	{
		return this.xm;
	};

	public void setXm(Integer xm)
	{
		this.xm = xm;
	};

	// ============A 正常;B 超分;C 转出;D 暂扣;E 撤销;F 吊销;G 注销;H 违法未处理;I 事故未处理;J 停止使用;K 协查;L 锁定;M 逾期未换证;N 延期换证;P 延期体检;R 逾期未体检;S 逾期未审;U 扣留;Z 其他;以上结果可能存在组合，如BDJ表示超分暂扣驾驶证停止使用 =================
	@Column(name="zt")
	public String getZt()
	{
		return this.zt;
	};

	public void setZt(String zt)
	{
		this.zt = zt;
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
			 + ", name=" + name
			 + ", jszh=" + jszh
			 + ", xm=" + xm
			 + ", zt=" + zt
			 + ", addtime=" + addtime;
	};
};