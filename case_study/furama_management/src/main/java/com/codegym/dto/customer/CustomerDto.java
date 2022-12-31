package com.codegym.dto.customer;


import com.codegym.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {

    private int id;
    private CustomerType customerType;
    @Pattern(regexp = "[a-zA-z ]+", message = "ko được nhập số")
    private String name;
    private String dateOfBirth;
    private boolean gender;
    @Pattern(regexp = "[\\d]{9}",message = "Id Card 9 số")
    private String idCard;
    @Pattern(regexp = "[\\d]{10}",message = "10 số")
    private String phoneNumber;
    @Pattern(regexp = "[\\w]+[@][\\w]+.[\\w]+",message = "nhập đúng đinh dạng email")
    private String email;
    private String address;

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String reg = "^([\\d]{2}/[\\d]{2}/[\\d]{4})$";
        if(customerDto.dateOfBirth.equals("") || !reg.matches(customerDto.dateOfBirth)){
            errors.rejectValue("dateOfBirth",getDateOfBirth(),"Không đúng định dạng dd/mm/yyyy");
        }
    }
}
