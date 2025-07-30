package com.common.entity;

import com.common.enums.ProposalStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "proposals")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProposalSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proposal_id")
    private Long proposalId;

    @Column(name = "job_posting_id", nullable = false)
    private Long jobPostingId;

    @Column(name = "freelancer_id", nullable = false)
    private UUID freelancerId;

    @Column(name = "client_id", nullable = false)
    private UUID clientId;

    @Column(name = "proposed_bid_amount", nullable = false)
    private int proposedBidAmount;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "proposal_status", columnDefinition = "proposal_status")
    private ProposalStatus proposalStatus;

    @Column(name = "cover_letter", columnDefinition = "text")
    private String coverLetter;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "proposalSubmission", orphanRemoval = true)
    private List<ProposalQuestionAnswer> questionAnswers;
}
