package com.sls.po.vo;

import java.util.Date;

public class BillPassDTO {

	private  long id;
	private  String supplierCode ;
	private  long grnNo ;
	private  long billNo ;
	private  String poId ;
	private  Date billDate ;
	private  float billAmount ;
	private  String docType ;
	private  String docNo ;
	private  String adjustmentType ;
	private  String financialYear ;
	private String uiBillNo;
	
	
	public String getUiBillNo() {
		return uiBillNo;
	}
	public void setUiBillNo(String uiBillNo) {
		this.uiBillNo = uiBillNo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public long getBillNo() {
		return billNo;
	}
	public void setBillNo(long billNo) {
		this.billNo = billNo;
	}
	public String getPoId() {
		return poId;
	}
	public void setPoId(String poId) {
		this.poId = poId;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public float getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getAdjustmentType() {
		return adjustmentType;
	}
	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	
	
	
}
