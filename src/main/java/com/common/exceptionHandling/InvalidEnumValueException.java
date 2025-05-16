package com.common.exceptionHandling;

public class InvalidEnumValueException extends RuntimeException {
    public InvalidEnumValueException(String enumName, String invalidValue) {
        super("Invalid value '" + invalidValue + "' for enum: " + enumName);
    }
}
