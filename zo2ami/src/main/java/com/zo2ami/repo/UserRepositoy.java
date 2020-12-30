package com.zo2ami.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zo2ami.entity.User;

@Repository
public interface UserRepositoy extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
	
}
