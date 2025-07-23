package com.common.event;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProposalSubmittedEvent {

    private Long proposalId;
    private int jobPostingId;
    private UUID clientId;
    private UUID freelancerId;
}
