package com.codegym.repository.contract;

import com.codegym.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
    @Query(value = "select * from `contract` ctr join `contract_detail` cd on ctr.contract_id = cd.contract_id join `attach_facility` af on af.attach_facility_id = cd.attach_facility_id where ctr.contract_id = :id",nativeQuery = true)
    List<AttachFacility> findByContractId(@Param("id") int id);
}
