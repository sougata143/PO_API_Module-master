package com.sls.po.dao;


import com.sls.po.model.ItemGroup;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface ItemGroupRepository extends CrudRepository<ItemGroup, String> {


}
