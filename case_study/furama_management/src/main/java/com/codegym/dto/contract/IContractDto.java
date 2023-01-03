package com.codegym.dto.contract;

public interface IContractDto {
    int getId();
    String getFacility();
    String getEmployee();
    String getCustomer();
    String getStartDate();
    String getEndDate();
    double getDeposit();
    double getTotal();
}
