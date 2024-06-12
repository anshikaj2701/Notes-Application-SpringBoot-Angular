package com.nagarro.training.notesapi.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.nagarro.training.notesapi.dao.NoteDao;
import com.nagarro.training.notesapi.dao.UserDao;
import com.nagarro.training.notesapi.models.Note;
import com.nagarro.training.notesapi.models.User;
import com.nagarro.training.notesapi.services.NoteService;
import com.nagarro.training.notesapi.services.UserService;
/**
 * Service class to perform various operations on notes
 * @author harshraj01
 *
 */
@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	
	/**
	 * Creates a new note in the database
	 */
	@Override
	public Note addNote(Note note) {
		String currentUser = this.userService.getCurrentUser();	//fetch the current user's email
		//System.out.println(currentUser);
		User writer = this.userDao.findByEmail(currentUser);
		note.setWriter(writer);
		return this.noteDao.save(note); //save in database
	}
	
	
	/**
	 * Returns a list of recent ten notes from the database based on the writer's credential 
	 */
	@Override
	public List<Note> getRecentNotes(){
		String currentUser = this.userService.getCurrentUser();
		User writer = this.userDao.findByEmail(currentUser);
		return this.noteDao.findFirst10ByWriterOrderByCreatedDateDescCreatedTimeDesc(writer);
	}
	
	/**
	 * Delete's a note based on the id
	 */
	@Override
	public String deleteNoteById(Long id) {
		Optional<Note> note = this.noteDao.findById(id);
		if(note != null) {
			this.noteDao.deleteById(id);
			return "Note deleted successfully...!!";
		}
		//this.noteDao.deleteById(id);
		return "Error deleting the note...!!!";
		
	}
	
	
	/**
	 * Returns a single Note based on the id
	 */
	@Override
	public Note getSingleNote(Long id) {
		return this.noteDao.findById(id).get();
	}
	
	
	/**
	 * Cron Job service that hourly deletes all the old notes except the ten recently
	 * added notes from the database 
	 */
	@Scheduled(fixedRate = 3600000) //a cron job that get's scheduled after every one hour
	@Transactional
	public void hourlyDeleteNotes() {
		System.out.println("deleting old notes has been started in background....");
		List<String> allEmails = this.noteDao.findAllEmails();
		//System.out.println("ALL EMAILS ARE:" +allEmails);
		for(String email: allEmails) {
			List<Long> noteIdsToKeep = this.noteDao.findRecentlyAddedNoteIds(email);
			
			if(noteIdsToKeep.size()>10) {
				noteIdsToKeep = noteIdsToKeep.subList(0,10);
			}
			this.noteDao.deleteOldNotes(email, noteIdsToKeep);
		}
	}
	
}
