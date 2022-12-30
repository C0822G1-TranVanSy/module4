package com.codegym.repository.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select c.id, c.name, ct.name, ctr.contract_id, f.name, (ifnull(f.cost, 0)+sum(ifnull(cd.quantity, 0)* ifnull(af.cost, 0))) as total from customer c left join contract ctr on c.id = ctr.customer_id left join facility f on ctr.facility_id = f.id left join contract_detail cd on ctr.contract_id = cd.id left join attach_facility af on cd.attach_facility_id = af.attach_facility_id left join customer_type ct on c.customer_type_id = ct.id group by ctr.contract_id,c.id",nativeQuery = true)
    public List<Contract> findContractBy();
}
