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
@Table(name="SCM_GRN_HDR")

public class GoodReceiveHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRN_HDR_SEQ")
    @SequenceGenerator(sequenceName = "SCM_GRN_HEADER_SEQ", allocationSize = 1, name = "GRN_HDR_SEQ")
	@Column(name="GOOD_RECEPT_NUM")
	private  long id;
	
	@Column(name="PO_NUM")
	private  String poId ;
	
	@Column(name="GOOD_RECEPT_STATUS")
	private  String status ;
	
	@Column(name="USER_1")
	private  String submitter ;
	
	@Column(name="FIN_YEAR")
	private  String finnacialYear ;
	
	@Column(name="DATE_1")
	private  Date createDate ;
	
	@Column(name="GOOD_RECEPT_DATE")
	private  Date goodReceiptDate ;
	
	@Column(name="SUPP_CODE")
	private  String supplierId ;
	
	@Column(name="APPROVER_LEVEL_FIRST")
	private  String approverFirst ;
	
	@Column(name="APPROVER_LEVEL_SECOND")
	private  String approverSecond ;
	
	@Column(name="APPROVE_LEVEL_FIRST_DATE")
	private  Date approveFirstDate ;
	
	@Column(name="APPROVE_LEVEL_SECOND_DATE")
	private  Date approveSecondDate ;
	
	@Column(name="CHALAN_NO")
	private  long chalanNo ;
	
	@Column(name="CHALAN_DATE")
	private  Date chalanDate ;
	
	@Column(name="STORE_ID")
	private  long storeId ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPoId() {
		return poId;
	}

	public void setPoId(String poId) {
		this.poId = poId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public String getFinnacialYear() {
		return finnacialYear;
	}

	public void setFinnacialYear(String finnacialYear) {
		this.finnacialYear = finnacialYear;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getGoodReceiptDate() {
		return goodReceiptDate;
	}

	public void setGoodReceiptDate(Date goodReceiptDate) {
		this.goodReceiptDate = goodReceiptDate;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
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

	public long getChalanNo() {
		return chalanNo;
	}

	public void setChalanNo(long chalanNo) {
		this.chalanNo = chalanNo;
	}

	public Date getChalanDate() {
		return chalanDate;
	}

	public void setChalanDate(Date chalanDate) {
		this.chalanDate = chalanDate;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	
	
}