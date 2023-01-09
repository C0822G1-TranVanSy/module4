package com.codegym.dto.facility;


import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {
    private int id;
    @Pattern(regexp = "[\\w ]+", message = "Không đúng định dạng")
    private String name;
    private int area;
    @NotNull(message = "Không được null")
    private Double cost;
    private int maxPeople;
    private RentType rentType;
    private FacilityType facilityType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    private String facilityFree;

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

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        String[] strings = facilityDto.name.split(" ");
        if (!facilityDto.name.equals("")) {
            for (String s : strings) {
                if (s.charAt(0) < 'A' || s.charAt(0) > 'Z') {
                    errors.rejectValue("name", "name", "Chữ cái đầu tiên phải viết hoa");
                    break;
                }
            }
        }
        if(facilityDto.getFacilityType().getId()==3){
            facilityDto.setNumberOfFloors(null);
        }
        if (facilityDto.numberOfFloors!=null && !facilityDto.numberOfFloors.toString().matches("[\\d]+")) {
            errors.rejectValue("numberOfFloors", "numberOfFloors", "Bắt buộc phải nhập số");
        }
        if(facilityDto.cost!=null && !facilityDto.cost.toString().matches("([\\d]+)|([\\d]*.[\\d]+)")){
            errors.rejectValue("cost","cost","Giá phải số dương");
        }
    }
}
