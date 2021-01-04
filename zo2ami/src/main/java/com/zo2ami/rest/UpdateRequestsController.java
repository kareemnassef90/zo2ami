package com.zo2ami.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zo2ami.dto.ErrorDTO;
import com.zo2ami.dto.PageDTO;
import com.zo2ami.dto.PageRequestDTO;
import com.zo2ami.dto.ServiceProviderUpdateProfileRequestDTO;
import com.zo2ami.entity.ServiceProviderUpdateProfileRequest;
import com.zo2ami.enums.ErrorCodes;
import com.zo2ami.service.ServiceProviderUpdateProfileRequestService;

@RestController
@RequestMapping("/provider-profile-update-requests")
public class UpdateRequestsController {
	
	@Autowired
	ServiceProviderUpdateProfileRequestService providerUpdateRequestService;
	
	@PostMapping("/requests")
	public ResponseEntity<PageDTO<ServiceProviderUpdateProfileRequestDTO>> listRequests(@RequestBody PageRequestDTO pageRequest){
		PageDTO<ServiceProviderUpdateProfileRequestDTO> pageResonse = new PageDTO<>();
		List<ServiceProviderUpdateProfileRequestDTO> updateRequestDTOs = new ArrayList<>();
		Page<ServiceProviderUpdateProfileRequest> page = providerUpdateRequestService.listAllUpdateRequests(pageRequest.getPageNumber(), pageRequest.getPageSize());
		page.get().forEach(request -> updateRequestDTOs.add(new ServiceProviderUpdateProfileRequestDTO().toDto(request)));
		pageResonse.setList(updateRequestDTOs);
		pageResonse.setTotalCount(page.getTotalElements());
		return new ResponseEntity<>(pageResonse, HttpStatus.OK);
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
