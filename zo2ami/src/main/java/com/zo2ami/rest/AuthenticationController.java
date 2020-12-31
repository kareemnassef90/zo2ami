package com.zo2ami.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zo2ami.config.JwtRequest;
import com.zo2ami.config.LoginResponseDTO;
import com.zo2ami.config.JwtTokenUtil;
import com.zo2ami.dto.ErrorDTO;
import com.zo2ami.dto.ResetPasswordDTO;
import com.zo2ami.dto.UserDTO;
import com.zo2ami.entity.PasswordResetToken;
import com.zo2ami.entity.User;
import com.zo2ami.enums.AccountType;
import com.zo2ami.enums.ClientType;
import com.zo2ami.enums.ErrorCodes;
import com.zo2ami.service.CustomerService;
import com.zo2ami.service.ServiceProviderService;
import com.zo2ami.service.SubscriberService;
import com.zo2ami.service.UserDetailsServiceImpl;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private ServiceProviderService providerService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private SubscriberService subscriberService ;
	
	

	@PostMapping(value = "/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody JwtRequest authenticationRequest)  {
		LoginResponseDTO response = new LoginResponseDTO();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
		} catch (Exception e) {
			response.getErrors().add(new ErrorDTO(ErrorCodes.INVALID_USERNAME_OR_PASSWORD));
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		} 

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);

		User user = (User) userDetails;
		response = new LoginResponseDTO(token, user.getAccountType());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<List<ErrorDTO>> register(@RequestBody UserDTO userDto) {
		List<ErrorDTO> errors = userDto.validate();
		if(userDetailsService.loadUserByUsername(userDto.getEmail()) != null)
			errors.add(new ErrorDTO(ErrorCodes.EMAIL_ALREADY_EXISTS));
		if(errors.isEmpty()) {
			if(userDto.getAccountType().equals(AccountType.SERVICE_PROVIDER.toString())) {
				providerService.save(new UserDTO().toServiceProviderDomain(userDto));
			} else {
				subscriberService.save(new UserDTO().toSubscriberDomain(userDto));
			}
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(errors, HttpStatus.OK);
		}
	}
	
	
	
	@PostMapping(value = "/forget-password")
	public ResponseEntity<ResetPasswordDTO> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO){
		ResetPasswordDTO response = new ResetPasswordDTO();
		if(resetPasswordDTO.getClientType() == null) {
			response.getErrors().add(new ErrorDTO(ErrorCodes.MISSING_CLIENT_TYPE));
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		User user = (User) userDetailsService.loadUserByUsername(resetPasswordDTO.getEmail());
		if(user == null) {
			response.getErrors().add(new ErrorDTO(ErrorCodes.USER_NOT_FOUND));
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} else {
			customerService.sendResetPasswordMail(user, ClientType.valueOf(resetPasswordDTO.getClientType()));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/forget-password-change")
	public ResponseEntity<ResetPasswordDTO> changePassword(@RequestBody ResetPasswordDTO resetPasswordDTO){
		ResetPasswordDTO response = new ResetPasswordDTO();
		if(resetPasswordDTO.getToken() == null) {
			response.getErrors().add(new ErrorDTO(ErrorCodes.MISSING_RESET_PASSWORD_TOKEN));
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		if(resetPasswordDTO.getPassword().equals(resetPasswordDTO.getConfirmPassword())) {
			response.getErrors().add(new ErrorDTO(ErrorCodes.PASSWORDS_NOT_MATCHED));
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		PasswordResetToken passwordResetToken = customerService.getResetPasswordToken(resetPasswordDTO.getToken());
		if(passwordResetToken == null) {
			response.getErrors().add(new ErrorDTO(ErrorCodes.INVALID_RESET_PASSWORD_TOKEN));
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		if(!customerService.isValidRestPassworToken(passwordResetToken)) {
			response.getErrors().add(new ErrorDTO(ErrorCodes.INVALID_RESET_PASSWORD_TOKEN));
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} else {
			customerService.changePassword(passwordResetToken, resetPasswordDTO.getPassword());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	
	


}
