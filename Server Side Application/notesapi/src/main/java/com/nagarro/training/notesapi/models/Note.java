package com.nagarro.training.notesapi.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
/**
 * Entity class holds the details of a note
 * @author harshraj01
 *
 */
@Entity
@Table(name="notes")
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		//stores the id of the note
	
	private String title;	//stores the title of the note
	private String content;	//stores the content of the note
	
	@ManyToOne
	@JoinColumn(name="written_by", referencedColumnName="email")
	private User writer;	//stores the details of the writer
	
	private String createdDate;		//stores the note created date
	private String createdTime;		//stores the note created time
	
	
	//method that will automatically set the date and time when Note object is created
	@PrePersist
	public void prePersist() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Date currentDate = new Date();
		this.createdDate = dateFormat.format(currentDate);
		this.createdTime = timeFormat.format(currentDate);
	}
	
	//parameterized constructor
	public Note(String title, String content, User writer) {
		this.title = title;
        this.content = content;
        this.writer = writer;
	}
	
	public Note() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer + ", createdDate="
				+ createdDate + ", createdTime=" + createdTime + "]";
	}
	
	
}
