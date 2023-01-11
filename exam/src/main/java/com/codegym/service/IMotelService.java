package com.codegym.service;

import com.codegym.model.Motel;

import java.util.List;

public interface IMotelService {
    List<Motel> findThree(String name,String phone,int paymentId);

    List<Motel> findTwo(String name,String phone);

    List<Motel> findAll();

    Motel viewDetail(int id);

    void add(Motel motel);

    void deleteById(int id);

    Motel findById(int id);

}
