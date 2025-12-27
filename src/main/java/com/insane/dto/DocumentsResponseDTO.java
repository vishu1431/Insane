package com.insane.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentsResponseDTO {

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


