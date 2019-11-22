package com.unklick.controllers;

import com.unklick.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    private BookRepository bookRepository;
    public void BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @RequestMapping("/books")
    public String getBook(Model model){
        model.addAttribute("book", bookRepository.findAll());
        return "books";
    }



}
