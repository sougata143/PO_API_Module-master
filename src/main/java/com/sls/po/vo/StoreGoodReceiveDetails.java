package com.sls.po.vo;

import java.util.List;

import com.sls.po.model.GoodReceiveHeader;
import com.sls.po.model.IndentHeader;
import com.sls.po.model.POHeader;
import com.sls.po.model.StoreGoodReceiveHeader;

public class StoreGoodReceiveDetails {
	
	private StoreGoodReceiveHeader storeGoodReceiveHeader;
	private List<StoreGoodReceiveItemVo> storeGrnItemList;
	public StoreGoodReceiveHeader getStoreGoodReceiveHeader() {
		return storeGoodReceiveHeader;
	}
	public void setStoreGoodReceiveHeader(StoreGoodReceiveHeader storeGoodReceiveHeader) {
		this.storeGoodReceiveHeader = storeGoodReceiveHeader;
	}
	public List<StoreGoodReceiveItemVo> getStoreGrnItemList() {
		return storeGrnItemList;
	}
	public void setStoreGrnItemList(List<StoreGoodReceiveItemVo> storeGrnItemList) {
		this.storeGrnItemList = storeGrnItemList;
	}
	
	
	
	

}
