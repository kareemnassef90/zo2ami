package com.zo2ami.service;

import java.util.Date;

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
}
