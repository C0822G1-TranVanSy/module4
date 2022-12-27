package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BookCode {
    @Id
    private int code;
    private int bookId;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
