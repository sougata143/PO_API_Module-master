package com.sls.po.vo;

import java.util.List;

import com.sls.po.model.IndentHeader;
import com.sls.po.model.POHeader;

public class PODetails {
	
	private POHeader poHeader;
	private List<PoItemVo> poItemList;
	public POHeader getPoHeader() {
		return poHeader;
	}
	public void setPoHeader(POHeader poHeader) {
		this.poHeader = poHeader;
	}
	public List<PoItemVo> getPoItemList() {
		return poItemList;
	}
	public void setPoItemList(List<PoItemVo> poItemList) {
		this.poItemList = poItemList;
	}
	
	
	

}
