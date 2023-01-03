package com.codegym.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attach_facility_id")
    private int id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    private Double cost;
    @Column(columnDefinition = "varchar(10)")
    private String unit;
    @Column(columnDefinition = "varchar(45)")
    private String status;
    @OneToMany(mappedBy = "attachFacility")
    @JsonBackReference
    private Set<ContractDetail> contractDetail;

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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(Set<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }
}
