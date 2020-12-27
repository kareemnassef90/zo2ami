package com.zo2ami.config;

import java.io.Serializable;

import com.zo2ami.enums.AccountType;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 5776317649788860812L;
	
	private final String jwttoken;
	
	private  AccountType accountType;

	public AccountType getAccountType() {
		return accountType;
	}

	public JwtResponse(String jwttoken, AccountType accountType ) {
		this.jwttoken = jwttoken;
		this.accountType = accountType;
	}

	public String getToken() {
		return this.jwttoken;
	}

	

	
	
}
