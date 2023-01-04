package com.codegym.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String showList(Pageable pageable, Model model){
//        Page<Contract> contractPage = contractService.findAll(pageable);
        Page<IContractDto> contractPage = contractService.findAllContract(pageable);

        List<Customer> customerList = customerService.findAll();
        List<Employee> employeeList = employeeService.findAll();
        List<Facility> facilityList = facilityService.findAll();
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractPage",contractPage);
        model.addAttribute("customerList",customerList);
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("facilityList",facilityList);
        model.addAttribute("attachFacilityList",attachFacilityList);
        model.addAttribute("contractDetail",new ContractDetail());
        return "contract/list";
    }

    @PostMapping("/create")
    public String add(Contract contract, RedirectAttributes redirectAttributes){
        contractService.add(contract);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/contract";
    }

    @PostMapping("/update")
    public String update(Contract contract, RedirectAttributes redirectAttributes){
        contractService.update(contract);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/contract";
    }

    @GetMapping("/view/{id}")
    public String showListAttachFacility(@PathVariable int id,Model model,RedirectAttributes redirectAttributes){
        List<AttachFacility> attachFacilityList = attachFacilityService.findByContractId(id);
        redirectAttributes.addFlashAttribute("attachFacilityList",attachFacilityList);
        redirectAttributes.addFlashAttribute("modal",true);
        return "redirect:/contract";
    }

    @GetMapping("/addAttachFacility")
    public String addAttachFacility(){
        return "redirect:/contract";
    }
}
