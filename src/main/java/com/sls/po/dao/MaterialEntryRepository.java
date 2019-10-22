package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.JuteEntryHeader;

public interface MaterialEntryRepository extends CrudRepository<JuteEntryHeader, Long> {

	
	List<JuteEntryHeader> findByChalanNo(long chalanNo);
	List<JuteEntryHeader> findByChalanNoAndSuppCodeAndPoNo(long chalanNo, String suppCode, String poNo);
	
}
