package com.yodata.creditsupport.orm.entity.his;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ods_profit_his", catalog="credit_db")
public class OdsProfitHisEntity implements Serializable{

	private static final long serialVersionUID = -3464897537004984006L;

	// ============自定义主键 =================
		private Integer id;

		// ============流水号 =================
		private String serialNo;

		// ============工商注册号 =================
		private String regId;

		// ============项目 =================
		private String item;

		// ============上期金额 =================
		private Double preAmount;

		// ============本期金额 =================
		private Double curAmount;

		// ============ =================
		private Timestamp addTime;

		private String fileNo;			// 文件编号
		private Date createTime;		// 生成时间
		
		public OdsProfitHisEntity() {
			// TODO Auto-generated constructor stub
		}
		
	   public OdsProfitHisEntity(String fileNo,Date createTime) {
			// TODO Auto-generated constructor stub
		   this.fileNo = fileNo;
		   this.createTime = createTime;
		}
	   
		@Column(name="FILE_NO")
		public String getFileNo() {
			return fileNo;
		}
		public void setFileNo(String fileNo) {
			this.fileNo = fileNo;
		}
		@Column(name="CREATE_TIME")
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		
		// ============自定义主键 =================
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ID", nullable = false)
		public Integer getId()
		{
			return this.id;
		};

		public void setId(Integer id)
		{
			this.id = id;
		};

		// ============流水号 =================
		@Column(name="serial_no")
		public String getSerialNo()
		{
			return this.serialNo;
		};

		public void setSerialNo(String serialNo)
		{
			this.serialNo = serialNo;
		};

		// ============工商注册号 =================
		@Column(name="reg_id")
		public String getRegId()
		{
			return this.regId;
		};

		public void setRegId(String regId)
		{
			this.regId = regId;
		};

		// ============项目 =================
		@Column(name="item")
		public String getItem()
		{
			return this.item;
		};

		public void setItem(String item)
		{
			this.item = item;
		};

		// ============上期金额 =================
		@Column(name="pre_amount")
		public Double getPreAmount()
		{
			return this.preAmount;
		};

		public void setPreAmount(Double preAmount)
		{
			this.preAmount = preAmount;
		};

		// ============本期金额 =================
		@Column(name="cur_amount")
		public Double getCurAmount()
		{
			return this.curAmount;
		};

		public void setCurAmount(Double curAmount)
		{
			this.curAmount = curAmount;
		};

		// ============ =================
		@Column(name="add_time")
		public Timestamp getAddTime()
		{
			return this.addTime;
		};

		public void setAddTime(Timestamp addTime)
		{
			this.addTime = addTime;
		};
	
}
