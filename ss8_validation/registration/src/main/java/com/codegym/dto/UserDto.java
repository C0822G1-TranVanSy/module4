package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {
    private int id;
    @Size(min = 5,max = 45,message = "Độ dài phải từ 5 đến 45")
    private String firstName;
    @Size(min = 5,max = 45,message = "Độ dài phải từ 5 đến 45")
    private String lastName;
    @Pattern(regexp = "[0][\\d]{9}",message = "Số điện thoại 10 số, bắt đầu từ 0")
    private String phoneNumber;
    @Min(value = 18,message = "Bạn đã đủ 18+ chưa")
    private int age;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "Email phải đúng định dạng(Example: abc.dcf@gik.mno)")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
