package com.microservice.user.microserviceuser.dto;

public class RoleDTO {

    private int idRole;
    private String name;


    public RoleDTO() {
    }

    public RoleDTO(int idRole) {
        this.idRole=idRole;
    }

    public RoleDTO(int idRole,String name) {
        this.idRole=idRole;
        this.name = name;
    }
    public RoleDTO(String name) {
        this.name = name;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
