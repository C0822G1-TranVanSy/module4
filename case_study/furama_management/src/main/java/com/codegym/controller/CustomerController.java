package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/customer")
@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "0") int customerTypeId, @PageableDefault(size=5) Pageable pageable){
        Page<Customer> customerPage;
        if(customerTypeId==0){
            customerPage = customerService.findCustomerByNameContainingAndEmailContaining(name,email,pageable);
        }else {
            customerPage = customerService.findCustomerByNameContainingAndEmailContainingAndCustomerType_Id(name, email, customerTypeId, pageable);
        }
        model.addAttribute("customerPage",customerPage);
        model.addAttribute("customerTypeId", customerTypeId);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/list";
    }
}
