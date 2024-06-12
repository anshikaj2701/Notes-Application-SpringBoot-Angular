package com.nagarro.training.notesapi.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.training.notesapi.dao.UserDao;
import com.nagarro.training.notesapi.models.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = this.userDao.findByEmail(username);
		 if(user!=null) {
			 return new org.springframework.security.core.userdetails.User(
					 user.getEmail(), user.getPassword(),getAuthorities(user));
		 }else {
			 throw new UsernameNotFoundException("username is not valid");
		 }
	}
	
	private Set getAuthorities(User user) {
		Set authorities = new HashSet<>();
		
		user.getRoles().forEach(role->{
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
		});
		
		return authorities;
		
	}
	
	
}
