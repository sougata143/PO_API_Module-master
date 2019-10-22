package com.sls.po.dao;


import com.sls.po.model.Item;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.ItemStock;
import com.sls.po.model.StoreGoodReceiveLineItem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface ItemStockRepository extends CrudRepository<ItemStock, String> {

	
	List<ItemStock> findByItemId(String itemId);
	List<ItemStock> findByGroupId(String groupId);
	
	
}
