package com.yodata.creditsupport.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name ="ods_profit_balance_items", catalog="credit_db")
public class OdsProfitBalanceItemsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ============自定义主键 =================
	private Integer id;

	// ============编码 =================
	private String itemCode;

	// ============名称 =================
	private String itemName;

	// ============描述 =================
	private String itemDesc;

	// ============1利润 2流动资产 3非流动资产 4流动负债 5非流动负债 6所有者权益(或股东权益) =================
	private Integer itemType;

	// ============序号 =================
	private Integer itemSort;

	// ============ =================
	private Integer enable;

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

	// ============编码 =================
	@Column(name="item_code")
	public String getItemCode()
	{
		return this.itemCode;
	};

	public void setItemCode(String itemCode)
	{
		this.itemCode = itemCode;
	};

	// ============名称 =================
	@Column(name="item_name")
	public String getItemName()
	{
		return this.itemName;
	};

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	};

	// ============描述 =================
	@Column(name="item_desc")
	public String getItemDesc()
	{
		return this.itemDesc;
	};

	public void setItemDesc(String itemDesc)
	{
		this.itemDesc = itemDesc;
	};

	// ============1利润 2流动资产 3非流动资产 4流动负债 5非流动负债 6所有者权益(或股东权益) =================
	@Column(name="item_type")
	public Integer getItemType()
	{
		return this.itemType;
	};

	public void setItemType(Integer itemType)
	{
		this.itemType = itemType;
	};

	// ============序号 =================
	@Column(name="item_sort")
	public Integer getItemSort()
	{
		return this.itemSort;
	};

	public void setItemSort(Integer itemSort)
	{
		this.itemSort = itemSort;
	};

	// ============ =================
	@Column(name="enable")
	public Integer getEnable()
	{
		return this.enable;
	};

	public void setEnable(Integer enable)
	{
		this.enable = enable;
	};


};