package com.codegym.controller;

import com.codegym.dto.contract.ContractDto;
import com.codegym.dto.contract.IContractDto;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public String showList(Pageable pageable, Model model) {
        Page<IContractDto> contractPage = contractService.findAllContract(pageable);
        List<Customer> customerList = customerService.findAll();
        List<Employee> employeeList = employeeService.findAll();
        List<Facility> facilityList = facilityService.findAll();
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractPage", contractPage);
        model.addAttribute("customerList", customerList);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("facilityList", facilityList);
        model.addAttribute("attachFacilityList", attachFacilityList);
        model.addAttribute("contractDetail", new ContractDetail());
        return "contract/list";
    }

    @PostMapping("/create")
    public String add(@Validated ContractDto contractDto, BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("isModal", true);
            return "redirect:/contract";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.add(contract);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/contract";
    }

    @PostMapping("/update")
    public String update(Contract contract, RedirectAttributes redirectAttributes) {
        contractService.update(contract);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/contract";
    }

    @GetMapping("/view/{id}")
    public String showListAttachFacility(@PathVariable int id, RedirectAttributes redirectAttributes) {
        List<AttachFacility> attachFacilityList = attachFacilityService.findByContractId(id);
        redirectAttributes.addFlashAttribute("attachFacilityList", attachFacilityList);
        return "redirect:/contract";
    }

    @GetMapping("/addAttachFacility")
    public String addAttachFacility() {
        return "redirect:/contract";
    }
}
