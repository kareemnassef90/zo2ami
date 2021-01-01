package com.zo2ami.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zo2ami.dto.CustomerDTO;
import com.zo2ami.entity.ServiceProvider;
import com.zo2ami.entity.Subscriber;
import com.zo2ami.service.ServiceProviderService;
import com.zo2ami.service.SubscriberService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	SubscriberService subscriberService ; 
	
	@Autowired
	ServiceProviderService serviceProviderService ; 
	
	@GetMapping("/subscribers")
	public ResponseEntity<List<CustomerDTO>> listSubscribers(){
		List<Subscriber> subscribers = subscriberService.listAll();
		List<CustomerDTO> subscribersDto = new ArrayList<>();
		if(subscribers != null)
			subscribers.stream().forEach(subscriber -> subscribersDto.add(new CustomerDTO().toDto(subscriber)));
		return new ResponseEntity<>(subscribersDto, HttpStatus.OK);
	}
	
	
	@GetMapping("/service-providers")
	public ResponseEntity<List<CustomerDTO>> listServiceProviders(){
		List<ServiceProvider> providers = serviceProviderService.listAll();
		List<CustomerDTO> providersDto = new ArrayList<>();
		if(providers != null)
			providers.stream().forEach(provider -> providersDto.add(new CustomerDTO().toDto(provider)));
		return new ResponseEntity<>(providersDto, HttpStatus.OK);
	}

}
