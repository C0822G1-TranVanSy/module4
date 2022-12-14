package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/convert")
public class ConversionController {
//    @RequestMapping("")
    @PostMapping
    public String convert(Model model, @RequestBody double number, String type1, String type2){
        double result = 0;
        if(type1.equals("USD") && type2.equals("VND")){
            result = number*23000;
        }else
        if(type1.equals("VND") && type2.equals("USD")){
            result = number/23000;
        }else {
            result = number;
        }
        model.addAttribute("number",number);
        model.addAttribute("type1",type1);
        model.addAttribute("type2",type2);
        model.addAttribute("result",result);
        return "/result";
    }
}
