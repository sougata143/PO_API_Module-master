package com.sls.po.vo;

import java.util.Date;

import javax.persistence.Column;

import com.sls.po.model.*;

public class IndentVo {
	
	private Department department;
	private ItemGroup itemGroup;
	private Item      item;
	private QuantityUnit quantityUnit;
	private Quality quality;
	private String stock;
	private long indentQuantity;
	private long indentCancelledQuantity;
	private String status;
	private String submitter;
	
	private String indentId;
	private long indentItemId;
	
	
	private  String approverFirst ;	
	private  String approverSecond ;	
	private  Date approveFirstDate ;	
	private  Date approveSecondDate ;
		
	
	private  String marka;
	private  String additionalRequirement;
	private  float lastPurchasedRate;	
	private  String lastPurchasedCurrency;	
	
	
	public String getAdditionalRequirement() {
		return additionalRequirement;
	}
	public void setAdditionalRequirement(String additionalRequirement) {
		this.additionalRequirement = additionalRequirement;
	}
	public String getLastPurchasedCurrency() {
		return lastPurchasedCurrency;
	}
	public void setLastPurchasedCurrency(String lastPurchasedCurrency) {
		this.lastPurchasedCurrency = lastPurchasedCurrency;
	}
	public float getLastPurchasedRate() {
		return lastPurchasedRate;
	}
	public void setLastPurchasedRate(float lastPurchasedRate) {
		this.lastPurchasedRate = lastPurchasedRate;
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public long getIndentQuantity() {
		return indentQuantity;
	}
	public void setIndentQuantity(long indentQuantity) {
		this.indentQuantity = indentQuantity;
	}
	public long getIndentCancelledQuantity() {
		return indentCancelledQuantity;
	}
	public void setIndentCancelledQuantity(long indentCancelledQuantity) {
		this.indentCancelledQuantity = indentCancelledQuantity;
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
	
	

}
