package com.zo2ami.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.ServiceProvider;
import com.zo2ami.enums.AccountType;
import com.zo2ami.repo.ServiceProviderRepository;

@Service
public class ServiceProviderService {
	
	@Autowired
	ServiceProviderRepository providerRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void save(ServiceProvider serviceProvider) {
		serviceProvider.setPassword(passwordEncoder.encode(serviceProvider.getPassword()));
		serviceProvider.setAccountType(AccountType.SERVICE_PROVIDER);
		serviceProvider.setCreationDate(new Date());
		serviceProvider.setLastUpdateDate(new Date());
		providerRepository.save(serviceProvider);
	}
	
	public void update(ServiceProvider serviceProvider) {
		serviceProvider.setLastUpdateDate(new Date());
		providerRepository.save(serviceProvider);
	}

	
	
	
	
	public List<ServiceProvider> listAll(){
		return (List<ServiceProvider>) providerRepository.findAll();
	}
	
	public Optional<ServiceProvider> findById(long id) {
		return providerRepository.findById(id);
	}

}
