package com.harryseong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harryseong.Book;
import com.harryseong.BookRepository;

/**
 * Created by harry on 2/24/17.
 */

@Controller
@RequestMapping(path="/demo")
public class DBController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewBook(@RequestParam int bookID,
                                           @RequestParam String title,
                                           @RequestParam String authorFName,
                                           @RequestParam String authorMName,
                                           @RequestParam String authorLName,
                                           @RequestParam int numberOfPages,
                                           @RequestParam String isbn13,
                                           @RequestParam boolean readStatus){
        Book n=new Book();
        n.setBookID(bookID);
        n.setTitle(title);
        n.setAuthorFName(authorFName);
        n.setAuthorMName(authorMName);
        n.setAuthorLName(authorLName);
        n.setNumberOfPages(numberOfPages);
        n.setIsbn13(isbn13);
        n.setReadStatus(readStatus);
        bookRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
