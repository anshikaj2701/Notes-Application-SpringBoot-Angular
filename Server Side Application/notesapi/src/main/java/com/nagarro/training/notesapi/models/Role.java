package com.nagarro.training.notesapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
				
	@Id
	private String role_name;		//stores the name of a role
	private String description;

	

	//getter method to get the name of a role
	public String getName() {
		return role_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//setter method to set the name of the role
	public void setRoll_Name(String roll_name) {
		this.role_name = roll_name;
	}

}
