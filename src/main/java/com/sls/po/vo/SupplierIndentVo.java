package com.sls.po.vo;

import java.util.Date;

import com.sls.po.model.*;

public class SupplierIndentVo {
	
	private long transId;
	private String currencyCode;
	private Supplier supplier;
	private ItemGroup itemGroup;
	private Item      item;
	private QuantityUnit quantityUnit;
	private Quality quality;
	private long indentQuantity;
	private String status;
	private String submitter;	
	private String indentId;
	private long indentItemId;
	private float rate;
	private Date createDate;
	private String type;
	private  String finnacialYear ;
	private  String approverFirst ;	
	private  String approverSecond ;	
	private  Date approveFirstDate ;	
	private  Date approveSecondDate ;
	
	
	private  String marka;
	
	private  String additionalRequirement;
	
	

	public String getAdditionalRequirement() {
		return additionalRequirement;
	}

	public void setAdditionalRequirement(String additionalRequirement) {
		this.additionalRequirement = additionalRequirement;
	}

	public Quality getQuality() {
		return quality;
	}
	public void setQuality(Quality quality) {
		this.quality = quality;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public long getTransId() {
		return transId;
	}
	public void setTransId(long transId) {
		this.transId = transId;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
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
	public String getFinnacialYear() {
		return finnacialYear;
	}
	public void setFinnacialYear(String finnacialYear) {
		this.finnacialYear = finnacialYear;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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
	public long getIndentQuantity() {
		return indentQuantity;
	}
	public void setIndentQuantity(long indentQuantity) {
		this.indentQuantity = indentQuantity;
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
	public long getIndentItemId() {
		return indentItemId;
	}
	public void setIndentItemId(long indentItemId) {
		this.indentItemId = indentItemId;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	

}
