package com.codegym.model.facility;

import com.codegym.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    private int area;
    private Double cost;
    private int maxPeople;
    @ManyToOne
    @JoinColumn(name = "rent_type_id",nullable = false,referencedColumnName = "id")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "facility_type_id",nullable = false,referencedColumnName = "id")
    private FacilityType facilityType;
    @Column(columnDefinition = "varchar(45)")
    private String standardRoom;
    @Column(columnDefinition = "varchar(45)")
    private String description_other_convenience;
    private Double poolArea;
    private int numberOfFloors;
    @Column(columnDefinition = "text")
    private String facility_free;
    @OneToMany(mappedBy = "facility")
    private Set<Contract> contracts;

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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacility_free() {
        return facility_free;
    }

    public void setFacility_free(String facility_free) {
        this.facility_free = facility_free;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
