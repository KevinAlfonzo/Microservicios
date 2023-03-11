package com.msproduct.msproduct.exception;

public class BadRequestException extends RuntimeException {
    private static final String DESCRIPTION = "Los valores no son correctos ";

    public BadRequestException(String message) {
        super(String.format("%s : %s", DESCRIPTION, message));
    }
}
