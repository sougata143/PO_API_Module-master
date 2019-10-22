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

@Table(name="SCM_SUPP_INDENT_NOTF")
public class SupplierIndentNotification {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUPP_INDENT_NOTF_SEQ")
    @SequenceGenerator(sequenceName = "scm_supp_indent_notf_seq", allocationSize = 1, name = "SUPP_INDENT_NOTF_SEQ")
	@Column(name="TRANS_ID")
	private  long id;
	
	@Column(name="SUPP_CODE")
	private  String supplierCode;
	
	@Column(name="INDENT_NO")
	private  String indentNo;
	
	@Column(name="CREATE_USER")
	private  String submitter;
	
	@Column(name="CREATE_DATE")
	private  Date  createDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getIndentNo() {
		return indentNo;
	}

	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
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

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	

}
