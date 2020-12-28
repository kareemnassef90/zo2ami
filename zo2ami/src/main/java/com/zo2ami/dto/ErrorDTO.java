package com.zo2ami.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.zo2ami.enums.ErrorCodes;

@JsonInclude(Include.NON_NULL)
public class ErrorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String errorCode;
	
	private String errorMessage;

	public ErrorDTO(ErrorCodes error) {
		this.errorCode = error.getCode();
		this.errorMessage = error.getMessage();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	
	}