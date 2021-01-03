package com.zo2ami.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.ServiceProviderUpdateProfileRequest;
import com.zo2ami.enums.AccountType;
import com.zo2ami.repo.ServiceProviderUpdateProfileRequestRepository;

@Service
public class ServiceProviderUpdateProfileRequestService {

	@Autowired
	ServiceProviderUpdateProfileRequestRepository updateProfileRequestRepository;
	
	@Autowired 
	UserDetailsServiceImpl userDetailsService;
	
	
	public void save(ServiceProviderUpdateProfileRequest request) {
		updateProfileRequestRepository.save(request);
	}


	public List<ServiceProviderUpdateProfileRequest> listAllUpdateRequests() {
		return updateProfileRequestRepository.findByApprovedTrue();
	}


	public boolean canApprove() {
		return userDetailsService.getLoggedInUser().getAccountType().equals(AccountType.ADMIN);
	}


	public ServiceProviderUpdateProfileRequest findById(Long requestId) {
		Optional<ServiceProviderUpdateProfileRequest> request = updateProfileRequestRepository.findById(requestId);
		return request.isPresent() ? request.get() : null;
		
	}


	public void approve(ServiceProviderUpdateProfileRequest request) {
		request.setApproved(true);
		request.setApprovedBy(userDetailsService.getLoggedInUser());
		updateProfileRequestRepository.save(request);
		
	}
}
