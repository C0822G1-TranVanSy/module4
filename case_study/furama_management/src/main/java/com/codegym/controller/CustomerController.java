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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/customer")
@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "") String customerTypeName, @PageableDefault(size = 5) Pageable pageable) {
        Page<Customer> customerPage = customerService.findByNameAndEmailAndCustomerType(name, email, customerTypeName, pageable);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customerTypeName",customerTypeName);
        return "customer/list";
    }

    @GetMapping("/create")
    public String showAdd(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/create")
    public String add(Customer customer, RedirectAttributes redirectAttributes){
        customerService.add(customer);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id,RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/customer";
    }
}
