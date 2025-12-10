package com.insane.dto;

import java.util.List;

import com.insane.pojo.AddressDetails;
import com.insane.pojo.KycDetails;

import lombok.Data;

@Data
public class TenantRequestDTO {
	
	private String tenantType;
    private String tenantStatus;
    private String authMode;

    private String companyName;
    private String firstName;
    private String lastName;

    private String email;
    private String mobile;

    private String referralCode;
    private Integer agentsUnderDistributor;

    private Boolean emailVerified;
    private Boolean mobileVerified;

    private KycDetails kycDetails;
    private AddressDetails addressDetails;

    private Boolean agreementAccepted;
    private String password;

    private Object callbackUrls;  
    private Object ipWhitelist;

    private String wlLogo;
    private String wlDomain;

    private String profilePhoto;
    private String dob;
    private String gender;
    private String country;
    private String secondaryMobile;
    private String benefitTds;
    private String bookingTds;

    private String bankAccountNumber;
    private String bankIfsc;
    private String bankName;
    private String bankBranch;

    private String directorPanFile;
    private String directorAadhaarFile;
    private String gstFile;
    private String partnershipDeedFile;
    private String msmeFile;
    private String cancelChequeFile;
    private String firmPanFile;
    private String cinFile;

    private Boolean panVerified;
    private Boolean aadhaarVerified;
    private Boolean gstVerified;
    private Boolean cinVerified;

    private String notes;
    private List<AgencyDTO> agencies;
	
	

}
