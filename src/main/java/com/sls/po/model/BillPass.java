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
@Table(name="BILL_PASS")

public class BillPass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BILL_PASS_SEQ")
    @SequenceGenerator(sequenceName = "SCM_BILL_PASS_SEQ", allocationSize = 1, name = "BILL_PASS_SEQ")
	@Column(name="BILL_PASS_TRANS_NO")
	private  long id;
	
	@Column(name="SUPP_CODE")
	private  String supplierCode ;
	
	@Column(name="SR_MR_NUM")
	private  long grnNo ;
	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BILL_NO_SEQ")
//    @SequenceGenerator(sequenceName = "SCM_BILL_NO_SEQ", allocationSize = 1, name = "BILL_NO_SEQ")
	@Column(name="BILL_NO")
	private  String billNo ;
	
	@Column(name="PO_NUM")
	private  String poId ;
	
	@Column(name="BILL_DATE")
	private  Date billDate ;
	
	@Column(name="BILL_AMOUNT")
	private  float billAmount ;
	
	@Column(name="DOC_TYPE")
	private  String docType ;
	@Column(name="DOC_NUM")
	private  String docNo ;
	
	@Column(name="ADJUSTMENT_TYPE")
	private  String adjustmentType ;
	
	@Column(name="FIN_YEAR")
	private  String financialYear ;

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

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
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
