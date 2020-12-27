package com.zo2ami.rest;

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
import com.zo2ami.config.JwtResponse;
import com.zo2ami.config.JwtTokenUtil;
import com.zo2ami.dto.UserDTO;
import com.zo2ami.entity.Customer;
import com.zo2ami.entity.User;
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
	public ResponseEntity<String> register(@RequestBody UserDTO userDto) {
		userDto.validate();
		return new ResponseEntity(HttpStatus.CREATED);
	}
	


}
