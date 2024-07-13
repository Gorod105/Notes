package org.example.notes.service;

import org.example.notes.dao.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    private final List<Note> notes = new ArrayList<>();

    public List<Note> listAll(){
        return notes;
    }
    public Note add(Note note){
        note.setId( notes.getLast().getId()+1);
        notes.add(note);
        return note;
    }
    public void deleteById(long id){
        notes.remove((int) id);
    }
    public void update(Note note){
        try {
            Note oldNote = notes.get(Math.toIntExact(note.getId()));
            oldNote.setTitle(note.getTitle());
            oldNote.setContent(note.getContent());
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
    public Note getById(long id){
        return notes.get((int) id);
    }
}
