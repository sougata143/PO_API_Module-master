package com.sls.po.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.ReportCounter;

public interface ReportCounterRepository extends CrudRepository<ReportCounter, Long> {
	
	
	 @Query("SELECT t FROM ReportCounter t where t.type = ?1 AND t.id = ?2 ")
	  public  List<ReportCounter> findByTypeAndId(String type,String id);
	
}
