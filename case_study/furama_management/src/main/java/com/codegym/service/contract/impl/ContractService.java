package com.codegym.service.contract.impl;

import com.codegym.dto.contract.ContractDto;
import com.codegym.dto.contract.IContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.repository.contract.IContractRepository;
import com.codegym.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<IContractDto> findAllContract(Pageable pageable) {
        return contractRepository.findAllContract(pageable);
    }

    @Override
    public List<IContractDto> findAllContract() {
        return contractRepository.findAllContract();
    }

    @Override
    public void add(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void update(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(int id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Optional<Contract> findById(int id) {
        return contractRepository.findById(id);
    }
}
