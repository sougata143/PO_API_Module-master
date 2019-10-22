package com.sls.po.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity()
@Table(name="UOMMASTER")
public class QuantityUnit {
	
	@Id
	@Column(name="UOM_CODE")
	private  String id;
	@Column(name="UOM_DESC")
	private  String name ;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UOM_CODE")
	@JsonIgnore
	private Item quantityInUnit;
	
	
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
	public Item getQuantityInUnit() {
		return quantityInUnit;
	}
	public void setQuantityInUnit(Item quantityInUnit) {
		this.quantityInUnit = quantityInUnit;
	}	

}
