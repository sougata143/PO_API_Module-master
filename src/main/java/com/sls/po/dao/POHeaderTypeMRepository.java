package com.sls.po.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.POTypeGHeader;
import com.sls.po.model.POTypeMHeader;

public interface POHeaderTypeMRepository extends CrudRepository<POTypeMHeader, Long> {

   List<POTypeMHeader> findByStatus(String status);
   
   @Query("SELECT t FROM POTypeMHeader t where t.mukam= ?1 AND t.supplierId = ?2")
   public  List<POTypeMHeader> findByMukamAndSupplierId(String mukam, String supplierId);
   
   @Query("SELECT t FROM POTypeMHeader t where  t.supplierId = ?1 AND t.status=?2" )
   public  List<POTypeMHeader> findBySupplierIdAndStatus( String supplierId, String status);


}
