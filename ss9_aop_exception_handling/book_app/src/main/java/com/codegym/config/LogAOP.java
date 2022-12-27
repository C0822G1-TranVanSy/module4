package com.codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAOP {
    int count =0;
    @Pointcut("execution(* com.codegym.controller.BookController.*Book(..))")
    public void callMethod() {
    }

    @Before("callMethod()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("Bạn đang vào phương thức " + joinPoint.getSignature().getName() + ", time: " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.codegym.controller.BookController.showList(..))")
    public void visitLibrary() {
    }

    @After("visitLibrary()")
    public void afterMethod(JoinPoint joinPoint) {
        count++;
        System.out.println("Bạn đã ghé thăm thư viện " + joinPoint.getSignature().getName() + ", time: " + LocalDateTime.now());
        System.out.println("Số lần ghé thăm lên đến: " + count + " lần");
    }
}