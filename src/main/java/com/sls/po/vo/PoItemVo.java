package com.sls.po.vo;

import java.util.Date;

import javax.persistence.Column;

import com.sls.po.model.*;

public class PoItemVo {
	
	private ItemGroup itemGroup;
	private Item      item;
	private QuantityUnit quantityUnit;
	private Quality quality;	
	private float poQuantity;
	private float poActualQuantity;
	private float rate;	
	private float tax;
	private float valueWithTax;
	private float valueWithoutTax;	
	private String status;
	private String submitter;	
	private String indentId;
	private String type;
	private String poId;
	private long poItemId;	
	private  String approverFirst ;	
	private  String approverSecond ;	
	private  Date approveFirstDate ;	
	private  Date approveSecondDate ;	
	private  String marka;
	private  String additionalRequirement;	
	private  float discount ;
	private float allowableMoisturePercentage;
	private String unitConversionType;
	private float conversionQuantity;
	
	
	
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

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getAdditionalRequirement() {
		return additionalRequirement;
	}

	public void setAdditionalRequirement(String additionalRequirement) {
		this.additionalRequirement = additionalRequirement;
	}
	
	public ItemGroup getItemGroup() {
		return itemGroup;
	}
	public void setItemGroup(ItemGroup itemGroup) {
		this.itemGroup = itemGroup;
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
	public Quality getQuality() {
		return quality;
	}
	public void setQuality(Quality quality) {
		this.quality = quality;
	}
	public float getPoQuantity() {
		return poQuantity;
	}
	public void setPoQuantity(float poQuantity) {
		this.poQuantity = poQuantity;
	}
	public float getPoActualQuantity() {
		return poActualQuantity;
	}
	public void setPoActualQuantity(float poActualQuantity) {
		this.poActualQuantity = poActualQuantity;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getValueWithTax() {
		return valueWithTax;
	}
	public void setValueWithTax(float valueWithTax) {
		this.valueWithTax = valueWithTax;
	}
	public float getValueWithoutTax() {
		return valueWithoutTax;
	}
	public void setValueWithoutTax(float valueWithoutTax) {
		this.valueWithoutTax = valueWithoutTax;
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
	public String getIndentId() {
		return indentId;
	}
	public void setIndentId(String indentId) {
		this.indentId = indentId;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPoId() {
		return poId;
	}
	public void setPoId(String  poId) {
		this.poId = poId;
	}
	public long getPoItemId() {
		return poItemId;
	}
	public void setPoItemId(long poItemId) {
		this.poItemId = poItemId;
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
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	
	
	
	

}
