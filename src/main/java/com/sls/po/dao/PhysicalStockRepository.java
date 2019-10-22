package com.sls.po.dao;


import com.sls.po.model.Department;
import com.sls.po.model.IndentHeader;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.PhysicalStock;
import com.sls.po.model.QuantityUnit;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface PhysicalStockRepository extends CrudRepository<PhysicalStock, Long> {

   List<PhysicalStock> findByItemId(String itemId);
   
   List<PhysicalStock> findByStoreId(long storeId);
   
   @Query("SELECT t FROM PhysicalStock t where t.storeId = ?2 AND t.itemId = ?1 order by newStockExpirydDate")
   List<PhysicalStock> findByItemIdAndStoreId(String itemId, long storeId);
   
   @Query("SELECT t FROM PhysicalStock t where t.receiveNo = ?2 AND t.itemId = ?1 order by newStockExpirydDate")
   List<PhysicalStock> findByItemIdAndReceiveNo(String itemId, long receiveNo);
  
   
   @Query("SELECT t FROM PhysicalStock t where t.qualityCode = ?2 AND t.itemId = ?1 AND t.wareHouseNo=?3")   
   List<PhysicalStock> findByItemIdAndQualityCodeAndWareHouseNo(String itemId, String qualityCode,String wareHouseNo);
   
   @Query("SELECT t FROM PhysicalStock t where t.qualityCode = ?2 AND t.itemId = ?1 AND t.receiveNo=?3")   
   List<PhysicalStock> findByItemIdAndQualityCodeAndReceiveNo(String itemId, String qualityCode,long receiveNo);



}
