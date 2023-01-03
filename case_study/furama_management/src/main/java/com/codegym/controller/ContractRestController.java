package com.codegym.controller;

import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractRestController {
    @Autowired
    IContractService contractService;
    @Autowired
    IAttachFacilityService attachFacilityService;

    @GetMapping("/view/{id}")
    public ResponseEntity<List<AttachFacility>> searchAttachFacilityByContractId(@PathVariable("id") int id){
        List<AttachFacility> attachFacilityList = attachFacilityService.findByContractId(id);
        return new ResponseEntity<>(attachFacilityList,HttpStatus.OK);
    }

}
