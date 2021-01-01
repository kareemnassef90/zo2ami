package com.zo2ami.dto;

import java.io.Serializable;

import com.zo2ami.entity.Nationality;

public class NationalityDTO implements Serializable {

	private static final long serialVersionUID = 1910475484113321445L;
	
	private long id;
	
	private String name;
	
	
	
	public NationalityDTO(){
		
	}
	
	NationalityDTO(long id, String name){
		this.id = id;
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

	public NationalityDTO toDto(Nationality nationality) {
		NationalityDTO dto = new NationalityDTO();
		dto.setId(nationality.getId());
		dto.setName(nationality.getNameEn());
		return dto;
	}

}
