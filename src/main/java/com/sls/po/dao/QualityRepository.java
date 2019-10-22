package com.sls.po.dao;

import com.sls.po.model.Quality;

import java.util.List;
import org.springframework.data.repository.CrudRepository;



public interface QualityRepository extends CrudRepository<Quality, Long> {

	List<Quality> findByItemCode(String itemCode);
	List<Quality> findByName(String name);

}
