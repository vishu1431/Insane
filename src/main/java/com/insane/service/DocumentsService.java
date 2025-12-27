package com.insane.service;

import org.springframework.stereotype.Service;

import com.insane.Mapper.DocumentsMapper;
import com.insane.dto.DocumentsDTO;
import com.insane.dto.DocumentsResponseDTO;
import com.insane.entity.Documents;
import com.insane.entity.TenantMaster;
import com.insane.repository.DocumentsRepository;

@Service
public class DocumentsService {
	

    private final DocumentsRepository repo = null;
    private final DocumentsMapper mapper = new DocumentsMapper();

  
    public DocumentsResponseDTO uploadDocuments(DocumentsDTO dto, TenantMaster tenant) {
        Documents doc = mapper.toEntity(dto);
        doc.setTenant(tenant);
        Documents saved = repo.save(doc);

        return mapper.toDto(saved);
    }
	

}
