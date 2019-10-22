package com.sls.po.vo;

import java.util.List;

import com.sls.po.model.GoodReceiveHeader;
import com.sls.po.model.IndentHeader;
import com.sls.po.model.POHeader;

public class GoodReceiveDetails {
	
	private GoodReceiveHeader goodReceiveHeader;
	private List<GoodReceiveItemVo> grnItemList;
	public GoodReceiveHeader getGoodReceiveHeader() {
		return goodReceiveHeader;
	}
	public void setGoodReceiveHeader(GoodReceiveHeader goodReceiveHeader) {
		this.goodReceiveHeader = goodReceiveHeader;
	}
	public List<GoodReceiveItemVo> getGrnItemList() {
		return grnItemList;
	}
	public void setGrnItemList(List<GoodReceiveItemVo> grnItemList) {
		this.grnItemList = grnItemList;
	}
	
	
	
	

}
