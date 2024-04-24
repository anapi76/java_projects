package com.anapiqueras.api_users.controller.dto;

public class UserDTOController {

    private int idUser;
    private String username;
    private String password;
    private String email;
    private Integer role;

    public UserDTOController() {
    }

    public UserDTOController(int idUser, String username, String password, String email, Integer role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
