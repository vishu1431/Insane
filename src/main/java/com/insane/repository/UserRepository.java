package com.insane.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insane.Enum.UserStatus;
import com.insane.entity.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find by email (login ke time kaam aata hai)
    Optional<User> findByEmail(String email);

    // Mobile se find
    Optional<User> findByMobileNumber(String mobileNumber);

    // Tenant ke saare users
    List<User> findByTenant_TenantId(Long tenantId);

    // External user mapping (API / WL flows)
    Optional<User> findByExternalUserIdAndTenant_TenantId(String externalUserId, Long tenantId);

    // Active users only
    List<User> findByStatus(UserStatus status);

    // Login email/mobile check combined
    @Query("SELECT u FROM User u WHERE (u.email = :identifier OR u.mobileNumber = :identifier)")
    Optional<User> findByIdentifier(String identifier);

    // Login Attempts ke liye
    @Query("SELECT u FROM User u WHERE u.userId = :userId")
    Optional<User> getUserForLogin(Long userId);
}

