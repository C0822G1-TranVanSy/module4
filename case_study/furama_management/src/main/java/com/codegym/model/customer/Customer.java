package com.codegym.model.customer;

import com.codegym.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false, referencedColumnName = "id")
    private CustomerType customerType;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    @Column(columnDefinition = "date")
    private String dateOfBirth;
    private boolean gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Column(columnDefinition = "varchar(45)")
    private String idCard;
    @Column(columnDefinition = "varchar(45)")
    private String phoneNumber;
    @Column(columnDefinition = "varchar(45)")
    private String email;
    @Column(columnDefinition = "varchar(45)")
    private String address;
    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;
}
