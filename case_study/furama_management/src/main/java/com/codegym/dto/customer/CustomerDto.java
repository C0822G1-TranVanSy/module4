package com.codegym.dto.customer;

import com.codegym.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CustomerDto implements Validator {

    private int id;
    private CustomerType customerType;
    private String name;
    private String dateOfBirth;
    private boolean gender;
    private String idCard;
    private String phoneNumber;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate dateOfBirth1 = LocalDate.parse(customerDto.dateOfBirth, formatter);
        } catch (DateTimeParseException e) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Ng??y sinh ph???i ????ng ?????nh d???ng dd/MM/yyyy");
        }

        String[] strings = customerDto.getName().split(" ");
        if(!customerDto.name.matches("[a-zA-Z ]+")|| customerDto.name.equals("")){
            errors.rejectValue("name","name","Kh??ng ????ng ?????nh d???ng t??n");
        }
        if(!customerDto.name.equals("")){
        for (String string : strings) {
            if (string.charAt(0) < 'A' || string.charAt(0) > 'Z') {
                errors.rejectValue("name", "name", "Ch??? c??i ?????u ph???i vi???t hoa");
                break;
            }
        }}

        if(!customerDto.idCard.matches("[\\d]{9,12}") || customerDto.idCard.equals("")){
            errors.rejectValue("idCard","idCard","Kh??ng ????ng ?????nh d???ng (9 ho???c 12 s???)");
        }
        if(!customerDto.phoneNumber.matches("(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}") || customerDto.phoneNumber.equals("")){
            errors.rejectValue("phoneNumber","phoneNumber","?????nh d???ng 090xxxxxxx ho???c 091xxxxxxx ho???c (84)+90xxxxxxx ho???c (84)+91xxxxxxx");
        }
        if(!customerDto.email.matches("[\\w]{5,}@[\\w]+.[\\w]+")){
            errors.rejectValue("email","email","?????nh d???ng (abcde@xyz.ikm)");
        }
    }
}
