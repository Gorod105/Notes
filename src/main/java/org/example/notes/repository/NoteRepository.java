package org.example.notes.repository;

import org.example.notes.dao.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Node;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {

}
