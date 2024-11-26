package com.springboot.notetest.repository;

import com.springboot.notetest.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    Note findById(String id);
    Note save(Note note);


}
