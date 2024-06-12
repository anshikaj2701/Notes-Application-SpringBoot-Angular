package com.nagarro.training.notesapi.services;

import com.nagarro.training.notesapi.models.JwtRequest;
import com.nagarro.training.notesapi.models.JwtResponse;

public interface AuthService {

	JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception;

}
