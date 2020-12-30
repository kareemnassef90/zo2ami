package com.zo2ami.dto;

import java.io.Serializable;

import com.zo2ami.entity.Country;

public class CountryDTO implements Serializable {

	private static final long serialVersionUID = -8246644245766606974L;

	private long id;
	
	private String name;
	
	
	
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



	public CountryDTO toDto(Country country) {
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setId(country.getId());
		countryDTO.setName(country.getNameEn());
		return countryDTO;
		
	}
}
