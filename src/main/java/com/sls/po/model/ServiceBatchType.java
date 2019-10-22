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
@Table(name="SCM_BATCH_MASTER")

public class ServiceBatchType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERVICE_BATCH_SEQ")
    @SequenceGenerator(sequenceName = "SCM_SERVICE_BATCH_SEQ", allocationSize = 1, name = "SERVICE_BATCH_SEQ")
	@Column(name="ID")
	private  long id;
	
	@Column(name="SERVICE_TYPE")
	private  String serviceType ;
	
	@Column(name="SERVICE_DESC")
	private  String serviceDesc ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceDesc() {
		return serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}
	
	
	

}
