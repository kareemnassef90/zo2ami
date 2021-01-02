package com.zo2ami.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.User;
import com.zo2ami.repo.UserRepositoy;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepositoy userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email)  {
		return userRepository.findByEmail(email);
	}
	
	public User getLoggedInUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
