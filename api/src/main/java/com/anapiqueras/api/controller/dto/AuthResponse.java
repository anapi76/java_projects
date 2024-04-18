package com.anapiqueras.api.controller.dto;

public record AuthResponse (String userName, String message, String jwt, boolean status){

}
