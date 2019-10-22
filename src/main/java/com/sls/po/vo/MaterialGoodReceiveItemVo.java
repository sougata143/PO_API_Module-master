package com.sls.po.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.sls.po.model.*;

public class MaterialGoodReceiveItemVo {
	
	private  long id;	
	private  long materialGrnHdrId;
	private Item      item;	
	private QuantityUnit quantityUnit;
	private  float quantity ;
	private  String marka;	
	private  Quality advisedQuality ;
	private  Quality actualQuality ;
	private  float issueQuantity ;
	private  float advisedWeight ;
	private  float actualWeight ;
	private  float deviation ;
	private  float rate ;
	private  String claimsQuality ;
	private  String claimsCondition ;
	private  String status ;
	private  String warehouseNo ;
	private  String remarks ;
	private  float totalPrice ;
	private  String debitNotesFlag ;
	private  String approverFirst ;
	private  String approverSecond ;
	private  Date approveFirstDate ;
	private  Date approveSecondDate ;
	private float allowableMoisturePercentage;	
	private String unitConversionType;
	private float conversionQuantity;
	public float conversionActualQuantity;
	private Item      advisedItem;	
	 
	
	public float getConversionActualQuantity() {
		return conversionActualQuantity;
	}
	public void setConversionActualQuantity(float conversionActualQuantity) {
		this.conversionActualQuantity = conversionActualQuantity;
	}
	public String getUnitConversionType() {
		return unitConversionType;
	}
	public void setUnitConversionType(String unitConversionType) {
		this.unitConversionType = unitConversionType;
	}
	public float getConversionQuantity() {
		return conversionQuantity;
	}
	public void setConversionQuantity(float conversionQuantity) {
		this.conversionQuantity = conversionQuantity;
	}
	public float getAllowableMoisturePercentage() {
		return allowableMoisturePercentage;
	}
	public void setAllowableMoisturePercentage(float allowableMoisturePercentage) {
		this.allowableMoisturePercentage = allowableMoisturePercentage;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getMaterialGrnHdrId() {
		return materialGrnHdrId;
	}
	public void setMaterialGrnHdrId(long materialGrnHdrId) {
		this.materialGrnHdrId = materialGrnHdrId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public QuantityUnit getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(QuantityUnit quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public Quality getAdvisedQuality() {
		return advisedQuality;
	}
	public void setAdvisedQuality(Quality advisedQuality) {
		this.advisedQuality = advisedQuality;
	}
	public Quality getActualQuality() {
		return actualQuality;
	}
	public void setActualQuality(Quality actualQuality) {
		this.actualQuality = actualQuality;
	}
	public float getAdvisedWeight() {
		return advisedWeight;
	}
	public void setAdvisedWeight(float advisedWeight) {
		this.advisedWeight = advisedWeight;
	}
	public float getActualWeight() {
		return actualWeight;
	}
	public void setActualWeight(float actualWeight) {
		this.actualWeight = actualWeight;
	}
	public float getDeviation() {
		return deviation;
	}
	public void setDeviation(float deviation) {
		this.deviation = deviation;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	public String getClaimsQuality() {
		return claimsQuality;
	}
	public void setClaimsQuality(String claimsQuality) {
		this.claimsQuality = claimsQuality;
	}
	public String getClaimsCondition() {
		return claimsCondition;
	}
	public void setClaimsCondition(String claimsCondition) {
		this.claimsCondition = claimsCondition;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWarehouseNo() {
		return warehouseNo;
	}
	public void setWarehouseNo(String warehouseNo) {
		this.warehouseNo = warehouseNo;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getDebitNotesFlag() {
		return debitNotesFlag;
	}
	public void setDebitNotesFlag(String debitNotesFlag) {
		this.debitNotesFlag = debitNotesFlag;
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
	public float getIssueQuantity() {
		return issueQuantity;
	}
	public void setIssueQuantity(float issueQuantity) {
		this.issueQuantity = issueQuantity;
	}
	public Item getAdvisedItem() {
		return advisedItem;
	}
	public void setAdvisedItem(Item advisedItem) {
		this.advisedItem = advisedItem;
	}
	
	
	

}
