package com.common.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PresignedUrlRequestDTO {
    private Long job_posting_id;
    private Set<String> fileNames = new HashSet<>();
}
