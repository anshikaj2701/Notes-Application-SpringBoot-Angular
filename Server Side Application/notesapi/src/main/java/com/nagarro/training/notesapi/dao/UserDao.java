package com.nagarro.training.notesapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.training.notesapi.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
