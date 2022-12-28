package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(){
        ModelAndView modelAndView = new ModelAndView("/views/shop");
        modelAndView.addObject("products",productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id, @SessionAttribute Cart cart){
        Optional<Product> product = productService.findById(id);
        if(!product.isPresent()){
            return "/views/error.404";
        }
        cart.addProduct(product.get());
        return "redirect:/cart";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable Integer id, Model model){
        Optional<Product> product = productService.findById(id);
        if(!product.isPresent()){
            return "/views/error.404";
        }
        model.addAttribute("product",product.get());
        return "views/detail";
    }
}
