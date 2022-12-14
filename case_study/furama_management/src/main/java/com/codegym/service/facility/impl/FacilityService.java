package com.codegym.service.facility.impl;

import com.codegym.model.facility.Facility;
import com.codegym.repository.facility.IFacilityRepository;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findByNameAndFacilityType(String name, String facilityTypeName, Pageable pageable) {
        return facilityRepository.findByNameAndFacilityType(name,facilityTypeName,pageable);
    }

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public void add(Facility facility) throws Exception {
        for (Facility f:findAll()
             ) {
            if(f.getName().equals(facility.getName())){
                throw new Exception("facility already exists");
            }
        }
        facilityRepository.save(facility);
    }

    @Override
    public void update(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }
}
