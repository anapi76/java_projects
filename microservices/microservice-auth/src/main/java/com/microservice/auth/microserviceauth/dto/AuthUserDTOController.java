package com.microservice.auth.microserviceauth.dto;

public class AuthUserDTOController {

    private int idUser;
    private String username;
    private String password;
    private Integer role;

    public AuthUserDTOController() {
    }

    public AuthUserDTOController(int idUser, String username, String password, Integer role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.role = role;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
