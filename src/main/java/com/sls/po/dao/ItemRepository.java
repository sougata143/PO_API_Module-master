package com.sls.po.dao;


import com.sls.po.model.Item;
import com.sls.po.model.ItemGroup;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface ItemRepository extends CrudRepository<Item, String> {

	Item findByName(String name);
	List<Item> findByGroupId(String groupId);

}
