package com.sls.po.dao;


import com.sls.po.model.Department;
import com.sls.po.model.Indent;
import com.sls.po.model.IndentHeader;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.POLineItem;
import com.sls.po.model.QuantityUnit;
import com.sls.po.model.StoreGoodReceiveLineItem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface POLineItemRepository extends CrudRepository<POLineItem, Long> {

   List<POLineItem> findByPoId(String poId);
   List<POLineItem> findByIndentId(String indentId);
   List<POLineItem> findByIndentIdAndItemId(String indentId, String itemCode);
   @Query("SELECT t FROM POLineItem t where t.poId = ?1 AND t.itemId = ?2 AND t.qualityCode = ?3")
   public  List<POLineItem> findByPoIdAndItemIdAndQualityCode(String poId, String itemId, long qualityCode);


}
