package org.dannydev.todolistdanny.controller;

import jakarta.servlet.http.HttpSession;
import org.dannydev.todolistdanny.model.Note;
import org.dannydev.todolistdanny.service.NoteService;
import org.dannydev.todolistdanny.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/add")
    public String addNotes(HttpSession session, Note note){
        User user = (User) session.getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        note.setUser(user);

        System.out.println("USER ID: " + user.getID());
        System.out.println("TITLE: " + note.getNoteTitle());
        System.out.println("BODY: " + note.getNoteBody());
        System.out.println("STATUS: " + note.getStatus());
        noteService.addNote(note);
        return "redirect:/notes";
    }

    @PostMapping("/delete/{noteId}")
    public String deleteNotes(HttpSession session){
        User user = (User) session.getAttribute("user");

        if(user == null){
            return "redirect:/login";
        }
        return "notes";
    }
}
