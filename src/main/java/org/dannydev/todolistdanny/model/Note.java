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
    private User user_id;

    @Column(name ="password")
    private String password;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
