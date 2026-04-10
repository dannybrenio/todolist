package org.dannydev.todolistdanny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.dannydev.todolistdanny.model.User;
import org.dannydev.todolistdanny.service.UserService;
import org.springframework.ui.Model;
@Controller
public class AuthController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public String register(User user, Model model){

        boolean success = userService.register(user);
        if(!success){
            model.addAttribute("error", "Username exists");
            return "redirect:/register.html";
        }

        return "redirect:/login.html";
    }
}
