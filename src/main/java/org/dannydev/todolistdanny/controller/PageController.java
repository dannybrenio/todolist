package org.dannydev.todolistdanny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/", "/home"})
    public String homePage(){
        return "redirect:/index.html";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "redirect:/login.html";
    }

    @GetMapping("/registration")
    public String registerPage(){
        return "redirect:/register.html";
    }

}