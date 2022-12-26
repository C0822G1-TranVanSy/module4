package com.codegym.service.customer.impl;

import com.codegym.model.customer.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findCustomerByNameContainingAndEmailContainingAndCustomerType_Id(String name, String email, int customerTypeId, Pageable pageable) {
        return customerRepository.findCustomerByNameContainingAndEmailContainingAndCustomerType_Id(name,email,customerTypeId,pageable);
    }

    @Override
    public Page<Customer> findCustomerByNameContainingAndEmailContaining(String name,String email,Pageable pageable) {
        return customerRepository.findCustomerByNameContainingAndEmailContaining(name,email,pageable);
    }
}
