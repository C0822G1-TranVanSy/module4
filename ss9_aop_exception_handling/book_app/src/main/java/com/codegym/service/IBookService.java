package com.codegym.service;

import com.codegym.exception.EmptyException;
import com.codegym.exception.NotFoundCodeException;
import com.codegym.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();

    Optional<Book> findById(int id);

    int borrowBook(int id) throws EmptyException;

    void giveBook(int code) throws NotFoundCodeException;

}
