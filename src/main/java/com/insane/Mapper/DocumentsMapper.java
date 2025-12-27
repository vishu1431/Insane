package com.insane.Mapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.insane.dto.DocumentsDTO;
import com.insane.dto.DocumentsResponseDTO;
import com.insane.entity.Documents;

@Component
public class DocumentsMapper {

    private static final String UPLOAD_DIR = "uploads/";

   

        public Documents toEntity(DocumentsDTO dto) {

            Documents doc = new Documents();

            doc.setDirectorPanFile(save(dto.getDirectorPanFile()));
            doc.setDirectorAadhaarFile(save(dto.getDirectorAadhaarFile()));
            doc.setGstFile(save(dto.getGstFile()));
            doc.setPartnershipDeedFile(save(dto.getPartnershipDeedFile()));
            doc.setMsmeFile(save(dto.getMsmeFile()));
            doc.setCancelChequeFile(save(dto.getCancelChequeFile()));
            doc.setFirmPanFile(save(dto.getFirmPanFile()));
            doc.setCinFile(save(dto.getCinFile()));

            return doc;
        }

        public DocumentsResponseDTO toDto(Documents d) {
            if (d == null)
                return null;

            DocumentsResponseDTO dto = new DocumentsResponseDTO();

            dto.setId(d.getId());
            dto.setDirectorPanFile(d.getDirectorPanFile());
            dto.setDirectorAadhaarFile(d.getDirectorAadhaarFile());
            dto.setGstFile(d.getGstFile());
            dto.setPartnershipDeedFile(d.getPartnershipDeedFile());
            dto.setMsmeFile(d.getMsmeFile());
            dto.setCancelChequeFile(d.getCancelChequeFile());
            dto.setFirmPanFile(d.getFirmPanFile());
            dto.setCinFile(d.getCinFile());

            return dto;
        }

        private String save(MultipartFile file) {
            if (file == null || file.isEmpty())
                return null;

            try {
                String path = "uploads/" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path finalPath = Paths.get(path);
                Files.createDirectories(finalPath.getParent());
                Files.copy(file.getInputStream(), finalPath);
                return path;
            } catch (Exception e) {
                throw new RuntimeException("File upload failed");
            }
        }
    }


