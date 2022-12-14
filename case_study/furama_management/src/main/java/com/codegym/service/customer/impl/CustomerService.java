package com.codegym.service.customer.impl;

import com.codegym.dto.customer.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findByNameAndEmailAndCustomerType(String name, String email, String customerTypeName, Pageable pageable) {
        return customerRepository.findByNameAndEmailAndCustomerType(name,email,customerTypeName,pageable);
    }

    @Override
    public Page<Customer> findByNameAndEmail(String name, String email, Pageable pageable) {
        return customerRepository.findByNameAndEmail(name,email,pageable);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Map<String,String> getError(CustomerDto customerDto) {
        Map<String,String> errorMap = new HashMap<>();

        for (Customer c: findAll()) {
            if(customerDto.getId()!=c.getId()){
            if(c.getIdCard().equals(customerDto.getIdCard())){
                errorMap.put("errorIdCard","Trùng id card");
//                throw new Exception("E_CONFLICT_ID");
            }
            if(c.getPhoneNumber().equals(customerDto.getPhoneNumber())){
                errorMap.put("errorPhoneNumber","Trùng số phone");
            }
            if(c.getEmail().equals(customerDto.getEmail())){
                errorMap.put("errorEmail","Trùng email");
            }
        }
        }
        return errorMap;
    }

    @Override
    public void add(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        getError(customerDto);
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        getError(customerDto);
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean existsByIdCardAndPhoneNumberAndEmail(String idCard, String phoneNumber, String email) {
        return customerRepository.existsByIdCardAndPhoneNumberAndEmail(idCard,phoneNumber,email);
    }

}
