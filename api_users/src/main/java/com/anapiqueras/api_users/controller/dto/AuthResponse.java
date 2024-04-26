package com.anapiqueras.api_users.controller.dto;

public record AuthResponse (String username, String message, String jwt, boolean status){

}
