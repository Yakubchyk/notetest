package com.springboot.notetest.repository;

import com.springboot.notetest.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
