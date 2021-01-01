package com.zo2ami.dto;

import java.io.Serializable;

public class PermissionDTO implements Serializable {

	private static final long serialVersionUID = -9066684024202248842L;

	private long id;
	
	private String code;
	
	
	
	
	PermissionDTO(long id, String code){
		this.id = id;
		this.code = code;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}
