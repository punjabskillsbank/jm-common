package com.common.dto.dto;

import com.common.enums.BudgetType;
import com.common.enums.ExperienceLevel;
import com.common.enums.ProjectDuration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobPostingAuditDTO {

    private String title;
    private String description;
    private BudgetType budgetType;
    private Integer hourlyMinRate;
    private Integer hourlyMaxRate;
    private Integer fixedPrice;
    private ProjectDuration projectDuration;
    private ExperienceLevel experienceLevel;
    private Long categoryId;

}
