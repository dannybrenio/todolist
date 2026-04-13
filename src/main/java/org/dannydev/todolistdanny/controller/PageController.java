package org.dannydev.todolistdanny.controller;

import jakarta.servlet.http.HttpSession;
import org.dannydev.todolistdanny.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/index")
    public String homePage(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");

        if(user != null){
            Integer userId = user.getID();
            System.out.println("user id:" + userId);
        }else{
            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/registration")
    public String registerPage(){
        return "register";
    }

}