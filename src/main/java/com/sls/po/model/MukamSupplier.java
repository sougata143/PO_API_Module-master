package com.sls.po.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="MUKAM_SUPPLIER_MAP")
public class MukamSupplier {	
	
	@Id
	@Column(name="MAPPING_ID")
	private  long id;
	
	@Column(name="MUKAM_ID")
	private  long mukamId;
	
	@Column(name="SUPP_CODE")
	private  String supplierName ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMukamId() {
		return mukamId;
	}

	public void setMukamId(long mukamId) {
		this.mukamId = mukamId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	

}
