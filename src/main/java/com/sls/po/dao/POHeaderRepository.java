package com.sls.po.dao;


import com.sls.po.model.Department;
import com.sls.po.model.IndentHeader;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.MaterialGoodReceiveLineItem;
import com.sls.po.model.POHeader;
import com.sls.po.model.QuantityUnit;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface POHeaderRepository extends CrudRepository<POHeader, String> {

   List<POHeader> findByStatus(String status);
   
   @Query("SELECT t FROM POHeader t where t.mukam= ?1 AND t.supplierId = ?2")
   public  List<POHeader> findByMukamAndSupplierId(String mukam, String supplierId);
   
   @Query("SELECT t FROM POHeader t where  t.supplierId = ?1 AND t.status=?2" )
   public  List<POHeader> findBySupplierIdAndStatus( String supplierId, String status);


}
