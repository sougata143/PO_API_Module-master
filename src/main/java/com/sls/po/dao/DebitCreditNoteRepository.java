package com.sls.po.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.po.model.DebitCreditNotes;

public interface DebitCreditNoteRepository extends JpaRepository<DebitCreditNotes, Long> {

   List<DebitCreditNotes> findBySupplierCode(String supplierCode);
   List<DebitCreditNotes> findByGrnNo(long grnNo);


}
