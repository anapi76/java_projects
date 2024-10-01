package com.microservice.user.microserviceuser.entities;

//import java.util.*;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, unique = true, length = 20)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(name="is_enabled")
    private boolean isEnabled;

    @Column(name="account_no_expired")
    private boolean accountNoExpired;

    @Column(name="account_no_locked")
    private boolean accountNoLocked;

    @Column(name="credential_no_expired")
    private boolean credentialNoExpired;

    @ManyToOne
    @JoinColumn(name="role_id")
    private RoleEntity role;

   /*  @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="user_roles",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<RoleEntity> roles=new HashSet<>(); */

    public UserEntity() {
    }
    
    public UserEntity(String name,String username, String password, String email, RoleEntity role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email=email;
        this.role=role;
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
    
    public RoleEntity getRole() {
        return role;
    }
    
    public void setRole(RoleEntity role) {
        this.role = role;
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
