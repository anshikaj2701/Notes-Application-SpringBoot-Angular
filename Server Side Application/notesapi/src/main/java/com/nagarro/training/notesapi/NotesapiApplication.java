package com.nagarro.training.notesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling	
public class NotesapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesapiApplication.class, args);
	}

}
