package com.insane.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Documents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String directorPanFile;
    
    private String directorAadhaarFile;
    
    private String gstFile;
    
    private String partnershipDeedFile;
    
    private String msmeFile;
    
    private String cancelChequeFile;
    
    private String firmPanFile;
    
    private String cinFile;
    
    
	

}
