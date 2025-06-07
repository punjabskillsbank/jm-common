package com.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDTO {
    private String certificateName;
    private String issuedBy;
    private Date issueDate;
    private Date expiryDate;
    private String credentialUrl;
    private UUID freelancerId;
}
