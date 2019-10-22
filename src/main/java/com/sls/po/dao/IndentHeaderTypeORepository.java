package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.IndentHeaderTypeG;
import com.sls.po.model.IndentHeaderTypeO;

public interface IndentHeaderTypeORepository extends CrudRepository<IndentHeaderTypeO, String> {

   List<IndentHeaderTypeO> findByStatus(String status);
   List<IndentHeaderTypeO> findByMukam(String mukam);
   
  
}
