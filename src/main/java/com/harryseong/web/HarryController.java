package com.harryseong.web;

import com.harryseong.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by harry on 2/20/17.
 */

@Controller
public class HarryController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/")
    public String index(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "index";
    }
    @RequestMapping("/places")
    public String places(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "places";
    }
    @RequestMapping("/family")
    public String family(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "family";
    }
    @RequestMapping("/books")
    public String books(
                        // @RequestParam(value = "bookID", required = false, defaultValue = "0") String bookID,
                        // @RequestParam(value = "title", required = false, defaultValue = "Book Title") String title,
                        // @RequestParam(value = "authorFName", required = false, defaultValue = "John") String authorFName,
                        // @RequestParam(value = "authorMName", required = false, defaultValue = "M") String authorMName,
                        // @RequestParam(value = "authorLName", required = false, defaultValue = "Smith") String authorLName,
                        // @RequestParam(value = "isbn13", required = false, defaultValue = "000-0-00-000000-0") String isbn13,
                        // @RequestParam(value = "readStatus", required = false, defaultValue = "true") String readStatus,
                        Model model)
    {
        model.addAttribute("bookID", bookRepository.findAll());
        //model.addAttribute("title", title);
        //model.addAttribute("authorFName", authorFName);
        //model.addAttribute("authorMName", authorMName);
        //model.addAttribute("authorLName", authorLName);
        //model.addAttribute("isbn13", isbn13);
        //model.addAttribute("readStatus", readStatus);

        return "books";
    }
    @RequestMapping("/music")
    public String music(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "music";
    }
    @RequestMapping("/technology")
    public String technology(@RequestParam(value = "name", required =false, defaultValue = "World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "technology";
    }

}
