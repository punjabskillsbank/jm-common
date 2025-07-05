package com.common.dto;

import com.common.enums.ProposalStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProposalSubmissionDTO {

    @NotNull(message = "Job Posting ID is required")
    private Long jobPostingId;

    @NotNull(message = "Freelancer ID is required")
    private UUID freelancerId;

    @NotNull(message = "Client ID is required")
    private UUID clientId;

    @NotNull(message = "Proposed bid amount is required")
    @Positive(message = "Bid amount must be positive")
    private int proposedBidAmount;

    @NotNull(message = "Proposal status is required")
    private ProposalStatus proposalStatus;

    @NotBlank(message = "Cover letter is required")
    private String coverLetter;

    private List<ProposalQuestionAnswerDTO> questionAnswers;
}
