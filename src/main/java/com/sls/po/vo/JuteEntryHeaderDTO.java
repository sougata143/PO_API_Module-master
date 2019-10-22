package com.sls.po.vo;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;

public class JuteEntryHeaderDTO {

	private  long id;
	private  long chalanNo;
	private  long mrNo;
	private  String poNo;
	private  Date chalanDate ;
	private  String mukam ;
	private  String vehicleNo ;
	private String suppCode;
	private String mukamName;
	
	
	public String getMukamName() {
		return mukamName;
	}

	public void setMukamName(String mukamName) {
		this.mukamName = mukamName;
	}

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
