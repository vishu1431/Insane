package com.insane.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.insane.Enum.AgentType;
import com.insane.Enum.KycStatus;
import com.insane.Enum.Role;

import lombok.Data;

@Data
public class UserResponseDto {
	
	    private Long userId;
	    private Long tenantId;
	    private String name;
	    private String email;
	    private String mobileNumber;
	    private Role role;
	    private AgentType agentType;
	    private String status;
	    private KycStatus kycStatus;
	    private String createdAt;
	    private String updatedAt;

}
