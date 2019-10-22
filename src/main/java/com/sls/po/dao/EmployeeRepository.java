package com.sls.po.dao;


import org.springframework.data.repository.CrudRepository;

import com.sls.po.model.Employee;



public interface EmployeeRepository extends CrudRepository<Employee,Integer>
{

}
