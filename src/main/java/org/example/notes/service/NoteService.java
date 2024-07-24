package org.example.notes.service;

import org.example.notes.dao.model.Note;
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

        return noteRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void save(Note note) {
        noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);

    }
    @Transactional
    public void update(Long id, String newTitle, String newContent) {
        try {
            Note note = noteRepository.findById(id).orElseThrow();
            if (!newTitle.isEmpty()){
                note.setTitle(newTitle);
            }
            if (!newContent.isEmpty()){
                note.setContent(newContent);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Note getById(long id) {
        return noteRepository.findById(id).orElseThrow();
    }
}
