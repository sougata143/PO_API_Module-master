package com.sls.po.dao;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sls.po.model.IssueHeader;

public interface IssueHeaderRepository extends JpaRepository<IssueHeader, Long> {

   List<IssueHeader> findByDeptId(String deptId);
   List<IssueHeader> findByUnitId(String unitId);
   List<IssueHeader> findByStatus(String status);
   List<IssueHeader> findByLastModifiedDateBetween(Date startdate, Date enddate);
   @Query("select i from IssueHeader i where i.lastModifiedDate <= :startdate and i.lastModifiedDate >= :enddate")
   List<IssueHeader> findByModOnRange(@Param("startdate") Date startdate, @Param("enddate") Date enddate);

}
