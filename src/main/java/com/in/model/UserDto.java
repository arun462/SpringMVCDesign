package com.in.model;

import java.util.List;

public class UserDto {
	
	private String lastname;
	private String firstname;
	private String username;
	private String password;
	private String useremail;
		
	
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
	@Override
	public String toString() {
		return "UserDto [lastname=" + lastname + ", firstname=" + firstname + ", username=" + username + ", password="
				+ password + ", useremail=" + useremail + "]";
	}
	
	

}
