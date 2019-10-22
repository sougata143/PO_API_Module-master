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
@Table(name="QC_JUTE_SAMPLE_CHECK_FOR_MR")

public class JuteQualityEntryHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JUTE_QC_SEQ")
    @SequenceGenerator(sequenceName = "SCM_QC_JUTE_SEQ", allocationSize = 1, name = "JUTE_QC_SEQ")
	@Column(name="SRL_NUM")
	private  long id;
	
	@Column(name="CHALLAN_NO")
	private  long chalanNo;
	
	@Column(name="MR_NO")
	private  long mrNo;
	
	@Column(name="PO_NO")
	private  String poNo;
	
	@Column(name="PO_LINE_ITEM_NUM")
	private  long poLineItemId;	
	
	@Column(name="ADVISED_JUTE_TYPE")
	private  String advisedJuteType ;
	
	@Column(name="ACTUAL_JUTE_TYPE")
	private  String actualJuteType ;
	
	@Column(name="ADVISED_QUALITY")
	private  String advisedQuality ;
	
	@Column(name="ACTUAL_QUALITY")
	private  String actualQuality  ;
	
	@Column(name="ADVISED_QUANTITY")
	private  float advisedQuantity ;
	
	@Column(name="ACTUAL_QUANTITY")
	private  float actualQuantity  ;
	
	@Column(name="READING")
	private  float reading  ;

	
	@Column(name="CREARED_BY")
	private  String createUser ;
	
	@Column(name="CREATED_ON")
	private  Date createDate ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getChalanNo() {
		return chalanNo;
	}

	public void setChalanNo(long chalanNo) {
		this.chalanNo = chalanNo;
	}

	public long getMrNo() {
		return mrNo;
	}

	public void setMrNo(long mrNo) {
		this.mrNo = mrNo;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public long getPoLineItemId() {
		return poLineItemId;
	}

	public void setPoLineItemId(long poLineItemId) {
		this.poLineItemId = poLineItemId;
	}

	public String getAdvisedJuteType() {
		return advisedJuteType;
	}

	public void setAdvisedJuteType(String advisedJuteType) {
		this.advisedJuteType = advisedJuteType;
	}

	public String getActualJuteType() {
		return actualJuteType;
	}

	public void setActualJuteType(String actualJuteType) {
		this.actualJuteType = actualJuteType;
	}

	public String getAdvisedQuality() {
		return advisedQuality;
	}

	public void setAdvisedQuality(String advisedQuality) {
		this.advisedQuality = advisedQuality;
	}

	public String getActualQuality() {
		return actualQuality;
	}

	public void setActualQuality(String actualQuality) {
		this.actualQuality = actualQuality;
	}

	public float getAdvisedQuantity() {
		return advisedQuantity;
	}

	public void setAdvisedQuantity(float advisedQuantity) {
		this.advisedQuantity = advisedQuantity;
	}

	public float getActualQuantity() {
		return actualQuantity;
	}

	public void setActualQuantity(float actualQuantity) {
		this.actualQuantity = actualQuantity;
	}

	public float getReading() {
		return reading;
	}

	public void setReading(float reading) {
		this.reading = reading;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	


}
