package com.codegym.repository;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from furama_module4.customer where name like concat('%',:name,'%') and email like concat('%',:email,'%') and customer_type_id = :customerTypeId",nativeQuery = true)
    Page<Customer> findCustomerByNameContainingAndEmailContainingAndCustomerType_Id(@Param("name") String name,@Param("email") String email,@Param("customerTypeId") int customerTypeId, Pageable pageable);

    @Query(value = "select * from furama_module4.customer where name like concat('%',:name,'%') and email like concat('%',:email,'%')",nativeQuery = true)
    Page<Customer> findCustomerByNameContainingAndEmailContaining(@Param("name") String name,@Param("email") String email, Pageable pageable);

}
