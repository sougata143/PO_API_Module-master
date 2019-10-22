package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.IndentHeaderTypeH;
import com.sls.po.model.IndentHeaderTypeW;

public interface IndentHeaderTypeWRepository extends CrudRepository<IndentHeaderTypeW, String> {

   List<IndentHeaderTypeW> findByStatus(String status);
   List<IndentHeaderTypeW> findByMukam(String mukam);
   
  
}
