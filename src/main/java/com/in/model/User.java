package com.in.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name="user")

public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sid")
	private int sid;
	
	@Column(name="lastname",nullable=false)
	private String lastname;
	
	@Column(name="firstname",nullable=false)
	private String firstname;
	
	@Column(name="username",unique=true,nullable=false)
	private String username;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="useremail",unique=true,nullable=false)
	private String useremail;
	
	@Column(name="otp")
	private String otp;
	
	@Column(name="active_status")
	private int activeStatus;
	
	@Column(name="activation_session")
	private String activationSession;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	

	public String getActivationSession() {
		return activationSession;
	}

	public void setActivationSession(String activationSession) {
		this.activationSession = activationSession;
	}

	@Override
	public String toString() {
		return "User [lastname=" + lastname + ", firstname=" + firstname + ", username=" + username + ", password="
				+ password + ", useremail=" + useremail + "]";
	}

	public User(){
		
	}
	
	
}
