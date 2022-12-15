package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CalculatorController {

    @GetMapping("/calculator")
    public String getHome() {
        return "/calculator";
    }

    @PostMapping("/calculator")
    public String calculate(Model model,double number1, double number2, String calculate){
        double result = 0;
        String msg = null;
        switch (calculate){
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 == 0d) {
                    msg = "Invalid number2";
                    break;
                }
                result = number1 / number2;
                break;
        }
        model.addAttribute("result",result);
        model.addAttribute("errorMsg", msg);
        model.addAttribute("number2",number2);
     return "/calculator";
    }
}
