package com.insane.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class DocumentsDTO {

    private Long tenantId;

    private MultipartFile directorPanFile;
    private MultipartFile directorAadhaarFile;
    private MultipartFile gstFile;
    private MultipartFile partnershipDeedFile;
    private MultipartFile msmeFile;
    private MultipartFile cancelChequeFile;
    private MultipartFile firmPanFile;
    private MultipartFile cinFile;
}
