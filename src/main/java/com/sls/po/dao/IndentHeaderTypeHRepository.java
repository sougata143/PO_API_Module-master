package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.IndentHeaderTypeG;
import com.sls.po.model.IndentHeaderTypeH;

public interface IndentHeaderTypeHRepository extends CrudRepository<IndentHeaderTypeH, String> {

   List<IndentHeaderTypeH> findByStatus(String status);
   List<IndentHeaderTypeH> findByMukam(String mukam);
   
  
}
