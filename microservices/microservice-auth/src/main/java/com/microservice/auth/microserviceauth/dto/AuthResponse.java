package com.microservice.auth.microserviceauth.dto;

public record AuthResponse (String username, String message, String jwt, boolean status){

}
