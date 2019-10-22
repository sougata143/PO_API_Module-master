package com.sls.po.vo;

import java.util.Date;

import com.sls.po.model.Item;
import com.sls.po.model.QuantityUnit;

public class DebitCreditNotesVo {
	
	
	private  long id;
	private  String adjustmentType; 
	private  Date adjustmentDate ;
	private  String financialYear ;
	private  String supplierCode ;
	private  long grnNo ;
	private  String grnYear ;
	private  Date grnDate ;
	private  Item item ;
	private  float adjustmentQunatity ;
	private  float adjustmentValue ;
	private  QuantityUnit quantityUnit;
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
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
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
	public QuantityUnit getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(QuantityUnit quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	
	
	
}
