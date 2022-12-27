package com.codegym.repository;

import com.codegym.model.BookCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IBookCodeRepository extends JpaRepository<BookCode, Integer> {
    @Query(value = "select * from book_code where code = :code",nativeQuery = true)
    BookCode findByCode(int code);
}
