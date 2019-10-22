package com.sls.po.bo;

import java.util.List;

import com.sls.po.model.Item;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.ItemMaterialStock;
import com.sls.po.model.Items;

public interface ItemBo {
	public Items getAllItemBygroupId( String groupId) ;
	
	public Item getItemById(String itemId) ;
	public ItemMaterialStock getStockByItemIdAndQualityCode(String itemId,String qualityCode);

	public Items getAllItemByMukam(long mukamId);
	
	public List<ItemGroup> getAllItemGroupsByDepartmentId(long deparmentId);
}
