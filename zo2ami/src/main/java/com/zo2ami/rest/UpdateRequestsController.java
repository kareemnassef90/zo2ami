package com.zo2ami.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zo2ami.dto.ServiceProviderUpdateProfileRequestDTO;

@RestController
@RequestMapping("/update-profile-requests")
public class UpdateRequestsController {
	
	@GetMapping("/requests")
	public ResponseEntity<List<ServiceProviderUpdateProfileRequestDTO>> listRequests(){
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	

}
