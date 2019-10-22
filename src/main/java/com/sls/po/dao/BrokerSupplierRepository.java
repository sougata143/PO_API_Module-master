package com.sls.po.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.BrokerSupplierMap;

public interface BrokerSupplierRepository extends CrudRepository<BrokerSupplierMap, Long> {

  List<BrokerSupplierMap> findByBrokerId(long brokerId);
  List<BrokerSupplierMap> findBySupplierCode(String supplierCode);
}
