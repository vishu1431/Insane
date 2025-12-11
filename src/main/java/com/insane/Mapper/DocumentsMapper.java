package com.insane.Mapper;

import org.springframework.stereotype.Component;

import com.insane.dto.DocumentsDTO;
import com.insane.entity.Documents;

@Component
public class DocumentsMapper {
	


	    public Documents toEntity(DocumentsDTO dto) {
	        if (dto == null) return null;

	        Documents d = new Documents();
	        d.setDirectorPanFile(dto.getDirectorPanFile());
	        d.setDirectorAadhaarFile(dto.getDirectorAadhaarFile());
	        d.setGstFile(dto.getGstFile());
	        d.setPartnershipDeedFile(dto.getPartnershipDeedFile());
	        d.setMsmeFile(dto.getMsmeFile());
	        d.setCancelChequeFile(dto.getCancelChequeFile());
	        d.setFirmPanFile(dto.getFirmPanFile());
	        d.setCinFile(dto.getCinFile());
	        return d;
	    }

	    public DocumentsDTO toDto(Documents d) {
	        if (d == null) return null;

	        DocumentsDTO dto = new DocumentsDTO();
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
	}



