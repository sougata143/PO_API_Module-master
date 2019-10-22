package com.sls.po.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetail implements Serializable {
    
   private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USER_DETAILS_SEQ")
    @SequenceGenerator(name="USER_DETAILS_SEQ", sequenceName="USER_DETAILS_SEQ")
    private Long userCount;

    @Column(name = "USER_LOGIN_ID")
    private String userName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "FROM_DATE")
    private Date fromDate;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "DOB")
    private Date dateOfBirth;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ALTR_EMAIL")
    private String alternateEmail;

    @Column(name = "MOBILE")
    private Long mobile;

    @Column(name = "END_DATE")
    private Date endDate;

   
    @Column(name = "TYPE_OF_EMP")
    private String typeOfEmployment;

    @Column(name = "IS_ENABLE")
    private Long isEnabled;

    @Column(name = "USER_IMG")
    private Blob userImg;

    @Column(name = "MOD_BY")
    private String modifiedBy;

    @Column(name = "MOD_DT")
    private Date modifiedOn;
    
    @Column(name = "PERM_ADDR")
    private String permAddr;

    /*@ManyToOne
    @JoinColumn(name="STATE",insertable = false, updatable = false)
    private State state;*/
    
    @Column(name = "STATE")
    private String state;
    
    /*@ManyToOne
    @JoinColumn(name="CITY")
    private City city;*/
    
    @Column(name = "CITY")
    private String city;
    
    /*@ManyToOne
    @JoinColumn(name="COUNTRY")
    private Country country;*/
    
    @Column(name = "COUNTRY")
    private String country;
    
    @Column(name = "ZIP")
    private String zip;
    
    @Column(name = "FATHER")
    private String fatherName;
    
    @Column(name = "SPOUSE")
    private String spouseName;
    
    @Column(name = "PASSPORT")
    private String passport;
    
   
    @Column(name="EPF_NO")
    private String epfNo;
    
    @Column(name="ESI_NO")
    private String esiNo;
    
    
    
    
    
    
	/*public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}*/

	public String getEpfNo() {
		return epfNo;
	}

	public void setEpfNo(String epfNo) {
		this.epfNo = epfNo;
	}

	public String getEsiNo() {
		return esiNo;
	}

	public void setEsiNo(String esiNo) {
		this.esiNo = esiNo;
	}


    

    public Long getUserCount() {
		return userCount;
	}

	public void setUserCount(Long userCount) {
		this.userCount = userCount;
	}

	public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public Date getFromDate() {
	return fromDate;
    }

    public void setFromDate(Date fromDate) {
	this.fromDate = fromDate;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getGender() {
	return gender;
    }

    public void setGender(String gender) {
	this.gender = gender;
    }

    public Date getDateOfBirth() {
	return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getAlternateEmail() {
	return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
	this.alternateEmail = alternateEmail;
    }

    public Long getMobile() {
	return mobile;
    }

    public void setMobile(Long mobile) {
	this.mobile = mobile;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    

   

    public String getTypeOfEmployment() {
	return typeOfEmployment;
    }

    public void setTypeOfEmployment(String typeOfEmployment) {
	this.typeOfEmployment = typeOfEmployment;
    }

    public Long getIsEnabled() {
	return isEnabled;
    }

    public void setIsEnabled(Long isEnabled) {
	this.isEnabled = isEnabled;
    }

    public Blob getUserImg() {
	return userImg;
    }

    public void setUserImg(Blob userImg) {
	this.userImg = userImg;
    }

    public String getModifiedBy() {
	return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
	return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
	this.modifiedOn = modifiedOn;
    }

    
    public String getPermAddr() {
        return permAddr;
    }

    public void setPermAddr(String permAddr) {
        this.permAddr = permAddr;
    }
    
    

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

  

    

   
}
