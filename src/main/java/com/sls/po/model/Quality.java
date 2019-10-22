package com.sls.po.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="JUTE_QUALITY_PRICE_MASTER")
public class Quality {	
	
	@Id
	@Column(name="ID")
	private  long id;
	
	@Column(name="ITEM_CODE")
	private  String itemCode ;
	
	@Column(name="JUTE_QUALITY")
	private  String name ;
	
	@Column(name="RATE")
	private  float rate ;
	
	@Column(name="CURRENCY")
	private  String currency ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	

}
