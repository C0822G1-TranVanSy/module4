package com.codegym.model.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int role_id;
    private String role_name;
//    @ManyToMany(mappedBy = "likedRoles")
//    @JsonManagedReference
//    private Set<User> likes;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

}
