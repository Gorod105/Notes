package org.example.notes.model;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_seq")
    @SequenceGenerator(name = "note_seq", sequenceName = "seq_notes_id", allocationSize = 1)
    private Long id;
    private String title;
    private String content;


}
