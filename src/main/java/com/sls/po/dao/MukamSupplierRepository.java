package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.MukamSupplier;

public interface MukamSupplierRepository extends CrudRepository<MukamSupplier, Long> {
	
	 List<MukamSupplier> findBySupplierName(String supplierName);

  
}
