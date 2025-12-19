package com.insane.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insane.entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
	
	Optional<RefreshToken> findByRefreshToken(String refreshToken);
	
	
	Optional<RefreshToken> findByRefreshTokenAndIsRevokedFalse(String refreshToken);

}
