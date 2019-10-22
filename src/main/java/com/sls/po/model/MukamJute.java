package com.sls.po.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="MUKAM_JUTE_MAP")
public class MukamJute {	
	
	@Id
	@Column(name="MAPPING_ID")
	private  long id;
	
	@Column(name="MUKAM_ID")
	private  long mukamId;
	
	@Column(name="ITEM_CODE_JUTE")
	private  String ItemJuteCode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMukamId() {
		return mukamId;
	}

	public void setMukamId(long mukamId) {
		this.mukamId = mukamId;
	}

	public String getItemJuteCode() {
		return ItemJuteCode;
	}

	public void setItemJuteCode(String itemJuteCode) {
		ItemJuteCode = itemJuteCode;
	}

	

}
