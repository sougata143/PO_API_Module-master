package com.sls.po.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity()
@Table(name="DR_CR_NOTE")

public class DebitCreditNotes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DR_CR_NOTE_SEQ")
    @SequenceGenerator(sequenceName = "SCM_DR_CR_NOTE_SEQ", allocationSize = 1, name = "DR_CR_NOTE_SEQ")
	@Column(name="ADJUSTMENT_NO")
	private  long id;
	

	@Column(name="ADJUSTMENT_TYPE")
	private  String adjustmentType ;
	

	@Column(name="ADJUSTMENT_DATE")
	private  Date adjustmentDate ;
	
	@Column(name="FIN_YEAR")
	private  String financialYear ;
	
	@Column(name="SUPP_CODE")
	private  String supplierCode ;
	
	@Column(name="SR_MR_NUM")
	private  long grnNo ;
	
	@Column(name="SR_MR_YEAR")
	private  String grnYear ;
	
	
	@Column(name="SR_MR_DATE")
	private  Date grnDate ;
	
	
	@Column(name="ITEM_CODE")
	private  String itemCode ;
	
	@Column(name="ADJUSTMENT_QUANTITY")
	private  float adjustmentQunatity ;
	
	@Column(name="ADJUSTMENT_VALUE")
	private  float adjustmentValue ;
	
	@Column(name="UOM_CODE")
	private  String uomCode;
	
	@Column(name="REASON")
	private  String reason ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdjustmentType() {
		return adjustmentType;
	}

	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public Date getAdjustmentDate() {
		return adjustmentDate;
	}

	public void setAdjustmentDate(Date adjustmentDate) {
		this.adjustmentDate = adjustmentDate;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public long getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(long grnNo) {
		this.grnNo = grnNo;
	}

	

	public String getGrnYear() {
		return grnYear;
	}

	public void setGrnYear(String grnYear) {
		this.grnYear = grnYear;
	}

	public Date getGrnDate() {
		return grnDate;
	}

	public void setGrnDate(Date grnDate) {
		this.grnDate = grnDate;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public float getAdjustmentQunatity() {
		return adjustmentQunatity;
	}

	public void setAdjustmentQunatity(float adjustmentQunatity) {
		this.adjustmentQunatity = adjustmentQunatity;
	}

	public float getAdjustmentValue() {
		return adjustmentValue;
	}

	public void setAdjustmentValue(float adjustmentValue) {
		this.adjustmentValue = adjustmentValue;
	}

	

	public String getUomCode() {
		return uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}
