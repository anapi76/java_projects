package com.anapiqueras.api_users.entity;

//import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_role")
    private int idRole;

    @Column(nullable=false)
    private String name;

  /*  @OneToMany(mappedBy = "role")
    private List<UserEntity>users;  */

    public RoleEntity() {
    }

    public RoleEntity(String name) {
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
