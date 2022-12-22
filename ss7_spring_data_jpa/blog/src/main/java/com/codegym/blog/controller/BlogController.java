package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@RequestMapping("/blog")
@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "views/list";
    }

    @GetMapping("/add")
    public String showAdd(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categoryList",categoryService.findAll());
        return "views/create";
    }

    @PostMapping("/add")
    public String add(Blog blog, RedirectAttributes redirectAttributes){
        boolean check = blogService.add(blog);
        String mess = "Thêm mới thành công";
        if(!check){
            mess = "Đã tồn tài title";
        }
        redirectAttributes.addFlashAttribute("mess",mess);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(Model model, @PathVariable int id){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("categoryList",categoryService.findAll());
        return "views/edit";
    }

    @PostMapping("/edit")
    public String edit(Blog blog, RedirectAttributes redirectAttributes){
        boolean check = blogService.add(blog);
        String mess = "Chỉnh sửa thành công";
        if(!check){
            mess = "Đã tồn tài title";
        }
        redirectAttributes.addFlashAttribute("mess",mess);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete( @PathVariable int id){
        blogService.delete(id);
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id,Model model){
        model.addAttribute("blog",blogService.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found blog")));
        return "views/view";
    }
}
