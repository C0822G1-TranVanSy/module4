package com.codegym.service.impl;

import com.codegym.model.BookCode;
import com.codegym.repository.IBookCodeRepository;
import com.codegym.service.IBookCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookCodeService implements IBookCodeService {
    @Autowired
    private IBookCodeRepository bookCodeRepository;

    @Override
    public List<BookCode> findAll() {
        return bookCodeRepository.findAll();
    }

    @Override
    public BookCode findByCode(int code) {
        return bookCodeRepository.findByCode(code);
    }

}
