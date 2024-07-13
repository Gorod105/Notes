package org.example.notes.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
public class Note {
    private Long id;
    private String title;
    private String content;
}
