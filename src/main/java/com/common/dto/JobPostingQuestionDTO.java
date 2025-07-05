package com.common.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobPostingQuestionDTO {
    private Long questionId;
    private String question;
}

