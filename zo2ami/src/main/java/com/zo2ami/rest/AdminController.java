package com.zo2ami.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zo2ami.dto.CustomerDTO;
import com.zo2ami.dto.ErrorDTO;
import com.zo2ami.entity.ServiceProvider;
import com.zo2ami.entity.Subscriber;
import com.zo2ami.enums.ErrorCodes;
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
	
	
	@PostMapping("/update-service-provider")	
	public ResponseEntity<ErrorDTO> updateServiceProvider(@RequestBody CustomerDTO providerDto){
		if(providerDto == null || providerDto.getId() == null )
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_ID), HttpStatus.BAD_REQUEST);
		Optional<ServiceProvider> provider = serviceProviderService.findById(providerDto.getId());
		if(!provider.isPresent())
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.INVALID_ID), HttpStatus.BAD_REQUEST);
		serviceProviderService.update((ServiceProvider) providerDto.update(provider.get()));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping("/update-subscriber")	
	public ResponseEntity<ErrorDTO> updateSubscriber(@RequestBody CustomerDTO subscriberDto){
		if(subscriberDto == null || subscriberDto.getId() == null )
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_ID), HttpStatus.BAD_REQUEST);
		Optional<Subscriber> subscriber = subscriberService.findById(subscriberDto.getId());
		if(!subscriber.isPresent())
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.INVALID_ID), HttpStatus.BAD_REQUEST);
		serviceProviderService.update((ServiceProvider) subscriberDto.update(subscriber.get()));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/get-subscriber-details/{id}")	
	public ResponseEntity<CustomerDTO> getSubscriberDetails(@PathVariable Long id){
		if(id == null)
			return new ResponseEntity<>(new CustomerDTO(new ErrorDTO(ErrorCodes.MISSING_ID)), HttpStatus.BAD_REQUEST);
		Optional<Subscriber> subscriber = subscriberService.findById(id);
		if(!subscriber.isPresent())
			return new ResponseEntity<>(new CustomerDTO(new ErrorDTO(ErrorCodes.INVALID_ID)), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(new CustomerDTO().toDto(subscriber.get()), HttpStatus.OK);
	}
	
	@GetMapping("/get-service-provider-details/{id}")	
	public ResponseEntity<CustomerDTO> getServiceProviderDetails(@PathVariable Long id){
		if(id == null)
			return new ResponseEntity<>(new CustomerDTO(new ErrorDTO(ErrorCodes.MISSING_ID)), HttpStatus.BAD_REQUEST);
		Optional<ServiceProvider> provider = serviceProviderService.findById(id);
		if(!provider.isPresent())
			return new ResponseEntity<>(new CustomerDTO(new ErrorDTO(ErrorCodes.INVALID_ID)), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(new CustomerDTO().toDto(provider.get()), HttpStatus.OK);
	}
	
	@PostMapping("/create-activity")
	public ResponseEntity<CustomerDTO> createActivity(@PathVariable Long id){
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
