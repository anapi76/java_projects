package com.microservice.user.microserviceuser.dto;

public class UserDTO {

    private int idUser;
    private String name;
    private String username;
    private String password;
    private String email;
    private boolean isEnabled;
    private boolean accountNoExpired;
    private boolean accountNoLocked;
    private boolean credentialNoExpired;
    private RoleDTO roleDto;

    public UserDTO() {
    }

    public UserDTO(int idUser, String name,String username, String password, String email, boolean isEnabled,
            boolean accountNoExpired,
            boolean accountNoLocked, boolean credentialNoExpired, RoleDTO roleDto) {
        this.idUser = idUser;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isEnabled = isEnabled;
        this.accountNoExpired = accountNoExpired;
        this.accountNoLocked = accountNoLocked;
        this.credentialNoExpired = credentialNoExpired;
        this.roleDto = roleDto;
    }

    public UserDTO(int idUser, String name, String username, String password, String email, RoleDTO roleDto) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleDto = roleDto;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public RoleDTO getRoleDto() {
        return roleDto;
    }

    public void setRoleDto(RoleDTO roleDto) {
        this.roleDto = roleDto;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean isAccountNoExpired() {
        return accountNoExpired;
    }

    public void setAccountNoExpired(boolean accountNoExpired) {
        this.accountNoExpired = accountNoExpired;
    }

    public boolean isAccountNoLocked() {
        return accountNoLocked;
    }

    public void setAccountNoLocked(boolean accountNoLocked) {
        this.accountNoLocked = accountNoLocked;
    }

    public boolean isCredentialNoExpired() {
        return credentialNoExpired;
    }

    public void setCredentialNoExpired(boolean credentialNoExpired) {
        this.credentialNoExpired = credentialNoExpired;
    }
}
