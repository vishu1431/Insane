package com.insane.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insane.Mapper.UserMapper;
import com.insane.dto.UserRequestDto;
import com.insane.dto.UserResponseDto;
import com.insane.entity.TenantMaster;
import com.insane.entity.User;
import com.insane.repository.TenantMasterRepository;
import com.insane.repository.UserRepository;

@Service
public class UserServiceImpl{

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TenantMasterRepository tenantRepo;

    @Autowired
    private UserMapper mapper;

    public UserResponseDto createUser(UserRequestDto dto) {

        TenantMaster tenant = tenantRepo.findById(dto.getTenantId())
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        User user = mapper.toEntity(dto, tenant);
        user = userRepo.save(user);

        return mapper.toDto(user);
    }
}
