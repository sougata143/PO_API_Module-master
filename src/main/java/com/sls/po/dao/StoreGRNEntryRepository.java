package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.JuteGRNEntry;
import com.sls.po.model.StoreGRNEntry;

public interface StoreGRNEntryRepository extends CrudRepository<StoreGRNEntry, Long> {

   List<StoreGRNEntry> findByChalanNo(Long chalanNo);
   List<StoreGRNEntry> findByPoId(String poId);
   List<StoreGRNEntry> findBySuppCodeAndPoId(String suppCode, String poId);
   List<StoreGRNEntry> findByChalanNoAndSuppCode(long chalanNo, String suppCode);
   List<StoreGRNEntry> findByChalanNoAndSuppCodeAndPoId(long chalanNo, String suppCode, String poId);
   List<StoreGRNEntry>  findBySuppCode(String suppCode);
   
}
