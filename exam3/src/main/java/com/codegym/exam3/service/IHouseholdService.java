package com.codegym.exam3.service;

import com.codegym.exam3.model.Household;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IHouseholdService {
    Page<Household> findAll(Pageable pageable);

    Household findById(int id);

    List<String> findMemberNameById(int id);

    void update(Household household);
}
