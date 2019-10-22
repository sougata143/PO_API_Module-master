package com.sls.po.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.POTypeGHeader;
import com.sls.po.model.POTypeJHeader;

public interface POHeaderTypeJRepository extends CrudRepository<POTypeJHeader, Long> {

   List<POTypeJHeader> findByStatus(String status);
   
   @Query("SELECT t FROM POTypeJHeader t where t.mukam= ?1 AND t.supplierId = ?2")
   public  List<POTypeJHeader> findByMukamAndSupplierId(String mukam, String supplierId);
   
   @Query("SELECT t FROM POTypeJHeader t where  t.supplierId = ?1 AND t.status=?2" )
   public  List<POTypeJHeader> findBySupplierIdAndStatus( String supplierId, String status);


}
