package com.insane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insane.entity.TenantMaster;

public interface TenantMasterRepository extends JpaRepository<TenantMaster, Long> {

	    boolean existsByEmail(String email);
	    boolean existsByMobile(String mobile);
	}
	


