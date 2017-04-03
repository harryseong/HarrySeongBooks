package com.harryseong.web;

import com.harryseong.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harryseong.domain.Book;

/**
 * Created by harry on 2/24/17.
 */

@Controller

@RequestMapping(path="/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("")
    public String books(Model model)
    {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

    @GetMapping(path="/add")
    @ResponseBody
    public String addNewBook(@RequestParam Long bookID,
                             @RequestParam String title,
                             @RequestParam String authorName,
                             @RequestParam int numberOfPages,
                             @RequestParam String isbn13,
                             @RequestParam boolean readStatus)
    {
        Book n=new Book();
        n.setBookID(bookID);
        n.setTitle(title);
        n.setAuthorName(authorName);
        n.setPageCount(numberOfPages);
        n.setIsbn13(isbn13);
        n.setReadStatus(readStatus);
        bookRepository.save(n);
        return "Book Saved";
    }

    @GetMapping(path="/all")
    @ResponseBody
    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
