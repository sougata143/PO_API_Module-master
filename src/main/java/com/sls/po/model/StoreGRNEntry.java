package com.sls.po.model;

import java.sql.Timestamp;
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

@Table(name="GATE_STORE_ENTRY_REG_HDR")
public class StoreGRNEntry {
	
	@Id	
	@Column(name="HDR_ID")
	private  long id;
	
	@Column(name="CHALLAN_NO")
	private  long chalanNo;
	
	@Column(name="CHALLAN_DATE")
	private  Date chalanDate ;
	
	@Column(name="PO_NO")
	private  String poId ;
	
	@Column(name="VEHICLE_NO")
	private String vehicleNo;
	
	@Column(name="DRIVER_NAME")
	private String driverName;
	
	@Column(name="SUPPLIER_NAME")
	private String supplierName;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="OPEN_CLOSE")
	private String openClose;
	
	@Column(name="IN_DATE")
	private Date inDate;
	
	@Column(name="IN_TIME")
	private Timestamp inTime;
	
	@Column(name="OUT_TIME")
	private Timestamp outTime;
	
	@Column(name="OUT_DATE")
	private Date outDate;
	
	@Column(name="UPDATE_BY")
	private String updateBy;
	
	@Column(name="UPDATE_DATE_TIME")
	private Timestamp updateDateTime;
	
	@Column(name="SUPP_CODE")
	private String suppCode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPoId() {
		return poId;
	}

	public void setPoId(String poId) {
		this.poId = poId;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOpenClose() {
		return openClose;
	}

	public void setOpenClose(String openClose) {
		this.openClose = openClose;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Timestamp getInTime() {
		return inTime;
	}

	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}

	public Timestamp getOutTime() {
		return outTime;
	}

	public void setOutTime(Timestamp outTime) {
		this.outTime = outTime;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Timestamp getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Timestamp updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
}
