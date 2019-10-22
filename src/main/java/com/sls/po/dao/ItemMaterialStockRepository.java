package com.sls.po.dao;


import com.sls.po.model.Item;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.ItemMaterialStock;
import com.sls.po.model.ItemStock;
import com.sls.po.model.StoreGoodReceiveLineItem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface ItemMaterialStockRepository extends CrudRepository<ItemMaterialStock, String> {

	
	List<ItemMaterialStock> findByItemId(String itemId);
	List<ItemMaterialStock> findByGroupId(String groupId);
	
	 @Query("SELECT t FROM ItemMaterialStock t where t.itemId = ?1 AND t.qualityCode = ?2 ")
	  public  List<ItemMaterialStock> findByItemIdAndQualityCode(String itemId,String qualityCode);

}
