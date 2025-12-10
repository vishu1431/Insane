package com.insane.Mapper;

import org.springframework.stereotype.Component;

import com.insane.dto.AgencyDTO;
import com.insane.entity.Agency;

import lombok.Data;

@Data
@Component
public class AgencyMapper {
	
	public Agency toEntity(AgencyDTO dto) {
	    Agency a = new Agency();
	    a.setAgentType(dto.getAgentType());
	    a.setAgentCode(dto.getAgentCode());
	    a.setAgencyUrl(dto.getUrl());
	    return a;
	}
	
	  public AgencyDTO toDTO(Agency agency) {
	        AgencyDTO dto = new AgencyDTO();
	        dto.setAgentType(agency.getAgentType());
	        dto.setAgentCode(agency.getAgentCode());
	        dto.setUrl(agency.getAgencyUrl());
	        return dto;
	    

}
}
