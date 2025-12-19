package com.insane.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insane.entity.LoginUser;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Long>{
	
	Optional<LoginUser> findByUsername(String username);
	

}
