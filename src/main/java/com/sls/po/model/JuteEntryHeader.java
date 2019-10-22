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
@Table(name="JUTE_GATE_ENTRY_HDR")

public class JuteEntryHeader {
	
	@Id
	@Column(name="REC_ID")
	private  long id;
	
	@Column(name="CHALLAN_NO")
	private  long chalanNo;
	
	@Column(name="MR_NO")
	private  long mrNo;
	
	@Column(name="PO_NO")
	private  String poNo;
	

	@Column(name="CHALLAN_DATE")
	private  Date chalanDate ;
	
	@Column(name="MUKAM")
	private  String mukam ;
	
	@Column(name="VEHICLE_NO")
	private  String vehicleNo ;
	
	@Column(name="SUPP_CODE")
	private String suppCode;
	
	
	
	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

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

	public long getMrNo() {
		return mrNo;
	}

	public void setMrNo(long mrNo) {
		this.mrNo = mrNo;
	}

	

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public Date getChalanDate() {
		return chalanDate;
	}

	public void setChalanDate(Date chalanDate) {
		this.chalanDate = chalanDate;
	}

	public String getMukam() {
		return mukam;
	}

	public void setMukam(String mukam) {
		this.mukam = mukam;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	
	


}
