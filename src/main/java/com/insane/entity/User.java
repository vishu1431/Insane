package com.insane.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.insane.Enum.AgentType;
import com.insane.Enum.KycStatus;
import com.insane.Enum.Role;
import com.insane.Enum.UserSource;
import com.insane.Enum.UserStatus;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantMaster tenant;

    private String externalUserId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private String name;

    private String email;
    private String mobileNumber;
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AgentType agentType;

    private String businessType;
    private String businessName;

    private String referralCode;
    private String leadSource;

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.invited;

    private LocalDateTime invitedAt;
    private LocalDateTime activatedAt;
    private LocalDateTime suspendedAt;
    private LocalDateTime otpVerifiedAt;

    @Enumerated(EnumType.STRING)
    private KycStatus kycStatus = KycStatus.PENDING;

    private LocalDateTime kycSubmittedAt;

    private Long subAdminId;
    private Long distributorId;

    private String timezone;
    private String language;
    private String profilePhoto;

    
    private String modules; // JSON string

    @Enumerated(EnumType.STRING)
    private UserSource userSource = UserSource.web;

    private String ipAddress;

  
    private String deviceInfo;

    
    private String geolocation;

    private LocalDateTime lastLoginAt;
    private Integer loginAttempts = 0;

    private Boolean deleted = false;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
