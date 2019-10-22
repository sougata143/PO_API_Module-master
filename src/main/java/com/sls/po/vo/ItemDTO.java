package com.sls.po.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.sls.po.model.ItemStock;
import com.sls.po.model.ItemTax;
import com.sls.po.model.QuantityUnit;

public class ItemDTO {

	private String id;
	private String name;
	private String stock;
	private String groupId;
	private String hsnCode;
	private String uomCode;
	private float maxValue;
	private float maxOrderValue;
	private float centralStockValue;
	private String legacyItemCode;
	private String make;
	private List<ItemStock> itemStock;
	private ItemTax itemTax;
	private QuantityUnit quantityUnit;
	private float avgConsumption;

	
	public float getAvgConsumption() {
		return avgConsumption;
	}

	public void setAvgConsumption(float avgConsumption) {
		this.avgConsumption = avgConsumption;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getUomCode() {
		return uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public float getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}

	public float getMaxOrderValue() {
		return maxOrderValue;
	}

	public void setMaxOrderValue(float maxOrderValue) {
		this.maxOrderValue = maxOrderValue;
	}

	public float getCentralStockValue() {
		return centralStockValue;
	}

	public void setCentralStockValue(float centralStockValue) {
		this.centralStockValue = centralStockValue;
	}

	public String getLegacyItemCode() {
		return legacyItemCode;
	}

	public void setLegacyItemCode(String legacyItemCode) {
		this.legacyItemCode = legacyItemCode;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public List<ItemStock> getItemStock() {
		return itemStock;
	}

	public void setItemStock(List<ItemStock> itemStock) {
		this.itemStock = itemStock;
	}

	public ItemTax getItemTax() {
		return itemTax;
	}

	public void setItemTax(ItemTax itemTax) {
		this.itemTax = itemTax;
	}

	public QuantityUnit getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(QuantityUnit quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

}
