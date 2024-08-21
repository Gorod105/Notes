package org.example.notes.service;

import org.example.notes.model.Note;
import org.example.notes.repository.NoteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> listAll() {

        return noteRepository.findAll();
    }

    public Long save(String title, String content) {
        Note note = Note.builder()
                .title(title)
                .content(content)
                .build();
        noteRepository.save(note);
        return note.getId();
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);

    }
    @Transactional
    public Note update(Long id, String newTitle, String newContent) {
        try {
            Note note = noteRepository.findById(id).orElseThrow();
            if (!newTitle.isEmpty()){
                note.setTitle(newTitle);
            }
            if (!newContent.isEmpty()){
                note.setContent(newContent);
            }
            noteRepository.save(note);
            return note;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
