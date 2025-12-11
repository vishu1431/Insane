package com.insane.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.insane.Mapper.TenantMapper;
import com.insane.dto.TenantRequestDTO;
import com.insane.dto.TenantResponseDTO;
import com.insane.entity.TenantMaster;
import com.insane.repository.TenantMasterRepository;

@Service
public class TenantMasterService {

    @Autowired
    private TenantMasterRepository tenantMasterRepository;

    @Autowired
    private TenantMapper tenantMasterMapper;

    public TenantResponseDTO createTenant(TenantRequestDTO dto)  throws JsonProcessingException{

        // DTO → ENTITY
        TenantMaster entity = tenantMasterMapper.toEntity(dto);

        // Save (will also save Agencies automatically)
        TenantMaster saved = tenantMasterRepository.save(entity);

        // ENTITY → RESPONSE DTO
        return tenantMasterMapper.toResponse(saved);
    }
    
    public TenantResponseDTO getTenantById(Long id) {
        TenantMaster tenant = tenantMasterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant not found with id: " + id));

        return tenantMasterMapper.toResponse(tenant);
    }

}