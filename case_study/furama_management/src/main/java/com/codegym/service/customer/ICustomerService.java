package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findByNameAndEmailAndCustomerType(String name, String email, String customerTypeName, Pageable pageable);

    Page<Customer> findByNameAndEmail(String name, String email, Pageable pageable);

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    Map<String,String> getError(Customer customer);

    void add(Customer customer);

    void update(Customer customer);

    void remove(int id);

    Optional<Customer> findById(int id);

    boolean existsByIdCardAndPhoneNumberAndEmail(String idCard,String phoneNumber,String email);
}
