package com.sls.po.dao;



import com.sls.po.model.GoodReceiveHeader;
import java.util.List; 
import org.springframework.data.repository.CrudRepository;



public interface GoodReceiveHeaderRepository extends CrudRepository<GoodReceiveHeader, Long> {

   List<GoodReceiveHeader> findByStatus(String status);
   List<GoodReceiveHeader> findBySupplierId(String supplierId);
   List<GoodReceiveHeader> findByPoId(String poId);
   
   List<GoodReceiveHeader> findBychalanNo(long chalanNo);
   List<GoodReceiveHeader> findByStoreId(long storeId);
   


}
