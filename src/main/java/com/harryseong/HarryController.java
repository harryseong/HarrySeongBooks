package com.harryseong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by harry on 2/20/17.
 */

@Controller
public class HarryController {
    @RequestMapping("/")
    public String index(@RequestParam(value = "name", required =false, defaultValue = "World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "index";
    }
    @RequestMapping("/places")
    public String places(@RequestParam(value = "name", required =false, defaultValue = "World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "places";
    }
}
