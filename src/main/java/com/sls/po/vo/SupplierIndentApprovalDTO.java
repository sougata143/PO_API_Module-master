package com.sls.po.vo;

import java.util.List;

import com.sls.po.model.Indent;
import com.sls.po.model.Supplier;

public class SupplierIndentApprovalDTO {

	private Supplier supplier;
	private List<SupplierResponseIndentLineDTO> indentlineitems;
	private Long tranId;

	public Long getTranId() {
		return tranId;
	}

	public void setTranId(Long tranId) {
		this.tranId = tranId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<SupplierResponseIndentLineDTO> getIndentlineitems() {
		return indentlineitems;
	}

	public void setIndentlineitems(List<SupplierResponseIndentLineDTO> indentlineitems) {
		this.indentlineitems = indentlineitems;
	}

}
