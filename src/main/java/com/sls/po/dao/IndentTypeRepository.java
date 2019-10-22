package com.sls.po.dao;


import com.sls.po.model.IndentType;
import com.sls.po.model.Item;
import com.sls.po.model.ItemGroup;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface IndentTypeRepository extends CrudRepository<IndentType, String> {

	
//	List<Item> findByGroupId(String groupId);
//    List<Customer> findByEmail(String email);
//
//    @Query("select c from Customer c where c.email = :email")
//    Stream<Customer> findByEmailReturnStream(@Param("email") String email);
//
//    List<Customer> findByDate(Date date);

    //@Query("select c from Customer c")
    //Stream<Customer> findAllAndStream();

    //List<Customer> findByDateBetween(Date from, Date to);

}
