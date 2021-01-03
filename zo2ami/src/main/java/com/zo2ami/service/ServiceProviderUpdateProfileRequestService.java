package com.zo2ami.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.ServiceProviderUpdateProfileRequest;
import com.zo2ami.repo.ServiceProviderUpdateProfileRequestRepository;

@Service
public class ServiceProviderUpdateProfileRequestService {

	@Autowired
	ServiceProviderUpdateProfileRequestRepository updateProfileRequestRepository;
	
	
	public void save(ServiceProviderUpdateProfileRequest request) {
		updateProfileRequestRepository.save(request);
	}
}
