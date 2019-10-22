package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.JuteGRNEntry;

public interface JuteGRNEntryRepository extends CrudRepository<JuteGRNEntry, Long> {

   List<JuteGRNEntry> findByChalanNo(Long chalanNo);
   List<JuteGRNEntry> findByPoId(String poId);
   List<JuteGRNEntry> findBySuppCodeAndChalanNo(String suppCode, long chalanNo);
   List<JuteGRNEntry> findBySuppCode(String suppCode);
   JuteGRNEntry findByMrNo(long mrNo);
}
