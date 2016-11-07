package com.yodata.creditsupport.orm.entity.his;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yodata.creditsupport.orm.entity.AgentTaxAccountEntity;

/**
 * 
 * @author lenovo
 * 税务信息
 *
 */
@Entity
@Table(name="ods_agent_tax_account_info_his", catalog="credit_db")
public class AgentTaxAccountHisEntity implements Serializable{

	private static final long serialVersionUID = -6308909441809036652L;
	
	// =============== 自增主键 =================
		private Integer id;

		// =============== 工商注册号 =================
		private String regId;

		// =============== 增值税（税率） =================
		private Double addedValueTaxRate;

		// =============== 企业所得税（税率） =================
		private Double incomeTaxRate;

		// =============== 年应税额 =================
		private Double annualTax;

		// =============== 应税货物销售额 =================
		private Double taxableGoodsSales;

		// =============== 应税劳务销售额 =================
		private Double taxableLaberServiceSales;

		// =============== 纳税检查调整的销售额 =================
		private Double ajustedSales;

		// =============== 免税销售额 =================
		private Double taxExemptSales;

		// =============== 合计 =================
		private Double taxSum;

		// =============== 销项税额 =================
		private Double outputVat;

		// =============== 进项税额 =================
		private Double inputVat;

		// =============== 上期留底税额 =================
		private Double overpaidVat;

		// =============== 应纳税额合计 =================
		private Double totalAmountOfTax;

		// =============== 期末留抵金额 =================
		private Double taxCreditToStay;

		// =============== 年应税销售额 =================
		private Double annualTaxableSales;

		// =============== 企业所得税 =================
		private Double incomeTax;

		// =============== 增值税 =================
		private Double addedValueTax;

		// =============== 其他税种 =================
		private Double otherTax;

		// =============== 创建时间 =================
		private Date createTime;

		// =============== 文件编号 =================
		private String fileNo;

		
		public AgentTaxAccountHisEntity(){};
		
		public AgentTaxAccountHisEntity(String fileNo, Date createTime) {
			this.fileNo = fileNo;
			this.createTime = createTime;
		}
		
