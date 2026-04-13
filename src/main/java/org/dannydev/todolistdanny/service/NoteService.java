package org.dannydev.todolistdanny.service;

import org.dannydev.todolistdanny.model.Note;
import org.dannydev.todolistdanny.model.User;
import org.dannydev.todolistdanny.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public void addNote(Note note){
        noteRepository.save(note);
    }
}
