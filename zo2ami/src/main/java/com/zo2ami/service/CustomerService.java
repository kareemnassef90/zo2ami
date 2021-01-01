package com.zo2ami.service;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.PasswordResetToken;
import com.zo2ami.entity.User;
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

	public void sendResetPasswordMail(User user, ClientType clientType) throws Exception {
		String token = UUID.randomUUID().toString();
		createResetPasswordToken(user, token);
		mailService.sendForgetPasswordMail(user, token, clientType);
		
	}

	private void createResetPasswordToken(User user, String token) {
		PasswordResetToken resetToken = new PasswordResetToken();
		resetToken.setUser(user);
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
		return resetToken != null && new Date().before(resetToken.getExpiryDate());
	}

	public PasswordResetToken getResetPasswordToken(String token) {
		return resetPasswordTokenRepository.findByToken(token);
	}

	public void changePassword(PasswordResetToken passwordResetToken, String password) {
		User user = passwordResetToken.getUser();
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
		passwordResetToken.setExpired(true);
		resetPasswordTokenRepository.save(passwordResetToken);
	}

	public boolean isValidPassword(PasswordResetToken passwordResetToken, String newPassword) {
		return !passwordEncoder.matches(newPassword, passwordResetToken.getUser().getPassword());
	}
	
	
	

}
