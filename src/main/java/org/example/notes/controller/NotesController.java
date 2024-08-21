package org.example.notes.controller;

import lombok.RequiredArgsConstructor;
import org.example.notes.model.Note;
import org.example.notes.model.dto.request.NoteAddRequest;
import org.example.notes.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NotesController {

    private final NoteService noteService;

    @PostMapping("/add")
    public Note add(@RequestBody NoteAddRequest request) {

       return noteService.save(request.getTitle(), request.getContent());
    }
    @PutMapping("/edit/{id}")
    public Note edit(@PathVariable Long id ,@RequestBody NoteAddRequest request) {
        return noteService.update(id, request.getTitle(), request.getContent());
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ) {
        noteService.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<Note> findAll() {
        return noteService.listAll();
    }
}
