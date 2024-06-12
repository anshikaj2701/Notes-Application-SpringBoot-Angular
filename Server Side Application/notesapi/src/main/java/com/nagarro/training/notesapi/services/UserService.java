package com.nagarro.training.notesapi.services;

import org.springframework.stereotype.Service;

import com.nagarro.training.notesapi.models.User;


public interface UserService {

	String registerUser(User user);

	String getCurrentUser();

}
