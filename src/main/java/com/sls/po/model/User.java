package com.sls.po.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class User implements Serializable {
    
    

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "USER_LOGIN_ID")
    private String userName;

  

    @Column(name = "PASSWORD")
    private String password;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

  


    

   

}
