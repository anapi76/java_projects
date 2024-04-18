package com.anapiqueras.api.persistence.model;

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
    private Long IdUser;

    @Column(nullable = false, unique = true, length = 20)
    private String userName;

    @Column(nullable = false)
    private String password;

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
    
    public UserEntity(String userName, String password, RoleEntity role) {
        this.userName = userName;
        this.password = password;
        this.role=role;
    }
    
    public Long getIdUser() {
        return IdUser;
    }
    
    public void setIdUser(Long idUser) {
        IdUser = idUser;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
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
