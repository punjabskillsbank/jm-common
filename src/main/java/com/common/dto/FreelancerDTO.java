package com.common.dto;

import com.common.enums.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FreelancerDTO {
    @NotNull(message = "freelancerId cannot be null.")
    private UUID freelancerId;

    @NotBlank(message = "title cannot be null.")
    private String title;

    @NotNull(message = "bio cannot be null.")
    private String bio;

    @NotNull(message = "Services cannot be null.")
    @Size(min = 1, message = "services cannot be empty.")
    @Size(max = 10, message = "Cannot assign more than 10 services.")
    private List<Long> services;

    @Positive(message = "hourlyRate must be greater than 0.")
    private int hourlyRate;
    private String address;
    private String city;
    private String state;
    private String country;

    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Please enter a valid postal code")
    private String postalCode;

    @Pattern(regexp = "^(\\+91)?[6789]\\d{9}$", message = "Please enter a valid Phone Number")
    private String phoneNumber;

    @JsonProperty("isAbcMember")
    private Boolean isAbcMember;
    private String profilePhotoURL;
    private List<EducationDTO> educations;
    private List<JobDTO> jobs;
    private List<CertificateDTO> certificates;

    @NotNull(message = "profileStatus cannot be null.")
    private ProfileStatus profileStatus;
}