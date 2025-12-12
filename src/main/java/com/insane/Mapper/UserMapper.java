package com.insane.Mapper;

import org.springframework.stereotype.Component;

import com.insane.dto.UserRequestDto;
import com.insane.dto.UserResponseDto;
import com.insane.entity.TenantMaster;
import com.insane.entity.User;

@Component
public class UserMapper {
	
	public User toEntity(UserRequestDto dto, TenantMaster tenant) {
	        User user = new User();
	        user.setTenant(tenant);
	        user.setExternalUserId(dto.getExternalUserId());
	        user.setRole(dto.getRole());
	        user.setName(dto.getName());
	        user.setEmail(dto.getEmail());
	        user.setMobileNumber(dto.getMobileNumber());
	        user.setPasswordHash(dto.getPassword());
	        user.setAgentType(dto.getAgentType());
	        user.setBusinessType(dto.getBusinessType());
	        user.setBusinessName(dto.getBusinessName());
	        user.setReferralCode(dto.getReferralCode());
	        user.setLeadSource(dto.getLeadSource());
	        user.setSubAdminId(dto.getSubAdminId());
	        user.setDistributorId(dto.getDistributorId());
	        user.setTimezone(dto.getTimezone());
	        user.setLanguage(dto.getLanguage());
	        user.setProfilePhoto(dto.getProfilePhoto());
	        user.setModules(dto.getModules());
	        return user;
	    }

	    public UserResponseDto toDto(User user) {
	        UserResponseDto dto = new UserResponseDto();
	        dto.setUserId(user.getUserId());
	        dto.setTenantId(user.getTenant().getTenantId());
	        dto.setName(user.getName());
	        dto.setEmail(user.getEmail());
	        dto.setMobileNumber(user.getMobileNumber());
	        dto.setRole(user.getRole());
	        dto.setAgentType(user.getAgentType());
	        dto.setStatus(user.getStatus().name());
	        dto.setKycStatus(user.getKycStatus());
	        dto.setCreatedAt(user.getCreatedAt().toString());
	        dto.setUpdatedAt(user.getUpdatedAt().toString());
	        
	        return dto;
	    }
	}



