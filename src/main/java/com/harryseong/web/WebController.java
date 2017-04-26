package com.harryseong.web;

import com.harryseong.domain.Book;
import com.harryseong.repository.BookRepository;
import com.harryseong.service.ImportBookJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by harry on 2/20/17.
 */

@Controller
public class WebController {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/")
    public String index(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "index";
    }
    @GetMapping("/places")
    public String places()
    {
        return "places";
    }
    @GetMapping("/family")
    public String family()
    {
        return "family";
    }
    @GetMapping("/music")
    public String music()
    {
        return "music";
    }
    @GetMapping("/technology")
    public String technology()
    {
        return "technology";
    }

}
