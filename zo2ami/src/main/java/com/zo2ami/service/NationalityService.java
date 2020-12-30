package com.zo2ami.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Nationality;
import com.zo2ami.repo.NationalityRepository;

@Service
public class NationalityService {

	@Autowired
	private NationalityRepository nationalityRepository;
	
	public List<Nationality>listNationalities(){
		return nationalityRepository.findAll();
	}
}
