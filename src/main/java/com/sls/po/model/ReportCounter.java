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
@Table(name="SCM_REPORT_COUNTER")

public class ReportCounter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_COUNTER_SEQ")
    @SequenceGenerator(sequenceName = "SCM_REPORT_COUNTER_SEQ", allocationSize = 1, name = "REPORT_COUNTER_SEQ")
	@Column(name="SERIAl_NO")
	private  long serialNo;
	
	@Column(name="TYPE")
	private  String type ;
	
	@Column(name="ID")
	private  String id ;
	
	@Column(name="COUNTER")
	private  long counter ;

	public long getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(long serialNo) {
		this.serialNo = serialNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getCounter() {
		return counter;
	}

	public void setCounter(long counter) {
		this.counter = counter;
	}	
	
	


}
