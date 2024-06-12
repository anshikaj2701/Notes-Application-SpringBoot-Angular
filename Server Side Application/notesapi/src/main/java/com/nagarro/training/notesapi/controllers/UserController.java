package com.nagarro.training.notesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.notesapi.models.User;
import com.nagarro.training.notesapi.services.UserService;
/**
* REST Controller that contains the handler methods for the user endpoint
* @author harshraj01
*
*/

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * Handler method to register a new user in the database
	 * @param user
	 * @return User
	 */
	@PostMapping("/register")
	public ResponseEntity registerUser(@RequestBody User user) {
		return ResponseEntity.ok().body(this.userService.registerUser(user));
		
	}
	
	@GetMapping("/testUser")
    @PreAuthorize("hasRole('USER')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
	
}
