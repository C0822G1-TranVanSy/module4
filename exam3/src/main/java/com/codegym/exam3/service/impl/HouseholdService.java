package com.codegym.exam3.service.impl;

import com.codegym.exam3.model.Household;
import com.codegym.exam3.repository.IHouseholdRepository;
import com.codegym.exam3.service.IHouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdService implements IHouseholdService {
    @Autowired
    private IHouseholdRepository householdRepository;

    @Override
    public Page<Household> findAll(Pageable pageable) {
        return householdRepository.findAll(pageable);
    }

    @Override
    public Household findById(int id) {
        return householdRepository.findById(id).orElse(null);
    }

    @Override
    public List<String> findMemberNameById(int id) {
        return householdRepository.findMemberNameById(id);
    }

    @Override
    public void update(Household household) {
        householdRepository.save(household);
    }
}
