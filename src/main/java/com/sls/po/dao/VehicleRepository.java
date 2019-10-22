package com.sls.po.dao;


import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

  
}
