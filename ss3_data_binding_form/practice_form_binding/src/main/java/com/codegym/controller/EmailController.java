package com.codegym.controller;

import com.codegym.model.Email;
import com.codegym.repository.EmailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {

    @Autowired
    EmailRepository emailRepository;

    @GetMapping("")
    public String display(Model model) {
        List<Email> emailList = emailRepository.findAll();
        model.addAttribute("emailList", emailList);
        return "/list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdate(Model model, @PathVariable int id) {
        List<String> languageList = emailRepository.getLanguages();
        List<Integer> pageSizeList = emailRepository.getPageSize();
        model.addAttribute("languageList", languageList);
        model.addAttribute("pageSizeList",pageSizeList);
        List<Email> emailList = emailRepository.findAll();
        model.addAttribute("emailList", emailList);

        model.addAttribute("email",emailRepository.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Email email,@RequestParam int id, Model model, RedirectAttributes redirectAttributes){
        emailRepository.update(email,id);
        redirectAttributes.addFlashAttribute("mess","Đã chỉnh sửa thành công");
        return "redirect:/";
    }
}
