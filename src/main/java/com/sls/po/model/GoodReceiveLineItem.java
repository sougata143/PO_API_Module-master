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
@Table(name="SCM_GRN_LINE_ITEM")

public class GoodReceiveLineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRN_ITEM_SEQ")
    @SequenceGenerator(sequenceName = "SCM_GRN_ITEM_SEQ", allocationSize = 1, name = "GRN_ITEM_SEQ")
	@Column(name="LINE_ITEM_NUM")
	private  long id;
	
	@Column(name="GOOD_RECEPT_NUM")
	private  long grnId;
	
	@Column(name="ITEM_CODE")
	private  String itemId ;
	
	@Column(name="GROUP_CODE")
	private  String groupCode ;
	
	@Column(name="ORDER_QUANTITY")
	private  float orderQuantity ;
	
	@Column(name="ACTUAL_QUANTITY")
	private  float actualQuantity ;
	
	@Column(name="APPROVED_QUANTITY")
	private  float approvedQuantity ;
	
	@Column(name="REJECTED_QUANTITY")
	private  float rejectedQuantity ;
	
	@Column(name="INDENT_NO")
	private  long indentId;
	
	@Column(name="INDENT_TYPE")
	private  String indentType;

	@Column(name="STATUS")
	private  String status ;
	
	@Column(name="MOD_BY")
	private  String lastModifiedUser ;
	
	@Column(name="MOD_DATE")
	private  Date lastModifiedDate ;
	
	
	@Column(name="APPROVER_LEVEL_FIRST")
	private  String approverFirst ;
	@Column(name="APPROVER_LEVEL_SECOND")
	private  String approverSecond ;
	
	@Column(name="APPROVE_LEVEL_FIRST_DATE")
	private  Date approveFirstDate ;
	@Column(name="APPROVE_LEVEL_SECOND_DATE")
	private  Date approveSecondDate ;
	
	@Column(name="QUALITY")
	private  long qualityCode;
	
	@Column(name="MARKA")
	private  String marka;
	
	@Column(name="UOM_CODE")
	private  String unitId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGrnId() {
		return grnId;
	}

	public void setGrnId(long grnId) {
		this.grnId = grnId;
	}

	public float getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(float orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public float getActualQuantity() {
		return actualQuantity;
	}

	public void setActualQuantity(float actualQuantity) {
		this.actualQuantity = actualQuantity;
	}

	public float getApprovedQuantity() {
		return approvedQuantity;
	}

	public void setApprovedQuantity(float approvedQuantity) {
		this.approvedQuantity = approvedQuantity;
	}

	public float getRejectedQuantity() {
		return rejectedQuantity;
	}

	public void setRejectedQuantity(float rejectedQuantity) {
		this.rejectedQuantity = rejectedQuantity;
	}

	public long getIndentId() {
		return indentId;
	}

	public void setIndentId(long indentId) {
		this.indentId = indentId;
	}

	public String getIndentType() {
		return indentType;
	}

	public void setIndentType(String indentType) {
		this.indentType = indentType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
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

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	
		
}