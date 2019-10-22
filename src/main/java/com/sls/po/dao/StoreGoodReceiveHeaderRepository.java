package com.sls.po.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.po.model.StoreGoodReceiveHeader;



public interface StoreGoodReceiveHeaderRepository extends JpaRepository<StoreGoodReceiveHeader, Long> {

   List<StoreGoodReceiveHeader> findByStatus(String status);
   List<StoreGoodReceiveHeader> findBySupplierId(String supplierId);
   List<StoreGoodReceiveHeader> findByPoId(String poId);   
   List<StoreGoodReceiveHeader> findBychalanNo(long chalanNo);
   List<StoreGoodReceiveHeader> findByStoreNo(String storeNo);
   List<StoreGoodReceiveHeader> findByChalanNoAndSupplierIdAndPoId(long chalanNo, String supplierId, String poId);
}
