package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.IndentHeaderTypeG;
import com.sls.po.model.IndentHeaderTypeM;

public interface IndentHeaderTypeMRepository extends CrudRepository<IndentHeaderTypeM, String> {

   List<IndentHeaderTypeM> findByStatus(String status);
   List<IndentHeaderTypeM> findByMukam(String mukam);
   
  
}
