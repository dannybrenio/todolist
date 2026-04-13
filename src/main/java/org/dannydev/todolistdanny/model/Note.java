package org.dannydev.todolistdanny.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notes")

public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer note_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)//foreign key column
    private User user;

    @Column(name = "note_title")
    private String noteTitle;

    @Column(name = "note_body")
    private String noteBody;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    //getters and setters

    public Integer getNoteId(){
        return note_id;
    }

    public String getNoteTitle(){
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle){
        this.noteTitle = noteTitle;
    }

    public String getNoteBody(){
        return noteBody;
    }

    public void setNoteBody(String noteBody){
        this.noteBody = noteBody;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }
}
