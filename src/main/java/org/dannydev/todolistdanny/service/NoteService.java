package org.dannydev.todolistdanny.service;

import org.dannydev.todolistdanny.model.Note;
import org.dannydev.todolistdanny.model.User;
import org.dannydev.todolistdanny.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getNotesByUser(User user){
        return noteRepository.findByUser(user);
    }

    public void addNote(Note note){
        noteRepository.save(note);
    }
}
