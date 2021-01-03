package com.zo2ami.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zo2ami.dto.CustomerDTO;
import com.zo2ami.dto.ErrorDTO;
import com.zo2ami.entity.ServiceProvider;
import com.zo2ami.enums.ErrorCodes;
import com.zo2ami.service.ServiceProviderService;

@RestController
@RequestMapping("/service-provider")
public class ServiceProviderController {
	
	@Autowired
	ServiceProviderService serviceProviderService;
	
	@PostMapping("/update-profile")
	public ResponseEntity<ErrorDTO> updateServiceProvider(@RequestBody CustomerDTO providerDto){
		if(providerDto == null || providerDto.getId() == null )
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_ID), HttpStatus.BAD_REQUEST);
		Optional<ServiceProvider> provider = serviceProviderService.findById(providerDto.getId());
		if(!provider.isPresent())
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.INVALID_ID), HttpStatus.BAD_REQUEST);
		serviceProviderService.update((ServiceProvider) providerDto.update(provider.get()));
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
