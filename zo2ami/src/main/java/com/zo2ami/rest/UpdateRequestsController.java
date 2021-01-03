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

import com.zo2ami.dto.ErrorDTO;
import com.zo2ami.dto.ServiceProviderUpdateProfileRequestDTO;
import com.zo2ami.entity.ServiceProviderUpdateProfileRequest;
import com.zo2ami.enums.ErrorCodes;
import com.zo2ami.service.ServiceProviderUpdateProfileRequestService;

@RestController
@RequestMapping("/provider-profile-update-requests")
public class UpdateRequestsController {
	
	@Autowired
	ServiceProviderUpdateProfileRequestService providerUpdateRequestService;
	
	@GetMapping("/requests")
	public ResponseEntity<List<ServiceProviderUpdateProfileRequestDTO>> listRequests(){
		List<ServiceProviderUpdateProfileRequest> updateRequests = providerUpdateRequestService.listAllUpdateRequests();
		List<ServiceProviderUpdateProfileRequestDTO> updateRequestDTOs = new ArrayList<>();
		for (ServiceProviderUpdateProfileRequest serviceProviderUpdateProfileRequest : updateRequests) {
			updateRequestDTOs.add(new ServiceProviderUpdateProfileRequestDTO().toDto(serviceProviderUpdateProfileRequest));
		}
		return new ResponseEntity<>(updateRequestDTOs, HttpStatus.OK);
	}
	
	
	@GetMapping("/approve/{requestId}")
	public ResponseEntity<ErrorDTO> approveRequest(@PathVariable Long requestId){
		if(requestId == null)
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_ID), HttpStatus.BAD_REQUEST);
		if(!providerUpdateRequestService.canApprove())
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		ServiceProviderUpdateProfileRequest request = providerUpdateRequestService.findById(requestId);
		if(request == null)
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.INVALID_ID), HttpStatus.BAD_REQUEST);
		providerUpdateRequestService.approve(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	

}
