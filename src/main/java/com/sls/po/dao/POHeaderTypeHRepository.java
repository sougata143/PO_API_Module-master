package com.sls.po.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.POTypeGHeader;
import com.sls.po.model.POTypeHHeader;

public interface POHeaderTypeHRepository extends CrudRepository<POTypeHHeader, Long> {

   List<POTypeHHeader> findByStatus(String status);
   
   @Query("SELECT t FROM POTypeHHeader t where t.mukam= ?1 AND t.supplierId = ?2")
   public  List<POTypeHHeader> findByMukamAndSupplierId(String mukam, String supplierId);
   
   @Query("SELECT t FROM POTypeHHeader t where  t.supplierId = ?1 AND t.status=?2" )
   public  List<POTypeHHeader> findBySupplierIdAndStatus( String supplierId, String status);


}
