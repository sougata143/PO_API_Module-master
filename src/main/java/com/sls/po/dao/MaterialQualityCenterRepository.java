package com.sls.po.dao;


import com.sls.po.model.Item;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.ItemMaterialStock;
import com.sls.po.model.ItemStock;
import com.sls.po.model.JuteQualityEntryHeader;
import com.sls.po.model.StoreGoodReceiveLineItem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface MaterialQualityCenterRepository extends CrudRepository<JuteQualityEntryHeader, Long> {

	
	List<JuteQualityEntryHeader> findByMrNo(long mrNo);
	List<JuteQualityEntryHeader> findByPoNo(String poNo);
	
	 @Query("SELECT t FROM JuteQualityEntryHeader t where t.poNo = ?1 AND t.poLineItemId = ?2 ")
	  public  List<JuteQualityEntryHeader> findByPoNoAndPoLineItemId(String poNo,long poLineItemId);

}
