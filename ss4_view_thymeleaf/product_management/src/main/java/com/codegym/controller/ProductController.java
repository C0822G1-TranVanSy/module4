package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("")
    public String display(Model model){
        model.addAttribute("productList",productService.selectAll());
        return "/list";
    }

    @GetMapping("/add")
    public String showAdd(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }

    @PostMapping("/add")
    public String addProduct( Product product){
        product.setId(productService.selectAll().get(productService.selectAll().size()-1).getId()+1);
        productService.add(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(Product product, RedirectAttributes redirectAttributes){
        productService.update(product);
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes){
        productService.delete(id);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String showDetail(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/detail";
    }

    @GetMapping("/search")
    public String search(Model model, String name ){
        model.addAttribute("productList",productService.findByName(name));
        return "/list";
    }

}
