package com.sls.po.dao;


import com.sls.po.model.Department;
import com.sls.po.model.IndentHeader;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.MaterialGoodReceiveLineItem;
import com.sls.po.model.QuantityUnit;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface IndentHeaderRepository extends CrudRepository<IndentHeader, String> {

   List<IndentHeader> findByStatus(String status);
   List<IndentHeader> findByMukam(String mukam);
   
  
}
