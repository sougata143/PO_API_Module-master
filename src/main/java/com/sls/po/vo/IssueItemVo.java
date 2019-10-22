package com.sls.po.vo;

import java.util.Date;

import javax.persistence.Column;

import com.sls.po.model.*;

public class IssueItemVo {
	
	private Department department;
	private ItemGroup itemGroup;
	private Item      item;
	private QuantityUnit quantityUnit;
	private Quality quality;	
	private  long id;	
	private  float indentQuantity;
	private  float issuedQuantity ;
	private  long indentId;	
	private  String marka;
	private  String issuer ;
	private  String receiver ;
	private  Date issueDate ;
	private  String lastModifiedUser ;
	private  Date lastModifiedDate ;
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
		
	public float getIndentQuantity() {
		return indentQuantity;
	}
	public void setIndentQuantity(float indentQuantity) {
		this.indentQuantity = indentQuantity;
	}
	public float getIssuedQuantity() {
		return issuedQuantity;
	}
	public void setIssuedQuantity(float issuedQuantity) {
		this.issuedQuantity = issuedQuantity;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
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
	public long getIndentId() {
		return indentId;
	}
	public void setIndentId(long indentId) {
		this.indentId = indentId;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}


}
