package com.codegym.service.contract.impl;

import com.codegym.model.contract.ContractDetail;
import com.codegym.repository.contract.IContractDetailRepository;
import com.codegym.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;


    @Override
    public void add(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
