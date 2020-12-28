package com.zo2ami.service;

import java.util.Date;

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
		providerRepository.save(serviceProvider);
	}

}
