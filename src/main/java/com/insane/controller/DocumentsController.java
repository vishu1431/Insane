package com.insane.controller;

import com.insane.dto.DocumentsDTO;
import com.insane.dto.DocumentsResponseDTO;
import com.insane.entity.TenantMaster;
import com.insane.repository.TenantMasterRepository;
import com.insane.service.DocumentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;

@RestController
@RequestMapping("/documents")
public class DocumentsController {

    private final DocumentsService documentsService;
    private final TenantMasterRepository tenantRepo;

    public DocumentsController(DocumentsService documentsService,
    		TenantMasterRepository tenantRepo) {
        this.documentsService = documentsService;
        this.tenantRepo = tenantRepo;
    }

    @PostMapping("/tenant/{id}/upload")
    public ResponseEntity<DocumentsResponseDTO> uploadDocs(
            @PathVariable Long id,
            @ModelAttribute DocumentsDTO dto) {

        TenantMaster tenant = tenantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        dto.setTenantId(id);

        DocumentsResponseDTO response = documentsService.uploadDocuments(dto, tenant);

        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<String> handleUploadError(MultipartException e) {
        return ResponseEntity.badRequest().body("Invalid file upload!");
    }
}
