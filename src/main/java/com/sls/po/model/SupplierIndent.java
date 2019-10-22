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

@Table(name="SCM_SUPP_INDENT_RESPONSE")
public class SupplierIndent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUPP_INDENT_ITM_SEQ")
    @SequenceGenerator(sequenceName = "SCM_SUPP_INDENT_ITEM_SEQ", allocationSize = 1, name = "SUPP_INDENT_ITM_SEQ")
	@Column(name="TRANS_ID")
	private long transId;
	
	@Column(name="INDENT_SRL_NO")
	private  long id;
	
	@Column(name="INDENT_NO")
	private  String indentHeaderId;
	
	@Column(name="INDENT_TYPE")
	private  String type ;
	
	@Column(name="INDENT_STATUS")
	private  String status ;
	
	@Column(name="GROUP_CODE")
	private  String itemGroupId;
	
	@Column(name="ITEM_CODE")
	private  String itemId;
	
	@Column(name="UOM_CODE")
	private  String unitId;
	
	
	@Column(name="SUPP_CODE")
	private  String supplierCode;
	
	@Column(name="RATE")
	private  float rate;
	
	
	@Column(name="USER_1")
	private  String submitter ;
	
	
	
	@Column(name="CREATE_DATE")
	private  Date createDate ;
	
	
	@Column(name="INDENT_QTY")
	private long indentQuantity;
	
	@Column(name="FIN_YEAR")
	private  String finnacialYear ;
	
	
	@Column(name="APPROVER_LEVEL_FIRST")
	private  String approverFirst ;
	@Column(name="APPROVER_LEVEL_SECOND")
	private  String approverSecond ;
	
	@Column(name="APPROVE_LEVEL_FIRST_DATE")
	private  Date approveFirstDate ;
	@Column(name="APPROVE_LEVEL_SECOND_DATE")
	private  Date approveSecondDate ;
		
	@Column(name="CURRENCY")
	private String currencyCode;
	
	@Column(name="QUALITY")
	private  long qualityCode;
	
	@Column(name="MARKA")
	private  String marka;

	

	public long getQualityCode() {
		return qualityCode;
	}

	public void setQualityCode(long qualityCode) {
		this.qualityCode = qualityCode;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public long getTransId() {
		return transId;
	}

	public void setTransId(long transId) {
		this.transId = transId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getApproverFirst() {
		return approverFirst;
	}

	public void setApproverFirst(String approverFirst) {
		this.approverFirst = approverFirst;
	}

	public String getApproverSecond() {
		return approverSecond;
	}

	public void setApproverSecond(String approverSecond) {
		this.approverSecond = approverSecond;
	}

	public Date getApproveFirstDate() {
		return approveFirstDate;
	}

	public void setApproveFirstDate(Date approveFirstDate) {
		this.approveFirstDate = approveFirstDate;
	}

	public Date getApproveSecondDate() {
		return approveSecondDate;
	}

	public void setApproveSecondDate(Date approveSecondDate) {
		this.approveSecondDate = approveSecondDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIndentHeaderId() {
		return indentHeaderId;
	}

	public void setIndentHeaderId(String indentHeaderId) {
		this.indentHeaderId = indentHeaderId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getItemGroupId() {
		return itemGroupId;
	}

	public void setItemGroupId(String itemGroupId) {
		this.itemGroupId = itemGroupId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getIndentQuantity() {
		return indentQuantity;
	}

	public void setIndentQuantity(long indentQuantity) {
		this.indentQuantity = indentQuantity;
	}

	public String getFinnacialYear() {
		return finnacialYear;
	}

	public void setFinnacialYear(String finnacialYear) {
		this.finnacialYear = finnacialYear;
	}
}
