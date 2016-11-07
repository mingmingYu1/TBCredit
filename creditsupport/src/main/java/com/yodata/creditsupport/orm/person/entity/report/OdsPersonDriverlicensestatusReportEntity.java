package com.yodata.creditsupport.orm.person.entity.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name ="ods_person_driverlicensestatus_report", catalog="credit_db")
public class OdsPersonDriverlicensestatusReportEntity implements Serializable {


	private static final long serialVersionUID = -3389693371403658525L;

	// ============自增主键 =================
	private Integer id;

	// ============创建时间 =================
	private Date createTime;

	// ============文件编号 =================
	private String fileNo;

	// ============身份证号 =================
	private String cardId;

	// ============姓名 =================
	private String name;

	// ============驾驶证号匹配结果 =================
	private Integer jszh;

	// ============姓名匹配结果 =================
	private Integer xm;

	// ============A 正常 B 超分 C 转出 D 暂扣 E 撤销 F 吊销 G 注销 H 违法未处理 I 事故未处理 J 停止使用 K 协查 L 锁定 M 逾期未换证 N 延期换证 P 延期体检 R 逾期未体检 S 逾期未审 U 扣留 Z 其他 以上结果可能存在组合，如”BDJ”表示“超分暂扣驾驶证停止使用”  =================
	private String zt;

	// ============ =================
	private Timestamp addtime;

	// ============自增主键 =================
	
	public OdsPersonDriverlicensestatusReportEntity(){}
	
	public OdsPersonDriverlicensestatusReportEntity(String fileNo,Date createTime)
	{
		this.fileNo = fileNo;
		this.createTime=createTime;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
	public Integer getId()
	{
		return this.id;
	};

	public void setId(Integer id)
	{
		this.id = id;
	};

	// ============创建时间 =================
	@Column(name="CREATE_TIME")
	public Date getCreateTime()
	{
		return this.createTime;
	};

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	};

	// ============文件编号 =================
	@Column(name="FILE_NO")
	public String getFileNo()
	{
		return this.fileNo;
	};

	public void setFileNo(String fileNo)
	{
		this.fileNo = fileNo;
	};

	// ============身份证号 =================
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

	// ============A 正常 B 超分 C 转出 D 暂扣 E 撤销 F 吊销 G 注销 H 违法未处理 I 事故未处理 J 停止使用 K 协查 L 锁定 M 逾期未换证 N 延期换证 P 延期体检 R 逾期未体检 S 逾期未审 U 扣留 Z 其他 以上结果可能存在组合，如”BDJ”表示“超分暂扣驾驶证停止使用”  =================
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
		 return "id=" + id
			 + ", createTime=" + createTime
			 + ", fileNo=" + fileNo
			 + ", cardId=" + cardId
			 + ", name=" + name
			 + ", jszh=" + jszh
			 + ", xm=" + xm
			 + ", zt=" + zt
			 + ", addtime=" + addtime;
	};
};