package com.zo2ami.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zo2ami.entity.PasswordResetToken;

@Repository
public interface ResetPasswordTokenRepository extends CrudRepository<PasswordResetToken, Long>{

	public PasswordResetToken findBytToken(String token);
}
