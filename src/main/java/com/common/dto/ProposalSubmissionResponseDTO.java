package com.common.dto;

import com.common.enums.ProposalStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProposalSubmissionResponseDTO {
    private Long proposalId;
    private Long jobPostingId;
    private UUID freelancerId;
    private UUID clientId;
    private int proposedBidAmount;
    private ProposalStatus proposalStatus;
    private String coverLetter;
    private List<ProposalQuestionAnswerDTO> questionAnswers;
    private List<String> attachment_s3_key;
}
