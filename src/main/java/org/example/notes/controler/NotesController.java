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

    @PostMapping("/add")
    public ModelAndView showAddPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("action", "add");
        return modelAndView;
    }
    @PostMapping("/add/send")
    public String add(@RequestParam String title, @RequestParam String content) {
        Note newNote = Note.builder()
                .title(title)
                .content(content)
                .build();
        noteService.add(newNote);
        return "redirect:/";
    }
    @PostMapping("/edit")
    public ModelAndView showEditPage(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("action", "edit");
        modelAndView.addObject("noteShow", noteService.getById(id));
        return modelAndView;
    }
    @PostMapping("/edit/send")
    public String edit(@RequestParam Long id , @RequestParam String title, @RequestParam String content) {
        Note note = noteService.getById(id);
        note.setTitle(title);
        note.setContent(content);
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam Long id ) {
        noteService.deleteById(id);
        return "redirect:/";
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
