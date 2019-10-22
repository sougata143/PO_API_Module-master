package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.ServiceBatchType;

public interface ServiceBatchRepository extends CrudRepository<ServiceBatchType, Long> {

   List<ServiceBatchType> findByServiceType(String serviceType);
   


}
