package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DictionaryController {
    @RequestMapping("/dictionary")
    public String translate(Model model, String text) {
        String[] englishList = {"apple", "banana", "orange"};
        String[] vietnameseList = {"táo", "chuối", "cam"};
        String result = "Không tìm thấy";
        for (int i = 0; i < englishList.length; i++) {
            if (text.toLowerCase().equals(englishList[i])) {
                result = vietnameseList[i];
                break;
            }
        }
        model.addAttribute("text",text.toLowerCase());
        model.addAttribute("result", result);
        return "/result";
    }
}
