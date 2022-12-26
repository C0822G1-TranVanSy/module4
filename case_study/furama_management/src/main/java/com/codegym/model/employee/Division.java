package com.codegym.model.employee;

import com.codegym.model.customer.Customer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    @OneToMany(mappedBy = "division")
    private Set<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }


}
