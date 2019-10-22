package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.IndentHeaderTypeG;

public interface IndentHeaderTypeGRepository extends CrudRepository<IndentHeaderTypeG, String> {

   List<IndentHeaderTypeG> findByStatus(String status);
   List<IndentHeaderTypeG> findByMukam(String mukam);
   
  
}
