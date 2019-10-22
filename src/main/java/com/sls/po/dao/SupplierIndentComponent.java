package com.sls.po.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.po.model.SupplierIndent;

@Component
public class SupplierIndentComponent {

	@Autowired
	SupplierIndentRepository supplierIndentRepository;
	
	@Transactional
	public SupplierIndent save(SupplierIndent supplierIndent) {
		return supplierIndentRepository.save(supplierIndent);
	}
	
}
