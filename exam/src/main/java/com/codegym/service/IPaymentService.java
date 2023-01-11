package com.codegym.service;

import com.codegym.model.Payment;

import java.util.List;

public interface IPaymentService {
    List<Payment> findAll();
}
