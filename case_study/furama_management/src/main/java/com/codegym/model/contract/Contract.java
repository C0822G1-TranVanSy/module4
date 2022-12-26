package com.codegym.model.contract;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Role;
import com.codegym.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contract_id")
    private int id;
    @Column(columnDefinition = "datetime")
    private String startDate;
    @Column(columnDefinition = "datetime")
    private String endDate;
    private Double deposit;
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false,referencedColumnName = "id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false,referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "facility_id",nullable = false,referencedColumnName = "id")
    private Facility facility;
    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Set<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(Set<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }
}
