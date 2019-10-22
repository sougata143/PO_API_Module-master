package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.IndentHeaderTypeG;
import com.sls.po.model.IndentHeaderTypeP;

public interface IndentHeaderTypePRepository extends CrudRepository<IndentHeaderTypeP, String> {

   List<IndentHeaderTypeP> findByStatus(String status);
   List<IndentHeaderTypeP> findByMukam(String mukam);
   
  
}
