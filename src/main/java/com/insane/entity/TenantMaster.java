package com.insane.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import com.vladmihalcea.hibernate.type.json.JsonType;


import com.insane.pojo.AddressDetails;
import com.insane.pojo.KycDetails;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@Data
@Entity
@Table(name = "tenant_master")

public class TenantMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tenantId;

    // Tenant Category
    private String tenantType;
    private String tenantStatus;
    private String authMode;

    // Registration Basic Details
    private String companyName;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String mobile;

    private String referralCode;
    private Integer agentsUnderDistributor;

    private Boolean emailVerified;
    private Boolean mobileVerified;
    
    private Boolean agreementAccepted;
    private String password;

    // ➤ KYC JSONB
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private KycDetails kycDetails;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private AddressDetails addressDetails;
    
     @Column(columnDefinition = "jsonb")
     @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> callbackUrls;

    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private String ipWhitelist;

    // Whitelabel
    private String wlLogo;
    private String wlDomain;

    // Preferences
    private String mobileAppOrWeb;
    private String location;
    private Double latitude;
    private Double longitude;

    // Profile
    private String profilePhoto;
    private String dob;
    private String gender;
    private String country;
    private String secondaryMobile;
    private String benefitTds;
    private String bookingTds;

    // Bank Details
    private String bankAccountNumber;
    private String bankIfsc;
    private String bankName;
    private String bankBranch;

    // Documents
    private String panNumber;
    private String aadhaarNumber;
    private String gstNumber;
    private String cinNumber;
    
   // Verification flags
    private Boolean panVerified;
    private Boolean aadhaarVerified;
    private Boolean gstVerified;
    private Boolean cinVerified;
    private String notes;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    //Mapping with Agency Table
    @OneToMany(mappedBy = "tenantmaster", cascade = CascadeType.ALL)
    private List<Agency> agencies;
    
    @OneToOne(mappedBy = "tenant", cascade = CascadeType.ALL)
    private Documents documents;
    
}



    // ==========================
    // ENUMS
    // ==========================
    //{ API_KEY, OAUTH }
   //company name - class - 
    
    //temp address
    //permanent address
    
    //isenabled
    //isDleted
    
    //user_type - id uid  -- super admin 1/tenant admin 2- /sub admin - 3 / - distubuter-4/-user-5 
    
    



