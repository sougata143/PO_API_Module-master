package com.sls.po.vo;

import java.util.Date;

import javax.persistence.Column;

import com.sls.po.model.*;

public class IssueLineItemVo {
	
	
	private ItemGroup itemGroup;
	private Item      item;
	private QuantityUnit quantityUnit;
	private Quality quality;
	private long stock;
	private long issueQuantity;
	private long issueId;
	private long issueItemId;
	private  String marka;
	private  String additionalRequirement;	
	private  String remark;
	private ServiceBatchType serviceBatchType;
	
	
	public long getIssueId() {
		return issueId;
	}
	public void setIssueId(long issueId) {
		this.issueId = issueId;
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
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public long getIssueQuantity() {
		return issueQuantity;
	}
	public void setIssueQuantity(long issueQuantity) {
		this.issueQuantity = issueQuantity;
	}
	public long getIssueItemId() {
		return issueItemId;
	}
	public void setIssueItemId(long issueItemId) {
		this.issueItemId = issueItemId;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getAdditionalRequirement() {
		return additionalRequirement;
	}
	public void setAdditionalRequirement(String additionalRequirement) {
		this.additionalRequirement = additionalRequirement;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ServiceBatchType getServiceBatchType() {
		return serviceBatchType;
	}
	public void setServiceBatchType(ServiceBatchType serviceBatchType) {
		this.serviceBatchType = serviceBatchType;
	}	
	
	
}
