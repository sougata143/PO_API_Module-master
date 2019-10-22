package com.sls.po.vo;

import java.util.Date;

public class StoreGRNEntryDTO {

	private  long id;
	private  long chalanNo;
	private  Date chalanDate ;
	private  String poNo ;
	private String vehicleNo;
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
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getSuppCode() {
		return suppCode;
	}
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
}
