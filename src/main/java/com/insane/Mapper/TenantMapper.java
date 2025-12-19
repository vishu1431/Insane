package com.insane.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insane.dto.AgencyDTO;
import com.insane.dto.TenantRequestDTO;
import com.insane.dto.TenantResponseDTO;
import com.insane.entity.Agency;
import com.insane.entity.Documents;
import com.insane.entity.TenantMaster;
import com.insane.pojo.AddressDetails;
import com.insane.pojo.KycDetails;
import com.insane.util.MaskingUtil;

@Component
public class TenantMapper {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private AgencyMapper agencyMapper;
	
	@Autowired
	private DocumentsMapper documentsMapper;
	
	@Autowired
	private MaskingUtil maskingUtil;

	public TenantMaster toEntity(TenantRequestDTO dto) throws JsonProcessingException {
		TenantMaster t = new TenantMaster();

		t.setPanNumber(dto.getPanNumber());
		t.setAadhaarNumber(dto.getAadhaarNumber());
		t.setGstNumber(dto.getGstNumber());
		t.setCinNumber(dto.getCinNumber());

		t.setTenantType(dto.getTenantType());
		t.setTenantStatus(dto.getTenantStatus());
		t.setAuthMode(dto.getAuthMode());
		t.setCompanyName(dto.getCompanyName());
		t.setFirstName(dto.getFirstName());
		t.setLastName(dto.getLastName());
		t.setEmail(dto.getEmail());
		t.setMobile(dto.getMobile());
		t.setReferralCode(dto.getReferralCode());
		t.setAgentsUnderDistributor(dto.getAgentsUnderDistributor());
		t.setEmailVerified(dto.getEmailVerified());
		t.setMobileVerified(dto.getMobileVerified());
		t.setAddressDetails(dto.getAddressDetails());
		t.setKycDetails(dto.getKycDetails());
		t.setCallbackUrls(dto.getCallbackUrls());

		String ipJson = objectMapper.writeValueAsString(dto.getIpWhitelist());
		t.setIpWhitelist(ipJson);

		t.setAgreementAccepted(dto.getAgreementAccepted());
		t.setPassword(dto.getPassword()); // later hash

		t.setWlLogo(dto.getWlLogo());
		t.setWlDomain(dto.getWlDomain());

		t.setProfilePhoto(dto.getProfilePhoto());
		t.setDob(dto.getDob());
		t.setGender(dto.getGender());
		t.setCountry(dto.getCountry());
		t.setSecondaryMobile(dto.getSecondaryMobile());
		t.setBenefitTds(dto.getBenefitTds());
		t.setBookingTds(dto.getBookingTds());

		t.setBankAccountNumber(dto.getBankAccountNumber());
		t.setBankIfsc(dto.getBankIfsc());
		t.setBankName(dto.getBankName());
		t.setBankBranch(dto.getBankBranch());

		t.setPanVerified(dto.getPanVerified());
		t.setAadhaarVerified(dto.getAadhaarVerified());
		t.setGstVerified(dto.getGstVerified());
		t.setCinVerified(dto.getCinVerified());
		t.setLocation(dto.getLocation());
		t.setLatitude(dto.getLatitude());
		t.setLongitude(dto.getLongitude());

		t.setNotes(dto.getNotes());

		if (dto.getAgencies() != null) {
			List<Agency> agencies = dto.getAgencies().stream().map(agencyMapper::toEntity).collect(Collectors.toList());

			agencies.forEach(a -> a.setTenantmaster(t));
			t.setAgencies(agencies);
		}
		
		if (dto.getDocuments() != null) {
		    Documents docs = documentsMapper.toEntity(dto.getDocuments());

		    docs.setTenant(t); // ⭐ MOST IMPORTANT – relation set karega
		    t.setDocuments(docs);
		}

		return t;
	}

	public TenantResponseDTO toResponse(TenantMaster t) {
		TenantResponseDTO dto = new TenantResponseDTO();

		dto.setPanNumber(MaskingUtil.maskPan(t.getPanNumber()));
		dto.setAadhaarNumber(MaskingUtil.maskAadhaar(t.getAadhaarNumber()));
		dto.setGstNumber(t.getGstNumber());
		dto.setCinNumber(t.getCinNumber());
		dto.setTenantId(t.getTenantId());
		dto.setTenantType(t.getTenantType());
		dto.setTenantStatus(t.getTenantStatus());
		dto.setAuthMode(t.getAuthMode());

		dto.setCompanyName(t.getCompanyName());
		dto.setFirstName(t.getFirstName());
		dto.setLastName(t.getLastName());
		dto.setEmail(t.getEmail());
		dto.setMobile(t.getMobile());

		dto.setReferralCode(t.getReferralCode());
		dto.setAgentsUnderDistributor(t.getAgentsUnderDistributor());
		dto.setEmailVerified(t.getEmailVerified());
		dto.setMobileVerified(t.getMobileVerified());
		dto.setAddressDetails(t.getAddressDetails());

		dto.setKycDetails(t.getKycDetails());
		dto.setCallbackUrls(t.getCallbackUrls());
		dto.setIpWhitelist(t.getIpWhitelist());

		dto.setAgreementAccepted(t.getAgreementAccepted());
		dto.setCallbackUrls(t.getCallbackUrls());
		dto.setIpWhitelist(t.getIpWhitelist());
		dto.setWlLogo(t.getWlLogo());
		dto.setWlDomain(t.getWlDomain());
		dto.setProfilePhoto(t.getProfilePhoto());
		dto.setDob(t.getDob());
		dto.setGender(t.getGender());
		dto.setCountry(t.getCountry());
		dto.setSecondaryMobile(t.getSecondaryMobile());
		dto.setBenefitTds(t.getBenefitTds());
		dto.setBookingTds(t.getBookingTds());
		dto.setBankAccountNumber(t.getBankAccountNumber());
		dto.setBankIfsc(t.getBankIfsc());
		dto.setBankName(t.getBankName());
		dto.setBankBranch(t.getBankBranch());

		dto.setLocation(t.getLocation());
		dto.setLatitude(t.getLatitude());
		dto.setLongitude(t.getLongitude());

		dto.setPanVerified(t.getPanVerified());
		dto.setAadhaarVerified(t.getAadhaarVerified());
		dto.setGstVerified(t.getGstVerified());
		dto.setCinVerified(t.getCinVerified());
		dto.setDocuments(documentsMapper.toDto(t.getDocuments()));
		dto.setNotes(t.getNotes());
		dto.setCreatedAt(t.getCreatedAt().toString());
		dto.setUpdatedAt(t.getUpdatedAt().toString());

		return dto;
	}
}
