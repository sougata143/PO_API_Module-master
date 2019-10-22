package com.sls.po.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.POTypeGHeader;
import com.sls.po.model.POTypeOHeader;

public interface POHeaderTypeORepository extends CrudRepository<POTypeOHeader, Long> {

   List<POTypeOHeader> findByStatus(String status);
   
   @Query("SELECT t FROM POTypeOHeader t where t.mukam= ?1 AND t.supplierId = ?2")
   public  List<POTypeOHeader> findByMukamAndSupplierId(String mukam, String supplierId);
   
   @Query("SELECT t FROM POTypeOHeader t where  t.supplierId = ?1 AND t.status=?2" )
   public  List<POTypeOHeader> findBySupplierIdAndStatus( String supplierId, String status);


}
