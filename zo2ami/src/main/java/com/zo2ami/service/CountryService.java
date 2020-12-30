package com.zo2ami.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Country;
import com.zo2ami.repo.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepository;
	
	public List<Country> listCountries(){
		return countryRepository.findAll();
	}

}
