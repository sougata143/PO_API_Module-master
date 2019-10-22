package com.sls.po.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity()

@Table(name="BROKER_SUPP_MAP")
public class BrokerSupplierMap {
	
	@Id	
	@Column(name="MAP_ID")
	private  long id;
	
	@Column(name="BROKER_ID")
	private  long brokerId;
	
	@Column(name="SUPP_CODE")
	private  String supplierCode;
	
	@Column(name="IS_MAPPED")
	private  String isMapped;

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(long brokerId) {
		this.brokerId = brokerId;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getIsMapped() {
		return isMapped;
	}

	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}
	
	

	
}
