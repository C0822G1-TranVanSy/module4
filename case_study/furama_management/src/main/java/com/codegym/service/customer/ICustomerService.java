package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findCustomerByNameContainingAndEmailContainingAndCustomerType_Id(String name, String email, int customer_type_id, Pageable pageable);

    Page<Customer> findCustomerByNameContainingAndEmailContaining(String name, String email,Pageable pageable);


}
