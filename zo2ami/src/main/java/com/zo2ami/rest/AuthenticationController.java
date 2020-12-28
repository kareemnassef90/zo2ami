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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zo2ami.config.JwtRequest;
import com.zo2ami.config.JwtResponse;
import com.zo2ami.config.JwtTokenUtil;
import com.zo2ami.dto.ErrorDTO;
import com.zo2ami.dto.UserDTO;
import com.zo2ami.entity.ServiceProvider;
import com.zo2ami.entity.Subscriber;
import com.zo2ami.entity.User;
import com.zo2ami.enums.AccountType;
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
	private SubscriberService subscriberService ;
	

	@PostMapping(value = "/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authenticationRequest)  {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} 

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		User user = (User) userDetails;
		
		return ResponseEntity.ok(new JwtResponse(token,user.getAccountType()));

	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<List<ErrorDTO>> register(@RequestBody UserDTO userDto) {
		List<ErrorDTO> errors = userDto.validate();
		if(errors.isEmpty()) {
			if(userDto.getAccountType().equals(AccountType.SERVICE_PROVIDER.toString())) {
				providerService.save(new UserDTO().toServiceProviderDomain(userDto));
			} else {
				subscriberService.save(new UserDTO().toSubscriberDomain(userDto));
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(errors, HttpStatus.OK);
		}
	}
	


}
