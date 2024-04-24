package com.microservice.user.microserviceuser.exceptions;

public class UserCantBeNullException extends Exception {
    public UserCantBeNullException(String message) {
        super(message);
    }
}
