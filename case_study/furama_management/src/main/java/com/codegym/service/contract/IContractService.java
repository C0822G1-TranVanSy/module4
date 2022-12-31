package com.codegym.service.contract;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void add(Contract contract);

    void update(Contract contract);

    void remove(int id);

    Optional<Contract> findById(int id);
}
