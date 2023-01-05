package com.codegym.repository.contract;

import com.codegym.dto.contract.ContractDto;
import com.codegym.dto.contract.IContractDto;
import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select ctr.contract_id as id,f.id as facilityId,c.id as customerId,e.id as employeeId, f.name as facilityName,e.name as employeeName, c.name as customerName,ctr.start_date as startDate,ctr.end_date as endDate,ctr.deposit as deposit, (ifnull(f.cost, 0)+sum(ifnull(cd.quantity, 0)* ifnull(af.cost, 0))) as total from contract ctr join customer c on c.id = ctr.customer_id left join facility f on ctr.facility_id = f.id left join employee e on ctr.employee_id = e.id left join contract_detail cd on ctr.contract_id = cd.contract_id left join attach_facility af on cd.attach_facility_id = af.attach_facility_id left join customer_type ct on c.customer_type_id = ct.id group by ctr.contract_id",countQuery = "select count(*) from contract",nativeQuery = true)
    Page<IContractDto> findAllContract(Pageable pageable);

    @Query(value = "select ctr.contract_id as id,f.id as facilityId,c.id as customerId,e.id as employeeId, f.name as facilityName,e.name as employeeName, c.name as customerName,ctr.start_date as startDate,ctr.end_date as endDate,ctr.deposit as deposit, (ifnull(f.cost, 0)+sum(ifnull(cd.quantity, 0)* ifnull(af.cost, 0))) as total from contract ctr join customer c on c.id = ctr.customer_id left join facility f on ctr.facility_id = f.id left join employee e on ctr.employee_id = e.id left join contract_detail cd on ctr.contract_id = cd.contract_id left join attach_facility af on cd.attach_facility_id = af.attach_facility_id left join customer_type ct on c.customer_type_id = ct.id group by ctr.contract_id",countQuery = "select count(*) from contract",nativeQuery = true)
    List<IContractDto> findAllContract();
}
