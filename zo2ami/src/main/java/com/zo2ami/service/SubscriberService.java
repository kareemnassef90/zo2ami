package com.zo2ami.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Subscriber;
import com.zo2ami.enums.AccountType;
import com.zo2ami.repo.SubscriberRepository;

@Service
public class SubscriberService {

	@Autowired
	SubscriberRepository subscriberRepository;
	
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	public void save(Subscriber subscriber) {
		subscriber.setPassword(passwordEncoder.encode(subscriber.getPassword()));
		subscriber.setAccountType(AccountType.SUBSCRIBER);
		subscriber.setCreationDate(new Date());
		subscriberRepository.save(subscriber);
	}
	
	
	public List<Subscriber> listAll(){
		return (List<Subscriber>) subscriberRepository.findAll();
	}
	
	public Optional<Subscriber> findById(Long id){
		return subscriberRepository.findById(id);
	}
}
