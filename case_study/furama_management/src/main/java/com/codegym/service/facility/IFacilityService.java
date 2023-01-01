package com.codegym.service.facility;

import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findByNameAndFacilityType(String name, String facilityTypeName, Pageable pageable);

    Page<Facility> findAll(Pageable pageable);

    List<Facility> findAll();

    void add(Facility facility) throws Exception;

    void update(Facility facility);

    void remove(int id);

    Optional<Facility> findById(int id);
}
