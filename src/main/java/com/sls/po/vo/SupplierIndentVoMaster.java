package com.sls.po.vo;

import java.util.Date;
import java.util.List;

import com.sls.po.model.*;

public class SupplierIndentVoMaster {
	
	private List<SupplierIndentVo> supplierIndentVoList;
	private List<SupplierRankVo> sortedIndentSuppliers;
	private List<SupplierRankVo> sortedIndentItemSuppliers;
	public List<SupplierIndentVo> getSupplierIndentVoList() {
		return supplierIndentVoList;
	}
	public void setSupplierIndentVoList(List<SupplierIndentVo> supplierIndentVoList) {
		this.supplierIndentVoList = supplierIndentVoList;
	}
	public List<SupplierRankVo> getSortedIndentSuppliers() {
		return sortedIndentSuppliers;
	}
	public void setSortedIndentSuppliers(List<SupplierRankVo> sortedIndentSuppliers) {
		this.sortedIndentSuppliers = sortedIndentSuppliers;
	}
	public List<SupplierRankVo> getSortedIndentItemSuppliers() {
		return sortedIndentItemSuppliers;
	}
	public void setSortedIndentItemSuppliers(List<SupplierRankVo> sortedIndentItemSuppliers) {
		this.sortedIndentItemSuppliers = sortedIndentItemSuppliers;
	}
	
	

}
