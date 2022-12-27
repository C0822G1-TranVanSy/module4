package com.codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAOP {

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

    @AfterThrowing("visitLibrary()")
    public void afterThrowingMethod(JoinPoint joinPoint) {
        System.out.println("Bạn đã ghé thăm thư viện" + joinPoint.getSignature().getName() + ", time: " + LocalDateTime.now());
    }
}