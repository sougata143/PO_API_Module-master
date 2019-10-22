package com.sls.po.dao;


import com.sls.po.model.Department;
import com.sls.po.model.GoodReceiveLineItem;
import com.sls.po.model.Indent;
import com.sls.po.model.IndentHeader;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.MaterialGoodReceiveLineItem;
import com.sls.po.model.QuantityUnit;
import com.sls.po.model.StoreGoodReceiveLineItem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface MaterialGoodReceiveItemRepository extends CrudRepository<MaterialGoodReceiveLineItem, Long> {

   List<MaterialGoodReceiveLineItem> findByMaterialGrnHdrId(long grnId);
   @Query("SELECT t FROM MaterialGoodReceiveLineItem t where t.warehouseNo= ?1 AND t.itemId = ?2")
   public  List<MaterialGoodReceiveLineItem> findByWarehouseNoAndItemId(String warehouseNo, String itemId);

}
