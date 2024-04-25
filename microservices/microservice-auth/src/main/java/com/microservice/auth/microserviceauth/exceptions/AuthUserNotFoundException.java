package com.microservice.auth.microserviceauth.exceptions;

public class AuthUserNotFoundException extends Exception {
    public AuthUserNotFoundException(String message) {
        super(message);
    }
}
