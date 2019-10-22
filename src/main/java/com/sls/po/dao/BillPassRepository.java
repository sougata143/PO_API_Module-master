package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.BillPass;
import com.sls.po.model.JuteGRNEntry;
import com.sls.po.model.StoreGRNEntry;

public interface BillPassRepository extends CrudRepository<BillPass, Long> {

   List<BillPass> findBySupplierCode(String supplierCode);
   List<BillPass> findByGrnNo(long grnNo);
   List<BillPass> findByBillNo(String billNo);
   List<BillPass> findByPoId(String poId);
   


}
