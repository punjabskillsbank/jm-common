package com.common.exceptionHandling;

import java.util.UUID;


public class FreelancerNotFoundException extends RuntimeException {
    public FreelancerNotFoundException(UUID freelancerId) {
        super("Freelancer not found with ID: " + freelancerId);

    }
}
