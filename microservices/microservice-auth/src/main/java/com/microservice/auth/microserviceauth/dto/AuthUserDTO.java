package com.microservice.auth.microserviceauth.dto;

public class AuthUserDTO {

    private int idUser;
    private String username;
    private String password;
    private RoleDTO role;
    
    public AuthUserDTO() {
    }
    
    public AuthUserDTO(int idUser,String username, String password, RoleDTO role) {
        this.idUser=idUser;
        this.username = username;
        this.password = password;
        this.role=role;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
