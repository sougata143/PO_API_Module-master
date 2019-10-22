package com.sls.po.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.POTypeGHeader;
import com.sls.po.model.POTypePHeader;

public interface POHeaderTypePRepository extends CrudRepository<POTypePHeader, Long> {

   List<POTypePHeader> findByStatus(String status);
   
   @Query("SELECT t FROM POTypePHeader t where t.mukam= ?1 AND t.supplierId = ?2")
   public  List<POTypePHeader> findByMukamAndSupplierId(String mukam, String supplierId);
   
   @Query("SELECT t FROM POTypePHeader t where  t.supplierId = ?1 AND t.status=?2" )
   public  List<POTypePHeader> findBySupplierIdAndStatus( String supplierId, String status);


}
