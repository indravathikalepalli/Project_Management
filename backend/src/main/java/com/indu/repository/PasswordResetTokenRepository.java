package com.indu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indu.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	PasswordResetToken findByToken(String token);
}
