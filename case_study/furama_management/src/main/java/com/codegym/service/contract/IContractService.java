package com.codegym.service.contract;

import com.codegym.dto.contract.ContractDto;
import com.codegym.dto.contract.IContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    Page<IContractDto> findAllContract(Pageable pageable);

    List<IContractDto> findAllContract();

    void add(Contract contract);

    void update(Contract contract);

    void remove(int id);

    Optional<Contract> findById(int id);
}
