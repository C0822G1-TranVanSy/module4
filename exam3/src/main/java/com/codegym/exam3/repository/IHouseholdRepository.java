package com.codegym.exam3.repository;

import com.codegym.exam3.model.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IHouseholdRepository extends JpaRepository<Household,Integer> {
    @Query(value = "select member.name from household join member on household.id = member.household_id where household.id = :id",nativeQuery = true)
    List<String> findMemberNameById(@Param("id") int id);
}
