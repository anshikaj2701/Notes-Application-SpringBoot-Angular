package com.nagarro.training.notesapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.notesapi.models.Note;
import com.nagarro.training.notesapi.services.NoteService;
/**
 * A REST Controller that handles the requests from the client side	
 * @author harshraj01
 *
 */
@RestController
@RequestMapping("/notes")
public class NoteController {
	
	@Autowired 
	private NoteService noteService;
	
	/**
	 * Handler method to add a new note in the database
	 * @param note
	 * @return note added
	 */
	@PostMapping
	@PreAuthorize("hasRole('USER')")
	public Note addNote(@RequestBody Note note) {
		return this.noteService.addNote(note);
	}
	
	/**
	 * Handler method to return the recent 10 notes of the user
	 * @return List of Note
	 */
	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public List<Note> getRecentNotes(){
		return this.noteService.getRecentNotes();
	}
	
	/**
	 * Handler method to fetch a single note from the database
	 * @param id
	 * @return Note
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public Note getSingleNote(@PathVariable Long id) {
		return this.noteService.getSingleNote(id);
	}
	
	
	/**
	 * Handler method to delete a note based on the id
	 * @param id
	 * @return ResponseEntity
	 */
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<String> deleteNoteById(@PathVariable Long id) {
		String msg = this.noteService.deleteNoteById(id);
		if(msg.equals("Note deleted successfully...!!")) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
