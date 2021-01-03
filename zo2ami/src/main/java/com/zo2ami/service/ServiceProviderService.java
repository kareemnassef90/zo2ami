package com.zo2ami.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Country;
import com.zo2ami.entity.Nationality;
import com.zo2ami.entity.Residence;
import com.zo2ami.entity.ServiceProvider;
import com.zo2ami.entity.ServiceProviderUpdateProfileRequest;
import com.zo2ami.enums.AccountType;
import com.zo2ami.enums.Gender;
import com.zo2ami.repo.ServiceProviderRepository;

@Service
public class ServiceProviderService {
	
	@Autowired
	ServiceProviderRepository providerRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	ServiceProviderUpdateProfileRequestService providerUpdateProfileRequestService;
	
	public void save(ServiceProvider serviceProvider) {
		serviceProvider.setPassword(passwordEncoder.encode(serviceProvider.getPassword()));
		serviceProvider.setAccountType(AccountType.SERVICE_PROVIDER);
		serviceProvider.setCreationDate(new Date());
		serviceProvider.setLastUpdateDate(new Date());
		providerRepository.save(serviceProvider);
	}
	
	public void update(ServiceProvider serviceProvider) {
		if(userDetailsService.getLoggedInUser().getAccountType().equals(AccountType.ADMIN)) {
			serviceProvider.setLastUpdateDate(new Date());
			providerRepository.save(serviceProvider);
		} else {
			ServiceProviderUpdateProfileRequest updateRequest = new ServiceProviderUpdateProfileRequest();
			fillRequest(serviceProvider, updateRequest);
			providerUpdateProfileRequestService.save(updateRequest);
		}
		
	}

	
	
	
	
	private void fillRequest(ServiceProvider serviceProvider, ServiceProviderUpdateProfileRequest updateRequest) {
		updateRequest.setMobileNumber(serviceProvider.getMobileNumber());
		updateRequest.setMobileNumber2(serviceProvider.getMobileNumber2());
		updateRequest.setMobileNumber3(serviceProvider.getMobileNumber3());
		updateRequest.setDateOfBirth(serviceProvider.getDateOfBirth());
		updateRequest.setBrief(serviceProvider.getBrief());
		updateRequest.setGender(serviceProvider.getGender());
		updateRequest.setNationality(serviceProvider.getNationality());
		updateRequest.setCountry(serviceProvider.getCountry());
		updateRequest.setAreaOfResidence(serviceProvider.getAreaOfResidence());
	}

	public List<ServiceProvider> listAll(){
		return (List<ServiceProvider>) providerRepository.findAll();
	}
	
	public Optional<ServiceProvider> findById(long id) {
		return providerRepository.findById(id);
	}

}
