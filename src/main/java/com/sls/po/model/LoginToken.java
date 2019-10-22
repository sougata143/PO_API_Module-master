package com.sls.po.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity()
@Table(name="USER_LOGIN_DETAILS")
public class LoginToken {
	
	@Id
	@Column(name="LOGIN_TOKEN")
	private  String tokenId;
	@Column(name="USER_ID")
	private  String userId ;
	@Column(name="USER_LOGIN_ID")
	private  String loginId ;
	
	@Column(name="FIRST_NAME")
	private  String firstName ;
	
	@Column(name="LAST_NAME")
	private  String lastName ;
		
	@Column(name="IS_ACTIVE")
	private  String isActive;
	
	@Column(name="COUNTER")
	private  int counter;
	
	@Column(name="CREATE_DATE")
	private  Date createDate;
	
	@Column(name="LAST_MODIFIED_DATE")
	private  Date lastModifiedDate;

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	

	
}
