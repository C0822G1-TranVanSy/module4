package com.codegym.controller;

import com.codegym.exception.EmptyException;
import com.codegym.exception.NotFoundCodeException;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(EmptyException.class)
    public String errorPage(){
        return "views/errorPage";
    }

    @ExceptionHandler({NotFoundCodeException.class,NumberFormatException.class})
    public String errorPage2(){
        return "views/errorPage2";
    }


}
