package com.kenton.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/29 15:49
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public String testException(Exception exception, Model model){
        model.addAttribute("ex",exception);
        return "error";
    }
}
