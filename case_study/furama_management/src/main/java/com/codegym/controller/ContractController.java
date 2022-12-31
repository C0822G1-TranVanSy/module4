package com.codegym.controller;

import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public String showList(Pageable pageable, Model model){
        Page<Contract> contractPage = contractService.findAll(pageable);
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        List<Customer> customerList = customerService.findAll();
        List<Facility> facilityList = facilityService.findAll();
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractPage",contractPage);
        model.addAttribute("attachFacilityList",attachFacilityList);
        model.addAttribute("customerList",customerList);
        model.addAttribute("facilityList",facilityList);
        return "contract/list";
    }



}
