package com.zo2ami.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Residence;
import com.zo2ami.repo.ResidenceRepository;

@Service
public class ResidenceService {

	
	@Autowired
	ResidenceRepository residenceRepository;
	
	public List<Residence> listResidences(long countryId){
		return residenceRepository.findAllByCountryId(countryId);
	}
}
