package com.sls.po.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity()
@Table(name="ITEMMASTER")
public class Item {
	
	@Id
	@Column(name="ITEM_CODE")
	private String id;
	@Column(name = "ITEM_DESC")
	private String name;

	@Column(name = "CENTRAL_STOCK")
	private String stock;

	@Column(name = "GROUP_CODE")
	private String groupId;

	@Column(name = "HSN_CODE")
	private String hsnCode;

	@Column(name = "UOM_CODE")
	private String uomCode;

	@Column(name = "MAX_VALUE")
	private float maxValue;

	@Column(name = "MAX_ORDER_VALUE")
	private float maxOrderValue;

	@Column(name = "CENTRAL_STOCK_VALUE")
	private float centralStockValue;

	@Column(name = "LEGACY_ITEM_CODE")
	private String legacyItemCode;

	@Column(name = "MAKE")
	private String make;
	
	
	
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getLegacyItemCode() {
		return legacyItemCode;
	}

	public void setLegacyItemCode(String legacyItemCode) {
		this.legacyItemCode = legacyItemCode;
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



	@OneToMany(mappedBy="itemInStock",cascade = CascadeType.ALL, fetch = FetchType.EAGER)	   
    private List<ItemStock> itemStock;
	
	@OneToOne(mappedBy="itemInTax",cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = true)	   
    private ItemTax itemTax;

	@OneToOne(mappedBy="quantityInUnit",cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = true)	   
    private QuantityUnit quantityUnit;

	
	
	 public Item()
	    {
	        super();
	    }

	    public Item(String id, String name,String stock,String groupId,String hsnCode, List<ItemStock> itemStock,ItemTax itemTax,QuantityUnit quantityUnit,String legacyItemCode,float maxValue, float maxOrderValue, float centralStockValue, String make)
	    {
	        super();
	        this.id = id;
	        this.name = name;
	        this.stock=stock;
	        this.groupId=groupId;
	        this.hsnCode=hsnCode;
	        this.itemStock=itemStock;
	        this.itemTax=itemTax;
	        this.quantityUnit=quantityUnit;
	        this.legacyItemCode=legacyItemCode;
	        this.maxValue=maxValue;
	        this.maxOrderValue=maxOrderValue;
	        this.centralStockValue=centralStockValue;
	        this.make=make;
	        
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

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
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

	public String getUomCode() {
		return uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public QuantityUnit getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(QuantityUnit quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public float getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}
	
	
	
	


}
