package com.microservice.auth.microserviceauth.exceptions;

public class AuthUserCantBeNullException extends Exception {
    public AuthUserCantBeNullException(String message) {
        super(message);
    }
}
