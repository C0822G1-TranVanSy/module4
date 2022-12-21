package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public String showList(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "views/list";
    }

    @GetMapping("/add")
    public String showAdd(Model model){
        model.addAttribute("blog",new Blog());
        return "views/create";
    }

    @PostMapping("/add")
    public String add(Blog blog){
        blogService.add(blog);
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(Model model, @PathVariable int id){
        model.addAttribute("blog",blogService.findById(id));
        return "views/edit";
    }

    @PostMapping("/edit")
    public String edit(Blog blog){
        blogService.edit(blog);
        return "redirect:";
    }

    @GetMapping("/delete/{id}")
    public String delete( @PathVariable int id){
        blogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "views/view";
    }
}
