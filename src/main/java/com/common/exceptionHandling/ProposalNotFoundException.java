package com.common.exceptionHandling;

public class ProposalNotFoundException extends RuntimeException {
    public ProposalNotFoundException(Long proposalId) {
        super("Proposal not found at given proposalId: " + proposalId);
    }
}
