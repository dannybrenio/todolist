package org.dannydev.todolistdanny.controller;

import jakarta.servlet.http.HttpSession;
import org.dannydev.todolistdanny.model.Note;
import org.dannydev.todolistdanny.model.User;
import org.dannydev.todolistdanny.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/notes")
    public String homePage(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");

        if(user != null){
            Integer userId = user.getID();
            System.out.println("user id:" + userId);
            model.addAttribute("user", user);
            model.addAttribute("userId", userId);
            List<Note> notes = noteService.getNotesByUser(user);
            model.addAttribute("notes", notes);
        }else{
            return "redirect:/login";
        }
        return "notes";
    }

    @GetMapping("/notes/add")
    public String noteAddPage(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        return "noteAdd";
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