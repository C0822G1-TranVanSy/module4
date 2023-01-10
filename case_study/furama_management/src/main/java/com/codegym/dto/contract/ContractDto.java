package com.codegym.dto.contract;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ContractDto implements Validator {
    private int id;
    private String startDate;
    private String endDate;
    private Double deposit;
    private Employee employee;
    private Customer customer;
    private Facility facility;

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDay = null;
        LocalDate endDay = null;
        try {
            startDay = LocalDate.parse(contractDto.startDate, formatter);
            endDay = LocalDate.parse(contractDto.endDate, formatter);
        } catch (DateTimeParseException e) {
            if(startDay == null) {
                errors.rejectValue("startDate", "startDate", "Ngày tháng phải đúng định dạng dd/MM/yyyy");
            }else {
                errors.rejectValue("endDate", "endDate", "Ngày tháng phải đúng định dạng dd/MM/yyyy");
            }
        }
        if(contractDto.getStartDate().compareTo(contractDto.getEndDate())>=1){
            errors.rejectValue("endDate", "endDate", "Ngày kết thúc phải lớn hơn ngày bắt đầu");
        }
        if(contractDto.getDeposit()!=null && !contractDto.getDeposit().toString().matches("([\\d]+)|([\\d]*.[\\d]+)")){
            errors.rejectValue("deposit","deposit","Không đúng định dạng");
        }if(contractDto.getDeposit() == null){
            errors.rejectValue("deposit","deposit","Không được null");
        }
    }
}
