package com.sls.po.vo;

import java.util.Date;

import javax.persistence.Column;

import com.sls.po.model.*;

public class GoodReceiveItemVo {
	
	private ItemGroup itemGroup;
	private Item      item;
	private QuantityUnit quantityUnit;
	private Quality quality;	
	private  long id;	
	private  long grnId;
	private  float orderQuantity ;
	private  float actualQuantity ;
	private  float approvedQuantity ;
	private  float rejectedQuantity ;
	private  long indentId;
	private  String indentType;
	private  String marka;
	private  String status ;
	private  String lastModifiedUser ;
	private  Date lastModifiedDate ;
	private  String approverFirst ;
	private  String approverSecond ;
	private  Date approveFirstDate ;
	private  Date approveSecondDate ;
	
	
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getGrnId() {
		return grnId;
	}
	public void setGrnId(long grnId) {
		this.grnId = grnId;
	}
	public float getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(float orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public float getActualQuantity() {
		return actualQuantity;
	}
	public void setActualQuantity(float actualQuantity) {
		this.actualQuantity = actualQuantity;
	}
	public float getApprovedQuantity() {
		return approvedQuantity;
	}
	public void setApprovedQuantity(float approvedQuantity) {
		this.approvedQuantity = approvedQuantity;
	}
	public float getRejectedQuantity() {
		return rejectedQuantity;
	}
	public void setRejectedQuantity(float rejectedQuantity) {
		this.rejectedQuantity = rejectedQuantity;
	}
	public long getIndentId() {
		return indentId;
	}
	public void setIndentId(long indentId) {
		this.indentId = indentId;
	}
	public String getIndentType() {
		return indentType;
	}
	public void setIndentType(String indentType) {
		this.indentType = indentType;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLastModifiedUser() {
		return lastModifiedUser;
	}
	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
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
	
	

}
