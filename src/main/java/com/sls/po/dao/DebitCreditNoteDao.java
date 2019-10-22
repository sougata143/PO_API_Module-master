package com.sls.po.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sls.po.model.DebitCreditNotes;

@Component
public class DebitCreditNoteDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(DebitCreditNoteDao.class);
    @Autowired
    DataSource dataSource;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    DebitCreditNoteRepository drcrRepository;
    
    @Transactional
    public DebitCreditNotes saveDebitCreditNotes(DebitCreditNotes drcrnotes) {
    	return drcrRepository.save(drcrnotes);
    }
    
    @Transactional
    public void storedProc(String inReason, Float inQuantity, String inItemCode, Long inSrNum, String inSuppCode) {
    	String hql = 
    		"BEGIN ADJUST_DR_CR_PROC(:IN_REASON, :IN_QUANTITY, :IN_ITEM_CODE, :IN_SR_NUM, :IN_SUPP_CODE); END;";
    	entityManager.createNativeQuery(hql)
		.setParameter("IN_REASON", inReason)
		.setParameter("IN_QUANTITY", inQuantity)
		.setParameter("IN_ITEM_CODE", inItemCode)
		.setParameter("IN_SR_NUM", inSrNum)
		.setParameter("IN_SUPP_CODE", inSuppCode)
		.executeUpdate();
    }
	
}
