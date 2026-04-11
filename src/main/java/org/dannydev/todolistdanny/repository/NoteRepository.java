package org.dannydev.todolistdanny.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.dannydev.todolistdanny.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

}
