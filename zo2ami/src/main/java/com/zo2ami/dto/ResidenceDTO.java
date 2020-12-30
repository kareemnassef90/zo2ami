package com.zo2ami.dto;

import java.io.Serializable;

import com.zo2ami.entity.Residence;

public class ResidenceDTO implements Serializable {

	private static final long serialVersionUID = 7238882376280047129L;
	
	private Long id;
	
	private String name;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public ResidenceDTO toDto(Residence residence) {
		ResidenceDTO dto = new ResidenceDTO();
		dto.setId(residence.getId());
		dto.setName(residence.getNameEn());
		return dto;
	}

	
}
