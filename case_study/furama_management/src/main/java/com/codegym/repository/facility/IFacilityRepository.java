package com.codegym.repository.facility;

import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(value = "select f.* from `facility` f join `facility_type` ft on f.facility_type_id = ft.id  where f.name like %:name% and ft.name like %:facilityTypeName%" ,nativeQuery = true )
    Page<Facility> findByNameAndFacilityType(@Param("name") String name, @Param("facilityTypeName") String facilityTypeName, Pageable pageable);

}
