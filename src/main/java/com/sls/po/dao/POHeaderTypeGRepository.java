package com.sls.po.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.POTypeGHeader;

public interface POHeaderTypeGRepository extends CrudRepository<POTypeGHeader, Long> {

   List<POTypeGHeader> findByStatus(String status);
   
   @Query("SELECT t FROM POTypeGHeader t where t.mukam= ?1 AND t.supplierId = ?2")
   public  List<POTypeGHeader> findByMukamAndSupplierId(String mukam, String supplierId);
   
   @Query("SELECT t FROM POTypeGHeader t where  t.supplierId = ?1 AND t.status=?2" )
   public  List<POTypeGHeader> findBySupplierIdAndStatus( String supplierId, String status);


}
