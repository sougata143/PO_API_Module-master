package com.sls.po.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="MUKAM")
public class Mukam {	
	
	@Id
	@Column(name="MUKAM_ID")
	private  long mukamId;
	
	@Column(name="MUKAM_NAME")
	private  String mukamName ;

	public long getMukamId() {
		return mukamId;
	}

	public void setMukamId(long mukamId) {
		this.mukamId = mukamId;
	}

	public String getMukamName() {
		return mukamName;
	}

	public void setMukamName(String mukamName) {
		this.mukamName = mukamName;
	}
	
	
	
	

}
