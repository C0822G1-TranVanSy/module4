package com.codegym.controller;

import com.codegym.dto.contract.ContractDetailDto;
import com.codegym.dto.contract.ContractDto;
import com.codegym.dto.contract.IAttachFacilityDto;
import com.codegym.dto.contract.IContractDto;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractRestController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/list")
    public ResponseEntity<List<IContractDto>> findAllContract(){
        List<IContractDto> contractDtoList = contractService.findAllContract();
        return new ResponseEntity<>(contractDtoList,HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<List<IAttachFacilityDto>> searchAttachFacilityByContractId(@PathVariable("id") int id){
        List<IAttachFacilityDto> attachFacilityList = attachFacilityService.findByContractIdNew(id);
        return new ResponseEntity<>(attachFacilityList,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createContractDetail(@RequestBody ContractDetailDto contractDetailDto){
        Contract contract = contractService.findById(contractDetailDto.getContract()).orElse(null);
        AttachFacility attachFacility = attachFacilityService.findById(contractDetailDto.getAttachFacility());
        ContractDetail contractDetail = new ContractDetail();
        contractDetail.setContract(contract);
        contractDetail.setQuantity(contractDetailDto.getQuantity());
        contractDetail.setAttachFacility(attachFacility);
        contractDetailService.add(contractDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
