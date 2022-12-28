package com.codegym.service.facility;

import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findByNameAndFacilityType(String name, String facilityTypeName, Pageable pageable);

    void add(Facility facility);

    void update(Facility facility);

    void remove(int id);

    Optional<Facility> findById(int id);
}
