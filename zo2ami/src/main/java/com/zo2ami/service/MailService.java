package com.zo2ami.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Customer;
import com.zo2ami.entity.MailTemplate;
import com.zo2ami.entity.User;
import com.zo2ami.enums.ClientType;
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
	
	@Value("${reset.password.mobile.link}")
	private String mobileLink;
	
	@Value("${reset.password.web.link}")
	private String webLink;


	public void sendForgetPasswordMail(User user, String token, ClientType clientType) throws Exception {
		MailTemplate template =  mailTemplateRepository.findByCode(MailTemplateCode.FORGET_PASSWORD);
		if(template != null) {
			Map<String, String> placeholders = new HashMap<>();
			placeholders.put("username", user.getUsername());
			placeholders.put("token", token);
			if(clientType.equals(ClientType.MOBILE))
				placeholders.put("link", mobileLink + token);
			else
				placeholders.put("link", webLink + token);
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(template.getMailFrom());
			message.setTo(user.getEmail()); 
			message.setSubject(MailTemplateUtils.buildMail(template.getSubject(), placeholders)); 
			message.setText(MailTemplateUtils.buildMail(template.getBody(), placeholders));
			LOGGER.info("START SEND MAIL TO : {} WITH TEMPLATE : {}", message.getTo(), template.getCode());
			emailSender.send(message);
			LOGGER.info("END SEND MAIL TO : {} WITH TEMPLATE : {}", message.getTo(), template.getCode());
		} else {
			LOGGER.error("CANNOT FIND MAIL TEMPLATE WITH CODE : {}", MailTemplateCode.FORGET_PASSWORD);
			throw new Exception();
		}
		
	}
}
