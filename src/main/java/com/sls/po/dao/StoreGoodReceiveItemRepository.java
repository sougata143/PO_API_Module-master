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

public interface StoreGoodReceiveItemRepository extends CrudRepository<StoreGoodReceiveLineItem, Long> {

   List<StoreGoodReceiveLineItem> findByStoreGrnHdrId(long grnId);
   
//   @Query("SELECT t FROM SCM_SR_LINE_ITEM t where t.STORE_ID = ?1 AND t.STORE_LINE_ITEM_DETAILS = ?2")
//   public  List<StoreGoodReceiveLineItem> findByStoreIdAndItemId(String storeId, String itemId);
   
   @Query("SELECT t FROM StoreGoodReceiveLineItem t where t.storeId = ?1 AND t.itemId = ?2 order by expiryDate")
   public  List<StoreGoodReceiveLineItem> findByStoreIdAndItemId(String storeId, String itemId);

}
