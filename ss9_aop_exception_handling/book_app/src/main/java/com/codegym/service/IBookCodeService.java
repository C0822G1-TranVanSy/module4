package com.codegym.service;

import com.codegym.model.BookCode;

import java.util.List;

public interface IBookCodeService {
    List<BookCode> findAll();

    BookCode findByCode(int code);
}
