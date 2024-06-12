package com.nagarro.training.notesapi.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nagarro.training.notesapi.dao.RoleDao;
import com.nagarro.training.notesapi.dao.UserDao;
import com.nagarro.training.notesapi.models.Role;
import com.nagarro.training.notesapi.models.User;
import com.nagarro.training.notesapi.services.UserService;
/**
 * Service class implementation for UserService interface to provide utilities to the
 * User Controller
 * @author harshraj01
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	/**
	 * Method to add a new user
	 */
	@Override
	public String registerUser(User user) {
		User tmp = userDao.findByEmail(user.getEmail());
		if(tmp != null) {
			return "Email/User already present...!!";
		}
		
		Set<Role> roles = new HashSet<>();
		Role role = this.roleDao.findById("USER").get();
		roles.add(role);
		user.setRoles(roles);
		
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		this.userDao.save(user);
		
		return "User addedd successfully...!!!";
		
	}
	
	/**
	 * Method to get the current user detail
	 */
	@Override
	public String getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUser = authentication.getName();
		return currentUser;
	}

}
