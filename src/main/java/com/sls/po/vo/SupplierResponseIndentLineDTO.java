package com.sls.po.vo;

import java.util.Date;

import com.sls.po.model.ItemGroup;
import com.sls.po.model.Quality;

public class SupplierResponseIndentLineDTO {

	private Long tranId;
	private long indentItemId;
	private String indentId;
	private String type;
	private String status;
	private ItemGroup itemGroup;
	private ItemDTO item;
	private String unitId;
	private String deptId;
	private float stock;
	private long indentQuantity;
	private long indentCancelledQuantity;
	private String approverFirst;
	private String approverSecond;
	private Date approveFirstDate;
	private Date approveSecondDate;
	private Quality quality;
	private String marka;
	private String additionalRequirement;
	private Float rate;
	private long discount;
	
	
	public long getDiscount() {
		return discount;
	}

	public void setDiscount(long discount) {
		this.discount = discount;
	}

	public Long getTranId() {
		return tranId;
	}

	public void setTranId(Long tranId) {
		this.tranId = tranId;
	}

	public long getIndentItemId() {
		return indentItemId;
	}

	public void setIndentItemId(long indentItemId) {
		this.indentItemId = indentItemId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ItemGroup getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(ItemGroup itemGroup) {
		this.itemGroup = itemGroup;
	}

	public ItemDTO getItem() {
		return item;
	}

	public void setItem(ItemDTO item) {
		this.item = item;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public float getStock() {
		return stock;
	}

	public void setStock(float stock) {
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

	public String getAdditionalRequirement() {
		return additionalRequirement;
	}

	public void setAdditionalRequirement(String additionalRequirement) {
		this.additionalRequirement = additionalRequirement;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

}
