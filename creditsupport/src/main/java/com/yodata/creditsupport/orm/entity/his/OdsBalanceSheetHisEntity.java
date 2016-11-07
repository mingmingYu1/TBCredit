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
@Table(name ="ods_balance_sheet_his", catalog="credit_db")
public class OdsBalanceSheetHisEntity implements Serializable{

	private static final long serialVersionUID = 5134965037307618291L;
	
	// ============自定义主键 =================
		private Integer id;

		// ============流水号 =================
		private String serialNo;

		// ============工商注册号 =================
		private String regId;

		// ============项目 =================
		private String item;

		// ============年初 =================
		private String lastYear;

		// ============期末 =================
		private String endingBalance;

		// ============ =================
		private Timestamp addTime;

		private String fileNo;			// 文件编号
		private Date createTime;		// 生成时间
		
	   public OdsBalanceSheetHisEntity() {}
		
	   public OdsBalanceSheetHisEntity(String fileNo,Date createTime) 
	   {
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

		// ============年初 =================
		@Column(name="last_year")
		public String getLastYear()
		{
			return this.lastYear;
		};

		public void setLastYear(String lastYear)
		{
			this.lastYear = lastYear;
		};

		// ============期末 =================
		@Column(name="ending_balance")
		public String getEndingBalance()
		{
			return this.endingBalance;
		};

		public void setEndingBalance(String endingBalance)
		{
			this.endingBalance = endingBalance;
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
