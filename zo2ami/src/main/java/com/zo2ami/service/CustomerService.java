package com.zo2ami.service;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Customer;
import com.zo2ami.entity.PasswordResetToken;
import com.zo2ami.enums.ClientType;
import com.zo2ami.repo.ResetPasswordTokenRepository;
import com.zo2ami.repo.UserRepositoy;

@Service
public class CustomerService {
	
	@Autowired
	MailService mailService;
	
	@Autowired
	ResetPasswordTokenRepository resetPasswordTokenRepository;
	
	@Autowired
	UserRepositoy userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Value("${reset.password.expirarion.hours}")
	private int expirarionHours;

	public void sendResetPasswordMail(Customer customer, ClientType clientType) {
		String token = UUID.randomUUID().toString();
		createResetPasswordToken(customer, token);
		mailService.sendForgetPasswordMail(customer, token, clientType);
		
	}

	private void createResetPasswordToken(Customer customer, String token) {
		PasswordResetToken resetToken = new PasswordResetToken();
		resetToken.setCustomer(customer);
		resetToken.setExpiryDate(addExpiryDate());
		resetToken.setToken(token);
		resetPasswordTokenRepository.save(resetToken);
	}

	private Date addExpiryDate() {
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());
	    calendar.add(Calendar.HOUR_OF_DAY, expirarionHours);
		return calendar.getTime();
	}

	public boolean isValidRestPassworToken(PasswordResetToken resetToken) {
		return resetToken != null && resetToken.getExpiryDate().before(new Date());
	}

	public PasswordResetToken getResetPasswordToken(String token) {
		return resetPasswordTokenRepository.findBytToken(token);
	}

	public void changePassword(PasswordResetToken passwordResetToken, String password) {
		Customer customer = passwordResetToken.getCustomer();
		customer.setPassword(passwordEncoder.encode(password));
		userRepository.save(customer);
	}
	
	
	

}
