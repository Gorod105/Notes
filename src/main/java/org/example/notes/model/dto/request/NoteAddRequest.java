package org.example.notes.model.dto.request;

import lombok.Data;

@Data
public class NoteAddRequest {
    private String title;
    private String content;
}
