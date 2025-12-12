package com.insane.dto;

import com.insane.Enum.AgentType;
import com.insane.Enum.Role;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    @NotNull
    private Long tenantId;

    private String externalUserId;

    @NotNull
    private Role role;

    @NotNull
    private String name;

    private String email;
    private String mobileNumber;
    private String password;

    @NotNull
    private AgentType agentType;

    private String businessType;
    private String businessName;

    private String referralCode;
    private String leadSource;

    private Long subAdminId;
    private Long distributorId;

    private String timezone;
    private String language;
    private String profilePhoto;

    private String modules; 
}

