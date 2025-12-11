package com.insane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.insane.dto.TenantRequestDTO;
import com.insane.dto.TenantResponseDTO;
import com.insane.service.TenantMasterService;

@RestController
@RequestMapping("/api/tenant")
public class TenantMasterController {

    @Autowired
    private TenantMasterService tenantMasterService;

    @PostMapping("/create")
    public ResponseEntity<TenantResponseDTO> createTenant(
            @RequestBody TenantRequestDTO dto) throws JsonProcessingException {

        TenantResponseDTO response = tenantMasterService.createTenant(dto);

        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{tenantId}")
    public ResponseEntity<TenantResponseDTO> getTenant(@PathVariable("tenantId") Long tenantId) {

        TenantResponseDTO response = tenantMasterService.getTenantById(tenantId);

        return ResponseEntity.ok(response);
    }
}
