package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.IssueHeader;
import com.sls.po.model.MukamJute;

public interface MukamJuteRepository extends CrudRepository<MukamJute, Long> {
	
	 List<MukamJute> findByMukamId(long mukamId);

  
}
