package com.codegym.model.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;


public class User {
    private String username;
    private String password;
    @OneToOne(mappedBy = "user")
    private Employee employee;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "username"),inverseJoinColumns = @JoinColumn(name = "role_id"))
//    @JsonManagedReference
//    private Set<Role> likedRoles;

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

}
