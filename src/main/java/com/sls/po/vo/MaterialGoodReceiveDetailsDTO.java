package com.sls.po.vo;

import java.util.List;

import com.sls.po.model.MaterialGoodReceiveHeader;

public class MaterialGoodReceiveDetailsDTO {

	private MaterialGoodReceiveHeaderDTO materialGoodReceiveHeader;
	private List<MaterialGoodReceiveItemVo> materialGrnItemList;
	public MaterialGoodReceiveHeaderDTO getMaterialGoodReceiveHeader() {
		return materialGoodReceiveHeader;
	}
	public void setMaterialGoodReceiveHeader(MaterialGoodReceiveHeaderDTO materialGoodReceiveHeader) {
		this.materialGoodReceiveHeader = materialGoodReceiveHeader;
	}
	public List<MaterialGoodReceiveItemVo> getMaterialGrnItemList() {
		return materialGrnItemList;
	}
	public void setMaterialGrnItemList(List<MaterialGoodReceiveItemVo> materialGrnItemList) {
		this.materialGrnItemList = materialGrnItemList;
	}
	
	
	
}
