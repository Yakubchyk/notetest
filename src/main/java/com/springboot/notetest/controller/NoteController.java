package com.springboot.notetest.controller;


import com.springboot.notetest.entity.Note;
import com.springboot.notetest.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping
    public String note(Model model) {
        List<Note> all = noteRepository.findAll();
        model.addAttribute("notes", all);
        return "note";
    }

    @PostMapping("/add")
    public String add(Note note) {
        noteRepository.save(note);
        return "redirect:/note";
    }

    @PostMapping("/remove")
    public String add(@RequestParam Long id) {
        noteRepository.deleteById(id);
        return "redirect:/note";
    }
}
