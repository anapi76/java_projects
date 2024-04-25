package com.microservice.auth.microserviceauth.dto;

public class AuthUserDTO {

    private int idAuth;
    private String username;
    private String password;
    private RoleDTO role;
    
    public AuthUserDTO() {
    }
    
    public AuthUserDTO(int idAuth,String username, String password, RoleDTO role) {
        this.idAuth=idAuth;
        this.username = username;
        this.password = password;
        this.role=role;
    }

    public int getIdAuth() {
        return idAuth;
    }

    public void setIdAuth(int idAuth) {
        this.idAuth = idAuth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

}
