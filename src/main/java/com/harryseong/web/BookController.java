package com.harryseong.web;

import com.harryseong.repository.BookRepository;
import com.harryseong.service.BookDBImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.harryseong.domain.Book;

import java.io.IOException;

/**
 * Created by harry on 2/24/17.
 */

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookDBImport bookDBImport;


    @RequestMapping("books")
    public String books(Model model)
    {
        // This model necessary for displaying all books in books template table.
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("book", new Book());
        return "books";
    }

    @PostMapping("books/add")
    public String bookSubmit(@ModelAttribute Book book) {
        try {
            book=bookDBImport.parseBookJson(book, "9780399588174");
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        bookRepository.save(book);
        // Do a redirect to "books"
        return "redirect:/books";
    }

    @GetMapping("books/all")
    @ResponseBody
    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
