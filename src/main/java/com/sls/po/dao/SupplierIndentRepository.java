package com.sls.po.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.po.model.SupplierIndent;

public interface SupplierIndentRepository extends JpaRepository<SupplierIndent, Long> {

   List<SupplierIndent> findByIndentHeaderId(String indentHeaderId);
   
   List<SupplierIndent> findBySupplierCode(String supplierCode);
   List<SupplierIndent> findByType(String type);
   List<SupplierIndent> findByid(long id);
   List<SupplierIndent> findBySupplierCodeAndIndentHeaderId(String suppCode, String indentNo);
   SupplierIndent findBySupplierCodeAndId(String supplierCode, Long id);
}
