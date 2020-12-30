package com.zo2ami.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Customer;

@Service
public class CustomerService {
	
	@Autowired
	MailService mailService;

	public void sendResetPasswordMail(Customer customer) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
