package com.sls.po.dao;


import com.sls.po.model.Department;
import com.sls.po.model.Indent;
import com.sls.po.model.IndentHeader;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.QuantityUnit;
import com.sls.po.model.Supplier;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface SupplierRepository extends CrudRepository<Supplier, String> {
	
	 List<Supplier> findByType(String type);

 
}
