package com.common.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

    @NotNull(message = "CategoryId cannot be null")
    private Long categoryId;

    private String category;
    private String speciality;

}
