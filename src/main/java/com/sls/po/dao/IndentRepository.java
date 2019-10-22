package com.sls.po.dao;


import com.sls.po.model.Department;
import com.sls.po.model.Indent;
import com.sls.po.model.IndentHeader;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.QuantityUnit;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface IndentRepository extends CrudRepository<Indent, Long> {

   List<Indent> findByIndentHeaderId(String indentHeaderId);
   Indent findByIndentHeaderIdAndItemId(String indentId, String itemCode);
//
//    @Query("select c from Customer c where c.email = :email")
//    Stream<Customer> findByEmailReturnStream(@Param("email") String email);
//
//    List<Customer> findByDate(Date date);

    //@Query("select c from Customer c")
    //Stream<Customer> findAllAndStream();

    //List<Customer> findByDateBetween(Date from, Date to);

}
