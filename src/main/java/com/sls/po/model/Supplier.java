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

@Table(name="SUPPLIERMASTER")
public class Supplier {
	
	@Id	
	@Column(name="SUPP_CODE")
	private  String id;
	
	@Column(name="SUPP_NAME")
	private  String name;
	
	@Column(name="ADDRESS_1")
	private  String address1;
	
	@Column(name="ADDRESS_2")
	private  String address2;
	
	@Column(name="ADDRESS_3")
	private  String address3;
	
	
	@Column(name="SUPP_TYPE")
	private  String type;
	
	@Column(name="PHONE_1")
	private  String phone1;
	
	@Column(name="PHONE_2")
	private  String phone2;
	
	@Column(name="FAX")
	private  String fax;
	
	
	@Column(name="CELL_PHONE")
	private  String cellPhone;
	
	@Column(name="EMAIL")
	private  String email;
	
	@Column(name="SALETAXNO")
	private  String sellTaxNo;
	
	@Column(name="BLACK_LISTED_TAG")
	private  String blackListedTag;
	
	@Column(name="BLACK_LISTED_DATE")
	private  Date blackListedDate;
	
	@Column(name="VATNO")
	private  String vatNo;
	
	
	@Column(name="CONTACT_PERSON")
	private  String contactPerson;
	
	@Column(name="DESIGNATION")
	private  String designation;
	
	@Column(name="CST")
	private  String  cst;
	
	@Column(name="CIN")
	private  String cin;
	
	@Column(name="GSTNO")
	private  String gstNo;
	
	@Column(name="PANNO")
	private  String panNo;
	
	@Column(name="DISTRICT")
	private  String district;
	
	@Column(name="STATE")
	private  String state;
	
	@Column(name="COUNTRY")
	private  String country;
	
	@Column(name="PINCODE")
	private  int pinCode;
	
	

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

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

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSellTaxNo() {
		return sellTaxNo;
	}

	public void setSellTaxNo(String sellTaxNo) {
		this.sellTaxNo = sellTaxNo;
	}

	public String getBlackListedTag() {
		return blackListedTag;
	}

	public void setBlackListedTag(String blackListedTag) {
		this.blackListedTag = blackListedTag;
	}

	public Date getBlackListedDate() {
		return blackListedDate;
	}

	public void setBlackListedDate(Date blackListedDate) {
		this.blackListedDate = blackListedDate;
	}

	public String getVatNo() {
		return vatNo;
	}

	public void setVatNo(String vatNo) {
		this.vatNo = vatNo;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCst() {
		return cst;
	}

	public void setCst(String cst) {
		this.cst = cst;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	
	
}
