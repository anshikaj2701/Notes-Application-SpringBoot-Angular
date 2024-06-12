package com.nagarro.training.notesapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.training.notesapi.models.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, String> {


}
