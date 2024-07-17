package org.example.notes.controler;

import lombok.RequiredArgsConstructor;
import org.example.notes.dao.model.Note;
import org.example.notes.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class NotesController {

    private final NoteService noteService;

    @PostMapping("/edit")
    public ModelAndView edit(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("editPage");
//        noteService.deleteById(id);
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam Long id ) {
        ModelAndView modelAndView = new ModelAndView("index");
        noteService.deleteById(id);
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Note> all = noteService.listAll();
        modelAndView.addObject("action", "findAll");
        modelAndView.addObject("notes", all);
        return modelAndView;
    }
}
