package com.sls.po.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity()
@Table(name="SCM_INDENT_TYPE_MASTER")
public class IndentType {
	
	@Id
	@Column(name="INDENT_TYPE_ID")
	private  String id;
	@Column(name="INDENT_TYPE_DESC")
	private  String name ;
	
	@Column(name="INDENT_TYPE_CODE")
	private  String code;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	


}
