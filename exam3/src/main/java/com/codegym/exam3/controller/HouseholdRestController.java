package com.codegym.exam3.controller;

import com.codegym.exam3.model.Household;
import com.codegym.exam3.model.Member;
import com.codegym.exam3.service.IHouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/households")
public class HouseholdRestController {
    @Autowired
    private IHouseholdService householdService;

    @GetMapping("/view/{id}")
    public ResponseEntity<List<String>> view(@PathVariable int id){
        List<String> memberList = householdService.findMemberNameById(id);
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }
}
