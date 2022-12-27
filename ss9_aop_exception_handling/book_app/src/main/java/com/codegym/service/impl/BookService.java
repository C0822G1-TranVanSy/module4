package com.codegym.service.impl;

import com.codegym.exception.EmptyException;
import com.codegym.exception.NotFoundCodeException;
import com.codegym.model.Book;
import com.codegym.model.BookCode;
import com.codegym.repository.IBookCodeRepository;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookCodeService;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private IBookCodeRepository bookCodeRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public int borrowBook(int id) throws EmptyException {
        Book book = findById(id).orElseThrow(()-> new IllegalArgumentException("not found"));
        if(book.getQuantity()<=0) {
            throw new EmptyException();
        }
            book.setQuantity(book.getQuantity()-1);
            bookRepository.save(book);
            int code = (int) Math.floor(((Math.random() * 89999) + 10000));
            BookCode bookCode = new BookCode();
            bookCode.setBookId(book.getId());
            bookCode.setCode(code);
            bookCodeRepository.save(bookCode);
        return code;
    }

    @Override
    public void giveBook(int code) throws NotFoundCodeException {
        BookCode bookCode = bookCodeRepository.findByCode(code);
        if(bookCode!=null){
            Book book = bookRepository.findById(bookCode.getBookId()).orElseThrow(()-> new IllegalArgumentException("not found"));
            book.setQuantity(book.getQuantity()+1);
            bookRepository.save(book);
            bookCodeRepository.deleteById(code);
        }else {
            throw new NotFoundCodeException();
        }

    }


}
