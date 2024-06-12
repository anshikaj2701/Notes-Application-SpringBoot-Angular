package com.nagarro.training.notesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.notesapi.models.JwtRequest;
import com.nagarro.training.notesapi.models.JwtResponse;
import com.nagarro.training.notesapi.services.AuthService;
/**
 * A REST Controller for authentication of the user information
 * @author harshraj01
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/auth")
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		return this.authService.createJwtToken(jwtRequest);
	}

}
