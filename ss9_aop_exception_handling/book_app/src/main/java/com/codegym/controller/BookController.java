package com.codegym.controller;

import com.codegym.exception.EmptyException;
import com.codegym.exception.NotFoundCodeException;
import com.codegym.model.Book;
import com.codegym.service.IBookCodeService;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private IBookCodeService bookCodeService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("bookList", bookService.findAll());
        model.addAttribute("bookCodeList", bookCodeService.findAll());
        return "views/list";
    }

    @GetMapping("/borrow/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        Book book = bookService.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));
        model.addAttribute("book", book);
        return "views/detail";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam int id, RedirectAttributes redirectAttributes) throws EmptyException {
        int code = bookService.borrowBook(id);
        redirectAttributes.addFlashAttribute("mess", "Mượn sách thành công, mã sách: " + code);
        return "redirect:/book";
    }

    @PostMapping("/give")
    public String giveBook(@RequestParam int code, RedirectAttributes redirectAttributes) throws NotFoundCodeException {
        bookService.giveBook(code);
        redirectAttributes.addFlashAttribute("mess", "Trả sách có mã số: " + code + " thành công");
        return "redirect:/book";
    }
}
