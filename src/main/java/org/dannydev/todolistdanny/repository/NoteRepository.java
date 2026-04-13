package org.dannydev.todolistdanny.repository;

import org.dannydev.todolistdanny.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.dannydev.todolistdanny.model.Note;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findByUser(User user);

}
