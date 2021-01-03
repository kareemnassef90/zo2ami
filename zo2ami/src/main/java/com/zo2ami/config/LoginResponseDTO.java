package com.zo2ami.config;

import java.io.Serializable;

import com.zo2ami.dto.CommonDTOWithErrors;
import com.zo2ami.dto.CustomerDTO;
import com.zo2ami.enums.AccountType;

public class LoginResponseDTO extends CommonDTOWithErrors implements Serializable {

	private static final long serialVersionUID = 5776317649788860812L;
	
	private String jwttoken;
	
	private  AccountType accountType;
	
	private CustomerDTO customer;
	

	public LoginResponseDTO(){
		
	}
	
	public LoginResponseDTO(String token, AccountType accountType){
		this.jwttoken = token;
		this.accountType = accountType;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}


	public String getJwttoken() {
		return jwttoken;
	}


	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}


	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	

	

	
	
}
