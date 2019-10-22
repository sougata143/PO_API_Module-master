package com.sls.po.model;

import java.util.List;

import com.sls.po.vo.ItemDTO;

public class Items {

	private ItemGroup item_Group;
	private List<ItemDTO> items;
	public ItemGroup getItem_Group() {
		return item_Group;
	}
	public void setItem_Group(ItemGroup item_Group) {
		this.item_Group = item_Group;
	}
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	
}
