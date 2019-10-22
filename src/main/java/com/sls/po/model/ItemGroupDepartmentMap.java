package com.sls.po.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(name="ITEM_GRP_DEPT_MAP")
public class ItemGroupDepartmentMap {
	
	@Id	
	@Column(name="MAP_ID")
	private  long id;
	
	@Column(name="ITEM_GRP")
	private  String itemGroupCode;
	
	@Column(name="DEPT_ID")
	private  long deparmentId;
	
	@Column(name="IS_MAPPED")
	private  String isMapped;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemGroupCode() {
		return itemGroupCode;
	}

	public void setItemGroupCode(String itemGroupCode) {
		this.itemGroupCode = itemGroupCode;
	}

	public long getDeparmentId() {
		return deparmentId;
	}

	public void setDeparmentId(long deparmentId) {
		this.deparmentId = deparmentId;
	}

	public String getIsMapped() {
		return isMapped;
	}

	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}
	
	


}
