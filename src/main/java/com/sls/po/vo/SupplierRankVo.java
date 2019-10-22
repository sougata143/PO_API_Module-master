package com.sls.po.vo;

import java.util.List;

import com.sls.po.model.Supplier;
import com.sls.po.model.SupplierIndent;

public class SupplierRankVo {
	private Supplier supplier;
	private float totalFinalPrice;
	private List<SupplierIndentVo>  supplierIndentList;
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public float getTotalFinalPrice() {
		return totalFinalPrice;
	}
	public void setTotalFinalPrice(float totalFinalPrice) {
		this.totalFinalPrice = totalFinalPrice;
	}
	public List<SupplierIndentVo> getSupplierIndentList() {
		return supplierIndentList;
	}
	public void setSupplierIndentList(List<SupplierIndentVo> supplierIndentList) {
		this.supplierIndentList = supplierIndentList;
	}
	

}
