package com.zo2ami.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Customer;
import com.zo2ami.entity.MailTemplate;
import com.zo2ami.enums.MailTemplateCode;
import com.zo2ami.repo.MailTemplateRepository;
import com.zo2ami.utils.MailTemplateUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class MailService {
	
	private static final Logger LOGGER = LogManager.getLogger(MailService.class);
	
	@Autowired
	MailTemplateRepository mailTemplateRepository;

	@Autowired
    private JavaMailSender emailSender;


	public void sendForgetPasswordMail(Customer customer) {
		MailTemplate template =  mailTemplateRepository.findByCode(MailTemplateCode.FORGET_PASSWORD.toString());
		Map<String, String> placeholders = new HashMap<>();
		placeholders.put("username", customer.getUsername());
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom(template.getMailFrom());
        message.setTo(customer.getEmail()); 
        message.setSubject(MailTemplateUtils.buildMail(template.getSubject(), placeholders)); 
        message.setText(MailTemplateUtils.buildMail(template.getBody(), placeholders));
        LOGGER.info("START SEND MAIL TO : {} WITH TEMPLATE : {}", message.getTo(), template.getCode());
        emailSender.send(message);
        LOGGER.info("END SEND MAIL TO : {} WITH TEMPLATE : {}", message.getTo(), template.getCode());
		
	}
}
