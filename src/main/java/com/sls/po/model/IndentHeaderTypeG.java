package com.sls.po.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity()
@Table(name = "SCM_INDENT_HDR")

public class IndentHeaderTypeG {

	@Id
	@GenericGenerator(name = "assigned-sequence", strategy = "com.sls.po.dao.sequence.CustomSequenceIdentifierGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_name", value = "SCM_INDENT_G_TYPE_SEQ"),
			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = "G_"), })
	@GeneratedValue(generator = "assigned-sequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "INDENT_NO")
	private String id;

	@Column(name = "INDENT_TYPE")
	private String type;

	@Column(name = "INDENT_STATUS")
	private String status;

	@Column(name = "USER_1")
	private String submitter;

	@Column(name = "FIN_YEAR")
	private String finnacialYear;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "INDENT_DATE")
	private Date indentDate;

	@Column(name = "APPROVER_LEVEL_FIRST")
	private String approverFirst;
	@Column(name = "APPROVER_LEVEL_SECOND")
	private String approverSecond;

	@Column(name = "APPROVE_LEVEL_FIRST_DATE")
	private Date approveFirstDate;
	@Column(name = "APPROVE_LEVEL_SECOND_DATE")
	private Date approveSecondDate;

	@Column(name = "MUKAM")
	private String mukam;

	@Column(name = "VEHICLE_TYPE_ID")
	private long vehicleTypeId;

	@Column(name = "VEHICLE_QUANTITY")
	private long vehicleQuantity;

	@Column(name = "MOD_ON")
	private java.sql.Date modOn;
	
	@Column(name="MOD_BY")
	private String modBy;
	
	
	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public java.sql.Date getModOn() {
		return modOn;
	}

	public void setModOn(java.sql.Date modOn) {
		this.modOn = modOn;
	}

	public String getMukam() {
		return mukam;
	}

	public void setMukam(String mukam) {
		this.mukam = mukam;
	}

	public long getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(long vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public long getVehicleQuantity() {
		return vehicleQuantity;
	}

	public void setVehicleQuantity(long vehicleQuantity) {
		this.vehicleQuantity = vehicleQuantity;
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

	public Date getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFinnacialYear() {
		return finnacialYear;
	}

	public void setFinnacialYear(String finnacialYear) {
		this.finnacialYear = finnacialYear;
	}

}
