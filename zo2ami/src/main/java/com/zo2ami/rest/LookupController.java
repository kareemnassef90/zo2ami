package com.zo2ami.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zo2ami.dto.CountryDTO;
import com.zo2ami.dto.NationalityDTO;
import com.zo2ami.dto.ResidenceDTO;
import com.zo2ami.entity.Country;
import com.zo2ami.entity.Nationality;
import com.zo2ami.entity.Residence;
import com.zo2ami.service.CountryService;
import com.zo2ami.service.NationalityService;
import com.zo2ami.service.ResidenceService;

@RestController
@RequestMapping(value = "/lookups")
public class LookupController {
	
	@Autowired
	NationalityService nationalityService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	ResidenceService residenceService;
	
	
	@GetMapping("/nationalites")
	public ResponseEntity<List<NationalityDTO>> listNationalities(){
		List<Nationality> nationalites = nationalityService.listNationalities();
		List<NationalityDTO> nationalitesDto = new ArrayList<>();
		for (Nationality nationality : nationalites) {
			nationalitesDto.add(new NationalityDTO().toDto(nationality));
		}
		return new ResponseEntity<>(nationalitesDto, HttpStatus.OK);
	}
	
	@GetMapping("/countries")
	public ResponseEntity<List<CountryDTO>> listcountries(){
		List<Country> countries = countryService.listCountries();
		List<CountryDTO> countriesDto = new ArrayList<>();
		for (Country country : countries) {
			countriesDto.add(new CountryDTO().toDto(country));
		}
		return new ResponseEntity<>(countriesDto, HttpStatus.OK);
	}
	
	
	@GetMapping("/residences/{countryId}")
	public ResponseEntity<List<ResidenceDTO>> listResidences(@PathVariable long countryId){
		List<Residence> residences = residenceService.listResidences(countryId);
		List<ResidenceDTO> residencesDto = new ArrayList<>();
		for (Residence residence : residences) {
			residencesDto.add(new ResidenceDTO().toDto(residence));
		}
		return new ResponseEntity<>(residencesDto, HttpStatus.OK);
	}

}
