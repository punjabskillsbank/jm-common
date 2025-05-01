package com.common.exceptionHandeling;

import java.util.UUID;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(UUID clientId) {
        super("Client not found with ID: " + clientId);
    }
}
