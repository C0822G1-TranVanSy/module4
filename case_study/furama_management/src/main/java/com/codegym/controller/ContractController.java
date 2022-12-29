package com.codegym.controller;

import com.codegym.model.contract.Contract;
import com.codegym.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public String showList(Pageable pageable, Model model){
        Page<Contract> contractPage = contractService.findAll(pageable);
        model.addAttribute("contractPage",contractPage);
        return "contract/list";
    }
}
