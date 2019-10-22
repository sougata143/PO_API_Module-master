package com.sls.po.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.po.model.MaterialGoodReceiveHeader;



public interface MaterialGoodReceiveHeaderRepository extends JpaRepository<MaterialGoodReceiveHeader, Long> {

   List<MaterialGoodReceiveHeader> findByStatus(String status);
   List<MaterialGoodReceiveHeader> findBySupplierId(String supplierId);
   List<MaterialGoodReceiveHeader> findByPoId(String poId);   
   List<MaterialGoodReceiveHeader> findBychalanNo(long chalanNo);
   List<MaterialGoodReceiveHeader> findByWarehouseNo(String warehouseNo);
   List<MaterialGoodReceiveHeader> findByChalanNoAndSupplierIdAndPoId(long chalanNo, String supplierId, String poId);
}
