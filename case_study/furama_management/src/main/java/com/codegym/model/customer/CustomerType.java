package com.codegym.model.customer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "varchar(45)")
    private String name;

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

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;
}
