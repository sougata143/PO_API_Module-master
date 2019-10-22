package com.sls.po.dao;


import com.sls.po.model.Item;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.ItemTax;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface ItemTaxRepository extends CrudRepository<ItemTax, String> {

	ItemTax findByItemInTax(Item item);
	List<ItemTax> findByHsnCode(String hsnCode);

}
