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
@Table(name="ITEM_GROUP_MASTER")
public class ItemGroup {
	
	@Id
	@Column(name="GROUP_CODE")
	private  String id;
	@Column(name="GROUP_DESC")
	private  String name ;
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

}
