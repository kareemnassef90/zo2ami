package com.zo2ami.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	
	public Page<Subscriber> listAll(int pageNumber, int pageSize){
		Pageable page = PageRequest.of(pageNumber - 1, pageSize);
		return subscriberRepository.findAll(page);
	}
	
	public Optional<Subscriber> findById(Long id){
		return subscriberRepository.findById(id);
	}
}
