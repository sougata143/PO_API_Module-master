package com.sls.po.vo;

import java.util.Date;
import java.util.List;

import com.sls.po.model.IndentHeader;
import com.sls.po.model.POHeader;

public class POChalanDetails {
	
	private POHeader poHeader;
	private long chalanNo;
	private Date chalanDate;
	private List<PoItemVo> poItemList;
	public POHeader getPoHeader() {
		return poHeader;
	}
	public void setPoHeader(POHeader poHeader) {
		this.poHeader = poHeader;
	}
	public List<PoItemVo> getPoItemList() {
		return poItemList;
	}
	public void setPoItemList(List<PoItemVo> poItemList) {
		this.poItemList = poItemList;
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
	
	
	

}
