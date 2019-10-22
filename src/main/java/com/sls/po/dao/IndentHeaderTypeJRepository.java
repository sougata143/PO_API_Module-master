package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.IndentHeaderTypeG;
import com.sls.po.model.IndentHeaderTypeJ;

public interface IndentHeaderTypeJRepository extends CrudRepository<IndentHeaderTypeJ, String> {

   List<IndentHeaderTypeJ> findByStatus(String status);
   List<IndentHeaderTypeJ> findByMukam(String mukam);
   
  
}
