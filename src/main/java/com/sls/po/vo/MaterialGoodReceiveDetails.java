package com.sls.po.vo;

import java.util.List;

import com.sls.po.model.GoodReceiveHeader;
import com.sls.po.model.IndentHeader;
import com.sls.po.model.MaterialGoodReceiveHeader;
import com.sls.po.model.POHeader;

public class MaterialGoodReceiveDetails {
	
	private MaterialGoodReceiveHeader materialGoodReceiveHeader;
	private List<MaterialGoodReceiveItemVo> materialGrnItemList;
	
	public MaterialGoodReceiveHeader getMaterialGoodReceiveHeader() {
		return materialGoodReceiveHeader;
	}
	public void setMaterialGoodReceiveHeader(MaterialGoodReceiveHeader materialGoodReceiveHeader) {
		this.materialGoodReceiveHeader = materialGoodReceiveHeader;
	}
	public List<MaterialGoodReceiveItemVo> getMaterialGrnItemList() {
		return materialGrnItemList;
	}
	public void setMaterialGrnItemList(List<MaterialGoodReceiveItemVo> materialGrnItemList) {
		this.materialGrnItemList = materialGrnItemList;
	}
	
	
	
	

}
