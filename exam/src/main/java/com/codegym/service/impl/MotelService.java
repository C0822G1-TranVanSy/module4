package com.codegym.service.impl;

import com.codegym.model.Motel;
import com.codegym.repository.IMotelRepository;
import com.codegym.service.IMotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotelService implements IMotelService {
    @Autowired
    private IMotelRepository motelRepository;

    @Override
    public List<Motel> findThree(String name,String phone,int  paymentId) {
        return motelRepository.findThree(name, phone, paymentId);
    }

    @Override
    public List<Motel> findTwo(String name,String phone) {
        return motelRepository.findTwo(name,phone);
    }

    @Override
    public List<Motel> findAll() {
        return motelRepository.findAll();
    }

    @Override
    public Motel viewDetail(int id) {
        return motelRepository.viewDetail(id);
    }

    @Override
    public void add(Motel motel) {
        motelRepository.save(motel);
    }

    @Override
    public void deleteById(int id) {
        motelRepository.deleteById(id);
    }

    @Override
    public Motel findById(int id) {
        return motelRepository.findById(id).orElse(null);
    }
}
