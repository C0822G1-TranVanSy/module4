package com.codegym.dto;

import com.codegym.model.Payment;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MotelDto implements Validator {
    private int id;
    @NotBlank
    @Size(min=5,max = 50,message = "Độ dài 5-50")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "Không đúng định dạng")
    private String name;
    @NotBlank
    @Pattern(regexp = "[\\d]{10}",message = "Không đúng định dạng")
    private String numberPhone;
    @NotBlank
    private String startDate;
    private Payment payment;
    @Size(max = 200,message = "Không cho phép quá 200 ký tự")
    private String note;

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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MotelDto motelDto = (MotelDto) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate startDate = LocalDate.parse(motelDto.startDate, formatter);
        } catch (DateTimeParseException e) {
            errors.rejectValue("startDate", "startDate", "Ngày tháng phải đúng định dạng dd/MM/yyyy");
        }
    }
}
