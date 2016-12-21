package com.greenfinch.signup.model;

import javax.validation.constraints.Pattern;


public class User {

	@Pattern(regexp = "[A-Za-z0-9]{5,}")
	private String userName;

	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")
	private String password;

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

}
