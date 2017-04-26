package com.harryseong.web;

import com.harryseong.HarrySeongApp;
import com.harryseong.repository.BookRepository;
import com.harryseong.service.ImportBookJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class BookController{

    private static final Logger log = LoggerFactory.getLogger(HarrySeongApp.class);

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ImportBookJson importBookJson;

    @GetMapping("books")
    public String Books(Model model)
    {
        // This model necessary for displaying all books in books template table.
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("book", new Book());
        return "books";
    }

    @PostMapping("books/add")
    public String addBook(@ModelAttribute Book book) {
        try {
            book=importBookJson.importBookJson(book, book.getIsbn13());
            bookRepository.save(book);
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        return "redirect:/books";
    }

    @PostMapping ("books/delete")
    public String deleteBook(@RequestParam Long bookID) {
        Book book = bookRepository.findByBookID(bookID);
        bookRepository.delete(book);
        log.info("[BookID: "+ bookID +"] has been deleted.");
        return "redirect:/books";
    }

    @PostMapping ("books/updateReadStatus")
    public String updateReadStatus(@RequestParam Long bookID, @RequestParam boolean readStatus){
        Book book = bookRepository.findByBookID(bookID);
        book.setReadStatus(readStatus);
        bookRepository.save(book);
        log.info("[BookID: "+ bookID +"] 'Read Status' has been updated.");
        return "redirect:/books";
    }
    
    @GetMapping("books/all")
    @ResponseBody
    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("books/one")
    @ResponseBody
    public Book getOneBook(@RequestParam Long bookID){
        return bookRepository.findByBookID(bookID);
    }

}
