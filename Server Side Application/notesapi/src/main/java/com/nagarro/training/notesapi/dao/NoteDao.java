package com.nagarro.training.notesapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.training.notesapi.models.Note;
import com.nagarro.training.notesapi.models.User;

@Repository
public interface NoteDao extends JpaRepository<Note, Long> {
	
	
	// Query method to find the 10 most recently added notes
    List<Note> findFirst10ByWriterOrderByCreatedDateDescCreatedTimeDesc(User user);
    
    // Query to find email of all the writers in the database
    @Query("SELECT DISTINCT n.writer.email FROM Note n")
    List<String> findAllEmails();
    
    
    //Query to fing the recently added notes from the database
    @Query("SELECT n.id FROM Note n WHERE n.writer.email = :email ORDER BY n.createdDate DESC, n.createdTime DESC")
    List<Long> findRecentlyAddedNoteIds(@Param("email") String email);
    
    
    //Query that will delete the notes based on the email and id
    @Modifying
    @Query("DELETE FROM Note n WHERE n.writer.email = :email AND n.id NOT IN :noteIds")
    void deleteOldNotes(@Param("email") String email, @Param("noteIds") List<Long> noteIds);

}
