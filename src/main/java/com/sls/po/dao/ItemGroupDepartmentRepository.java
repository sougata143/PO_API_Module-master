package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.ItemGroupDepartmentMap;

public interface ItemGroupDepartmentRepository extends CrudRepository<ItemGroupDepartmentMap, String> {
	
	List<ItemGroupDepartmentMap> findByDeparmentId(long deparmentId);


}
