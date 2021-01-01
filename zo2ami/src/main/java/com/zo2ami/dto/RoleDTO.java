package com.zo2ami.dto;

import java.io.Serializable;
import java.util.List;

public class RoleDTO implements Serializable {

	private static final long serialVersionUID = 2889539540666678411L;
	
	private long id;
	
	private String name;
	
	private List<PermissionDTO> permissions;
	
	
	RoleDTO(long id, String name){
		this.id= id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PermissionDTO> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionDTO> permissions) {
		this.permissions = permissions;
	}
	
	

}
