package com.anapiqueras.api.controller.dto;

public record AuthResponse (String username, String message, String jwt, boolean status){

}
