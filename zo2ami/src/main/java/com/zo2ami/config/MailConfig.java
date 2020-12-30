package com.zo2ami.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Value("${mail.host}")
	private String mailHost;
	
	@Value("${mail.port}")
	private int mailPort;
	
	@Value("${mail.username}")
	private String mailUsername;
	
	@Value("${mail.password}")
	private String mailPassword;
	
	@Value("${mail.protocol}")
	private String mailProtocol;
	
	@Value("${mail.amtp.auth}")
	private boolean mailSmtpAuth;
	
	@Value("${mail.start.tls}")
	private boolean mailStartTls;
	
	@Value("${mail.debug}")
	private boolean debug; 
	
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost(mailHost);
	    mailSender.setPort(mailPort);
	    
	    mailSender.setUsername(mailUsername);
	    mailSender.setPassword(mailPassword);
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", mailProtocol);
	    props.put("mail.smtp.auth", mailSmtpAuth);
	    props.put("mail.smtp.starttls.enable", mailStartTls);
	    props.put("mail.debug", debug);
	    
	    return mailSender;
	}

}
