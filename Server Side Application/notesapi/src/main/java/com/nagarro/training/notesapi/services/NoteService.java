package com.nagarro.training.notesapi.services;

import java.util.List;

import com.nagarro.training.notesapi.models.Note;

public interface NoteService {

	Note addNote(Note note);

	List<Note> getRecentNotes();

	String deleteNoteById(Long id);

	Note getSingleNote(Long id);

}
