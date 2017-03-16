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
public class WebController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/")
    public String index(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "index";
    }
    @RequestMapping("/places")
    public String places()
    {
        return "places";
    }
    @RequestMapping("/family")
    public String family()
    {
        return "family";
    }
    @RequestMapping("/music")
    public String music()
    {
        return "music";
    }
    @RequestMapping("/technology")
    public String technology()
    {
        return "technology";
    }

}