		// =============== 自增主键 =================
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id", nullable = false)
		public Integer getId() {
			return this.id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		// =============== 工商注册号 =================
		@Column(name = "REG_ID")
		public String getRegId() {
			return this.regId;
		}

		public void setRegId(String regId) {
			this.regId = regId;
		}

		// =============== 增值税（税率） =================
		@Column(name = "ADDED_VALUE_TAX_RATE")
		public Double getAddedValueTaxRate() {
			return this.addedValueTaxRate;
		}

		public void setAddedValueTaxRate(Double addedValueTaxRate) {
			this.addedValueTaxRate = addedValueTaxRate;
		}

		// =============== 企业所得税（税率） =================
		@Column(name = "INCOME_TAX_RATE")
		public Double getIncomeTaxRate() {
			return this.incomeTaxRate;
		}

		public void setIncomeTaxRate(Double incomeTaxRate) {
			this.incomeTaxRate = incomeTaxRate;
		}

		// =============== 年应税额 =================
		@Column(name = "ANNUAL_TAX")
		public Double getAnnualTax() {
			return this.annualTax;
		}

		public void setAnnualTax(Double annualTax) {
			this.annualTax = annualTax;
		}

		// =============== 应税货物销售额 =================
		@Column(name = "TAXABLE_GOODS_SALES")
		public Double getTaxableGoodsSales() {
			return this.taxableGoodsSales;
		}

		public void setTaxableGoodsSales(Double taxableGoodsSales) {
			this.taxableGoodsSales = taxableGoodsSales;
		}

		// =============== 应税劳务销售额 =================
		@Column(name = "TAXABLE_LABER_SERVICE_SALES")
		public Double getTaxableLaberServiceSales() {
			return this.taxableLaberServiceSales;
		}

		public void setTaxableLaberServiceSales(Double taxableLaberServiceSales) {
			this.taxableLaberServiceSales = taxableLaberServiceSales;
		}

		// =============== 纳税检查调整的销售额 =================
		@Column(name = "AJUSTED_SALES")
		public Double getAjustedSales() {
			return this.ajustedSales;
		}

		public void setAjustedSales(Double ajustedSales) {
			this.ajustedSales = ajustedSales;
		}

		// =============== 免税销售额 =================
		@Column(name = "TAX_EXEMPT_SALES")
		public Double getTaxExemptSales() {
			return this.taxExemptSales;
		}

		public void setTaxExemptSales(Double taxExemptSales) {
			this.taxExemptSales = taxExemptSales;
		}

		// =============== 合计 =================
		@Column(name = "TAX_SUM")
		public Double getTaxSum() {
			return this.taxSum;
		}

		public void setTaxSum(Double taxSum) {
			this.taxSum = taxSum;
		}

		// =============== 销项税额 =================
		@Column(name = "OUTPUT_VAT")
		public Double getOutputVat() {
			return this.outputVat;
		}

		public void setOutputVat(Double outputVat) {
			this.outputVat = outputVat;
		}

		// =============== 进项税额 =================
		@Column(name = "INPUT_VAT")
		public Double getInputVat() {
			return this.inputVat;
		}

		public void setInputVat(Double inputVat) {
			this.inputVat = inputVat;
		}

		// =============== 上期留底税额 =================
		@Column(name = "OVERPAID_VAT")
		public Double getOverpaidVat() {
			return this.overpaidVat;
		}

		public void setOverpaidVat(Double overpaidVat) {
			this.overpaidVat = overpaidVat;
		}

		// =============== 应纳税额合计 =================
		@Column(name = "TOTAL_AMOUNT_OF_TAX")
		public Double getTotalAmountOfTax() {
			return this.totalAmountOfTax;
		}

		public void setTotalAmountOfTax(Double totalAmountOfTax) {
			this.totalAmountOfTax = totalAmountOfTax;
		}

		// =============== 期末留抵金额 =================
		@Column(name = "TAX_CREDIT_TO_STAY")
		public Double getTaxCreditToStay() {
			return this.taxCreditToStay;
		}

		public void setTaxCreditToStay(Double taxCreditToStay) {
			this.taxCreditToStay = taxCreditToStay;
		}

		// =============== 年应税销售额 =================
		@Column(name = "ANNUAL_TAXABLE_SALES")
		public Double getAnnualTaxableSales() {
			return this.annualTaxableSales;
		}

		public void setAnnualTaxableSales(Double annualTaxableSales) {
			this.annualTaxableSales = annualTaxableSales;
		}

		// =============== 企业所得税 =================
		@Column(name = "INCOME_TAX")
		public Double getIncomeTax() {
			return this.incomeTax;
		}

		public void setIncomeTax(Double incomeTax) {
			this.incomeTax = incomeTax;
		}

		// =============== 增值税 =================
		@Column(name = "ADDED_VALUE_TAX")
		public Double getAddedValueTax() {
			return this.addedValueTax;
		}

		public void setAddedValueTax(Double addedValueTax) {
			this.addedValueTax = addedValueTax;
		}

		// =============== 其他税种 =================
		@Column(name = "OTHER_TAX")
		public Double getOtherTax() {
			return this.otherTax;
		}

		public void setOtherTax(Double otherTax) {
			this.otherTax = otherTax;
		}

		// =============== 创建时间 =================
		@Column(name = "CREATE_TIME")
		public Date getCreateTime() {
			return this.createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		// =============== 文件编号 =================
		@Column(name = "FILE_NO")
		public String getFileNo() {
			return this.fileNo;
		}

		public void setFileNo(String fileNo) {
			this.fileNo = fileNo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}


		@Override
		public String toString() {
			return "AgentLiquidationEntity [id=" + id + ", regId=" + regId + ", taxSum=" + taxSum + "]";
		}
	
}
