package org.dannydev.todolistdanny.controller;

import jakarta.servlet.http.HttpSession;
import org.dannydev.todolistdanny.model.User;
import org.dannydev.todolistdanny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(User user, Model model){

        boolean success = userService.register(user);
        if(!success){
            model.addAttribute("error", "Username exists");
            return "register";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session, Model model){

        Optional<User> user = userService.login(username, password);

        if(user.isPresent()){
            session.setAttribute("user", user.get());
            return "redirect:/notes";
        }
        model.addAttribute("error", "Invalid credentials");
        return  "login";
    }
}
