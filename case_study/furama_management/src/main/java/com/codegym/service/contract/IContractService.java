package com.codegym.service.contract;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void add(Customer customer);

    void update(Customer customer);

    void remove(int id);

    Optional<Customer> findById(int id);
}
