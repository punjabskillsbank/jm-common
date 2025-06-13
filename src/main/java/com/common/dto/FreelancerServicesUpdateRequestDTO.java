package com.common.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FreelancerServicesUpdateRequestDTO {

    @NotNull(message = "Category IDs cannot be null")
    private Set<Long> categoryIds;

}
