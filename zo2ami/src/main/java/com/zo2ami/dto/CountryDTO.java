package com.zo2ami.dto;

import java.io.Serializable;

import com.zo2ami.entity.Country;

public class CountryDTO implements Serializable {

	private static final long serialVersionUID = -8246644245766606974L;

	private Long id;
	
	private String name;
	
	public CountryDTO(){
		
	}
	CountryDTO(Long id, String name){
		this.id = id;
		this.name = name;
	}
	
	
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



	public CountryDTO toDto(Country country) {
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setId(country.getId());
		countryDTO.setName(country.getNameEn());
		return countryDTO;
		
	}
}
